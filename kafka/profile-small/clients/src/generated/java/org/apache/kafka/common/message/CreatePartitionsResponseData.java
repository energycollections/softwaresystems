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


public class CreatePartitionsResponseData implements ApiMessage {
    private int throttleTimeMs;
    private List<CreatePartitionsTopicResult> results;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("results", new ArrayOf(CreatePartitionsTopicResult.SCHEMA_0), "The partition creation results for each topic.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public CreatePartitionsResponseData(Readable readable, short version) {
        this.results = new ArrayList<CreatePartitionsTopicResult>();
        read(readable, version);
    }
    
    public CreatePartitionsResponseData(Struct struct, short version) {
        this.results = new ArrayList<CreatePartitionsTopicResult>();
        fromStruct(struct, version);
    }
    
    public CreatePartitionsResponseData() {
        this.throttleTimeMs = 0;
        this.results = new ArrayList<CreatePartitionsTopicResult>();
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
        this.throttleTimeMs = readable.readInt();
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.results.clear();
            } else {
                this.results.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.results.add(new CreatePartitionsTopicResult(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(throttleTimeMs);
        writable.writeInt(results.size());
        for (CreatePartitionsTopicResult element : results) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.throttleTimeMs = struct.getInt("throttle_time_ms");
        {
            Object[] nestedObjects = struct.getArray("results");
            this.results = new ArrayList<CreatePartitionsTopicResult>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.results.add(new CreatePartitionsTopicResult((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("throttle_time_ms", this.throttleTimeMs);
        {
            Struct[] nestedObjects = new Struct[results.size()];
            int i = 0;
            for (CreatePartitionsTopicResult element : this.results) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("results", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        size += 4;
        for (CreatePartitionsTopicResult element : results) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CreatePartitionsResponseData)) return false;
        CreatePartitionsResponseData other = (CreatePartitionsResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (this.results == null) {
            if (other.results != null) return false;
        } else {
            if (!this.results.equals(other.results)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + (results == null ? 0 : results.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "CreatePartitionsResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", results=" + MessageUtil.deepToString(results.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public List<CreatePartitionsTopicResult> results() {
        return this.results;
    }
    
    public CreatePartitionsResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public CreatePartitionsResponseData setResults(List<CreatePartitionsTopicResult> v) {
        this.results = v;
        return this;
    }
    
    static public class CreatePartitionsTopicResult implements Message {
        private String name;
        private short errorCode;
        private String errorMessage;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("error_code", Type.INT16, "The result error, or zero if there was no error."),
                new Field("error_message", Type.NULLABLE_STRING, "The result message, or null if there was no error.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public CreatePartitionsTopicResult(Readable readable, short version) {
            read(readable, version);
        }
        
        public CreatePartitionsTopicResult(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public CreatePartitionsTopicResult() {
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
            return 1;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.name = readable.readNullableString();
            this.errorCode = readable.readShort();
            this.errorMessage = readable.readNullableString();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeShort(errorCode);
            writable.writeNullableString(errorMessage);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            this.errorCode = struct.getShort("error_code");
            this.errorMessage = struct.getString("error_message");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            struct.set("error_code", this.errorCode);
            struct.set("error_message", this.errorMessage);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            size += 2;
            size += 2;
            if (errorMessage != null) {
                size += MessageUtil.serializedUtf8Length(errorMessage);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof CreatePartitionsTopicResult)) return false;
            CreatePartitionsTopicResult other = (CreatePartitionsTopicResult) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (errorCode != other.errorCode) return false;
            if (this.errorMessage == null) {
                if (other.errorMessage != null) return false;
            } else {
                if (!this.errorMessage.equals(other.errorMessage)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + errorCode;
            hashCode = 31 * hashCode + (errorMessage == null ? 0 : errorMessage.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "CreatePartitionsTopicResult("
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
        
        public CreatePartitionsTopicResult setName(String v) {
            this.name = v;
            return this;
        }
        
        public CreatePartitionsTopicResult setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public CreatePartitionsTopicResult setErrorMessage(String v) {
            this.errorMessage = v;
            return this;
        }
    }
}
