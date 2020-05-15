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


public class OffsetFetchRequestData implements ApiMessage {
    private String groupId;
    private List<OffsetFetchRequestTopic> topics;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("group_id", Type.STRING, "The group to fetch offsets for."),
            new Field("topics", new ArrayOf(OffsetFetchRequestTopic.SCHEMA_0), "Each topic we would like to fetch offsets for, or null to fetch offsets for all topics.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("group_id", Type.STRING, "The group to fetch offsets for."),
            new Field("topics", ArrayOf.nullable(OffsetFetchRequestTopic.SCHEMA_0), "Each topic we would like to fetch offsets for, or null to fetch offsets for all topics.")
        );
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
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
    
    public OffsetFetchRequestData(Readable readable, short version) {
        this.topics = new ArrayList<OffsetFetchRequestTopic>();
        read(readable, version);
    }
    
    public OffsetFetchRequestData(Struct struct, short version) {
        this.topics = new ArrayList<OffsetFetchRequestTopic>();
        fromStruct(struct, version);
    }
    
    public OffsetFetchRequestData() {
        this.groupId = "";
        this.topics = new ArrayList<OffsetFetchRequestTopic>();
    }
    
    @Override
    public short apiKey() {
        return 9;
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
        this.groupId = readable.readNullableString();
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topics.clear();
            } else {
                this.topics.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.topics.add(new OffsetFetchRequestTopic(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeString(groupId);
        if (topics == null) {
            writable.writeInt(-1);
        } else {
            writable.writeInt(topics.size());
            for (OffsetFetchRequestTopic element : topics) {
                element.write(writable, version);
            }
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.groupId = struct.getString("group_id");
        {
            Object[] nestedObjects = struct.getArray("topics");
            if (nestedObjects == null) {
                this.topics = null;
            } else {
                this.topics = new ArrayList<OffsetFetchRequestTopic>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.topics.add(new OffsetFetchRequestTopic((Struct) nestedObject, version));
                }
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("group_id", this.groupId);
        {
            if (topics == null) {
                struct.set("topics", null);
            } else {
                Struct[] nestedObjects = new Struct[topics.size()];
                int i = 0;
                for (OffsetFetchRequestTopic element : this.topics) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("topics", (Object[]) nestedObjects);
            }
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 2;
        size += MessageUtil.serializedUtf8Length(groupId);
        if (topics == null) {
            size += 4;
        } else {
            size += 4;
            for (OffsetFetchRequestTopic element : topics) {
                size += element.size(version);
            }
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OffsetFetchRequestData)) return false;
        OffsetFetchRequestData other = (OffsetFetchRequestData) obj;
        if (this.groupId == null) {
            if (other.groupId != null) return false;
        } else {
            if (!this.groupId.equals(other.groupId)) return false;
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
        hashCode = 31 * hashCode + (groupId == null ? 0 : groupId.hashCode());
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "OffsetFetchRequestData("
            + "groupId='" + groupId + "'"
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public String groupId() {
        return this.groupId;
    }
    
    public List<OffsetFetchRequestTopic> topics() {
        return this.topics;
    }
    
    public OffsetFetchRequestData setGroupId(String v) {
        this.groupId = v;
        return this;
    }
    
    public OffsetFetchRequestData setTopics(List<OffsetFetchRequestTopic> v) {
        this.topics = v;
        return this;
    }
    
    static public class OffsetFetchRequestTopic implements Message {
        private String name;
        private List<Integer> partitionIndexes;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, ""),
                new Field("partition_indexes", new ArrayOf(Type.INT32), "The partition indexes we would like to fetch offsets for.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
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
        
        public OffsetFetchRequestTopic(Readable readable, short version) {
            this.partitionIndexes = new ArrayList<Integer>();
            read(readable, version);
        }
        
        public OffsetFetchRequestTopic(Struct struct, short version) {
            this.partitionIndexes = new ArrayList<Integer>();
            fromStruct(struct, version);
        }
        
        public OffsetFetchRequestTopic() {
            this.name = "";
            this.partitionIndexes = new ArrayList<Integer>();
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
            writable.writeString(name);
            writable.writeInt(partitionIndexes.size());
            for (Integer element : partitionIndexes) {
                writable.writeInt(element);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
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
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            size += 4;
            size += partitionIndexes.size() * 4;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof OffsetFetchRequestTopic)) return false;
            OffsetFetchRequestTopic other = (OffsetFetchRequestTopic) obj;
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
            return "OffsetFetchRequestTopic("
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
        
        public OffsetFetchRequestTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public OffsetFetchRequestTopic setPartitionIndexes(List<Integer> v) {
            this.partitionIndexes = v;
            return this;
        }
    }
}
