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


public class AddOffsetsToTxnRequestData implements ApiMessage {
    private String transactionalId;
    private long producerId;
    private short producerEpoch;
    private String groupId;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("transactional_id", Type.STRING, "The transactional id corresponding to the transaction."),
            new Field("producer_id", Type.INT64, "Current producer id in use by the transactional id."),
            new Field("producer_epoch", Type.INT16, "Current epoch associated with the producer id."),
            new Field("group_id", Type.STRING, "The unique group identifier.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public AddOffsetsToTxnRequestData(Readable readable, short version) {
        read(readable, version);
    }
    
    public AddOffsetsToTxnRequestData(Struct struct, short version) {
        fromStruct(struct, version);
    }
    
    public AddOffsetsToTxnRequestData() {
        this.transactionalId = "";
        this.producerId = 0L;
        this.producerEpoch = (short) 0;
        this.groupId = "";
    }
    
    @Override
    public short apiKey() {
        return 25;
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
        this.groupId = readable.readNullableString();
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeString(transactionalId);
        writable.writeLong(producerId);
        writable.writeShort(producerEpoch);
        writable.writeString(groupId);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.transactionalId = struct.getString("transactional_id");
        this.producerId = struct.getLong("producer_id");
        this.producerEpoch = struct.getShort("producer_epoch");
        this.groupId = struct.getString("group_id");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("transactional_id", this.transactionalId);
        struct.set("producer_id", this.producerId);
        struct.set("producer_epoch", this.producerEpoch);
        struct.set("group_id", this.groupId);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 2;
        size += MessageUtil.serializedUtf8Length(transactionalId);
        size += 8;
        size += 2;
        size += 2;
        size += MessageUtil.serializedUtf8Length(groupId);
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AddOffsetsToTxnRequestData)) return false;
        AddOffsetsToTxnRequestData other = (AddOffsetsToTxnRequestData) obj;
        if (this.transactionalId == null) {
            if (other.transactionalId != null) return false;
        } else {
            if (!this.transactionalId.equals(other.transactionalId)) return false;
        }
        if (producerId != other.producerId) return false;
        if (producerEpoch != other.producerEpoch) return false;
        if (this.groupId == null) {
            if (other.groupId != null) return false;
        } else {
            if (!this.groupId.equals(other.groupId)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (transactionalId == null ? 0 : transactionalId.hashCode());
        hashCode = 31 * hashCode + ((int) (producerId >> 32) ^ (int) producerId);
        hashCode = 31 * hashCode + producerEpoch;
        hashCode = 31 * hashCode + (groupId == null ? 0 : groupId.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "AddOffsetsToTxnRequestData("
            + "transactionalId='" + transactionalId + "'"
            + ", producerId=" + producerId
            + ", producerEpoch=" + producerEpoch
            + ", groupId='" + groupId + "'"
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
    
    public String groupId() {
        return this.groupId;
    }
    
    public AddOffsetsToTxnRequestData setTransactionalId(String v) {
        this.transactionalId = v;
        return this;
    }
    
    public AddOffsetsToTxnRequestData setProducerId(long v) {
        this.producerId = v;
        return this;
    }
    
    public AddOffsetsToTxnRequestData setProducerEpoch(short v) {
        this.producerEpoch = v;
        return this;
    }
    
    public AddOffsetsToTxnRequestData setGroupId(String v) {
        this.groupId = v;
        return this;
    }
}
