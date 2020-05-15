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


public class FindCoordinatorRequestData implements ApiMessage {
    private String key;
    private byte keyType;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("key", Type.STRING, "The coordinator key.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("key", Type.STRING, "The coordinator key."),
            new Field("key_type", Type.INT8, "The coordinator key type.  (Group, transaction, etc.)")
        );
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2
    };
    
    public FindCoordinatorRequestData(Readable readable, short version) {
        read(readable, version);
    }
    
    public FindCoordinatorRequestData(Struct struct, short version) {
        fromStruct(struct, version);
    }
    
    public FindCoordinatorRequestData() {
        this.key = "";
        this.keyType = (byte) 0;
    }
    
    @Override
    public short apiKey() {
        return 10;
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
        this.key = readable.readNullableString();
        if (version >= 1) {
            this.keyType = readable.readByte();
        } else {
            this.keyType = (byte) 0;
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeString(key);
        if (version >= 1) {
            writable.writeByte(keyType);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.key = struct.getString("key");
        if (version >= 1) {
            this.keyType = struct.getByte("key_type");
        } else {
            this.keyType = (byte) 0;
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("key", this.key);
        if (version >= 1) {
            struct.set("key_type", this.keyType);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 2;
        size += MessageUtil.serializedUtf8Length(key);
        if (version >= 1) {
            size += 1;
        } else {
            if (keyType != (byte) 0) {
                throw new UnsupportedVersionException("Attempted to write a non-default keyType at version " + version);
            }
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FindCoordinatorRequestData)) return false;
        FindCoordinatorRequestData other = (FindCoordinatorRequestData) obj;
        if (this.key == null) {
            if (other.key != null) return false;
        } else {
            if (!this.key.equals(other.key)) return false;
        }
        if (keyType != other.keyType) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (key == null ? 0 : key.hashCode());
        hashCode = 31 * hashCode + keyType;
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "FindCoordinatorRequestData("
            + "key='" + key + "'"
            + ", keyType=" + keyType
            + ")";
    }
    
    public String key() {
        return this.key;
    }
    
    public byte keyType() {
        return this.keyType;
    }
    
    public FindCoordinatorRequestData setKey(String v) {
        this.key = v;
        return this;
    }
    
    public FindCoordinatorRequestData setKeyType(byte v) {
        this.keyType = v;
        return this;
    }
}
