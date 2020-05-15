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


public class StopReplicaResponseData implements ApiMessage {
    private short errorCode;
    private List<StopReplicaResponsePartition> partitions;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("error_code", Type.INT16, "The top-level error code, or 0 if there was no top-level error."),
            new Field("partitions", new ArrayOf(StopReplicaResponsePartition.SCHEMA_0), "The responses for each partition.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public StopReplicaResponseData(Readable readable, short version) {
        this.partitions = new ArrayList<StopReplicaResponsePartition>();
        read(readable, version);
    }
    
    public StopReplicaResponseData(Struct struct, short version) {
        this.partitions = new ArrayList<StopReplicaResponsePartition>();
        fromStruct(struct, version);
    }
    
    public StopReplicaResponseData() {
        this.errorCode = (short) 0;
        this.partitions = new ArrayList<StopReplicaResponsePartition>();
    }
    
    @Override
    public short apiKey() {
        return 5;
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
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.partitions.clear();
            } else {
                this.partitions.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.partitions.add(new StopReplicaResponsePartition(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeShort(errorCode);
        writable.writeInt(partitions.size());
        for (StopReplicaResponsePartition element : partitions) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.errorCode = struct.getShort("error_code");
        {
            Object[] nestedObjects = struct.getArray("partitions");
            this.partitions = new ArrayList<StopReplicaResponsePartition>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.partitions.add(new StopReplicaResponsePartition((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("error_code", this.errorCode);
        {
            Struct[] nestedObjects = new Struct[partitions.size()];
            int i = 0;
            for (StopReplicaResponsePartition element : this.partitions) {
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
        size += 4;
        for (StopReplicaResponsePartition element : partitions) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof StopReplicaResponseData)) return false;
        StopReplicaResponseData other = (StopReplicaResponseData) obj;
        if (errorCode != other.errorCode) return false;
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
        hashCode = 31 * hashCode + errorCode;
        hashCode = 31 * hashCode + (partitions == null ? 0 : partitions.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "StopReplicaResponseData("
            + "errorCode=" + errorCode
            + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
            + ")";
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public List<StopReplicaResponsePartition> partitions() {
        return this.partitions;
    }
    
    public StopReplicaResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    public StopReplicaResponseData setPartitions(List<StopReplicaResponsePartition> v) {
        this.partitions = v;
        return this;
    }
    
    static public class StopReplicaResponsePartition implements Message {
        private String topicName;
        private int partitionIndex;
        private short errorCode;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("topic_name", Type.STRING, "The topic name."),
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The partition error code, or 0 if there was no partition error.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public StopReplicaResponsePartition(Readable readable, short version) {
            read(readable, version);
        }
        
        public StopReplicaResponsePartition(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public StopReplicaResponsePartition() {
            this.topicName = "";
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
            this.topicName = readable.readNullableString();
            this.partitionIndex = readable.readInt();
            this.errorCode = readable.readShort();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(topicName);
            writable.writeInt(partitionIndex);
            writable.writeShort(errorCode);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.topicName = struct.getString("topic_name");
            this.partitionIndex = struct.getInt("partition_index");
            this.errorCode = struct.getShort("error_code");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("topic_name", this.topicName);
            struct.set("partition_index", this.partitionIndex);
            struct.set("error_code", this.errorCode);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(topicName);
            size += 4;
            size += 2;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof StopReplicaResponsePartition)) return false;
            StopReplicaResponsePartition other = (StopReplicaResponsePartition) obj;
            if (this.topicName == null) {
                if (other.topicName != null) return false;
            } else {
                if (!this.topicName.equals(other.topicName)) return false;
            }
            if (partitionIndex != other.partitionIndex) return false;
            if (errorCode != other.errorCode) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (topicName == null ? 0 : topicName.hashCode());
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + errorCode;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "StopReplicaResponsePartition("
                + "topicName='" + topicName + "'"
                + ", partitionIndex=" + partitionIndex
                + ", errorCode=" + errorCode
                + ")";
        }
        
        public String topicName() {
            return this.topicName;
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public StopReplicaResponsePartition setTopicName(String v) {
            this.topicName = v;
            return this;
        }
        
        public StopReplicaResponsePartition setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public StopReplicaResponsePartition setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
    }
}
