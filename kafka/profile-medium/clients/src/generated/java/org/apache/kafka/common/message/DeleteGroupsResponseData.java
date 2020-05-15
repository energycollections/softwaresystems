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


public class DeleteGroupsResponseData implements ApiMessage {
    private int throttleTimeMs;
    private DeletableGroupResultSet results;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("results", new ArrayOf(DeletableGroupResult.SCHEMA_0), "The deletion results")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public DeleteGroupsResponseData(Readable readable, short version) {
        this.results = new DeletableGroupResultSet(0);
        read(readable, version);
    }
    
    public DeleteGroupsResponseData(Struct struct, short version) {
        this.results = new DeletableGroupResultSet(0);
        fromStruct(struct, version);
    }
    
    public DeleteGroupsResponseData() {
        this.throttleTimeMs = 0;
        this.results = new DeletableGroupResultSet(0);
    }
    
    @Override
    public short apiKey() {
        return 42;
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
                this.results.clear(0);
            } else {
                this.results.clear(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    this.results.add(new DeletableGroupResult(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(throttleTimeMs);
        writable.writeInt(results.size());
        for (DeletableGroupResult element : results) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.throttleTimeMs = struct.getInt("throttle_time_ms");
        {
            Object[] nestedObjects = struct.getArray("results");
            this.results = new DeletableGroupResultSet(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.results.add(new DeletableGroupResult((Struct) nestedObject, version));
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
            for (DeletableGroupResult element : this.results) {
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
        for (DeletableGroupResult element : results) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DeleteGroupsResponseData)) return false;
        DeleteGroupsResponseData other = (DeleteGroupsResponseData) obj;
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
        return "DeleteGroupsResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", results=" + MessageUtil.deepToString(results.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public DeletableGroupResultSet results() {
        return this.results;
    }
    
    public DeleteGroupsResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public DeleteGroupsResponseData setResults(DeletableGroupResultSet v) {
        this.results = v;
        return this;
    }
    
    static public class DeletableGroupResult implements Message, ImplicitLinkedHashMultiSet.Element {
        private String groupId;
        private short errorCode;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("group_id", Type.STRING, "The group id"),
                new Field("error_code", Type.INT16, "The deletion error, or 0 if the deletion succeeded.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public DeletableGroupResult(Readable readable, short version) {
            read(readable, version);
        }
        
        public DeletableGroupResult(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public DeletableGroupResult() {
            this.groupId = "";
            this.errorCode = (short) 0;
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
            this.groupId = readable.readNullableString();
            this.errorCode = readable.readShort();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(groupId);
            writable.writeShort(errorCode);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.groupId = struct.getString("group_id");
            this.errorCode = struct.getShort("error_code");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("group_id", this.groupId);
            struct.set("error_code", this.errorCode);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(groupId);
            size += 2;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DeletableGroupResult)) return false;
            DeletableGroupResult other = (DeletableGroupResult) obj;
            if (this.groupId == null) {
                if (other.groupId != null) return false;
            } else {
                if (!this.groupId.equals(other.groupId)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (groupId == null ? 0 : groupId.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DeletableGroupResult("
                + "groupId='" + groupId + "'"
                + ", errorCode=" + errorCode
                + ")";
        }
        
        public String groupId() {
            return this.groupId;
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        @Override
        public int next() {
            return this.next;
        }
        
        @Override
        public int prev() {
            return this.prev;
        }
        
        public DeletableGroupResult setGroupId(String v) {
            this.groupId = v;
            return this;
        }
        
        public DeletableGroupResult setErrorCode(short v) {
            this.errorCode = v;
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
    
    public static class DeletableGroupResultSet extends ImplicitLinkedHashMultiSet<DeletableGroupResult> {
        public DeletableGroupResultSet() {
            super();
        }
        
        public DeletableGroupResultSet(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public DeletableGroupResultSet(Iterator<DeletableGroupResult> iterator) {
            super(iterator);
        }
        
        public DeletableGroupResult find(String groupId) {
            DeletableGroupResult key = new DeletableGroupResult();
            key.setGroupId(groupId);
            return find(key);
        }
        
        public List<DeletableGroupResult> findAll(String groupId) {
            DeletableGroupResult key = new DeletableGroupResult();
            key.setGroupId(groupId);
            return findAll(key);
        }
        
    }
}
