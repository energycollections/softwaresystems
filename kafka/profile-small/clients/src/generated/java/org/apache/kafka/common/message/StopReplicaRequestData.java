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


public class StopReplicaRequestData implements ApiMessage {
    private int controllerId;
    private int controllerEpoch;
    private long brokerEpoch;
    private boolean deletePartitions;
    private List<StopReplicaRequestPartitionV0> partitionsV0;
    private List<StopReplicaRequestTopic> topics;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("delete_partitions", Type.BOOLEAN, "Whether these partitions should be deleted."),
            new Field("partitions_v0", new ArrayOf(StopReplicaRequestPartitionV0.SCHEMA_0), "The partitions to stop.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("broker_epoch", Type.INT64, "The broker epoch."),
            new Field("delete_partitions", Type.BOOLEAN, "Whether these partitions should be deleted."),
            new Field("topics", new ArrayOf(StopReplicaRequestTopic.SCHEMA_1), "The topics to stop.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public StopReplicaRequestData(Readable readable, short version) {
        this.partitionsV0 = new ArrayList<StopReplicaRequestPartitionV0>();
        this.topics = new ArrayList<StopReplicaRequestTopic>();
        read(readable, version);
    }
    
    public StopReplicaRequestData(Struct struct, short version) {
        this.partitionsV0 = new ArrayList<StopReplicaRequestPartitionV0>();
        this.topics = new ArrayList<StopReplicaRequestTopic>();
        fromStruct(struct, version);
    }
    
    public StopReplicaRequestData() {
        this.controllerId = 0;
        this.controllerEpoch = 0;
        this.brokerEpoch = -1L;
        this.deletePartitions = false;
        this.partitionsV0 = new ArrayList<StopReplicaRequestPartitionV0>();
        this.topics = new ArrayList<StopReplicaRequestTopic>();
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
        this.controllerId = readable.readInt();
        this.controllerEpoch = readable.readInt();
        if (version >= 1) {
            this.brokerEpoch = readable.readLong();
        } else {
            this.brokerEpoch = -1L;
        }
        this.deletePartitions = readable.readByte() != 0;
        if (version <= 0) {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.partitionsV0.clear();
            } else {
                this.partitionsV0.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.partitionsV0.add(new StopReplicaRequestPartitionV0(readable, version));
                }
            }
        } else {
            this.partitionsV0 = new ArrayList<StopReplicaRequestPartitionV0>();
        }
        if (version >= 1) {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topics.clear();
            } else {
                this.topics.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.topics.add(new StopReplicaRequestTopic(readable, version));
                }
            }
        } else {
            this.topics = new ArrayList<StopReplicaRequestTopic>();
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(controllerId);
        writable.writeInt(controllerEpoch);
        if (version >= 1) {
            writable.writeLong(brokerEpoch);
        }
        writable.writeByte(deletePartitions ? (byte) 1 : (byte) 0);
        if (version <= 0) {
            writable.writeInt(partitionsV0.size());
            for (StopReplicaRequestPartitionV0 element : partitionsV0) {
                element.write(writable, version);
            }
        }
        if (version >= 1) {
            writable.writeInt(topics.size());
            for (StopReplicaRequestTopic element : topics) {
                element.write(writable, version);
            }
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.controllerId = struct.getInt("controller_id");
        this.controllerEpoch = struct.getInt("controller_epoch");
        if (version >= 1) {
            this.brokerEpoch = struct.getLong("broker_epoch");
        } else {
            this.brokerEpoch = -1L;
        }
        this.deletePartitions = struct.getBoolean("delete_partitions");
        if (version <= 0) {
            Object[] nestedObjects = struct.getArray("partitions_v0");
            this.partitionsV0 = new ArrayList<StopReplicaRequestPartitionV0>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.partitionsV0.add(new StopReplicaRequestPartitionV0((Struct) nestedObject, version));
            }
        } else {
            this.partitionsV0 = new ArrayList<StopReplicaRequestPartitionV0>();
        }
        if (version >= 1) {
            Object[] nestedObjects = struct.getArray("topics");
            this.topics = new ArrayList<StopReplicaRequestTopic>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topics.add(new StopReplicaRequestTopic((Struct) nestedObject, version));
            }
        } else {
            this.topics = new ArrayList<StopReplicaRequestTopic>();
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("controller_id", this.controllerId);
        struct.set("controller_epoch", this.controllerEpoch);
        if (version >= 1) {
            struct.set("broker_epoch", this.brokerEpoch);
        }
        struct.set("delete_partitions", this.deletePartitions);
        if (version <= 0) {
            Struct[] nestedObjects = new Struct[partitionsV0.size()];
            int i = 0;
            for (StopReplicaRequestPartitionV0 element : this.partitionsV0) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("partitions_v0", (Object[]) nestedObjects);
        }
        if (version >= 1) {
            Struct[] nestedObjects = new Struct[topics.size()];
            int i = 0;
            for (StopReplicaRequestTopic element : this.topics) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("topics", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        size += 4;
        if (version >= 1) {
            size += 8;
        }
        size += 1;
        if (version <= 0) {
            size += 4;
            for (StopReplicaRequestPartitionV0 element : partitionsV0) {
                size += element.size(version);
            }
        } else {
            if (!partitionsV0.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default partitionsV0 at version " + version);
            }
        }
        if (version >= 1) {
            size += 4;
            for (StopReplicaRequestTopic element : topics) {
                size += element.size(version);
            }
        } else {
            if (!topics.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default topics at version " + version);
            }
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof StopReplicaRequestData)) return false;
        StopReplicaRequestData other = (StopReplicaRequestData) obj;
        if (controllerId != other.controllerId) return false;
        if (controllerEpoch != other.controllerEpoch) return false;
        if (brokerEpoch != other.brokerEpoch) return false;
        if (deletePartitions != other.deletePartitions) return false;
        if (this.partitionsV0 == null) {
            if (other.partitionsV0 != null) return false;
        } else {
            if (!this.partitionsV0.equals(other.partitionsV0)) return false;
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
        hashCode = 31 * hashCode + controllerId;
        hashCode = 31 * hashCode + controllerEpoch;
        hashCode = 31 * hashCode + ((int) (brokerEpoch >> 32) ^ (int) brokerEpoch);
        hashCode = 31 * hashCode + (deletePartitions ? 1231 : 1237);
        hashCode = 31 * hashCode + (partitionsV0 == null ? 0 : partitionsV0.hashCode());
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "StopReplicaRequestData("
            + "controllerId=" + controllerId
            + ", controllerEpoch=" + controllerEpoch
            + ", brokerEpoch=" + brokerEpoch
            + ", deletePartitions=" + (deletePartitions ? "true" : "false")
            + ", partitionsV0=" + MessageUtil.deepToString(partitionsV0.iterator())
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public int controllerId() {
        return this.controllerId;
    }
    
    public int controllerEpoch() {
        return this.controllerEpoch;
    }
    
    public long brokerEpoch() {
        return this.brokerEpoch;
    }
    
    public boolean deletePartitions() {
        return this.deletePartitions;
    }
    
    public List<StopReplicaRequestPartitionV0> partitionsV0() {
        return this.partitionsV0;
    }
    
    public List<StopReplicaRequestTopic> topics() {
        return this.topics;
    }
    
    public StopReplicaRequestData setControllerId(int v) {
        this.controllerId = v;
        return this;
    }
    
    public StopReplicaRequestData setControllerEpoch(int v) {
        this.controllerEpoch = v;
        return this;
    }
    
    public StopReplicaRequestData setBrokerEpoch(long v) {
        this.brokerEpoch = v;
        return this;
    }
    
    public StopReplicaRequestData setDeletePartitions(boolean v) {
        this.deletePartitions = v;
        return this;
    }
    
    public StopReplicaRequestData setPartitionsV0(List<StopReplicaRequestPartitionV0> v) {
        this.partitionsV0 = v;
        return this;
    }
    
    public StopReplicaRequestData setTopics(List<StopReplicaRequestTopic> v) {
        this.topics = v;
        return this;
    }
    
    static public class StopReplicaRequestPartitionV0 implements Message {
        private String topicName;
        private int partitionIndex;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("topic_name", Type.STRING, "The topic name."),
                new Field("partition_index", Type.INT32, "The partition index.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0
        };
        
        public StopReplicaRequestPartitionV0(Readable readable, short version) {
            read(readable, version);
        }
        
        public StopReplicaRequestPartitionV0(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public StopReplicaRequestPartitionV0() {
            this.topicName = "";
            this.partitionIndex = 0;
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
            if (version > 0) {
                throw new UnsupportedVersionException("Can't read version " + version + " of StopReplicaRequestPartitionV0");
            }
            this.topicName = readable.readNullableString();
            this.partitionIndex = readable.readInt();
        }
        
        @Override
        public void write(Writable writable, short version) {
            if (version > 0) {
                throw new UnsupportedVersionException("Can't write version " + version + " of StopReplicaRequestPartitionV0");
            }
            writable.writeString(topicName);
            writable.writeInt(partitionIndex);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            if (version > 0) {
                throw new UnsupportedVersionException("Can't read version " + version + " of StopReplicaRequestPartitionV0");
            }
            this.topicName = struct.getString("topic_name");
            this.partitionIndex = struct.getInt("partition_index");
        }
        
        @Override
        public Struct toStruct(short version) {
            if (version > 0) {
                throw new UnsupportedVersionException("Can't write version " + version + " of StopReplicaRequestPartitionV0");
            }
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("topic_name", this.topicName);
            struct.set("partition_index", this.partitionIndex);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            if (version > 0) {
                throw new UnsupportedVersionException("Can't size version " + version + " of StopReplicaRequestPartitionV0");
            }
            size += 2;
            size += MessageUtil.serializedUtf8Length(topicName);
            size += 4;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof StopReplicaRequestPartitionV0)) return false;
            StopReplicaRequestPartitionV0 other = (StopReplicaRequestPartitionV0) obj;
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
            return "StopReplicaRequestPartitionV0("
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
        
        public StopReplicaRequestPartitionV0 setTopicName(String v) {
            this.topicName = v;
            return this;
        }
        
        public StopReplicaRequestPartitionV0 setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
    }
    
    static public class StopReplicaRequestTopic implements Message {
        private String name;
        private List<Integer> partitionIndexes;
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partition_indexes", new ArrayOf(Type.INT32), "The partition indexes.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            SCHEMA_1
        };
        
        public StopReplicaRequestTopic(Readable readable, short version) {
            this.partitionIndexes = new ArrayList<Integer>();
            read(readable, version);
        }
        
        public StopReplicaRequestTopic(Struct struct, short version) {
            this.partitionIndexes = new ArrayList<Integer>();
            fromStruct(struct, version);
        }
        
        public StopReplicaRequestTopic() {
            this.name = "";
            this.partitionIndexes = new ArrayList<Integer>();
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
            if (version < 1) {
                throw new UnsupportedVersionException("Can't read version " + version + " of StopReplicaRequestTopic");
            }
            this.name = readable.readNullableString();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.partitionIndexes.clear();
                } else {
                    this.partitionIndexes.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.partitionIndexes.add(readable.readInt());
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            if (version < 1) {
                throw new UnsupportedVersionException("Can't write version " + version + " of StopReplicaRequestTopic");
            }
            writable.writeString(name);
            writable.writeInt(partitionIndexes.size());
            for (Integer element : partitionIndexes) {
                writable.writeInt(element);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            if (version < 1) {
                throw new UnsupportedVersionException("Can't read version " + version + " of StopReplicaRequestTopic");
            }
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partition_indexes");
                this.partitionIndexes = new ArrayList<Integer>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitionIndexes.add((Integer) nestedObject);
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            if (version < 1) {
                throw new UnsupportedVersionException("Can't write version " + version + " of StopReplicaRequestTopic");
            }
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            {
                Integer[] nestedObjects = new Integer[partitionIndexes.size()];
                int i = 0;
                for (Integer element : this.partitionIndexes) {
                    nestedObjects[i++] = element;
                }
                struct.set("partition_indexes", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            if (version < 1) {
                throw new UnsupportedVersionException("Can't size version " + version + " of StopReplicaRequestTopic");
            }
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            size += 4;
            size += partitionIndexes.size() * 4;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof StopReplicaRequestTopic)) return false;
            StopReplicaRequestTopic other = (StopReplicaRequestTopic) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (this.partitionIndexes == null) {
                if (other.partitionIndexes != null) return false;
            } else {
                if (!this.partitionIndexes.equals(other.partitionIndexes)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + (partitionIndexes == null ? 0 : partitionIndexes.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "StopReplicaRequestTopic("
                + "name='" + name + "'"
                + ", partitionIndexes=" + MessageUtil.deepToString(partitionIndexes.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<Integer> partitionIndexes() {
            return this.partitionIndexes;
        }
        
        public StopReplicaRequestTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public StopReplicaRequestTopic setPartitionIndexes(List<Integer> v) {
            this.partitionIndexes = v;
            return this;
        }
    }
}
