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

import org.apache.kafka.common.protocol.ApiMessage;
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Struct;
import org.apache.kafka.common.protocol.types.Type;


public class SaslHandshakeRequestData implements ApiMessage {
    private String mechanism;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("mechanism", Type.STRING, "The SASL mechanism chosen by the client.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public SaslHandshakeRequestData(Readable readable, short version) {
        read(readable, version);
    }
    
    public SaslHandshakeRequestData(Struct struct, short version) {
        fromStruct(struct, version);
    }
    
    public SaslHandshakeRequestData() {
        this.mechanism = "";
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
        this.mechanism = readable.readNullableString();
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeString(mechanism);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.mechanism = struct.getString("mechanism");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("mechanism", this.mechanism);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 2;
        size += MessageUtil.serializedUtf8Length(mechanism);
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SaslHandshakeRequestData)) return false;
        SaslHandshakeRequestData other = (SaslHandshakeRequestData) obj;
        if (this.mechanism == null) {
            if (other.mechanism != null) return false;
        } else {
            if (!this.mechanism.equals(other.mechanism)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (mechanism == null ? 0 : mechanism.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "SaslHandshakeRequestData("
            + "mechanism='" + mechanism + "'"
            + ")";
    }
    
    public String mechanism() {
        return this.mechanism;
    }
    
    public SaslHandshakeRequestData setMechanism(String v) {
        this.mechanism = v;
        return this;
    }
}
