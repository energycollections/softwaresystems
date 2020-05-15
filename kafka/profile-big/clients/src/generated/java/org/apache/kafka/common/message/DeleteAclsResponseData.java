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


public class DeleteAclsResponseData implements ApiMessage {
    private int throttleTimeMs;
    private List<DeleteAclsFilterResult> filterResults;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("filter_results", new ArrayOf(DeleteAclsFilterResult.SCHEMA_0), "The results for each filter.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("filter_results", new ArrayOf(DeleteAclsFilterResult.SCHEMA_1), "The results for each filter.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public DeleteAclsResponseData(Readable readable, short version) {
        this.filterResults = new ArrayList<DeleteAclsFilterResult>();
        read(readable, version);
    }
    
    public DeleteAclsResponseData(Struct struct, short version) {
        this.filterResults = new ArrayList<DeleteAclsFilterResult>();
        fromStruct(struct, version);
    }
    
    public DeleteAclsResponseData() {
        this.throttleTimeMs = 0;
        this.filterResults = new ArrayList<DeleteAclsFilterResult>();
    }
    
    @Override
    public short apiKey() {
        return 31;
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
                this.filterResults.clear();
            } else {
                this.filterResults.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.filterResults.add(new DeleteAclsFilterResult(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(throttleTimeMs);
        writable.writeInt(filterResults.size());
        for (DeleteAclsFilterResult element : filterResults) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.throttleTimeMs = struct.getInt("throttle_time_ms");
        {
            Object[] nestedObjects = struct.getArray("filter_results");
            this.filterResults = new ArrayList<DeleteAclsFilterResult>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.filterResults.add(new DeleteAclsFilterResult((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("throttle_time_ms", this.throttleTimeMs);
        {
            Struct[] nestedObjects = new Struct[filterResults.size()];
            int i = 0;
            for (DeleteAclsFilterResult element : this.filterResults) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("filter_results", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        size += 4;
        for (DeleteAclsFilterResult element : filterResults) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DeleteAclsResponseData)) return false;
        DeleteAclsResponseData other = (DeleteAclsResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (this.filterResults == null) {
            if (other.filterResults != null) return false;
        } else {
            if (!this.filterResults.equals(other.filterResults)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + (filterResults == null ? 0 : filterResults.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "DeleteAclsResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", filterResults=" + MessageUtil.deepToString(filterResults.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public List<DeleteAclsFilterResult> filterResults() {
        return this.filterResults;
    }
    
    public DeleteAclsResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public DeleteAclsResponseData setFilterResults(List<DeleteAclsFilterResult> v) {
        this.filterResults = v;
        return this;
    }
    
    static public class DeleteAclsFilterResult implements Message {
        private short errorCode;
        private String errorMessage;
        private List<DeleteAclsMatchingAcl> matchingAcls;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("error_code", Type.INT16, "The error code, or 0 if the filter succeeded."),
                new Field("error_message", Type.NULLABLE_STRING, "The error message, or null if the filter succeeded."),
                new Field("matching_acls", new ArrayOf(DeleteAclsMatchingAcl.SCHEMA_0), "The ACLs which matched this filter.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("error_code", Type.INT16, "The error code, or 0 if the filter succeeded."),
                new Field("error_message", Type.NULLABLE_STRING, "The error message, or null if the filter succeeded."),
                new Field("matching_acls", new ArrayOf(DeleteAclsMatchingAcl.SCHEMA_1), "The ACLs which matched this filter.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public DeleteAclsFilterResult(Readable readable, short version) {
            this.matchingAcls = new ArrayList<DeleteAclsMatchingAcl>();
            read(readable, version);
        }
        
        public DeleteAclsFilterResult(Struct struct, short version) {
            this.matchingAcls = new ArrayList<DeleteAclsMatchingAcl>();
            fromStruct(struct, version);
        }
        
        public DeleteAclsFilterResult() {
            this.errorCode = (short) 0;
            this.errorMessage = "";
            this.matchingAcls = new ArrayList<DeleteAclsMatchingAcl>();
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
            this.errorCode = readable.readShort();
            this.errorMessage = readable.readNullableString();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.matchingAcls.clear();
                } else {
                    this.matchingAcls.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.matchingAcls.add(new DeleteAclsMatchingAcl(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeShort(errorCode);
            writable.writeNullableString(errorMessage);
            writable.writeInt(matchingAcls.size());
            for (DeleteAclsMatchingAcl element : matchingAcls) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.errorCode = struct.getShort("error_code");
            this.errorMessage = struct.getString("error_message");
            {
                Object[] nestedObjects = struct.getArray("matching_acls");
                this.matchingAcls = new ArrayList<DeleteAclsMatchingAcl>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.matchingAcls.add(new DeleteAclsMatchingAcl((Struct) nestedObject, version));
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("error_code", this.errorCode);
            struct.set("error_message", this.errorMessage);
            {
                Struct[] nestedObjects = new Struct[matchingAcls.size()];
                int i = 0;
                for (DeleteAclsMatchingAcl element : this.matchingAcls) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("matching_acls", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += 2;
            if (errorMessage != null) {
                size += MessageUtil.serializedUtf8Length(errorMessage);
            }
            size += 4;
            for (DeleteAclsMatchingAcl element : matchingAcls) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DeleteAclsFilterResult)) return false;
            DeleteAclsFilterResult other = (DeleteAclsFilterResult) obj;
            if (errorCode != other.errorCode) return false;
            if (this.errorMessage == null) {
                if (other.errorMessage != null) return false;
            } else {
                if (!this.errorMessage.equals(other.errorMessage)) return false;
            }
            if (this.matchingAcls == null) {
                if (other.matchingAcls != null) return false;
            } else {
                if (!this.matchingAcls.equals(other.matchingAcls)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + errorCode;
            hashCode = 31 * hashCode + (errorMessage == null ? 0 : errorMessage.hashCode());
            hashCode = 31 * hashCode + (matchingAcls == null ? 0 : matchingAcls.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DeleteAclsFilterResult("
                + "errorCode=" + errorCode
                + ", errorMessage='" + errorMessage + "'"
                + ", matchingAcls=" + MessageUtil.deepToString(matchingAcls.iterator())
                + ")";
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public String errorMessage() {
            return this.errorMessage;
        }
        
        public List<DeleteAclsMatchingAcl> matchingAcls() {
            return this.matchingAcls;
        }
        
        public DeleteAclsFilterResult setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public DeleteAclsFilterResult setErrorMessage(String v) {
            this.errorMessage = v;
            return this;
        }
        
        public DeleteAclsFilterResult setMatchingAcls(List<DeleteAclsMatchingAcl> v) {
            this.matchingAcls = v;
            return this;
        }
    }
    
    static public class DeleteAclsMatchingAcl implements Message {
        private short errorCode;
        private String errorMessage;
        private byte resourceType;
        private String resourceName;
        private byte patternType;
        private String principal;
        private String host;
        private byte operation;
        private byte permissionType;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("error_code", Type.INT16, "The deletion error code, or 0 if the deletion succeeded."),
                new Field("error_message", Type.NULLABLE_STRING, "The deletion error message, or null if the deletion succeeded."),
                new Field("resource_type", Type.INT8, "The ACL resource type."),
                new Field("resource_name", Type.STRING, "The ACL resource name."),
                new Field("principal", Type.STRING, "The ACL principal."),
                new Field("host", Type.STRING, "The ACL host."),
                new Field("operation", Type.INT8, "The ACL operation."),
                new Field("permission_type", Type.INT8, "The ACL permission type.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("error_code", Type.INT16, "The deletion error code, or 0 if the deletion succeeded."),
                new Field("error_message", Type.NULLABLE_STRING, "The deletion error message, or null if the deletion succeeded."),
                new Field("resource_type", Type.INT8, "The ACL resource type."),
                new Field("resource_name", Type.STRING, "The ACL resource name."),
                new Field("pattern_type", Type.INT8, "The ACL resource pattern type."),
                new Field("principal", Type.STRING, "The ACL principal."),
                new Field("host", Type.STRING, "The ACL host."),
                new Field("operation", Type.INT8, "The ACL operation."),
                new Field("permission_type", Type.INT8, "The ACL permission type.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public DeleteAclsMatchingAcl(Readable readable, short version) {
            read(readable, version);
        }
        
        public DeleteAclsMatchingAcl(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public DeleteAclsMatchingAcl() {
            this.errorCode = (short) 0;
            this.errorMessage = "";
            this.resourceType = (byte) 0;
            this.resourceName = "";
            this.patternType = (byte) 3;
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
            this.errorCode = readable.readShort();
            this.errorMessage = readable.readNullableString();
            this.resourceType = readable.readByte();
            this.resourceName = readable.readNullableString();
            if (version >= 1) {
                this.patternType = readable.readByte();
            } else {
                this.patternType = (byte) 3;
            }
            this.principal = readable.readNullableString();
            this.host = readable.readNullableString();
            this.operation = readable.readByte();
            this.permissionType = readable.readByte();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeShort(errorCode);
            writable.writeNullableString(errorMessage);
            writable.writeByte(resourceType);
            writable.writeString(resourceName);
            if (version >= 1) {
                writable.writeByte(patternType);
            }
            writable.writeString(principal);
            writable.writeString(host);
            writable.writeByte(operation);
            writable.writeByte(permissionType);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.errorCode = struct.getShort("error_code");
            this.errorMessage = struct.getString("error_message");
            this.resourceType = struct.getByte("resource_type");
            this.resourceName = struct.getString("resource_name");
            if (version >= 1) {
                this.patternType = struct.getByte("pattern_type");
            } else {
                this.patternType = (byte) 3;
            }
            this.principal = struct.getString("principal");
            this.host = struct.getString("host");
            this.operation = struct.getByte("operation");
            this.permissionType = struct.getByte("permission_type");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("error_code", this.errorCode);
            struct.set("error_message", this.errorMessage);
            struct.set("resource_type", this.resourceType);
            struct.set("resource_name", this.resourceName);
            if (version >= 1) {
                struct.set("pattern_type", this.patternType);
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
            size += 2;
            size += 2;
            if (errorMessage != null) {
                size += MessageUtil.serializedUtf8Length(errorMessage);
            }
            size += 1;
            size += 2;
            size += MessageUtil.serializedUtf8Length(resourceName);
            if (version >= 1) {
                size += 1;
            } else {
                if (patternType != (byte) 3) {
                    throw new UnsupportedVersionException("Attempted to write a non-default patternType at version " + version);
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
            if (!(obj instanceof DeleteAclsMatchingAcl)) return false;
            DeleteAclsMatchingAcl other = (DeleteAclsMatchingAcl) obj;
            if (errorCode != other.errorCode) return false;
            if (this.errorMessage == null) {
                if (other.errorMessage != null) return false;
            } else {
                if (!this.errorMessage.equals(other.errorMessage)) return false;
            }
            if (resourceType != other.resourceType) return false;
            if (this.resourceName == null) {
                if (other.resourceName != null) return false;
            } else {
                if (!this.resourceName.equals(other.resourceName)) return false;
            }
            if (patternType != other.patternType) return false;
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
            hashCode = 31 * hashCode + errorCode;
            hashCode = 31 * hashCode + (errorMessage == null ? 0 : errorMessage.hashCode());
            hashCode = 31 * hashCode + resourceType;
            hashCode = 31 * hashCode + (resourceName == null ? 0 : resourceName.hashCode());
            hashCode = 31 * hashCode + patternType;
            hashCode = 31 * hashCode + (principal == null ? 0 : principal.hashCode());
            hashCode = 31 * hashCode + (host == null ? 0 : host.hashCode());
            hashCode = 31 * hashCode + operation;
            hashCode = 31 * hashCode + permissionType;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DeleteAclsMatchingAcl("
                + "errorCode=" + errorCode
                + ", errorMessage='" + errorMessage + "'"
                + ", resourceType=" + resourceType
                + ", resourceName='" + resourceName + "'"
                + ", patternType=" + patternType
                + ", principal='" + principal + "'"
                + ", host='" + host + "'"
                + ", operation=" + operation
                + ", permissionType=" + permissionType
                + ")";
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public String errorMessage() {
            return this.errorMessage;
        }
        
        public byte resourceType() {
            return this.resourceType;
        }
        
        public String resourceName() {
            return this.resourceName;
        }
        
        public byte patternType() {
            return this.patternType;
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
        
        public DeleteAclsMatchingAcl setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public DeleteAclsMatchingAcl setErrorMessage(String v) {
            this.errorMessage = v;
            return this;
        }
        
        public DeleteAclsMatchingAcl setResourceType(byte v) {
            this.resourceType = v;
            return this;
        }
        
        public DeleteAclsMatchingAcl setResourceName(String v) {
            this.resourceName = v;
            return this;
        }
        
        public DeleteAclsMatchingAcl setPatternType(byte v) {
            this.patternType = v;
            return this;
        }
        
        public DeleteAclsMatchingAcl setPrincipal(String v) {
            this.principal = v;
            return this;
        }
        
        public DeleteAclsMatchingAcl setHost(String v) {
            this.host = v;
            return this;
        }
        
        public DeleteAclsMatchingAcl setOperation(byte v) {
            this.operation = v;
            return this;
        }
        
        public DeleteAclsMatchingAcl setPermissionType(byte v) {
            this.permissionType = v;
            return this;
        }
    }
}
