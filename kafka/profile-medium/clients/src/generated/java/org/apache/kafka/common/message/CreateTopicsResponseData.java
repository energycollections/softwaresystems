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


public class CreateTopicsResponseData implements ApiMessage {
    private int throttleTimeMs;
    private CreatableTopicResultSet topics;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topics", new ArrayOf(CreatableTopicResult.SCHEMA_0), "Results for each topic we tried to create.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("topics", new ArrayOf(CreatableTopicResult.SCHEMA_1), "Results for each topic we tried to create.")
        );
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("topics", new ArrayOf(CreatableTopicResult.SCHEMA_1), "Results for each topic we tried to create.")
        );
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3
    };
    
    public CreateTopicsResponseData(Readable readable, short version) {
        this.topics = new CreatableTopicResultSet(0);
        read(readable, version);
    }
    
    public CreateTopicsResponseData(Struct struct, short version) {
        this.topics = new CreatableTopicResultSet(0);
        fromStruct(struct, version);
    }
    
    public CreateTopicsResponseData() {
        this.throttleTimeMs = 0;
        this.topics = new CreatableTopicResultSet(0);
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
        if (version >= 2) {
            this.throttleTimeMs = readable.readInt();
        } else {
            this.throttleTimeMs = 0;
        }
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topics.clear(0);
            } else {
                this.topics.clear(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    this.topics.add(new CreatableTopicResult(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        if (version >= 2) {
            writable.writeInt(throttleTimeMs);
        }
        writable.writeInt(topics.size());
        for (CreatableTopicResult element : topics) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        if (version >= 2) {
            this.throttleTimeMs = struct.getInt("throttle_time_ms");
        } else {
            this.throttleTimeMs = 0;
        }
        {
            Object[] nestedObjects = struct.getArray("topics");
            this.topics = new CreatableTopicResultSet(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topics.add(new CreatableTopicResult((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        if (version >= 2) {
            struct.set("throttle_time_ms", this.throttleTimeMs);
        }
        {
            Struct[] nestedObjects = new Struct[topics.size()];
            int i = 0;
            for (CreatableTopicResult element : this.topics) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("topics", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        if (version >= 2) {
            size += 4;
        }
        size += 4;
        for (CreatableTopicResult element : topics) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CreateTopicsResponseData)) return false;
        CreateTopicsResponseData other = (CreateTopicsResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
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
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "CreateTopicsResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public CreatableTopicResultSet topics() {
        return this.topics;
    }
    
    public CreateTopicsResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public CreateTopicsResponseData setTopics(CreatableTopicResultSet v) {
        this.topics = v;
        return this;
    }
    
    static public class CreatableTopicResult implements Message, ImplicitLinkedHashMultiSet.Element {
        private String name;
        private short errorCode;
        private String errorMessage;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no error.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
                new Field("error_message", Type.NULLABLE_STRING, "The error message, or null if there was no error.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3
        };
        
        public CreatableTopicResult(Readable readable, short version) {
            read(readable, version);
        }
        
        public CreatableTopicResult(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public CreatableTopicResult() {
            this.name = "";
            this.errorCode = (short) 0;
            this.errorMessage = "";
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
            this.errorCode = readable.readShort();
            if (version >= 1) {
                this.errorMessage = readable.readNullableString();
            } else {
                this.errorMessage = "";
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeShort(errorCode);
            if (version >= 1) {
                writable.writeNullableString(errorMessage);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            this.errorCode = struct.getShort("error_code");
            if (version >= 1) {
                this.errorMessage = struct.getString("error_message");
            } else {
                this.errorMessage = "";
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            struct.set("error_code", this.errorCode);
            if (version >= 1) {
                struct.set("error_message", this.errorMessage);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            size += 2;
            if (version >= 1) {
                size += 2;
                if (errorMessage != null) {
                    size += MessageUtil.serializedUtf8Length(errorMessage);
                }
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof CreatableTopicResult)) return false;
            CreatableTopicResult other = (CreatableTopicResult) obj;
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
            return "CreatableTopicResult("
                + "name='" + name + "'"
                + ", errorCode=" + errorCode
                + ", errorMessage='" + errorMessage + "'"
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public String errorMessage() {
            return this.errorMessage;
        }
        
        @Override
        public int next() {
            return this.next;
        }
        
        @Override
        public int prev() {
            return this.prev;
        }
        
        public CreatableTopicResult setName(String v) {
            this.name = v;
            return this;
        }
        
        public CreatableTopicResult setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public CreatableTopicResult setErrorMessage(String v) {
            this.errorMessage = v;
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
    
    public static class CreatableTopicResultSet extends ImplicitLinkedHashMultiSet<CreatableTopicResult> {
        public CreatableTopicResultSet() {
            super();
        }
        
        public CreatableTopicResultSet(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public CreatableTopicResultSet(Iterator<CreatableTopicResult> iterator) {
            super(iterator);
        }
        
        public CreatableTopicResult find(String name) {
            CreatableTopicResult key = new CreatableTopicResult();
            key.setName(name);
            return find(key);
        }
        
        public List<CreatableTopicResult> findAll(String name) {
            CreatableTopicResult key = new CreatableTopicResult();
            key.setName(name);
            return findAll(key);
        }
        
    }
}
