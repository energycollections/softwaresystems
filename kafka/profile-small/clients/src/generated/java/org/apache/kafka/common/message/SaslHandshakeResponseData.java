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
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.ArrayOf;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Struct;
import org.apache.kafka.common.protocol.types.Type;


public class SaslHandshakeResponseData implements ApiMessage {
    private short errorCode;
    private List<String> mechanisms;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
            new Field("mechanisms", new ArrayOf(Type.STRING), "The mechanisms enabled in the server.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public SaslHandshakeResponseData(Readable readable, short version) {
        this.mechanisms = new ArrayList<String>();
        read(readable, version);
    }
    
    public SaslHandshakeResponseData(Struct struct, short version) {
        this.mechanisms = new ArrayList<String>();
        fromStruct(struct, version);
    }
    
    public SaslHandshakeResponseData() {
        this.errorCode = (short) 0;
        this.mechanisms = new ArrayList<String>();
    }
    
    @Override
    public short apiKey() {
        return 17;
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
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.mechanisms.clear();
            } else {
                this.mechanisms.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.mechanisms.add(readable.readNullableString());
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeShort(errorCode);
        writable.writeInt(mechanisms.size());
        for (String element : mechanisms) {
            writable.writeString(element);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.errorCode = struct.getShort("error_code");
        {
            Object[] nestedObjects = struct.getArray("mechanisms");
            this.mechanisms = new ArrayList<String>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.mechanisms.add((String) nestedObject);
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("error_code", this.errorCode);
        {
            String[] nestedObjects = new String[mechanisms.size()];
            int i = 0;
            for (String element : this.mechanisms) {
                nestedObjects[i++] = element;
            }
            struct.set("mechanisms", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 2;
        size += 4;
        for (String element : mechanisms) {
            size += 2;
            size += MessageUtil.serializedUtf8Length(element);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SaslHandshakeResponseData)) return false;
        SaslHandshakeResponseData other = (SaslHandshakeResponseData) obj;
        if (errorCode != other.errorCode) return false;
        if (this.mechanisms == null) {
            if (other.mechanisms != null) return false;
        } else {
            if (!this.mechanisms.equals(other.mechanisms)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + errorCode;
        hashCode = 31 * hashCode + (mechanisms == null ? 0 : mechanisms.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "SaslHandshakeResponseData("
            + "errorCode=" + errorCode
            + ", mechanisms=" + MessageUtil.deepToString(mechanisms.iterator())
            + ")";
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public List<String> mechanisms() {
        return this.mechanisms;
    }
    
    public SaslHandshakeResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    public SaslHandshakeResponseData setMechanisms(List<String> v) {
        this.mechanisms = v;
        return this;
    }
}
