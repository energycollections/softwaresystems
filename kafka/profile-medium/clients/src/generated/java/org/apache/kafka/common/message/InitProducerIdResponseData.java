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


public class InitProducerIdResponseData implements ApiMessage {
    private int throttleTimeMs;
    private short errorCode;
    private long producerId;
    private short producerEpoch;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
            new Field("producer_id", Type.INT64, "The current producer id."),
            new Field("producer_epoch", Type.INT16, "The current epoch associated with the producer id.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public InitProducerIdResponseData(Readable readable, short version) {
        read(readable, version);
    }
    
    public InitProducerIdResponseData(Struct struct, short version) {
        fromStruct(struct, version);
    }
    
    public InitProducerIdResponseData() {
        this.throttleTimeMs = 0;
        this.errorCode = (short) 0;
        this.producerId = 0L;
        this.producerEpoch = (short) 0;
    }
    
    @Override
    public short apiKey() {
        return 22;
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
        this.throttleTimeMs = readable.readInt();
        this.errorCode = readable.readShort();
        this.producerId = readable.readLong();
        this.producerEpoch = readable.readShort();
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(throttleTimeMs);
        writable.writeShort(errorCode);
        writable.writeLong(producerId);
        writable.writeShort(producerEpoch);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.throttleTimeMs = struct.getInt("throttle_time_ms");
        this.errorCode = struct.getShort("error_code");
        this.producerId = struct.getLong("producer_id");
        this.producerEpoch = struct.getShort("producer_epoch");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("throttle_time_ms", this.throttleTimeMs);
        struct.set("error_code", this.errorCode);
        struct.set("producer_id", this.producerId);
        struct.set("producer_epoch", this.producerEpoch);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        size += 2;
        size += 8;
        size += 2;
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof InitProducerIdResponseData)) return false;
        InitProducerIdResponseData other = (InitProducerIdResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (errorCode != other.errorCode) return false;
        if (producerId != other.producerId) return false;
        if (producerEpoch != other.producerEpoch) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + errorCode;
        hashCode = 31 * hashCode + ((int) (producerId >> 32) ^ (int) producerId);
        hashCode = 31 * hashCode + producerEpoch;
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "InitProducerIdResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", errorCode=" + errorCode
            + ", producerId=" + producerId
            + ", producerEpoch=" + producerEpoch
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public long producerId() {
        return this.producerId;
    }
    
    public short producerEpoch() {
        return this.producerEpoch;
    }
    
    public InitProducerIdResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public InitProducerIdResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    public InitProducerIdResponseData setProducerId(long v) {
        this.producerId = v;
        return this;
    }
    
    public InitProducerIdResponseData setProducerEpoch(short v) {
        this.producerEpoch = v;
        return this;
    }
}
