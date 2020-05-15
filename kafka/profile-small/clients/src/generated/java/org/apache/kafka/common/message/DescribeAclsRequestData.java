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

import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.ApiMessage;
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Struct;
import org.apache.kafka.common.protocol.types.Type;


public class DescribeAclsRequestData implements ApiMessage {
    private byte resourceType;
    private String resourceNameFilter;
    private byte resourcePatternType;
    private String principalFilter;
    private String hostFilter;
    private byte operation;
    private byte permissionType;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("resource_type", Type.INT8, "The resource type."),
            new Field("resource_name_filter", Type.NULLABLE_STRING, "The resource name, or null to match any resource name."),
            new Field("principal_filter", Type.NULLABLE_STRING, "The principal to match, or null to match any principal."),
            new Field("host_filter", Type.NULLABLE_STRING, "The host to match, or null to match any host."),
            new Field("operation", Type.INT8, "The operation to match."),
            new Field("permission_type", Type.INT8, "The permission type to match.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("resource_type", Type.INT8, "The resource type."),
            new Field("resource_name_filter", Type.NULLABLE_STRING, "The resource name, or null to match any resource name."),
            new Field("resource_pattern_type", Type.INT8, "The resource pattern to match."),
            new Field("principal_filter", Type.NULLABLE_STRING, "The principal to match, or null to match any principal."),
            new Field("host_filter", Type.NULLABLE_STRING, "The host to match, or null to match any host."),
            new Field("operation", Type.INT8, "The operation to match."),
            new Field("permission_type", Type.INT8, "The permission type to match.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public DescribeAclsRequestData(Readable readable, short version) {
        read(readable, version);
    }
    
    public DescribeAclsRequestData(Struct struct, short version) {
        fromStruct(struct, version);
    }
    
    public DescribeAclsRequestData() {
        this.resourceType = (byte) 0;
        this.resourceNameFilter = "";
        this.resourcePatternType = (byte) 3;
        this.principalFilter = "";
        this.hostFilter = "";
        this.operation = (byte) 0;
        this.permissionType = (byte) 0;
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
        this.resourceType = readable.readByte();
        this.resourceNameFilter = readable.readNullableString();
        if (version >= 1) {
            this.resourcePatternType = readable.readByte();
        } else {
            this.resourcePatternType = (byte) 3;
        }
        this.principalFilter = readable.readNullableString();
        this.hostFilter = readable.readNullableString();
        this.operation = readable.readByte();
        this.permissionType = readable.readByte();
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeByte(resourceType);
        writable.writeNullableString(resourceNameFilter);
        if (version >= 1) {
            writable.writeByte(resourcePatternType);
        }
        writable.writeNullableString(principalFilter);
        writable.writeNullableString(hostFilter);
        writable.writeByte(operation);
        writable.writeByte(permissionType);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.resourceType = struct.getByte("resource_type");
        this.resourceNameFilter = struct.getString("resource_name_filter");
        if (version >= 1) {
            this.resourcePatternType = struct.getByte("resource_pattern_type");
        } else {
            this.resourcePatternType = (byte) 3;
        }
        this.principalFilter = struct.getString("principal_filter");
        this.hostFilter = struct.getString("host_filter");
        this.operation = struct.getByte("operation");
        this.permissionType = struct.getByte("permission_type");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("resource_type", this.resourceType);
        struct.set("resource_name_filter", this.resourceNameFilter);
        if (version >= 1) {
            struct.set("resource_pattern_type", this.resourcePatternType);
        }
        struct.set("principal_filter", this.principalFilter);
        struct.set("host_filter", this.hostFilter);
        struct.set("operation", this.operation);
        struct.set("permission_type", this.permissionType);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 1;
        size += 2;
        if (resourceNameFilter != null) {
            size += MessageUtil.serializedUtf8Length(resourceNameFilter);
        }
        if (version >= 1) {
            size += 1;
        } else {
            if (resourcePatternType != (byte) 3) {
                throw new UnsupportedVersionException("Attempted to write a non-default resourcePatternType at version " + version);
            }
        }
        size += 2;
        if (principalFilter != null) {
            size += MessageUtil.serializedUtf8Length(principalFilter);
        }
        size += 2;
        if (hostFilter != null) {
            size += MessageUtil.serializedUtf8Length(hostFilter);
        }
        size += 1;
        size += 1;
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DescribeAclsRequestData)) return false;
        DescribeAclsRequestData other = (DescribeAclsRequestData) obj;
        if (resourceType != other.resourceType) return false;
        if (this.resourceNameFilter == null) {
            if (other.resourceNameFilter != null) return false;
        } else {
            if (!this.resourceNameFilter.equals(other.resourceNameFilter)) return false;
        }
        if (resourcePatternType != other.resourcePatternType) return false;
        if (this.principalFilter == null) {
            if (other.principalFilter != null) return false;
        } else {
            if (!this.principalFilter.equals(other.principalFilter)) return false;
        }
        if (this.hostFilter == null) {
            if (other.hostFilter != null) return false;
        } else {
            if (!this.hostFilter.equals(other.hostFilter)) return false;
        }
        if (operation != other.operation) return false;
        if (permissionType != other.permissionType) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + resourceType;
        hashCode = 31 * hashCode + (resourceNameFilter == null ? 0 : resourceNameFilter.hashCode());
        hashCode = 31 * hashCode + resourcePatternType;
        hashCode = 31 * hashCode + (principalFilter == null ? 0 : principalFilter.hashCode());
        hashCode = 31 * hashCode + (hostFilter == null ? 0 : hostFilter.hashCode());
        hashCode = 31 * hashCode + operation;
        hashCode = 31 * hashCode + permissionType;
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "DescribeAclsRequestData("
            + "resourceType=" + resourceType
            + ", resourceNameFilter='" + resourceNameFilter + "'"
            + ", resourcePatternType=" + resourcePatternType
            + ", principalFilter='" + principalFilter + "'"
            + ", hostFilter='" + hostFilter + "'"
            + ", operation=" + operation
            + ", permissionType=" + permissionType
            + ")";
    }
    
    public byte resourceType() {
        return this.resourceType;
    }
    
    public String resourceNameFilter() {
        return this.resourceNameFilter;
    }
    
    public byte resourcePatternType() {
        return this.resourcePatternType;
    }
    
    public String principalFilter() {
        return this.principalFilter;
    }
    
    public String hostFilter() {
        return this.hostFilter;
    }
    
    public byte operation() {
        return this.operation;
    }
    
    public byte permissionType() {
        return this.permissionType;
    }
    
    public DescribeAclsRequestData setResourceType(byte v) {
        this.resourceType = v;
        return this;
    }
    
    public DescribeAclsRequestData setResourceNameFilter(String v) {
        this.resourceNameFilter = v;
        return this;
    }
    
    public DescribeAclsRequestData setResourcePatternType(byte v) {
        this.resourcePatternType = v;
        return this;
    }
    
    public DescribeAclsRequestData setPrincipalFilter(String v) {
        this.principalFilter = v;
        return this;
    }
    
    public DescribeAclsRequestData setHostFilter(String v) {
        this.hostFilter = v;
        return this;
    }
    
    public DescribeAclsRequestData setOperation(byte v) {
        this.operation = v;
        return this;
    }
    
    public DescribeAclsRequestData setPermissionType(byte v) {
        this.permissionType = v;
        return this;
    }
}
