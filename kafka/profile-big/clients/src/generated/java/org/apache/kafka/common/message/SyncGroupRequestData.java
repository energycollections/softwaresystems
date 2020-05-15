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


public class SyncGroupRequestData implements ApiMessage {
    private String groupId;
    private int generationId;
    private String memberId;
    private List<SyncGroupRequestAssignment> assignments;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("group_id", Type.STRING, "The unique group identifier."),
            new Field("generation_id", Type.INT32, "The generation of the group."),
            new Field("member_id", Type.STRING, "The member ID assigned by the group."),
            new Field("assignments", new ArrayOf(SyncGroupRequestAssignment.SCHEMA_0), "Each assignment.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2
    };
    
    public SyncGroupRequestData(Readable readable, short version) {
        this.assignments = new ArrayList<SyncGroupRequestAssignment>();
        read(readable, version);
    }
    
    public SyncGroupRequestData(Struct struct, short version) {
        this.assignments = new ArrayList<SyncGroupRequestAssignment>();
        fromStruct(struct, version);
    }
    
    public SyncGroupRequestData() {
        this.groupId = "";
        this.generationId = 0;
        this.memberId = "";
        this.assignments = new ArrayList<SyncGroupRequestAssignment>();
    }
    
    @Override
    public short apiKey() {
        return 14;
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
        this.generationId = readable.readInt();
        this.memberId = readable.readNullableString();
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.assignments.clear();
            } else {
                this.assignments.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.assignments.add(new SyncGroupRequestAssignment(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeString(groupId);
        writable.writeInt(generationId);
        writable.writeString(memberId);
        writable.writeInt(assignments.size());
        for (SyncGroupRequestAssignment element : assignments) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.groupId = struct.getString("group_id");
        this.generationId = struct.getInt("generation_id");
        this.memberId = struct.getString("member_id");
        {
            Object[] nestedObjects = struct.getArray("assignments");
            this.assignments = new ArrayList<SyncGroupRequestAssignment>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.assignments.add(new SyncGroupRequestAssignment((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("group_id", this.groupId);
        struct.set("generation_id", this.generationId);
        struct.set("member_id", this.memberId);
        {
            Struct[] nestedObjects = new Struct[assignments.size()];
            int i = 0;
            for (SyncGroupRequestAssignment element : this.assignments) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("assignments", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 2;
        size += MessageUtil.serializedUtf8Length(groupId);
        size += 4;
        size += 2;
        size += MessageUtil.serializedUtf8Length(memberId);
        size += 4;
        for (SyncGroupRequestAssignment element : assignments) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SyncGroupRequestData)) return false;
        SyncGroupRequestData other = (SyncGroupRequestData) obj;
        if (this.groupId == null) {
            if (other.groupId != null) return false;
        } else {
            if (!this.groupId.equals(other.groupId)) return false;
        }
        if (generationId != other.generationId) return false;
        if (this.memberId == null) {
            if (other.memberId != null) return false;
        } else {
            if (!this.memberId.equals(other.memberId)) return false;
        }
        if (this.assignments == null) {
            if (other.assignments != null) return false;
        } else {
            if (!this.assignments.equals(other.assignments)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (groupId == null ? 0 : groupId.hashCode());
        hashCode = 31 * hashCode + generationId;
        hashCode = 31 * hashCode + (memberId == null ? 0 : memberId.hashCode());
        hashCode = 31 * hashCode + (assignments == null ? 0 : assignments.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "SyncGroupRequestData("
            + "groupId='" + groupId + "'"
            + ", generationId=" + generationId
            + ", memberId='" + memberId + "'"
            + ", assignments=" + MessageUtil.deepToString(assignments.iterator())
            + ")";
    }
    
    public String groupId() {
        return this.groupId;
    }
    
    public int generationId() {
        return this.generationId;
    }
    
    public String memberId() {
        return this.memberId;
    }
    
    public List<SyncGroupRequestAssignment> assignments() {
        return this.assignments;
    }
    
    public SyncGroupRequestData setGroupId(String v) {
        this.groupId = v;
        return this;
    }
    
    public SyncGroupRequestData setGenerationId(int v) {
        this.generationId = v;
        return this;
    }
    
    public SyncGroupRequestData setMemberId(String v) {
        this.memberId = v;
        return this;
    }
    
    public SyncGroupRequestData setAssignments(List<SyncGroupRequestAssignment> v) {
        this.assignments = v;
        return this;
    }
    
    static public class SyncGroupRequestAssignment implements Message {
        private String memberId;
        private byte[] assignment;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("member_id", Type.STRING, "The ID of the member to assign."),
                new Field("assignment", Type.BYTES, "The member assignment.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public SyncGroupRequestAssignment(Readable readable, short version) {
            read(readable, version);
        }
        
        public SyncGroupRequestAssignment(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public SyncGroupRequestAssignment() {
            this.memberId = "";
            this.assignment = Bytes.EMPTY;
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
            this.assignment = readable.readNullableBytes();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(memberId);
            writable.writeBytes(assignment);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.memberId = struct.getString("member_id");
            this.assignment = struct.getByteArray("assignment");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("member_id", this.memberId);
            struct.setByteArray("assignment", this.assignment);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(memberId);
            size += 4;
            size += assignment.length;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof SyncGroupRequestAssignment)) return false;
            SyncGroupRequestAssignment other = (SyncGroupRequestAssignment) obj;
            if (this.memberId == null) {
                if (other.memberId != null) return false;
            } else {
                if (!this.memberId.equals(other.memberId)) return false;
            }
            if (!Arrays.equals(this.assignment, other.assignment)) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (memberId == null ? 0 : memberId.hashCode());
            hashCode = 31 * hashCode + Arrays.hashCode(assignment);
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "SyncGroupRequestAssignment("
                + "memberId='" + memberId + "'"
                + ", assignment=" + Arrays.toString(assignment)
                + ")";
        }
        
        public String memberId() {
            return this.memberId;
        }
        
        public byte[] assignment() {
            return this.assignment;
        }
        
        public SyncGroupRequestAssignment setMemberId(String v) {
            this.memberId = v;
            return this;
        }
        
        public SyncGroupRequestAssignment setAssignment(byte[] v) {
            this.assignment = v;
            return this;
        }
    }
}
