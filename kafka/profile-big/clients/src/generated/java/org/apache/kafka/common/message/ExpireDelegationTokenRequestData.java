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


public class ExpireDelegationTokenRequestData implements ApiMessage {
    private byte[] hmac;
    private long expiryTimePeriodMs;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("hmac", Type.BYTES, "The HMAC of the delegation token to be expired."),
            new Field("expiry_time_period_ms", Type.INT64, "The expiry time period in milliseconds.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public ExpireDelegationTokenRequestData(Readable readable, short version) {
        read(readable, version);
    }
    
    public ExpireDelegationTokenRequestData(Struct struct, short version) {
        fromStruct(struct, version);
    }
    
    public ExpireDelegationTokenRequestData() {
        this.hmac = Bytes.EMPTY;
        this.expiryTimePeriodMs = 0L;
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
        this.hmac = readable.readNullableBytes();
        this.expiryTimePeriodMs = readable.readLong();
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeBytes(hmac);
        writable.writeLong(expiryTimePeriodMs);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.hmac = struct.getByteArray("hmac");
        this.expiryTimePeriodMs = struct.getLong("expiry_time_period_ms");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.setByteArray("hmac", this.hmac);
        struct.set("expiry_time_period_ms", this.expiryTimePeriodMs);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        size += hmac.length;
        size += 8;
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ExpireDelegationTokenRequestData)) return false;
        ExpireDelegationTokenRequestData other = (ExpireDelegationTokenRequestData) obj;
        if (!Arrays.equals(this.hmac, other.hmac)) return false;
        if (expiryTimePeriodMs != other.expiryTimePeriodMs) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + Arrays.hashCode(hmac);
        hashCode = 31 * hashCode + ((int) (expiryTimePeriodMs >> 32) ^ (int) expiryTimePeriodMs);
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "ExpireDelegationTokenRequestData("
            + "hmac=" + Arrays.toString(hmac)
            + ", expiryTimePeriodMs=" + expiryTimePeriodMs
            + ")";
    }
    
    public byte[] hmac() {
        return this.hmac;
    }
    
    public long expiryTimePeriodMs() {
        return this.expiryTimePeriodMs;
    }
    
    public ExpireDelegationTokenRequestData setHmac(byte[] v) {
        this.hmac = v;
        return this;
    }
    
    public ExpireDelegationTokenRequestData setExpiryTimePeriodMs(long v) {
        this.expiryTimePeriodMs = v;
        return this;
    }
}
