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


public class DescribeDelegationTokenRequestData implements ApiMessage {
    private List<DescribeDelegationTokenOwner> owners;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("owners", ArrayOf.nullable(DescribeDelegationTokenOwner.SCHEMA_0), "Each owner that we want to describe delegation tokens for, or null to describe all tokens.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public DescribeDelegationTokenRequestData(Readable readable, short version) {
        this.owners = new ArrayList<DescribeDelegationTokenOwner>();
        read(readable, version);
    }
    
    public DescribeDelegationTokenRequestData(Struct struct, short version) {
        this.owners = new ArrayList<DescribeDelegationTokenOwner>();
        fromStruct(struct, version);
    }
    
    public DescribeDelegationTokenRequestData() {
        this.owners = new ArrayList<DescribeDelegationTokenOwner>();
    }
    
    @Override
    public short apiKey() {
        return 41;
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
                this.owners.clear();
            } else {
                this.owners.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.owners.add(new DescribeDelegationTokenOwner(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        if (owners == null) {
            writable.writeInt(-1);
        } else {
            writable.writeInt(owners.size());
            for (DescribeDelegationTokenOwner element : owners) {
                element.write(writable, version);
            }
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        {
            Object[] nestedObjects = struct.getArray("owners");
            if (nestedObjects == null) {
                this.owners = null;
            } else {
                this.owners = new ArrayList<DescribeDelegationTokenOwner>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.owners.add(new DescribeDelegationTokenOwner((Struct) nestedObject, version));
                }
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        {
            if (owners == null) {
                struct.set("owners", null);
            } else {
                Struct[] nestedObjects = new Struct[owners.size()];
                int i = 0;
                for (DescribeDelegationTokenOwner element : this.owners) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("owners", (Object[]) nestedObjects);
            }
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        if (owners == null) {
            size += 4;
        } else {
            size += 4;
            for (DescribeDelegationTokenOwner element : owners) {
                size += element.size(version);
            }
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DescribeDelegationTokenRequestData)) return false;
        DescribeDelegationTokenRequestData other = (DescribeDelegationTokenRequestData) obj;
        if (this.owners == null) {
            if (other.owners != null) return false;
        } else {
            if (!this.owners.equals(other.owners)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (owners == null ? 0 : owners.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "DescribeDelegationTokenRequestData("
            + "owners=" + MessageUtil.deepToString(owners.iterator())
            + ")";
    }
    
    public List<DescribeDelegationTokenOwner> owners() {
        return this.owners;
    }
    
    public DescribeDelegationTokenRequestData setOwners(List<DescribeDelegationTokenOwner> v) {
        this.owners = v;
        return this;
    }
    
    static public class DescribeDelegationTokenOwner implements Message {
        private String principalType;
        private String principalName;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("principal_type", Type.STRING, "The owner principal type."),
                new Field("principal_name", Type.STRING, "The owner principal name.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public DescribeDelegationTokenOwner(Readable readable, short version) {
            read(readable, version);
        }
        
        public DescribeDelegationTokenOwner(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public DescribeDelegationTokenOwner() {
            this.principalType = "";
            this.principalName = "";
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
            this.principalType = readable.readNullableString();
            this.principalName = readable.readNullableString();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(principalType);
            writable.writeString(principalName);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.principalType = struct.getString("principal_type");
            this.principalName = struct.getString("principal_name");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("principal_type", this.principalType);
            struct.set("principal_name", this.principalName);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(principalType);
            size += 2;
            size += MessageUtil.serializedUtf8Length(principalName);
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DescribeDelegationTokenOwner)) return false;
            DescribeDelegationTokenOwner other = (DescribeDelegationTokenOwner) obj;
            if (this.principalType == null) {
                if (other.principalType != null) return false;
            } else {
                if (!this.principalType.equals(other.principalType)) return false;
            }
            if (this.principalName == null) {
                if (other.principalName != null) return false;
            } else {
                if (!this.principalName.equals(other.principalName)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (principalType == null ? 0 : principalType.hashCode());
            hashCode = 31 * hashCode + (principalName == null ? 0 : principalName.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DescribeDelegationTokenOwner("
                + "principalType='" + principalType + "'"
                + ", principalName='" + principalName + "'"
                + ")";
        }
        
        public String principalType() {
            return this.principalType;
        }
        
        public String principalName() {
            return this.principalName;
        }
        
        public DescribeDelegationTokenOwner setPrincipalType(String v) {
            this.principalType = v;
            return this;
        }
        
        public DescribeDelegationTokenOwner setPrincipalName(String v) {
            this.principalName = v;
            return this;
        }
    }
}
