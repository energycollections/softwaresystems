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
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.ApiMessage;
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Struct;
import org.apache.kafka.common.protocol.types.Type;
import org.apache.kafka.common.utils.Bytes;


public class SaslAuthenticateResponseData implements ApiMessage {
    private short errorCode;
    private String errorMessage;
    private byte[] authBytes;
    private long sessionLifetimeMs;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
            new Field("error_message", Type.NULLABLE_STRING, "The error message, or null if there was no error."),
            new Field("auth_bytes", Type.BYTES, "The SASL authentication bytes from the server, as defined by the SASL mechanism.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
            new Field("error_message", Type.NULLABLE_STRING, "The error message, or null if there was no error."),
            new Field("auth_bytes", Type.BYTES, "The SASL authentication bytes from the server, as defined by the SASL mechanism."),
            new Field("session_lifetime_ms", Type.INT64, "The SASL authentication bytes from the server, as defined by the SASL mechanism.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public SaslAuthenticateResponseData(Readable readable, short version) {
        read(readable, version);
    }
    
    public SaslAuthenticateResponseData(Struct struct, short version) {
        fromStruct(struct, version);
    }
    
    public SaslAuthenticateResponseData() {
        this.errorCode = (short) 0;
        this.errorMessage = "";
        this.authBytes = Bytes.EMPTY;
        this.sessionLifetimeMs = 0L;
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
        this.errorCode = readable.readShort();
        this.errorMessage = readable.readNullableString();
        this.authBytes = readable.readNullableBytes();
        if (version >= 1) {
            this.sessionLifetimeMs = readable.readLong();
        } else {
            this.sessionLifetimeMs = 0L;
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeShort(errorCode);
        writable.writeNullableString(errorMessage);
        writable.writeBytes(authBytes);
        if (version >= 1) {
            writable.writeLong(sessionLifetimeMs);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.errorCode = struct.getShort("error_code");
        this.errorMessage = struct.getString("error_message");
        this.authBytes = struct.getByteArray("auth_bytes");
        if (version >= 1) {
            this.sessionLifetimeMs = struct.getLong("session_lifetime_ms");
        } else {
            this.sessionLifetimeMs = 0L;
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("error_code", this.errorCode);
        struct.set("error_message", this.errorMessage);
        struct.setByteArray("auth_bytes", this.authBytes);
        if (version >= 1) {
            struct.set("session_lifetime_ms", this.sessionLifetimeMs);
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
        size += 4;
        size += authBytes.length;
        if (version >= 1) {
            size += 8;
        } else {
            if (sessionLifetimeMs != 0L) {
                throw new UnsupportedVersionException("Attempted to write a non-default sessionLifetimeMs at version " + version);
            }
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SaslAuthenticateResponseData)) return false;
        SaslAuthenticateResponseData other = (SaslAuthenticateResponseData) obj;
        if (errorCode != other.errorCode) return false;
        if (this.errorMessage == null) {
            if (other.errorMessage != null) return false;
        } else {
            if (!this.errorMessage.equals(other.errorMessage)) return false;
        }
        if (!Arrays.equals(this.authBytes, other.authBytes)) return false;
        if (sessionLifetimeMs != other.sessionLifetimeMs) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + errorCode;
        hashCode = 31 * hashCode + (errorMessage == null ? 0 : errorMessage.hashCode());
        hashCode = 31 * hashCode + Arrays.hashCode(authBytes);
        hashCode = 31 * hashCode + ((int) (sessionLifetimeMs >> 32) ^ (int) sessionLifetimeMs);
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "SaslAuthenticateResponseData("
            + "errorCode=" + errorCode
            + ", errorMessage='" + errorMessage + "'"
            + ", authBytes=" + Arrays.toString(authBytes)
            + ", sessionLifetimeMs=" + sessionLifetimeMs
            + ")";
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public String errorMessage() {
        return this.errorMessage;
    }
    
    public byte[] authBytes() {
        return this.authBytes;
    }
    
    public long sessionLifetimeMs() {
        return this.sessionLifetimeMs;
    }
    
    public SaslAuthenticateResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    public SaslAuthenticateResponseData setErrorMessage(String v) {
        this.errorMessage = v;
        return this;
    }
    
    public SaslAuthenticateResponseData setAuthBytes(byte[] v) {
        this.authBytes = v;
        return this;
    }
    
    public SaslAuthenticateResponseData setSessionLifetimeMs(long v) {
        this.sessionLifetimeMs = v;
        return this;
    }
}
