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


public class DescribeConfigsRequestData implements ApiMessage {
    private List<DescribeConfigsResource> resources;
    private boolean includeSynoyms;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("resources", new ArrayOf(DescribeConfigsResource.SCHEMA_0), "The resources whose configurations we want to describe.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("resources", new ArrayOf(DescribeConfigsResource.SCHEMA_0), "The resources whose configurations we want to describe."),
            new Field("include_synoyms", Type.BOOLEAN, "True if we should include all synonyms.")
        );
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2
    };
    
    public DescribeConfigsRequestData(Readable readable, short version) {
        this.resources = new ArrayList<DescribeConfigsResource>();
        read(readable, version);
    }
    
    public DescribeConfigsRequestData(Struct struct, short version) {
        this.resources = new ArrayList<DescribeConfigsResource>();
        fromStruct(struct, version);
    }
    
    public DescribeConfigsRequestData() {
        this.resources = new ArrayList<DescribeConfigsResource>();
        this.includeSynoyms = false;
    }
    
    @Override
    public short apiKey() {
        return 32;
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
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.resources.clear();
            } else {
                this.resources.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.resources.add(new DescribeConfigsResource(readable, version));
                }
            }
        }
        if (version >= 1) {
            this.includeSynoyms = readable.readByte() != 0;
        } else {
            this.includeSynoyms = false;
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(resources.size());
        for (DescribeConfigsResource element : resources) {
            element.write(writable, version);
        }
        if (version >= 1) {
            writable.writeByte(includeSynoyms ? (byte) 1 : (byte) 0);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        {
            Object[] nestedObjects = struct.getArray("resources");
            this.resources = new ArrayList<DescribeConfigsResource>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.resources.add(new DescribeConfigsResource((Struct) nestedObject, version));
            }
        }
        if (version >= 1) {
            this.includeSynoyms = struct.getBoolean("include_synoyms");
        } else {
            this.includeSynoyms = false;
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        {
            Struct[] nestedObjects = new Struct[resources.size()];
            int i = 0;
            for (DescribeConfigsResource element : this.resources) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("resources", (Object[]) nestedObjects);
        }
        if (version >= 1) {
            struct.set("include_synoyms", this.includeSynoyms);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        for (DescribeConfigsResource element : resources) {
            size += element.size(version);
        }
        if (version >= 1) {
            size += 1;
        } else {
            if (includeSynoyms) {
                throw new UnsupportedVersionException("Attempted to write a non-default includeSynoyms at version " + version);
            }
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DescribeConfigsRequestData)) return false;
        DescribeConfigsRequestData other = (DescribeConfigsRequestData) obj;
        if (this.resources == null) {
            if (other.resources != null) return false;
        } else {
            if (!this.resources.equals(other.resources)) return false;
        }
        if (includeSynoyms != other.includeSynoyms) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (resources == null ? 0 : resources.hashCode());
        hashCode = 31 * hashCode + (includeSynoyms ? 1231 : 1237);
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "DescribeConfigsRequestData("
            + "resources=" + MessageUtil.deepToString(resources.iterator())
            + ", includeSynoyms=" + (includeSynoyms ? "true" : "false")
            + ")";
    }
    
    public List<DescribeConfigsResource> resources() {
        return this.resources;
    }
    
    public boolean includeSynoyms() {
        return this.includeSynoyms;
    }
    
    public DescribeConfigsRequestData setResources(List<DescribeConfigsResource> v) {
        this.resources = v;
        return this;
    }
    
    public DescribeConfigsRequestData setIncludeSynoyms(boolean v) {
        this.includeSynoyms = v;
        return this;
    }
    
    static public class DescribeConfigsResource implements Message {
        private byte resourceType;
        private String resourceName;
        private List<String> configurationKeys;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("resource_type", Type.INT8, "The resource type."),
                new Field("resource_name", Type.STRING, "The resource name."),
                new Field("configuration_keys", ArrayOf.nullable(Type.STRING), "The configuration keys to list, or null to list all configuration keys.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public DescribeConfigsResource(Readable readable, short version) {
            this.configurationKeys = new ArrayList<String>();
            read(readable, version);
        }
        
        public DescribeConfigsResource(Struct struct, short version) {
            this.configurationKeys = new ArrayList<String>();
            fromStruct(struct, version);
        }
        
        public DescribeConfigsResource() {
            this.resourceType = (byte) 0;
            this.resourceName = "";
            this.configurationKeys = new ArrayList<String>();
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
            this.resourceType = readable.readByte();
            this.resourceName = readable.readNullableString();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.configurationKeys.clear();
                } else {
                    this.configurationKeys.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.configurationKeys.add(readable.readNullableString());
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeByte(resourceType);
            writable.writeString(resourceName);
            if (configurationKeys == null) {
                writable.writeInt(-1);
            } else {
                writable.writeInt(configurationKeys.size());
                for (String element : configurationKeys) {
                    writable.writeString(element);
                }
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.resourceType = struct.getByte("resource_type");
            this.resourceName = struct.getString("resource_name");
            {
                Object[] nestedObjects = struct.getArray("configuration_keys");
                if (nestedObjects == null) {
                    this.configurationKeys = null;
                } else {
                    this.configurationKeys = new ArrayList<String>(nestedObjects.length);
                    for (Object nestedObject : nestedObjects) {
                        this.configurationKeys.add((String) nestedObject);
                    }
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("resource_type", this.resourceType);
            struct.set("resource_name", this.resourceName);
            {
                if (configurationKeys == null) {
                    struct.set("configuration_keys", null);
                } else {
                    String[] nestedObjects = new String[configurationKeys.size()];
                    int i = 0;
                    for (String element : this.configurationKeys) {
                        nestedObjects[i++] = element;
                    }
                    struct.set("configuration_keys", (Object[]) nestedObjects);
                }
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 1;
            size += 2;
            size += MessageUtil.serializedUtf8Length(resourceName);
            if (configurationKeys == null) {
                size += 4;
            } else {
                size += 4;
                for (String element : configurationKeys) {
                    size += 2;
                    size += MessageUtil.serializedUtf8Length(element);
                }
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DescribeConfigsResource)) return false;
            DescribeConfigsResource other = (DescribeConfigsResource) obj;
            if (resourceType != other.resourceType) return false;
            if (this.resourceName == null) {
                if (other.resourceName != null) return false;
            } else {
                if (!this.resourceName.equals(other.resourceName)) return false;
            }
            if (this.configurationKeys == null) {
                if (other.configurationKeys != null) return false;
            } else {
                if (!this.configurationKeys.equals(other.configurationKeys)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + resourceType;
            hashCode = 31 * hashCode + (resourceName == null ? 0 : resourceName.hashCode());
            hashCode = 31 * hashCode + (configurationKeys == null ? 0 : configurationKeys.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DescribeConfigsResource("
                + "resourceType=" + resourceType
                + ", resourceName='" + resourceName + "'"
                + ", configurationKeys=" + MessageUtil.deepToString(configurationKeys.iterator())
                + ")";
        }
        
        public byte resourceType() {
            return this.resourceType;
        }
        
        public String resourceName() {
            return this.resourceName;
        }
        
        public List<String> configurationKeys() {
            return this.configurationKeys;
        }
        
        public DescribeConfigsResource setResourceType(byte v) {
            this.resourceType = v;
            return this;
        }
        
        public DescribeConfigsResource setResourceName(String v) {
            this.resourceName = v;
            return this;
        }
        
        public DescribeConfigsResource setConfigurationKeys(List<String> v) {
            this.configurationKeys = v;
            return this;
        }
    }
}
