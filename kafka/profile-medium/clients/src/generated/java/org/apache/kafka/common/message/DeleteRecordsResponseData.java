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


public class DeleteRecordsResponseData implements ApiMessage {
    private int throttleTimeMs;
    private List<DeleteRecordsTopicResult> topics;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("topics", new ArrayOf(DeleteRecordsTopicResult.SCHEMA_0), "Each topic that we wanted to delete records from.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public DeleteRecordsResponseData(Readable readable, short version) {
        this.topics = new ArrayList<DeleteRecordsTopicResult>();
        read(readable, version);
    }
    
    public DeleteRecordsResponseData(Struct struct, short version) {
        this.topics = new ArrayList<DeleteRecordsTopicResult>();
        fromStruct(struct, version);
    }
    
    public DeleteRecordsResponseData() {
        this.throttleTimeMs = 0;
        this.topics = new ArrayList<DeleteRecordsTopicResult>();
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
        this.throttleTimeMs = readable.readInt();
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topics.clear();
            } else {
                this.topics.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.topics.add(new DeleteRecordsTopicResult(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(throttleTimeMs);
        writable.writeInt(topics.size());
        for (DeleteRecordsTopicResult element : topics) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.throttleTimeMs = struct.getInt("throttle_time_ms");
        {
            Object[] nestedObjects = struct.getArray("topics");
            this.topics = new ArrayList<DeleteRecordsTopicResult>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topics.add(new DeleteRecordsTopicResult((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("throttle_time_ms", this.throttleTimeMs);
        {
            Struct[] nestedObjects = new Struct[topics.size()];
            int i = 0;
            for (DeleteRecordsTopicResult element : this.topics) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("topics", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        size += 4;
        for (DeleteRecordsTopicResult element : topics) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DeleteRecordsResponseData)) return false;
        DeleteRecordsResponseData other = (DeleteRecordsResponseData) obj;
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
        return "DeleteRecordsResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public List<DeleteRecordsTopicResult> topics() {
        return this.topics;
    }
    
    public DeleteRecordsResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public DeleteRecordsResponseData setTopics(List<DeleteRecordsTopicResult> v) {
        this.topics = v;
        return this;
    }
    
    static public class DeleteRecordsTopicResult implements Message {
        private String name;
        private List<DeleteRecordsPartitionResult> partitions;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(DeleteRecordsPartitionResult.SCHEMA_0), "Each partition that we wanted to delete records from.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public DeleteRecordsTopicResult(Readable readable, short version) {
            this.partitions = new ArrayList<DeleteRecordsPartitionResult>();
            read(readable, version);
        }
        
        public DeleteRecordsTopicResult(Struct struct, short version) {
            this.partitions = new ArrayList<DeleteRecordsPartitionResult>();
            fromStruct(struct, version);
        }
        
        public DeleteRecordsTopicResult() {
            this.name = "";
            this.partitions = new ArrayList<DeleteRecordsPartitionResult>();
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
                        this.partitions.add(new DeleteRecordsPartitionResult(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(partitions.size());
            for (DeleteRecordsPartitionResult element : partitions) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partitions");
                this.partitions = new ArrayList<DeleteRecordsPartitionResult>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitions.add(new DeleteRecordsPartitionResult((Struct) nestedObject, version));
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
                for (DeleteRecordsPartitionResult element : this.partitions) {
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
            for (DeleteRecordsPartitionResult element : partitions) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DeleteRecordsTopicResult)) return false;
            DeleteRecordsTopicResult other = (DeleteRecordsTopicResult) obj;
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
            return "DeleteRecordsTopicResult("
                + "name='" + name + "'"
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<DeleteRecordsPartitionResult> partitions() {
            return this.partitions;
        }
        
        public DeleteRecordsTopicResult setName(String v) {
            this.name = v;
            return this;
        }
        
        public DeleteRecordsTopicResult setPartitions(List<DeleteRecordsPartitionResult> v) {
            this.partitions = v;
            return this;
        }
    }
    
    static public class DeleteRecordsPartitionResult implements Message {
        private int partitionIndex;
        private long lowWatermark;
        private short errorCode;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("low_watermark", Type.INT64, "The partition low water mark."),
                new Field("error_code", Type.INT16, "The deletion error code, or 0 if the deletion succeeded.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public DeleteRecordsPartitionResult(Readable readable, short version) {
            read(readable, version);
        }
        
        public DeleteRecordsPartitionResult(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public DeleteRecordsPartitionResult() {
            this.partitionIndex = 0;
            this.lowWatermark = 0L;
            this.errorCode = (short) 0;
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
            this.lowWatermark = readable.readLong();
            this.errorCode = readable.readShort();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionIndex);
            writable.writeLong(lowWatermark);
            writable.writeShort(errorCode);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionIndex = struct.getInt("partition_index");
            this.lowWatermark = struct.getLong("low_watermark");
            this.errorCode = struct.getShort("error_code");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_index", this.partitionIndex);
            struct.set("low_watermark", this.lowWatermark);
            struct.set("error_code", this.errorCode);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            size += 8;
            size += 2;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DeleteRecordsPartitionResult)) return false;
            DeleteRecordsPartitionResult other = (DeleteRecordsPartitionResult) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (lowWatermark != other.lowWatermark) return false;
            if (errorCode != other.errorCode) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + ((int) (lowWatermark >> 32) ^ (int) lowWatermark);
            hashCode = 31 * hashCode + errorCode;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DeleteRecordsPartitionResult("
                + "partitionIndex=" + partitionIndex
                + ", lowWatermark=" + lowWatermark
                + ", errorCode=" + errorCode
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public long lowWatermark() {
            return this.lowWatermark;
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public DeleteRecordsPartitionResult setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public DeleteRecordsPartitionResult setLowWatermark(long v) {
            this.lowWatermark = v;
            return this;
        }
        
        public DeleteRecordsPartitionResult setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
    }
}
