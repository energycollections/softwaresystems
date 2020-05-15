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


public class OffsetCommitResponseData implements ApiMessage {
    private int throttleTimeMs;
    private List<OffsetCommitResponseTopic> topics;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topics", new ArrayOf(OffsetCommitResponseTopic.SCHEMA_0), "The responses for each topic.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema SCHEMA_3 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("topics", new ArrayOf(OffsetCommitResponseTopic.SCHEMA_0), "The responses for each topic.")
        );
    
    public static final Schema SCHEMA_4 = SCHEMA_3;
    
    public static final Schema SCHEMA_5 = SCHEMA_4;
    
    public static final Schema SCHEMA_6 = SCHEMA_5;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3,
        SCHEMA_4,
        SCHEMA_5,
        SCHEMA_6
    };
    
    public OffsetCommitResponseData(Readable readable, short version) {
        this.topics = new ArrayList<OffsetCommitResponseTopic>();
        read(readable, version);
    }
    
    public OffsetCommitResponseData(Struct struct, short version) {
        this.topics = new ArrayList<OffsetCommitResponseTopic>();
        fromStruct(struct, version);
    }
    
    public OffsetCommitResponseData() {
        this.throttleTimeMs = 0;
        this.topics = new ArrayList<OffsetCommitResponseTopic>();
    }
    
    @Override
    public short apiKey() {
        return 8;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 6;
    }
    
    @Override
    public void read(Readable readable, short version) {
        if (version >= 3) {
            this.throttleTimeMs = readable.readInt();
        } else {
            this.throttleTimeMs = 0;
        }
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topics.clear();
            } else {
                this.topics.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.topics.add(new OffsetCommitResponseTopic(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        if (version >= 3) {
            writable.writeInt(throttleTimeMs);
        }
        writable.writeInt(topics.size());
        for (OffsetCommitResponseTopic element : topics) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        if (version >= 3) {
            this.throttleTimeMs = struct.getInt("throttle_time_ms");
        } else {
            this.throttleTimeMs = 0;
        }
        {
            Object[] nestedObjects = struct.getArray("topics");
            this.topics = new ArrayList<OffsetCommitResponseTopic>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topics.add(new OffsetCommitResponseTopic((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        if (version >= 3) {
            struct.set("throttle_time_ms", this.throttleTimeMs);
        }
        {
            Struct[] nestedObjects = new Struct[topics.size()];
            int i = 0;
            for (OffsetCommitResponseTopic element : this.topics) {
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
            size += 4;
        }
        size += 4;
        for (OffsetCommitResponseTopic element : topics) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OffsetCommitResponseData)) return false;
        OffsetCommitResponseData other = (OffsetCommitResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
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
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "OffsetCommitResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public List<OffsetCommitResponseTopic> topics() {
        return this.topics;
    }
    
    public OffsetCommitResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public OffsetCommitResponseData setTopics(List<OffsetCommitResponseTopic> v) {
        this.topics = v;
        return this;
    }
    
    static public class OffsetCommitResponseTopic implements Message {
        private String name;
        private List<OffsetCommitResponsePartition> partitions;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(OffsetCommitResponsePartition.SCHEMA_0), "The responses for each partition in the topic.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5,
            SCHEMA_6
        };
        
        public OffsetCommitResponseTopic(Readable readable, short version) {
            this.partitions = new ArrayList<OffsetCommitResponsePartition>();
            read(readable, version);
        }
        
        public OffsetCommitResponseTopic(Struct struct, short version) {
            this.partitions = new ArrayList<OffsetCommitResponsePartition>();
            fromStruct(struct, version);
        }
        
        public OffsetCommitResponseTopic() {
            this.name = "";
            this.partitions = new ArrayList<OffsetCommitResponsePartition>();
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 6;
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
                        this.partitions.add(new OffsetCommitResponsePartition(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(partitions.size());
            for (OffsetCommitResponsePartition element : partitions) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partitions");
                this.partitions = new ArrayList<OffsetCommitResponsePartition>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitions.add(new OffsetCommitResponsePartition((Struct) nestedObject, version));
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
                for (OffsetCommitResponsePartition element : this.partitions) {
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
            for (OffsetCommitResponsePartition element : partitions) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof OffsetCommitResponseTopic)) return false;
            OffsetCommitResponseTopic other = (OffsetCommitResponseTopic) obj;
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
            return "OffsetCommitResponseTopic("
                + "name='" + name + "'"
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<OffsetCommitResponsePartition> partitions() {
            return this.partitions;
        }
        
        public OffsetCommitResponseTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public OffsetCommitResponseTopic setPartitions(List<OffsetCommitResponsePartition> v) {
            this.partitions = v;
            return this;
        }
    }
    
    static public class OffsetCommitResponsePartition implements Message {
        private int partitionIndex;
        private short errorCode;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no error.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5,
            SCHEMA_6
        };
        
        public OffsetCommitResponsePartition(Readable readable, short version) {
            read(readable, version);
        }
        
        public OffsetCommitResponsePartition(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public OffsetCommitResponsePartition() {
            this.partitionIndex = 0;
            this.errorCode = (short) 0;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 6;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.partitionIndex = readable.readInt();
            this.errorCode = readable.readShort();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionIndex);
            writable.writeShort(errorCode);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionIndex = struct.getInt("partition_index");
            this.errorCode = struct.getShort("error_code");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_index", this.partitionIndex);
            struct.set("error_code", this.errorCode);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            size += 2;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof OffsetCommitResponsePartition)) return false;
            OffsetCommitResponsePartition other = (OffsetCommitResponsePartition) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (errorCode != other.errorCode) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + errorCode;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "OffsetCommitResponsePartition("
                + "partitionIndex=" + partitionIndex
                + ", errorCode=" + errorCode
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public OffsetCommitResponsePartition setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public OffsetCommitResponsePartition setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
    }
}
