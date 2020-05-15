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
import java.util.Arrays;
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
import org.apache.kafka.common.utils.Bytes;


public class FetchResponseData implements ApiMessage {
    private int throttleTimeMs;
    private short errorCode;
    private int sessionId;
    private List<FetchableTopicResponse> topics;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topics", new ArrayOf(FetchableTopicResponse.SCHEMA_0), "The response topics.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("topics", new ArrayOf(FetchableTopicResponse.SCHEMA_0), "The response topics.")
        );
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema SCHEMA_4 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("topics", new ArrayOf(FetchableTopicResponse.SCHEMA_4), "The response topics.")
        );
    
    public static final Schema SCHEMA_5 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("topics", new ArrayOf(FetchableTopicResponse.SCHEMA_5), "The response topics.")
        );
    
    public static final Schema SCHEMA_6 = SCHEMA_5;
    
    public static final Schema SCHEMA_7 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("error_code", Type.INT16, "The top level response error code."),
            new Field("session_id", Type.INT32, "The fetch session ID, or 0 if this is not part of a fetch session."),
            new Field("topics", new ArrayOf(FetchableTopicResponse.SCHEMA_5), "The response topics.")
        );
    
    public static final Schema SCHEMA_8 = SCHEMA_7;
    
    public static final Schema SCHEMA_9 = SCHEMA_8;
    
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
    
    public FetchResponseData(Readable readable, short version) {
        this.topics = new ArrayList<FetchableTopicResponse>();
        read(readable, version);
    }
    
    public FetchResponseData(Struct struct, short version) {
        this.topics = new ArrayList<FetchableTopicResponse>();
        fromStruct(struct, version);
    }
    
    public FetchResponseData() {
        this.throttleTimeMs = 0;
        this.errorCode = (short) 0;
        this.sessionId = 0;
        this.topics = new ArrayList<FetchableTopicResponse>();
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
        if (version >= 1) {
            this.throttleTimeMs = readable.readInt();
        } else {
            this.throttleTimeMs = 0;
        }
        if (version >= 7) {
            this.errorCode = readable.readShort();
        } else {
            this.errorCode = (short) 0;
        }
        if (version >= 7) {
            this.sessionId = readable.readInt();
        } else {
            this.sessionId = 0;
        }
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topics.clear();
            } else {
                this.topics.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.topics.add(new FetchableTopicResponse(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        if (version >= 1) {
            writable.writeInt(throttleTimeMs);
        }
        if (version >= 7) {
            writable.writeShort(errorCode);
        }
        if (version >= 7) {
            writable.writeInt(sessionId);
        }
        writable.writeInt(topics.size());
        for (FetchableTopicResponse element : topics) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        if (version >= 1) {
            this.throttleTimeMs = struct.getInt("throttle_time_ms");
        } else {
            this.throttleTimeMs = 0;
        }
        if (version >= 7) {
            this.errorCode = struct.getShort("error_code");
        } else {
            this.errorCode = (short) 0;
        }
        if (version >= 7) {
            this.sessionId = struct.getInt("session_id");
        } else {
            this.sessionId = 0;
        }
        {
            Object[] nestedObjects = struct.getArray("topics");
            this.topics = new ArrayList<FetchableTopicResponse>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topics.add(new FetchableTopicResponse((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        if (version >= 1) {
            struct.set("throttle_time_ms", this.throttleTimeMs);
        }
        if (version >= 7) {
            struct.set("error_code", this.errorCode);
        }
        if (version >= 7) {
            struct.set("session_id", this.sessionId);
        }
        {
            Struct[] nestedObjects = new Struct[topics.size()];
            int i = 0;
            for (FetchableTopicResponse element : this.topics) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("topics", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        if (version >= 1) {
            size += 4;
        }
        if (version >= 7) {
            size += 2;
        } else {
            if (errorCode != (short) 0) {
                throw new UnsupportedVersionException("Attempted to write a non-default errorCode at version " + version);
            }
        }
        if (version >= 7) {
            size += 4;
        } else {
            if (sessionId != 0) {
                throw new UnsupportedVersionException("Attempted to write a non-default sessionId at version " + version);
            }
        }
        size += 4;
        for (FetchableTopicResponse element : topics) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FetchResponseData)) return false;
        FetchResponseData other = (FetchResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (errorCode != other.errorCode) return false;
        if (sessionId != other.sessionId) return false;
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
        hashCode = 31 * hashCode + errorCode;
        hashCode = 31 * hashCode + sessionId;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "FetchResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", errorCode=" + errorCode
            + ", sessionId=" + sessionId
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public int sessionId() {
        return this.sessionId;
    }
    
    public List<FetchableTopicResponse> topics() {
        return this.topics;
    }
    
    public FetchResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public FetchResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    public FetchResponseData setSessionId(int v) {
        this.sessionId = v;
        return this;
    }
    
    public FetchResponseData setTopics(List<FetchableTopicResponse> v) {
        this.topics = v;
        return this;
    }
    
    static public class FetchableTopicResponse implements Message {
        private String name;
        private List<FetchablePartitionResponse> partitions;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(FetchablePartitionResponse.SCHEMA_0), "The topic partitions.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(FetchablePartitionResponse.SCHEMA_4), "The topic partitions.")
            );
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(FetchablePartitionResponse.SCHEMA_5), "The topic partitions.")
            );
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
        public static final Schema SCHEMA_8 = SCHEMA_7;
        
        public static final Schema SCHEMA_9 = SCHEMA_8;
        
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
        
        public FetchableTopicResponse(Readable readable, short version) {
            this.partitions = new ArrayList<FetchablePartitionResponse>();
            read(readable, version);
        }
        
        public FetchableTopicResponse(Struct struct, short version) {
            this.partitions = new ArrayList<FetchablePartitionResponse>();
            fromStruct(struct, version);
        }
        
        public FetchableTopicResponse() {
            this.name = "";
            this.partitions = new ArrayList<FetchablePartitionResponse>();
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
                    this.partitions.clear();
                } else {
                    this.partitions.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.partitions.add(new FetchablePartitionResponse(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(partitions.size());
            for (FetchablePartitionResponse element : partitions) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partitions");
                this.partitions = new ArrayList<FetchablePartitionResponse>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitions.add(new FetchablePartitionResponse((Struct) nestedObject, version));
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
                for (FetchablePartitionResponse element : this.partitions) {
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
            for (FetchablePartitionResponse element : partitions) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof FetchableTopicResponse)) return false;
            FetchableTopicResponse other = (FetchableTopicResponse) obj;
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
            return "FetchableTopicResponse("
                + "name='" + name + "'"
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<FetchablePartitionResponse> partitions() {
            return this.partitions;
        }
        
        public FetchableTopicResponse setName(String v) {
            this.name = v;
            return this;
        }
        
        public FetchableTopicResponse setPartitions(List<FetchablePartitionResponse> v) {
            this.partitions = v;
            return this;
        }
    }
    
    static public class FetchablePartitionResponse implements Message {
        private int partitionIndex;
        private short errorCode;
        private long highWatermark;
        private long lastStableOffset;
        private long logStartOffset;
        private List<AbortedTransaction> aborted;
        private byte[] records;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partiiton index."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no fetch error."),
                new Field("high_watermark", Type.INT64, "The current high water mark."),
                new Field("records", Type.NULLABLE_BYTES, "The record data.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partiiton index."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no fetch error."),
                new Field("high_watermark", Type.INT64, "The current high water mark."),
                new Field("last_stable_offset", Type.INT64, "The last stable offset (or LSO) of the partition. This is the last offset such that the state of all transactional records prior to this offset have been decided (ABORTED or COMMITTED)"),
                new Field("aborted", ArrayOf.nullable(AbortedTransaction.SCHEMA_4), "The aborted transactions."),
                new Field("records", Type.NULLABLE_BYTES, "The record data.")
            );
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partiiton index."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no fetch error."),
                new Field("high_watermark", Type.INT64, "The current high water mark."),
                new Field("last_stable_offset", Type.INT64, "The last stable offset (or LSO) of the partition. This is the last offset such that the state of all transactional records prior to this offset have been decided (ABORTED or COMMITTED)"),
                new Field("log_start_offset", Type.INT64, "The current log start offset."),
                new Field("aborted", ArrayOf.nullable(AbortedTransaction.SCHEMA_4), "The aborted transactions."),
                new Field("records", Type.NULLABLE_BYTES, "The record data.")
            );
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
        public static final Schema SCHEMA_8 = SCHEMA_7;
        
        public static final Schema SCHEMA_9 = SCHEMA_8;
        
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
        
        public FetchablePartitionResponse(Readable readable, short version) {
            this.aborted = new ArrayList<AbortedTransaction>();
            read(readable, version);
        }
        
        public FetchablePartitionResponse(Struct struct, short version) {
            this.aborted = new ArrayList<AbortedTransaction>();
            fromStruct(struct, version);
        }
        
        public FetchablePartitionResponse() {
            this.partitionIndex = 0;
            this.errorCode = (short) 0;
            this.highWatermark = 0L;
            this.lastStableOffset = -1L;
            this.logStartOffset = -1L;
            this.aborted = new ArrayList<AbortedTransaction>();
            this.records = Bytes.EMPTY;
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
            this.errorCode = readable.readShort();
            this.highWatermark = readable.readLong();
            if (version >= 4) {
                this.lastStableOffset = readable.readLong();
            } else {
                this.lastStableOffset = -1L;
            }
            if (version >= 5) {
                this.logStartOffset = readable.readLong();
            } else {
                this.logStartOffset = -1L;
            }
            if (version >= 4) {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.aborted.clear();
                } else {
                    this.aborted.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.aborted.add(new AbortedTransaction(readable, version));
                    }
                }
            } else {
                this.aborted = new ArrayList<AbortedTransaction>();
            }
            this.records = readable.readNullableBytes();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionIndex);
            writable.writeShort(errorCode);
            writable.writeLong(highWatermark);
            if (version >= 4) {
                writable.writeLong(lastStableOffset);
            }
            if (version >= 5) {
                writable.writeLong(logStartOffset);
            }
            if (version >= 4) {
                if (aborted == null) {
                    writable.writeInt(-1);
                } else {
                    writable.writeInt(aborted.size());
                    for (AbortedTransaction element : aborted) {
                        element.write(writable, version);
                    }
                }
            }
            writable.writeNullableBytes(records);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionIndex = struct.getInt("partition_index");
            this.errorCode = struct.getShort("error_code");
            this.highWatermark = struct.getLong("high_watermark");
            if (version >= 4) {
                this.lastStableOffset = struct.getLong("last_stable_offset");
            } else {
                this.lastStableOffset = -1L;
            }
            if (version >= 5) {
                this.logStartOffset = struct.getLong("log_start_offset");
            } else {
                this.logStartOffset = -1L;
            }
            if (version >= 4) {
                Object[] nestedObjects = struct.getArray("aborted");
                if (nestedObjects == null) {
                    this.aborted = null;
                } else {
                    this.aborted = new ArrayList<AbortedTransaction>(nestedObjects.length);
                    for (Object nestedObject : nestedObjects) {
                        this.aborted.add(new AbortedTransaction((Struct) nestedObject, version));
                    }
                }
            } else {
                this.aborted = new ArrayList<AbortedTransaction>();
            }
            this.records = struct.getByteArray("records");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_index", this.partitionIndex);
            struct.set("error_code", this.errorCode);
            struct.set("high_watermark", this.highWatermark);
            if (version >= 4) {
                struct.set("last_stable_offset", this.lastStableOffset);
            }
            if (version >= 5) {
                struct.set("log_start_offset", this.logStartOffset);
            }
            if (version >= 4) {
                if (aborted == null) {
                    struct.set("aborted", null);
                } else {
                    Struct[] nestedObjects = new Struct[aborted.size()];
                    int i = 0;
                    for (AbortedTransaction element : this.aborted) {
                        nestedObjects[i++] = element.toStruct(version);
                    }
                    struct.set("aborted", (Object[]) nestedObjects);
                }
            }
            struct.setByteArray("records", this.records);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            size += 2;
            size += 8;
            if (version >= 4) {
                size += 8;
            }
            if (version >= 5) {
                size += 8;
            }
            if (version >= 4) {
                if (aborted == null) {
                    size += 4;
                } else {
                    size += 4;
                    for (AbortedTransaction element : aborted) {
                        size += element.size(version);
                    }
                }
            } else {
                if (!aborted.isEmpty()) {
                    throw new UnsupportedVersionException("Attempted to write a non-default aborted at version " + version);
                }
            }
            size += 4;
            if (records != null) {
                size += records.length;
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof FetchablePartitionResponse)) return false;
            FetchablePartitionResponse other = (FetchablePartitionResponse) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (errorCode != other.errorCode) return false;
            if (highWatermark != other.highWatermark) return false;
            if (lastStableOffset != other.lastStableOffset) return false;
            if (logStartOffset != other.logStartOffset) return false;
            if (this.aborted == null) {
                if (other.aborted != null) return false;
            } else {
                if (!this.aborted.equals(other.aborted)) return false;
            }
            if (!Arrays.equals(this.records, other.records)) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + errorCode;
            hashCode = 31 * hashCode + ((int) (highWatermark >> 32) ^ (int) highWatermark);
            hashCode = 31 * hashCode + ((int) (lastStableOffset >> 32) ^ (int) lastStableOffset);
            hashCode = 31 * hashCode + ((int) (logStartOffset >> 32) ^ (int) logStartOffset);
            hashCode = 31 * hashCode + (aborted == null ? 0 : aborted.hashCode());
            hashCode = 31 * hashCode + Arrays.hashCode(records);
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "FetchablePartitionResponse("
                + "partitionIndex=" + partitionIndex
                + ", errorCode=" + errorCode
                + ", highWatermark=" + highWatermark
                + ", lastStableOffset=" + lastStableOffset
                + ", logStartOffset=" + logStartOffset
                + ", aborted=" + MessageUtil.deepToString(aborted.iterator())
                + ", records=" + Arrays.toString(records)
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public long highWatermark() {
            return this.highWatermark;
        }
        
        public long lastStableOffset() {
            return this.lastStableOffset;
        }
        
        public long logStartOffset() {
            return this.logStartOffset;
        }
        
        public List<AbortedTransaction> aborted() {
            return this.aborted;
        }
        
        public byte[] records() {
            return this.records;
        }
        
        public FetchablePartitionResponse setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public FetchablePartitionResponse setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public FetchablePartitionResponse setHighWatermark(long v) {
            this.highWatermark = v;
            return this;
        }
        
        public FetchablePartitionResponse setLastStableOffset(long v) {
            this.lastStableOffset = v;
            return this;
        }
        
        public FetchablePartitionResponse setLogStartOffset(long v) {
            this.logStartOffset = v;
            return this;
        }
        
        public FetchablePartitionResponse setAborted(List<AbortedTransaction> v) {
            this.aborted = v;
            return this;
        }
        
        public FetchablePartitionResponse setRecords(byte[] v) {
            this.records = v;
            return this;
        }
    }
    
    static public class AbortedTransaction implements Message {
        private long producerId;
        private long firstOffset;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("producer_id", Type.INT64, "The producer id associated with the aborted transaction."),
                new Field("first_offset", Type.INT64, "The first offset in the aborted transaction.")
            );
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
        public static final Schema SCHEMA_8 = SCHEMA_7;
        
        public static final Schema SCHEMA_9 = SCHEMA_8;
        
        public static final Schema SCHEMA_10 = SCHEMA_9;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            null,
            null,
            null,
            SCHEMA_4,
            SCHEMA_5,
            SCHEMA_6,
            SCHEMA_7,
            SCHEMA_8,
            SCHEMA_9,
            SCHEMA_10
        };
        
        public AbortedTransaction(Readable readable, short version) {
            read(readable, version);
        }
        
        public AbortedTransaction(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public AbortedTransaction() {
            this.producerId = 0L;
            this.firstOffset = 0L;
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
            if (version < 4) {
                throw new UnsupportedVersionException("Can't read version " + version + " of AbortedTransaction");
            }
            this.producerId = readable.readLong();
            this.firstOffset = readable.readLong();
        }
        
        @Override
        public void write(Writable writable, short version) {
            if (version < 4) {
                throw new UnsupportedVersionException("Can't write version " + version + " of AbortedTransaction");
            }
            writable.writeLong(producerId);
            writable.writeLong(firstOffset);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            if (version < 4) {
                throw new UnsupportedVersionException("Can't read version " + version + " of AbortedTransaction");
            }
            this.producerId = struct.getLong("producer_id");
            this.firstOffset = struct.getLong("first_offset");
        }
        
        @Override
        public Struct toStruct(short version) {
            if (version < 4) {
                throw new UnsupportedVersionException("Can't write version " + version + " of AbortedTransaction");
            }
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("producer_id", this.producerId);
            struct.set("first_offset", this.firstOffset);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            if (version < 4) {
                throw new UnsupportedVersionException("Can't size version " + version + " of AbortedTransaction");
            }
            size += 8;
            size += 8;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof AbortedTransaction)) return false;
            AbortedTransaction other = (AbortedTransaction) obj;
            if (producerId != other.producerId) return false;
            if (firstOffset != other.firstOffset) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + ((int) (producerId >> 32) ^ (int) producerId);
            hashCode = 31 * hashCode + ((int) (firstOffset >> 32) ^ (int) firstOffset);
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "AbortedTransaction("
                + "producerId=" + producerId
                + ", firstOffset=" + firstOffset
                + ")";
        }
        
        public long producerId() {
            return this.producerId;
        }
        
        public long firstOffset() {
            return this.firstOffset;
        }
        
        public AbortedTransaction setProducerId(long v) {
            this.producerId = v;
            return this;
        }
        
        public AbortedTransaction setFirstOffset(long v) {
            this.firstOffset = v;
            return this;
        }
    }
}
