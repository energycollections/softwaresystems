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


public class AlterReplicaLogDirsRequestData implements ApiMessage {
    private AlterReplicaLogDirSet dirs;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("dirs", new ArrayOf(AlterReplicaLogDir.SCHEMA_0), "The alterations to make for each directory.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public AlterReplicaLogDirsRequestData(Readable readable, short version) {
        this.dirs = new AlterReplicaLogDirSet(0);
        read(readable, version);
    }
    
    public AlterReplicaLogDirsRequestData(Struct struct, short version) {
        this.dirs = new AlterReplicaLogDirSet(0);
        fromStruct(struct, version);
    }
    
    public AlterReplicaLogDirsRequestData() {
        this.dirs = new AlterReplicaLogDirSet(0);
    }
    
    @Override
    public short apiKey() {
        return 34;
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
                this.dirs.clear(0);
            } else {
                this.dirs.clear(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    this.dirs.add(new AlterReplicaLogDir(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(dirs.size());
        for (AlterReplicaLogDir element : dirs) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        {
            Object[] nestedObjects = struct.getArray("dirs");
            this.dirs = new AlterReplicaLogDirSet(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.dirs.add(new AlterReplicaLogDir((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        {
            Struct[] nestedObjects = new Struct[dirs.size()];
            int i = 0;
            for (AlterReplicaLogDir element : this.dirs) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("dirs", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        for (AlterReplicaLogDir element : dirs) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AlterReplicaLogDirsRequestData)) return false;
        AlterReplicaLogDirsRequestData other = (AlterReplicaLogDirsRequestData) obj;
        if (this.dirs == null) {
            if (other.dirs != null) return false;
        } else {
            if (!this.dirs.equals(other.dirs)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (dirs == null ? 0 : dirs.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "AlterReplicaLogDirsRequestData("
            + "dirs=" + MessageUtil.deepToString(dirs.iterator())
            + ")";
    }
    
    public AlterReplicaLogDirSet dirs() {
        return this.dirs;
    }
    
    public AlterReplicaLogDirsRequestData setDirs(AlterReplicaLogDirSet v) {
        this.dirs = v;
        return this;
    }
    
    static public class AlterReplicaLogDir implements Message, ImplicitLinkedHashMultiSet.Element {
        private String path;
        private AlterReplicaLogDirTopicSet topics;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("path", Type.STRING, "The absolute directory path."),
                new Field("topics", new ArrayOf(AlterReplicaLogDirTopic.SCHEMA_0), "The topics to add to the directory.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public AlterReplicaLogDir(Readable readable, short version) {
            this.topics = new AlterReplicaLogDirTopicSet(0);
            read(readable, version);
        }
        
        public AlterReplicaLogDir(Struct struct, short version) {
            this.topics = new AlterReplicaLogDirTopicSet(0);
            fromStruct(struct, version);
        }
        
        public AlterReplicaLogDir() {
            this.path = "";
            this.topics = new AlterReplicaLogDirTopicSet(0);
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
            this.path = readable.readNullableString();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.topics.clear(0);
                } else {
                    this.topics.clear(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        this.topics.add(new AlterReplicaLogDirTopic(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(path);
            writable.writeInt(topics.size());
            for (AlterReplicaLogDirTopic element : topics) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.path = struct.getString("path");
            {
                Object[] nestedObjects = struct.getArray("topics");
                this.topics = new AlterReplicaLogDirTopicSet(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.topics.add(new AlterReplicaLogDirTopic((Struct) nestedObject, version));
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("path", this.path);
            {
                Struct[] nestedObjects = new Struct[topics.size()];
                int i = 0;
                for (AlterReplicaLogDirTopic element : this.topics) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("topics", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(path);
            size += 4;
            for (AlterReplicaLogDirTopic element : topics) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof AlterReplicaLogDir)) return false;
            AlterReplicaLogDir other = (AlterReplicaLogDir) obj;
            if (this.path == null) {
                if (other.path != null) return false;
            } else {
                if (!this.path.equals(other.path)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (path == null ? 0 : path.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "AlterReplicaLogDir("
                + "path='" + path + "'"
                + ", topics=" + MessageUtil.deepToString(topics.iterator())
                + ")";
        }
        
        public String path() {
            return this.path;
        }
        
        public AlterReplicaLogDirTopicSet topics() {
            return this.topics;
        }
        
        @Override
        public int next() {
            return this.next;
        }
        
        @Override
        public int prev() {
            return this.prev;
        }
        
        public AlterReplicaLogDir setPath(String v) {
            this.path = v;
            return this;
        }
        
        public AlterReplicaLogDir setTopics(AlterReplicaLogDirTopicSet v) {
            this.topics = v;
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
    
    static public class AlterReplicaLogDirTopic implements Message, ImplicitLinkedHashMultiSet.Element {
        private String name;
        private List<Integer> partitions;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(Type.INT32), "The partition indexes.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public AlterReplicaLogDirTopic(Readable readable, short version) {
            this.partitions = new ArrayList<Integer>();
            read(readable, version);
        }
        
        public AlterReplicaLogDirTopic(Struct struct, short version) {
            this.partitions = new ArrayList<Integer>();
            fromStruct(struct, version);
        }
        
        public AlterReplicaLogDirTopic() {
            this.name = "";
            this.partitions = new ArrayList<Integer>();
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
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.partitions.clear();
                } else {
                    this.partitions.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.partitions.add(readable.readInt());
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(partitions.size());
            for (Integer element : partitions) {
                writable.writeInt(element);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partitions");
                this.partitions = new ArrayList<Integer>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitions.add((Integer) nestedObject);
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            {
                Integer[] nestedObjects = new Integer[partitions.size()];
                int i = 0;
                for (Integer element : this.partitions) {
                    nestedObjects[i++] = element;
                }
                struct.set("partitions", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            size += 4;
            size += partitions.size() * 4;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof AlterReplicaLogDirTopic)) return false;
            AlterReplicaLogDirTopic other = (AlterReplicaLogDirTopic) obj;
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
            return "AlterReplicaLogDirTopic("
                + "name='" + name + "'"
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<Integer> partitions() {
            return this.partitions;
        }
        
        @Override
        public int next() {
            return this.next;
        }
        
        @Override
        public int prev() {
            return this.prev;
        }
        
        public AlterReplicaLogDirTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public AlterReplicaLogDirTopic setPartitions(List<Integer> v) {
            this.partitions = v;
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
    
    public static class AlterReplicaLogDirTopicSet extends ImplicitLinkedHashMultiSet<AlterReplicaLogDirTopic> {
        public AlterReplicaLogDirTopicSet() {
            super();
        }
        
        public AlterReplicaLogDirTopicSet(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public AlterReplicaLogDirTopicSet(Iterator<AlterReplicaLogDirTopic> iterator) {
            super(iterator);
        }
        
        public AlterReplicaLogDirTopic find(String name) {
            AlterReplicaLogDirTopic key = new AlterReplicaLogDirTopic();
            key.setName(name);
            return find(key);
        }
        
        public List<AlterReplicaLogDirTopic> findAll(String name) {
            AlterReplicaLogDirTopic key = new AlterReplicaLogDirTopic();
            key.setName(name);
            return findAll(key);
        }
        
    }
    
    public static class AlterReplicaLogDirSet extends ImplicitLinkedHashMultiSet<AlterReplicaLogDir> {
        public AlterReplicaLogDirSet() {
            super();
        }
        
        public AlterReplicaLogDirSet(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public AlterReplicaLogDirSet(Iterator<AlterReplicaLogDir> iterator) {
            super(iterator);
        }
        
        public AlterReplicaLogDir find(String path) {
            AlterReplicaLogDir key = new AlterReplicaLogDir();
            key.setPath(path);
            return find(key);
        }
        
        public List<AlterReplicaLogDir> findAll(String path) {
            AlterReplicaLogDir key = new AlterReplicaLogDir();
            key.setPath(path);
            return findAll(key);
        }
        
    }
}
