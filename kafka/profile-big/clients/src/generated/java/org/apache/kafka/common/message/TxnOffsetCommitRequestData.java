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


public class TxnOffsetCommitRequestData implements ApiMessage {
    private String transactionalId;
    private String groupId;
    private long producerId;
    private short producerEpoch;
    private List<TxnOffsetCommitRequestTopic> topics;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("transactional_id", Type.STRING, "The ID of the transaction."),
            new Field("group_id", Type.STRING, "The ID of the group."),
            new Field("producer_id", Type.INT64, "The current producer ID in use by the transactional ID."),
            new Field("producer_epoch", Type.INT16, "The current epoch associated with the producer ID."),
            new Field("topics", new ArrayOf(TxnOffsetCommitRequestTopic.SCHEMA_0), "Each topic that we want to committ offsets for.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("transactional_id", Type.STRING, "The ID of the transaction."),
            new Field("group_id", Type.STRING, "The ID of the group."),
            new Field("producer_id", Type.INT64, "The current producer ID in use by the transactional ID."),
            new Field("producer_epoch", Type.INT16, "The current epoch associated with the producer ID."),
            new Field("topics", new ArrayOf(TxnOffsetCommitRequestTopic.SCHEMA_2), "Each topic that we want to committ offsets for.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2
    };
    
    public TxnOffsetCommitRequestData(Readable readable, short version) {
        this.topics = new ArrayList<TxnOffsetCommitRequestTopic>();
        read(readable, version);
    }
    
    public TxnOffsetCommitRequestData(Struct struct, short version) {
        this.topics = new ArrayList<TxnOffsetCommitRequestTopic>();
        fromStruct(struct, version);
    }
    
    public TxnOffsetCommitRequestData() {
        this.transactionalId = "";
        this.groupId = "";
        this.producerId = 0L;
        this.producerEpoch = (short) 0;
        this.topics = new ArrayList<TxnOffsetCommitRequestTopic>();
    }
    
    @Override
    public short apiKey() {
        return 28;
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
        this.transactionalId = readable.readNullableString();
        this.groupId = readable.readNullableString();
        this.producerId = readable.readLong();
        this.producerEpoch = readable.readShort();
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topics.clear();
            } else {
                this.topics.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.topics.add(new TxnOffsetCommitRequestTopic(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeString(transactionalId);
        writable.writeString(groupId);
        writable.writeLong(producerId);
        writable.writeShort(producerEpoch);
        writable.writeInt(topics.size());
        for (TxnOffsetCommitRequestTopic element : topics) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.transactionalId = struct.getString("transactional_id");
        this.groupId = struct.getString("group_id");
        this.producerId = struct.getLong("producer_id");
        this.producerEpoch = struct.getShort("producer_epoch");
        {
            Object[] nestedObjects = struct.getArray("topics");
            this.topics = new ArrayList<TxnOffsetCommitRequestTopic>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topics.add(new TxnOffsetCommitRequestTopic((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("transactional_id", this.transactionalId);
        struct.set("group_id", this.groupId);
        struct.set("producer_id", this.producerId);
        struct.set("producer_epoch", this.producerEpoch);
        {
            Struct[] nestedObjects = new Struct[topics.size()];
            int i = 0;
            for (TxnOffsetCommitRequestTopic element : this.topics) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("topics", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 2;
        size += MessageUtil.serializedUtf8Length(transactionalId);
        size += 2;
        size += MessageUtil.serializedUtf8Length(groupId);
        size += 8;
        size += 2;
        size += 4;
        for (TxnOffsetCommitRequestTopic element : topics) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TxnOffsetCommitRequestData)) return false;
        TxnOffsetCommitRequestData other = (TxnOffsetCommitRequestData) obj;
        if (this.transactionalId == null) {
            if (other.transactionalId != null) return false;
        } else {
            if (!this.transactionalId.equals(other.transactionalId)) return false;
        }
        if (this.groupId == null) {
            if (other.groupId != null) return false;
        } else {
            if (!this.groupId.equals(other.groupId)) return false;
        }
        if (producerId != other.producerId) return false;
        if (producerEpoch != other.producerEpoch) return false;
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
        hashCode = 31 * hashCode + (groupId == null ? 0 : groupId.hashCode());
        hashCode = 31 * hashCode + ((int) (producerId >> 32) ^ (int) producerId);
        hashCode = 31 * hashCode + producerEpoch;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "TxnOffsetCommitRequestData("
            + "transactionalId='" + transactionalId + "'"
            + ", groupId='" + groupId + "'"
            + ", producerId=" + producerId
            + ", producerEpoch=" + producerEpoch
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public String transactionalId() {
        return this.transactionalId;
    }
    
    public String groupId() {
        return this.groupId;
    }
    
    public long producerId() {
        return this.producerId;
    }
    
    public short producerEpoch() {
        return this.producerEpoch;
    }
    
    public List<TxnOffsetCommitRequestTopic> topics() {
        return this.topics;
    }
    
    public TxnOffsetCommitRequestData setTransactionalId(String v) {
        this.transactionalId = v;
        return this;
    }
    
    public TxnOffsetCommitRequestData setGroupId(String v) {
        this.groupId = v;
        return this;
    }
    
    public TxnOffsetCommitRequestData setProducerId(long v) {
        this.producerId = v;
        return this;
    }
    
    public TxnOffsetCommitRequestData setProducerEpoch(short v) {
        this.producerEpoch = v;
        return this;
    }
    
    public TxnOffsetCommitRequestData setTopics(List<TxnOffsetCommitRequestTopic> v) {
        this.topics = v;
        return this;
    }
    
    static public class TxnOffsetCommitRequestTopic implements Message {
        private String name;
        private List<TxnOffsetCommitRequestPartition> partitions;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(TxnOffsetCommitRequestPartition.SCHEMA_0), "The partitions inside the topic that we want to committ offsets for.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(TxnOffsetCommitRequestPartition.SCHEMA_2), "The partitions inside the topic that we want to committ offsets for.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public TxnOffsetCommitRequestTopic(Readable readable, short version) {
            this.partitions = new ArrayList<TxnOffsetCommitRequestPartition>();
            read(readable, version);
        }
        
        public TxnOffsetCommitRequestTopic(Struct struct, short version) {
            this.partitions = new ArrayList<TxnOffsetCommitRequestPartition>();
            fromStruct(struct, version);
        }
        
        public TxnOffsetCommitRequestTopic() {
            this.name = "";
            this.partitions = new ArrayList<TxnOffsetCommitRequestPartition>();
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
                        this.partitions.add(new TxnOffsetCommitRequestPartition(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(partitions.size());
            for (TxnOffsetCommitRequestPartition element : partitions) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partitions");
                this.partitions = new ArrayList<TxnOffsetCommitRequestPartition>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitions.add(new TxnOffsetCommitRequestPartition((Struct) nestedObject, version));
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
                for (TxnOffsetCommitRequestPartition element : this.partitions) {
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
            for (TxnOffsetCommitRequestPartition element : partitions) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof TxnOffsetCommitRequestTopic)) return false;
            TxnOffsetCommitRequestTopic other = (TxnOffsetCommitRequestTopic) obj;
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
            return "TxnOffsetCommitRequestTopic("
                + "name='" + name + "'"
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<TxnOffsetCommitRequestPartition> partitions() {
            return this.partitions;
        }
        
        public TxnOffsetCommitRequestTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public TxnOffsetCommitRequestTopic setPartitions(List<TxnOffsetCommitRequestPartition> v) {
            this.partitions = v;
            return this;
        }
    }
    
    static public class TxnOffsetCommitRequestPartition implements Message {
        private int partitionIndex;
        private long committedOffset;
        private int committedLeaderEpoch;
        private String committedMetadata;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The index of the partition within the topic."),
                new Field("committed_offset", Type.INT64, "The message offset to be committed."),
                new Field("committed_metadata", Type.NULLABLE_STRING, "Any associated metadata the client wants to keep.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("partition_index", Type.INT32, "The index of the partition within the topic."),
                new Field("committed_offset", Type.INT64, "The message offset to be committed."),
                new Field("committed_leader_epoch", Type.INT32, "The leader epoch of the last consumed record."),
                new Field("committed_metadata", Type.NULLABLE_STRING, "Any associated metadata the client wants to keep.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public TxnOffsetCommitRequestPartition(Readable readable, short version) {
            read(readable, version);
        }
        
        public TxnOffsetCommitRequestPartition(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public TxnOffsetCommitRequestPartition() {
            this.partitionIndex = 0;
            this.committedOffset = 0L;
            this.committedLeaderEpoch = -1;
            this.committedMetadata = "";
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
            this.committedOffset = readable.readLong();
            if (version >= 2) {
                this.committedLeaderEpoch = readable.readInt();
            } else {
                this.committedLeaderEpoch = -1;
            }
            this.committedMetadata = readable.readNullableString();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionIndex);
            writable.writeLong(committedOffset);
            if (version >= 2) {
                writable.writeInt(committedLeaderEpoch);
            }
            writable.writeNullableString(committedMetadata);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionIndex = struct.getInt("partition_index");
            this.committedOffset = struct.getLong("committed_offset");
            if (version >= 2) {
                this.committedLeaderEpoch = struct.getInt("committed_leader_epoch");
            } else {
                this.committedLeaderEpoch = -1;
            }
            this.committedMetadata = struct.getString("committed_metadata");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_index", this.partitionIndex);
            struct.set("committed_offset", this.committedOffset);
            if (version >= 2) {
                struct.set("committed_leader_epoch", this.committedLeaderEpoch);
            }
            struct.set("committed_metadata", this.committedMetadata);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            size += 8;
            if (version >= 2) {
                size += 4;
            }
            size += 2;
            if (committedMetadata != null) {
                size += MessageUtil.serializedUtf8Length(committedMetadata);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof TxnOffsetCommitRequestPartition)) return false;
            TxnOffsetCommitRequestPartition other = (TxnOffsetCommitRequestPartition) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (committedOffset != other.committedOffset) return false;
            if (committedLeaderEpoch != other.committedLeaderEpoch) return false;
            if (this.committedMetadata == null) {
                if (other.committedMetadata != null) return false;
            } else {
                if (!this.committedMetadata.equals(other.committedMetadata)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + ((int) (committedOffset >> 32) ^ (int) committedOffset);
            hashCode = 31 * hashCode + committedLeaderEpoch;
            hashCode = 31 * hashCode + (committedMetadata == null ? 0 : committedMetadata.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "TxnOffsetCommitRequestPartition("
                + "partitionIndex=" + partitionIndex
                + ", committedOffset=" + committedOffset
                + ", committedLeaderEpoch=" + committedLeaderEpoch
                + ", committedMetadata='" + committedMetadata + "'"
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
        
        public String committedMetadata() {
            return this.committedMetadata;
        }
        
        public TxnOffsetCommitRequestPartition setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public TxnOffsetCommitRequestPartition setCommittedOffset(long v) {
            this.committedOffset = v;
            return this;
        }
        
        public TxnOffsetCommitRequestPartition setCommittedLeaderEpoch(int v) {
            this.committedLeaderEpoch = v;
            return this;
        }
        
        public TxnOffsetCommitRequestPartition setCommittedMetadata(String v) {
            this.committedMetadata = v;
            return this;
        }
    }
}
