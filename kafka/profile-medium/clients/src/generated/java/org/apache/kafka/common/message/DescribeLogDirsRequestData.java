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


public class DescribeLogDirsRequestData implements ApiMessage {
    private List<DescribableLogDirTopic> topics;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topics", ArrayOf.nullable(DescribableLogDirTopic.SCHEMA_0), "Each topic that we want to describe log directories for, or null for all topics.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public DescribeLogDirsRequestData(Readable readable, short version) {
        this.topics = new ArrayList<DescribableLogDirTopic>();
        read(readable, version);
    }
    
    public DescribeLogDirsRequestData(Struct struct, short version) {
        this.topics = new ArrayList<DescribableLogDirTopic>();
        fromStruct(struct, version);
    }
    
    public DescribeLogDirsRequestData() {
        this.topics = new ArrayList<DescribableLogDirTopic>();
    }
    
    @Override
    public short apiKey() {
        return 35;
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
                    this.topics.add(new DescribableLogDirTopic(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        if (topics == null) {
            writable.writeInt(-1);
        } else {
            writable.writeInt(topics.size());
            for (DescribableLogDirTopic element : topics) {
                element.write(writable, version);
            }
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        {
            Object[] nestedObjects = struct.getArray("topics");
            if (nestedObjects == null) {
                this.topics = null;
            } else {
                this.topics = new ArrayList<DescribableLogDirTopic>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.topics.add(new DescribableLogDirTopic((Struct) nestedObject, version));
                }
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        {
            if (topics == null) {
                struct.set("topics", null);
            } else {
                Struct[] nestedObjects = new Struct[topics.size()];
                int i = 0;
                for (DescribableLogDirTopic element : this.topics) {
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
        if (topics == null) {
            size += 4;
        } else {
            size += 4;
            for (DescribableLogDirTopic element : topics) {
                size += element.size(version);
            }
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DescribeLogDirsRequestData)) return false;
        DescribeLogDirsRequestData other = (DescribeLogDirsRequestData) obj;
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
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "DescribeLogDirsRequestData("
            + "topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public List<DescribableLogDirTopic> topics() {
        return this.topics;
    }
    
    public DescribeLogDirsRequestData setTopics(List<DescribableLogDirTopic> v) {
        this.topics = v;
        return this;
    }
    
    static public class DescribableLogDirTopic implements Message {
        private String topic;
        private List<Integer> partitionIndex;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("topic", Type.STRING, "The topic name"),
                new Field("partition_index", new ArrayOf(Type.INT32), "The partition indxes.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public DescribableLogDirTopic(Readable readable, short version) {
            this.partitionIndex = new ArrayList<Integer>();
            read(readable, version);
        }
        
        public DescribableLogDirTopic(Struct struct, short version) {
            this.partitionIndex = new ArrayList<Integer>();
            fromStruct(struct, version);
        }
        
        public DescribableLogDirTopic() {
            this.topic = "";
            this.partitionIndex = new ArrayList<Integer>();
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
            this.topic = readable.readNullableString();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.partitionIndex.clear();
                } else {
                    this.partitionIndex.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.partitionIndex.add(readable.readInt());
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(topic);
            writable.writeInt(partitionIndex.size());
            for (Integer element : partitionIndex) {
                writable.writeInt(element);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.topic = struct.getString("topic");
            {
                Object[] nestedObjects = struct.getArray("partition_index");
                this.partitionIndex = new ArrayList<Integer>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitionIndex.add((Integer) nestedObject);
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("topic", this.topic);
            {
                Integer[] nestedObjects = new Integer[partitionIndex.size()];
                int i = 0;
                for (Integer element : this.partitionIndex) {
                    nestedObjects[i++] = element;
                }
                struct.set("partition_index", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(topic);
            size += 4;
            size += partitionIndex.size() * 4;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DescribableLogDirTopic)) return false;
            DescribableLogDirTopic other = (DescribableLogDirTopic) obj;
            if (this.topic == null) {
                if (other.topic != null) return false;
            } else {
                if (!this.topic.equals(other.topic)) return false;
            }
            if (this.partitionIndex == null) {
                if (other.partitionIndex != null) return false;
            } else {
                if (!this.partitionIndex.equals(other.partitionIndex)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (topic == null ? 0 : topic.hashCode());
            hashCode = 31 * hashCode + (partitionIndex == null ? 0 : partitionIndex.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DescribableLogDirTopic("
                + "topic='" + topic + "'"
                + ", partitionIndex=" + MessageUtil.deepToString(partitionIndex.iterator())
                + ")";
        }
        
        public String topic() {
            return this.topic;
        }
        
        public List<Integer> partitionIndex() {
            return this.partitionIndex;
        }
        
        public DescribableLogDirTopic setTopic(String v) {
            this.topic = v;
            return this;
        }
        
        public DescribableLogDirTopic setPartitionIndex(List<Integer> v) {
            this.partitionIndex = v;
            return this;
        }
    }
}
