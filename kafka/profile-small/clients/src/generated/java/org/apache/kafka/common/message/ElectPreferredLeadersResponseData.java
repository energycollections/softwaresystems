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


public class ElectPreferredLeadersResponseData implements ApiMessage {
    private int throttleTimeMs;
    private List<ReplicaElectionResult> replicaElectionResults;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("replica_election_results", new ArrayOf(ReplicaElectionResult.SCHEMA_0), "The error code, or 0 if there was no error.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0
    };
    
    public ElectPreferredLeadersResponseData(Readable readable, short version) {
        this.replicaElectionResults = new ArrayList<ReplicaElectionResult>();
        read(readable, version);
    }
    
    public ElectPreferredLeadersResponseData(Struct struct, short version) {
        this.replicaElectionResults = new ArrayList<ReplicaElectionResult>();
        fromStruct(struct, version);
    }
    
    public ElectPreferredLeadersResponseData() {
        this.throttleTimeMs = 0;
        this.replicaElectionResults = new ArrayList<ReplicaElectionResult>();
    }
    
    @Override
    public short apiKey() {
        return 43;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 0;
    }
    
    @Override
    public void read(Readable readable, short version) {
        this.throttleTimeMs = readable.readInt();
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.replicaElectionResults.clear();
            } else {
                this.replicaElectionResults.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.replicaElectionResults.add(new ReplicaElectionResult(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(throttleTimeMs);
        writable.writeInt(replicaElectionResults.size());
        for (ReplicaElectionResult element : replicaElectionResults) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.throttleTimeMs = struct.getInt("throttle_time_ms");
        {
            Object[] nestedObjects = struct.getArray("replica_election_results");
            this.replicaElectionResults = new ArrayList<ReplicaElectionResult>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.replicaElectionResults.add(new ReplicaElectionResult((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("throttle_time_ms", this.throttleTimeMs);
        {
            Struct[] nestedObjects = new Struct[replicaElectionResults.size()];
            int i = 0;
            for (ReplicaElectionResult element : this.replicaElectionResults) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("replica_election_results", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        size += 4;
        for (ReplicaElectionResult element : replicaElectionResults) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ElectPreferredLeadersResponseData)) return false;
        ElectPreferredLeadersResponseData other = (ElectPreferredLeadersResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (this.replicaElectionResults == null) {
            if (other.replicaElectionResults != null) return false;
        } else {
            if (!this.replicaElectionResults.equals(other.replicaElectionResults)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + (replicaElectionResults == null ? 0 : replicaElectionResults.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "ElectPreferredLeadersResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", replicaElectionResults=" + MessageUtil.deepToString(replicaElectionResults.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public List<ReplicaElectionResult> replicaElectionResults() {
        return this.replicaElectionResults;
    }
    
    public ElectPreferredLeadersResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public ElectPreferredLeadersResponseData setReplicaElectionResults(List<ReplicaElectionResult> v) {
        this.replicaElectionResults = v;
        return this;
    }
    
    static public class ReplicaElectionResult implements Message {
        private String topic;
        private List<PartitionResult> partitionResult;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("topic", Type.STRING, "The topic name"),
                new Field("partition_result", new ArrayOf(PartitionResult.SCHEMA_0), "The results for each partition")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0
        };
        
        public ReplicaElectionResult(Readable readable, short version) {
            this.partitionResult = new ArrayList<PartitionResult>();
            read(readable, version);
        }
        
        public ReplicaElectionResult(Struct struct, short version) {
            this.partitionResult = new ArrayList<PartitionResult>();
            fromStruct(struct, version);
        }
        
        public ReplicaElectionResult() {
            this.topic = "";
            this.partitionResult = new ArrayList<PartitionResult>();
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 0;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.topic = readable.readNullableString();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.partitionResult.clear();
                } else {
                    this.partitionResult.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.partitionResult.add(new PartitionResult(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(topic);
            writable.writeInt(partitionResult.size());
            for (PartitionResult element : partitionResult) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.topic = struct.getString("topic");
            {
                Object[] nestedObjects = struct.getArray("partition_result");
                this.partitionResult = new ArrayList<PartitionResult>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitionResult.add(new PartitionResult((Struct) nestedObject, version));
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("topic", this.topic);
            {
                Struct[] nestedObjects = new Struct[partitionResult.size()];
                int i = 0;
                for (PartitionResult element : this.partitionResult) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("partition_result", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(topic);
            size += 4;
            for (PartitionResult element : partitionResult) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ReplicaElectionResult)) return false;
            ReplicaElectionResult other = (ReplicaElectionResult) obj;
            if (this.topic == null) {
                if (other.topic != null) return false;
            } else {
                if (!this.topic.equals(other.topic)) return false;
            }
            if (this.partitionResult == null) {
                if (other.partitionResult != null) return false;
            } else {
                if (!this.partitionResult.equals(other.partitionResult)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (topic == null ? 0 : topic.hashCode());
            hashCode = 31 * hashCode + (partitionResult == null ? 0 : partitionResult.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "ReplicaElectionResult("
                + "topic='" + topic + "'"
                + ", partitionResult=" + MessageUtil.deepToString(partitionResult.iterator())
                + ")";
        }
        
        public String topic() {
            return this.topic;
        }
        
        public List<PartitionResult> partitionResult() {
            return this.partitionResult;
        }
        
        public ReplicaElectionResult setTopic(String v) {
            this.topic = v;
            return this;
        }
        
        public ReplicaElectionResult setPartitionResult(List<PartitionResult> v) {
            this.partitionResult = v;
            return this;
        }
    }
    
    static public class PartitionResult implements Message {
        private int partitionId;
        private short errorCode;
        private String errorMessage;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_id", Type.INT32, "The partition id"),
                new Field("error_code", Type.INT16, "The result error, or zero if there was no error."),
                new Field("error_message", Type.NULLABLE_STRING, "The result message, or null if there was no error.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0
        };
        
        public PartitionResult(Readable readable, short version) {
            read(readable, version);
        }
        
        public PartitionResult(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public PartitionResult() {
            this.partitionId = 0;
            this.errorCode = (short) 0;
            this.errorMessage = "";
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 0;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.partitionId = readable.readInt();
            this.errorCode = readable.readShort();
            this.errorMessage = readable.readNullableString();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionId);
            writable.writeShort(errorCode);
            writable.writeNullableString(errorMessage);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionId = struct.getInt("partition_id");
            this.errorCode = struct.getShort("error_code");
            this.errorMessage = struct.getString("error_message");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_id", this.partitionId);
            struct.set("error_code", this.errorCode);
            struct.set("error_message", this.errorMessage);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            size += 2;
            size += 2;
            if (errorMessage != null) {
                size += MessageUtil.serializedUtf8Length(errorMessage);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof PartitionResult)) return false;
            PartitionResult other = (PartitionResult) obj;
            if (partitionId != other.partitionId) return false;
            if (errorCode != other.errorCode) return false;
            if (this.errorMessage == null) {
                if (other.errorMessage != null) return false;
            } else {
                if (!this.errorMessage.equals(other.errorMessage)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionId;
            hashCode = 31 * hashCode + errorCode;
            hashCode = 31 * hashCode + (errorMessage == null ? 0 : errorMessage.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "PartitionResult("
                + "partitionId=" + partitionId
                + ", errorCode=" + errorCode
                + ", errorMessage='" + errorMessage + "'"
                + ")";
        }
        
        public int partitionId() {
            return this.partitionId;
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public String errorMessage() {
            return this.errorMessage;
        }
        
        public PartitionResult setPartitionId(int v) {
            this.partitionId = v;
            return this;
        }
        
        public PartitionResult setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public PartitionResult setErrorMessage(String v) {
            this.errorMessage = v;
            return this;
        }
    }
}
