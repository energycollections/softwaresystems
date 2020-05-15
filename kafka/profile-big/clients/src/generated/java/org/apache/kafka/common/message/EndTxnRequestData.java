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


public class EndTxnRequestData implements ApiMessage {
    private String transactionalId;
    private long producerId;
    private short producerEpoch;
    private boolean committed;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("transactional_id", Type.STRING, "The ID of the transaction to end."),
            new Field("producer_id", Type.INT64, "The producer ID."),
            new Field("producer_epoch", Type.INT16, "The current epoch associated with the producer."),
            new Field("committed", Type.BOOLEAN, "True if the transaction was committed, false if it was aborted.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public EndTxnRequestData(Readable readable, short version) {
        read(readable, version);
    }
    
    public EndTxnRequestData(Struct struct, short version) {
        fromStruct(struct, version);
    }
    
    public EndTxnRequestData() {
        this.transactionalId = "";
        this.producerId = 0L;
        this.producerEpoch = (short) 0;
        this.committed = false;
    }
    
    @Override
    public short apiKey() {
        return 26;
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
        this.producerId = readable.readLong();
        this.producerEpoch = readable.readShort();
        this.committed = readable.readByte() != 0;
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeString(transactionalId);
        writable.writeLong(producerId);
        writable.writeShort(producerEpoch);
        writable.writeByte(committed ? (byte) 1 : (byte) 0);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.transactionalId = struct.getString("transactional_id");
        this.producerId = struct.getLong("producer_id");
        this.producerEpoch = struct.getShort("producer_epoch");
        this.committed = struct.getBoolean("committed");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("transactional_id", this.transactionalId);
        struct.set("producer_id", this.producerId);
        struct.set("producer_epoch", this.producerEpoch);
        struct.set("committed", this.committed);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 2;
        size += MessageUtil.serializedUtf8Length(transactionalId);
        size += 8;
        size += 2;
        size += 1;
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EndTxnRequestData)) return false;
        EndTxnRequestData other = (EndTxnRequestData) obj;
        if (this.transactionalId == null) {
            if (other.transactionalId != null) return false;
        } else {
            if (!this.transactionalId.equals(other.transactionalId)) return false;
        }
        if (producerId != other.producerId) return false;
        if (producerEpoch != other.producerEpoch) return false;
        if (committed != other.committed) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (transactionalId == null ? 0 : transactionalId.hashCode());
        hashCode = 31 * hashCode + ((int) (producerId >> 32) ^ (int) producerId);
        hashCode = 31 * hashCode + producerEpoch;
        hashCode = 31 * hashCode + (committed ? 1231 : 1237);
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "EndTxnRequestData("
            + "transactionalId='" + transactionalId + "'"
            + ", producerId=" + producerId
            + ", producerEpoch=" + producerEpoch
            + ", committed=" + (committed ? "true" : "false")
            + ")";
    }
    
    public String transactionalId() {
        return this.transactionalId;
    }
    
    public long producerId() {
        return this.producerId;
    }
    
    public short producerEpoch() {
        return this.producerEpoch;
    }
    
    public boolean committed() {
        return this.committed;
    }
    
    public EndTxnRequestData setTransactionalId(String v) {
        this.transactionalId = v;
        return this;
    }
    
    public EndTxnRequestData setProducerId(long v) {
        this.producerId = v;
        return this;
    }
    
    public EndTxnRequestData setProducerEpoch(short v) {
        this.producerEpoch = v;
        return this;
    }
    
    public EndTxnRequestData setCommitted(boolean v) {
        this.committed = v;
        return this;
    }
}
