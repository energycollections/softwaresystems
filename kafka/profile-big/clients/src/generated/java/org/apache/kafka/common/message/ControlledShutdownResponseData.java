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

import java.util.Iterator;
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
import org.apache.kafka.common.utils.ImplicitLinkedHashMultiSet;


public class ControlledShutdownResponseData implements ApiMessage {
    private short errorCode;
    private RemainingPartitionSet remainingPartitions;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("error_code", Type.INT16, "The top-level error code."),
            new Field("remaining_partitions", new ArrayOf(RemainingPartition.SCHEMA_0), "The partitions that the broker still leads.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2
    };
    
    public ControlledShutdownResponseData(Readable readable, short version) {
        this.remainingPartitions = new RemainingPartitionSet(0);
        read(readable, version);
    }
    
    public ControlledShutdownResponseData(Struct struct, short version) {
        this.remainingPartitions = new RemainingPartitionSet(0);
        fromStruct(struct, version);
    }
    
    public ControlledShutdownResponseData() {
        this.errorCode = (short) 0;
        this.remainingPartitions = new RemainingPartitionSet(0);
    }
    
    @Override
    public short apiKey() {
        return 7;
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
        this.errorCode = readable.readShort();
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.remainingPartitions.clear(0);
            } else {
                this.remainingPartitions.clear(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    this.remainingPartitions.add(new RemainingPartition(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeShort(errorCode);
        writable.writeInt(remainingPartitions.size());
        for (RemainingPartition element : remainingPartitions) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.errorCode = struct.getShort("error_code");
        {
            Object[] nestedObjects = struct.getArray("remaining_partitions");
            this.remainingPartitions = new RemainingPartitionSet(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.remainingPartitions.add(new RemainingPartition((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("error_code", this.errorCode);
        {
            Struct[] nestedObjects = new Struct[remainingPartitions.size()];
            int i = 0;
            for (RemainingPartition element : this.remainingPartitions) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("remaining_partitions", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 2;
        size += 4;
        for (RemainingPartition element : remainingPartitions) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ControlledShutdownResponseData)) return false;
        ControlledShutdownResponseData other = (ControlledShutdownResponseData) obj;
        if (errorCode != other.errorCode) return false;
        if (this.remainingPartitions == null) {
            if (other.remainingPartitions != null) return false;
        } else {
            if (!this.remainingPartitions.equals(other.remainingPartitions)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + errorCode;
        hashCode = 31 * hashCode + (remainingPartitions == null ? 0 : remainingPartitions.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "ControlledShutdownResponseData("
            + "errorCode=" + errorCode
            + ", remainingPartitions=" + MessageUtil.deepToString(remainingPartitions.iterator())
            + ")";
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public RemainingPartitionSet remainingPartitions() {
        return this.remainingPartitions;
    }
    
    public ControlledShutdownResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    public ControlledShutdownResponseData setRemainingPartitions(RemainingPartitionSet v) {
        this.remainingPartitions = v;
        return this;
    }
    
    static public class RemainingPartition implements Message, ImplicitLinkedHashMultiSet.Element {
        private String topicName;
        private int partitionIndex;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("topic_name", Type.STRING, "The name of the topic."),
                new Field("partition_index", Type.INT32, "The index of the partition.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public RemainingPartition(Readable readable, short version) {
            read(readable, version);
        }
        
        public RemainingPartition(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public RemainingPartition() {
            this.topicName = "";
            this.partitionIndex = 0;
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
            this.topicName = readable.readNullableString();
            this.partitionIndex = readable.readInt();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(topicName);
            writable.writeInt(partitionIndex);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.topicName = struct.getString("topic_name");
            this.partitionIndex = struct.getInt("partition_index");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("topic_name", this.topicName);
            struct.set("partition_index", this.partitionIndex);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(topicName);
            size += 4;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof RemainingPartition)) return false;
            RemainingPartition other = (RemainingPartition) obj;
            if (this.topicName == null) {
                if (other.topicName != null) return false;
            } else {
                if (!this.topicName.equals(other.topicName)) return false;
            }
            if (partitionIndex != other.partitionIndex) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (topicName == null ? 0 : topicName.hashCode());
            hashCode = 31 * hashCode + partitionIndex;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "RemainingPartition("
                + "topicName='" + topicName + "'"
                + ", partitionIndex=" + partitionIndex
                + ")";
        }
        
        public String topicName() {
            return this.topicName;
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        @Override
        public int next() {
            return this.next;
        }
        
        @Override
        public int prev() {
            return this.prev;
        }
        
        public RemainingPartition setTopicName(String v) {
            this.topicName = v;
            return this;
        }
        
        public RemainingPartition setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        @Override
        public void setNext(int v) {
            this.next = v;
        }
        
        @Override
        public void setPrev(int v) {
            this.prev = v;
        }
    }
    
    public static class RemainingPartitionSet extends ImplicitLinkedHashMultiSet<RemainingPartition> {
        public RemainingPartitionSet() {
            super();
        }
        
        public RemainingPartitionSet(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public RemainingPartitionSet(Iterator<RemainingPartition> iterator) {
            super(iterator);
        }
        
        public RemainingPartition find(String topicName, int partitionIndex) {
            RemainingPartition key = new RemainingPartition();
            key.setTopicName(topicName);
            key.setPartitionIndex(partitionIndex);
            return find(key);
        }
        
        public List<RemainingPartition> findAll(String topicName, int partitionIndex) {
            RemainingPartition key = new RemainingPartition();
            key.setTopicName(topicName);
            key.setPartitionIndex(partitionIndex);
            return findAll(key);
        }
        
    }
}
