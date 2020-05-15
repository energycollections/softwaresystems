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


public class InitProducerIdRequestData implements ApiMessage {
    private String transactionalId;
    private int transactionTimeoutMs;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("transactional_id", Type.NULLABLE_STRING, "The transactional id, or null if the producer is not transactional."),
            new Field("transaction_timeout_ms", Type.INT32, "The time in ms to wait for before aborting idle transactions sent by this producer.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public InitProducerIdRequestData(Readable readable, short version) {
        read(readable, version);
    }
    
    public InitProducerIdRequestData(Struct struct, short version) {
        fromStruct(struct, version);
    }
    
    public InitProducerIdRequestData() {
        this.transactionalId = "";
        this.transactionTimeoutMs = 0;
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
        this.transactionalId = readable.readNullableString();
        this.transactionTimeoutMs = readable.readInt();
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeNullableString(transactionalId);
        writable.writeInt(transactionTimeoutMs);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.transactionalId = struct.getString("transactional_id");
        this.transactionTimeoutMs = struct.getInt("transaction_timeout_ms");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("transactional_id", this.transactionalId);
        struct.set("transaction_timeout_ms", this.transactionTimeoutMs);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 2;
        if (transactionalId != null) {
            size += MessageUtil.serializedUtf8Length(transactionalId);
        }
        size += 4;
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof InitProducerIdRequestData)) return false;
        InitProducerIdRequestData other = (InitProducerIdRequestData) obj;
        if (this.transactionalId == null) {
            if (other.transactionalId != null) return false;
        } else {
            if (!this.transactionalId.equals(other.transactionalId)) return false;
        }
        if (transactionTimeoutMs != other.transactionTimeoutMs) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (transactionalId == null ? 0 : transactionalId.hashCode());
        hashCode = 31 * hashCode + transactionTimeoutMs;
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "InitProducerIdRequestData("
            + "transactionalId='" + transactionalId + "'"
            + ", transactionTimeoutMs=" + transactionTimeoutMs
            + ")";
    }
    
    public String transactionalId() {
        return this.transactionalId;
    }
    
    public int transactionTimeoutMs() {
        return this.transactionTimeoutMs;
    }
    
    public InitProducerIdRequestData setTransactionalId(String v) {
        this.transactionalId = v;
        return this;
    }
    
    public InitProducerIdRequestData setTransactionTimeoutMs(int v) {
        this.transactionTimeoutMs = v;
        return this;
    }
}
