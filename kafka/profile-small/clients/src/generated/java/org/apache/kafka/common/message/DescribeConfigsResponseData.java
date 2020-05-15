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


public class DescribeConfigsResponseData implements ApiMessage {
    private int throttleTimeMs;
    private List<DescribeConfigsResult> results;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("results", new ArrayOf(DescribeConfigsResult.SCHEMA_0), "The results for each resource.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("results", new ArrayOf(DescribeConfigsResult.SCHEMA_1), "The results for each resource.")
        );
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2
    };
    
    public DescribeConfigsResponseData(Readable readable, short version) {
        this.results = new ArrayList<DescribeConfigsResult>();
        read(readable, version);
    }
    
    public DescribeConfigsResponseData(Struct struct, short version) {
        this.results = new ArrayList<DescribeConfigsResult>();
        fromStruct(struct, version);
    }
    
    public DescribeConfigsResponseData() {
        this.throttleTimeMs = 0;
        this.results = new ArrayList<DescribeConfigsResult>();
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
        this.throttleTimeMs = readable.readInt();
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.results.clear();
            } else {
                this.results.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.results.add(new DescribeConfigsResult(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(throttleTimeMs);
        writable.writeInt(results.size());
        for (DescribeConfigsResult element : results) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.throttleTimeMs = struct.getInt("throttle_time_ms");
        {
            Object[] nestedObjects = struct.getArray("results");
            this.results = new ArrayList<DescribeConfigsResult>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.results.add(new DescribeConfigsResult((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("throttle_time_ms", this.throttleTimeMs);
        {
            Struct[] nestedObjects = new Struct[results.size()];
            int i = 0;
            for (DescribeConfigsResult element : this.results) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("results", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        size += 4;
        for (DescribeConfigsResult element : results) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DescribeConfigsResponseData)) return false;
        DescribeConfigsResponseData other = (DescribeConfigsResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (this.results == null) {
            if (other.results != null) return false;
        } else {
            if (!this.results.equals(other.results)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + (results == null ? 0 : results.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "DescribeConfigsResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", results=" + MessageUtil.deepToString(results.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public List<DescribeConfigsResult> results() {
        return this.results;
    }
    
    public DescribeConfigsResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public DescribeConfigsResponseData setResults(List<DescribeConfigsResult> v) {
        this.results = v;
        return this;
    }
    
    static public class DescribeConfigsResult implements Message {
        private short errorCode;
        private String errorMessage;
        private byte resourceType;
        private String resourceName;
        private List<DescribeConfigsResourceResult> configs;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("error_code", Type.INT16, "The error code, or 0 if we were able to successfully describe the configurations."),
                new Field("error_message", Type.NULLABLE_STRING, "The error message, or null if we were able to successfully describe the configurations."),
                new Field("resource_type", Type.INT8, "The resource type."),
                new Field("resource_name", Type.STRING, "The resource name."),
                new Field("configs", new ArrayOf(DescribeConfigsResourceResult.SCHEMA_0), "Each listed configuration.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("error_code", Type.INT16, "The error code, or 0 if we were able to successfully describe the configurations."),
                new Field("error_message", Type.NULLABLE_STRING, "The error message, or null if we were able to successfully describe the configurations."),
                new Field("resource_type", Type.INT8, "The resource type."),
                new Field("resource_name", Type.STRING, "The resource name."),
                new Field("configs", new ArrayOf(DescribeConfigsResourceResult.SCHEMA_1), "Each listed configuration.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public DescribeConfigsResult(Readable readable, short version) {
            this.configs = new ArrayList<DescribeConfigsResourceResult>();
            read(readable, version);
        }
        
        public DescribeConfigsResult(Struct struct, short version) {
            this.configs = new ArrayList<DescribeConfigsResourceResult>();
            fromStruct(struct, version);
        }
        
        public DescribeConfigsResult() {
            this.errorCode = (short) 0;
            this.errorMessage = "";
            this.resourceType = (byte) 0;
            this.resourceName = "";
            this.configs = new ArrayList<DescribeConfigsResourceResult>();
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
            this.errorMessage = readable.readNullableString();
            this.resourceType = readable.readByte();
            this.resourceName = readable.readNullableString();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.configs.clear();
                } else {
                    this.configs.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.configs.add(new DescribeConfigsResourceResult(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeShort(errorCode);
            writable.writeNullableString(errorMessage);
            writable.writeByte(resourceType);
            writable.writeString(resourceName);
            writable.writeInt(configs.size());
            for (DescribeConfigsResourceResult element : configs) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.errorCode = struct.getShort("error_code");
            this.errorMessage = struct.getString("error_message");
            this.resourceType = struct.getByte("resource_type");
            this.resourceName = struct.getString("resource_name");
            {
                Object[] nestedObjects = struct.getArray("configs");
                this.configs = new ArrayList<DescribeConfigsResourceResult>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.configs.add(new DescribeConfigsResourceResult((Struct) nestedObject, version));
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("error_code", this.errorCode);
            struct.set("error_message", this.errorMessage);
            struct.set("resource_type", this.resourceType);
            struct.set("resource_name", this.resourceName);
            {
                Struct[] nestedObjects = new Struct[configs.size()];
                int i = 0;
                for (DescribeConfigsResourceResult element : this.configs) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("configs", (Object[]) nestedObjects);
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
            size += 1;
            size += 2;
            size += MessageUtil.serializedUtf8Length(resourceName);
            size += 4;
            for (DescribeConfigsResourceResult element : configs) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DescribeConfigsResult)) return false;
            DescribeConfigsResult other = (DescribeConfigsResult) obj;
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
            if (this.configs == null) {
                if (other.configs != null) return false;
            } else {
                if (!this.configs.equals(other.configs)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + errorCode;
            hashCode = 31 * hashCode + (errorMessage == null ? 0 : errorMessage.hashCode());
            hashCode = 31 * hashCode + resourceType;
            hashCode = 31 * hashCode + (resourceName == null ? 0 : resourceName.hashCode());
            hashCode = 31 * hashCode + (configs == null ? 0 : configs.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DescribeConfigsResult("
                + "errorCode=" + errorCode
                + ", errorMessage='" + errorMessage + "'"
                + ", resourceType=" + resourceType
                + ", resourceName='" + resourceName + "'"
                + ", configs=" + MessageUtil.deepToString(configs.iterator())
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
        
        public List<DescribeConfigsResourceResult> configs() {
            return this.configs;
        }
        
        public DescribeConfigsResult setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public DescribeConfigsResult setErrorMessage(String v) {
            this.errorMessage = v;
            return this;
        }
        
        public DescribeConfigsResult setResourceType(byte v) {
            this.resourceType = v;
            return this;
        }
        
        public DescribeConfigsResult setResourceName(String v) {
            this.resourceName = v;
            return this;
        }
        
        public DescribeConfigsResult setConfigs(List<DescribeConfigsResourceResult> v) {
            this.configs = v;
            return this;
        }
    }
    
    static public class DescribeConfigsResourceResult implements Message {
        private String name;
        private String value;
        private boolean readOnly;
        private boolean isDefault;
        private byte configSource;
        private boolean isSensitive;
        private List<DescribeConfigsSynonym> synonyms;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The configuration name."),
                new Field("value", Type.NULLABLE_STRING, "The configuration value."),
                new Field("read_only", Type.BOOLEAN, "True if the configuration is read-only."),
                new Field("is_default", Type.BOOLEAN, "True if the configuration is not set."),
                new Field("is_sensitive", Type.BOOLEAN, "True if this configuration is sensitive.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("name", Type.STRING, "The configuration name."),
                new Field("value", Type.NULLABLE_STRING, "The configuration value."),
                new Field("read_only", Type.BOOLEAN, "True if the configuration is read-only."),
                new Field("config_source", Type.INT8, "The configuration source."),
                new Field("is_sensitive", Type.BOOLEAN, "True if this configuration is sensitive."),
                new Field("synonyms", new ArrayOf(DescribeConfigsSynonym.SCHEMA_1), "The synonyms for this configuration key.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public DescribeConfigsResourceResult(Readable readable, short version) {
            this.synonyms = new ArrayList<DescribeConfigsSynonym>();
            read(readable, version);
        }
        
        public DescribeConfigsResourceResult(Struct struct, short version) {
            this.synonyms = new ArrayList<DescribeConfigsSynonym>();
            fromStruct(struct, version);
        }
        
        public DescribeConfigsResourceResult() {
            this.name = "";
            this.value = "";
            this.readOnly = false;
            this.isDefault = false;
            this.configSource = (byte) -1;
            this.isSensitive = false;
            this.synonyms = new ArrayList<DescribeConfigsSynonym>();
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
            this.name = readable.readNullableString();
            this.value = readable.readNullableString();
            this.readOnly = readable.readByte() != 0;
            if (version <= 0) {
                this.isDefault = readable.readByte() != 0;
            } else {
                this.isDefault = false;
            }
            if (version >= 1) {
                this.configSource = readable.readByte();
            } else {
                this.configSource = (byte) -1;
            }
            this.isSensitive = readable.readByte() != 0;
            if (version >= 1) {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.synonyms.clear();
                } else {
                    this.synonyms.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.synonyms.add(new DescribeConfigsSynonym(readable, version));
                    }
                }
            } else {
                this.synonyms = new ArrayList<DescribeConfigsSynonym>();
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeNullableString(value);
            writable.writeByte(readOnly ? (byte) 1 : (byte) 0);
            if (version <= 0) {
                writable.writeByte(isDefault ? (byte) 1 : (byte) 0);
            }
            if (version >= 1) {
                writable.writeByte(configSource);
            }
            writable.writeByte(isSensitive ? (byte) 1 : (byte) 0);
            if (version >= 1) {
                writable.writeInt(synonyms.size());
                for (DescribeConfigsSynonym element : synonyms) {
                    element.write(writable, version);
                }
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            this.value = struct.getString("value");
            this.readOnly = struct.getBoolean("read_only");
            if (version <= 0) {
                this.isDefault = struct.getBoolean("is_default");
            } else {
                this.isDefault = false;
            }
            if (version >= 1) {
                this.configSource = struct.getByte("config_source");
            } else {
                this.configSource = (byte) -1;
            }
            this.isSensitive = struct.getBoolean("is_sensitive");
            if (version >= 1) {
                Object[] nestedObjects = struct.getArray("synonyms");
                this.synonyms = new ArrayList<DescribeConfigsSynonym>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.synonyms.add(new DescribeConfigsSynonym((Struct) nestedObject, version));
                }
            } else {
                this.synonyms = new ArrayList<DescribeConfigsSynonym>();
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            struct.set("value", this.value);
            struct.set("read_only", this.readOnly);
            if (version <= 0) {
                struct.set("is_default", this.isDefault);
            }
            if (version >= 1) {
                struct.set("config_source", this.configSource);
            }
            struct.set("is_sensitive", this.isSensitive);
            if (version >= 1) {
                Struct[] nestedObjects = new Struct[synonyms.size()];
                int i = 0;
                for (DescribeConfigsSynonym element : this.synonyms) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("synonyms", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            size += 2;
            if (value != null) {
                size += MessageUtil.serializedUtf8Length(value);
            }
            size += 1;
            if (version <= 0) {
                size += 1;
            } else {
                if (isDefault) {
                    throw new UnsupportedVersionException("Attempted to write a non-default isDefault at version " + version);
                }
            }
            if (version >= 1) {
                size += 1;
            }
            size += 1;
            if (version >= 1) {
                size += 4;
                for (DescribeConfigsSynonym element : synonyms) {
                    size += element.size(version);
                }
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DescribeConfigsResourceResult)) return false;
            DescribeConfigsResourceResult other = (DescribeConfigsResourceResult) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (this.value == null) {
                if (other.value != null) return false;
            } else {
                if (!this.value.equals(other.value)) return false;
            }
            if (readOnly != other.readOnly) return false;
            if (isDefault != other.isDefault) return false;
            if (configSource != other.configSource) return false;
            if (isSensitive != other.isSensitive) return false;
            if (this.synonyms == null) {
                if (other.synonyms != null) return false;
            } else {
                if (!this.synonyms.equals(other.synonyms)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + (value == null ? 0 : value.hashCode());
            hashCode = 31 * hashCode + (readOnly ? 1231 : 1237);
            hashCode = 31 * hashCode + (isDefault ? 1231 : 1237);
            hashCode = 31 * hashCode + configSource;
            hashCode = 31 * hashCode + (isSensitive ? 1231 : 1237);
            hashCode = 31 * hashCode + (synonyms == null ? 0 : synonyms.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DescribeConfigsResourceResult("
                + "name='" + name + "'"
                + ", value='" + value + "'"
                + ", readOnly=" + (readOnly ? "true" : "false")
                + ", isDefault=" + (isDefault ? "true" : "false")
                + ", configSource=" + configSource
                + ", isSensitive=" + (isSensitive ? "true" : "false")
                + ", synonyms=" + MessageUtil.deepToString(synonyms.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public String value() {
            return this.value;
        }
        
        public boolean readOnly() {
            return this.readOnly;
        }
        
        public boolean isDefault() {
            return this.isDefault;
        }
        
        public byte configSource() {
            return this.configSource;
        }
        
        public boolean isSensitive() {
            return this.isSensitive;
        }
        
        public List<DescribeConfigsSynonym> synonyms() {
            return this.synonyms;
        }
        
        public DescribeConfigsResourceResult setName(String v) {
            this.name = v;
            return this;
        }
        
        public DescribeConfigsResourceResult setValue(String v) {
            this.value = v;
            return this;
        }
        
        public DescribeConfigsResourceResult setReadOnly(boolean v) {
            this.readOnly = v;
            return this;
        }
        
        public DescribeConfigsResourceResult setIsDefault(boolean v) {
            this.isDefault = v;
            return this;
        }
        
        public DescribeConfigsResourceResult setConfigSource(byte v) {
            this.configSource = v;
            return this;
        }
        
        public DescribeConfigsResourceResult setIsSensitive(boolean v) {
            this.isSensitive = v;
            return this;
        }
        
        public DescribeConfigsResourceResult setSynonyms(List<DescribeConfigsSynonym> v) {
            this.synonyms = v;
            return this;
        }
    }
    
    static public class DescribeConfigsSynonym implements Message {
        private String name;
        private String value;
        private byte source;
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("name", Type.STRING, "The synonym name."),
                new Field("value", Type.NULLABLE_STRING, "The synonym value."),
                new Field("source", Type.INT8, "The synonym source.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public DescribeConfigsSynonym(Readable readable, short version) {
            read(readable, version);
        }
        
        public DescribeConfigsSynonym(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public DescribeConfigsSynonym() {
            this.name = "";
            this.value = "";
            this.source = (byte) 0;
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
            if (version < 1) {
                throw new UnsupportedVersionException("Can't read version " + version + " of DescribeConfigsSynonym");
            }
            this.name = readable.readNullableString();
            this.value = readable.readNullableString();
            this.source = readable.readByte();
        }
        
        @Override
        public void write(Writable writable, short version) {
            if (version < 1) {
                throw new UnsupportedVersionException("Can't write version " + version + " of DescribeConfigsSynonym");
            }
            writable.writeString(name);
            writable.writeNullableString(value);
            writable.writeByte(source);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            if (version < 1) {
                throw new UnsupportedVersionException("Can't read version " + version + " of DescribeConfigsSynonym");
            }
            this.name = struct.getString("name");
            this.value = struct.getString("value");
            this.source = struct.getByte("source");
        }
        
        @Override
        public Struct toStruct(short version) {
            if (version < 1) {
                throw new UnsupportedVersionException("Can't write version " + version + " of DescribeConfigsSynonym");
            }
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            struct.set("value", this.value);
            struct.set("source", this.source);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            if (version < 1) {
                throw new UnsupportedVersionException("Can't size version " + version + " of DescribeConfigsSynonym");
            }
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            size += 2;
            if (value != null) {
                size += MessageUtil.serializedUtf8Length(value);
            }
            size += 1;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DescribeConfigsSynonym)) return false;
            DescribeConfigsSynonym other = (DescribeConfigsSynonym) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (this.value == null) {
                if (other.value != null) return false;
            } else {
                if (!this.value.equals(other.value)) return false;
            }
            if (source != other.source) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + (value == null ? 0 : value.hashCode());
            hashCode = 31 * hashCode + source;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DescribeConfigsSynonym("
                + "name='" + name + "'"
                + ", value='" + value + "'"
                + ", source=" + source
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public String value() {
            return this.value;
        }
        
        public byte source() {
            return this.source;
        }
        
        public DescribeConfigsSynonym setName(String v) {
            this.name = v;
            return this;
        }
        
        public DescribeConfigsSynonym setValue(String v) {
            this.value = v;
            return this;
        }
        
        public DescribeConfigsSynonym setSource(byte v) {
            this.source = v;
            return this;
        }
    }
}
