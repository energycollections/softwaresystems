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


public class FetchRequestData implements ApiMessage {
    private int replicaId;
    private int maxWait;
    private int minBytes;
    private int maxBytes;
    private byte isolationLevel;
    private int sessionId;
    private int epoch;
    private List<FetchableTopic> topics;
    private List<ForgottenTopic> forgotten;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the follower, of -1 if this request is from a consumer."),
            new Field("max_wait", Type.INT32, "The maximum time in milliseconds to wait for the response."),
            new Field("min_bytes", Type.INT32, "The minimum bytes to accumulate in the response."),
            new Field("topics", new ArrayOf(FetchableTopic.SCHEMA_0), "The topics to fetch.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema SCHEMA_3 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the follower, of -1 if this request is from a consumer."),
            new Field("max_wait", Type.INT32, "The maximum time in milliseconds to wait for the response."),
            new Field("min_bytes", Type.INT32, "The minimum bytes to accumulate in the response."),
            new Field("max_bytes", Type.INT32, "The maximum bytes to fetch.  See KIP-74 for cases where this limit may not be honored."),
            new Field("topics", new ArrayOf(FetchableTopic.SCHEMA_0), "The topics to fetch.")
        );
    
    public static final Schema SCHEMA_4 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the follower, of -1 if this request is from a consumer."),
            new Field("max_wait", Type.INT32, "The maximum time in milliseconds to wait for the response."),
            new Field("min_bytes", Type.INT32, "The minimum bytes to accumulate in the response."),
            new Field("max_bytes", Type.INT32, "The maximum bytes to fetch.  See KIP-74 for cases where this limit may not be honored."),
            new Field("isolation_level", Type.INT8, "This setting controls the visibility of transactional records. Using READ_UNCOMMITTED (isolation_level = 0) makes all records visible. With READ_COMMITTED (isolation_level = 1), non-transactional and COMMITTED transactional records are visible. To be more concrete, READ_COMMITTED returns all data from offsets smaller than the current LSO (last stable offset), and enables the inclusion of the list of aborted transactions in the result, which allows consumers to discard ABORTED transactional records"),
            new Field("topics", new ArrayOf(FetchableTopic.SCHEMA_0), "The topics to fetch.")
        );
    
    public static final Schema SCHEMA_5 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the follower, of -1 if this request is from a consumer."),
            new Field("max_wait", Type.INT32, "The maximum time in milliseconds to wait for the response."),
            new Field("min_bytes", Type.INT32, "The minimum bytes to accumulate in the response."),
            new Field("max_bytes", Type.INT32, "The maximum bytes to fetch.  See KIP-74 for cases where this limit may not be honored."),
            new Field("isolation_level", Type.INT8, "This setting controls the visibility of transactional records. Using READ_UNCOMMITTED (isolation_level = 0) makes all records visible. With READ_COMMITTED (isolation_level = 1), non-transactional and COMMITTED transactional records are visible. To be more concrete, READ_COMMITTED returns all data from offsets smaller than the current LSO (last stable offset), and enables the inclusion of the list of aborted transactions in the result, which allows consumers to discard ABORTED transactional records"),
            new Field("topics", new ArrayOf(FetchableTopic.SCHEMA_5), "The topics to fetch.")
        );
    
    public static final Schema SCHEMA_6 = SCHEMA_5;
    
    public static final Schema SCHEMA_7 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the follower, of -1 if this request is from a consumer."),
            new Field("max_wait", Type.INT32, "The maximum time in milliseconds to wait for the response."),
            new Field("min_bytes", Type.INT32, "The minimum bytes to accumulate in the response."),
            new Field("max_bytes", Type.INT32, "The maximum bytes to fetch.  See KIP-74 for cases where this limit may not be honored."),
            new Field("isolation_level", Type.INT8, "This setting controls the visibility of transactional records. Using READ_UNCOMMITTED (isolation_level = 0) makes all records visible. With READ_COMMITTED (isolation_level = 1), non-transactional and COMMITTED transactional records are visible. To be more concrete, READ_COMMITTED returns all data from offsets smaller than the current LSO (last stable offset), and enables the inclusion of the list of aborted transactions in the result, which allows consumers to discard ABORTED transactional records"),
            new Field("session_id", Type.INT32, "The fetch session ID."),
            new Field("epoch", Type.INT32, "The fetch session ID."),
            new Field("topics", new ArrayOf(FetchableTopic.SCHEMA_5), "The topics to fetch."),
            new Field("forgotten", new ArrayOf(ForgottenTopic.SCHEMA_7), "In an incremental fetch request, the partitions to remove.")
        );
    
    public static final Schema SCHEMA_8 = SCHEMA_7;
    
    public static final Schema SCHEMA_9 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the follower, of -1 if this request is from a consumer."),
            new Field("max_wait", Type.INT32, "The maximum time in milliseconds to wait for the response."),
            new Field("min_bytes", Type.INT32, "The minimum bytes to accumulate in the response."),
            new Field("max_bytes", Type.INT32, "The maximum bytes to fetch.  See KIP-74 for cases where this limit may not be honored."),
            new Field("isolation_level", Type.INT8, "This setting controls the visibility of transactional records. Using READ_UNCOMMITTED (isolation_level = 0) makes all records visible. With READ_COMMITTED (isolation_level = 1), non-transactional and COMMITTED transactional records are visible. To be more concrete, READ_COMMITTED returns all data from offsets smaller than the current LSO (last stable offset), and enables the inclusion of the list of aborted transactions in the result, which allows consumers to discard ABORTED transactional records"),
            new Field("session_id", Type.INT32, "The fetch session ID."),
            new Field("epoch", Type.INT32, "The fetch session ID."),
            new Field("topics", new ArrayOf(FetchableTopic.SCHEMA_9), "The topics to fetch."),
            new Field("forgotten", new ArrayOf(ForgottenTopic.SCHEMA_7), "In an incremental fetch request, the partitions to remove.")
        );
    
    public static final Schema SCHEMA_10 = SCHEMA_9;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3,
        SCHEMA_4,
        SCHEMA_5,
        SCHEMA_6,
        SCHEMA_7,
        SCHEMA_8,
        SCHEMA_9,
        SCHEMA_10
    };
    
    public FetchRequestData(Readable readable, short version) {
        this.topics = new ArrayList<FetchableTopic>();
        this.forgotten = new ArrayList<ForgottenTopic>();
        read(readable, version);
    }
    
    public FetchRequestData(Struct struct, short version) {
        this.topics = new ArrayList<FetchableTopic>();
        this.forgotten = new ArrayList<ForgottenTopic>();
        fromStruct(struct, version);
    }
    
    public FetchRequestData() {
        this.replicaId = 0;
        this.maxWait = 0;
        this.minBytes = 0;
        this.maxBytes = 0x7fffffff;
        this.isolationLevel = (byte) 0;
        this.sessionId = 0;
        this.epoch = -1;
        this.topics = new ArrayList<FetchableTopic>();
        this.forgotten = new ArrayList<ForgottenTopic>();
    }
    
    @Override
    public short apiKey() {
        return 1;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 10;
    }
    
    @Override
    public void read(Readable readable, short version) {
        this.replicaId = readable.readInt();
        this.maxWait = readable.readInt();
        this.minBytes = readable.readInt();
        if (version >= 3) {
            this.maxBytes = readable.readInt();
        } else {
            this.maxBytes = 0x7fffffff;
        }
        if (version >= 4) {
            this.isolationLevel = readable.readByte();
        } else {
            this.isolationLevel = (byte) 0;
        }
        if (version >= 7) {
            this.sessionId = readable.readInt();
        } else {
            this.sessionId = 0;
        }
        if (version >= 7) {
            this.epoch = readable.readInt();
        } else {
            this.epoch = -1;
        }
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topics.clear();
            } else {
                this.topics.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.topics.add(new FetchableTopic(readable, version));
                }
            }
        }
        if (version >= 7) {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.forgotten.clear();
            } else {
                this.forgotten.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.forgotten.add(new ForgottenTopic(readable, version));
                }
            }
        } else {
            this.forgotten = new ArrayList<ForgottenTopic>();
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(replicaId);
        writable.writeInt(maxWait);
        writable.writeInt(minBytes);
        if (version >= 3) {
            writable.writeInt(maxBytes);
        }
        if (version >= 4) {
            writable.writeByte(isolationLevel);
        }
        if (version >= 7) {
            writable.writeInt(sessionId);
        }
        if (version >= 7) {
            writable.writeInt(epoch);
        }
        writable.writeInt(topics.size());
        for (FetchableTopic element : topics) {
            element.write(writable, version);
        }
        if (version >= 7) {
            writable.writeInt(forgotten.size());
            for (ForgottenTopic element : forgotten) {
                element.write(writable, version);
            }
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.replicaId = struct.getInt("replica_id");
        this.maxWait = struct.getInt("max_wait");
        this.minBytes = struct.getInt("min_bytes");
        if (version >= 3) {
            this.maxBytes = struct.getInt("max_bytes");
        } else {
            this.maxBytes = 0x7fffffff;
        }
        if (version >= 4) {
            this.isolationLevel = struct.getByte("isolation_level");
        } else {
            this.isolationLevel = (byte) 0;
        }
        if (version >= 7) {
            this.sessionId = struct.getInt("session_id");
        } else {
            this.sessionId = 0;
        }
        if (version >= 7) {
            this.epoch = struct.getInt("epoch");
        } else {
            this.epoch = -1;
        }
        {
            Object[] nestedObjects = struct.getArray("topics");
            this.topics = new ArrayList<FetchableTopic>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topics.add(new FetchableTopic((Struct) nestedObject, version));
            }
        }
        if (version >= 7) {
            Object[] nestedObjects = struct.getArray("forgotten");
            this.forgotten = new ArrayList<ForgottenTopic>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.forgotten.add(new ForgottenTopic((Struct) nestedObject, version));
            }
        } else {
            this.forgotten = new ArrayList<ForgottenTopic>();
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("replica_id", this.replicaId);
        struct.set("max_wait", this.maxWait);
        struct.set("min_bytes", this.minBytes);
        if (version >= 3) {
            struct.set("max_bytes", this.maxBytes);
        }
        if (version >= 4) {
            struct.set("isolation_level", this.isolationLevel);
        }
        if (version >= 7) {
            struct.set("session_id", this.sessionId);
        }
        if (version >= 7) {
            struct.set("epoch", this.epoch);
        }
        {
            Struct[] nestedObjects = new Struct[topics.size()];
            int i = 0;
            for (FetchableTopic element : this.topics) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("topics", (Object[]) nestedObjects);
        }
        if (version >= 7) {
            Struct[] nestedObjects = new Struct[forgotten.size()];
            int i = 0;
            for (ForgottenTopic element : this.forgotten) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("forgotten", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        size += 4;
        size += 4;
        if (version >= 3) {
            size += 4;
        }
        if (version >= 4) {
            size += 1;
        } else {
            if (isolationLevel != (byte) 0) {
                throw new UnsupportedVersionException("Attempted to write a non-default isolationLevel at version " + version);
            }
        }
        if (version >= 7) {
            size += 4;
        } else {
            if (sessionId != 0) {
                throw new UnsupportedVersionException("Attempted to write a non-default sessionId at version " + version);
            }
        }
        if (version >= 7) {
            size += 4;
        } else {
            if (epoch != -1) {
                throw new UnsupportedVersionException("Attempted to write a non-default epoch at version " + version);
            }
        }
        size += 4;
        for (FetchableTopic element : topics) {
            size += element.size(version);
        }
        if (version >= 7) {
            size += 4;
            for (ForgottenTopic element : forgotten) {
                size += element.size(version);
            }
        } else {
            if (!forgotten.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default forgotten at version " + version);
            }
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FetchRequestData)) return false;
        FetchRequestData other = (FetchRequestData) obj;
        if (replicaId != other.replicaId) return false;
        if (maxWait != other.maxWait) return false;
        if (minBytes != other.minBytes) return false;
        if (maxBytes != other.maxBytes) return false;
        if (isolationLevel != other.isolationLevel) return false;
        if (sessionId != other.sessionId) return false;
        if (epoch != other.epoch) return false;
        if (this.topics == null) {
            if (other.topics != null) return false;
        } else {
            if (!this.topics.equals(other.topics)) return false;
        }
        if (this.forgotten == null) {
            if (other.forgotten != null) return false;
        } else {
            if (!this.forgotten.equals(other.forgotten)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + replicaId;
        hashCode = 31 * hashCode + maxWait;
        hashCode = 31 * hashCode + minBytes;
        hashCode = 31 * hashCode + maxBytes;
        hashCode = 31 * hashCode + isolationLevel;
        hashCode = 31 * hashCode + sessionId;
        hashCode = 31 * hashCode + epoch;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        hashCode = 31 * hashCode + (forgotten == null ? 0 : forgotten.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "FetchRequestData("
            + "replicaId=" + replicaId
            + ", maxWait=" + maxWait
            + ", minBytes=" + minBytes
            + ", maxBytes=" + maxBytes
            + ", isolationLevel=" + isolationLevel
            + ", sessionId=" + sessionId
            + ", epoch=" + epoch
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ", forgotten=" + MessageUtil.deepToString(forgotten.iterator())
            + ")";
    }
    
    public int replicaId() {
        return this.replicaId;
    }
    
    public int maxWait() {
        return this.maxWait;
    }
    
    public int minBytes() {
        return this.minBytes;
    }
    
    public int maxBytes() {
        return this.maxBytes;
    }
    
    public byte isolationLevel() {
        return this.isolationLevel;
    }
    
    public int sessionId() {
        return this.sessionId;
    }
    
    public int epoch() {
        return this.epoch;
    }
    
    public List<FetchableTopic> topics() {
        return this.topics;
    }
    
    public List<ForgottenTopic> forgotten() {
        return this.forgotten;
    }
    
    public FetchRequestData setReplicaId(int v) {
        this.replicaId = v;
        return this;
    }
    
    public FetchRequestData setMaxWait(int v) {
        this.maxWait = v;
        return this;
    }
    
    public FetchRequestData setMinBytes(int v) {
        this.minBytes = v;
        return this;
    }
    
    public FetchRequestData setMaxBytes(int v) {
        this.maxBytes = v;
        return this;
    }
    
    public FetchRequestData setIsolationLevel(byte v) {
        this.isolationLevel = v;
        return this;
    }
    
    public FetchRequestData setSessionId(int v) {
        this.sessionId = v;
        return this;
    }
    
    public FetchRequestData setEpoch(int v) {
        this.epoch = v;
        return this;
    }
    
    public FetchRequestData setTopics(List<FetchableTopic> v) {
        this.topics = v;
        return this;
    }
    
    public FetchRequestData setForgotten(List<ForgottenTopic> v) {
        this.forgotten = v;
        return this;
    }
    
    static public class FetchableTopic implements Message {
        private String name;
        private List<FetchPartition> fetchPartitions;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The name of the topic to fetch."),
                new Field("fetch_partitions", new ArrayOf(FetchPartition.SCHEMA_0), "The partitions to fetch.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("name", Type.STRING, "The name of the topic to fetch."),
                new Field("fetch_partitions", new ArrayOf(FetchPartition.SCHEMA_5), "The partitions to fetch.")
            );
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
        public static final Schema SCHEMA_8 = SCHEMA_7;
        
        public static final Schema SCHEMA_9 =
            new Schema(
                new Field("name", Type.STRING, "The name of the topic to fetch."),
                new Field("fetch_partitions", new ArrayOf(FetchPartition.SCHEMA_9), "The partitions to fetch.")
            );
        
        public static final Schema SCHEMA_10 = SCHEMA_9;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5,
            SCHEMA_6,
            SCHEMA_7,
            SCHEMA_8,
            SCHEMA_9,
            SCHEMA_10
        };
        
        public FetchableTopic(Readable readable, short version) {
            this.fetchPartitions = new ArrayList<FetchPartition>();
            read(readable, version);
        }
        
        public FetchableTopic(Struct struct, short version) {
            this.fetchPartitions = new ArrayList<FetchPartition>();
            fromStruct(struct, version);
        }
        
        public FetchableTopic() {
            this.name = "";
            this.fetchPartitions = new ArrayList<FetchPartition>();
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 10;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.name = readable.readNullableString();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.fetchPartitions.clear();
                } else {
                    this.fetchPartitions.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.fetchPartitions.add(new FetchPartition(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(fetchPartitions.size());
            for (FetchPartition element : fetchPartitions) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("fetch_partitions");
                this.fetchPartitions = new ArrayList<FetchPartition>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.fetchPartitions.add(new FetchPartition((Struct) nestedObject, version));
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            {
                Struct[] nestedObjects = new Struct[fetchPartitions.size()];
                int i = 0;
                for (FetchPartition element : this.fetchPartitions) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("fetch_partitions", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            size += 4;
            for (FetchPartition element : fetchPartitions) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof FetchableTopic)) return false;
            FetchableTopic other = (FetchableTopic) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (this.fetchPartitions == null) {
                if (other.fetchPartitions != null) return false;
            } else {
                if (!this.fetchPartitions.equals(other.fetchPartitions)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + (fetchPartitions == null ? 0 : fetchPartitions.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "FetchableTopic("
                + "name='" + name + "'"
                + ", fetchPartitions=" + MessageUtil.deepToString(fetchPartitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<FetchPartition> fetchPartitions() {
            return this.fetchPartitions;
        }
        
        public FetchableTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public FetchableTopic setFetchPartitions(List<FetchPartition> v) {
            this.fetchPartitions = v;
            return this;
        }
    }
    
    static public class FetchPartition implements Message {
        private int partitionIndex;
        private int currentLeaderEpoch;
        private long fetchOffset;
        private long logStartOffset;
        private int maxBytes;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("fetch_offset", Type.INT64, "The message offset."),
                new Field("max_bytes", Type.INT32, "The maximum bytes to fetch from this partition.  See KIP-74 for cases where this limit may not be honored.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("fetch_offset", Type.INT64, "The message offset."),
                new Field("log_start_offset", Type.INT64, "The earliest available offset of the follower replica.  The field is only used when the request is sent by the follower."),
                new Field("max_bytes", Type.INT32, "The maximum bytes to fetch from this partition.  See KIP-74 for cases where this limit may not be honored.")
            );
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
        public static final Schema SCHEMA_8 = SCHEMA_7;
        
        public static final Schema SCHEMA_9 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("current_leader_epoch", Type.INT32, "The current leader epoch of the partition."),
                new Field("fetch_offset", Type.INT64, "The message offset."),
                new Field("log_start_offset", Type.INT64, "The earliest available offset of the follower replica.  The field is only used when the request is sent by the follower."),
                new Field("max_bytes", Type.INT32, "The maximum bytes to fetch from this partition.  See KIP-74 for cases where this limit may not be honored.")
            );
        
        public static final Schema SCHEMA_10 = SCHEMA_9;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5,
            SCHEMA_6,
            SCHEMA_7,
            SCHEMA_8,
            SCHEMA_9,
            SCHEMA_10
        };
        
        public FetchPartition(Readable readable, short version) {
            read(readable, version);
        }
        
        public FetchPartition(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public FetchPartition() {
            this.partitionIndex = 0;
            this.currentLeaderEpoch = -1;
            this.fetchOffset = 0L;
            this.logStartOffset = -1L;
            this.maxBytes = 0;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 10;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.partitionIndex = readable.readInt();
            if (version >= 9) {
                this.currentLeaderEpoch = readable.readInt();
            } else {
                this.currentLeaderEpoch = -1;
            }
            this.fetchOffset = readable.readLong();
            if (version >= 5) {
                this.logStartOffset = readable.readLong();
            } else {
                this.logStartOffset = -1L;
            }
            this.maxBytes = readable.readInt();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionIndex);
            if (version >= 9) {
                writable.writeInt(currentLeaderEpoch);
            }
            writable.writeLong(fetchOffset);
            if (version >= 5) {
                writable.writeLong(logStartOffset);
            }
            writable.writeInt(maxBytes);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionIndex = struct.getInt("partition_index");
            if (version >= 9) {
                this.currentLeaderEpoch = struct.getInt("current_leader_epoch");
            } else {
                this.currentLeaderEpoch = -1;
            }
            this.fetchOffset = struct.getLong("fetch_offset");
            if (version >= 5) {
                this.logStartOffset = struct.getLong("log_start_offset");
            } else {
                this.logStartOffset = -1L;
            }
            this.maxBytes = struct.getInt("max_bytes");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_index", this.partitionIndex);
            if (version >= 9) {
                struct.set("current_leader_epoch", this.currentLeaderEpoch);
            }
            struct.set("fetch_offset", this.fetchOffset);
            if (version >= 5) {
                struct.set("log_start_offset", this.logStartOffset);
            }
            struct.set("max_bytes", this.maxBytes);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            if (version >= 9) {
                size += 4;
            }
            size += 8;
            if (version >= 5) {
                size += 8;
            } else {
                if (logStartOffset != -1L) {
                    throw new UnsupportedVersionException("Attempted to write a non-default logStartOffset at version " + version);
                }
            }
            size += 4;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof FetchPartition)) return false;
            FetchPartition other = (FetchPartition) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (currentLeaderEpoch != other.currentLeaderEpoch) return false;
            if (fetchOffset != other.fetchOffset) return false;
            if (logStartOffset != other.logStartOffset) return false;
            if (maxBytes != other.maxBytes) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + currentLeaderEpoch;
            hashCode = 31 * hashCode + ((int) (fetchOffset >> 32) ^ (int) fetchOffset);
            hashCode = 31 * hashCode + ((int) (logStartOffset >> 32) ^ (int) logStartOffset);
            hashCode = 31 * hashCode + maxBytes;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "FetchPartition("
                + "partitionIndex=" + partitionIndex
                + ", currentLeaderEpoch=" + currentLeaderEpoch
                + ", fetchOffset=" + fetchOffset
                + ", logStartOffset=" + logStartOffset
                + ", maxBytes=" + maxBytes
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public int currentLeaderEpoch() {
            return this.currentLeaderEpoch;
        }
        
        public long fetchOffset() {
            return this.fetchOffset;
        }
        
        public long logStartOffset() {
            return this.logStartOffset;
        }
        
        public int maxBytes() {
            return this.maxBytes;
        }
        
        public FetchPartition setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public FetchPartition setCurrentLeaderEpoch(int v) {
            this.currentLeaderEpoch = v;
            return this;
        }
        
        public FetchPartition setFetchOffset(long v) {
            this.fetchOffset = v;
            return this;
        }
        
        public FetchPartition setLogStartOffset(long v) {
            this.logStartOffset = v;
            return this;
        }
        
        public FetchPartition setMaxBytes(int v) {
            this.maxBytes = v;
            return this;
        }
    }
    
    static public class ForgottenTopic implements Message {
        private String name;
        private List<Integer> forgottenPartitionIndexes;
        
        public static final Schema SCHEMA_7 =
            new Schema(
                new Field("name", Type.STRING, "The partition name."),
                new Field("forgotten_partition_indexes", new ArrayOf(Type.INT32), "The partitions indexes to forget.")
            );
        
        public static final Schema SCHEMA_8 = SCHEMA_7;
        
        public static final Schema SCHEMA_9 = SCHEMA_8;
        
        public static final Schema SCHEMA_10 = SCHEMA_9;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            SCHEMA_7,
            SCHEMA_8,
            SCHEMA_9,
            SCHEMA_10
        };
        
        public ForgottenTopic(Readable readable, short version) {
            this.forgottenPartitionIndexes = new ArrayList<Integer>();
            read(readable, version);
        }
        
        public ForgottenTopic(Struct struct, short version) {
            this.forgottenPartitionIndexes = new ArrayList<Integer>();
            fromStruct(struct, version);
        }
        
        public ForgottenTopic() {
            this.name = "";
            this.forgottenPartitionIndexes = new ArrayList<Integer>();
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 10;
        }
        
        @Override
        public void read(Readable readable, short version) {
            if (version < 7) {
                throw new UnsupportedVersionException("Can't read version " + version + " of ForgottenTopic");
            }
            this.name = readable.readNullableString();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.forgottenPartitionIndexes.clear();
                } else {
                    this.forgottenPartitionIndexes.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.forgottenPartitionIndexes.add(readable.readInt());
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            if (version < 7) {
                throw new UnsupportedVersionException("Can't write version " + version + " of ForgottenTopic");
            }
            writable.writeString(name);
            writable.writeInt(forgottenPartitionIndexes.size());
            for (Integer element : forgottenPartitionIndexes) {
                writable.writeInt(element);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            if (version < 7) {
                throw new UnsupportedVersionException("Can't read version " + version + " of ForgottenTopic");
            }
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("forgotten_partition_indexes");
                this.forgottenPartitionIndexes = new ArrayList<Integer>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.forgottenPartitionIndexes.add((Integer) nestedObject);
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            if (version < 7) {
                throw new UnsupportedVersionException("Can't write version " + version + " of ForgottenTopic");
            }
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            {
                Integer[] nestedObjects = new Integer[forgottenPartitionIndexes.size()];
                int i = 0;
                for (Integer element : this.forgottenPartitionIndexes) {
                    nestedObjects[i++] = element;
                }
                struct.set("forgotten_partition_indexes", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            if (version < 7) {
                throw new UnsupportedVersionException("Can't size version " + version + " of ForgottenTopic");
            }
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            size += 4;
            size += forgottenPartitionIndexes.size() * 4;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ForgottenTopic)) return false;
            ForgottenTopic other = (ForgottenTopic) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (this.forgottenPartitionIndexes == null) {
                if (other.forgottenPartitionIndexes != null) return false;
            } else {
                if (!this.forgottenPartitionIndexes.equals(other.forgottenPartitionIndexes)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + (forgottenPartitionIndexes == null ? 0 : forgottenPartitionIndexes.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "ForgottenTopic("
                + "name='" + name + "'"
                + ", forgottenPartitionIndexes=" + MessageUtil.deepToString(forgottenPartitionIndexes.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<Integer> forgottenPartitionIndexes() {
            return this.forgottenPartitionIndexes;
        }
        
        public ForgottenTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public ForgottenTopic setForgottenPartitionIndexes(List<Integer> v) {
            this.forgottenPartitionIndexes = v;
            return this;
        }
    }
}
