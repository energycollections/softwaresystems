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


public class ResponseHeaderData implements ApiMessage {
    private int correlationId;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("correlation_id", Type.INT32, "The correlation ID of this response.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0
    };
    
    public ResponseHeaderData(Readable readable, short version) {
        read(readable, version);
    }
    
    public ResponseHeaderData(Struct struct, short version) {
        fromStruct(struct, version);
    }
    
    public ResponseHeaderData() {
        this.correlationId = 0;
    }
    
    @Override
    public short apiKey() {
        return -1;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 0;
    }
    
    @Override
    public void read(Readable readable, short version) {
        this.correlationId = readable.readInt();
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(correlationId);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.correlationId = struct.getInt("correlation_id");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("correlation_id", this.correlationId);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ResponseHeaderData)) return false;
        ResponseHeaderData other = (ResponseHeaderData) obj;
        if (correlationId != other.correlationId) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + correlationId;
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "ResponseHeaderData("
            + "correlationId=" + correlationId
            + ")";
    }
    
    public int correlationId() {
        return this.correlationId;
    }
    
    public ResponseHeaderData setCorrelationId(int v) {
        this.correlationId = v;
        return this;
    }
}
