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


public class DescribeAclsResponseData implements ApiMessage {
    private int throttleTimeMs;
    private short errorCode;
    private String errorMessage;
    private List<DescribeAclsResource> resources;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
            new Field("error_message", Type.NULLABLE_STRING, "The error message, or null if there was no error."),
            new Field("resources", new ArrayOf(DescribeAclsResource.SCHEMA_0), "Each Resource that is referenced in an ACL.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
            new Field("error_message", Type.NULLABLE_STRING, "The error message, or null if there was no error."),
            new Field("resources", new ArrayOf(DescribeAclsResource.SCHEMA_1), "Each Resource that is referenced in an ACL.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public DescribeAclsResponseData(Readable readable, short version) {
        this.resources = new ArrayList<DescribeAclsResource>();
        read(readable, version);
    }
    
    public DescribeAclsResponseData(Struct struct, short version) {
        this.resources = new ArrayList<DescribeAclsResource>();
        fromStruct(struct, version);
    }
    
    public DescribeAclsResponseData() {
        this.throttleTimeMs = 0;
        this.errorCode = (short) 0;
        this.errorMessage = "";
        this.resources = new ArrayList<DescribeAclsResource>();
    }
    
    @Override
    public short apiKey() {
        return 29;
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
        this.errorCode = readable.readShort();
        this.errorMessage = readable.readNullableString();
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.resources.clear();
            } else {
                this.resources.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.resources.add(new DescribeAclsResource(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(throttleTimeMs);
        writable.writeShort(errorCode);
        writable.writeNullableString(errorMessage);
        writable.writeInt(resources.size());
        for (DescribeAclsResource element : resources) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.throttleTimeMs = struct.getInt("throttle_time_ms");
        this.errorCode = struct.getShort("error_code");
        this.errorMessage = struct.getString("error_message");
        {
            Object[] nestedObjects = struct.getArray("resources");
            this.resources = new ArrayList<DescribeAclsResource>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.resources.add(new DescribeAclsResource((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("throttle_time_ms", this.throttleTimeMs);
        struct.set("error_code", this.errorCode);
        struct.set("error_message", this.errorMessage);
        {
            Struct[] nestedObjects = new Struct[resources.size()];
            int i = 0;
            for (DescribeAclsResource element : this.resources) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("resources", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        size += 2;
        size += 2;
        if (errorMessage != null) {
            size += MessageUtil.serializedUtf8Length(errorMessage);
        }
        size += 4;
        for (DescribeAclsResource element : resources) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DescribeAclsResponseData)) return false;
        DescribeAclsResponseData other = (DescribeAclsResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (errorCode != other.errorCode) return false;
        if (this.errorMessage == null) {
            if (other.errorMessage != null) return false;
        } else {
            if (!this.errorMessage.equals(other.errorMessage)) return false;
        }
        if (this.resources == null) {
            if (other.resources != null) return false;
        } else {
            if (!this.resources.equals(other.resources)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + errorCode;
        hashCode = 31 * hashCode + (errorMessage == null ? 0 : errorMessage.hashCode());
        hashCode = 31 * hashCode + (resources == null ? 0 : resources.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "DescribeAclsResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", errorCode=" + errorCode
            + ", errorMessage='" + errorMessage + "'"
            + ", resources=" + MessageUtil.deepToString(resources.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public String errorMessage() {
        return this.errorMessage;
    }
    
    public List<DescribeAclsResource> resources() {
        return this.resources;
    }
    
    public DescribeAclsResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public DescribeAclsResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    public DescribeAclsResponseData setErrorMessage(String v) {
        this.errorMessage = v;
        return this;
    }
    
    public DescribeAclsResponseData setResources(List<DescribeAclsResource> v) {
        this.resources = v;
        return this;
    }
    
    static public class DescribeAclsResource implements Message {
        private byte type;
        private String name;
        private byte patternType;
        private List<AclDescription> acls;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("type", Type.INT8, "The resource type."),
                new Field("name", Type.STRING, "The resource name."),
                new Field("acls", new ArrayOf(AclDescription.SCHEMA_0), "The ACLs.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("type", Type.INT8, "The resource type."),
                new Field("name", Type.STRING, "The resource name."),
                new Field("pattern_type", Type.INT8, "The resource pattern type."),
                new Field("acls", new ArrayOf(AclDescription.SCHEMA_0), "The ACLs.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public DescribeAclsResource(Readable readable, short version) {
            this.acls = new ArrayList<AclDescription>();
            read(readable, version);
        }
        
        public DescribeAclsResource(Struct struct, short version) {
            this.acls = new ArrayList<AclDescription>();
            fromStruct(struct, version);
        }
        
        public DescribeAclsResource() {
            this.type = (byte) 0;
            this.name = "";
            this.patternType = (byte) 3;
            this.acls = new ArrayList<AclDescription>();
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
            this.type = readable.readByte();
            this.name = readable.readNullableString();
            if (version >= 1) {
                this.patternType = readable.readByte();
            } else {
                this.patternType = (byte) 3;
            }
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.acls.clear();
                } else {
                    this.acls.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.acls.add(new AclDescription(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeByte(type);
            writable.writeString(name);
            if (version >= 1) {
                writable.writeByte(patternType);
            }
            writable.writeInt(acls.size());
            for (AclDescription element : acls) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.type = struct.getByte("type");
            this.name = struct.getString("name");
            if (version >= 1) {
                this.patternType = struct.getByte("pattern_type");
            } else {
                this.patternType = (byte) 3;
            }
            {
                Object[] nestedObjects = struct.getArray("acls");
                this.acls = new ArrayList<AclDescription>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.acls.add(new AclDescription((Struct) nestedObject, version));
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("type", this.type);
            struct.set("name", this.name);
            if (version >= 1) {
                struct.set("pattern_type", this.patternType);
            }
            {
                Struct[] nestedObjects = new Struct[acls.size()];
                int i = 0;
                for (AclDescription element : this.acls) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("acls", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 1;
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            if (version >= 1) {
                size += 1;
            } else {
                if (patternType != (byte) 3) {
                    throw new UnsupportedVersionException("Attempted to write a non-default patternType at version " + version);
                }
            }
            size += 4;
            for (AclDescription element : acls) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DescribeAclsResource)) return false;
            DescribeAclsResource other = (DescribeAclsResource) obj;
            if (type != other.type) return false;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (patternType != other.patternType) return false;
            if (this.acls == null) {
                if (other.acls != null) return false;
            } else {
                if (!this.acls.equals(other.acls)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + type;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + patternType;
            hashCode = 31 * hashCode + (acls == null ? 0 : acls.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DescribeAclsResource("
                + "type=" + type
                + ", name='" + name + "'"
                + ", patternType=" + patternType
                + ", acls=" + MessageUtil.deepToString(acls.iterator())
                + ")";
        }
        
        public byte type() {
            return this.type;
        }
        
        public String name() {
            return this.name;
        }
        
        public byte patternType() {
            return this.patternType;
        }
        
        public List<AclDescription> acls() {
            return this.acls;
        }
        
        public DescribeAclsResource setType(byte v) {
            this.type = v;
            return this;
        }
        
        public DescribeAclsResource setName(String v) {
            this.name = v;
            return this;
        }
        
        public DescribeAclsResource setPatternType(byte v) {
            this.patternType = v;
            return this;
        }
        
        public DescribeAclsResource setAcls(List<AclDescription> v) {
            this.acls = v;
            return this;
        }
    }
    
    static public class AclDescription implements Message {
        private String principal;
        private String host;
        private byte operation;
        private byte permissionType;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("principal", Type.STRING, "The ACL principal."),
                new Field("host", Type.STRING, "The ACL host."),
                new Field("operation", Type.INT8, "The ACL operation."),
                new Field("permission_type", Type.INT8, "The ACL permission type.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public AclDescription(Readable readable, short version) {
            read(readable, version);
        }
        
        public AclDescription(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public AclDescription() {
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
            this.principal = readable.readNullableString();
            this.host = readable.readNullableString();
            this.operation = readable.readByte();
            this.permissionType = readable.readByte();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(principal);
            writable.writeString(host);
            writable.writeByte(operation);
            writable.writeByte(permissionType);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.principal = struct.getString("principal");
            this.host = struct.getString("host");
            this.operation = struct.getByte("operation");
            this.permissionType = struct.getByte("permission_type");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("principal", this.principal);
            struct.set("host", this.host);
            struct.set("operation", this.operation);
            struct.set("permission_type", this.permissionType);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
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
            if (!(obj instanceof AclDescription)) return false;
            AclDescription other = (AclDescription) obj;
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
            hashCode = 31 * hashCode + (principal == null ? 0 : principal.hashCode());
            hashCode = 31 * hashCode + (host == null ? 0 : host.hashCode());
            hashCode = 31 * hashCode + operation;
            hashCode = 31 * hashCode + permissionType;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "AclDescription("
                + "principal='" + principal + "'"
                + ", host='" + host + "'"
                + ", operation=" + operation
                + ", permissionType=" + permissionType
                + ")";
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
        
        public AclDescription setPrincipal(String v) {
            this.principal = v;
            return this;
        }
        
        public AclDescription setHost(String v) {
            this.host = v;
            return this;
        }
        
        public AclDescription setOperation(byte v) {
            this.operation = v;
            return this;
        }
        
        public AclDescription setPermissionType(byte v) {
            this.permissionType = v;
            return this;
        }
    }
}
