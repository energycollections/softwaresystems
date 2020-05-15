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
import java.util.Arrays;
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
import org.apache.kafka.common.utils.Bytes;


public class DescribeGroupsResponseData implements ApiMessage {
    private int throttleTimeMs;
    private List<DescribedGroup> groups;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("groups", new ArrayOf(DescribedGroup.SCHEMA_0), "Each described group.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("groups", new ArrayOf(DescribedGroup.SCHEMA_0), "Each described group.")
        );
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2
    };
    
    public DescribeGroupsResponseData(Readable readable, short version) {
        this.groups = new ArrayList<DescribedGroup>();
        read(readable, version);
    }
    
    public DescribeGroupsResponseData(Struct struct, short version) {
        this.groups = new ArrayList<DescribedGroup>();
        fromStruct(struct, version);
    }
    
    public DescribeGroupsResponseData() {
        this.throttleTimeMs = 0;
        this.groups = new ArrayList<DescribedGroup>();
    }
    
    @Override
    public short apiKey() {
        return 15;
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
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.groups.clear();
            } else {
                this.groups.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.groups.add(new DescribedGroup(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        if (version >= 1) {
            writable.writeInt(throttleTimeMs);
        }
        writable.writeInt(groups.size());
        for (DescribedGroup element : groups) {
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
            Object[] nestedObjects = struct.getArray("groups");
            this.groups = new ArrayList<DescribedGroup>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.groups.add(new DescribedGroup((Struct) nestedObject, version));
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
            Struct[] nestedObjects = new Struct[groups.size()];
            int i = 0;
            for (DescribedGroup element : this.groups) {
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
        size += 4;
        for (DescribedGroup element : groups) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DescribeGroupsResponseData)) return false;
        DescribeGroupsResponseData other = (DescribeGroupsResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
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
        hashCode = 31 * hashCode + (groups == null ? 0 : groups.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "DescribeGroupsResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", groups=" + MessageUtil.deepToString(groups.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public List<DescribedGroup> groups() {
        return this.groups;
    }
    
    public DescribeGroupsResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public DescribeGroupsResponseData setGroups(List<DescribedGroup> v) {
        this.groups = v;
        return this;
    }
    
    static public class DescribedGroup implements Message {
        private short errorCode;
        private String groupId;
        private String groupState;
        private String protocolType;
        private String protocolData;
        private List<DescribedGroupMember> members;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("error_code", Type.INT16, "The describe error, or 0 if there was no error."),
                new Field("group_id", Type.STRING, "The group ID string."),
                new Field("group_state", Type.STRING, "The group state string, or the empty string."),
                new Field("protocol_type", Type.STRING, "The group protocol type, or the empty string."),
                new Field("protocol_data", Type.STRING, "The group protocol data, or the empty string."),
                new Field("members", new ArrayOf(DescribedGroupMember.SCHEMA_0), "The group members.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public DescribedGroup(Readable readable, short version) {
            this.members = new ArrayList<DescribedGroupMember>();
            read(readable, version);
        }
        
        public DescribedGroup(Struct struct, short version) {
            this.members = new ArrayList<DescribedGroupMember>();
            fromStruct(struct, version);
        }
        
        public DescribedGroup() {
            this.errorCode = (short) 0;
            this.groupId = "";
            this.groupState = "";
            this.protocolType = "";
            this.protocolData = "";
            this.members = new ArrayList<DescribedGroupMember>();
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
            this.groupId = readable.readNullableString();
            this.groupState = readable.readNullableString();
            this.protocolType = readable.readNullableString();
            this.protocolData = readable.readNullableString();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.members.clear();
                } else {
                    this.members.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.members.add(new DescribedGroupMember(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeShort(errorCode);
            writable.writeString(groupId);
            writable.writeString(groupState);
            writable.writeString(protocolType);
            writable.writeString(protocolData);
            writable.writeInt(members.size());
            for (DescribedGroupMember element : members) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.errorCode = struct.getShort("error_code");
            this.groupId = struct.getString("group_id");
            this.groupState = struct.getString("group_state");
            this.protocolType = struct.getString("protocol_type");
            this.protocolData = struct.getString("protocol_data");
            {
                Object[] nestedObjects = struct.getArray("members");
                this.members = new ArrayList<DescribedGroupMember>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.members.add(new DescribedGroupMember((Struct) nestedObject, version));
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("error_code", this.errorCode);
            struct.set("group_id", this.groupId);
            struct.set("group_state", this.groupState);
            struct.set("protocol_type", this.protocolType);
            struct.set("protocol_data", this.protocolData);
            {
                Struct[] nestedObjects = new Struct[members.size()];
                int i = 0;
                for (DescribedGroupMember element : this.members) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("members", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += 2;
            size += MessageUtil.serializedUtf8Length(groupId);
            size += 2;
            size += MessageUtil.serializedUtf8Length(groupState);
            size += 2;
            size += MessageUtil.serializedUtf8Length(protocolType);
            size += 2;
            size += MessageUtil.serializedUtf8Length(protocolData);
            size += 4;
            for (DescribedGroupMember element : members) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DescribedGroup)) return false;
            DescribedGroup other = (DescribedGroup) obj;
            if (errorCode != other.errorCode) return false;
            if (this.groupId == null) {
                if (other.groupId != null) return false;
            } else {
                if (!this.groupId.equals(other.groupId)) return false;
            }
            if (this.groupState == null) {
                if (other.groupState != null) return false;
            } else {
                if (!this.groupState.equals(other.groupState)) return false;
            }
            if (this.protocolType == null) {
                if (other.protocolType != null) return false;
            } else {
                if (!this.protocolType.equals(other.protocolType)) return false;
            }
            if (this.protocolData == null) {
                if (other.protocolData != null) return false;
            } else {
                if (!this.protocolData.equals(other.protocolData)) return false;
            }
            if (this.members == null) {
                if (other.members != null) return false;
            } else {
                if (!this.members.equals(other.members)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + errorCode;
            hashCode = 31 * hashCode + (groupId == null ? 0 : groupId.hashCode());
            hashCode = 31 * hashCode + (groupState == null ? 0 : groupState.hashCode());
            hashCode = 31 * hashCode + (protocolType == null ? 0 : protocolType.hashCode());
            hashCode = 31 * hashCode + (protocolData == null ? 0 : protocolData.hashCode());
            hashCode = 31 * hashCode + (members == null ? 0 : members.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DescribedGroup("
                + "errorCode=" + errorCode
                + ", groupId='" + groupId + "'"
                + ", groupState='" + groupState + "'"
                + ", protocolType='" + protocolType + "'"
                + ", protocolData='" + protocolData + "'"
                + ", members=" + MessageUtil.deepToString(members.iterator())
                + ")";
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public String groupId() {
            return this.groupId;
        }
        
        public String groupState() {
            return this.groupState;
        }
        
        public String protocolType() {
            return this.protocolType;
        }
        
        public String protocolData() {
            return this.protocolData;
        }
        
        public List<DescribedGroupMember> members() {
            return this.members;
        }
        
        public DescribedGroup setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public DescribedGroup setGroupId(String v) {
            this.groupId = v;
            return this;
        }
        
        public DescribedGroup setGroupState(String v) {
            this.groupState = v;
            return this;
        }
        
        public DescribedGroup setProtocolType(String v) {
            this.protocolType = v;
            return this;
        }
        
        public DescribedGroup setProtocolData(String v) {
            this.protocolData = v;
            return this;
        }
        
        public DescribedGroup setMembers(List<DescribedGroupMember> v) {
            this.members = v;
            return this;
        }
    }
    
    static public class DescribedGroupMember implements Message {
        private String memberId;
        private String clientId;
        private String clientHost;
        private byte[] memberMetadata;
        private byte[] memberAssignment;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("member_id", Type.STRING, "The member ID assigned by the group coordinator."),
                new Field("client_id", Type.STRING, "The client ID used in the member's latest join group request."),
                new Field("client_host", Type.STRING, "The client host."),
                new Field("member_metadata", Type.BYTES, "The metadata corresponding to the current group protocol in use."),
                new Field("member_assignment", Type.BYTES, "The current assignment provided by the group leader.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public DescribedGroupMember(Readable readable, short version) {
            read(readable, version);
        }
        
        public DescribedGroupMember(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public DescribedGroupMember() {
            this.memberId = "";
            this.clientId = "";
            this.clientHost = "";
            this.memberMetadata = Bytes.EMPTY;
            this.memberAssignment = Bytes.EMPTY;
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
            this.memberId = readable.readNullableString();
            this.clientId = readable.readNullableString();
            this.clientHost = readable.readNullableString();
            this.memberMetadata = readable.readNullableBytes();
            this.memberAssignment = readable.readNullableBytes();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(memberId);
            writable.writeString(clientId);
            writable.writeString(clientHost);
            writable.writeBytes(memberMetadata);
            writable.writeBytes(memberAssignment);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.memberId = struct.getString("member_id");
            this.clientId = struct.getString("client_id");
            this.clientHost = struct.getString("client_host");
            this.memberMetadata = struct.getByteArray("member_metadata");
            this.memberAssignment = struct.getByteArray("member_assignment");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("member_id", this.memberId);
            struct.set("client_id", this.clientId);
            struct.set("client_host", this.clientHost);
            struct.setByteArray("member_metadata", this.memberMetadata);
            struct.setByteArray("member_assignment", this.memberAssignment);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(memberId);
            size += 2;
            size += MessageUtil.serializedUtf8Length(clientId);
            size += 2;
            size += MessageUtil.serializedUtf8Length(clientHost);
            size += 4;
            size += memberMetadata.length;
            size += 4;
            size += memberAssignment.length;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DescribedGroupMember)) return false;
            DescribedGroupMember other = (DescribedGroupMember) obj;
            if (this.memberId == null) {
                if (other.memberId != null) return false;
            } else {
                if (!this.memberId.equals(other.memberId)) return false;
            }
            if (this.clientId == null) {
                if (other.clientId != null) return false;
            } else {
                if (!this.clientId.equals(other.clientId)) return false;
            }
            if (this.clientHost == null) {
                if (other.clientHost != null) return false;
            } else {
                if (!this.clientHost.equals(other.clientHost)) return false;
            }
            if (!Arrays.equals(this.memberMetadata, other.memberMetadata)) return false;
            if (!Arrays.equals(this.memberAssignment, other.memberAssignment)) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (memberId == null ? 0 : memberId.hashCode());
            hashCode = 31 * hashCode + (clientId == null ? 0 : clientId.hashCode());
            hashCode = 31 * hashCode + (clientHost == null ? 0 : clientHost.hashCode());
            hashCode = 31 * hashCode + Arrays.hashCode(memberMetadata);
            hashCode = 31 * hashCode + Arrays.hashCode(memberAssignment);
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DescribedGroupMember("
                + "memberId='" + memberId + "'"
                + ", clientId='" + clientId + "'"
                + ", clientHost='" + clientHost + "'"
                + ", memberMetadata=" + Arrays.toString(memberMetadata)
                + ", memberAssignment=" + Arrays.toString(memberAssignment)
                + ")";
        }
        
        public String memberId() {
            return this.memberId;
        }
        
        public String clientId() {
            return this.clientId;
        }
        
        public String clientHost() {
            return this.clientHost;
        }
        
        public byte[] memberMetadata() {
            return this.memberMetadata;
        }
        
        public byte[] memberAssignment() {
            return this.memberAssignment;
        }
        
        public DescribedGroupMember setMemberId(String v) {
            this.memberId = v;
            return this;
        }
        
        public DescribedGroupMember setClientId(String v) {
            this.clientId = v;
            return this;
        }
        
        public DescribedGroupMember setClientHost(String v) {
            this.clientHost = v;
            return this;
        }
        
        public DescribedGroupMember setMemberMetadata(byte[] v) {
            this.memberMetadata = v;
            return this;
        }
        
        public DescribedGroupMember setMemberAssignment(byte[] v) {
            this.memberAssignment = v;
            return this;
        }
    }
}
