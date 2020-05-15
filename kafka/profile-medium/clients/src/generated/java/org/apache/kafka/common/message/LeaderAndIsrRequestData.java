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


public class LeaderAndIsrRequestData implements ApiMessage {
    private int controllerId;
    private int controllerEpoch;
    private long brokerEpoch;
    private List<LeaderAndIsrRequestTopicState> topicStates;
    private List<LeaderAndIsrRequestPartitionStateV0> partitionStatesV0;
    private List<LeaderAndIsrLiveLeader> liveLeaders;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("controller_id", Type.INT32, "The current controller ID."),
            new Field("controller_epoch", Type.INT32, "The current controller epoch."),
            new Field("partition_states_v0", new ArrayOf(LeaderAndIsrRequestPartitionStateV0.SCHEMA_0), "The state of each partition"),
            new Field("live_leaders", new ArrayOf(LeaderAndIsrLiveLeader.SCHEMA_0), "The current live leaders.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("controller_id", Type.INT32, "The current controller ID."),
            new Field("controller_epoch", Type.INT32, "The current controller epoch."),
            new Field("partition_states_v0", new ArrayOf(LeaderAndIsrRequestPartitionStateV0.SCHEMA_1), "The state of each partition"),
            new Field("live_leaders", new ArrayOf(LeaderAndIsrLiveLeader.SCHEMA_0), "The current live leaders.")
        );
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("controller_id", Type.INT32, "The current controller ID."),
            new Field("controller_epoch", Type.INT32, "The current controller epoch."),
            new Field("broker_epoch", Type.INT64, "The current broker epoch."),
            new Field("topic_states", new ArrayOf(LeaderAndIsrRequestTopicState.SCHEMA_2), "Each topic."),
            new Field("live_leaders", new ArrayOf(LeaderAndIsrLiveLeader.SCHEMA_0), "The current live leaders.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2
    };
    
    public LeaderAndIsrRequestData(Readable readable, short version) {
        this.topicStates = new ArrayList<LeaderAndIsrRequestTopicState>();
        this.partitionStatesV0 = new ArrayList<LeaderAndIsrRequestPartitionStateV0>();
        this.liveLeaders = new ArrayList<LeaderAndIsrLiveLeader>();
        read(readable, version);
    }
    
    public LeaderAndIsrRequestData(Struct struct, short version) {
        this.topicStates = new ArrayList<LeaderAndIsrRequestTopicState>();
        this.partitionStatesV0 = new ArrayList<LeaderAndIsrRequestPartitionStateV0>();
        this.liveLeaders = new ArrayList<LeaderAndIsrLiveLeader>();
        fromStruct(struct, version);
    }
    
    public LeaderAndIsrRequestData() {
        this.controllerId = 0;
        this.controllerEpoch = 0;
        this.brokerEpoch = -1L;
        this.topicStates = new ArrayList<LeaderAndIsrRequestTopicState>();
        this.partitionStatesV0 = new ArrayList<LeaderAndIsrRequestPartitionStateV0>();
        this.liveLeaders = new ArrayList<LeaderAndIsrLiveLeader>();
    }
    
