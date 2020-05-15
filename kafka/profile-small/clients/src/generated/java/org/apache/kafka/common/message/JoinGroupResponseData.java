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


public class JoinGroupResponseData implements ApiMessage {
    private int throttleTimeMs;
    private short errorCode;
    private int generationId;
    private String protocolName;
    private String leader;
    private String memberId;
    private List<JoinGroupResponseMember> members;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
            new Field("generation_id", Type.INT32, "The generation ID of the group."),
            new Field("protocol_name", Type.STRING, "The group protocol selected by the coordinator."),
            new Field("leader", Type.STRING, "The leader of the group."),
            new Field("member_id", Type.STRING, "The member ID assigned by the group coordinator."),
            new Field("members", new ArrayOf(JoinGroupResponseMember.SCHEMA_0), "")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
            new Field("generation_id", Type.INT32, "The generation ID of the group."),
            new Field("protocol_name", Type.STRING, "The group protocol selected by the coordinator."),
            new Field("leader", Type.STRING, "The leader of the group."),
            new Field("member_id", Type.STRING, "The member ID assigned by the group coordinator."),
            new Field("members", new ArrayOf(JoinGroupResponseMember.SCHEMA_0), "")
        );
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema SCHEMA_4 = SCHEMA_3;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3,
        SCHEMA_4
    };
    
    public JoinGroupResponseData(Readable readable, short version) {
        this.members = new ArrayList<JoinGroupResponseMember>();
        read(readable, version);
    }
    
    public JoinGroupResponseData(Struct struct, short version) {
        this.members = new ArrayList<JoinGroupResponseMember>();
        fromStruct(struct, version);
    }
    
    public JoinGroupResponseData() {
        this.throttleTimeMs = 0;
        this.errorCode = (short) 0;
        this.generationId = 0;
        this.protocolName = "";
        this.leader = "";
        this.memberId = "";
        this.members = new ArrayList<JoinGroupResponseMember>();
    }
    
    @Override
    public short apiKey() {
        return 11;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 4;
    }
    
    @Override
    public void read(Readable readable, short version) {
        if (version >= 2) {
            this.throttleTimeMs = readable.readInt();
        } else {
            this.throttleTimeMs = 0;
        }
        this.errorCode = readable.readShort();
        this.generationId = readable.readInt();
        this.protocolName = readable.readNullableString();
        this.leader = readable.readNullableString();
        this.memberId = readable.readNullableString();
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.members.clear();
            } else {
                this.members.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.members.add(new JoinGroupResponseMember(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        if (version >= 2) {
            writable.writeInt(throttleTimeMs);
        }
        writable.writeShort(errorCode);
        writable.writeInt(generationId);
        writable.writeString(protocolName);
        writable.writeString(leader);
        writable.writeString(memberId);
        writable.writeInt(members.size());
        for (JoinGroupResponseMember element : members) {
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
        this.errorCode = struct.getShort("error_code");
        this.generationId = struct.getInt("generation_id");
        this.protocolName = struct.getString("protocol_name");
        this.leader = struct.getString("leader");
        this.memberId = struct.getString("member_id");
        {
            Object[] nestedObjects = struct.getArray("members");
            this.members = new ArrayList<JoinGroupResponseMember>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.members.add(new JoinGroupResponseMember((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        if (version >= 2) {
            struct.set("throttle_time_ms", this.throttleTimeMs);
        }
        struct.set("error_code", this.errorCode);
        struct.set("generation_id", this.generationId);
        struct.set("protocol_name", this.protocolName);
        struct.set("leader", this.leader);
        struct.set("member_id", this.memberId);
        {
            Struct[] nestedObjects = new Struct[members.size()];
            int i = 0;
            for (JoinGroupResponseMember element : this.members) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("members", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        if (version >= 2) {
            size += 4;
        }
        size += 2;
        size += 4;
        size += 2;
        size += MessageUtil.serializedUtf8Length(protocolName);
        size += 2;
        size += MessageUtil.serializedUtf8Length(leader);
        size += 2;
        size += MessageUtil.serializedUtf8Length(memberId);
        size += 4;
        for (JoinGroupResponseMember element : members) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof JoinGroupResponseData)) return false;
        JoinGroupResponseData other = (JoinGroupResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (errorCode != other.errorCode) return false;
        if (generationId != other.generationId) return false;
        if (this.protocolName == null) {
            if (other.protocolName != null) return false;
        } else {
            if (!this.protocolName.equals(other.protocolName)) return false;
        }
        if (this.leader == null) {
            if (other.leader != null) return false;
        } else {
            if (!this.leader.equals(other.leader)) return false;
        }
        if (this.memberId == null) {
            if (other.memberId != null) return false;
        } else {
            if (!this.memberId.equals(other.memberId)) return false;
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
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + errorCode;
        hashCode = 31 * hashCode + generationId;
        hashCode = 31 * hashCode + (protocolName == null ? 0 : protocolName.hashCode());
        hashCode = 31 * hashCode + (leader == null ? 0 : leader.hashCode());
        hashCode = 31 * hashCode + (memberId == null ? 0 : memberId.hashCode());
        hashCode = 31 * hashCode + (members == null ? 0 : members.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "JoinGroupResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", errorCode=" + errorCode
            + ", generationId=" + generationId
            + ", protocolName='" + protocolName + "'"
            + ", leader='" + leader + "'"
            + ", memberId='" + memberId + "'"
            + ", members=" + MessageUtil.deepToString(members.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public int generationId() {
        return this.generationId;
    }
    
    public String protocolName() {
        return this.protocolName;
    }
    
    public String leader() {
        return this.leader;
    }
    
    public String memberId() {
        return this.memberId;
    }
    
    public List<JoinGroupResponseMember> members() {
        return this.members;
    }
    
    public JoinGroupResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public JoinGroupResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    public JoinGroupResponseData setGenerationId(int v) {
        this.generationId = v;
        return this;
    }
    
    public JoinGroupResponseData setProtocolName(String v) {
        this.protocolName = v;
        return this;
    }
    
    public JoinGroupResponseData setLeader(String v) {
        this.leader = v;
        return this;
    }
    
    public JoinGroupResponseData setMemberId(String v) {
        this.memberId = v;
        return this;
    }
    
    public JoinGroupResponseData setMembers(List<JoinGroupResponseMember> v) {
        this.members = v;
        return this;
    }
    
    static public class JoinGroupResponseMember implements Message {
        private String memberId;
        private byte[] metadata;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("member_id", Type.STRING, "The group member ID."),
                new Field("metadata", Type.BYTES, "The group member metadata.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4
        };
        
        public JoinGroupResponseMember(Readable readable, short version) {
            read(readable, version);
        }
        
        public JoinGroupResponseMember(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public JoinGroupResponseMember() {
            this.memberId = "";
            this.metadata = Bytes.EMPTY;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 4;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.memberId = readable.readNullableString();
            this.metadata = readable.readNullableBytes();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(memberId);
            writable.writeBytes(metadata);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.memberId = struct.getString("member_id");
            this.metadata = struct.getByteArray("metadata");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("member_id", this.memberId);
            struct.setByteArray("metadata", this.metadata);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(memberId);
            size += 4;
            size += metadata.length;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof JoinGroupResponseMember)) return false;
            JoinGroupResponseMember other = (JoinGroupResponseMember) obj;
            if (this.memberId == null) {
                if (other.memberId != null) return false;
            } else {
                if (!this.memberId.equals(other.memberId)) return false;
            }
            if (!Arrays.equals(this.metadata, other.metadata)) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (memberId == null ? 0 : memberId.hashCode());
            hashCode = 31 * hashCode + Arrays.hashCode(metadata);
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "JoinGroupResponseMember("
                + "memberId='" + memberId + "'"
                + ", metadata=" + Arrays.toString(metadata)
                + ")";
        }
        
        public String memberId() {
            return this.memberId;
        }
        
        public byte[] metadata() {
            return this.metadata;
        }
        
        public JoinGroupResponseMember setMemberId(String v) {
            this.memberId = v;
            return this;
        }
        
        public JoinGroupResponseMember setMetadata(byte[] v) {
            this.metadata = v;
            return this;
        }
    }
}
