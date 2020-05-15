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
import java.util.Iterator;
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
import org.apache.kafka.common.utils.ImplicitLinkedHashMultiSet;


public class CreateTopicsRequestData implements ApiMessage {
    private List<CreatableTopic> topics;
    private int timeoutMs;
    private boolean validateOnly;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topics", new ArrayOf(CreatableTopic.SCHEMA_0), "The topics to create."),
            new Field("timeout_ms", Type.INT32, "How long to wait in milliseconds before timing out the request.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("topics", new ArrayOf(CreatableTopic.SCHEMA_0), "The topics to create."),
            new Field("timeout_ms", Type.INT32, "How long to wait in milliseconds before timing out the request."),
            new Field("validate_only", Type.BOOLEAN, "If true, check that the topics can be created as specified, but don't create anything.")
        );
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3
    };
    
    public CreateTopicsRequestData(Readable readable, short version) {
        this.topics = new ArrayList<CreatableTopic>();
        read(readable, version);
    }
    
    public CreateTopicsRequestData(Struct struct, short version) {
        this.topics = new ArrayList<CreatableTopic>();
        fromStruct(struct, version);
    }
    
    public CreateTopicsRequestData() {
        this.topics = new ArrayList<CreatableTopic>();
        this.timeoutMs = 0;
        this.validateOnly = false;
    }
    
    @Override
    public short apiKey() {
        return 19;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 3;
    }
    
    @Override
    public void read(Readable readable, short version) {
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topics.clear();
            } else {
                this.topics.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.topics.add(new CreatableTopic(readable, version));
                }
            }
        }
        this.timeoutMs = readable.readInt();
        if (version >= 1) {
            this.validateOnly = readable.readByte() != 0;
        } else {
            this.validateOnly = false;
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(topics.size());
        for (CreatableTopic element : topics) {
            element.write(writable, version);
        }
        writable.writeInt(timeoutMs);
        if (version >= 1) {
            writable.writeByte(validateOnly ? (byte) 1 : (byte) 0);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        {
            Object[] nestedObjects = struct.getArray("topics");
            this.topics = new ArrayList<CreatableTopic>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topics.add(new CreatableTopic((Struct) nestedObject, version));
            }
        }
        this.timeoutMs = struct.getInt("timeout_ms");
        if (version >= 1) {
            this.validateOnly = struct.getBoolean("validate_only");
        } else {
            this.validateOnly = false;
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        {
            Struct[] nestedObjects = new Struct[topics.size()];
            int i = 0;
            for (CreatableTopic element : this.topics) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("topics", (Object[]) nestedObjects);
        }
        struct.set("timeout_ms", this.timeoutMs);
        if (version >= 1) {
            struct.set("validate_only", this.validateOnly);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        for (CreatableTopic element : topics) {
            size += element.size(version);
        }
        size += 4;
        if (version >= 1) {
            size += 1;
        } else {
            if (validateOnly) {
                throw new UnsupportedVersionException("Attempted to write a non-default validateOnly at version " + version);
            }
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CreateTopicsRequestData)) return false;
        CreateTopicsRequestData other = (CreateTopicsRequestData) obj;
        if (this.topics == null) {
            if (other.topics != null) return false;
        } else {
            if (!this.topics.equals(other.topics)) return false;
        }
        if (timeoutMs != other.timeoutMs) return false;
        if (validateOnly != other.validateOnly) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        hashCode = 31 * hashCode + timeoutMs;
        hashCode = 31 * hashCode + (validateOnly ? 1231 : 1237);
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "CreateTopicsRequestData("
            + "topics=" + MessageUtil.deepToString(topics.iterator())
            + ", timeoutMs=" + timeoutMs
            + ", validateOnly=" + (validateOnly ? "true" : "false")
            + ")";
    }
    
    public List<CreatableTopic> topics() {
        return this.topics;
    }
    
    public int timeoutMs() {
        return this.timeoutMs;
    }
    
    public boolean validateOnly() {
        return this.validateOnly;
    }
    
    public CreateTopicsRequestData setTopics(List<CreatableTopic> v) {
        this.topics = v;
        return this;
    }
    
    public CreateTopicsRequestData setTimeoutMs(int v) {
        this.timeoutMs = v;
        return this;
    }
    
    public CreateTopicsRequestData setValidateOnly(boolean v) {
        this.validateOnly = v;
        return this;
    }
    
    static public class CreatableTopic implements Message {
        private String name;
        private int numPartitions;
        private short replicationFactor;
        private CreatableReplicaAssignmentSet assignments;
        private CreateableTopicConfigSet configs;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("num_partitions", Type.INT32, "The number of partitions to create in the topic, or -1 if we are specifying a manual partition assignment."),
                new Field("replication_factor", Type.INT16, "The number of replicas to create for each partition in the topic, or -1 if we are specifying a manual partition assignment."),
                new Field("assignments", new ArrayOf(CreatableReplicaAssignment.SCHEMA_0), "The manual partition assignment, or the empty array if we are using automatic assignment."),
                new Field("configs", new ArrayOf(CreateableTopicConfig.SCHEMA_0), "The custom topic configurations to set.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3
        };
        
        public CreatableTopic(Readable readable, short version) {
            this.assignments = new CreatableReplicaAssignmentSet(0);
            this.configs = new CreateableTopicConfigSet(0);
            read(readable, version);
        }
        
        public CreatableTopic(Struct struct, short version) {
            this.assignments = new CreatableReplicaAssignmentSet(0);
            this.configs = new CreateableTopicConfigSet(0);
            fromStruct(struct, version);
        }
        
        public CreatableTopic() {
            this.name = "";
            this.numPartitions = 0;
            this.replicationFactor = (short) 0;
            this.assignments = new CreatableReplicaAssignmentSet(0);
            this.configs = new CreateableTopicConfigSet(0);
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 3;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.name = readable.readNullableString();
            this.numPartitions = readable.readInt();
            this.replicationFactor = readable.readShort();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.assignments.clear(0);
                } else {
                    this.assignments.clear(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        this.assignments.add(new CreatableReplicaAssignment(readable, version));
                    }
                }
            }
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.configs.clear(0);
                } else {
                    this.configs.clear(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        this.configs.add(new CreateableTopicConfig(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(numPartitions);
            writable.writeShort(replicationFactor);
            writable.writeInt(assignments.size());
            for (CreatableReplicaAssignment element : assignments) {
                element.write(writable, version);
            }
            writable.writeInt(configs.size());
            for (CreateableTopicConfig element : configs) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            this.numPartitions = struct.getInt("num_partitions");
            this.replicationFactor = struct.getShort("replication_factor");
            {
                Object[] nestedObjects = struct.getArray("assignments");
                this.assignments = new CreatableReplicaAssignmentSet(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.assignments.add(new CreatableReplicaAssignment((Struct) nestedObject, version));
                }
            }
            {
                Object[] nestedObjects = struct.getArray("configs");
                this.configs = new CreateableTopicConfigSet(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.configs.add(new CreateableTopicConfig((Struct) nestedObject, version));
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            struct.set("num_partitions", this.numPartitions);
            struct.set("replication_factor", this.replicationFactor);
            {
                Struct[] nestedObjects = new Struct[assignments.size()];
                int i = 0;
                for (CreatableReplicaAssignment element : this.assignments) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("assignments", (Object[]) nestedObjects);
            }
            {
                Struct[] nestedObjects = new Struct[configs.size()];
                int i = 0;
                for (CreateableTopicConfig element : this.configs) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("configs", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            size += 4;
            size += 2;
            size += 4;
            for (CreatableReplicaAssignment element : assignments) {
                size += element.size(version);
            }
            size += 4;
            for (CreateableTopicConfig element : configs) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof CreatableTopic)) return false;
            CreatableTopic other = (CreatableTopic) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (numPartitions != other.numPartitions) return false;
            if (replicationFactor != other.replicationFactor) return false;
            if (this.assignments == null) {
                if (other.assignments != null) return false;
            } else {
                if (!this.assignments.equals(other.assignments)) return false;
            }
            if (this.configs == null) {
                if (other.configs != null) return false;
            } else {
                if (!this.configs.equals(other.configs)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + numPartitions;
            hashCode = 31 * hashCode + replicationFactor;
            hashCode = 31 * hashCode + (assignments == null ? 0 : assignments.hashCode());
            hashCode = 31 * hashCode + (configs == null ? 0 : configs.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "CreatableTopic("
                + "name='" + name + "'"
                + ", numPartitions=" + numPartitions
                + ", replicationFactor=" + replicationFactor
                + ", assignments=" + MessageUtil.deepToString(assignments.iterator())
                + ", configs=" + MessageUtil.deepToString(configs.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public int numPartitions() {
            return this.numPartitions;
        }
        
        public short replicationFactor() {
            return this.replicationFactor;
        }
        
        public CreatableReplicaAssignmentSet assignments() {
            return this.assignments;
        }
        
        public CreateableTopicConfigSet configs() {
            return this.configs;
        }
        
        public CreatableTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public CreatableTopic setNumPartitions(int v) {
            this.numPartitions = v;
            return this;
        }
        
        public CreatableTopic setReplicationFactor(short v) {
            this.replicationFactor = v;
            return this;
        }
        
        public CreatableTopic setAssignments(CreatableReplicaAssignmentSet v) {
            this.assignments = v;
            return this;
        }
        
        public CreatableTopic setConfigs(CreateableTopicConfigSet v) {
            this.configs = v;
            return this;
        }
    }
    
    static public class CreatableReplicaAssignment implements Message, ImplicitLinkedHashMultiSet.Element {
        private int partitionIndex;
        private List<Integer> brokerIds;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("broker_ids", new ArrayOf(Type.INT32), "The brokers to place the partition on.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3
        };
        
        public CreatableReplicaAssignment(Readable readable, short version) {
            this.brokerIds = new ArrayList<Integer>();
            read(readable, version);
        }
        
        public CreatableReplicaAssignment(Struct struct, short version) {
            this.brokerIds = new ArrayList<Integer>();
            fromStruct(struct, version);
        }
        
        public CreatableReplicaAssignment() {
            this.partitionIndex = 0;
            this.brokerIds = new ArrayList<Integer>();
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 3;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.partitionIndex = readable.readInt();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.brokerIds.clear();
                } else {
                    this.brokerIds.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.brokerIds.add(readable.readInt());
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionIndex);
            writable.writeInt(brokerIds.size());
            for (Integer element : brokerIds) {
                writable.writeInt(element);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionIndex = struct.getInt("partition_index");
            {
                Object[] nestedObjects = struct.getArray("broker_ids");
                this.brokerIds = new ArrayList<Integer>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.brokerIds.add((Integer) nestedObject);
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_index", this.partitionIndex);
            {
                Integer[] nestedObjects = new Integer[brokerIds.size()];
                int i = 0;
                for (Integer element : this.brokerIds) {
                    nestedObjects[i++] = element;
                }
                struct.set("broker_ids", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            size += 4;
            size += brokerIds.size() * 4;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof CreatableReplicaAssignment)) return false;
            CreatableReplicaAssignment other = (CreatableReplicaAssignment) obj;
            if (partitionIndex != other.partitionIndex) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "CreatableReplicaAssignment("
                + "partitionIndex=" + partitionIndex
                + ", brokerIds=" + MessageUtil.deepToString(brokerIds.iterator())
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public List<Integer> brokerIds() {
            return this.brokerIds;
        }
        
        @Override
        public int next() {
            return this.next;
        }
        
        @Override
        public int prev() {
            return this.prev;
        }
        
        public CreatableReplicaAssignment setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public CreatableReplicaAssignment setBrokerIds(List<Integer> v) {
            this.brokerIds = v;
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
    
    public static class CreatableReplicaAssignmentSet extends ImplicitLinkedHashMultiSet<CreatableReplicaAssignment> {
        public CreatableReplicaAssignmentSet() {
            super();
        }
        
        public CreatableReplicaAssignmentSet(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public CreatableReplicaAssignmentSet(Iterator<CreatableReplicaAssignment> iterator) {
            super(iterator);
        }
        
        public CreatableReplicaAssignment find(int partitionIndex) {
            CreatableReplicaAssignment key = new CreatableReplicaAssignment();
            key.setPartitionIndex(partitionIndex);
            return find(key);
        }
        
        public List<CreatableReplicaAssignment> findAll(int partitionIndex) {
            CreatableReplicaAssignment key = new CreatableReplicaAssignment();
            key.setPartitionIndex(partitionIndex);
            return findAll(key);
        }
        
    }
    
    static public class CreateableTopicConfig implements Message, ImplicitLinkedHashMultiSet.Element {
        private String name;
        private String value;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The configuration name."),
                new Field("value", Type.NULLABLE_STRING, "The configuration value.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3
        };
        
        public CreateableTopicConfig(Readable readable, short version) {
            read(readable, version);
        }
        
        public CreateableTopicConfig(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public CreateableTopicConfig() {
            this.name = "";
            this.value = "";
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 3;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.name = readable.readNullableString();
            this.value = readable.readNullableString();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeNullableString(value);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            this.value = struct.getString("value");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            struct.set("value", this.value);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            size += 2;
            if (value != null) {
                size += MessageUtil.serializedUtf8Length(value);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof CreateableTopicConfig)) return false;
            CreateableTopicConfig other = (CreateableTopicConfig) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "CreateableTopicConfig("
                + "name='" + name + "'"
                + ", value='" + value + "'"
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public String value() {
            return this.value;
        }
        
        @Override
        public int next() {
            return this.next;
        }
        
        @Override
        public int prev() {
            return this.prev;
        }
        
        public CreateableTopicConfig setName(String v) {
            this.name = v;
            return this;
        }
        
        public CreateableTopicConfig setValue(String v) {
            this.value = v;
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
    
    public static class CreateableTopicConfigSet extends ImplicitLinkedHashMultiSet<CreateableTopicConfig> {
        public CreateableTopicConfigSet() {
            super();
        }
        
        public CreateableTopicConfigSet(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public CreateableTopicConfigSet(Iterator<CreateableTopicConfig> iterator) {
            super(iterator);
        }
        
        public CreateableTopicConfig find(String name) {
            CreateableTopicConfig key = new CreateableTopicConfig();
            key.setName(name);
            return find(key);
        }
        
        public List<CreateableTopicConfig> findAll(String name) {
            CreateableTopicConfig key = new CreateableTopicConfig();
            key.setName(name);
            return findAll(key);
        }
        
    }
}
