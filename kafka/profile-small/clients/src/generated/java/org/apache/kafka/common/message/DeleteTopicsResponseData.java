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


public class DeleteTopicsResponseData implements ApiMessage {
    private int throttleTimeMs;
    private List<DeletableTopicResult> responses;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("responses", new ArrayOf(DeletableTopicResult.SCHEMA_0), "The results for each topic.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("responses", new ArrayOf(DeletableTopicResult.SCHEMA_0), "The results for each topic.")
        );
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3
    };
    
    public DeleteTopicsResponseData(Readable readable, short version) {
        this.responses = new ArrayList<DeletableTopicResult>();
        read(readable, version);
    }
    
    public DeleteTopicsResponseData(Struct struct, short version) {
        this.responses = new ArrayList<DeletableTopicResult>();
        fromStruct(struct, version);
    }
    
    public DeleteTopicsResponseData() {
        this.throttleTimeMs = 0;
        this.responses = new ArrayList<DeletableTopicResult>();
    }
    
    @Override
    public short apiKey() {
        return 20;
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
        if (version >= 1) {
            this.throttleTimeMs = readable.readInt();
        } else {
            this.throttleTimeMs = 0;
        }
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.responses.clear();
            } else {
                this.responses.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.responses.add(new DeletableTopicResult(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        if (version >= 1) {
            writable.writeInt(throttleTimeMs);
        }
        writable.writeInt(responses.size());
        for (DeletableTopicResult element : responses) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        if (version >= 1) {
            this.throttleTimeMs = struct.getInt("throttle_time_ms");
        } else {
            this.throttleTimeMs = 0;
        }
        {
            Object[] nestedObjects = struct.getArray("responses");
            this.responses = new ArrayList<DeletableTopicResult>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.responses.add(new DeletableTopicResult((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        if (version >= 1) {
            struct.set("throttle_time_ms", this.throttleTimeMs);
        }
        {
            Struct[] nestedObjects = new Struct[responses.size()];
            int i = 0;
            for (DeletableTopicResult element : this.responses) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("responses", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        if (version >= 1) {
            size += 4;
        } else {
            if (throttleTimeMs != 0) {
                throw new UnsupportedVersionException("Attempted to write a non-default throttleTimeMs at version " + version);
            }
        }
        size += 4;
        for (DeletableTopicResult element : responses) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DeleteTopicsResponseData)) return false;
        DeleteTopicsResponseData other = (DeleteTopicsResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (this.responses == null) {
            if (other.responses != null) return false;
        } else {
            if (!this.responses.equals(other.responses)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + (responses == null ? 0 : responses.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "DeleteTopicsResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", responses=" + MessageUtil.deepToString(responses.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public List<DeletableTopicResult> responses() {
        return this.responses;
    }
    
    public DeleteTopicsResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public DeleteTopicsResponseData setResponses(List<DeletableTopicResult> v) {
        this.responses = v;
        return this;
    }
    
    static public class DeletableTopicResult implements Message {
        private String name;
        private short errorCode;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name"),
                new Field("error_code", Type.INT16, "The deletion error, or 0 if the deletion succeeded.")
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
        
        public DeletableTopicResult(Readable readable, short version) {
            read(readable, version);
        }
        
        public DeletableTopicResult(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public DeletableTopicResult() {
            this.name = "";
            this.errorCode = (short) 0;
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
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeShort(errorCode);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            this.errorCode = struct.getShort("error_code");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            struct.set("error_code", this.errorCode);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            size += 2;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DeletableTopicResult)) return false;
            DeletableTopicResult other = (DeletableTopicResult) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (errorCode != other.errorCode) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + errorCode;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DeletableTopicResult("
                + "name='" + name + "'"
                + ", errorCode=" + errorCode
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public DeletableTopicResult setName(String v) {
            this.name = v;
            return this;
        }
        
        public DeletableTopicResult setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
    }
}
