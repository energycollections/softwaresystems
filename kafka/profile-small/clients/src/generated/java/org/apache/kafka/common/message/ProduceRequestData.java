/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// THIS CODE IS AUTOMATICALLY GENERATED.  DO NOT EDIT.

package org.apache.kafka.common.message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.ApiMessage;
import org.apache.kafka.common.protocol.Message;
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.ArrayOf;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Struct;
import org.apache.kafka.common.protocol.types.Type;
import org.apache.kafka.common.utils.Bytes;


public class ProduceRequestData implements ApiMessage {
    private String transactionalId;
    private short acks;
    private int timeoutMs;
    private List<TopicProduceData> topics;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("acks", Type.INT16, "The number of acknowledgments the producer requires the leader to have received before considering a request complete. Allowed values: 0 for no acknowledgments, 1 for only the leader and -1 for the full ISR."),
            new Field("timeout_ms", Type.INT32, "The timeout to await a response in miliseconds."),
            new Field("topics", new ArrayOf(TopicProduceData.SCHEMA_0), "Each topic to produce to.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema SCHEMA_3 =
        new Schema(
            new Field("transactional_id", Type.NULLABLE_STRING, "The transactional ID, or null if the producer is not transactional."),
            new Field("acks", Type.INT16, "The number of acknowledgments the producer requires the leader to have received before considering a request complete. Allowed values: 0 for no acknowledgments, 1 for only the leader and -1 for the full ISR."),
            new Field("timeout_ms", Type.INT32, "The timeout to await a response in miliseconds."),
            new Field("topics", new ArrayOf(TopicProduceData.SCHEMA_0), "Each topic to produce to.")
        );
    
    public static final Schema SCHEMA_4 = SCHEMA_3;
    
    public static final Schema SCHEMA_5 = SCHEMA_4;
    
    public static final Schema SCHEMA_6 = SCHEMA_5;
    
    public static final Schema SCHEMA_7 = SCHEMA_6;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3,
        SCHEMA_4,
        SCHEMA_5,
        SCHEMA_6,
        SCHEMA_7
    };
    
    public ProduceRequestData(Readable readable, short version) {
        this.topics = new ArrayList<TopicProduceData>();
        read(readable, version);
    }
    
    public ProduceRequestData(Struct struct, short version) {
        this.topics = new ArrayList<TopicProduceData>();
        fromStruct(struct, version);
    }
    
    public ProduceRequestData() {
        this.transactionalId = "";
        this.acks = (short) 0;
        this.timeoutMs = 0;
        this.topics = new ArrayList<TopicProduceData>();
    }
    
    @Override
    public short apiKey() {
        return 0;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 7;
    }
    
