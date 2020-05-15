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


public class OffsetForLeaderEpochRequestData implements ApiMessage {
    private List<OffsetForLeaderTopic> topics;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topics", new ArrayOf(OffsetForLeaderTopic.SCHEMA_0), "Each topic to get offsets for.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("topics", new ArrayOf(OffsetForLeaderTopic.SCHEMA_2), "Each topic to get offsets for.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2
    };
    
    public OffsetForLeaderEpochRequestData(Readable readable, short version) {
        this.topics = new ArrayList<OffsetForLeaderTopic>();
        read(readable, version);
    }
    
    public OffsetForLeaderEpochRequestData(Struct struct, short version) {
        this.topics = new ArrayList<OffsetForLeaderTopic>();
        fromStruct(struct, version);
    }
    
    public OffsetForLeaderEpochRequestData() {
        this.topics = new ArrayList<OffsetForLeaderTopic>();
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
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topics.clear();
            } else {
                this.topics.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.topics.add(new OffsetForLeaderTopic(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(topics.size());
        for (OffsetForLeaderTopic element : topics) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        {
            Object[] nestedObjects = struct.getArray("topics");
            this.topics = new ArrayList<OffsetForLeaderTopic>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topics.add(new OffsetForLeaderTopic((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        {
            Struct[] nestedObjects = new Struct[topics.size()];
            int i = 0;
            for (OffsetForLeaderTopic element : this.topics) {
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
        for (OffsetForLeaderTopic element : topics) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OffsetForLeaderEpochRequestData)) return false;
        OffsetForLeaderEpochRequestData other = (OffsetForLeaderEpochRequestData) obj;
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
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "OffsetForLeaderEpochRequestData("
            + "topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public List<OffsetForLeaderTopic> topics() {
        return this.topics;
    }
    
    public OffsetForLeaderEpochRequestData setTopics(List<OffsetForLeaderTopic> v) {
        this.topics = v;
        return this;
    }
    
    static public class OffsetForLeaderTopic implements Message {
        private String name;
        private List<OffsetForLeaderPartition> partitions;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(OffsetForLeaderPartition.SCHEMA_0), "Each partition to get offsets for.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(OffsetForLeaderPartition.SCHEMA_2), "Each partition to get offsets for.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public OffsetForLeaderTopic(Readable readable, short version) {
            this.partitions = new ArrayList<OffsetForLeaderPartition>();
            read(readable, version);
        }
        
        public OffsetForLeaderTopic(Struct struct, short version) {
            this.partitions = new ArrayList<OffsetForLeaderPartition>();
            fromStruct(struct, version);
        }
        
        public OffsetForLeaderTopic() {
            this.name = "";
            this.partitions = new ArrayList<OffsetForLeaderPartition>();
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
                        this.partitions.add(new OffsetForLeaderPartition(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(partitions.size());
            for (OffsetForLeaderPartition element : partitions) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partitions");
                this.partitions = new ArrayList<OffsetForLeaderPartition>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitions.add(new OffsetForLeaderPartition((Struct) nestedObject, version));
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
                for (OffsetForLeaderPartition element : this.partitions) {
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
            for (OffsetForLeaderPartition element : partitions) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof OffsetForLeaderTopic)) return false;
            OffsetForLeaderTopic other = (OffsetForLeaderTopic) obj;
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
            return "OffsetForLeaderTopic("
                + "name='" + name + "'"
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<OffsetForLeaderPartition> partitions() {
            return this.partitions;
        }
        
        public OffsetForLeaderTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public OffsetForLeaderTopic setPartitions(List<OffsetForLeaderPartition> v) {
            this.partitions = v;
            return this;
        }
    }
    
    static public class OffsetForLeaderPartition implements Message {
        private int partitionIndex;
        private int currentLeaderEpoch;
        private int leaderEpoch;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("leader_epoch", Type.INT32, "The epoch to look up an offset for.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("current_leader_epoch", Type.INT32, "An epoch used to fence consumers/replicas with old metadata.  If the epoch provided by the client is larger than the current epoch known to the broker, then the UNKNOWN_LEADER_EPOCH error code will be returned. If the provided epoch is smaller, then the FENCED_LEADER_EPOCH error code will be returned."),
                new Field("leader_epoch", Type.INT32, "The epoch to look up an offset for.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public OffsetForLeaderPartition(Readable readable, short version) {
            read(readable, version);
        }
        
        public OffsetForLeaderPartition(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public OffsetForLeaderPartition() {
            this.partitionIndex = 0;
            this.currentLeaderEpoch = -1;
            this.leaderEpoch = 0;
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
            this.partitionIndex = readable.readInt();
            if (version >= 2) {
                this.currentLeaderEpoch = readable.readInt();
            } else {
                this.currentLeaderEpoch = -1;
            }
            this.leaderEpoch = readable.readInt();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionIndex);
            if (version >= 2) {
                writable.writeInt(currentLeaderEpoch);
            }
            writable.writeInt(leaderEpoch);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionIndex = struct.getInt("partition_index");
            if (version >= 2) {
                this.currentLeaderEpoch = struct.getInt("current_leader_epoch");
            } else {
                this.currentLeaderEpoch = -1;
            }
            this.leaderEpoch = struct.getInt("leader_epoch");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_index", this.partitionIndex);
            if (version >= 2) {
                struct.set("current_leader_epoch", this.currentLeaderEpoch);
            }
            struct.set("leader_epoch", this.leaderEpoch);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            if (version >= 2) {
                size += 4;
            }
            size += 4;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof OffsetForLeaderPartition)) return false;
            OffsetForLeaderPartition other = (OffsetForLeaderPartition) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (currentLeaderEpoch != other.currentLeaderEpoch) return false;
            if (leaderEpoch != other.leaderEpoch) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + currentLeaderEpoch;
            hashCode = 31 * hashCode + leaderEpoch;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "OffsetForLeaderPartition("
                + "partitionIndex=" + partitionIndex
                + ", currentLeaderEpoch=" + currentLeaderEpoch
                + ", leaderEpoch=" + leaderEpoch
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public int currentLeaderEpoch() {
            return this.currentLeaderEpoch;
        }
        
        public int leaderEpoch() {
            return this.leaderEpoch;
        }
        
        public OffsetForLeaderPartition setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public OffsetForLeaderPartition setCurrentLeaderEpoch(int v) {
            this.currentLeaderEpoch = v;
            return this;
        }
        
        public OffsetForLeaderPartition setLeaderEpoch(int v) {
            this.leaderEpoch = v;
            return this;
        }
    }
}
