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


public class OffsetForLeaderEpochResponseData implements ApiMessage {
    private int throttleTimeMs;
    private List<OffsetForLeaderTopicResult> topics;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topics", new ArrayOf(OffsetForLeaderTopicResult.SCHEMA_0), "Each topic we fetched offsets for.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("topics", new ArrayOf(OffsetForLeaderTopicResult.SCHEMA_1), "Each topic we fetched offsets for.")
        );
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("topics", new ArrayOf(OffsetForLeaderTopicResult.SCHEMA_1), "Each topic we fetched offsets for.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2
    };
    
    public OffsetForLeaderEpochResponseData(Readable readable, short version) {
        this.topics = new ArrayList<OffsetForLeaderTopicResult>();
        read(readable, version);
    }
    
    public OffsetForLeaderEpochResponseData(Struct struct, short version) {
        this.topics = new ArrayList<OffsetForLeaderTopicResult>();
        fromStruct(struct, version);
    }
    
    public OffsetForLeaderEpochResponseData() {
        this.throttleTimeMs = 0;
        this.topics = new ArrayList<OffsetForLeaderTopicResult>();
    }
    
    @Override
    public short apiKey() {
        return 23;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 2;
    }
    
    @Override
    public void read(Readable readable, short version) {
        if (version >= 2) {
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
                    this.topics.add(new OffsetForLeaderTopicResult(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        if (version >= 2) {
            writable.writeInt(throttleTimeMs);
        }
        writable.writeInt(topics.size());
        for (OffsetForLeaderTopicResult element : topics) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        if (version >= 2) {
            this.throttleTimeMs = struct.getInt("throttle_time_ms");
        } else {
            this.throttleTimeMs = 0;
        }
        {
            Object[] nestedObjects = struct.getArray("topics");
            this.topics = new ArrayList<OffsetForLeaderTopicResult>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topics.add(new OffsetForLeaderTopicResult((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        if (version >= 2) {
            struct.set("throttle_time_ms", this.throttleTimeMs);
        }
        {
            Struct[] nestedObjects = new Struct[topics.size()];
            int i = 0;
            for (OffsetForLeaderTopicResult element : this.topics) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("topics", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        if (version >= 2) {
            size += 4;
        }
        size += 4;
        for (OffsetForLeaderTopicResult element : topics) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OffsetForLeaderEpochResponseData)) return false;
        OffsetForLeaderEpochResponseData other = (OffsetForLeaderEpochResponseData) obj;
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
        return "OffsetForLeaderEpochResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public List<OffsetForLeaderTopicResult> topics() {
        return this.topics;
    }
    
    public OffsetForLeaderEpochResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public OffsetForLeaderEpochResponseData setTopics(List<OffsetForLeaderTopicResult> v) {
        this.topics = v;
        return this;
    }
    
    static public class OffsetForLeaderTopicResult implements Message {
        private String name;
        private List<OffsetForLeaderPartitionResult> partitions;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(OffsetForLeaderPartitionResult.SCHEMA_0), "Each partition in the topic we fetched offsets for.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(OffsetForLeaderPartitionResult.SCHEMA_1), "Each partition in the topic we fetched offsets for.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public OffsetForLeaderTopicResult(Readable readable, short version) {
            this.partitions = new ArrayList<OffsetForLeaderPartitionResult>();
            read(readable, version);
        }
        
        public OffsetForLeaderTopicResult(Struct struct, short version) {
            this.partitions = new ArrayList<OffsetForLeaderPartitionResult>();
            fromStruct(struct, version);
        }
        
        public OffsetForLeaderTopicResult() {
            this.name = "";
            this.partitions = new ArrayList<OffsetForLeaderPartitionResult>();
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 2;
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
                        this.partitions.add(new OffsetForLeaderPartitionResult(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(partitions.size());
            for (OffsetForLeaderPartitionResult element : partitions) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partitions");
                this.partitions = new ArrayList<OffsetForLeaderPartitionResult>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitions.add(new OffsetForLeaderPartitionResult((Struct) nestedObject, version));
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
                for (OffsetForLeaderPartitionResult element : this.partitions) {
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
            for (OffsetForLeaderPartitionResult element : partitions) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof OffsetForLeaderTopicResult)) return false;
            OffsetForLeaderTopicResult other = (OffsetForLeaderTopicResult) obj;
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
            return "OffsetForLeaderTopicResult("
                + "name='" + name + "'"
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<OffsetForLeaderPartitionResult> partitions() {
            return this.partitions;
        }
        
        public OffsetForLeaderTopicResult setName(String v) {
            this.name = v;
            return this;
        }
        
        public OffsetForLeaderTopicResult setPartitions(List<OffsetForLeaderPartitionResult> v) {
            this.partitions = v;
            return this;
        }
    }
    
    static public class OffsetForLeaderPartitionResult implements Message {
        private short errorCode;
        private int partitionIndex;
        private int leaderEpoch;
        private long endOffset;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("error_code", Type.INT16, "The error code 0, or if there was no error."),
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("end_offset", Type.INT64, "The end offset of the epoch.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("error_code", Type.INT16, "The error code 0, or if there was no error."),
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("leader_epoch", Type.INT32, "The leader epoch of the partition."),
                new Field("end_offset", Type.INT64, "The end offset of the epoch.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public OffsetForLeaderPartitionResult(Readable readable, short version) {
            read(readable, version);
        }
        
        public OffsetForLeaderPartitionResult(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public OffsetForLeaderPartitionResult() {
            this.errorCode = (short) 0;
            this.partitionIndex = 0;
            this.leaderEpoch = -1;
            this.endOffset = 0L;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 2;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.errorCode = readable.readShort();
            this.partitionIndex = readable.readInt();
            if (version >= 1) {
                this.leaderEpoch = readable.readInt();
            } else {
                this.leaderEpoch = -1;
            }
            this.endOffset = readable.readLong();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeShort(errorCode);
            writable.writeInt(partitionIndex);
            if (version >= 1) {
                writable.writeInt(leaderEpoch);
            }
            writable.writeLong(endOffset);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.errorCode = struct.getShort("error_code");
            this.partitionIndex = struct.getInt("partition_index");
            if (version >= 1) {
                this.leaderEpoch = struct.getInt("leader_epoch");
            } else {
                this.leaderEpoch = -1;
            }
            this.endOffset = struct.getLong("end_offset");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("error_code", this.errorCode);
            struct.set("partition_index", this.partitionIndex);
            if (version >= 1) {
                struct.set("leader_epoch", this.leaderEpoch);
            }
            struct.set("end_offset", this.endOffset);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += 4;
            if (version >= 1) {
                size += 4;
            }
            size += 8;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof OffsetForLeaderPartitionResult)) return false;
            OffsetForLeaderPartitionResult other = (OffsetForLeaderPartitionResult) obj;
            if (errorCode != other.errorCode) return false;
            if (partitionIndex != other.partitionIndex) return false;
            if (leaderEpoch != other.leaderEpoch) return false;
            if (endOffset != other.endOffset) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + errorCode;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + leaderEpoch;
            hashCode = 31 * hashCode + ((int) (endOffset >> 32) ^ (int) endOffset);
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "OffsetForLeaderPartitionResult("
                + "errorCode=" + errorCode
                + ", partitionIndex=" + partitionIndex
                + ", leaderEpoch=" + leaderEpoch
                + ", endOffset=" + endOffset
                + ")";
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public int leaderEpoch() {
            return this.leaderEpoch;
        }
        
        public long endOffset() {
            return this.endOffset;
        }
        
        public OffsetForLeaderPartitionResult setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public OffsetForLeaderPartitionResult setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public OffsetForLeaderPartitionResult setLeaderEpoch(int v) {
            this.leaderEpoch = v;
            return this;
        }
        
        public OffsetForLeaderPartitionResult setEndOffset(long v) {
            this.endOffset = v;
            return this;
        }
    }
}