    @Override
    public short apiKey() {
        return 4;
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
        this.controllerId = readable.readInt();
        this.controllerEpoch = readable.readInt();
        if (version >= 2) {
            this.brokerEpoch = readable.readLong();
        } else {
            this.brokerEpoch = -1L;
        }
        if (version >= 2) {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topicStates.clear();
            } else {
                this.topicStates.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.topicStates.add(new LeaderAndIsrRequestTopicState(readable, version));
                }
            }
        } else {
            this.topicStates = new ArrayList<LeaderAndIsrRequestTopicState>();
        }
        if (version <= 1) {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.partitionStatesV0.clear();
            } else {
                this.partitionStatesV0.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.partitionStatesV0.add(new LeaderAndIsrRequestPartitionStateV0(readable, version));
                }
            }
        } else {
            this.partitionStatesV0 = new ArrayList<LeaderAndIsrRequestPartitionStateV0>();
        }
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.liveLeaders.clear();
            } else {
                this.liveLeaders.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.liveLeaders.add(new LeaderAndIsrLiveLeader(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(controllerId);
        writable.writeInt(controllerEpoch);
        if (version >= 2) {
            writable.writeLong(brokerEpoch);
        }
        if (version >= 2) {
            writable.writeInt(topicStates.size());
            for (LeaderAndIsrRequestTopicState element : topicStates) {
                element.write(writable, version);
            }
        }
        if (version <= 1) {
            writable.writeInt(partitionStatesV0.size());
            for (LeaderAndIsrRequestPartitionStateV0 element : partitionStatesV0) {
                element.write(writable, version);
            }
        }
        writable.writeInt(liveLeaders.size());
        for (LeaderAndIsrLiveLeader element : liveLeaders) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.controllerId = struct.getInt("controller_id");
        this.controllerEpoch = struct.getInt("controller_epoch");
        if (version >= 2) {
            this.brokerEpoch = struct.getLong("broker_epoch");
        } else {
            this.brokerEpoch = -1L;
        }
        if (version >= 2) {
            Object[] nestedObjects = struct.getArray("topic_states");
            this.topicStates = new ArrayList<LeaderAndIsrRequestTopicState>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topicStates.add(new LeaderAndIsrRequestTopicState((Struct) nestedObject, version));
            }
        } else {
            this.topicStates = new ArrayList<LeaderAndIsrRequestTopicState>();
        }
        if (version <= 1) {
            Object[] nestedObjects = struct.getArray("partition_states_v0");
            this.partitionStatesV0 = new ArrayList<LeaderAndIsrRequestPartitionStateV0>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.partitionStatesV0.add(new LeaderAndIsrRequestPartitionStateV0((Struct) nestedObject, version));
            }
        } else {
            this.partitionStatesV0 = new ArrayList<LeaderAndIsrRequestPartitionStateV0>();
        }
        {
            Object[] nestedObjects = struct.getArray("live_leaders");
            this.liveLeaders = new ArrayList<LeaderAndIsrLiveLeader>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.liveLeaders.add(new LeaderAndIsrLiveLeader((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("controller_id", this.controllerId);
        struct.set("controller_epoch", this.controllerEpoch);
        if (version >= 2) {
            struct.set("broker_epoch", this.brokerEpoch);
        }
        if (version >= 2) {
            Struct[] nestedObjects = new Struct[topicStates.size()];
            int i = 0;
            for (LeaderAndIsrRequestTopicState element : this.topicStates) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("topic_states", (Object[]) nestedObjects);
        }
        if (version <= 1) {
            Struct[] nestedObjects = new Struct[partitionStatesV0.size()];
            int i = 0;
            for (LeaderAndIsrRequestPartitionStateV0 element : this.partitionStatesV0) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("partition_states_v0", (Object[]) nestedObjects);
        }
        {
            Struct[] nestedObjects = new Struct[liveLeaders.size()];
            int i = 0;
            for (LeaderAndIsrLiveLeader element : this.liveLeaders) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("live_leaders", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        size += 4;
        if (version >= 2) {
            size += 8;
        }
        if (version >= 2) {
            size += 4;
            for (LeaderAndIsrRequestTopicState element : topicStates) {
                size += element.size(version);
            }
        } else {
            if (!topicStates.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default topicStates at version " + version);
            }
        }
        if (version <= 1) {
            size += 4;
            for (LeaderAndIsrRequestPartitionStateV0 element : partitionStatesV0) {
                size += element.size(version);
            }
        } else {
            if (!partitionStatesV0.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default partitionStatesV0 at version " + version);
            }
        }
        size += 4;
        for (LeaderAndIsrLiveLeader element : liveLeaders) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LeaderAndIsrRequestData)) return false;
        LeaderAndIsrRequestData other = (LeaderAndIsrRequestData) obj;
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
        if (this.liveLeaders == null) {
            if (other.liveLeaders != null) return false;
        } else {
            if (!this.liveLeaders.equals(other.liveLeaders)) return false;
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
        hashCode = 31 * hashCode + (liveLeaders == null ? 0 : liveLeaders.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "LeaderAndIsrRequestData("
            + "controllerId=" + controllerId
            + ", controllerEpoch=" + controllerEpoch
            + ", brokerEpoch=" + brokerEpoch
            + ", topicStates=" + MessageUtil.deepToString(topicStates.iterator())
            + ", partitionStatesV0=" + MessageUtil.deepToString(partitionStatesV0.iterator())
            + ", liveLeaders=" + MessageUtil.deepToString(liveLeaders.iterator())
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
    
    public List<LeaderAndIsrRequestTopicState> topicStates() {
        return this.topicStates;
    }
    
    public List<LeaderAndIsrRequestPartitionStateV0> partitionStatesV0() {
        return this.partitionStatesV0;
    }
    
    public List<LeaderAndIsrLiveLeader> liveLeaders() {
        return this.liveLeaders;
    }
    
    public LeaderAndIsrRequestData setControllerId(int v) {
        this.controllerId = v;
        return this;
    }
    
    public LeaderAndIsrRequestData setControllerEpoch(int v) {
        this.controllerEpoch = v;
        return this;
    }
    
    public LeaderAndIsrRequestData setBrokerEpoch(long v) {
        this.brokerEpoch = v;
        return this;
    }
    
    public LeaderAndIsrRequestData setTopicStates(List<LeaderAndIsrRequestTopicState> v) {
        this.topicStates = v;
        return this;
    }
    
    public LeaderAndIsrRequestData setPartitionStatesV0(List<LeaderAndIsrRequestPartitionStateV0> v) {
        this.partitionStatesV0 = v;
        return this;
    }
    
    public LeaderAndIsrRequestData setLiveLeaders(List<LeaderAndIsrLiveLeader> v) {
        this.liveLeaders = v;
        return this;
    }
    
    static public class LeaderAndIsrRequestTopicState implements Message {
        private String name;
        private List<LeaderAndIsrRequestPartitionState> partitionStates;
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partition_states", new ArrayOf(LeaderAndIsrRequestPartitionState.SCHEMA_2), "The state of each partition")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            null,
            SCHEMA_2
        };
        
        public LeaderAndIsrRequestTopicState(Readable readable, short version) {
            this.partitionStates = new ArrayList<LeaderAndIsrRequestPartitionState>();
            read(readable, version);
        }
        
        public LeaderAndIsrRequestTopicState(Struct struct, short version) {
            this.partitionStates = new ArrayList<LeaderAndIsrRequestPartitionState>();
            fromStruct(struct, version);
        }
        
        public LeaderAndIsrRequestTopicState() {
            this.name = "";
            this.partitionStates = new ArrayList<LeaderAndIsrRequestPartitionState>();
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
            if (version < 2) {
                throw new UnsupportedVersionException("Can't read version " + version + " of LeaderAndIsrRequestTopicState");
            }
            this.name = readable.readNullableString();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.partitionStates.clear();
                } else {
                    this.partitionStates.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.partitionStates.add(new LeaderAndIsrRequestPartitionState(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            if (version < 2) {
                throw new UnsupportedVersionException("Can't write version " + version + " of LeaderAndIsrRequestTopicState");
            }
            writable.writeString(name);
            writable.writeInt(partitionStates.size());
            for (LeaderAndIsrRequestPartitionState element : partitionStates) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            if (version < 2) {
                throw new UnsupportedVersionException("Can't read version " + version + " of LeaderAndIsrRequestTopicState");
            }
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partition_states");
                this.partitionStates = new ArrayList<LeaderAndIsrRequestPartitionState>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitionStates.add(new LeaderAndIsrRequestPartitionState((Struct) nestedObject, version));
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            if (version < 2) {
                throw new UnsupportedVersionException("Can't write version " + version + " of LeaderAndIsrRequestTopicState");
            }
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            {
                Struct[] nestedObjects = new Struct[partitionStates.size()];
                int i = 0;
                for (LeaderAndIsrRequestPartitionState element : this.partitionStates) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("partition_states", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            if (version < 2) {
                throw new UnsupportedVersionException("Can't size version " + version + " of LeaderAndIsrRequestTopicState");
            }
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            size += 4;
            for (LeaderAndIsrRequestPartitionState element : partitionStates) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof LeaderAndIsrRequestTopicState)) return false;
            LeaderAndIsrRequestTopicState other = (LeaderAndIsrRequestTopicState) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
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
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + (partitionStates == null ? 0 : partitionStates.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "LeaderAndIsrRequestTopicState("
                + "name='" + name + "'"
                + ", partitionStates=" + MessageUtil.deepToString(partitionStates.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<LeaderAndIsrRequestPartitionState> partitionStates() {
            return this.partitionStates;
        }
        
        public LeaderAndIsrRequestTopicState setName(String v) {
            this.name = v;
            return this;
        }
        
        public LeaderAndIsrRequestTopicState setPartitionStates(List<LeaderAndIsrRequestPartitionState> v) {
            this.partitionStates = v;
            return this;
        }
    }
    
    static public class LeaderAndIsrRequestPartitionState implements Message {
        private int partitionIndex;
        private int controllerEpoch;
        private int leaderKey;
        private int leaderEpoch;
        private List<Integer> isrReplicas;
        private int zkVersion;
        private List<Integer> replicas;
        private boolean isNew;
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("controller_epoch", Type.INT32, "The controller epoch."),
                new Field("leader_key", Type.INT32, "The broker ID of the leader."),
                new Field("leader_epoch", Type.INT32, "The leader epoch."),
                new Field("isr_replicas", new ArrayOf(Type.INT32), "The in-sync replica IDs."),
                new Field("zk_version", Type.INT32, "The ZooKeeper version."),
                new Field("replicas", new ArrayOf(Type.INT32), "The replica IDs."),
                new Field("is_new", Type.BOOLEAN, "Whether the replica should have existed on the broker or not.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            null,
            SCHEMA_2
        };
        
        public LeaderAndIsrRequestPartitionState(Readable readable, short version) {
            this.isrReplicas = new ArrayList<Integer>();
            this.replicas = new ArrayList<Integer>();
            read(readable, version);
        }
        
        public LeaderAndIsrRequestPartitionState(Struct struct, short version) {
            this.isrReplicas = new ArrayList<Integer>();
            this.replicas = new ArrayList<Integer>();
            fromStruct(struct, version);
        }
        
        public LeaderAndIsrRequestPartitionState() {
            this.partitionIndex = 0;
            this.controllerEpoch = 0;
            this.leaderKey = 0;
            this.leaderEpoch = 0;
            this.isrReplicas = new ArrayList<Integer>();
            this.zkVersion = 0;
            this.replicas = new ArrayList<Integer>();
            this.isNew = false;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 2;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 2;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.partitionIndex = readable.readInt();
            this.controllerEpoch = readable.readInt();
            this.leaderKey = readable.readInt();
            this.leaderEpoch = readable.readInt();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.isrReplicas.clear();
                } else {
                    this.isrReplicas.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.isrReplicas.add(readable.readInt());
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
            this.isNew = readable.readByte() != 0;
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionIndex);
            writable.writeInt(controllerEpoch);
            writable.writeInt(leaderKey);
            writable.writeInt(leaderEpoch);
            writable.writeInt(isrReplicas.size());
            for (Integer element : isrReplicas) {
                writable.writeInt(element);
            }
            writable.writeInt(zkVersion);
            writable.writeInt(replicas.size());
            for (Integer element : replicas) {
                writable.writeInt(element);
            }
            writable.writeByte(isNew ? (byte) 1 : (byte) 0);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionIndex = struct.getInt("partition_index");
            this.controllerEpoch = struct.getInt("controller_epoch");
            this.leaderKey = struct.getInt("leader_key");
            this.leaderEpoch = struct.getInt("leader_epoch");
            {
                Object[] nestedObjects = struct.getArray("isr_replicas");
                this.isrReplicas = new ArrayList<Integer>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.isrReplicas.add((Integer) nestedObject);
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
            this.isNew = struct.getBoolean("is_new");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_index", this.partitionIndex);
            struct.set("controller_epoch", this.controllerEpoch);
            struct.set("leader_key", this.leaderKey);
            struct.set("leader_epoch", this.leaderEpoch);
            {
                Integer[] nestedObjects = new Integer[isrReplicas.size()];
                int i = 0;
                for (Integer element : this.isrReplicas) {
                    nestedObjects[i++] = element;
                }
                struct.set("isr_replicas", (Object[]) nestedObjects);
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
            struct.set("is_new", this.isNew);
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
            size += isrReplicas.size() * 4;
            size += 4;
            size += 4;
            size += replicas.size() * 4;
            size += 1;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof LeaderAndIsrRequestPartitionState)) return false;
            LeaderAndIsrRequestPartitionState other = (LeaderAndIsrRequestPartitionState) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (controllerEpoch != other.controllerEpoch) return false;
            if (leaderKey != other.leaderKey) return false;
            if (leaderEpoch != other.leaderEpoch) return false;
            if (this.isrReplicas == null) {
                if (other.isrReplicas != null) return false;
            } else {
                if (!this.isrReplicas.equals(other.isrReplicas)) return false;
            }
            if (zkVersion != other.zkVersion) return false;
            if (this.replicas == null) {
                if (other.replicas != null) return false;
            } else {
                if (!this.replicas.equals(other.replicas)) return false;
            }
            if (isNew != other.isNew) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + controllerEpoch;
            hashCode = 31 * hashCode + leaderKey;
            hashCode = 31 * hashCode + leaderEpoch;
            hashCode = 31 * hashCode + (isrReplicas == null ? 0 : isrReplicas.hashCode());
            hashCode = 31 * hashCode + zkVersion;
            hashCode = 31 * hashCode + (replicas == null ? 0 : replicas.hashCode());
            hashCode = 31 * hashCode + (isNew ? 1231 : 1237);
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "LeaderAndIsrRequestPartitionState("
                + "partitionIndex=" + partitionIndex
                + ", controllerEpoch=" + controllerEpoch
                + ", leaderKey=" + leaderKey
                + ", leaderEpoch=" + leaderEpoch
                + ", isrReplicas=" + MessageUtil.deepToString(isrReplicas.iterator())
                + ", zkVersion=" + zkVersion
                + ", replicas=" + MessageUtil.deepToString(replicas.iterator())
                + ", isNew=" + (isNew ? "true" : "false")
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public int controllerEpoch() {
            return this.controllerEpoch;
        }
        
        public int leaderKey() {
            return this.leaderKey;
        }
        
        public int leaderEpoch() {
            return this.leaderEpoch;
        }
        
        public List<Integer> isrReplicas() {
            return this.isrReplicas;
        }
        
        public int zkVersion() {
            return this.zkVersion;
        }
        
        public List<Integer> replicas() {
            return this.replicas;
        }
        
        public boolean isNew() {
            return this.isNew;
        }
        
        public LeaderAndIsrRequestPartitionState setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public LeaderAndIsrRequestPartitionState setControllerEpoch(int v) {
            this.controllerEpoch = v;
            return this;
        }
        
        public LeaderAndIsrRequestPartitionState setLeaderKey(int v) {
            this.leaderKey = v;
            return this;
        }
        
        public LeaderAndIsrRequestPartitionState setLeaderEpoch(int v) {
            this.leaderEpoch = v;
            return this;
        }
        
        public LeaderAndIsrRequestPartitionState setIsrReplicas(List<Integer> v) {
            this.isrReplicas = v;
            return this;
        }
        
        public LeaderAndIsrRequestPartitionState setZkVersion(int v) {
            this.zkVersion = v;
            return this;
        }
        
        public LeaderAndIsrRequestPartitionState setReplicas(List<Integer> v) {
            this.replicas = v;
            return this;
        }
        
        public LeaderAndIsrRequestPartitionState setIsNew(boolean v) {
            this.isNew = v;
            return this;
        }
    }
    
    static public class LeaderAndIsrRequestPartitionStateV0 implements Message {
        private String topicName;
        private int partitionIndex;
        private int controllerEpoch;
        private int leaderKey;
        private int leaderEpoch;
        private List<Integer> isrReplicas;
        private int zkVersion;
        private List<Integer> replicas;
        private boolean isNew;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("topic_name", Type.STRING, "The topic name."),
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("controller_epoch", Type.INT32, "The controller epoch."),
                new Field("leader_key", Type.INT32, "The broker ID of the leader."),
                new Field("leader_epoch", Type.INT32, "The leader epoch."),
                new Field("isr_replicas", new ArrayOf(Type.INT32), "The in-sync replica IDs."),
                new Field("zk_version", Type.INT32, "The ZooKeeper version."),
                new Field("replicas", new ArrayOf(Type.INT32), "The replica IDs.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("topic_name", Type.STRING, "The topic name."),
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("controller_epoch", Type.INT32, "The controller epoch."),
                new Field("leader_key", Type.INT32, "The broker ID of the leader."),
                new Field("leader_epoch", Type.INT32, "The leader epoch."),
                new Field("isr_replicas", new ArrayOf(Type.INT32), "The in-sync replica IDs."),
                new Field("zk_version", Type.INT32, "The ZooKeeper version."),
                new Field("replicas", new ArrayOf(Type.INT32), "The replica IDs."),
                new Field("is_new", Type.BOOLEAN, "Whether the replica should have existed on the broker or not.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public LeaderAndIsrRequestPartitionStateV0(Readable readable, short version) {
            this.isrReplicas = new ArrayList<Integer>();
            this.replicas = new ArrayList<Integer>();
            read(readable, version);
        }
        
        public LeaderAndIsrRequestPartitionStateV0(Struct struct, short version) {
            this.isrReplicas = new ArrayList<Integer>();
            this.replicas = new ArrayList<Integer>();
            fromStruct(struct, version);
        }
        
        public LeaderAndIsrRequestPartitionStateV0() {
            this.topicName = "";
            this.partitionIndex = 0;
            this.controllerEpoch = 0;
            this.leaderKey = 0;
            this.leaderEpoch = 0;
            this.isrReplicas = new ArrayList<Integer>();
            this.zkVersion = 0;
            this.replicas = new ArrayList<Integer>();
            this.isNew = false;
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
            if (version > 1) {
                throw new UnsupportedVersionException("Can't read version " + version + " of LeaderAndIsrRequestPartitionStateV0");
            }
            this.topicName = readable.readNullableString();
            this.partitionIndex = readable.readInt();
            this.controllerEpoch = readable.readInt();
            this.leaderKey = readable.readInt();
            this.leaderEpoch = readable.readInt();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.isrReplicas.clear();
                } else {
                    this.isrReplicas.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.isrReplicas.add(readable.readInt());
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
            if (version >= 1) {
                this.isNew = readable.readByte() != 0;
            } else {
                this.isNew = false;
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            if (version > 1) {
                throw new UnsupportedVersionException("Can't write version " + version + " of LeaderAndIsrRequestPartitionStateV0");
            }
            writable.writeString(topicName);
            writable.writeInt(partitionIndex);
            writable.writeInt(controllerEpoch);
            writable.writeInt(leaderKey);
            writable.writeInt(leaderEpoch);
            writable.writeInt(isrReplicas.size());
            for (Integer element : isrReplicas) {
                writable.writeInt(element);
            }
            writable.writeInt(zkVersion);
            writable.writeInt(replicas.size());
            for (Integer element : replicas) {
                writable.writeInt(element);
            }
            if (version >= 1) {
                writable.writeByte(isNew ? (byte) 1 : (byte) 0);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            if (version > 1) {
                throw new UnsupportedVersionException("Can't read version " + version + " of LeaderAndIsrRequestPartitionStateV0");
            }
            this.topicName = struct.getString("topic_name");
            this.partitionIndex = struct.getInt("partition_index");
            this.controllerEpoch = struct.getInt("controller_epoch");
            this.leaderKey = struct.getInt("leader_key");
            this.leaderEpoch = struct.getInt("leader_epoch");
            {
                Object[] nestedObjects = struct.getArray("isr_replicas");
                this.isrReplicas = new ArrayList<Integer>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.isrReplicas.add((Integer) nestedObject);
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
            if (version >= 1) {
                this.isNew = struct.getBoolean("is_new");
            } else {
                this.isNew = false;
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            if (version > 1) {
                throw new UnsupportedVersionException("Can't write version " + version + " of LeaderAndIsrRequestPartitionStateV0");
            }
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("topic_name", this.topicName);
            struct.set("partition_index", this.partitionIndex);
            struct.set("controller_epoch", this.controllerEpoch);
            struct.set("leader_key", this.leaderKey);
            struct.set("leader_epoch", this.leaderEpoch);
            {
                Integer[] nestedObjects = new Integer[isrReplicas.size()];
                int i = 0;
                for (Integer element : this.isrReplicas) {
                    nestedObjects[i++] = element;
                }
                struct.set("isr_replicas", (Object[]) nestedObjects);
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
            if (version >= 1) {
                struct.set("is_new", this.isNew);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            if (version > 1) {
                throw new UnsupportedVersionException("Can't size version " + version + " of LeaderAndIsrRequestPartitionStateV0");
            }
            size += 2;
            size += MessageUtil.serializedUtf8Length(topicName);
            size += 4;
            size += 4;
            size += 4;
            size += 4;
            size += 4;
            size += isrReplicas.size() * 4;
            size += 4;
            size += 4;
            size += replicas.size() * 4;
            if (version >= 1) {
                size += 1;
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof LeaderAndIsrRequestPartitionStateV0)) return false;
            LeaderAndIsrRequestPartitionStateV0 other = (LeaderAndIsrRequestPartitionStateV0) obj;
            if (this.topicName == null) {
                if (other.topicName != null) return false;
            } else {
                if (!this.topicName.equals(other.topicName)) return false;
            }
            if (partitionIndex != other.partitionIndex) return false;
            if (controllerEpoch != other.controllerEpoch) return false;
            if (leaderKey != other.leaderKey) return false;
            if (leaderEpoch != other.leaderEpoch) return false;
            if (this.isrReplicas == null) {
                if (other.isrReplicas != null) return false;
            } else {
                if (!this.isrReplicas.equals(other.isrReplicas)) return false;
            }
            if (zkVersion != other.zkVersion) return false;
            if (this.replicas == null) {
                if (other.replicas != null) return false;
            } else {
                if (!this.replicas.equals(other.replicas)) return false;
            }
            if (isNew != other.isNew) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (topicName == null ? 0 : topicName.hashCode());
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + controllerEpoch;
            hashCode = 31 * hashCode + leaderKey;
            hashCode = 31 * hashCode + leaderEpoch;
            hashCode = 31 * hashCode + (isrReplicas == null ? 0 : isrReplicas.hashCode());
            hashCode = 31 * hashCode + zkVersion;
            hashCode = 31 * hashCode + (replicas == null ? 0 : replicas.hashCode());
            hashCode = 31 * hashCode + (isNew ? 1231 : 1237);
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "LeaderAndIsrRequestPartitionStateV0("
                + "topicName='" + topicName + "'"
                + ", partitionIndex=" + partitionIndex
                + ", controllerEpoch=" + controllerEpoch
                + ", leaderKey=" + leaderKey
                + ", leaderEpoch=" + leaderEpoch
                + ", isrReplicas=" + MessageUtil.deepToString(isrReplicas.iterator())
                + ", zkVersion=" + zkVersion
                + ", replicas=" + MessageUtil.deepToString(replicas.iterator())
                + ", isNew=" + (isNew ? "true" : "false")
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
        
        public int leaderKey() {
            return this.leaderKey;
        }
        
        public int leaderEpoch() {
            return this.leaderEpoch;
        }
        
        public List<Integer> isrReplicas() {
            return this.isrReplicas;
        }
        
        public int zkVersion() {
            return this.zkVersion;
        }
        
        public List<Integer> replicas() {
            return this.replicas;
        }
        
        public boolean isNew() {
            return this.isNew;
        }
        
        public LeaderAndIsrRequestPartitionStateV0 setTopicName(String v) {
            this.topicName = v;
            return this;
        }
        
        public LeaderAndIsrRequestPartitionStateV0 setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public LeaderAndIsrRequestPartitionStateV0 setControllerEpoch(int v) {
            this.controllerEpoch = v;
            return this;
        }
        
        public LeaderAndIsrRequestPartitionStateV0 setLeaderKey(int v) {
            this.leaderKey = v;
            return this;
        }
        
        public LeaderAndIsrRequestPartitionStateV0 setLeaderEpoch(int v) {
            this.leaderEpoch = v;
            return this;
        }
        
        public LeaderAndIsrRequestPartitionStateV0 setIsrReplicas(List<Integer> v) {
            this.isrReplicas = v;
            return this;
        }
        
        public LeaderAndIsrRequestPartitionStateV0 setZkVersion(int v) {
            this.zkVersion = v;
            return this;
        }
        
        public LeaderAndIsrRequestPartitionStateV0 setReplicas(List<Integer> v) {
            this.replicas = v;
            return this;
        }
        
        public LeaderAndIsrRequestPartitionStateV0 setIsNew(boolean v) {
            this.isNew = v;
            return this;
        }
    }
    
    static public class LeaderAndIsrLiveLeader implements Message {
        private int brokerId;
        private String hostName;
        private int port;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("broker_id", Type.INT32, "The leader's broker ID."),
                new Field("host_name", Type.STRING, "The leader's hostname."),
                new Field("port", Type.INT32, "The leader's port.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public LeaderAndIsrLiveLeader(Readable readable, short version) {
            read(readable, version);
        }
        
        public LeaderAndIsrLiveLeader(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public LeaderAndIsrLiveLeader() {
            this.brokerId = 0;
            this.hostName = "";
            this.port = 0;
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
            this.brokerId = readable.readInt();
            this.hostName = readable.readNullableString();
            this.port = readable.readInt();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(brokerId);
            writable.writeString(hostName);
            writable.writeInt(port);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.brokerId = struct.getInt("broker_id");
            this.hostName = struct.getString("host_name");
            this.port = struct.getInt("port");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("broker_id", this.brokerId);
            struct.set("host_name", this.hostName);
            struct.set("port", this.port);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            size += 2;
            size += MessageUtil.serializedUtf8Length(hostName);
            size += 4;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof LeaderAndIsrLiveLeader)) return false;
            LeaderAndIsrLiveLeader other = (LeaderAndIsrLiveLeader) obj;
            if (brokerId != other.brokerId) return false;
            if (this.hostName == null) {
                if (other.hostName != null) return false;
            } else {
                if (!this.hostName.equals(other.hostName)) return false;
            }
            if (port != other.port) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + brokerId;
            hashCode = 31 * hashCode + (hostName == null ? 0 : hostName.hashCode());
            hashCode = 31 * hashCode + port;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "LeaderAndIsrLiveLeader("
                + "brokerId=" + brokerId
                + ", hostName='" + hostName + "'"
                + ", port=" + port
                + ")";
        }
        
        public int brokerId() {
            return this.brokerId;
        }
        
        public String hostName() {
            return this.hostName;
        }
        
        public int port() {
            return this.port;
        }
        
        public LeaderAndIsrLiveLeader setBrokerId(int v) {
            this.brokerId = v;
            return this;
        }
        
        public LeaderAndIsrLiveLeader setHostName(String v) {
            this.hostName = v;
            return this;
        }
        
        public LeaderAndIsrLiveLeader setPort(int v) {
            this.port = v;
            return this;
        }
    }
}
