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


public class UpdateMetadataRequestData implements ApiMessage {
    private int controllerId;
    private int controllerEpoch;
    private long brokerEpoch;
    private List<UpdateMetadataRequestTopicState> topicStates;
    private List<UpdateMetadataRequestPartitionStateV0> partitionStatesV0;
    private List<UpdateMetadataRequestBroker> brokers;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("partition_states_v0", new ArrayOf(UpdateMetadataRequestPartitionStateV0.SCHEMA_0), "Each partition that we would like to update."),
            new Field("brokers", new ArrayOf(UpdateMetadataRequestBroker.SCHEMA_0), "")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("partition_states_v0", new ArrayOf(UpdateMetadataRequestPartitionStateV0.SCHEMA_0), "Each partition that we would like to update."),
            new Field("brokers", new ArrayOf(UpdateMetadataRequestBroker.SCHEMA_1), "")
        );
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("partition_states_v0", new ArrayOf(UpdateMetadataRequestPartitionStateV0.SCHEMA_0), "Each partition that we would like to update."),
            new Field("brokers", new ArrayOf(UpdateMetadataRequestBroker.SCHEMA_2), "")
        );
    
    public static final Schema SCHEMA_3 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("partition_states_v0", new ArrayOf(UpdateMetadataRequestPartitionStateV0.SCHEMA_0), "Each partition that we would like to update."),
            new Field("brokers", new ArrayOf(UpdateMetadataRequestBroker.SCHEMA_3), "")
        );
    
    public static final Schema SCHEMA_4 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("partition_states_v0", new ArrayOf(UpdateMetadataRequestPartitionStateV0.SCHEMA_4), "Each partition that we would like to update."),
            new Field("brokers", new ArrayOf(UpdateMetadataRequestBroker.SCHEMA_3), "")
        );
    
    public static final Schema SCHEMA_5 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("broker_epoch", Type.INT64, "The broker epoch."),
            new Field("topic_states", new ArrayOf(UpdateMetadataRequestTopicState.SCHEMA_5), "Each topic that we would like to update."),
            new Field("brokers", new ArrayOf(UpdateMetadataRequestBroker.SCHEMA_3), "")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3,
        SCHEMA_4,
        SCHEMA_5
    };
    
    public UpdateMetadataRequestData(Readable readable, short version) {
        this.topicStates = new ArrayList<UpdateMetadataRequestTopicState>();
        this.partitionStatesV0 = new ArrayList<UpdateMetadataRequestPartitionStateV0>();
        this.brokers = new ArrayList<UpdateMetadataRequestBroker>();
        read(readable, version);
    }
    
    public UpdateMetadataRequestData(Struct struct, short version) {
        this.topicStates = new ArrayList<UpdateMetadataRequestTopicState>();
        this.partitionStatesV0 = new ArrayList<UpdateMetadataRequestPartitionStateV0>();
        this.brokers = new ArrayList<UpdateMetadataRequestBroker>();
        fromStruct(struct, version);
    }
    
    public UpdateMetadataRequestData() {
        this.controllerId = 0;
        this.controllerEpoch = 0;
        this.brokerEpoch = -1L;
        this.topicStates = new ArrayList<UpdateMetadataRequestTopicState>();
        this.partitionStatesV0 = new ArrayList<UpdateMetadataRequestPartitionStateV0>();
        this.brokers = new ArrayList<UpdateMetadataRequestBroker>();
    }
    
    @Override
    public short apiKey() {
        return 6;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 5;
    }
    
    @Override
    public void read(Readable readable, short version) {
        this.controllerId = readable.readInt();
        this.controllerEpoch = readable.readInt();
        if (version >= 5) {
            this.brokerEpoch = readable.readLong();
        } else {
            this.brokerEpoch = -1L;
        }
        if (version >= 5) {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topicStates.clear();
            } else {
                this.topicStates.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.topicStates.add(new UpdateMetadataRequestTopicState(readable, version));
                }
            }
        } else {
            this.topicStates = new ArrayList<UpdateMetadataRequestTopicState>();
        }
        if (version <= 4) {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.partitionStatesV0.clear();
            } else {
                this.partitionStatesV0.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.partitionStatesV0.add(new UpdateMetadataRequestPartitionStateV0(readable, version));
                }
            }
        } else {
            this.partitionStatesV0 = new ArrayList<UpdateMetadataRequestPartitionStateV0>();
        }
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.brokers.clear();
            } else {
                this.brokers.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.brokers.add(new UpdateMetadataRequestBroker(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(controllerId);
        writable.writeInt(controllerEpoch);
        if (version >= 5) {
            writable.writeLong(brokerEpoch);
        }
        if (version >= 5) {
            writable.writeInt(topicStates.size());
            for (UpdateMetadataRequestTopicState element : topicStates) {
                element.write(writable, version);
            }
        }
        if (version <= 4) {
            writable.writeInt(partitionStatesV0.size());
            for (UpdateMetadataRequestPartitionStateV0 element : partitionStatesV0) {
                element.write(writable, version);
            }
        }
        writable.writeInt(brokers.size());
        for (UpdateMetadataRequestBroker element : brokers) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.controllerId = struct.getInt("controller_id");
        this.controllerEpoch = struct.getInt("controller_epoch");
        if (version >= 5) {
            this.brokerEpoch = struct.getLong("broker_epoch");
        } else {
            this.brokerEpoch = -1L;
        }
        if (version >= 5) {
            Object[] nestedObjects = struct.getArray("topic_states");
            this.topicStates = new ArrayList<UpdateMetadataRequestTopicState>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topicStates.add(new UpdateMetadataRequestTopicState((Struct) nestedObject, version));
            }
        } else {
            this.topicStates = new ArrayList<UpdateMetadataRequestTopicState>();
        }
        if (version <= 4) {
            Object[] nestedObjects = struct.getArray("partition_states_v0");
            this.partitionStatesV0 = new ArrayList<UpdateMetadataRequestPartitionStateV0>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.partitionStatesV0.add(new UpdateMetadataRequestPartitionStateV0((Struct) nestedObject, version));
            }
        } else {
            this.partitionStatesV0 = new ArrayList<UpdateMetadataRequestPartitionStateV0>();
        }
        {
            Object[] nestedObjects = struct.getArray("brokers");
            this.brokers = new ArrayList<UpdateMetadataRequestBroker>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.brokers.add(new UpdateMetadataRequestBroker((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("controller_id", this.controllerId);
        struct.set("controller_epoch", this.controllerEpoch);
        if (version >= 5) {
            struct.set("broker_epoch", this.brokerEpoch);
        }
        if (version >= 5) {
            Struct[] nestedObjects = new Struct[topicStates.size()];
            int i = 0;
            for (UpdateMetadataRequestTopicState element : this.topicStates) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("topic_states", (Object[]) nestedObjects);
        }
        if (version <= 4) {
            Struct[] nestedObjects = new Struct[partitionStatesV0.size()];
            int i = 0;
            for (UpdateMetadataRequestPartitionStateV0 element : this.partitionStatesV0) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("partition_states_v0", (Object[]) nestedObjects);
        }
        {
            Struct[] nestedObjects = new Struct[brokers.size()];
            int i = 0;
            for (UpdateMetadataRequestBroker element : this.brokers) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("brokers", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        size += 4;
        if (version >= 5) {
            size += 8;
        }
        if (version >= 5) {
            size += 4;
            for (UpdateMetadataRequestTopicState element : topicStates) {
                size += element.size(version);
            }
        } else {
            if (!topicStates.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default topicStates at version " + version);
            }
        }
        if (version <= 4) {
            size += 4;
            for (UpdateMetadataRequestPartitionStateV0 element : partitionStatesV0) {
                size += element.size(version);
            }
        } else {
            if (!partitionStatesV0.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default partitionStatesV0 at version " + version);
            }
        }
        size += 4;
        for (UpdateMetadataRequestBroker element : brokers) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UpdateMetadataRequestData)) return false;
        UpdateMetadataRequestData other = (UpdateMetadataRequestData) obj;
        if (controllerId != other.controllerId) return false;
        if (controllerEpoch != other.controllerEpoch) return false;
        if (brokerEpoch != other.brokerEpoch) return false;
        if (this.topicStates == null) {
            if (other.topicStates != null) return false;
        } else {
            if (!this.topicStates.equals(other.topicStates)) return false;
        }
        if (this.partitionStatesV0 == null) {
            if (other.partitionStatesV0 != null) return false;
        } else {
            if (!this.partitionStatesV0.equals(other.partitionStatesV0)) return false;
        }
        if (this.brokers == null) {
            if (other.brokers != null) return false;
        } else {
            if (!this.brokers.equals(other.brokers)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + controllerId;
        hashCode = 31 * hashCode + controllerEpoch;
        hashCode = 31 * hashCode + ((int) (brokerEpoch >> 32) ^ (int) brokerEpoch);
        hashCode = 31 * hashCode + (topicStates == null ? 0 : topicStates.hashCode());
        hashCode = 31 * hashCode + (partitionStatesV0 == null ? 0 : partitionStatesV0.hashCode());
        hashCode = 31 * hashCode + (brokers == null ? 0 : brokers.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "UpdateMetadataRequestData("
            + "controllerId=" + controllerId
            + ", controllerEpoch=" + controllerEpoch
            + ", brokerEpoch=" + brokerEpoch
            + ", topicStates=" + MessageUtil.deepToString(topicStates.iterator())
            + ", partitionStatesV0=" + MessageUtil.deepToString(partitionStatesV0.iterator())
            + ", brokers=" + MessageUtil.deepToString(brokers.iterator())
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
    
    public List<UpdateMetadataRequestTopicState> topicStates() {
        return this.topicStates;
    }
    
    public List<UpdateMetadataRequestPartitionStateV0> partitionStatesV0() {
        return this.partitionStatesV0;
    }
    
    public List<UpdateMetadataRequestBroker> brokers() {
        return this.brokers;
    }
    
    public UpdateMetadataRequestData setControllerId(int v) {
        this.controllerId = v;
        return this;
    }
    
    public UpdateMetadataRequestData setControllerEpoch(int v) {
        this.controllerEpoch = v;
        return this;
    }
    
    public UpdateMetadataRequestData setBrokerEpoch(long v) {
        this.brokerEpoch = v;
        return this;
    }
    
    public UpdateMetadataRequestData setTopicStates(List<UpdateMetadataRequestTopicState> v) {
        this.topicStates = v;
        return this;
    }
    
    public UpdateMetadataRequestData setPartitionStatesV0(List<UpdateMetadataRequestPartitionStateV0> v) {
        this.partitionStatesV0 = v;
        return this;
    }
    
    public UpdateMetadataRequestData setBrokers(List<UpdateMetadataRequestBroker> v) {
        this.brokers = v;
        return this;
    }
    
    static public class UpdateMetadataRequestTopicState implements Message {
        private String topicName;
        private List<UpdateMetadataPartitionState> partitionStates;
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("topic_name", Type.STRING, "The topic name."),
                new Field("partition_states", new ArrayOf(UpdateMetadataPartitionState.SCHEMA_5), "The partition that we would like to update.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            null,
            null,
            null,
            null,
            SCHEMA_5
        };
        
        public UpdateMetadataRequestTopicState(Readable readable, short version) {
            this.partitionStates = new ArrayList<UpdateMetadataPartitionState>();
            read(readable, version);
        }
        
        public UpdateMetadataRequestTopicState(Struct struct, short version) {
            this.partitionStates = new ArrayList<UpdateMetadataPartitionState>();
            fromStruct(struct, version);
        }
        
        public UpdateMetadataRequestTopicState() {
            this.topicName = "";
            this.partitionStates = new ArrayList<UpdateMetadataPartitionState>();
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 5;
        }
        
        @Override
        public void read(Readable readable, short version) {
            if (version < 5) {
                throw new UnsupportedVersionException("Can't read version " + version + " of UpdateMetadataRequestTopicState");
            }
            this.topicName = readable.readNullableString();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.partitionStates.clear();
                } else {
                    this.partitionStates.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.partitionStates.add(new UpdateMetadataPartitionState(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            if (version < 5) {
                throw new UnsupportedVersionException("Can't write version " + version + " of UpdateMetadataRequestTopicState");
            }
            writable.writeString(topicName);
            writable.writeInt(partitionStates.size());
            for (UpdateMetadataPartitionState element : partitionStates) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            if (version < 5) {
                throw new UnsupportedVersionException("Can't read version " + version + " of UpdateMetadataRequestTopicState");
            }
            this.topicName = struct.getString("topic_name");
            {
                Object[] nestedObjects = struct.getArray("partition_states");
                this.partitionStates = new ArrayList<UpdateMetadataPartitionState>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitionStates.add(new UpdateMetadataPartitionState((Struct) nestedObject, version));
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            if (version < 5) {
                throw new UnsupportedVersionException("Can't write version " + version + " of UpdateMetadataRequestTopicState");
            }
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("topic_name", this.topicName);
            {
                Struct[] nestedObjects = new Struct[partitionStates.size()];
                int i = 0;
                for (UpdateMetadataPartitionState element : this.partitionStates) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("partition_states", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            if (version < 5) {
                throw new UnsupportedVersionException("Can't size version " + version + " of UpdateMetadataRequestTopicState");
            }
            size += 2;
            size += MessageUtil.serializedUtf8Length(topicName);
            size += 4;
            for (UpdateMetadataPartitionState element : partitionStates) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof UpdateMetadataRequestTopicState)) return false;
            UpdateMetadataRequestTopicState other = (UpdateMetadataRequestTopicState) obj;
            if (this.topicName == null) {
                if (other.topicName != null) return false;
            } else {
                if (!this.topicName.equals(other.topicName)) return false;
            }
            if (this.partitionStates == null) {
                if (other.partitionStates != null) return false;
            } else {
                if (!this.partitionStates.equals(other.partitionStates)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (topicName == null ? 0 : topicName.hashCode());
            hashCode = 31 * hashCode + (partitionStates == null ? 0 : partitionStates.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "UpdateMetadataRequestTopicState("
                + "topicName='" + topicName + "'"
                + ", partitionStates=" + MessageUtil.deepToString(partitionStates.iterator())
                + ")";
        }
        
        public String topicName() {
            return this.topicName;
        }
        
        public List<UpdateMetadataPartitionState> partitionStates() {
            return this.partitionStates;
        }
        
        public UpdateMetadataRequestTopicState setTopicName(String v) {
            this.topicName = v;
            return this;
        }
        
        public UpdateMetadataRequestTopicState setPartitionStates(List<UpdateMetadataPartitionState> v) {
            this.partitionStates = v;
            return this;
        }
    }
    
    static public class UpdateMetadataPartitionState implements Message {
        private int partitionIndex;
        private int controllerEpoch;
        private int leader;
        private int leaderEpoch;
        private List<Integer> isr;
        private int zkVersion;
        private List<Integer> replicas;
        private List<Integer> offlineReplicas;
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("controller_epoch", Type.INT32, "The controller epoch."),
                new Field("leader", Type.INT32, "The ID of the broker which is the current partition leader."),
                new Field("leader_epoch", Type.INT32, "The leader epoch of this partition."),
                new Field("isr", new ArrayOf(Type.INT32), "The brokers which are in the ISR for this partition."),
                new Field("zk_version", Type.INT32, "The Zookeeper version."),
                new Field("replicas", new ArrayOf(Type.INT32), "All the replicas of this partition."),
                new Field("offline_replicas", new ArrayOf(Type.INT32), "The replicas of this partition which are offline.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            null,
            null,
            null,
            null,
            SCHEMA_5
        };
        
        public UpdateMetadataPartitionState(Readable readable, short version) {
            this.isr = new ArrayList<Integer>();
            this.replicas = new ArrayList<Integer>();
            this.offlineReplicas = new ArrayList<Integer>();
            read(readable, version);
        }
        
        public UpdateMetadataPartitionState(Struct struct, short version) {
            this.isr = new ArrayList<Integer>();
            this.replicas = new ArrayList<Integer>();
            this.offlineReplicas = new ArrayList<Integer>();
            fromStruct(struct, version);
        }
        
        public UpdateMetadataPartitionState() {
            this.partitionIndex = 0;
            this.controllerEpoch = 0;
            this.leader = 0;
            this.leaderEpoch = 0;
            this.isr = new ArrayList<Integer>();
            this.zkVersion = 0;
            this.replicas = new ArrayList<Integer>();
            this.offlineReplicas = new ArrayList<Integer>();
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 5;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 5;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.partitionIndex = readable.readInt();
            this.controllerEpoch = readable.readInt();
            this.leader = readable.readInt();
            this.leaderEpoch = readable.readInt();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.isr.clear();
                } else {
                    this.isr.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.isr.add(readable.readInt());
                    }
                }
            }
            this.zkVersion = readable.readInt();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.replicas.clear();
                } else {
                    this.replicas.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.replicas.add(readable.readInt());
                    }
                }
            }
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.offlineReplicas.clear();
                } else {
                    this.offlineReplicas.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.offlineReplicas.add(readable.readInt());
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionIndex);
            writable.writeInt(controllerEpoch);
            writable.writeInt(leader);
            writable.writeInt(leaderEpoch);
            writable.writeInt(isr.size());
            for (Integer element : isr) {
                writable.writeInt(element);
            }
            writable.writeInt(zkVersion);
            writable.writeInt(replicas.size());
            for (Integer element : replicas) {
                writable.writeInt(element);
            }
            writable.writeInt(offlineReplicas.size());
            for (Integer element : offlineReplicas) {
                writable.writeInt(element);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionIndex = struct.getInt("partition_index");
            this.controllerEpoch = struct.getInt("controller_epoch");
            this.leader = struct.getInt("leader");
            this.leaderEpoch = struct.getInt("leader_epoch");
            {
                Object[] nestedObjects = struct.getArray("isr");
                this.isr = new ArrayList<Integer>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.isr.add((Integer) nestedObject);
                }
            }
            this.zkVersion = struct.getInt("zk_version");
            {
                Object[] nestedObjects = struct.getArray("replicas");
                this.replicas = new ArrayList<Integer>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.replicas.add((Integer) nestedObject);
                }
            }
            {
                Object[] nestedObjects = struct.getArray("offline_replicas");
                this.offlineReplicas = new ArrayList<Integer>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.offlineReplicas.add((Integer) nestedObject);
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_index", this.partitionIndex);
            struct.set("controller_epoch", this.controllerEpoch);
            struct.set("leader", this.leader);
            struct.set("leader_epoch", this.leaderEpoch);
            {
                Integer[] nestedObjects = new Integer[isr.size()];
                int i = 0;
                for (Integer element : this.isr) {
                    nestedObjects[i++] = element;
                }
                struct.set("isr", (Object[]) nestedObjects);
            }
            struct.set("zk_version", this.zkVersion);
            {
                Integer[] nestedObjects = new Integer[replicas.size()];
                int i = 0;
                for (Integer element : this.replicas) {
                    nestedObjects[i++] = element;
                }
                struct.set("replicas", (Object[]) nestedObjects);
            }
            {
                Integer[] nestedObjects = new Integer[offlineReplicas.size()];
                int i = 0;
                for (Integer element : this.offlineReplicas) {
                    nestedObjects[i++] = element;
                }
                struct.set("offline_replicas", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            size += 4;
            size += 4;
            size += 4;
            size += 4;
            size += isr.size() * 4;
            size += 4;
            size += 4;
            size += replicas.size() * 4;
            size += 4;
            size += offlineReplicas.size() * 4;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof UpdateMetadataPartitionState)) return false;
            UpdateMetadataPartitionState other = (UpdateMetadataPartitionState) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (controllerEpoch != other.controllerEpoch) return false;
            if (leader != other.leader) return false;
            if (leaderEpoch != other.leaderEpoch) return false;
            if (this.isr == null) {
                if (other.isr != null) return false;
            } else {
                if (!this.isr.equals(other.isr)) return false;
            }
            if (zkVersion != other.zkVersion) return false;
            if (this.replicas == null) {
                if (other.replicas != null) return false;
            } else {
                if (!this.replicas.equals(other.replicas)) return false;
            }
            if (this.offlineReplicas == null) {
                if (other.offlineReplicas != null) return false;
            } else {
                if (!this.offlineReplicas.equals(other.offlineReplicas)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + controllerEpoch;
            hashCode = 31 * hashCode + leader;
            hashCode = 31 * hashCode + leaderEpoch;
            hashCode = 31 * hashCode + (isr == null ? 0 : isr.hashCode());
            hashCode = 31 * hashCode + zkVersion;
            hashCode = 31 * hashCode + (replicas == null ? 0 : replicas.hashCode());
            hashCode = 31 * hashCode + (offlineReplicas == null ? 0 : offlineReplicas.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "UpdateMetadataPartitionState("
                + "partitionIndex=" + partitionIndex
                + ", controllerEpoch=" + controllerEpoch
                + ", leader=" + leader
                + ", leaderEpoch=" + leaderEpoch
                + ", isr=" + MessageUtil.deepToString(isr.iterator())
                + ", zkVersion=" + zkVersion
                + ", replicas=" + MessageUtil.deepToString(replicas.iterator())
                + ", offlineReplicas=" + MessageUtil.deepToString(offlineReplicas.iterator())
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public int controllerEpoch() {
            return this.controllerEpoch;
        }
        
        public int leader() {
            return this.leader;
        }
        
        public int leaderEpoch() {
            return this.leaderEpoch;
        }
        
        public List<Integer> isr() {
            return this.isr;
        }
        
        public int zkVersion() {
            return this.zkVersion;
        }
        
        public List<Integer> replicas() {
            return this.replicas;
        }
        
        public List<Integer> offlineReplicas() {
            return this.offlineReplicas;
        }
        
        public UpdateMetadataPartitionState setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public UpdateMetadataPartitionState setControllerEpoch(int v) {
            this.controllerEpoch = v;
            return this;
        }
        
        public UpdateMetadataPartitionState setLeader(int v) {
            this.leader = v;
            return this;
        }
        
        public UpdateMetadataPartitionState setLeaderEpoch(int v) {
            this.leaderEpoch = v;
            return this;
        }
        
        public UpdateMetadataPartitionState setIsr(List<Integer> v) {
            this.isr = v;
            return this;
        }
        
        public UpdateMetadataPartitionState setZkVersion(int v) {
            this.zkVersion = v;
            return this;
        }
        
        public UpdateMetadataPartitionState setReplicas(List<Integer> v) {
            this.replicas = v;
            return this;
        }
        
        public UpdateMetadataPartitionState setOfflineReplicas(List<Integer> v) {
            this.offlineReplicas = v;
            return this;
        }
    }
    
    static public class UpdateMetadataRequestPartitionStateV0 implements Message {
        private String topicName;
        private int partitionIndex;
        private int controllerEpoch;
        private int leader;
        private int leaderEpoch;
        private List<Integer> isr;
        private int zkVersion;
        private List<Integer> replicas;
        private List<Integer> offlineReplicas;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("topic_name", Type.STRING, "The topic name."),
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("controller_epoch", Type.INT32, "The controller epoch."),
                new Field("leader", Type.INT32, "The ID of the broker which is the current partition leader."),
                new Field("leader_epoch", Type.INT32, "The leader epoch of this partition."),
                new Field("isr", new ArrayOf(Type.INT32), "The brokers which are in the ISR for this partition."),
                new Field("zk_version", Type.INT32, "The Zookeeper version."),
                new Field("replicas", new ArrayOf(Type.INT32), "All the replicas of this partition.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("topic_name", Type.STRING, "The topic name."),
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("controller_epoch", Type.INT32, "The controller epoch."),
                new Field("leader", Type.INT32, "The ID of the broker which is the current partition leader."),
                new Field("leader_epoch", Type.INT32, "The leader epoch of this partition."),
                new Field("isr", new ArrayOf(Type.INT32), "The brokers which are in the ISR for this partition."),
                new Field("zk_version", Type.INT32, "The Zookeeper version."),
                new Field("replicas", new ArrayOf(Type.INT32), "All the replicas of this partition."),
                new Field("offline_replicas", new ArrayOf(Type.INT32), "The replicas of this partition which are offline.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4
        };
        
        public UpdateMetadataRequestPartitionStateV0(Readable readable, short version) {
            this.isr = new ArrayList<Integer>();
            this.replicas = new ArrayList<Integer>();
            this.offlineReplicas = new ArrayList<Integer>();
            read(readable, version);
        }
        
        public UpdateMetadataRequestPartitionStateV0(Struct struct, short version) {
            this.isr = new ArrayList<Integer>();
            this.replicas = new ArrayList<Integer>();
            this.offlineReplicas = new ArrayList<Integer>();
            fromStruct(struct, version);
        }
        
        public UpdateMetadataRequestPartitionStateV0() {
            this.topicName = "";
            this.partitionIndex = 0;
            this.controllerEpoch = 0;
            this.leader = 0;
            this.leaderEpoch = 0;
            this.isr = new ArrayList<Integer>();
            this.zkVersion = 0;
            this.replicas = new ArrayList<Integer>();
            this.offlineReplicas = new ArrayList<Integer>();
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 5;
        }
        
        @Override
        public void read(Readable readable, short version) {
            if (version > 4) {
                throw new UnsupportedVersionException("Can't read version " + version + " of UpdateMetadataRequestPartitionStateV0");
            }
            this.topicName = readable.readNullableString();
            this.partitionIndex = readable.readInt();
            this.controllerEpoch = readable.readInt();
            this.leader = readable.readInt();
            this.leaderEpoch = readable.readInt();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.isr.clear();
                } else {
                    this.isr.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.isr.add(readable.readInt());
                    }
                }
            }
            this.zkVersion = readable.readInt();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.replicas.clear();
                } else {
                    this.replicas.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.replicas.add(readable.readInt());
                    }
                }
            }
            if (version >= 4) {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.offlineReplicas.clear();
                } else {
                    this.offlineReplicas.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.offlineReplicas.add(readable.readInt());
                    }
                }
            } else {
                this.offlineReplicas = new ArrayList<Integer>();
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            if (version > 4) {
                throw new UnsupportedVersionException("Can't write version " + version + " of UpdateMetadataRequestPartitionStateV0");
            }
            writable.writeString(topicName);
            writable.writeInt(partitionIndex);
            writable.writeInt(controllerEpoch);
            writable.writeInt(leader);
            writable.writeInt(leaderEpoch);
            writable.writeInt(isr.size());
            for (Integer element : isr) {
                writable.writeInt(element);
            }
            writable.writeInt(zkVersion);
            writable.writeInt(replicas.size());
            for (Integer element : replicas) {
                writable.writeInt(element);
            }
            if (version >= 4) {
                writable.writeInt(offlineReplicas.size());
                for (Integer element : offlineReplicas) {
                    writable.writeInt(element);
                }
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            if (version > 4) {
                throw new UnsupportedVersionException("Can't read version " + version + " of UpdateMetadataRequestPartitionStateV0");
            }
            this.topicName = struct.getString("topic_name");
            this.partitionIndex = struct.getInt("partition_index");
            this.controllerEpoch = struct.getInt("controller_epoch");
            this.leader = struct.getInt("leader");
            this.leaderEpoch = struct.getInt("leader_epoch");
            {
                Object[] nestedObjects = struct.getArray("isr");
                this.isr = new ArrayList<Integer>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.isr.add((Integer) nestedObject);
                }
            }
            this.zkVersion = struct.getInt("zk_version");
            {
                Object[] nestedObjects = struct.getArray("replicas");
                this.replicas = new ArrayList<Integer>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.replicas.add((Integer) nestedObject);
                }
            }
            if (version >= 4) {
                Object[] nestedObjects = struct.getArray("offline_replicas");
                this.offlineReplicas = new ArrayList<Integer>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.offlineReplicas.add((Integer) nestedObject);
                }
            } else {
                this.offlineReplicas = new ArrayList<Integer>();
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            if (version > 4) {
                throw new UnsupportedVersionException("Can't write version " + version + " of UpdateMetadataRequestPartitionStateV0");
            }
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("topic_name", this.topicName);
            struct.set("partition_index", this.partitionIndex);
            struct.set("controller_epoch", this.controllerEpoch);
            struct.set("leader", this.leader);
            struct.set("leader_epoch", this.leaderEpoch);
            {
                Integer[] nestedObjects = new Integer[isr.size()];
                int i = 0;
                for (Integer element : this.isr) {
                    nestedObjects[i++] = element;
                }
                struct.set("isr", (Object[]) nestedObjects);
            }
            struct.set("zk_version", this.zkVersion);
            {
                Integer[] nestedObjects = new Integer[replicas.size()];
                int i = 0;
                for (Integer element : this.replicas) {
                    nestedObjects[i++] = element;
                }
                struct.set("replicas", (Object[]) nestedObjects);
            }
            if (version >= 4) {
                Integer[] nestedObjects = new Integer[offlineReplicas.size()];
                int i = 0;
                for (Integer element : this.offlineReplicas) {
                    nestedObjects[i++] = element;
                }
                struct.set("offline_replicas", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            if (version > 4) {
                throw new UnsupportedVersionException("Can't size version " + version + " of UpdateMetadataRequestPartitionStateV0");
            }
            size += 2;
            size += MessageUtil.serializedUtf8Length(topicName);
            size += 4;
            size += 4;
            size += 4;
            size += 4;
            size += 4;
            size += isr.size() * 4;
            size += 4;
            size += 4;
            size += replicas.size() * 4;
            if (version >= 4) {
                size += 4;
                size += offlineReplicas.size() * 4;
            } else {
                if (!offlineReplicas.isEmpty()) {
                    throw new UnsupportedVersionException("Attempted to write a non-default offlineReplicas at version " + version);
                }
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof UpdateMetadataRequestPartitionStateV0)) return false;
            UpdateMetadataRequestPartitionStateV0 other = (UpdateMetadataRequestPartitionStateV0) obj;
            if (this.topicName == null) {
                if (other.topicName != null) return false;
            } else {
                if (!this.topicName.equals(other.topicName)) return false;
            }
            if (partitionIndex != other.partitionIndex) return false;
            if (controllerEpoch != other.controllerEpoch) return false;
            if (leader != other.leader) return false;
            if (leaderEpoch != other.leaderEpoch) return false;
            if (this.isr == null) {
                if (other.isr != null) return false;
            } else {
                if (!this.isr.equals(other.isr)) return false;
            }
            if (zkVersion != other.zkVersion) return false;
            if (this.replicas == null) {
                if (other.replicas != null) return false;
            } else {
                if (!this.replicas.equals(other.replicas)) return false;
            }
            if (this.offlineReplicas == null) {
                if (other.offlineReplicas != null) return false;
            } else {
                if (!this.offlineReplicas.equals(other.offlineReplicas)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (topicName == null ? 0 : topicName.hashCode());
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + controllerEpoch;
            hashCode = 31 * hashCode + leader;
            hashCode = 31 * hashCode + leaderEpoch;
            hashCode = 31 * hashCode + (isr == null ? 0 : isr.hashCode());
            hashCode = 31 * hashCode + zkVersion;
            hashCode = 31 * hashCode + (replicas == null ? 0 : replicas.hashCode());
            hashCode = 31 * hashCode + (offlineReplicas == null ? 0 : offlineReplicas.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "UpdateMetadataRequestPartitionStateV0("
                + "topicName='" + topicName + "'"
                + ", partitionIndex=" + partitionIndex
                + ", controllerEpoch=" + controllerEpoch
                + ", leader=" + leader
                + ", leaderEpoch=" + leaderEpoch
                + ", isr=" + MessageUtil.deepToString(isr.iterator())
                + ", zkVersion=" + zkVersion
                + ", replicas=" + MessageUtil.deepToString(replicas.iterator())
                + ", offlineReplicas=" + MessageUtil.deepToString(offlineReplicas.iterator())
                + ")";
        }
        
        public String topicName() {
            return this.topicName;
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public int controllerEpoch() {
            return this.controllerEpoch;
        }
        
        public int leader() {
            return this.leader;
        }
        
        public int leaderEpoch() {
            return this.leaderEpoch;
        }
        
        public List<Integer> isr() {
            return this.isr;
        }
        
        public int zkVersion() {
            return this.zkVersion;
        }
        
        public List<Integer> replicas() {
            return this.replicas;
        }
        
        public List<Integer> offlineReplicas() {
            return this.offlineReplicas;
        }
        
        public UpdateMetadataRequestPartitionStateV0 setTopicName(String v) {
            this.topicName = v;
            return this;
        }
        
        public UpdateMetadataRequestPartitionStateV0 setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public UpdateMetadataRequestPartitionStateV0 setControllerEpoch(int v) {
            this.controllerEpoch = v;
            return this;
        }
        
        public UpdateMetadataRequestPartitionStateV0 setLeader(int v) {
            this.leader = v;
            return this;
        }
        
        public UpdateMetadataRequestPartitionStateV0 setLeaderEpoch(int v) {
            this.leaderEpoch = v;
            return this;
        }
        
        public UpdateMetadataRequestPartitionStateV0 setIsr(List<Integer> v) {
            this.isr = v;
            return this;
        }
        
        public UpdateMetadataRequestPartitionStateV0 setZkVersion(int v) {
            this.zkVersion = v;
            return this;
        }
        
        public UpdateMetadataRequestPartitionStateV0 setReplicas(List<Integer> v) {
            this.replicas = v;
            return this;
        }
        
        public UpdateMetadataRequestPartitionStateV0 setOfflineReplicas(List<Integer> v) {
            this.offlineReplicas = v;
            return this;
        }
    }
    
    static public class UpdateMetadataRequestBroker implements Message {
        private int id;
        private String v0Host;
        private int v0Port;
        private List<UpdateMetadataRequestEndpoint> endpoints;
        private String rack;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("id", Type.INT32, ""),
                new Field("v0_host", Type.STRING, "The broker hostname."),
                new Field("v0_port", Type.INT32, "The broker port.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("id", Type.INT32, ""),
                new Field("endpoints", new ArrayOf(UpdateMetadataRequestEndpoint.SCHEMA_1), "The broker endpoints.")
            );
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("id", Type.INT32, ""),
                new Field("endpoints", new ArrayOf(UpdateMetadataRequestEndpoint.SCHEMA_1), "The broker endpoints."),
                new Field("rack", Type.NULLABLE_STRING, "The rack which this broker belongs to.")
            );
        
        public static final Schema SCHEMA_3 =
            new Schema(
                new Field("id", Type.INT32, ""),
                new Field("endpoints", new ArrayOf(UpdateMetadataRequestEndpoint.SCHEMA_3), "The broker endpoints."),
                new Field("rack", Type.NULLABLE_STRING, "The rack which this broker belongs to.")
            );
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5
        };
        
        public UpdateMetadataRequestBroker(Readable readable, short version) {
            this.endpoints = new ArrayList<UpdateMetadataRequestEndpoint>();
            read(readable, version);
        }
        
        public UpdateMetadataRequestBroker(Struct struct, short version) {
            this.endpoints = new ArrayList<UpdateMetadataRequestEndpoint>();
            fromStruct(struct, version);
        }
        
        public UpdateMetadataRequestBroker() {
            this.id = 0;
            this.v0Host = "";
            this.v0Port = 0;
            this.endpoints = new ArrayList<UpdateMetadataRequestEndpoint>();
            this.rack = "";
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 5;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.id = readable.readInt();
            if (version <= 0) {
                this.v0Host = readable.readNullableString();
            } else {
                this.v0Host = "";
            }
            if (version <= 0) {
                this.v0Port = readable.readInt();
            } else {
                this.v0Port = 0;
            }
            if (version >= 1) {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.endpoints.clear();
                } else {
                    this.endpoints.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.endpoints.add(new UpdateMetadataRequestEndpoint(readable, version));
                    }
                }
            } else {
                this.endpoints = new ArrayList<UpdateMetadataRequestEndpoint>();
            }
            if (version >= 2) {
                this.rack = readable.readNullableString();
            } else {
                this.rack = "";
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(id);
            if (version <= 0) {
                writable.writeString(v0Host);
            }
            if (version <= 0) {
                writable.writeInt(v0Port);
            }
            if (version >= 1) {
                writable.writeInt(endpoints.size());
                for (UpdateMetadataRequestEndpoint element : endpoints) {
                    element.write(writable, version);
                }
            }
            if (version >= 2) {
                writable.writeNullableString(rack);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.id = struct.getInt("id");
            if (version <= 0) {
                this.v0Host = struct.getString("v0_host");
            } else {
                this.v0Host = "";
            }
            if (version <= 0) {
                this.v0Port = struct.getInt("v0_port");
            } else {
                this.v0Port = 0;
            }
            if (version >= 1) {
                Object[] nestedObjects = struct.getArray("endpoints");
                this.endpoints = new ArrayList<UpdateMetadataRequestEndpoint>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.endpoints.add(new UpdateMetadataRequestEndpoint((Struct) nestedObject, version));
                }
            } else {
                this.endpoints = new ArrayList<UpdateMetadataRequestEndpoint>();
            }
            if (version >= 2) {
                this.rack = struct.getString("rack");
            } else {
                this.rack = "";
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("id", this.id);
            if (version <= 0) {
                struct.set("v0_host", this.v0Host);
            }
            if (version <= 0) {
                struct.set("v0_port", this.v0Port);
            }
            if (version >= 1) {
                Struct[] nestedObjects = new Struct[endpoints.size()];
                int i = 0;
                for (UpdateMetadataRequestEndpoint element : this.endpoints) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("endpoints", (Object[]) nestedObjects);
            }
            if (version >= 2) {
                struct.set("rack", this.rack);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            if (version <= 0) {
                size += 2;
                size += MessageUtil.serializedUtf8Length(v0Host);
            }
            if (version <= 0) {
                size += 4;
            }
            if (version >= 1) {
                size += 4;
                for (UpdateMetadataRequestEndpoint element : endpoints) {
                    size += element.size(version);
                }
            } else {
                if (!endpoints.isEmpty()) {
                    throw new UnsupportedVersionException("Attempted to write a non-default endpoints at version " + version);
                }
            }
            if (version >= 2) {
                size += 2;
                if (rack != null) {
                    size += MessageUtil.serializedUtf8Length(rack);
                }
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof UpdateMetadataRequestBroker)) return false;
            UpdateMetadataRequestBroker other = (UpdateMetadataRequestBroker) obj;
            if (id != other.id) return false;
            if (this.v0Host == null) {
                if (other.v0Host != null) return false;
            } else {
                if (!this.v0Host.equals(other.v0Host)) return false;
            }
            if (v0Port != other.v0Port) return false;
            if (this.endpoints == null) {
                if (other.endpoints != null) return false;
            } else {
                if (!this.endpoints.equals(other.endpoints)) return false;
            }
            if (this.rack == null) {
                if (other.rack != null) return false;
            } else {
                if (!this.rack.equals(other.rack)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + id;
            hashCode = 31 * hashCode + (v0Host == null ? 0 : v0Host.hashCode());
            hashCode = 31 * hashCode + v0Port;
            hashCode = 31 * hashCode + (endpoints == null ? 0 : endpoints.hashCode());
            hashCode = 31 * hashCode + (rack == null ? 0 : rack.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "UpdateMetadataRequestBroker("
                + "id=" + id
                + ", v0Host='" + v0Host + "'"
                + ", v0Port=" + v0Port
                + ", endpoints=" + MessageUtil.deepToString(endpoints.iterator())
                + ", rack='" + rack + "'"
                + ")";
        }
        
        public int id() {
            return this.id;
        }
        
        public String v0Host() {
            return this.v0Host;
        }
        
        public int v0Port() {
            return this.v0Port;
        }
        
        public List<UpdateMetadataRequestEndpoint> endpoints() {
            return this.endpoints;
        }
        
        public String rack() {
            return this.rack;
        }
        
        public UpdateMetadataRequestBroker setId(int v) {
            this.id = v;
            return this;
        }
        
        public UpdateMetadataRequestBroker setV0Host(String v) {
            this.v0Host = v;
            return this;
        }
        
        public UpdateMetadataRequestBroker setV0Port(int v) {
            this.v0Port = v;
            return this;
        }
        
        public UpdateMetadataRequestBroker setEndpoints(List<UpdateMetadataRequestEndpoint> v) {
            this.endpoints = v;
            return this;
        }
        
        public UpdateMetadataRequestBroker setRack(String v) {
            this.rack = v;
            return this;
        }
    }
    
    static public class UpdateMetadataRequestEndpoint implements Message {
        private int port;
        private String host;
        private String listener;
        private short securityProtocol;
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("port", Type.INT32, "The port of this endpoint"),
                new Field("host", Type.STRING, "The hostname of this endpoint"),
                new Field("security_protocol", Type.INT16, "The security protocol type.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 =
            new Schema(
                new Field("port", Type.INT32, "The port of this endpoint"),
                new Field("host", Type.STRING, "The hostname of this endpoint"),
                new Field("listener", Type.STRING, "The listener name."),
                new Field("security_protocol", Type.INT16, "The security protocol type.")
            );
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5
        };
        
        public UpdateMetadataRequestEndpoint(Readable readable, short version) {
            read(readable, version);
        }
        
        public UpdateMetadataRequestEndpoint(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public UpdateMetadataRequestEndpoint() {
            this.port = 0;
            this.host = "";
            this.listener = "";
            this.securityProtocol = (short) 0;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 5;
        }
        
        @Override
        public void read(Readable readable, short version) {
            if (version < 1) {
                throw new UnsupportedVersionException("Can't read version " + version + " of UpdateMetadataRequestEndpoint");
            }
            this.port = readable.readInt();
            this.host = readable.readNullableString();
            if (version >= 3) {
                this.listener = readable.readNullableString();
            } else {
                this.listener = "";
            }
            this.securityProtocol = readable.readShort();
        }
        
        @Override
        public void write(Writable writable, short version) {
            if (version < 1) {
                throw new UnsupportedVersionException("Can't write version " + version + " of UpdateMetadataRequestEndpoint");
            }
            writable.writeInt(port);
            writable.writeString(host);
            if (version >= 3) {
                writable.writeString(listener);
            }
            writable.writeShort(securityProtocol);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            if (version < 1) {
                throw new UnsupportedVersionException("Can't read version " + version + " of UpdateMetadataRequestEndpoint");
            }
            this.port = struct.getInt("port");
            this.host = struct.getString("host");
            if (version >= 3) {
                this.listener = struct.getString("listener");
            } else {
                this.listener = "";
            }
            this.securityProtocol = struct.getShort("security_protocol");
        }
        
        @Override
        public Struct toStruct(short version) {
            if (version < 1) {
                throw new UnsupportedVersionException("Can't write version " + version + " of UpdateMetadataRequestEndpoint");
            }
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("port", this.port);
            struct.set("host", this.host);
            if (version >= 3) {
                struct.set("listener", this.listener);
            }
            struct.set("security_protocol", this.securityProtocol);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            if (version < 1) {
                throw new UnsupportedVersionException("Can't size version " + version + " of UpdateMetadataRequestEndpoint");
            }
            size += 4;
            size += 2;
            size += MessageUtil.serializedUtf8Length(host);
            if (version >= 3) {
                size += 2;
                size += MessageUtil.serializedUtf8Length(listener);
            } else {
                if (listener.equals("")) {
                    throw new UnsupportedVersionException("Attempted to write a non-default listener at version " + version);
                }
            }
            size += 2;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof UpdateMetadataRequestEndpoint)) return false;
            UpdateMetadataRequestEndpoint other = (UpdateMetadataRequestEndpoint) obj;
            if (port != other.port) return false;
            if (this.host == null) {
                if (other.host != null) return false;
            } else {
                if (!this.host.equals(other.host)) return false;
            }
            if (this.listener == null) {
                if (other.listener != null) return false;
            } else {
                if (!this.listener.equals(other.listener)) return false;
            }
            if (securityProtocol != other.securityProtocol) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + port;
            hashCode = 31 * hashCode + (host == null ? 0 : host.hashCode());
            hashCode = 31 * hashCode + (listener == null ? 0 : listener.hashCode());
            hashCode = 31 * hashCode + securityProtocol;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "UpdateMetadataRequestEndpoint("
                + "port=" + port
                + ", host='" + host + "'"
                + ", listener='" + listener + "'"
                + ", securityProtocol=" + securityProtocol
                + ")";
        }
        
        public int port() {
            return this.port;
        }
        
        public String host() {
            return this.host;
        }
        
        public String listener() {
            return this.listener;
        }
        
        public short securityProtocol() {
            return this.securityProtocol;
        }
        
        public UpdateMetadataRequestEndpoint setPort(int v) {
            this.port = v;
            return this;
        }
        
        public UpdateMetadataRequestEndpoint setHost(String v) {
            this.host = v;
            return this;
        }
        
        public UpdateMetadataRequestEndpoint setListener(String v) {
            this.listener = v;
            return this;
        }
        
        public UpdateMetadataRequestEndpoint setSecurityProtocol(short v) {
            this.securityProtocol = v;
            return this;
        }
    }
}
