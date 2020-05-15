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
import java.util.List;
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


public class DeleteRecordsRequestData implements ApiMessage {
    private List<DeleteRecordsTopic> topics;
    private int timeoutMs;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topics", new ArrayOf(DeleteRecordsTopic.SCHEMA_0), "Each topic that we want to delete records from."),
            new Field("timeout_ms", Type.INT32, "How long to wait for the deletion to complete, in milliseconds.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public DeleteRecordsRequestData(Readable readable, short version) {
        this.topics = new ArrayList<DeleteRecordsTopic>();
        read(readable, version);
    }
    
    public DeleteRecordsRequestData(Struct struct, short version) {
        this.topics = new ArrayList<DeleteRecordsTopic>();
        fromStruct(struct, version);
    }
    
    public DeleteRecordsRequestData() {
        this.topics = new ArrayList<DeleteRecordsTopic>();
        this.timeoutMs = 0;
    }
    
    @Override
    public short apiKey() {
        return 21;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 1;
    }
    
    @Override
    public void read(Readable readable, short version) {
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topics.clear();
            } else {
                this.topics.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.topics.add(new DeleteRecordsTopic(readable, version));
                }
            }
        }
        this.timeoutMs = readable.readInt();
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(topics.size());
        for (DeleteRecordsTopic element : topics) {
            element.write(writable, version);
        }
        writable.writeInt(timeoutMs);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        {
            Object[] nestedObjects = struct.getArray("topics");
            this.topics = new ArrayList<DeleteRecordsTopic>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topics.add(new DeleteRecordsTopic((Struct) nestedObject, version));
            }
        }
        this.timeoutMs = struct.getInt("timeout_ms");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        {
            Struct[] nestedObjects = new Struct[topics.size()];
            int i = 0;
            for (DeleteRecordsTopic element : this.topics) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("topics", (Object[]) nestedObjects);
        }
        struct.set("timeout_ms", this.timeoutMs);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        for (DeleteRecordsTopic element : topics) {
            size += element.size(version);
        }
        size += 4;
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DeleteRecordsRequestData)) return false;
        DeleteRecordsRequestData other = (DeleteRecordsRequestData) obj;
        if (this.topics == null) {
            if (other.topics != null) return false;
        } else {
            if (!this.topics.equals(other.topics)) return false;
        }
        if (timeoutMs != other.timeoutMs) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        hashCode = 31 * hashCode + timeoutMs;
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "DeleteRecordsRequestData("
            + "topics=" + MessageUtil.deepToString(topics.iterator())
            + ", timeoutMs=" + timeoutMs
            + ")";
    }
    
    public List<DeleteRecordsTopic> topics() {
        return this.topics;
    }
    
    public int timeoutMs() {
        return this.timeoutMs;
    }
    
    public DeleteRecordsRequestData setTopics(List<DeleteRecordsTopic> v) {
        this.topics = v;
        return this;
    }
    
    public DeleteRecordsRequestData setTimeoutMs(int v) {
        this.timeoutMs = v;
        return this;
    }
    
    static public class DeleteRecordsTopic implements Message {
        private String name;
        private List<DeleteRecordsPartition> partitions;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(DeleteRecordsPartition.SCHEMA_0), "Each partition that we want to delete records from.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public DeleteRecordsTopic(Readable readable, short version) {
            this.partitions = new ArrayList<DeleteRecordsPartition>();
            read(readable, version);
        }
        
        public DeleteRecordsTopic(Struct struct, short version) {
            this.partitions = new ArrayList<DeleteRecordsPartition>();
            fromStruct(struct, version);
        }
        
        public DeleteRecordsTopic() {
            this.name = "";
            this.partitions = new ArrayList<DeleteRecordsPartition>();
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 1;
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
                        this.partitions.add(new DeleteRecordsPartition(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(partitions.size());
            for (DeleteRecordsPartition element : partitions) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partitions");
                this.partitions = new ArrayList<DeleteRecordsPartition>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitions.add(new DeleteRecordsPartition((Struct) nestedObject, version));
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
                for (DeleteRecordsPartition element : this.partitions) {
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
            for (DeleteRecordsPartition element : partitions) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DeleteRecordsTopic)) return false;
            DeleteRecordsTopic other = (DeleteRecordsTopic) obj;
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
            return "DeleteRecordsTopic("
                + "name='" + name + "'"
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<DeleteRecordsPartition> partitions() {
            return this.partitions;
        }
        
        public DeleteRecordsTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public DeleteRecordsTopic setPartitions(List<DeleteRecordsPartition> v) {
            this.partitions = v;
            return this;
        }
    }
    
    static public class DeleteRecordsPartition implements Message {
        private int partitionIndex;
        private long offset;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("offset", Type.INT64, "The deletion offset.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public DeleteRecordsPartition(Readable readable, short version) {
            read(readable, version);
        }
        
        public DeleteRecordsPartition(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public DeleteRecordsPartition() {
            this.partitionIndex = 0;
            this.offset = 0L;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 1;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.partitionIndex = readable.readInt();
            this.offset = readable.readLong();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionIndex);
            writable.writeLong(offset);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionIndex = struct.getInt("partition_index");
            this.offset = struct.getLong("offset");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_index", this.partitionIndex);
            struct.set("offset", this.offset);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            size += 8;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DeleteRecordsPartition)) return false;
            DeleteRecordsPartition other = (DeleteRecordsPartition) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (offset != other.offset) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + ((int) (offset >> 32) ^ (int) offset);
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DeleteRecordsPartition("
                + "partitionIndex=" + partitionIndex
                + ", offset=" + offset
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public long offset() {
            return this.offset;
        }
        
        public DeleteRecordsPartition setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public DeleteRecordsPartition setOffset(long v) {
            this.offset = v;
            return this;
        }
    }
}
