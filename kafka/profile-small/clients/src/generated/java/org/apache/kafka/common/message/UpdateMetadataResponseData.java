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


public class UpdateMetadataResponseData implements ApiMessage {
    private short errorCode;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema SCHEMA_4 = SCHEMA_3;
    
    public static final Schema SCHEMA_5 = SCHEMA_4;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3,
        SCHEMA_4,
        SCHEMA_5
    };
    
    public UpdateMetadataResponseData(Readable readable, short version) {
        read(readable, version);
    }
    
    public UpdateMetadataResponseData(Struct struct, short version) {
        fromStruct(struct, version);
    }
    
    public UpdateMetadataResponseData() {
        this.errorCode = (short) 0;
    }
    
    @Override
    public short apiKey() {
        return 6;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 5;
    }
    
    @Override
    public void read(Readable readable, short version) {
        this.errorCode = readable.readShort();
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeShort(errorCode);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.errorCode = struct.getShort("error_code");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("error_code", this.errorCode);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 2;
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UpdateMetadataResponseData)) return false;
        UpdateMetadataResponseData other = (UpdateMetadataResponseData) obj;
        if (errorCode != other.errorCode) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + errorCode;
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "UpdateMetadataResponseData("
            + "errorCode=" + errorCode
            + ")";
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public UpdateMetadataResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
}