    @Override
    public void read(Readable readable, short version) {
        if (version >= 3) {
            this.transactionalId = readable.readNullableString();
        } else {
            this.transactionalId = "";
        }
        this.acks = readable.readShort();
        this.timeoutMs = readable.readInt();
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topics.clear();
            } else {
                this.topics.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.topics.add(new TopicProduceData(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        if (version >= 3) {
            writable.writeNullableString(transactionalId);
        }
        writable.writeShort(acks);
        writable.writeInt(timeoutMs);
        writable.writeInt(topics.size());
        for (TopicProduceData element : topics) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        if (version >= 3) {
            this.transactionalId = struct.getString("transactional_id");
        } else {
            this.transactionalId = "";
        }
        this.acks = struct.getShort("acks");
        this.timeoutMs = struct.getInt("timeout_ms");
        {
            Object[] nestedObjects = struct.getArray("topics");
            this.topics = new ArrayList<TopicProduceData>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topics.add(new TopicProduceData((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        if (version >= 3) {
            struct.set("transactional_id", this.transactionalId);
        }
        struct.set("acks", this.acks);
        struct.set("timeout_ms", this.timeoutMs);
        {
            Struct[] nestedObjects = new Struct[topics.size()];
            int i = 0;
            for (TopicProduceData element : this.topics) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("topics", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        if (version >= 3) {
            size += 2;
            if (transactionalId != null) {
                size += MessageUtil.serializedUtf8Length(transactionalId);
            }
        } else {
            if (transactionalId.equals("")) {
                throw new UnsupportedVersionException("Attempted to write a non-default transactionalId at version " + version);
            }
        }
        size += 2;
        size += 4;
        size += 4;
        for (TopicProduceData element : topics) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ProduceRequestData)) return false;
        ProduceRequestData other = (ProduceRequestData) obj;
        if (this.transactionalId == null) {
            if (other.transactionalId != null) return false;
        } else {
            if (!this.transactionalId.equals(other.transactionalId)) return false;
        }
        if (acks != other.acks) return false;
        if (timeoutMs != other.timeoutMs) return false;
        if (this.topics == null) {
            if (other.topics != null) return false;
        } else {
            if (!this.topics.equals(other.topics)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (transactionalId == null ? 0 : transactionalId.hashCode());
        hashCode = 31 * hashCode + acks;
        hashCode = 31 * hashCode + timeoutMs;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "ProduceRequestData("
            + "transactionalId='" + transactionalId + "'"
            + ", acks=" + acks
            + ", timeoutMs=" + timeoutMs
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public String transactionalId() {
        return this.transactionalId;
    }
    
    public short acks() {
        return this.acks;
    }
    
    public int timeoutMs() {
        return this.timeoutMs;
    }
    
    public List<TopicProduceData> topics() {
        return this.topics;
    }
    
    public ProduceRequestData setTransactionalId(String v) {
        this.transactionalId = v;
        return this;
    }
    
    public ProduceRequestData setAcks(short v) {
        this.acks = v;
        return this;
    }
    
    public ProduceRequestData setTimeoutMs(int v) {
        this.timeoutMs = v;
        return this;
    }
    
    public ProduceRequestData setTopics(List<TopicProduceData> v) {
        this.topics = v;
        return this;
    }
    
    static public class TopicProduceData implements Message {
        private String name;
        private List<PartitionProduceData> partitions;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(PartitionProduceData.SCHEMA_0), "Each partition to produce to.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5,
            SCHEMA_6,
            SCHEMA_7
        };
        
        public TopicProduceData(Readable readable, short version) {
            this.partitions = new ArrayList<PartitionProduceData>();
            read(readable, version);
        }
        
        public TopicProduceData(Struct struct, short version) {
            this.partitions = new ArrayList<PartitionProduceData>();
            fromStruct(struct, version);
        }
        
        public TopicProduceData() {
            this.name = "";
            this.partitions = new ArrayList<PartitionProduceData>();
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 7;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.name = readable.readNullableString();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.partitions.clear();
                } else {
                    this.partitions.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.partitions.add(new PartitionProduceData(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(partitions.size());
            for (PartitionProduceData element : partitions) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partitions");
                this.partitions = new ArrayList<PartitionProduceData>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitions.add(new PartitionProduceData((Struct) nestedObject, version));
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            {
                Struct[] nestedObjects = new Struct[partitions.size()];
                int i = 0;
                for (PartitionProduceData element : this.partitions) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("partitions", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            size += 4;
            for (PartitionProduceData element : partitions) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof TopicProduceData)) return false;
            TopicProduceData other = (TopicProduceData) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (this.partitions == null) {
                if (other.partitions != null) return false;
            } else {
                if (!this.partitions.equals(other.partitions)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + (partitions == null ? 0 : partitions.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "TopicProduceData("
                + "name='" + name + "'"
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<PartitionProduceData> partitions() {
            return this.partitions;
        }
        
        public TopicProduceData setName(String v) {
            this.name = v;
            return this;
        }
        
        public TopicProduceData setPartitions(List<PartitionProduceData> v) {
            this.partitions = v;
            return this;
        }
    }
    
    static public class PartitionProduceData implements Message {
        private int partitionIndex;
        private byte[] records;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("records", Type.NULLABLE_BYTES, "The record data to be produced.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5,
            SCHEMA_6,
            SCHEMA_7
        };
        
        public PartitionProduceData(Readable readable, short version) {
            read(readable, version);
        }
        
        public PartitionProduceData(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public PartitionProduceData() {
            this.partitionIndex = 0;
            this.records = Bytes.EMPTY;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 7;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.partitionIndex = readable.readInt();
            this.records = readable.readNullableBytes();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionIndex);
            writable.writeNullableBytes(records);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionIndex = struct.getInt("partition_index");
            this.records = struct.getByteArray("records");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_index", this.partitionIndex);
            struct.setByteArray("records", this.records);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            size += 4;
            if (records != null) {
                size += records.length;
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof PartitionProduceData)) return false;
            PartitionProduceData other = (PartitionProduceData) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (!Arrays.equals(this.records, other.records)) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + Arrays.hashCode(records);
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "PartitionProduceData("
                + "partitionIndex=" + partitionIndex
                + ", records=" + Arrays.toString(records)
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public byte[] records() {
            return this.records;
        }
        
        public PartitionProduceData setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public PartitionProduceData setRecords(byte[] v) {
            this.records = v;
            return this;
        }
    }
}
