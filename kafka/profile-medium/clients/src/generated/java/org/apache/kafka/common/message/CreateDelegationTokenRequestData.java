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


public class CreateDelegationTokenRequestData implements ApiMessage {
    private List<CreatableRenewers> renewers;
    private long maxLifetimeMs;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("renewers", new ArrayOf(CreatableRenewers.SCHEMA_0), "A list of those who are allowed to renew this token before it expires."),
            new Field("max_lifetime_ms", Type.INT64, "The maximum lifetime of the token in milliseconds, or -1 to use the server side default.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public CreateDelegationTokenRequestData(Readable readable, short version) {
        this.renewers = new ArrayList<CreatableRenewers>();
        read(readable, version);
    }
    
    public CreateDelegationTokenRequestData(Struct struct, short version) {
        this.renewers = new ArrayList<CreatableRenewers>();
        fromStruct(struct, version);
    }
    
    public CreateDelegationTokenRequestData() {
        this.renewers = new ArrayList<CreatableRenewers>();
        this.maxLifetimeMs = 0L;
    }
    
    @Override
    public short apiKey() {
        return 38;
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
                this.renewers.clear();
            } else {
                this.renewers.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.renewers.add(new CreatableRenewers(readable, version));
                }
            }
        }
        this.maxLifetimeMs = readable.readLong();
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(renewers.size());
        for (CreatableRenewers element : renewers) {
            element.write(writable, version);
        }
        writable.writeLong(maxLifetimeMs);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        {
            Object[] nestedObjects = struct.getArray("renewers");
            this.renewers = new ArrayList<CreatableRenewers>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.renewers.add(new CreatableRenewers((Struct) nestedObject, version));
            }
        }
        this.maxLifetimeMs = struct.getLong("max_lifetime_ms");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        {
            Struct[] nestedObjects = new Struct[renewers.size()];
            int i = 0;
            for (CreatableRenewers element : this.renewers) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("renewers", (Object[]) nestedObjects);
        }
        struct.set("max_lifetime_ms", this.maxLifetimeMs);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        for (CreatableRenewers element : renewers) {
            size += element.size(version);
        }
        size += 8;
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CreateDelegationTokenRequestData)) return false;
        CreateDelegationTokenRequestData other = (CreateDelegationTokenRequestData) obj;
        if (this.renewers == null) {
            if (other.renewers != null) return false;
        } else {
            if (!this.renewers.equals(other.renewers)) return false;
        }
        if (maxLifetimeMs != other.maxLifetimeMs) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (renewers == null ? 0 : renewers.hashCode());
        hashCode = 31 * hashCode + ((int) (maxLifetimeMs >> 32) ^ (int) maxLifetimeMs);
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "CreateDelegationTokenRequestData("
            + "renewers=" + MessageUtil.deepToString(renewers.iterator())
            + ", maxLifetimeMs=" + maxLifetimeMs
            + ")";
    }
    
    public List<CreatableRenewers> renewers() {
        return this.renewers;
    }
    
    public long maxLifetimeMs() {
        return this.maxLifetimeMs;
    }
    
    public CreateDelegationTokenRequestData setRenewers(List<CreatableRenewers> v) {
        this.renewers = v;
        return this;
    }
    
    public CreateDelegationTokenRequestData setMaxLifetimeMs(long v) {
        this.maxLifetimeMs = v;
        return this;
    }
    
    static public class CreatableRenewers implements Message {
        private String principalType;
        private String principalName;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("principal_type", Type.STRING, "The type of the Kafka principal."),
                new Field("principal_name", Type.STRING, "The name of the Kafka principal.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public CreatableRenewers(Readable readable, short version) {
            read(readable, version);
        }
        
        public CreatableRenewers(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public CreatableRenewers() {
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
            if (!(obj instanceof CreatableRenewers)) return false;
            CreatableRenewers other = (CreatableRenewers) obj;
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
            return "CreatableRenewers("
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
        
        public CreatableRenewers setPrincipalType(String v) {
            this.principalType = v;
            return this;
        }
        
        public CreatableRenewers setPrincipalName(String v) {
            this.principalName = v;
            return this;
        }
    }
}
