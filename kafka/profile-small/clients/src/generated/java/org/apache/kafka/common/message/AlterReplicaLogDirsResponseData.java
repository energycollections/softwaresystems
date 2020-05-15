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


public class AlterReplicaLogDirsResponseData implements ApiMessage {
    private int throttleTimeMs;
    private List<AlterReplicaLogDirTopicResult> results;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "Duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("results", new ArrayOf(AlterReplicaLogDirTopicResult.SCHEMA_0), "The results for each topic.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public AlterReplicaLogDirsResponseData(Readable readable, short version) {
        this.results = new ArrayList<AlterReplicaLogDirTopicResult>();
        read(readable, version);
    }
    
    public AlterReplicaLogDirsResponseData(Struct struct, short version) {
        this.results = new ArrayList<AlterReplicaLogDirTopicResult>();
        fromStruct(struct, version);
    }
    
    public AlterReplicaLogDirsResponseData() {
        this.throttleTimeMs = 0;
        this.results = new ArrayList<AlterReplicaLogDirTopicResult>();
    }
    
    @Override
    public short apiKey() {
        return 34;
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
                    this.results.add(new AlterReplicaLogDirTopicResult(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(throttleTimeMs);
        writable.writeInt(results.size());
        for (AlterReplicaLogDirTopicResult element : results) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.throttleTimeMs = struct.getInt("throttle_time_ms");
        {
            Object[] nestedObjects = struct.getArray("results");
            this.results = new ArrayList<AlterReplicaLogDirTopicResult>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.results.add(new AlterReplicaLogDirTopicResult((Struct) nestedObject, version));
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
            for (AlterReplicaLogDirTopicResult element : this.results) {
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
        for (AlterReplicaLogDirTopicResult element : results) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AlterReplicaLogDirsResponseData)) return false;
        AlterReplicaLogDirsResponseData other = (AlterReplicaLogDirsResponseData) obj;
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
        return "AlterReplicaLogDirsResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", results=" + MessageUtil.deepToString(results.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public List<AlterReplicaLogDirTopicResult> results() {
        return this.results;
    }
    
    public AlterReplicaLogDirsResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public AlterReplicaLogDirsResponseData setResults(List<AlterReplicaLogDirTopicResult> v) {
        this.results = v;
        return this;
    }
    
    static public class AlterReplicaLogDirTopicResult implements Message {
        private String topicName;
        private List<AlterReplicaLogDirPartitionResult> partitions;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("topic_name", Type.STRING, "The name of the topic."),
                new Field("partitions", new ArrayOf(AlterReplicaLogDirPartitionResult.SCHEMA_0), "The results for each partition.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public AlterReplicaLogDirTopicResult(Readable readable, short version) {
            this.partitions = new ArrayList<AlterReplicaLogDirPartitionResult>();
            read(readable, version);
        }
        
        public AlterReplicaLogDirTopicResult(Struct struct, short version) {
            this.partitions = new ArrayList<AlterReplicaLogDirPartitionResult>();
            fromStruct(struct, version);
        }
        
        public AlterReplicaLogDirTopicResult() {
            this.topicName = "";
            this.partitions = new ArrayList<AlterReplicaLogDirPartitionResult>();
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
            this.topicName = readable.readNullableString();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.partitions.clear();
                } else {
                    this.partitions.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.partitions.add(new AlterReplicaLogDirPartitionResult(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(topicName);
            writable.writeInt(partitions.size());
            for (AlterReplicaLogDirPartitionResult element : partitions) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.topicName = struct.getString("topic_name");
            {
                Object[] nestedObjects = struct.getArray("partitions");
                this.partitions = new ArrayList<AlterReplicaLogDirPartitionResult>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitions.add(new AlterReplicaLogDirPartitionResult((Struct) nestedObject, version));
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("topic_name", this.topicName);
            {
                Struct[] nestedObjects = new Struct[partitions.size()];
                int i = 0;
                for (AlterReplicaLogDirPartitionResult element : this.partitions) {
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
            size += MessageUtil.serializedUtf8Length(topicName);
            size += 4;
            for (AlterReplicaLogDirPartitionResult element : partitions) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof AlterReplicaLogDirTopicResult)) return false;
            AlterReplicaLogDirTopicResult other = (AlterReplicaLogDirTopicResult) obj;
            if (this.topicName == null) {
                if (other.topicName != null) return false;
            } else {
                if (!this.topicName.equals(other.topicName)) return false;
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
            hashCode = 31 * hashCode + (topicName == null ? 0 : topicName.hashCode());
            hashCode = 31 * hashCode + (partitions == null ? 0 : partitions.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "AlterReplicaLogDirTopicResult("
                + "topicName='" + topicName + "'"
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String topicName() {
            return this.topicName;
        }
        
        public List<AlterReplicaLogDirPartitionResult> partitions() {
            return this.partitions;
        }
        
        public AlterReplicaLogDirTopicResult setTopicName(String v) {
            this.topicName = v;
            return this;
        }
        
        public AlterReplicaLogDirTopicResult setPartitions(List<AlterReplicaLogDirPartitionResult> v) {
            this.partitions = v;
            return this;
        }
    }
    
    static public class AlterReplicaLogDirPartitionResult implements Message {
        private int partitionIndex;
        private short errorCode;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no error.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public AlterReplicaLogDirPartitionResult(Readable readable, short version) {
            read(readable, version);
        }
        
        public AlterReplicaLogDirPartitionResult(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public AlterReplicaLogDirPartitionResult() {
            this.partitionIndex = 0;
            this.errorCode = (short) 0;
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
            this.errorCode = readable.readShort();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionIndex);
            writable.writeShort(errorCode);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionIndex = struct.getInt("partition_index");
            this.errorCode = struct.getShort("error_code");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_index", this.partitionIndex);
            struct.set("error_code", this.errorCode);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            size += 2;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof AlterReplicaLogDirPartitionResult)) return false;
            AlterReplicaLogDirPartitionResult other = (AlterReplicaLogDirPartitionResult) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (errorCode != other.errorCode) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + errorCode;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "AlterReplicaLogDirPartitionResult("
                + "partitionIndex=" + partitionIndex
                + ", errorCode=" + errorCode
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public AlterReplicaLogDirPartitionResult setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public AlterReplicaLogDirPartitionResult setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
    }
}
