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
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Struct;
import org.apache.kafka.common.protocol.types.Type;


public class ExpireDelegationTokenResponseData implements ApiMessage {
    private short errorCode;
    private long expiryTimestampMs;
    private int throttleTimeMs;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
            new Field("expiry_timestamp_ms", Type.INT64, "The timestamp in milliseconds at which this token expires."),
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public ExpireDelegationTokenResponseData(Readable readable, short version) {
        read(readable, version);
    }
    
    public ExpireDelegationTokenResponseData(Struct struct, short version) {
        fromStruct(struct, version);
    }
    
    public ExpireDelegationTokenResponseData() {
        this.errorCode = (short) 0;
        this.expiryTimestampMs = 0L;
        this.throttleTimeMs = 0;
    }
    
    @Override
    public short apiKey() {
        return 40;
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
        this.expiryTimestampMs = readable.readLong();
        this.throttleTimeMs = readable.readInt();
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeShort(errorCode);
        writable.writeLong(expiryTimestampMs);
        writable.writeInt(throttleTimeMs);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.errorCode = struct.getShort("error_code");
        this.expiryTimestampMs = struct.getLong("expiry_timestamp_ms");
        this.throttleTimeMs = struct.getInt("throttle_time_ms");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("error_code", this.errorCode);
        struct.set("expiry_timestamp_ms", this.expiryTimestampMs);
        struct.set("throttle_time_ms", this.throttleTimeMs);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 2;
        size += 8;
        size += 4;
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ExpireDelegationTokenResponseData)) return false;
        ExpireDelegationTokenResponseData other = (ExpireDelegationTokenResponseData) obj;
        if (errorCode != other.errorCode) return false;
        if (expiryTimestampMs != other.expiryTimestampMs) return false;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + errorCode;
        hashCode = 31 * hashCode + ((int) (expiryTimestampMs >> 32) ^ (int) expiryTimestampMs);
        hashCode = 31 * hashCode + throttleTimeMs;
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "ExpireDelegationTokenResponseData("
            + "errorCode=" + errorCode
            + ", expiryTimestampMs=" + expiryTimestampMs
            + ", throttleTimeMs=" + throttleTimeMs
            + ")";
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public long expiryTimestampMs() {
        return this.expiryTimestampMs;
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public ExpireDelegationTokenResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    public ExpireDelegationTokenResponseData setExpiryTimestampMs(long v) {
        this.expiryTimestampMs = v;
        return this;
    }
    
    public ExpireDelegationTokenResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
}
