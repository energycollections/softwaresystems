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


public class OffsetCommitRequestData implements ApiMessage {
    private String groupId;
    private int generationId;
    private String memberId;
    private long retentionTimeMs;
    private List<OffsetCommitRequestTopic> topics;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("group_id", Type.STRING, "The unique group identifier."),
            new Field("topics", new ArrayOf(OffsetCommitRequestTopic.SCHEMA_0), "The topics to commit offsets for.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("group_id", Type.STRING, "The unique group identifier."),
            new Field("generation_id", Type.INT32, "The generation of the group."),
            new Field("member_id", Type.STRING, "The member ID assigned by the group coordinator."),
            new Field("topics", new ArrayOf(OffsetCommitRequestTopic.SCHEMA_1), "The topics to commit offsets for.")
        );
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("group_id", Type.STRING, "The unique group identifier."),
            new Field("generation_id", Type.INT32, "The generation of the group."),
            new Field("member_id", Type.STRING, "The member ID assigned by the group coordinator."),
            new Field("retention_time_ms", Type.INT64, "The time period in ms to retain the offset."),
            new Field("topics", new ArrayOf(OffsetCommitRequestTopic.SCHEMA_2), "The topics to commit offsets for.")
        );
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema SCHEMA_4 = SCHEMA_3;
    
    public static final Schema SCHEMA_5 =
        new Schema(
            new Field("group_id", Type.STRING, "The unique group identifier."),
            new Field("generation_id", Type.INT32, "The generation of the group."),
            new Field("member_id", Type.STRING, "The member ID assigned by the group coordinator."),
            new Field("topics", new ArrayOf(OffsetCommitRequestTopic.SCHEMA_2), "The topics to commit offsets for.")
        );
    
    public static final Schema SCHEMA_6 =
        new Schema(
            new Field("group_id", Type.STRING, "The unique group identifier."),
            new Field("generation_id", Type.INT32, "The generation of the group."),
            new Field("member_id", Type.STRING, "The member ID assigned by the group coordinator."),
            new Field("topics", new ArrayOf(OffsetCommitRequestTopic.SCHEMA_6), "The topics to commit offsets for.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3,
        SCHEMA_4,
        SCHEMA_5,
        SCHEMA_6
    };
    
    public OffsetCommitRequestData(Readable readable, short version) {
        this.topics = new ArrayList<OffsetCommitRequestTopic>();
        read(readable, version);
    }
    
    public OffsetCommitRequestData(Struct struct, short version) {
        this.topics = new ArrayList<OffsetCommitRequestTopic>();
        fromStruct(struct, version);
    }
    
    public OffsetCommitRequestData() {
        this.groupId = "";
        this.generationId = -1;
        this.memberId = "";
        this.retentionTimeMs = -1L;
        this.topics = new ArrayList<OffsetCommitRequestTopic>();
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
        this.groupId = readable.readNullableString();
        if (version >= 1) {
            this.generationId = readable.readInt();
        } else {
            this.generationId = -1;
        }
        if (version >= 1) {
            this.memberId = readable.readNullableString();
        } else {
            this.memberId = "";
        }
        if ((version >= 2) && (version <= 4)) {
            this.retentionTimeMs = readable.readLong();
        } else {
            this.retentionTimeMs = -1L;
        }
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topics.clear();
            } else {
                this.topics.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.topics.add(new OffsetCommitRequestTopic(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeString(groupId);
        if (version >= 1) {
            writable.writeInt(generationId);
        }
        if (version >= 1) {
            writable.writeString(memberId);
        }
        if ((version >= 2) && (version <= 4)) {
            writable.writeLong(retentionTimeMs);
        }
        writable.writeInt(topics.size());
        for (OffsetCommitRequestTopic element : topics) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.groupId = struct.getString("group_id");
        if (version >= 1) {
            this.generationId = struct.getInt("generation_id");
        } else {
            this.generationId = -1;
        }
        if (version >= 1) {
            this.memberId = struct.getString("member_id");
        } else {
            this.memberId = "";
        }
        if ((version >= 2) && (version <= 4)) {
            this.retentionTimeMs = struct.getLong("retention_time_ms");
        } else {
            this.retentionTimeMs = -1L;
        }
        {
            Object[] nestedObjects = struct.getArray("topics");
            this.topics = new ArrayList<OffsetCommitRequestTopic>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topics.add(new OffsetCommitRequestTopic((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("group_id", this.groupId);
        if (version >= 1) {
            struct.set("generation_id", this.generationId);
        }
        if (version >= 1) {
            struct.set("member_id", this.memberId);
        }
        if ((version >= 2) && (version <= 4)) {
            struct.set("retention_time_ms", this.retentionTimeMs);
        }
        {
            Struct[] nestedObjects = new Struct[topics.size()];
            int i = 0;
            for (OffsetCommitRequestTopic element : this.topics) {
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
        size += MessageUtil.serializedUtf8Length(groupId);
        if (version >= 1) {
            size += 4;
        }
        if (version >= 1) {
            size += 2;
            size += MessageUtil.serializedUtf8Length(memberId);
        }
        if ((version >= 2) && (version <= 4)) {
            size += 8;
        }
        size += 4;
        for (OffsetCommitRequestTopic element : topics) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OffsetCommitRequestData)) return false;
        OffsetCommitRequestData other = (OffsetCommitRequestData) obj;
        if (this.groupId == null) {
            if (other.groupId != null) return false;
        } else {
            if (!this.groupId.equals(other.groupId)) return false;
        }
        if (generationId != other.generationId) return false;
        if (this.memberId == null) {
            if (other.memberId != null) return false;
        } else {
            if (!this.memberId.equals(other.memberId)) return false;
        }
        if (retentionTimeMs != other.retentionTimeMs) return false;
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
        hashCode = 31 * hashCode + (groupId == null ? 0 : groupId.hashCode());
        hashCode = 31 * hashCode + generationId;
        hashCode = 31 * hashCode + (memberId == null ? 0 : memberId.hashCode());
        hashCode = 31 * hashCode + ((int) (retentionTimeMs >> 32) ^ (int) retentionTimeMs);
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "OffsetCommitRequestData("
            + "groupId='" + groupId + "'"
            + ", generationId=" + generationId
            + ", memberId='" + memberId + "'"
            + ", retentionTimeMs=" + retentionTimeMs
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public String groupId() {
        return this.groupId;
    }
    
    public int generationId() {
        return this.generationId;
    }
    
    public String memberId() {
        return this.memberId;
    }
    
    public long retentionTimeMs() {
        return this.retentionTimeMs;
    }
    
    public List<OffsetCommitRequestTopic> topics() {
        return this.topics;
    }
    
    public OffsetCommitRequestData setGroupId(String v) {
        this.groupId = v;
        return this;
    }
    
    public OffsetCommitRequestData setGenerationId(int v) {
        this.generationId = v;
        return this;
    }
    
    public OffsetCommitRequestData setMemberId(String v) {
        this.memberId = v;
        return this;
    }
    
    public OffsetCommitRequestData setRetentionTimeMs(long v) {
        this.retentionTimeMs = v;
        return this;
    }
    
    public OffsetCommitRequestData setTopics(List<OffsetCommitRequestTopic> v) {
        this.topics = v;
        return this;
    }
    
    static public class OffsetCommitRequestTopic implements Message {
        private String name;
        private List<OffsetCommitRequestPartition> partitions;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(OffsetCommitRequestPartition.SCHEMA_0), "Each partition to commit offsets for.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(OffsetCommitRequestPartition.SCHEMA_1), "Each partition to commit offsets for.")
            );
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(OffsetCommitRequestPartition.SCHEMA_2), "Each partition to commit offsets for.")
            );
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema SCHEMA_6 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(OffsetCommitRequestPartition.SCHEMA_6), "Each partition to commit offsets for.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5,
            SCHEMA_6
        };
        
        public OffsetCommitRequestTopic(Readable readable, short version) {
            this.partitions = new ArrayList<OffsetCommitRequestPartition>();
            read(readable, version);
        }
        
        public OffsetCommitRequestTopic(Struct struct, short version) {
            this.partitions = new ArrayList<OffsetCommitRequestPartition>();
            fromStruct(struct, version);
        }
        
        public OffsetCommitRequestTopic() {
            this.name = "";
            this.partitions = new ArrayList<OffsetCommitRequestPartition>();
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
                        this.partitions.add(new OffsetCommitRequestPartition(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(partitions.size());
            for (OffsetCommitRequestPartition element : partitions) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partitions");
                this.partitions = new ArrayList<OffsetCommitRequestPartition>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitions.add(new OffsetCommitRequestPartition((Struct) nestedObject, version));
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
                for (OffsetCommitRequestPartition element : this.partitions) {
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
            for (OffsetCommitRequestPartition element : partitions) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof OffsetCommitRequestTopic)) return false;
            OffsetCommitRequestTopic other = (OffsetCommitRequestTopic) obj;
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
            return "OffsetCommitRequestTopic("
                + "name='" + name + "'"
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<OffsetCommitRequestPartition> partitions() {
            return this.partitions;
        }
        
        public OffsetCommitRequestTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public OffsetCommitRequestTopic setPartitions(List<OffsetCommitRequestPartition> v) {
            this.partitions = v;
            return this;
        }
    }
    
    static public class OffsetCommitRequestPartition implements Message {
        private int partitionIndex;
        private long committedOffset;
        private int committedLeaderEpoch;
        private long commitTimestamp;
        private String committedMetadata;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("committed_offset", Type.INT64, "The message offset to be committed."),
                new Field("committed_metadata", Type.NULLABLE_STRING, "Any associated metadata the client wants to keep.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("committed_offset", Type.INT64, "The message offset to be committed."),
                new Field("commit_timestamp", Type.INT64, "The timestamp of the commit."),
                new Field("committed_metadata", Type.NULLABLE_STRING, "Any associated metadata the client wants to keep.")
            );
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("committed_offset", Type.INT64, "The message offset to be committed."),
                new Field("committed_metadata", Type.NULLABLE_STRING, "Any associated metadata the client wants to keep.")
            );
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema SCHEMA_6 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("committed_offset", Type.INT64, "The message offset to be committed."),
                new Field("committed_leader_epoch", Type.INT32, "The leader epoch of this partition."),
                new Field("committed_metadata", Type.NULLABLE_STRING, "Any associated metadata the client wants to keep.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5,
            SCHEMA_6
        };
        
        public OffsetCommitRequestPartition(Readable readable, short version) {
            read(readable, version);
        }
        
        public OffsetCommitRequestPartition(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public OffsetCommitRequestPartition() {
            this.partitionIndex = 0;
            this.committedOffset = 0L;
            this.committedLeaderEpoch = -1;
            this.commitTimestamp = -1L;
            this.committedMetadata = "";
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
            this.committedOffset = readable.readLong();
            if (version >= 6) {
                this.committedLeaderEpoch = readable.readInt();
            } else {
                this.committedLeaderEpoch = -1;
            }
            if ((version >= 1) && (version <= 1)) {
                this.commitTimestamp = readable.readLong();
            } else {
                this.commitTimestamp = -1L;
            }
            this.committedMetadata = readable.readNullableString();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionIndex);
            writable.writeLong(committedOffset);
            if (version >= 6) {
                writable.writeInt(committedLeaderEpoch);
            }
            if ((version >= 1) && (version <= 1)) {
                writable.writeLong(commitTimestamp);
            }
            writable.writeNullableString(committedMetadata);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionIndex = struct.getInt("partition_index");
            this.committedOffset = struct.getLong("committed_offset");
            if (version >= 6) {
                this.committedLeaderEpoch = struct.getInt("committed_leader_epoch");
            } else {
                this.committedLeaderEpoch = -1;
            }
            if ((version >= 1) && (version <= 1)) {
                this.commitTimestamp = struct.getLong("commit_timestamp");
            } else {
                this.commitTimestamp = -1L;
            }
            this.committedMetadata = struct.getString("committed_metadata");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_index", this.partitionIndex);
            struct.set("committed_offset", this.committedOffset);
            if (version >= 6) {
                struct.set("committed_leader_epoch", this.committedLeaderEpoch);
            }
            if ((version >= 1) && (version <= 1)) {
                struct.set("commit_timestamp", this.commitTimestamp);
            }
            struct.set("committed_metadata", this.committedMetadata);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            size += 8;
            if (version >= 6) {
                size += 4;
            }
            if ((version >= 1) && (version <= 1)) {
                size += 8;
            } else {
                if (commitTimestamp != -1L) {
                    throw new UnsupportedVersionException("Attempted to write a non-default commitTimestamp at version " + version);
                }
            }
            size += 2;
            if (committedMetadata != null) {
                size += MessageUtil.serializedUtf8Length(committedMetadata);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof OffsetCommitRequestPartition)) return false;
            OffsetCommitRequestPartition other = (OffsetCommitRequestPartition) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (committedOffset != other.committedOffset) return false;
            if (committedLeaderEpoch != other.committedLeaderEpoch) return false;
            if (commitTimestamp != other.commitTimestamp) return false;
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
            hashCode = 31 * hashCode + ((int) (commitTimestamp >> 32) ^ (int) commitTimestamp);
            hashCode = 31 * hashCode + (committedMetadata == null ? 0 : committedMetadata.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "OffsetCommitRequestPartition("
                + "partitionIndex=" + partitionIndex
                + ", committedOffset=" + committedOffset
                + ", committedLeaderEpoch=" + committedLeaderEpoch
                + ", commitTimestamp=" + commitTimestamp
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
        
        public long commitTimestamp() {
            return this.commitTimestamp;
        }
        
        public String committedMetadata() {
            return this.committedMetadata;
        }
        
        public OffsetCommitRequestPartition setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public OffsetCommitRequestPartition setCommittedOffset(long v) {
            this.committedOffset = v;
            return this;
        }
        
        public OffsetCommitRequestPartition setCommittedLeaderEpoch(int v) {
            this.committedLeaderEpoch = v;
            return this;
        }
        
        public OffsetCommitRequestPartition setCommitTimestamp(long v) {
            this.commitTimestamp = v;
            return this;
        }
        
        public OffsetCommitRequestPartition setCommittedMetadata(String v) {
            this.committedMetadata = v;
            return this;
        }
    }
}
