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


public class ControlledShutdownRequestData implements ApiMessage {
    private int brokerId;
    private long brokerEpoch;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("broker_id", Type.INT32, "The id of the broker for which controlled shutdown has been requested.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("broker_id", Type.INT32, "The id of the broker for which controlled shutdown has been requested."),
            new Field("broker_epoch", Type.INT64, "The broker epoch.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2
    };
    
    public ControlledShutdownRequestData(Readable readable, short version) {
        read(readable, version);
    }
    
    public ControlledShutdownRequestData(Struct struct, short version) {
        fromStruct(struct, version);
    }
    
    public ControlledShutdownRequestData() {
        this.brokerId = 0;
        this.brokerEpoch = -1L;
    }
    
    @Override
    public short apiKey() {
        return 7;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 2;
    }
    
    @Override
    public void read(Readable readable, short version) {
        this.brokerId = readable.readInt();
        if (version >= 2) {
            this.brokerEpoch = readable.readLong();
        } else {
            this.brokerEpoch = -1L;
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(brokerId);
        if (version >= 2) {
            writable.writeLong(brokerEpoch);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.brokerId = struct.getInt("broker_id");
        if (version >= 2) {
            this.brokerEpoch = struct.getLong("broker_epoch");
        } else {
            this.brokerEpoch = -1L;
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("broker_id", this.brokerId);
        if (version >= 2) {
            struct.set("broker_epoch", this.brokerEpoch);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        if (version >= 2) {
            size += 8;
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ControlledShutdownRequestData)) return false;
        ControlledShutdownRequestData other = (ControlledShutdownRequestData) obj;
        if (brokerId != other.brokerId) return false;
        if (brokerEpoch != other.brokerEpoch) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + brokerId;
        hashCode = 31 * hashCode + ((int) (brokerEpoch >> 32) ^ (int) brokerEpoch);
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "ControlledShutdownRequestData("
            + "brokerId=" + brokerId
            + ", brokerEpoch=" + brokerEpoch
            + ")";
    }
    
    public int brokerId() {
        return this.brokerId;
    }
    
    public long brokerEpoch() {
        return this.brokerEpoch;
    }
    
    public ControlledShutdownRequestData setBrokerId(int v) {
        this.brokerId = v;
        return this;
    }
    
    public ControlledShutdownRequestData setBrokerEpoch(long v) {
        this.brokerEpoch = v;
        return this;
    }
}
