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


public class CreateAclsRequestData implements ApiMessage {
    private List<CreatableAcl> creations;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("creations", new ArrayOf(CreatableAcl.SCHEMA_0), "The ACLs that we want to create.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("creations", new ArrayOf(CreatableAcl.SCHEMA_1), "The ACLs that we want to create.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public CreateAclsRequestData(Readable readable, short version) {
        this.creations = new ArrayList<CreatableAcl>();
        read(readable, version);
    }
    
    public CreateAclsRequestData(Struct struct, short version) {
        this.creations = new ArrayList<CreatableAcl>();
        fromStruct(struct, version);
    }
    
    public CreateAclsRequestData() {
        this.creations = new ArrayList<CreatableAcl>();
    }
    
    @Override
    public short apiKey() {
        return 30;
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
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.creations.clear();
            } else {
                this.creations.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.creations.add(new CreatableAcl(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(creations.size());
        for (CreatableAcl element : creations) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        {
            Object[] nestedObjects = struct.getArray("creations");
            this.creations = new ArrayList<CreatableAcl>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.creations.add(new CreatableAcl((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        {
            Struct[] nestedObjects = new Struct[creations.size()];
            int i = 0;
            for (CreatableAcl element : this.creations) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("creations", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        for (CreatableAcl element : creations) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CreateAclsRequestData)) return false;
        CreateAclsRequestData other = (CreateAclsRequestData) obj;
        if (this.creations == null) {
            if (other.creations != null) return false;
        } else {
            if (!this.creations.equals(other.creations)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (creations == null ? 0 : creations.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "CreateAclsRequestData("
            + "creations=" + MessageUtil.deepToString(creations.iterator())
            + ")";
    }
    
    public List<CreatableAcl> creations() {
        return this.creations;
    }
    
    public CreateAclsRequestData setCreations(List<CreatableAcl> v) {
        this.creations = v;
        return this;
    }
    
    static public class CreatableAcl implements Message {
        private byte resourceType;
        private String resourceName;
        private byte resourcePatternType;
        private String principal;
        private String host;
        private byte operation;
        private byte permissionType;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("resource_type", Type.INT8, "The type of the resource."),
                new Field("resource_name", Type.STRING, "The resource name for the ACL."),
                new Field("principal", Type.STRING, "The principal for the ACL."),
                new Field("host", Type.STRING, "The host for the ACL."),
                new Field("operation", Type.INT8, "The operation type for the ACL (read, write, etc.)."),
                new Field("permission_type", Type.INT8, "The permission type for the ACL (allow, deny, etc.).")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("resource_type", Type.INT8, "The type of the resource."),
                new Field("resource_name", Type.STRING, "The resource name for the ACL."),
                new Field("resource_pattern_type", Type.INT8, "The pattern type for the ACL."),
                new Field("principal", Type.STRING, "The principal for the ACL."),
                new Field("host", Type.STRING, "The host for the ACL."),
                new Field("operation", Type.INT8, "The operation type for the ACL (read, write, etc.)."),
                new Field("permission_type", Type.INT8, "The permission type for the ACL (allow, deny, etc.).")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public CreatableAcl(Readable readable, short version) {
            read(readable, version);
        }
        
        public CreatableAcl(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public CreatableAcl() {
            this.resourceType = (byte) 0;
            this.resourceName = "";
            this.resourcePatternType = (byte) 3;
            this.principal = "";
            this.host = "";
            this.operation = (byte) 0;
            this.permissionType = (byte) 0;
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
            this.resourceType = readable.readByte();
            this.resourceName = readable.readNullableString();
            if (version >= 1) {
                this.resourcePatternType = readable.readByte();
            } else {
                this.resourcePatternType = (byte) 3;
            }
            this.principal = readable.readNullableString();
            this.host = readable.readNullableString();
            this.operation = readable.readByte();
            this.permissionType = readable.readByte();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeByte(resourceType);
            writable.writeString(resourceName);
            if (version >= 1) {
                writable.writeByte(resourcePatternType);
            }
            writable.writeString(principal);
            writable.writeString(host);
            writable.writeByte(operation);
            writable.writeByte(permissionType);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.resourceType = struct.getByte("resource_type");
            this.resourceName = struct.getString("resource_name");
            if (version >= 1) {
                this.resourcePatternType = struct.getByte("resource_pattern_type");
            } else {
                this.resourcePatternType = (byte) 3;
            }
            this.principal = struct.getString("principal");
            this.host = struct.getString("host");
            this.operation = struct.getByte("operation");
            this.permissionType = struct.getByte("permission_type");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("resource_type", this.resourceType);
            struct.set("resource_name", this.resourceName);
            if (version >= 1) {
                struct.set("resource_pattern_type", this.resourcePatternType);
            }
            struct.set("principal", this.principal);
            struct.set("host", this.host);
            struct.set("operation", this.operation);
            struct.set("permission_type", this.permissionType);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 1;
            size += 2;
            size += MessageUtil.serializedUtf8Length(resourceName);
            if (version >= 1) {
                size += 1;
            } else {
                if (resourcePatternType != (byte) 3) {
                    throw new UnsupportedVersionException("Attempted to write a non-default resourcePatternType at version " + version);
                }
            }
            size += 2;
            size += MessageUtil.serializedUtf8Length(principal);
            size += 2;
            size += MessageUtil.serializedUtf8Length(host);
            size += 1;
            size += 1;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof CreatableAcl)) return false;
            CreatableAcl other = (CreatableAcl) obj;
            if (resourceType != other.resourceType) return false;
            if (this.resourceName == null) {
                if (other.resourceName != null) return false;
            } else {
                if (!this.resourceName.equals(other.resourceName)) return false;
            }
            if (resourcePatternType != other.resourcePatternType) return false;
            if (this.principal == null) {
                if (other.principal != null) return false;
            } else {
                if (!this.principal.equals(other.principal)) return false;
            }
            if (this.host == null) {
                if (other.host != null) return false;
            } else {
                if (!this.host.equals(other.host)) return false;
            }
            if (operation != other.operation) return false;
            if (permissionType != other.permissionType) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + resourceType;
            hashCode = 31 * hashCode + (resourceName == null ? 0 : resourceName.hashCode());
            hashCode = 31 * hashCode + resourcePatternType;
            hashCode = 31 * hashCode + (principal == null ? 0 : principal.hashCode());
            hashCode = 31 * hashCode + (host == null ? 0 : host.hashCode());
            hashCode = 31 * hashCode + operation;
            hashCode = 31 * hashCode + permissionType;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "CreatableAcl("
                + "resourceType=" + resourceType
                + ", resourceName='" + resourceName + "'"
                + ", resourcePatternType=" + resourcePatternType
                + ", principal='" + principal + "'"
                + ", host='" + host + "'"
                + ", operation=" + operation
                + ", permissionType=" + permissionType
                + ")";
        }
        
        public byte resourceType() {
            return this.resourceType;
        }
        
        public String resourceName() {
            return this.resourceName;
        }
        
        public byte resourcePatternType() {
            return this.resourcePatternType;
        }
        
        public String principal() {
            return this.principal;
        }
        
        public String host() {
            return this.host;
        }
        
        public byte operation() {
            return this.operation;
        }
        
        public byte permissionType() {
            return this.permissionType;
        }
        
        public CreatableAcl setResourceType(byte v) {
            this.resourceType = v;
            return this;
        }
        
        public CreatableAcl setResourceName(String v) {
            this.resourceName = v;
            return this;
        }
        
        public CreatableAcl setResourcePatternType(byte v) {
            this.resourcePatternType = v;
            return this;
        }
        
        public CreatableAcl setPrincipal(String v) {
            this.principal = v;
            return this;
        }
        
        public CreatableAcl setHost(String v) {
            this.host = v;
            return this;
        }
        
        public CreatableAcl setOperation(byte v) {
            this.operation = v;
            return this;
        }
        
        public CreatableAcl setPermissionType(byte v) {
            this.permissionType = v;
            return this;
        }
    }
}
