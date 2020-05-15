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


public class ApiVersionsResponseData implements ApiMessage {
    private short errorCode;
    private ApiVersionsResponseKeySet apiKeys;
    private int throttleTimeMs;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("error_code", Type.INT16, "The top-level error code."),
            new Field("api_keys", new ArrayOf(ApiVersionsResponseKey.SCHEMA_0), "The APIs supported by the broker.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("error_code", Type.INT16, "The top-level error code."),
            new Field("api_keys", new ArrayOf(ApiVersionsResponseKey.SCHEMA_0), "The APIs supported by the broker."),
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota.")
        );
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2
    };
    
    public ApiVersionsResponseData(Readable readable, short version) {
        this.apiKeys = new ApiVersionsResponseKeySet(0);
        read(readable, version);
    }
    
    public ApiVersionsResponseData(Struct struct, short version) {
        this.apiKeys = new ApiVersionsResponseKeySet(0);
        fromStruct(struct, version);
    }
    
    public ApiVersionsResponseData() {
        this.errorCode = (short) 0;
        this.apiKeys = new ApiVersionsResponseKeySet(0);
        this.throttleTimeMs = 0;
    }
    
    @Override
    public short apiKey() {
        return 18;
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
        this.errorCode = readable.readShort();
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.apiKeys.clear(0);
            } else {
                this.apiKeys.clear(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    this.apiKeys.add(new ApiVersionsResponseKey(readable, version));
                }
            }
        }
        if (version >= 1) {
            this.throttleTimeMs = readable.readInt();
        } else {
            this.throttleTimeMs = 0;
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeShort(errorCode);
        writable.writeInt(apiKeys.size());
        for (ApiVersionsResponseKey element : apiKeys) {
            element.write(writable, version);
        }
        if (version >= 1) {
            writable.writeInt(throttleTimeMs);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.errorCode = struct.getShort("error_code");
        {
            Object[] nestedObjects = struct.getArray("api_keys");
            this.apiKeys = new ApiVersionsResponseKeySet(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.apiKeys.add(new ApiVersionsResponseKey((Struct) nestedObject, version));
            }
        }
        if (version >= 1) {
            this.throttleTimeMs = struct.getInt("throttle_time_ms");
        } else {
            this.throttleTimeMs = 0;
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("error_code", this.errorCode);
        {
            Struct[] nestedObjects = new Struct[apiKeys.size()];
            int i = 0;
            for (ApiVersionsResponseKey element : this.apiKeys) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("api_keys", (Object[]) nestedObjects);
        }
        if (version >= 1) {
            struct.set("throttle_time_ms", this.throttleTimeMs);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 2;
        size += 4;
        for (ApiVersionsResponseKey element : apiKeys) {
            size += element.size(version);
        }
        if (version >= 1) {
            size += 4;
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ApiVersionsResponseData)) return false;
        ApiVersionsResponseData other = (ApiVersionsResponseData) obj;
        if (errorCode != other.errorCode) return false;
        if (this.apiKeys == null) {
            if (other.apiKeys != null) return false;
        } else {
            if (!this.apiKeys.equals(other.apiKeys)) return false;
        }
        if (throttleTimeMs != other.throttleTimeMs) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + errorCode;
        hashCode = 31 * hashCode + (apiKeys == null ? 0 : apiKeys.hashCode());
        hashCode = 31 * hashCode + throttleTimeMs;
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "ApiVersionsResponseData("
            + "errorCode=" + errorCode
            + ", apiKeys=" + MessageUtil.deepToString(apiKeys.iterator())
            + ", throttleTimeMs=" + throttleTimeMs
            + ")";
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public ApiVersionsResponseKeySet apiKeys() {
        return this.apiKeys;
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public ApiVersionsResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    public ApiVersionsResponseData setApiKeys(ApiVersionsResponseKeySet v) {
        this.apiKeys = v;
        return this;
    }
    
    public ApiVersionsResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    static public class ApiVersionsResponseKey implements Message, ImplicitLinkedHashMultiSet.Element {
        private short index;
        private short minVersion;
        private short maxVersion;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("index", Type.INT16, "The API index."),
                new Field("min_version", Type.INT16, "The minimum supported version, inclusive."),
                new Field("max_version", Type.INT16, "The maximum supported version, inclusive.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public ApiVersionsResponseKey(Readable readable, short version) {
            read(readable, version);
        }
        
        public ApiVersionsResponseKey(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public ApiVersionsResponseKey() {
            this.index = (short) 0;
            this.minVersion = (short) 0;
            this.maxVersion = (short) 0;
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
            this.index = readable.readShort();
            this.minVersion = readable.readShort();
            this.maxVersion = readable.readShort();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeShort(index);
            writable.writeShort(minVersion);
            writable.writeShort(maxVersion);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.index = struct.getShort("index");
            this.minVersion = struct.getShort("min_version");
            this.maxVersion = struct.getShort("max_version");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("index", this.index);
            struct.set("min_version", this.minVersion);
            struct.set("max_version", this.maxVersion);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += 2;
            size += 2;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ApiVersionsResponseKey)) return false;
            ApiVersionsResponseKey other = (ApiVersionsResponseKey) obj;
            if (index != other.index) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + index;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "ApiVersionsResponseKey("
                + "index=" + index
                + ", minVersion=" + minVersion
                + ", maxVersion=" + maxVersion
                + ")";
        }
        
        public short index() {
            return this.index;
        }
        
        public short minVersion() {
            return this.minVersion;
        }
        
        public short maxVersion() {
            return this.maxVersion;
        }
        
        @Override
        public int next() {
            return this.next;
        }
        
        @Override
        public int prev() {
            return this.prev;
        }
        
        public ApiVersionsResponseKey setIndex(short v) {
            this.index = v;
            return this;
        }
        
        public ApiVersionsResponseKey setMinVersion(short v) {
            this.minVersion = v;
            return this;
        }
        
        public ApiVersionsResponseKey setMaxVersion(short v) {
            this.maxVersion = v;
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
    
    public static class ApiVersionsResponseKeySet extends ImplicitLinkedHashMultiSet<ApiVersionsResponseKey> {
        public ApiVersionsResponseKeySet() {
            super();
        }
        
        public ApiVersionsResponseKeySet(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public ApiVersionsResponseKeySet(Iterator<ApiVersionsResponseKey> iterator) {
            super(iterator);
        }
        
        public ApiVersionsResponseKey find(short index) {
            ApiVersionsResponseKey key = new ApiVersionsResponseKey();
            key.setIndex(index);
            return find(key);
        }
        
        public List<ApiVersionsResponseKey> findAll(short index) {
            ApiVersionsResponseKey key = new ApiVersionsResponseKey();
            key.setIndex(index);
            return findAll(key);
        }
        
    }
}
