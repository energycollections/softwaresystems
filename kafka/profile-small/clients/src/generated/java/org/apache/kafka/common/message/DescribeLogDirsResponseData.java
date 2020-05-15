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


public class DescribeLogDirsResponseData implements ApiMessage {
    private int throttleTimeMs;
    private List<DescribeLogDirsResult> results;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("results", new ArrayOf(DescribeLogDirsResult.SCHEMA_0), "The log directories.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public DescribeLogDirsResponseData(Readable readable, short version) {
        this.results = new ArrayList<DescribeLogDirsResult>();
        read(readable, version);
    }
    
    public DescribeLogDirsResponseData(Struct struct, short version) {
        this.results = new ArrayList<DescribeLogDirsResult>();
        fromStruct(struct, version);
    }
    
    public DescribeLogDirsResponseData() {
        this.throttleTimeMs = 0;
        this.results = new ArrayList<DescribeLogDirsResult>();
    }
    
    @Override
    public short apiKey() {
        return 35;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 1;
    }
    
    @Override
    public void read(Readable readable, short version) {
        this.throttleTimeMs = readable.readInt();
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.results.clear();
            } else {
                this.results.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.results.add(new DescribeLogDirsResult(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(throttleTimeMs);
        writable.writeInt(results.size());
        for (DescribeLogDirsResult element : results) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.throttleTimeMs = struct.getInt("throttle_time_ms");
        {
            Object[] nestedObjects = struct.getArray("results");
            this.results = new ArrayList<DescribeLogDirsResult>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.results.add(new DescribeLogDirsResult((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("throttle_time_ms", this.throttleTimeMs);
        {
            Struct[] nestedObjects = new Struct[results.size()];
            int i = 0;
            for (DescribeLogDirsResult element : this.results) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("results", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        size += 4;
        for (DescribeLogDirsResult element : results) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DescribeLogDirsResponseData)) return false;
        DescribeLogDirsResponseData other = (DescribeLogDirsResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (this.results == null) {
            if (other.results != null) return false;
        } else {
            if (!this.results.equals(other.results)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + (results == null ? 0 : results.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "DescribeLogDirsResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", results=" + MessageUtil.deepToString(results.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public List<DescribeLogDirsResult> results() {
        return this.results;
    }
    
    public DescribeLogDirsResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public DescribeLogDirsResponseData setResults(List<DescribeLogDirsResult> v) {
        this.results = v;
        return this;
    }
    
    static public class DescribeLogDirsResult implements Message {
        private short errorCode;
        private String logDir;
        private List<DescribeLogDirsTopic> topics;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
                new Field("log_dir", Type.STRING, "The absolute log directory path."),
                new Field("topics", new ArrayOf(DescribeLogDirsTopic.SCHEMA_0), "Each topic.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public DescribeLogDirsResult(Readable readable, short version) {
            this.topics = new ArrayList<DescribeLogDirsTopic>();
            read(readable, version);
        }
        
        public DescribeLogDirsResult(Struct struct, short version) {
            this.topics = new ArrayList<DescribeLogDirsTopic>();
            fromStruct(struct, version);
        }
        
        public DescribeLogDirsResult() {
            this.errorCode = (short) 0;
            this.logDir = "";
            this.topics = new ArrayList<DescribeLogDirsTopic>();
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 1;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.errorCode = readable.readShort();
            this.logDir = readable.readNullableString();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.topics.clear();
                } else {
                    this.topics.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.topics.add(new DescribeLogDirsTopic(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeShort(errorCode);
            writable.writeString(logDir);
            writable.writeInt(topics.size());
            for (DescribeLogDirsTopic element : topics) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.errorCode = struct.getShort("error_code");
            this.logDir = struct.getString("log_dir");
            {
                Object[] nestedObjects = struct.getArray("topics");
                this.topics = new ArrayList<DescribeLogDirsTopic>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.topics.add(new DescribeLogDirsTopic((Struct) nestedObject, version));
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("error_code", this.errorCode);
            struct.set("log_dir", this.logDir);
            {
                Struct[] nestedObjects = new Struct[topics.size()];
                int i = 0;
                for (DescribeLogDirsTopic element : this.topics) {
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
            size += 2;
            size += MessageUtil.serializedUtf8Length(logDir);
            size += 4;
            for (DescribeLogDirsTopic element : topics) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DescribeLogDirsResult)) return false;
            DescribeLogDirsResult other = (DescribeLogDirsResult) obj;
            if (errorCode != other.errorCode) return false;
            if (this.logDir == null) {
                if (other.logDir != null) return false;
            } else {
                if (!this.logDir.equals(other.logDir)) return false;
            }
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
            hashCode = 31 * hashCode + errorCode;
            hashCode = 31 * hashCode + (logDir == null ? 0 : logDir.hashCode());
            hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DescribeLogDirsResult("
                + "errorCode=" + errorCode
                + ", logDir='" + logDir + "'"
                + ", topics=" + MessageUtil.deepToString(topics.iterator())
                + ")";
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public String logDir() {
            return this.logDir;
        }
        
        public List<DescribeLogDirsTopic> topics() {
            return this.topics;
        }
        
        public DescribeLogDirsResult setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public DescribeLogDirsResult setLogDir(String v) {
            this.logDir = v;
            return this;
        }
        
        public DescribeLogDirsResult setTopics(List<DescribeLogDirsTopic> v) {
            this.topics = v;
            return this;
        }
    }
    
    static public class DescribeLogDirsTopic implements Message {
        private String name;
        private List<DescribeLogDirsPartition> partitions;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(DescribeLogDirsPartition.SCHEMA_0), "")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public DescribeLogDirsTopic(Readable readable, short version) {
            this.partitions = new ArrayList<DescribeLogDirsPartition>();
            read(readable, version);
        }
        
        public DescribeLogDirsTopic(Struct struct, short version) {
            this.partitions = new ArrayList<DescribeLogDirsPartition>();
            fromStruct(struct, version);
        }
        
        public DescribeLogDirsTopic() {
            this.name = "";
            this.partitions = new ArrayList<DescribeLogDirsPartition>();
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 1;
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
                        this.partitions.add(new DescribeLogDirsPartition(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(partitions.size());
            for (DescribeLogDirsPartition element : partitions) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partitions");
                this.partitions = new ArrayList<DescribeLogDirsPartition>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitions.add(new DescribeLogDirsPartition((Struct) nestedObject, version));
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
                for (DescribeLogDirsPartition element : this.partitions) {
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
            for (DescribeLogDirsPartition element : partitions) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DescribeLogDirsTopic)) return false;
            DescribeLogDirsTopic other = (DescribeLogDirsTopic) obj;
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
            return "DescribeLogDirsTopic("
                + "name='" + name + "'"
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<DescribeLogDirsPartition> partitions() {
            return this.partitions;
        }
        
        public DescribeLogDirsTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public DescribeLogDirsTopic setPartitions(List<DescribeLogDirsPartition> v) {
            this.partitions = v;
            return this;
        }
    }
    
    static public class DescribeLogDirsPartition implements Message {
        private int partitionIndex;
        private long partitionSize;
        private long offsetLag;
        private boolean isFutureKey;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("partition_size", Type.INT64, "The size of the log segments in this partition in bytes."),
                new Field("offset_lag", Type.INT64, "The lag of the log's LEO w.r.t. partition's HW (if it is the current log for the partition) or current replica's LEO (if it is the future log for the partition)"),
                new Field("is_future_key", Type.BOOLEAN, "True if this log is created by AlterReplicaLogDirsRequest and will replace the current log of the replica in the future.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public DescribeLogDirsPartition(Readable readable, short version) {
            read(readable, version);
        }
        
        public DescribeLogDirsPartition(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public DescribeLogDirsPartition() {
            this.partitionIndex = 0;
            this.partitionSize = 0L;
            this.offsetLag = 0L;
            this.isFutureKey = false;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 1;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.partitionIndex = readable.readInt();
            this.partitionSize = readable.readLong();
            this.offsetLag = readable.readLong();
            this.isFutureKey = readable.readByte() != 0;
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionIndex);
            writable.writeLong(partitionSize);
            writable.writeLong(offsetLag);
            writable.writeByte(isFutureKey ? (byte) 1 : (byte) 0);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionIndex = struct.getInt("partition_index");
            this.partitionSize = struct.getLong("partition_size");
            this.offsetLag = struct.getLong("offset_lag");
            this.isFutureKey = struct.getBoolean("is_future_key");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_index", this.partitionIndex);
            struct.set("partition_size", this.partitionSize);
            struct.set("offset_lag", this.offsetLag);
            struct.set("is_future_key", this.isFutureKey);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            size += 8;
            size += 8;
            size += 1;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DescribeLogDirsPartition)) return false;
            DescribeLogDirsPartition other = (DescribeLogDirsPartition) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (partitionSize != other.partitionSize) return false;
            if (offsetLag != other.offsetLag) return false;
            if (isFutureKey != other.isFutureKey) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + ((int) (partitionSize >> 32) ^ (int) partitionSize);
            hashCode = 31 * hashCode + ((int) (offsetLag >> 32) ^ (int) offsetLag);
            hashCode = 31 * hashCode + (isFutureKey ? 1231 : 1237);
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DescribeLogDirsPartition("
                + "partitionIndex=" + partitionIndex
                + ", partitionSize=" + partitionSize
                + ", offsetLag=" + offsetLag
                + ", isFutureKey=" + (isFutureKey ? "true" : "false")
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public long partitionSize() {
            return this.partitionSize;
        }
        
        public long offsetLag() {
            return this.offsetLag;
        }
        
        public boolean isFutureKey() {
            return this.isFutureKey;
        }
        
        public DescribeLogDirsPartition setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public DescribeLogDirsPartition setPartitionSize(long v) {
            this.partitionSize = v;
            return this;
        }
        
        public DescribeLogDirsPartition setOffsetLag(long v) {
            this.offsetLag = v;
            return this;
        }
        
        public DescribeLogDirsPartition setIsFutureKey(boolean v) {
            this.isFutureKey = v;
            return this;
        }
    }
}
