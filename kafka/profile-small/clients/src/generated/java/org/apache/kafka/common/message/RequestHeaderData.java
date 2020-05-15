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


public class RequestHeaderData implements ApiMessage {
    private short requestApiKey;
    private short requestApiVersion;
    private int correlationId;
    private String clientId;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("request_api_key", Type.INT16, "The API key of this request."),
            new Field("request_api_version", Type.INT16, "The API version of this request."),
            new Field("correlation_id", Type.INT32, "The correlation ID of this request."),
            new Field("client_id", Type.STRING, "The client ID string.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0
    };
    
    public RequestHeaderData(Readable readable, short version) {
        read(readable, version);
    }
    
    public RequestHeaderData(Struct struct, short version) {
        fromStruct(struct, version);
    }
    
    public RequestHeaderData() {
        this.requestApiKey = (short) 0;
        this.requestApiVersion = (short) 0;
        this.correlationId = 0;
        this.clientId = "";
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
        this.requestApiKey = readable.readShort();
        this.requestApiVersion = readable.readShort();
        this.correlationId = readable.readInt();
        this.clientId = readable.readNullableString();
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeShort(requestApiKey);
        writable.writeShort(requestApiVersion);
        writable.writeInt(correlationId);
        writable.writeString(clientId);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.requestApiKey = struct.getShort("request_api_key");
        this.requestApiVersion = struct.getShort("request_api_version");
        this.correlationId = struct.getInt("correlation_id");
        this.clientId = struct.getString("client_id");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("request_api_key", this.requestApiKey);
        struct.set("request_api_version", this.requestApiVersion);
        struct.set("correlation_id", this.correlationId);
        struct.set("client_id", this.clientId);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 2;
        size += 2;
        size += 4;
        size += 2;
        size += MessageUtil.serializedUtf8Length(clientId);
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RequestHeaderData)) return false;
        RequestHeaderData other = (RequestHeaderData) obj;
        if (requestApiKey != other.requestApiKey) return false;
        if (requestApiVersion != other.requestApiVersion) return false;
        if (correlationId != other.correlationId) return false;
        if (this.clientId == null) {
            if (other.clientId != null) return false;
        } else {
            if (!this.clientId.equals(other.clientId)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + requestApiKey;
        hashCode = 31 * hashCode + requestApiVersion;
        hashCode = 31 * hashCode + correlationId;
        hashCode = 31 * hashCode + (clientId == null ? 0 : clientId.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "RequestHeaderData("
            + "requestApiKey=" + requestApiKey
            + ", requestApiVersion=" + requestApiVersion
            + ", correlationId=" + correlationId
            + ", clientId='" + clientId + "'"
            + ")";
    }
    
    public short requestApiKey() {
        return this.requestApiKey;
    }
    
    public short requestApiVersion() {
        return this.requestApiVersion;
    }
    
    public int correlationId() {
        return this.correlationId;
    }
    
    public String clientId() {
        return this.clientId;
    }
    
    public RequestHeaderData setRequestApiKey(short v) {
        this.requestApiKey = v;
        return this;
    }
    
    public RequestHeaderData setRequestApiVersion(short v) {
        this.requestApiVersion = v;
        return this;
    }
    
    public RequestHeaderData setCorrelationId(int v) {
        this.correlationId = v;
        return this;
    }
    
    public RequestHeaderData setClientId(String v) {
        this.clientId = v;
        return this;
    }
}
