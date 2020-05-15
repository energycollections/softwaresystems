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


public class MetadataRequestData implements ApiMessage {
    private List<MetadataRequestTopic> topics;
    private boolean allowAutoTopicCreation;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topics", new ArrayOf(MetadataRequestTopic.SCHEMA_0), "The topics to fetch metadata for.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("topics", ArrayOf.nullable(MetadataRequestTopic.SCHEMA_0), "The topics to fetch metadata for.")
        );
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema SCHEMA_4 =
        new Schema(
            new Field("topics", ArrayOf.nullable(MetadataRequestTopic.SCHEMA_0), "The topics to fetch metadata for."),
            new Field("allow_auto_topic_creation", Type.BOOLEAN, "If this is true, the broker may auto-create topics that we requested which do not already exist, if it is configured to do so.")
        );
    
    public static final Schema SCHEMA_5 = SCHEMA_4;
    
    public static final Schema SCHEMA_6 = SCHEMA_5;
    
    public static final Schema SCHEMA_7 = SCHEMA_6;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3,
        SCHEMA_4,
        SCHEMA_5,
        SCHEMA_6,
        SCHEMA_7
    };
    
    public MetadataRequestData(Readable readable, short version) {
        this.topics = new ArrayList<MetadataRequestTopic>();
        read(readable, version);
    }
    
    public MetadataRequestData(Struct struct, short version) {
        this.topics = new ArrayList<MetadataRequestTopic>();
        fromStruct(struct, version);
    }
    
    public MetadataRequestData() {
        this.topics = new ArrayList<MetadataRequestTopic>();
        this.allowAutoTopicCreation = true;
    }
    
    @Override
    public short apiKey() {
        return 3;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 7;
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
                    this.topics.add(new MetadataRequestTopic(readable, version));
                }
            }
        }
        if (version >= 4) {
            this.allowAutoTopicCreation = readable.readByte() != 0;
        } else {
            this.allowAutoTopicCreation = true;
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        if (topics == null) {
            writable.writeInt(-1);
        } else {
            writable.writeInt(topics.size());
            for (MetadataRequestTopic element : topics) {
                element.write(writable, version);
            }
        }
        if (version >= 4) {
            writable.writeByte(allowAutoTopicCreation ? (byte) 1 : (byte) 0);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        {
            Object[] nestedObjects = struct.getArray("topics");
            if (nestedObjects == null) {
                this.topics = null;
            } else {
                this.topics = new ArrayList<MetadataRequestTopic>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.topics.add(new MetadataRequestTopic((Struct) nestedObject, version));
                }
            }
        }
        if (version >= 4) {
            this.allowAutoTopicCreation = struct.getBoolean("allow_auto_topic_creation");
        } else {
            this.allowAutoTopicCreation = true;
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
                for (MetadataRequestTopic element : this.topics) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("topics", (Object[]) nestedObjects);
            }
        }
        if (version >= 4) {
            struct.set("allow_auto_topic_creation", this.allowAutoTopicCreation);
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
            for (MetadataRequestTopic element : topics) {
                size += element.size(version);
            }
        }
        if (version >= 4) {
            size += 1;
        } else {
            if (!allowAutoTopicCreation) {
                throw new UnsupportedVersionException("Attempted to write a non-default allowAutoTopicCreation at version " + version);
            }
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MetadataRequestData)) return false;
        MetadataRequestData other = (MetadataRequestData) obj;
        if (this.topics == null) {
            if (other.topics != null) return false;
        } else {
            if (!this.topics.equals(other.topics)) return false;
        }
        if (allowAutoTopicCreation != other.allowAutoTopicCreation) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        hashCode = 31 * hashCode + (allowAutoTopicCreation ? 1231 : 1237);
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "MetadataRequestData("
            + "topics=" + MessageUtil.deepToString(topics.iterator())
            + ", allowAutoTopicCreation=" + (allowAutoTopicCreation ? "true" : "false")
            + ")";
    }
    
    public List<MetadataRequestTopic> topics() {
        return this.topics;
    }
    
    public boolean allowAutoTopicCreation() {
        return this.allowAutoTopicCreation;
    }
    
    public MetadataRequestData setTopics(List<MetadataRequestTopic> v) {
        this.topics = v;
        return this;
    }
    
    public MetadataRequestData setAllowAutoTopicCreation(boolean v) {
        this.allowAutoTopicCreation = v;
        return this;
    }
    
    static public class MetadataRequestTopic implements Message {
        private String name;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5,
            SCHEMA_6,
            SCHEMA_7
        };
        
        public MetadataRequestTopic(Readable readable, short version) {
            read(readable, version);
        }
        
        public MetadataRequestTopic(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public MetadataRequestTopic() {
            this.name = "";
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 7;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.name = readable.readNullableString();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MetadataRequestTopic)) return false;
            MetadataRequestTopic other = (MetadataRequestTopic) obj;
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
            return "MetadataRequestTopic("
                + "name='" + name + "'"
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public MetadataRequestTopic setName(String v) {
            this.name = v;
            return this;
        }
    }
}
