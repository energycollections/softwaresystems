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


public class ListOffsetRequestData implements ApiMessage {
    private int replicaId;
    private byte isolationLevel;
    private List<ListOffsetTopic> topics;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the requestor, or -1 if this request is being made by a normal consumer."),
            new Field("topics", new ArrayOf(ListOffsetTopic.SCHEMA_0), "Each topic in the request.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the requestor, or -1 if this request is being made by a normal consumer."),
            new Field("topics", new ArrayOf(ListOffsetTopic.SCHEMA_1), "Each topic in the request.")
        );
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the requestor, or -1 if this request is being made by a normal consumer."),
            new Field("isolation_level", Type.INT8, "This setting controls the visibility of transactional records. Using READ_UNCOMMITTED (isolation_level = 0) makes all records visible. With READ_COMMITTED (isolation_level = 1), non-transactional and COMMITTED transactional records are visible. To be more concrete, READ_COMMITTED returns all data from offsets smaller than the current LSO (last stable offset), and enables the inclusion of the list of aborted transactions in the result, which allows consumers to discard ABORTED transactional records"),
            new Field("topics", new ArrayOf(ListOffsetTopic.SCHEMA_1), "Each topic in the request.")
        );
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema SCHEMA_4 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the requestor, or -1 if this request is being made by a normal consumer."),
            new Field("isolation_level", Type.INT8, "This setting controls the visibility of transactional records. Using READ_UNCOMMITTED (isolation_level = 0) makes all records visible. With READ_COMMITTED (isolation_level = 1), non-transactional and COMMITTED transactional records are visible. To be more concrete, READ_COMMITTED returns all data from offsets smaller than the current LSO (last stable offset), and enables the inclusion of the list of aborted transactions in the result, which allows consumers to discard ABORTED transactional records"),
            new Field("topics", new ArrayOf(ListOffsetTopic.SCHEMA_4), "Each topic in the request.")
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
    
    public ListOffsetRequestData(Readable readable, short version) {
        this.topics = new ArrayList<ListOffsetTopic>();
        read(readable, version);
    }
    
    public ListOffsetRequestData(Struct struct, short version) {
        this.topics = new ArrayList<ListOffsetTopic>();
        fromStruct(struct, version);
    }
    
    public ListOffsetRequestData() {
        this.replicaId = 0;
        this.isolationLevel = (byte) 0;
        this.topics = new ArrayList<ListOffsetTopic>();
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
        this.replicaId = readable.readInt();
        if (version >= 2) {
            this.isolationLevel = readable.readByte();
        } else {
            this.isolationLevel = (byte) 0;
        }
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topics.clear();
            } else {
                this.topics.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.topics.add(new ListOffsetTopic(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(replicaId);
        if (version >= 2) {
            writable.writeByte(isolationLevel);
        }
        writable.writeInt(topics.size());
        for (ListOffsetTopic element : topics) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.replicaId = struct.getInt("replica_id");
        if (version >= 2) {
            this.isolationLevel = struct.getByte("isolation_level");
        } else {
            this.isolationLevel = (byte) 0;
        }
        {
            Object[] nestedObjects = struct.getArray("topics");
            this.topics = new ArrayList<ListOffsetTopic>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topics.add(new ListOffsetTopic((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("replica_id", this.replicaId);
        if (version >= 2) {
            struct.set("isolation_level", this.isolationLevel);
        }
        {
            Struct[] nestedObjects = new Struct[topics.size()];
            int i = 0;
            for (ListOffsetTopic element : this.topics) {
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
        if (version >= 2) {
            size += 1;
        } else {
            if (isolationLevel != (byte) 0) {
                throw new UnsupportedVersionException("Attempted to write a non-default isolationLevel at version " + version);
            }
        }
        size += 4;
        for (ListOffsetTopic element : topics) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ListOffsetRequestData)) return false;
        ListOffsetRequestData other = (ListOffsetRequestData) obj;
        if (replicaId != other.replicaId) return false;
        if (isolationLevel != other.isolationLevel) return false;
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
        hashCode = 31 * hashCode + replicaId;
        hashCode = 31 * hashCode + isolationLevel;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "ListOffsetRequestData("
            + "replicaId=" + replicaId
            + ", isolationLevel=" + isolationLevel
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public int replicaId() {
        return this.replicaId;
    }
    
    public byte isolationLevel() {
        return this.isolationLevel;
    }
    
    public List<ListOffsetTopic> topics() {
        return this.topics;
    }
    
    public ListOffsetRequestData setReplicaId(int v) {
        this.replicaId = v;
        return this;
    }
    
    public ListOffsetRequestData setIsolationLevel(byte v) {
        this.isolationLevel = v;
        return this;
    }
    
    public ListOffsetRequestData setTopics(List<ListOffsetTopic> v) {
        this.topics = v;
        return this;
    }
    
    static public class ListOffsetTopic implements Message {
        private String name;
        private List<ListOffsetPartition> partitions;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(ListOffsetPartition.SCHEMA_0), "Each partition in the request.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(ListOffsetPartition.SCHEMA_1), "Each partition in the request.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(ListOffsetPartition.SCHEMA_4), "Each partition in the request.")
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
        
        public ListOffsetTopic(Readable readable, short version) {
            this.partitions = new ArrayList<ListOffsetPartition>();
            read(readable, version);
        }
        
        public ListOffsetTopic(Struct struct, short version) {
            this.partitions = new ArrayList<ListOffsetPartition>();
            fromStruct(struct, version);
        }
        
        public ListOffsetTopic() {
            this.name = "";
            this.partitions = new ArrayList<ListOffsetPartition>();
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
                        this.partitions.add(new ListOffsetPartition(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(partitions.size());
            for (ListOffsetPartition element : partitions) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partitions");
                this.partitions = new ArrayList<ListOffsetPartition>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitions.add(new ListOffsetPartition((Struct) nestedObject, version));
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
                for (ListOffsetPartition element : this.partitions) {
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
            for (ListOffsetPartition element : partitions) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ListOffsetTopic)) return false;
            ListOffsetTopic other = (ListOffsetTopic) obj;
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
            return "ListOffsetTopic("
                + "name='" + name + "'"
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<ListOffsetPartition> partitions() {
            return this.partitions;
        }
        
        public ListOffsetTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public ListOffsetTopic setPartitions(List<ListOffsetPartition> v) {
            this.partitions = v;
            return this;
        }
    }
    
    static public class ListOffsetPartition implements Message {
        private int partitionIndex;
        private int currentLeaderEpoch;
        private long timestamp;
        private int maxNumOffsets;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("timestamp", Type.INT64, "The current timestamp."),
                new Field("max_num_offsets", Type.INT32, "The maximum number of offsets to report.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("timestamp", Type.INT64, "The current timestamp.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("current_leader_epoch", Type.INT32, "The current leader epoch."),
                new Field("timestamp", Type.INT64, "The current timestamp.")
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
        
        public ListOffsetPartition(Readable readable, short version) {
            read(readable, version);
        }
        
        public ListOffsetPartition(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public ListOffsetPartition() {
            this.partitionIndex = 0;
            this.currentLeaderEpoch = 0;
            this.timestamp = 0L;
            this.maxNumOffsets = 0;
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
            if (version >= 4) {
                this.currentLeaderEpoch = readable.readInt();
            } else {
                this.currentLeaderEpoch = 0;
            }
            this.timestamp = readable.readLong();
            if (version <= 0) {
                this.maxNumOffsets = readable.readInt();
            } else {
                this.maxNumOffsets = 0;
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionIndex);
            if (version >= 4) {
                writable.writeInt(currentLeaderEpoch);
            }
            writable.writeLong(timestamp);
            if (version <= 0) {
                writable.writeInt(maxNumOffsets);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionIndex = struct.getInt("partition_index");
            if (version >= 4) {
                this.currentLeaderEpoch = struct.getInt("current_leader_epoch");
            } else {
                this.currentLeaderEpoch = 0;
            }
            this.timestamp = struct.getLong("timestamp");
            if (version <= 0) {
                this.maxNumOffsets = struct.getInt("max_num_offsets");
            } else {
                this.maxNumOffsets = 0;
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_index", this.partitionIndex);
            if (version >= 4) {
                struct.set("current_leader_epoch", this.currentLeaderEpoch);
            }
            struct.set("timestamp", this.timestamp);
            if (version <= 0) {
                struct.set("max_num_offsets", this.maxNumOffsets);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            if (version >= 4) {
                size += 4;
            } else {
                if (currentLeaderEpoch != 0) {
                    throw new UnsupportedVersionException("Attempted to write a non-default currentLeaderEpoch at version " + version);
                }
            }
            size += 8;
            if (version <= 0) {
                size += 4;
            } else {
                if (maxNumOffsets != 0) {
                    throw new UnsupportedVersionException("Attempted to write a non-default maxNumOffsets at version " + version);
                }
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ListOffsetPartition)) return false;
            ListOffsetPartition other = (ListOffsetPartition) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (currentLeaderEpoch != other.currentLeaderEpoch) return false;
            if (timestamp != other.timestamp) return false;
            if (maxNumOffsets != other.maxNumOffsets) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + currentLeaderEpoch;
            hashCode = 31 * hashCode + ((int) (timestamp >> 32) ^ (int) timestamp);
            hashCode = 31 * hashCode + maxNumOffsets;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "ListOffsetPartition("
                + "partitionIndex=" + partitionIndex
                + ", currentLeaderEpoch=" + currentLeaderEpoch
                + ", timestamp=" + timestamp
                + ", maxNumOffsets=" + maxNumOffsets
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public int currentLeaderEpoch() {
            return this.currentLeaderEpoch;
        }
        
        public long timestamp() {
            return this.timestamp;
        }
        
        public int maxNumOffsets() {
            return this.maxNumOffsets;
        }
        
        public ListOffsetPartition setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public ListOffsetPartition setCurrentLeaderEpoch(int v) {
            this.currentLeaderEpoch = v;
            return this;
        }
        
        public ListOffsetPartition setTimestamp(long v) {
            this.timestamp = v;
            return this;
        }
        
        public ListOffsetPartition setMaxNumOffsets(int v) {
            this.maxNumOffsets = v;
            return this;
        }
    }
}
