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

import java.util.Arrays;
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
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.common.utils.ImplicitLinkedHashMultiSet;


public class JoinGroupRequestData implements ApiMessage {
    private String groupId;
    private int sessionTimeoutMs;
    private int rebalanceTimeoutMs;
    private String memberId;
    private String protocolType;
    private JoinGroupRequestProtocolSet protocols;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("group_id", Type.STRING, "The group identifier."),
            new Field("session_timeout_ms", Type.INT32, "The coordinator considers the consumer dead if it receives no heartbeat after this timeout in milliseconds."),
            new Field("member_id", Type.STRING, "The member id assigned by the group coordinator."),
            new Field("protocol_type", Type.STRING, "The unique name the for class of protocols implemented by the group we want to join."),
            new Field("protocols", new ArrayOf(JoinGroupRequestProtocol.SCHEMA_0), "The list of protocols that the member supports.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("group_id", Type.STRING, "The group identifier."),
            new Field("session_timeout_ms", Type.INT32, "The coordinator considers the consumer dead if it receives no heartbeat after this timeout in milliseconds."),
            new Field("rebalance_timeout_ms", Type.INT32, "The maximum time in milliseconds that the coordinator will wait for each member to rejoin when rebalancing the group."),
            new Field("member_id", Type.STRING, "The member id assigned by the group coordinator."),
            new Field("protocol_type", Type.STRING, "The unique name the for class of protocols implemented by the group we want to join."),
            new Field("protocols", new ArrayOf(JoinGroupRequestProtocol.SCHEMA_0), "The list of protocols that the member supports.")
        );
    
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
    
    public JoinGroupRequestData(Readable readable, short version) {
        this.protocols = new JoinGroupRequestProtocolSet(0);
        read(readable, version);
    }
    
    public JoinGroupRequestData(Struct struct, short version) {
        this.protocols = new JoinGroupRequestProtocolSet(0);
        fromStruct(struct, version);
    }
    
