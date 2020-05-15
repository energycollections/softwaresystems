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


public class DeleteAclsRequestData implements ApiMessage {
    private List<DeleteAclsFilter> filters;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("filters", new ArrayOf(DeleteAclsFilter.SCHEMA_0), "The filters to use when deleting ACLs.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("filters", new ArrayOf(DeleteAclsFilter.SCHEMA_1), "The filters to use when deleting ACLs.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public DeleteAclsRequestData(Readable readable, short version) {
        this.filters = new ArrayList<DeleteAclsFilter>();
        read(readable, version);
    }
    
    public DeleteAclsRequestData(Struct struct, short version) {
        this.filters = new ArrayList<DeleteAclsFilter>();
        fromStruct(struct, version);
    }
    
    public DeleteAclsRequestData() {
        this.filters = new ArrayList<DeleteAclsFilter>();
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
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.filters.clear();
            } else {
                this.filters.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.filters.add(new DeleteAclsFilter(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(filters.size());
        for (DeleteAclsFilter element : filters) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        {
            Object[] nestedObjects = struct.getArray("filters");
            this.filters = new ArrayList<DeleteAclsFilter>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.filters.add(new DeleteAclsFilter((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        {
            Struct[] nestedObjects = new Struct[filters.size()];
            int i = 0;
            for (DeleteAclsFilter element : this.filters) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("filters", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        for (DeleteAclsFilter element : filters) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DeleteAclsRequestData)) return false;
        DeleteAclsRequestData other = (DeleteAclsRequestData) obj;
        if (this.filters == null) {
            if (other.filters != null) return false;
        } else {
            if (!this.filters.equals(other.filters)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (filters == null ? 0 : filters.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "DeleteAclsRequestData("
            + "filters=" + MessageUtil.deepToString(filters.iterator())
            + ")";
    }
    
    public List<DeleteAclsFilter> filters() {
        return this.filters;
    }
    
    public DeleteAclsRequestData setFilters(List<DeleteAclsFilter> v) {
        this.filters = v;
        return this;
    }
    
    static public class DeleteAclsFilter implements Message {
        private byte resourceTypeFilter;
        private String resourceNameFilter;
        private byte patternTypeFilter;
        private String principalFilter;
        private String hostFilter;
        private byte operation;
        private byte permissionType;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("resource_type_filter", Type.INT8, "The resource type."),
                new Field("resource_name_filter", Type.NULLABLE_STRING, "The resource name."),
                new Field("principal_filter", Type.NULLABLE_STRING, "The principal filter, or null to accept all principals."),
                new Field("host_filter", Type.NULLABLE_STRING, "The host filter, or null to accept all hosts."),
                new Field("operation", Type.INT8, "The ACL operation."),
                new Field("permission_type", Type.INT8, "The permission type.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("resource_type_filter", Type.INT8, "The resource type."),
                new Field("resource_name_filter", Type.NULLABLE_STRING, "The resource name."),
                new Field("pattern_type_filter", Type.INT8, "The pattern type."),
                new Field("principal_filter", Type.NULLABLE_STRING, "The principal filter, or null to accept all principals."),
                new Field("host_filter", Type.NULLABLE_STRING, "The host filter, or null to accept all hosts."),
                new Field("operation", Type.INT8, "The ACL operation."),
                new Field("permission_type", Type.INT8, "The permission type.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public DeleteAclsFilter(Readable readable, short version) {
            read(readable, version);
        }
        
        public DeleteAclsFilter(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public DeleteAclsFilter() {
            this.resourceTypeFilter = (byte) 0;
            this.resourceNameFilter = "";
            this.patternTypeFilter = (byte) 3;
            this.principalFilter = "";
            this.hostFilter = "";
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
            this.resourceTypeFilter = readable.readByte();
            this.resourceNameFilter = readable.readNullableString();
            if (version >= 1) {
                this.patternTypeFilter = readable.readByte();
            } else {
                this.patternTypeFilter = (byte) 3;
            }
            this.principalFilter = readable.readNullableString();
            this.hostFilter = readable.readNullableString();
            this.operation = readable.readByte();
            this.permissionType = readable.readByte();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeByte(resourceTypeFilter);
            writable.writeNullableString(resourceNameFilter);
            if (version >= 1) {
                writable.writeByte(patternTypeFilter);
            }
            writable.writeNullableString(principalFilter);
            writable.writeNullableString(hostFilter);
            writable.writeByte(operation);
            writable.writeByte(permissionType);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.resourceTypeFilter = struct.getByte("resource_type_filter");
            this.resourceNameFilter = struct.getString("resource_name_filter");
            if (version >= 1) {
                this.patternTypeFilter = struct.getByte("pattern_type_filter");
            } else {
                this.patternTypeFilter = (byte) 3;
            }
            this.principalFilter = struct.getString("principal_filter");
            this.hostFilter = struct.getString("host_filter");
            this.operation = struct.getByte("operation");
            this.permissionType = struct.getByte("permission_type");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("resource_type_filter", this.resourceTypeFilter);
            struct.set("resource_name_filter", this.resourceNameFilter);
            if (version >= 1) {
                struct.set("pattern_type_filter", this.patternTypeFilter);
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
                if (patternTypeFilter != (byte) 3) {
                    throw new UnsupportedVersionException("Attempted to write a non-default patternTypeFilter at version " + version);
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
            if (!(obj instanceof DeleteAclsFilter)) return false;
            DeleteAclsFilter other = (DeleteAclsFilter) obj;
            if (resourceTypeFilter != other.resourceTypeFilter) return false;
            if (this.resourceNameFilter == null) {
                if (other.resourceNameFilter != null) return false;
            } else {
                if (!this.resourceNameFilter.equals(other.resourceNameFilter)) return false;
            }
            if (patternTypeFilter != other.patternTypeFilter) return false;
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
            hashCode = 31 * hashCode + resourceTypeFilter;
            hashCode = 31 * hashCode + (resourceNameFilter == null ? 0 : resourceNameFilter.hashCode());
            hashCode = 31 * hashCode + patternTypeFilter;
            hashCode = 31 * hashCode + (principalFilter == null ? 0 : principalFilter.hashCode());
            hashCode = 31 * hashCode + (hostFilter == null ? 0 : hostFilter.hashCode());
            hashCode = 31 * hashCode + operation;
            hashCode = 31 * hashCode + permissionType;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DeleteAclsFilter("
                + "resourceTypeFilter=" + resourceTypeFilter
                + ", resourceNameFilter='" + resourceNameFilter + "'"
                + ", patternTypeFilter=" + patternTypeFilter
                + ", principalFilter='" + principalFilter + "'"
                + ", hostFilter='" + hostFilter + "'"
                + ", operation=" + operation
                + ", permissionType=" + permissionType
                + ")";
        }
        
        public byte resourceTypeFilter() {
            return this.resourceTypeFilter;
        }
        
        public String resourceNameFilter() {
            return this.resourceNameFilter;
        }
        
        public byte patternTypeFilter() {
            return this.patternTypeFilter;
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
        
        public DeleteAclsFilter setResourceTypeFilter(byte v) {
            this.resourceTypeFilter = v;
            return this;
        }
        
        public DeleteAclsFilter setResourceNameFilter(String v) {
            this.resourceNameFilter = v;
            return this;
        }
        
        public DeleteAclsFilter setPatternTypeFilter(byte v) {
            this.patternTypeFilter = v;
            return this;
        }
        
        public DeleteAclsFilter setPrincipalFilter(String v) {
            this.principalFilter = v;
            return this;
        }
        
        public DeleteAclsFilter setHostFilter(String v) {
            this.hostFilter = v;
            return this;
        }
        
        public DeleteAclsFilter setOperation(byte v) {
            this.operation = v;
            return this;
        }
        
        public DeleteAclsFilter setPermissionType(byte v) {
            this.permissionType = v;
            return this;
        }
    }
}
