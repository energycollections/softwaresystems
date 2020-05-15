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

import java.util.Arrays;
import org.apache.kafka.common.protocol.ApiMessage;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Struct;
import org.apache.kafka.common.protocol.types.Type;
import org.apache.kafka.common.utils.Bytes;


public class SaslAuthenticateRequestData implements ApiMessage {
    private byte[] authBytes;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("auth_bytes", Type.BYTES, "The SASL authentication bytes from the client, as defined by the SASL mechanism.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public SaslAuthenticateRequestData(Readable readable, short version) {
        read(readable, version);
    }
    
    public SaslAuthenticateRequestData(Struct struct, short version) {
        fromStruct(struct, version);
    }
    
    public SaslAuthenticateRequestData() {
        this.authBytes = Bytes.EMPTY;
    }
    
    @Override
    public short apiKey() {
        return 36;
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
        this.authBytes = readable.readNullableBytes();
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeBytes(authBytes);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.authBytes = struct.getByteArray("auth_bytes");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.setByteArray("auth_bytes", this.authBytes);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        size += authBytes.length;
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SaslAuthenticateRequestData)) return false;
        SaslAuthenticateRequestData other = (SaslAuthenticateRequestData) obj;
        if (!Arrays.equals(this.authBytes, other.authBytes)) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + Arrays.hashCode(authBytes);
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "SaslAuthenticateRequestData("
            + "authBytes=" + Arrays.toString(authBytes)
            + ")";
    }
    
    public byte[] authBytes() {
        return this.authBytes;
    }
    
    public SaslAuthenticateRequestData setAuthBytes(byte[] v) {
        this.authBytes = v;
        return this;
    }
}
