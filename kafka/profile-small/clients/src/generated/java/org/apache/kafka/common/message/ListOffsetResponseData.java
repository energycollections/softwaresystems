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


public class ListOffsetResponseData implements ApiMessage {
    private int throttleTimeMs;
    private List<ListOffsetTopicResponse> topics;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topics", new ArrayOf(ListOffsetTopicResponse.SCHEMA_0), "Each topic in the response.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("topics", new ArrayOf(ListOffsetTopicResponse.SCHEMA_1), "Each topic in the response.")
        );
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("topics", new ArrayOf(ListOffsetTopicResponse.SCHEMA_1), "Each topic in the response.")
        );
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema SCHEMA_4 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("topics", new ArrayOf(ListOffsetTopicResponse.SCHEMA_4), "Each topic in the response.")
        );
    
    public static final Schema SCHEMA_5 = SCHEMA_4;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3,
        SCHEMA_4,
        SCHEMA_5
    };
    
    public ListOffsetResponseData(Readable readable, short version) {
        this.topics = new ArrayList<ListOffsetTopicResponse>();
        read(readable, version);
    }
    
    public ListOffsetResponseData(Struct struct, short version) {
        this.topics = new ArrayList<ListOffsetTopicResponse>();
        fromStruct(struct, version);
    }
    
    public ListOffsetResponseData() {
        this.throttleTimeMs = 0;
        this.topics = new ArrayList<ListOffsetTopicResponse>();
    }
    
    @Override
    public short apiKey() {
        return 2;
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
                    this.topics.add(new ListOffsetTopicResponse(readable, version));
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
        for (ListOffsetTopicResponse element : topics) {
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
            this.topics = new ArrayList<ListOffsetTopicResponse>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topics.add(new ListOffsetTopicResponse((Struct) nestedObject, version));
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
            for (ListOffsetTopicResponse element : this.topics) {
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
        for (ListOffsetTopicResponse element : topics) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ListOffsetResponseData)) return false;
        ListOffsetResponseData other = (ListOffsetResponseData) obj;
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
        return "ListOffsetResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public List<ListOffsetTopicResponse> topics() {
        return this.topics;
    }
    
    public ListOffsetResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public ListOffsetResponseData setTopics(List<ListOffsetTopicResponse> v) {
        this.topics = v;
        return this;
    }
    
    static public class ListOffsetTopicResponse implements Message {
        private String name;
        private List<ListOffsetPartitionResponse> partitions;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name"),
                new Field("partitions", new ArrayOf(ListOffsetPartitionResponse.SCHEMA_0), "Each partition in the response.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("name", Type.STRING, "The topic name"),
                new Field("partitions", new ArrayOf(ListOffsetPartitionResponse.SCHEMA_1), "Each partition in the response.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("name", Type.STRING, "The topic name"),
                new Field("partitions", new ArrayOf(ListOffsetPartitionResponse.SCHEMA_4), "Each partition in the response.")
            );
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5
        };
        
        public ListOffsetTopicResponse(Readable readable, short version) {
            this.partitions = new ArrayList<ListOffsetPartitionResponse>();
            read(readable, version);
        }
        
        public ListOffsetTopicResponse(Struct struct, short version) {
            this.partitions = new ArrayList<ListOffsetPartitionResponse>();
            fromStruct(struct, version);
        }
        
        public ListOffsetTopicResponse() {
            this.name = "";
            this.partitions = new ArrayList<ListOffsetPartitionResponse>();
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
                        this.partitions.add(new ListOffsetPartitionResponse(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(partitions.size());
            for (ListOffsetPartitionResponse element : partitions) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partitions");
                this.partitions = new ArrayList<ListOffsetPartitionResponse>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitions.add(new ListOffsetPartitionResponse((Struct) nestedObject, version));
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
                for (ListOffsetPartitionResponse element : this.partitions) {
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
            for (ListOffsetPartitionResponse element : partitions) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ListOffsetTopicResponse)) return false;
            ListOffsetTopicResponse other = (ListOffsetTopicResponse) obj;
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
            return "ListOffsetTopicResponse("
                + "name='" + name + "'"
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<ListOffsetPartitionResponse> partitions() {
            return this.partitions;
        }
        
        public ListOffsetTopicResponse setName(String v) {
            this.name = v;
            return this;
        }
        
        public ListOffsetTopicResponse setPartitions(List<ListOffsetPartitionResponse> v) {
            this.partitions = v;
            return this;
        }
    }
    
    static public class ListOffsetPartitionResponse implements Message {
        private int partitionIndex;
        private short errorCode;
        private List<Long> oldStyleOffsets;
        private long timestamp;
        private long offset;
        private int leaderEpoch;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The partition error code, or 0 if there was no error."),
                new Field("old_style_offsets", new ArrayOf(Type.INT64), "The result offsets.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The partition error code, or 0 if there was no error."),
                new Field("timestamp", Type.INT64, "The timestamp associated with the returned offset."),
                new Field("offset", Type.INT64, "The returned offset.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The partition error code, or 0 if there was no error."),
                new Field("timestamp", Type.INT64, "The timestamp associated with the returned offset."),
                new Field("offset", Type.INT64, "The returned offset."),
                new Field("leader_epoch", Type.INT32, "")
            );
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5
        };
        
        public ListOffsetPartitionResponse(Readable readable, short version) {
            this.oldStyleOffsets = new ArrayList<Long>();
            read(readable, version);
        }
        
        public ListOffsetPartitionResponse(Struct struct, short version) {
            this.oldStyleOffsets = new ArrayList<Long>();
            fromStruct(struct, version);
        }
        
        public ListOffsetPartitionResponse() {
            this.partitionIndex = 0;
            this.errorCode = (short) 0;
            this.oldStyleOffsets = new ArrayList<Long>();
            this.timestamp = -1L;
            this.offset = -1L;
            this.leaderEpoch = 0;
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
            this.errorCode = readable.readShort();
            if (version <= 0) {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.oldStyleOffsets.clear();
                } else {
                    this.oldStyleOffsets.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.oldStyleOffsets.add(readable.readLong());
                    }
                }
            } else {
                this.oldStyleOffsets = new ArrayList<Long>();
            }
            if (version >= 1) {
                this.timestamp = readable.readLong();
            } else {
                this.timestamp = -1L;
            }
            if (version >= 1) {
                this.offset = readable.readLong();
            } else {
                this.offset = -1L;
            }
            if (version >= 4) {
                this.leaderEpoch = readable.readInt();
            } else {
                this.leaderEpoch = 0;
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionIndex);
            writable.writeShort(errorCode);
            if (version <= 0) {
                writable.writeInt(oldStyleOffsets.size());
                for (Long element : oldStyleOffsets) {
                    writable.writeLong(element);
                }
            }
            if (version >= 1) {
                writable.writeLong(timestamp);
            }
            if (version >= 1) {
                writable.writeLong(offset);
            }
            if (version >= 4) {
                writable.writeInt(leaderEpoch);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionIndex = struct.getInt("partition_index");
            this.errorCode = struct.getShort("error_code");
            if (version <= 0) {
                Object[] nestedObjects = struct.getArray("old_style_offsets");
                this.oldStyleOffsets = new ArrayList<Long>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.oldStyleOffsets.add((Long) nestedObject);
                }
            } else {
                this.oldStyleOffsets = new ArrayList<Long>();
            }
            if (version >= 1) {
                this.timestamp = struct.getLong("timestamp");
            } else {
                this.timestamp = -1L;
            }
            if (version >= 1) {
                this.offset = struct.getLong("offset");
            } else {
                this.offset = -1L;
            }
            if (version >= 4) {
                this.leaderEpoch = struct.getInt("leader_epoch");
            } else {
                this.leaderEpoch = 0;
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_index", this.partitionIndex);
            struct.set("error_code", this.errorCode);
            if (version <= 0) {
                Long[] nestedObjects = new Long[oldStyleOffsets.size()];
                int i = 0;
                for (Long element : this.oldStyleOffsets) {
                    nestedObjects[i++] = element;
                }
                struct.set("old_style_offsets", (Object[]) nestedObjects);
            }
            if (version >= 1) {
                struct.set("timestamp", this.timestamp);
            }
            if (version >= 1) {
                struct.set("offset", this.offset);
            }
            if (version >= 4) {
                struct.set("leader_epoch", this.leaderEpoch);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            size += 2;
            if (version <= 0) {
                size += 4;
                size += oldStyleOffsets.size() * 8;
            } else {
                if (!oldStyleOffsets.isEmpty()) {
                    throw new UnsupportedVersionException("Attempted to write a non-default oldStyleOffsets at version " + version);
                }
            }
            if (version >= 1) {
                size += 8;
            } else {
                if (timestamp != -1L) {
                    throw new UnsupportedVersionException("Attempted to write a non-default timestamp at version " + version);
                }
            }
            if (version >= 1) {
                size += 8;
            } else {
                if (offset != -1L) {
                    throw new UnsupportedVersionException("Attempted to write a non-default offset at version " + version);
                }
            }
            if (version >= 4) {
                size += 4;
            } else {
                if (leaderEpoch != 0) {
                    throw new UnsupportedVersionException("Attempted to write a non-default leaderEpoch at version " + version);
                }
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ListOffsetPartitionResponse)) return false;
            ListOffsetPartitionResponse other = (ListOffsetPartitionResponse) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (errorCode != other.errorCode) return false;
            if (this.oldStyleOffsets == null) {
                if (other.oldStyleOffsets != null) return false;
            } else {
                if (!this.oldStyleOffsets.equals(other.oldStyleOffsets)) return false;
            }
            if (timestamp != other.timestamp) return false;
            if (offset != other.offset) return false;
            if (leaderEpoch != other.leaderEpoch) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + errorCode;
            hashCode = 31 * hashCode + (oldStyleOffsets == null ? 0 : oldStyleOffsets.hashCode());
            hashCode = 31 * hashCode + ((int) (timestamp >> 32) ^ (int) timestamp);
            hashCode = 31 * hashCode + ((int) (offset >> 32) ^ (int) offset);
            hashCode = 31 * hashCode + leaderEpoch;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "ListOffsetPartitionResponse("
                + "partitionIndex=" + partitionIndex
                + ", errorCode=" + errorCode
                + ", oldStyleOffsets=" + MessageUtil.deepToString(oldStyleOffsets.iterator())
                + ", timestamp=" + timestamp
                + ", offset=" + offset
                + ", leaderEpoch=" + leaderEpoch
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public List<Long> oldStyleOffsets() {
            return this.oldStyleOffsets;
        }
        
        public long timestamp() {
            return this.timestamp;
        }
        
        public long offset() {
            return this.offset;
        }
        
        public int leaderEpoch() {
            return this.leaderEpoch;
        }
        
        public ListOffsetPartitionResponse setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public ListOffsetPartitionResponse setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public ListOffsetPartitionResponse setOldStyleOffsets(List<Long> v) {
            this.oldStyleOffsets = v;
            return this;
        }
        
        public ListOffsetPartitionResponse setTimestamp(long v) {
            this.timestamp = v;
            return this;
        }
        
        public ListOffsetPartitionResponse setOffset(long v) {
            this.offset = v;
            return this;
        }
        
        public ListOffsetPartitionResponse setLeaderEpoch(int v) {
            this.leaderEpoch = v;
            return this;
        }
    }
}
