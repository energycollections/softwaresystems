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


public class ProduceResponseData implements ApiMessage {
    private List<TopicProduceResponse> responses;
    private int throttleTimeMs;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("responses", new ArrayOf(TopicProduceResponse.SCHEMA_0), "Each produce response")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("responses", new ArrayOf(TopicProduceResponse.SCHEMA_0), "Each produce response"),
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota.")
        );
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("responses", new ArrayOf(TopicProduceResponse.SCHEMA_2), "Each produce response"),
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota.")
        );
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema SCHEMA_4 = SCHEMA_3;
    
    public static final Schema SCHEMA_5 =
        new Schema(
            new Field("responses", new ArrayOf(TopicProduceResponse.SCHEMA_5), "Each produce response"),
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota.")
        );
    
    public static final Schema SCHEMA_6 = SCHEMA_5;
    
    public static final Schema SCHEMA_7 = SCHEMA_6;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3,
        SCHEMA_4,
        SCHEMA_5,
        SCHEMA_6,
        SCHEMA_7
    };
    
    public ProduceResponseData(Readable readable, short version) {
        this.responses = new ArrayList<TopicProduceResponse>();
        read(readable, version);
    }
    
    public ProduceResponseData(Struct struct, short version) {
        this.responses = new ArrayList<TopicProduceResponse>();
        fromStruct(struct, version);
    }
    
    public ProduceResponseData() {
        this.responses = new ArrayList<TopicProduceResponse>();
        this.throttleTimeMs = 0;
    }
    
    @Override
    public short apiKey() {
        return 0;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 7;
    }
    
    @Override
    public void read(Readable readable, short version) {
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.responses.clear();
            } else {
                this.responses.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.responses.add(new TopicProduceResponse(readable, version));
                }
            }
        }
        if (version >= 1) {
            this.throttleTimeMs = readable.readInt();
        } else {
            this.throttleTimeMs = 0;
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(responses.size());
        for (TopicProduceResponse element : responses) {
            element.write(writable, version);
        }
        if (version >= 1) {
            writable.writeInt(throttleTimeMs);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        {
            Object[] nestedObjects = struct.getArray("responses");
            this.responses = new ArrayList<TopicProduceResponse>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.responses.add(new TopicProduceResponse((Struct) nestedObject, version));
            }
        }
        if (version >= 1) {
            this.throttleTimeMs = struct.getInt("throttle_time_ms");
        } else {
            this.throttleTimeMs = 0;
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        {
            Struct[] nestedObjects = new Struct[responses.size()];
            int i = 0;
            for (TopicProduceResponse element : this.responses) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("responses", (Object[]) nestedObjects);
        }
        if (version >= 1) {
            struct.set("throttle_time_ms", this.throttleTimeMs);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        for (TopicProduceResponse element : responses) {
            size += element.size(version);
        }
        if (version >= 1) {
            size += 4;
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ProduceResponseData)) return false;
        ProduceResponseData other = (ProduceResponseData) obj;
        if (this.responses == null) {
            if (other.responses != null) return false;
        } else {
            if (!this.responses.equals(other.responses)) return false;
        }
        if (throttleTimeMs != other.throttleTimeMs) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (responses == null ? 0 : responses.hashCode());
        hashCode = 31 * hashCode + throttleTimeMs;
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "ProduceResponseData("
            + "responses=" + MessageUtil.deepToString(responses.iterator())
            + ", throttleTimeMs=" + throttleTimeMs
            + ")";
    }
    
    public List<TopicProduceResponse> responses() {
        return this.responses;
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public ProduceResponseData setResponses(List<TopicProduceResponse> v) {
        this.responses = v;
        return this;
    }
    
    public ProduceResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    static public class TopicProduceResponse implements Message {
        private String name;
        private List<PartitionProduceResponse> partitions;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name"),
                new Field("partitions", new ArrayOf(PartitionProduceResponse.SCHEMA_0), "Each partition that we produced to within the topic.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("name", Type.STRING, "The topic name"),
                new Field("partitions", new ArrayOf(PartitionProduceResponse.SCHEMA_2), "Each partition that we produced to within the topic.")
            );
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("name", Type.STRING, "The topic name"),
                new Field("partitions", new ArrayOf(PartitionProduceResponse.SCHEMA_5), "Each partition that we produced to within the topic.")
            );
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5,
            SCHEMA_6,
            SCHEMA_7
        };
        
        public TopicProduceResponse(Readable readable, short version) {
            this.partitions = new ArrayList<PartitionProduceResponse>();
            read(readable, version);
        }
        
        public TopicProduceResponse(Struct struct, short version) {
            this.partitions = new ArrayList<PartitionProduceResponse>();
            fromStruct(struct, version);
        }
        
        public TopicProduceResponse() {
            this.name = "";
            this.partitions = new ArrayList<PartitionProduceResponse>();
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 7;
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
                        this.partitions.add(new PartitionProduceResponse(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(partitions.size());
            for (PartitionProduceResponse element : partitions) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partitions");
                this.partitions = new ArrayList<PartitionProduceResponse>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitions.add(new PartitionProduceResponse((Struct) nestedObject, version));
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
                for (PartitionProduceResponse element : this.partitions) {
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
            for (PartitionProduceResponse element : partitions) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof TopicProduceResponse)) return false;
            TopicProduceResponse other = (TopicProduceResponse) obj;
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
            return "TopicProduceResponse("
                + "name='" + name + "'"
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<PartitionProduceResponse> partitions() {
            return this.partitions;
        }
        
        public TopicProduceResponse setName(String v) {
            this.name = v;
            return this;
        }
        
        public TopicProduceResponse setPartitions(List<PartitionProduceResponse> v) {
            this.partitions = v;
            return this;
        }
    }
    
    static public class PartitionProduceResponse implements Message {
        private int partitionIndex;
        private short errorCode;
        private long baseOffset;
        private long logAppendTimeMs;
        private long logStartOffset;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
                new Field("base_offset", Type.INT64, "The base offset.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
                new Field("base_offset", Type.INT64, "The base offset."),
                new Field("log_append_time_ms", Type.INT64, "The timestamp returned by broker after appending the messages. If CreateTime is used for the topic, the timestamp will be -1.  If LogAppendTime is used for the topic, the timestamp will be the broker local time when the messages are appended.")
            );
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
                new Field("base_offset", Type.INT64, "The base offset."),
                new Field("log_append_time_ms", Type.INT64, "The timestamp returned by broker after appending the messages. If CreateTime is used for the topic, the timestamp will be -1.  If LogAppendTime is used for the topic, the timestamp will be the broker local time when the messages are appended."),
                new Field("log_start_offset", Type.INT64, "The log start offset.")
            );
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5,
            SCHEMA_6,
            SCHEMA_7
        };
        
        public PartitionProduceResponse(Readable readable, short version) {
            read(readable, version);
        }
        
        public PartitionProduceResponse(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public PartitionProduceResponse() {
            this.partitionIndex = 0;
            this.errorCode = (short) 0;
            this.baseOffset = 0L;
            this.logAppendTimeMs = -1L;
            this.logStartOffset = -1L;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 7;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.partitionIndex = readable.readInt();
            this.errorCode = readable.readShort();
            this.baseOffset = readable.readLong();
            if (version >= 2) {
                this.logAppendTimeMs = readable.readLong();
            } else {
                this.logAppendTimeMs = -1L;
            }
            if (version >= 5) {
                this.logStartOffset = readable.readLong();
            } else {
                this.logStartOffset = -1L;
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionIndex);
            writable.writeShort(errorCode);
            writable.writeLong(baseOffset);
            if (version >= 2) {
                writable.writeLong(logAppendTimeMs);
            }
            if (version >= 5) {
                writable.writeLong(logStartOffset);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionIndex = struct.getInt("partition_index");
            this.errorCode = struct.getShort("error_code");
            this.baseOffset = struct.getLong("base_offset");
            if (version >= 2) {
                this.logAppendTimeMs = struct.getLong("log_append_time_ms");
            } else {
                this.logAppendTimeMs = -1L;
            }
            if (version >= 5) {
                this.logStartOffset = struct.getLong("log_start_offset");
            } else {
                this.logStartOffset = -1L;
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_index", this.partitionIndex);
            struct.set("error_code", this.errorCode);
            struct.set("base_offset", this.baseOffset);
            if (version >= 2) {
                struct.set("log_append_time_ms", this.logAppendTimeMs);
            }
            if (version >= 5) {
                struct.set("log_start_offset", this.logStartOffset);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            size += 2;
            size += 8;
            if (version >= 2) {
                size += 8;
            }
            if (version >= 5) {
                size += 8;
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof PartitionProduceResponse)) return false;
            PartitionProduceResponse other = (PartitionProduceResponse) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (errorCode != other.errorCode) return false;
            if (baseOffset != other.baseOffset) return false;
            if (logAppendTimeMs != other.logAppendTimeMs) return false;
            if (logStartOffset != other.logStartOffset) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + errorCode;
            hashCode = 31 * hashCode + ((int) (baseOffset >> 32) ^ (int) baseOffset);
            hashCode = 31 * hashCode + ((int) (logAppendTimeMs >> 32) ^ (int) logAppendTimeMs);
            hashCode = 31 * hashCode + ((int) (logStartOffset >> 32) ^ (int) logStartOffset);
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "PartitionProduceResponse("
                + "partitionIndex=" + partitionIndex
                + ", errorCode=" + errorCode
                + ", baseOffset=" + baseOffset
                + ", logAppendTimeMs=" + logAppendTimeMs
                + ", logStartOffset=" + logStartOffset
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public long baseOffset() {
            return this.baseOffset;
        }
        
        public long logAppendTimeMs() {
            return this.logAppendTimeMs;
        }
        
        public long logStartOffset() {
            return this.logStartOffset;
        }
        
        public PartitionProduceResponse setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public PartitionProduceResponse setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public PartitionProduceResponse setBaseOffset(long v) {
            this.baseOffset = v;
            return this;
        }
        
        public PartitionProduceResponse setLogAppendTimeMs(long v) {
            this.logAppendTimeMs = v;
            return this;
        }
        
        public PartitionProduceResponse setLogStartOffset(long v) {
            this.logStartOffset = v;
            return this;
        }
    }
}
