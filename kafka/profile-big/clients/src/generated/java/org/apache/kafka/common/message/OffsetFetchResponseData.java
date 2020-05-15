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


public class OffsetFetchResponseData implements ApiMessage {
    private int throttleTimeMs;
    private List<OffsetFetchResponseTopic> topics;
    private short errorCode;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topics", new ArrayOf(OffsetFetchResponseTopic.SCHEMA_0), "The responses per topic.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("topics", new ArrayOf(OffsetFetchResponseTopic.SCHEMA_0), "The responses per topic."),
            new Field("error_code", Type.INT16, "The top-level error code, or 0 if there was no error.")
        );
    
    public static final Schema SCHEMA_3 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("topics", new ArrayOf(OffsetFetchResponseTopic.SCHEMA_0), "The responses per topic."),
            new Field("error_code", Type.INT16, "The top-level error code, or 0 if there was no error.")
        );
    
    public static final Schema SCHEMA_4 = SCHEMA_3;
    
    public static final Schema SCHEMA_5 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("topics", new ArrayOf(OffsetFetchResponseTopic.SCHEMA_5), "The responses per topic."),
            new Field("error_code", Type.INT16, "The top-level error code, or 0 if there was no error.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3,
        SCHEMA_4,
        SCHEMA_5
    };
    
    public OffsetFetchResponseData(Readable readable, short version) {
        this.topics = new ArrayList<OffsetFetchResponseTopic>();
        read(readable, version);
    }
    
    public OffsetFetchResponseData(Struct struct, short version) {
        this.topics = new ArrayList<OffsetFetchResponseTopic>();
        fromStruct(struct, version);
    }
    
    public OffsetFetchResponseData() {
        this.throttleTimeMs = 0;
        this.topics = new ArrayList<OffsetFetchResponseTopic>();
        this.errorCode = (short) 0;
    }
    
    @Override
    public short apiKey() {
        return 9;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 5;
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
                    this.topics.add(new OffsetFetchResponseTopic(readable, version));
                }
            }
        }
        if (version >= 2) {
            this.errorCode = readable.readShort();
        } else {
            this.errorCode = (short) 0;
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        if (version >= 3) {
            writable.writeInt(throttleTimeMs);
        }
        writable.writeInt(topics.size());
        for (OffsetFetchResponseTopic element : topics) {
            element.write(writable, version);
        }
        if (version >= 2) {
            writable.writeShort(errorCode);
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
            this.topics = new ArrayList<OffsetFetchResponseTopic>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topics.add(new OffsetFetchResponseTopic((Struct) nestedObject, version));
            }
        }
        if (version >= 2) {
            this.errorCode = struct.getShort("error_code");
        } else {
            this.errorCode = (short) 0;
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
            for (OffsetFetchResponseTopic element : this.topics) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("topics", (Object[]) nestedObjects);
        }
        if (version >= 2) {
            struct.set("error_code", this.errorCode);
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
        for (OffsetFetchResponseTopic element : topics) {
            size += element.size(version);
        }
        if (version >= 2) {
            size += 2;
        } else {
            if (errorCode != (short) 0) {
                throw new UnsupportedVersionException("Attempted to write a non-default errorCode at version " + version);
            }
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OffsetFetchResponseData)) return false;
        OffsetFetchResponseData other = (OffsetFetchResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (this.topics == null) {
            if (other.topics != null) return false;
        } else {
            if (!this.topics.equals(other.topics)) return false;
        }
        if (errorCode != other.errorCode) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        hashCode = 31 * hashCode + errorCode;
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "OffsetFetchResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ", errorCode=" + errorCode
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public List<OffsetFetchResponseTopic> topics() {
        return this.topics;
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public OffsetFetchResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public OffsetFetchResponseData setTopics(List<OffsetFetchResponseTopic> v) {
        this.topics = v;
        return this;
    }
    
    public OffsetFetchResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    static public class OffsetFetchResponseTopic implements Message {
        private String name;
        private List<OffsetFetchResponsePartition> partitions;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(OffsetFetchResponsePartition.SCHEMA_0), "The responses per partition")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(OffsetFetchResponsePartition.SCHEMA_5), "The responses per partition")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5
        };
        
        public OffsetFetchResponseTopic(Readable readable, short version) {
            this.partitions = new ArrayList<OffsetFetchResponsePartition>();
            read(readable, version);
        }
        
        public OffsetFetchResponseTopic(Struct struct, short version) {
            this.partitions = new ArrayList<OffsetFetchResponsePartition>();
            fromStruct(struct, version);
        }
        
        public OffsetFetchResponseTopic() {
            this.name = "";
            this.partitions = new ArrayList<OffsetFetchResponsePartition>();
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 5;
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
                        this.partitions.add(new OffsetFetchResponsePartition(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(partitions.size());
            for (OffsetFetchResponsePartition element : partitions) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partitions");
                this.partitions = new ArrayList<OffsetFetchResponsePartition>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitions.add(new OffsetFetchResponsePartition((Struct) nestedObject, version));
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
                for (OffsetFetchResponsePartition element : this.partitions) {
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
            for (OffsetFetchResponsePartition element : partitions) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof OffsetFetchResponseTopic)) return false;
            OffsetFetchResponseTopic other = (OffsetFetchResponseTopic) obj;
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
            return "OffsetFetchResponseTopic("
                + "name='" + name + "'"
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<OffsetFetchResponsePartition> partitions() {
            return this.partitions;
        }
        
        public OffsetFetchResponseTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public OffsetFetchResponseTopic setPartitions(List<OffsetFetchResponsePartition> v) {
            this.partitions = v;
            return this;
        }
    }
    
    static public class OffsetFetchResponsePartition implements Message {
        private int partitionIndex;
        private long committedOffset;
        private int committedLeaderEpoch;
        private String metadata;
        private short errorCode;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("committed_offset", Type.INT64, "The committed message offset."),
                new Field("metadata", Type.NULLABLE_STRING, "The partition metadata."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no error.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("committed_offset", Type.INT64, "The committed message offset."),
                new Field("committed_leader_epoch", Type.INT32, "The leader epoch."),
                new Field("metadata", Type.NULLABLE_STRING, "The partition metadata."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no error.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5
        };
        
        public OffsetFetchResponsePartition(Readable readable, short version) {
            read(readable, version);
        }
        
        public OffsetFetchResponsePartition(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public OffsetFetchResponsePartition() {
            this.partitionIndex = 0;
            this.committedOffset = 0L;
            this.committedLeaderEpoch = 0;
            this.metadata = "";
            this.errorCode = (short) 0;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 5;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.partitionIndex = readable.readInt();
            this.committedOffset = readable.readLong();
            if (version >= 5) {
                this.committedLeaderEpoch = readable.readInt();
            } else {
                this.committedLeaderEpoch = 0;
            }
            this.metadata = readable.readNullableString();
            this.errorCode = readable.readShort();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionIndex);
            writable.writeLong(committedOffset);
            if (version >= 5) {
                writable.writeInt(committedLeaderEpoch);
            }
            writable.writeNullableString(metadata);
            writable.writeShort(errorCode);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionIndex = struct.getInt("partition_index");
            this.committedOffset = struct.getLong("committed_offset");
            if (version >= 5) {
                this.committedLeaderEpoch = struct.getInt("committed_leader_epoch");
            } else {
                this.committedLeaderEpoch = 0;
            }
            this.metadata = struct.getString("metadata");
            this.errorCode = struct.getShort("error_code");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_index", this.partitionIndex);
            struct.set("committed_offset", this.committedOffset);
            if (version >= 5) {
                struct.set("committed_leader_epoch", this.committedLeaderEpoch);
            }
            struct.set("metadata", this.metadata);
            struct.set("error_code", this.errorCode);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            size += 8;
            if (version >= 5) {
                size += 4;
            } else {
                if (committedLeaderEpoch != 0) {
                    throw new UnsupportedVersionException("Attempted to write a non-default committedLeaderEpoch at version " + version);
                }
            }
            size += 2;
            if (metadata != null) {
                size += MessageUtil.serializedUtf8Length(metadata);
            }
            size += 2;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof OffsetFetchResponsePartition)) return false;
            OffsetFetchResponsePartition other = (OffsetFetchResponsePartition) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (committedOffset != other.committedOffset) return false;
            if (committedLeaderEpoch != other.committedLeaderEpoch) return false;
            if (this.metadata == null) {
                if (other.metadata != null) return false;
            } else {
                if (!this.metadata.equals(other.metadata)) return false;
            }
            if (errorCode != other.errorCode) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + ((int) (committedOffset >> 32) ^ (int) committedOffset);
            hashCode = 31 * hashCode + committedLeaderEpoch;
            hashCode = 31 * hashCode + (metadata == null ? 0 : metadata.hashCode());
            hashCode = 31 * hashCode + errorCode;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "OffsetFetchResponsePartition("
                + "partitionIndex=" + partitionIndex
                + ", committedOffset=" + committedOffset
                + ", committedLeaderEpoch=" + committedLeaderEpoch
                + ", metadata='" + metadata + "'"
                + ", errorCode=" + errorCode
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public long committedOffset() {
            return this.committedOffset;
        }
        
        public int committedLeaderEpoch() {
            return this.committedLeaderEpoch;
        }
        
        public String metadata() {
            return this.metadata;
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public OffsetFetchResponsePartition setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public OffsetFetchResponsePartition setCommittedOffset(long v) {
            this.committedOffset = v;
            return this;
        }
        
        public OffsetFetchResponsePartition setCommittedLeaderEpoch(int v) {
            this.committedLeaderEpoch = v;
            return this;
        }
        
        public OffsetFetchResponsePartition setMetadata(String v) {
            this.metadata = v;
            return this;
        }
        
        public OffsetFetchResponsePartition setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
    }
}
