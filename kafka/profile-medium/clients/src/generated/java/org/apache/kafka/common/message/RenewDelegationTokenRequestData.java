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


public class RenewDelegationTokenRequestData implements ApiMessage {
    private byte[] hmac;
    private long renewPeriodMs;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("hmac", Type.BYTES, "The HMAC of the delegation token to be renewed."),
            new Field("renew_period_ms", Type.INT64, "The renewal time period in milliseconds.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public RenewDelegationTokenRequestData(Readable readable, short version) {
        read(readable, version);
    }
    
    public RenewDelegationTokenRequestData(Struct struct, short version) {
        fromStruct(struct, version);
    }
    
    public RenewDelegationTokenRequestData() {
        this.hmac = Bytes.EMPTY;
        this.renewPeriodMs = 0L;
    }
    
    @Override
    public short apiKey() {
        return 39;
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
        this.renewPeriodMs = readable.readLong();
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeBytes(hmac);
        writable.writeLong(renewPeriodMs);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.hmac = struct.getByteArray("hmac");
        this.renewPeriodMs = struct.getLong("renew_period_ms");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.setByteArray("hmac", this.hmac);
        struct.set("renew_period_ms", this.renewPeriodMs);
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
        if (!(obj instanceof RenewDelegationTokenRequestData)) return false;
        RenewDelegationTokenRequestData other = (RenewDelegationTokenRequestData) obj;
        if (!Arrays.equals(this.hmac, other.hmac)) return false;
        if (renewPeriodMs != other.renewPeriodMs) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + Arrays.hashCode(hmac);
        hashCode = 31 * hashCode + ((int) (renewPeriodMs >> 32) ^ (int) renewPeriodMs);
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "RenewDelegationTokenRequestData("
            + "hmac=" + Arrays.toString(hmac)
            + ", renewPeriodMs=" + renewPeriodMs
            + ")";
    }
    
    public byte[] hmac() {
        return this.hmac;
    }
    
    public long renewPeriodMs() {
        return this.renewPeriodMs;
    }
    
    public RenewDelegationTokenRequestData setHmac(byte[] v) {
        this.hmac = v;
        return this;
    }
    
    public RenewDelegationTokenRequestData setRenewPeriodMs(long v) {
        this.renewPeriodMs = v;
        return this;
    }
}
