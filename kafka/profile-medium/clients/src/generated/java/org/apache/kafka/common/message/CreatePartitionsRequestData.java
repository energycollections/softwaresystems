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


public class CreatePartitionsRequestData implements ApiMessage {
    private List<CreatePartitionsTopic> topics;
    private int timeoutMs;
    private boolean validateOnly;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topics", new ArrayOf(CreatePartitionsTopic.SCHEMA_0), "Each topic that we want to create new partitions inside."),
            new Field("timeout_ms", Type.INT32, "The time in ms to wait for the partitions to be created."),
            new Field("validate_only", Type.BOOLEAN, "If true, then validate the request, but don't actually increase the number of partitions.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public CreatePartitionsRequestData(Readable readable, short version) {
        this.topics = new ArrayList<CreatePartitionsTopic>();
        read(readable, version);
    }
    
    public CreatePartitionsRequestData(Struct struct, short version) {
        this.topics = new ArrayList<CreatePartitionsTopic>();
        fromStruct(struct, version);
    }
    
    public CreatePartitionsRequestData() {
        this.topics = new ArrayList<CreatePartitionsTopic>();
        this.timeoutMs = 0;
        this.validateOnly = false;
    }
    
    @Override
    public short apiKey() {
        return 37;
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
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topics.clear();
            } else {
                this.topics.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.topics.add(new CreatePartitionsTopic(readable, version));
                }
            }
        }
        this.timeoutMs = readable.readInt();
        this.validateOnly = readable.readByte() != 0;
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(topics.size());
        for (CreatePartitionsTopic element : topics) {
            element.write(writable, version);
        }
        writable.writeInt(timeoutMs);
        writable.writeByte(validateOnly ? (byte) 1 : (byte) 0);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        {
            Object[] nestedObjects = struct.getArray("topics");
            this.topics = new ArrayList<CreatePartitionsTopic>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topics.add(new CreatePartitionsTopic((Struct) nestedObject, version));
            }
        }
        this.timeoutMs = struct.getInt("timeout_ms");
        this.validateOnly = struct.getBoolean("validate_only");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        {
            Struct[] nestedObjects = new Struct[topics.size()];
            int i = 0;
            for (CreatePartitionsTopic element : this.topics) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("topics", (Object[]) nestedObjects);
        }
        struct.set("timeout_ms", this.timeoutMs);
        struct.set("validate_only", this.validateOnly);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        for (CreatePartitionsTopic element : topics) {
            size += element.size(version);
        }
        size += 4;
        size += 1;
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CreatePartitionsRequestData)) return false;
        CreatePartitionsRequestData other = (CreatePartitionsRequestData) obj;
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
        return "CreatePartitionsRequestData("
            + "topics=" + MessageUtil.deepToString(topics.iterator())
            + ", timeoutMs=" + timeoutMs
            + ", validateOnly=" + (validateOnly ? "true" : "false")
            + ")";
    }
    
    public List<CreatePartitionsTopic> topics() {
        return this.topics;
    }
    
    public int timeoutMs() {
        return this.timeoutMs;
    }
    
    public boolean validateOnly() {
        return this.validateOnly;
    }
    
    public CreatePartitionsRequestData setTopics(List<CreatePartitionsTopic> v) {
        this.topics = v;
        return this;
    }
    
    public CreatePartitionsRequestData setTimeoutMs(int v) {
        this.timeoutMs = v;
        return this;
    }
    
    public CreatePartitionsRequestData setValidateOnly(boolean v) {
        this.validateOnly = v;
        return this;
    }
    
    static public class CreatePartitionsTopic implements Message {
        private String name;
        private int count;
        private List<CreatePartitionsAssignment> assignments;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("count", Type.INT32, "The new partition count."),
                new Field("assignments", ArrayOf.nullable(CreatePartitionsAssignment.SCHEMA_0), "The new partition assignments.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public CreatePartitionsTopic(Readable readable, short version) {
            this.assignments = new ArrayList<CreatePartitionsAssignment>();
            read(readable, version);
        }
        
        public CreatePartitionsTopic(Struct struct, short version) {
            this.assignments = new ArrayList<CreatePartitionsAssignment>();
            fromStruct(struct, version);
        }
        
        public CreatePartitionsTopic() {
            this.name = "";
            this.count = 0;
            this.assignments = new ArrayList<CreatePartitionsAssignment>();
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
            this.count = readable.readInt();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.assignments.clear();
                } else {
                    this.assignments.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.assignments.add(new CreatePartitionsAssignment(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(count);
            if (assignments == null) {
                writable.writeInt(-1);
            } else {
                writable.writeInt(assignments.size());
                for (CreatePartitionsAssignment element : assignments) {
                    element.write(writable, version);
                }
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            this.count = struct.getInt("count");
            {
                Object[] nestedObjects = struct.getArray("assignments");
                if (nestedObjects == null) {
                    this.assignments = null;
                } else {
                    this.assignments = new ArrayList<CreatePartitionsAssignment>(nestedObjects.length);
                    for (Object nestedObject : nestedObjects) {
                        this.assignments.add(new CreatePartitionsAssignment((Struct) nestedObject, version));
                    }
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            struct.set("count", this.count);
            {
                if (assignments == null) {
                    struct.set("assignments", null);
                } else {
                    Struct[] nestedObjects = new Struct[assignments.size()];
                    int i = 0;
                    for (CreatePartitionsAssignment element : this.assignments) {
                        nestedObjects[i++] = element.toStruct(version);
                    }
                    struct.set("assignments", (Object[]) nestedObjects);
                }
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            size += 4;
            if (assignments == null) {
                size += 4;
            } else {
                size += 4;
                for (CreatePartitionsAssignment element : assignments) {
                    size += element.size(version);
                }
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof CreatePartitionsTopic)) return false;
            CreatePartitionsTopic other = (CreatePartitionsTopic) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (count != other.count) return false;
            if (this.assignments == null) {
                if (other.assignments != null) return false;
            } else {
                if (!this.assignments.equals(other.assignments)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + count;
            hashCode = 31 * hashCode + (assignments == null ? 0 : assignments.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "CreatePartitionsTopic("
                + "name='" + name + "'"
                + ", count=" + count
                + ", assignments=" + MessageUtil.deepToString(assignments.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public int count() {
            return this.count;
        }
        
        public List<CreatePartitionsAssignment> assignments() {
            return this.assignments;
        }
        
        public CreatePartitionsTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public CreatePartitionsTopic setCount(int v) {
            this.count = v;
            return this;
        }
        
        public CreatePartitionsTopic setAssignments(List<CreatePartitionsAssignment> v) {
            this.assignments = v;
            return this;
        }
    }
    
    static public class CreatePartitionsAssignment implements Message {
        private List<Integer> brokerIds;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("broker_ids", new ArrayOf(Type.INT32), "The assigned broker IDs.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public CreatePartitionsAssignment(Readable readable, short version) {
            this.brokerIds = new ArrayList<Integer>();
            read(readable, version);
        }
        
        public CreatePartitionsAssignment(Struct struct, short version) {
            this.brokerIds = new ArrayList<Integer>();
            fromStruct(struct, version);
        }
        
        public CreatePartitionsAssignment() {
            this.brokerIds = new ArrayList<Integer>();
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
            writable.writeInt(brokerIds.size());
            for (Integer element : brokerIds) {
                writable.writeInt(element);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
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
            size += brokerIds.size() * 4;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof CreatePartitionsAssignment)) return false;
            CreatePartitionsAssignment other = (CreatePartitionsAssignment) obj;
            if (this.brokerIds == null) {
                if (other.brokerIds != null) return false;
            } else {
                if (!this.brokerIds.equals(other.brokerIds)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (brokerIds == null ? 0 : brokerIds.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "CreatePartitionsAssignment("
                + "brokerIds=" + MessageUtil.deepToString(brokerIds.iterator())
                + ")";
        }
        
        public List<Integer> brokerIds() {
            return this.brokerIds;
        }
        
        public CreatePartitionsAssignment setBrokerIds(List<Integer> v) {
            this.brokerIds = v;
            return this;
        }
    }
}
