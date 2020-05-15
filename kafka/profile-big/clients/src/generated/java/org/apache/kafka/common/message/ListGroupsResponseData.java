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


public class ListGroupsResponseData implements ApiMessage {
    private int throttleTimeMs;
    private short errorCode;
    private List<ListedGroup> groups;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
            new Field("groups", new ArrayOf(ListedGroup.SCHEMA_0), "Each group in the response.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
            new Field("groups", new ArrayOf(ListedGroup.SCHEMA_0), "Each group in the response.")
        );
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2
    };
    
    public ListGroupsResponseData(Readable readable, short version) {
        this.groups = new ArrayList<ListedGroup>();
        read(readable, version);
    }
    
    public ListGroupsResponseData(Struct struct, short version) {
        this.groups = new ArrayList<ListedGroup>();
        fromStruct(struct, version);
    }
    
    public ListGroupsResponseData() {
        this.throttleTimeMs = 0;
        this.errorCode = (short) 0;
        this.groups = new ArrayList<ListedGroup>();
    }
    
    @Override
    public short apiKey() {
        return 16;
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
        if (version >= 1) {
            this.throttleTimeMs = readable.readInt();
        } else {
            this.throttleTimeMs = 0;
        }
        this.errorCode = readable.readShort();
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.groups.clear();
            } else {
                this.groups.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.groups.add(new ListedGroup(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        if (version >= 1) {
            writable.writeInt(throttleTimeMs);
        }
        writable.writeShort(errorCode);
        writable.writeInt(groups.size());
        for (ListedGroup element : groups) {
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
        this.errorCode = struct.getShort("error_code");
        {
            Object[] nestedObjects = struct.getArray("groups");
            this.groups = new ArrayList<ListedGroup>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.groups.add(new ListedGroup((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        if (version >= 1) {
            struct.set("throttle_time_ms", this.throttleTimeMs);
        }
        struct.set("error_code", this.errorCode);
        {
            Struct[] nestedObjects = new Struct[groups.size()];
            int i = 0;
            for (ListedGroup element : this.groups) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("groups", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        if (version >= 1) {
            size += 4;
        }
        size += 2;
        size += 4;
        for (ListedGroup element : groups) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ListGroupsResponseData)) return false;
        ListGroupsResponseData other = (ListGroupsResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (errorCode != other.errorCode) return false;
        if (this.groups == null) {
            if (other.groups != null) return false;
        } else {
            if (!this.groups.equals(other.groups)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + errorCode;
        hashCode = 31 * hashCode + (groups == null ? 0 : groups.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "ListGroupsResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", errorCode=" + errorCode
            + ", groups=" + MessageUtil.deepToString(groups.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public List<ListedGroup> groups() {
        return this.groups;
    }
    
    public ListGroupsResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public ListGroupsResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    public ListGroupsResponseData setGroups(List<ListedGroup> v) {
        this.groups = v;
        return this;
    }
    
    static public class ListedGroup implements Message {
        private String groupId;
        private String protocolType;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("group_id", Type.STRING, "The group ID."),
                new Field("protocol_type", Type.STRING, "The group protocol type.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public ListedGroup(Readable readable, short version) {
            read(readable, version);
        }
        
        public ListedGroup(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public ListedGroup() {
            this.groupId = "";
            this.protocolType = "";
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
            this.groupId = readable.readNullableString();
            this.protocolType = readable.readNullableString();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(groupId);
            writable.writeString(protocolType);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.groupId = struct.getString("group_id");
            this.protocolType = struct.getString("protocol_type");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("group_id", this.groupId);
            struct.set("protocol_type", this.protocolType);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(groupId);
            size += 2;
            size += MessageUtil.serializedUtf8Length(protocolType);
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ListedGroup)) return false;
            ListedGroup other = (ListedGroup) obj;
            if (this.groupId == null) {
                if (other.groupId != null) return false;
            } else {
                if (!this.groupId.equals(other.groupId)) return false;
            }
            if (this.protocolType == null) {
                if (other.protocolType != null) return false;
            } else {
                if (!this.protocolType.equals(other.protocolType)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (groupId == null ? 0 : groupId.hashCode());
            hashCode = 31 * hashCode + (protocolType == null ? 0 : protocolType.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "ListedGroup("
                + "groupId='" + groupId + "'"
                + ", protocolType='" + protocolType + "'"
                + ")";
        }
        
        public String groupId() {
            return this.groupId;
        }
        
        public String protocolType() {
            return this.protocolType;
        }
        
        public ListedGroup setGroupId(String v) {
            this.groupId = v;
            return this;
        }
        
        public ListedGroup setProtocolType(String v) {
            this.protocolType = v;
            return this;
        }
    }
}