    public JoinGroupRequestData() {
        this.groupId = "";
        this.sessionTimeoutMs = 0;
        this.rebalanceTimeoutMs = -1;
        this.memberId = "";
        this.protocolType = "";
        this.protocols = new JoinGroupRequestProtocolSet(0);
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
        this.groupId = readable.readNullableString();
        this.sessionTimeoutMs = readable.readInt();
        if (version >= 1) {
            this.rebalanceTimeoutMs = readable.readInt();
        } else {
            this.rebalanceTimeoutMs = -1;
        }
        this.memberId = readable.readNullableString();
        this.protocolType = readable.readNullableString();
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.protocols.clear(0);
            } else {
                this.protocols.clear(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    this.protocols.add(new JoinGroupRequestProtocol(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeString(groupId);
        writable.writeInt(sessionTimeoutMs);
        if (version >= 1) {
            writable.writeInt(rebalanceTimeoutMs);
        }
        writable.writeString(memberId);
        writable.writeString(protocolType);
        writable.writeInt(protocols.size());
        for (JoinGroupRequestProtocol element : protocols) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.groupId = struct.getString("group_id");
        this.sessionTimeoutMs = struct.getInt("session_timeout_ms");
        if (version >= 1) {
            this.rebalanceTimeoutMs = struct.getInt("rebalance_timeout_ms");
        } else {
            this.rebalanceTimeoutMs = -1;
        }
        this.memberId = struct.getString("member_id");
        this.protocolType = struct.getString("protocol_type");
        {
            Object[] nestedObjects = struct.getArray("protocols");
            this.protocols = new JoinGroupRequestProtocolSet(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.protocols.add(new JoinGroupRequestProtocol((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("group_id", this.groupId);
        struct.set("session_timeout_ms", this.sessionTimeoutMs);
        if (version >= 1) {
            struct.set("rebalance_timeout_ms", this.rebalanceTimeoutMs);
        }
        struct.set("member_id", this.memberId);
        struct.set("protocol_type", this.protocolType);
        {
            Struct[] nestedObjects = new Struct[protocols.size()];
            int i = 0;
            for (JoinGroupRequestProtocol element : this.protocols) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("protocols", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 2;
        size += MessageUtil.serializedUtf8Length(groupId);
        size += 4;
        if (version >= 1) {
            size += 4;
        }
        size += 2;
        size += MessageUtil.serializedUtf8Length(memberId);
        size += 2;
        size += MessageUtil.serializedUtf8Length(protocolType);
        size += 4;
        for (JoinGroupRequestProtocol element : protocols) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof JoinGroupRequestData)) return false;
        JoinGroupRequestData other = (JoinGroupRequestData) obj;
        if (this.groupId == null) {
            if (other.groupId != null) return false;
        } else {
            if (!this.groupId.equals(other.groupId)) return false;
        }
        if (sessionTimeoutMs != other.sessionTimeoutMs) return false;
        if (rebalanceTimeoutMs != other.rebalanceTimeoutMs) return false;
        if (this.memberId == null) {
            if (other.memberId != null) return false;
        } else {
            if (!this.memberId.equals(other.memberId)) return false;
        }
        if (this.protocolType == null) {
            if (other.protocolType != null) return false;
        } else {
            if (!this.protocolType.equals(other.protocolType)) return false;
        }
        if (this.protocols == null) {
            if (other.protocols != null) return false;
        } else {
            if (!this.protocols.equals(other.protocols)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (groupId == null ? 0 : groupId.hashCode());
        hashCode = 31 * hashCode + sessionTimeoutMs;
        hashCode = 31 * hashCode + rebalanceTimeoutMs;
        hashCode = 31 * hashCode + (memberId == null ? 0 : memberId.hashCode());
        hashCode = 31 * hashCode + (protocolType == null ? 0 : protocolType.hashCode());
        hashCode = 31 * hashCode + (protocols == null ? 0 : protocols.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "JoinGroupRequestData("
            + "groupId='" + groupId + "'"
            + ", sessionTimeoutMs=" + sessionTimeoutMs
            + ", rebalanceTimeoutMs=" + rebalanceTimeoutMs
            + ", memberId='" + memberId + "'"
            + ", protocolType='" + protocolType + "'"
            + ", protocols=" + MessageUtil.deepToString(protocols.iterator())
            + ")";
    }
    
    public String groupId() {
        return this.groupId;
    }
    
    public int sessionTimeoutMs() {
        return this.sessionTimeoutMs;
    }
    
    public int rebalanceTimeoutMs() {
        return this.rebalanceTimeoutMs;
    }
    
    public String memberId() {
        return this.memberId;
    }
    
    public String protocolType() {
        return this.protocolType;
    }
    
    public JoinGroupRequestProtocolSet protocols() {
        return this.protocols;
    }
    
    public JoinGroupRequestData setGroupId(String v) {
        this.groupId = v;
        return this;
    }
    
    public JoinGroupRequestData setSessionTimeoutMs(int v) {
        this.sessionTimeoutMs = v;
        return this;
    }
    
    public JoinGroupRequestData setRebalanceTimeoutMs(int v) {
        this.rebalanceTimeoutMs = v;
        return this;
    }
    
    public JoinGroupRequestData setMemberId(String v) {
        this.memberId = v;
        return this;
    }
    
    public JoinGroupRequestData setProtocolType(String v) {
        this.protocolType = v;
        return this;
    }
    
    public JoinGroupRequestData setProtocols(JoinGroupRequestProtocolSet v) {
        this.protocols = v;
        return this;
    }
    
    static public class JoinGroupRequestProtocol implements Message, ImplicitLinkedHashMultiSet.Element {
        private String name;
        private byte[] metadata;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The protocol name."),
                new Field("metadata", Type.BYTES, "The protocol metadata.")
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
        
        public JoinGroupRequestProtocol(Readable readable, short version) {
            read(readable, version);
        }
        
        public JoinGroupRequestProtocol(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public JoinGroupRequestProtocol() {
            this.name = "";
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
            this.name = readable.readNullableString();
            this.metadata = readable.readNullableBytes();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeBytes(metadata);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            this.metadata = struct.getByteArray("metadata");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            struct.setByteArray("metadata", this.metadata);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            size += 4;
            size += metadata.length;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof JoinGroupRequestProtocol)) return false;
            JoinGroupRequestProtocol other = (JoinGroupRequestProtocol) obj;
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
            return "JoinGroupRequestProtocol("
                + "name='" + name + "'"
                + ", metadata=" + Arrays.toString(metadata)
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public byte[] metadata() {
            return this.metadata;
        }
        
        @Override
        public int next() {
            return this.next;
        }
        
        @Override
        public int prev() {
            return this.prev;
        }
        
        public JoinGroupRequestProtocol setName(String v) {
            this.name = v;
            return this;
        }
        
        public JoinGroupRequestProtocol setMetadata(byte[] v) {
            this.metadata = v;
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
    
    public static class JoinGroupRequestProtocolSet extends ImplicitLinkedHashMultiSet<JoinGroupRequestProtocol> {
        public JoinGroupRequestProtocolSet() {
            super();
        }
        
        public JoinGroupRequestProtocolSet(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public JoinGroupRequestProtocolSet(Iterator<JoinGroupRequestProtocol> iterator) {
            super(iterator);
        }
        
        public JoinGroupRequestProtocol find(String name) {
            JoinGroupRequestProtocol key = new JoinGroupRequestProtocol();
            key.setName(name);
            return find(key);
        }
        
        public List<JoinGroupRequestProtocol> findAll(String name) {
            JoinGroupRequestProtocol key = new JoinGroupRequestProtocol();
            key.setName(name);
            return findAll(key);
        }
        
    }
}
