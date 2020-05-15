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


public class FindCoordinatorResponseData implements ApiMessage {
    private int throttleTimeMs;
    private short errorCode;
    private String errorMessage;
    private int nodeId;
    private String host;
    private int port;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
            new Field("node_id", Type.INT32, "The node id."),
            new Field("host", Type.STRING, "The host name."),
            new Field("port", Type.INT32, "The port.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
            new Field("error_message", Type.NULLABLE_STRING, "The error message, or null if there was no error."),
            new Field("node_id", Type.INT32, "The node id."),
            new Field("host", Type.STRING, "The host name."),
            new Field("port", Type.INT32, "The port.")
        );
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2
    };
    
    public FindCoordinatorResponseData(Readable readable, short version) {
        read(readable, version);
    }
    
    public FindCoordinatorResponseData(Struct struct, short version) {
        fromStruct(struct, version);
    }
    
    public FindCoordinatorResponseData() {
        this.throttleTimeMs = 0;
        this.errorCode = (short) 0;
        this.errorMessage = "";
        this.nodeId = 0;
        this.host = "";
        this.port = 0;
    }
    
    @Override
    public short apiKey() {
        return 10;
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
        if (version >= 1) {
            this.throttleTimeMs = readable.readInt();
        } else {
            this.throttleTimeMs = 0;
        }
        this.errorCode = readable.readShort();
        if (version >= 1) {
            this.errorMessage = readable.readNullableString();
        } else {
            this.errorMessage = "";
        }
        this.nodeId = readable.readInt();
        this.host = readable.readNullableString();
        this.port = readable.readInt();
    }
    
    @Override
    public void write(Writable writable, short version) {
        if (version >= 1) {
            writable.writeInt(throttleTimeMs);
        }
        writable.writeShort(errorCode);
        if (version >= 1) {
            writable.writeNullableString(errorMessage);
        }
        writable.writeInt(nodeId);
        writable.writeString(host);
        writable.writeInt(port);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        if (version >= 1) {
            this.throttleTimeMs = struct.getInt("throttle_time_ms");
        } else {
            this.throttleTimeMs = 0;
        }
        this.errorCode = struct.getShort("error_code");
        if (version >= 1) {
            this.errorMessage = struct.getString("error_message");
        } else {
            this.errorMessage = "";
        }
        this.nodeId = struct.getInt("node_id");
        this.host = struct.getString("host");
        this.port = struct.getInt("port");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        if (version >= 1) {
            struct.set("throttle_time_ms", this.throttleTimeMs);
        }
        struct.set("error_code", this.errorCode);
        if (version >= 1) {
            struct.set("error_message", this.errorMessage);
        }
        struct.set("node_id", this.nodeId);
        struct.set("host", this.host);
        struct.set("port", this.port);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        if (version >= 1) {
            size += 4;
        }
        size += 2;
        if (version >= 1) {
            size += 2;
            if (errorMessage != null) {
                size += MessageUtil.serializedUtf8Length(errorMessage);
            }
        }
        size += 4;
        size += 2;
        size += MessageUtil.serializedUtf8Length(host);
        size += 4;
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FindCoordinatorResponseData)) return false;
        FindCoordinatorResponseData other = (FindCoordinatorResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (errorCode != other.errorCode) return false;
        if (this.errorMessage == null) {
            if (other.errorMessage != null) return false;
        } else {
            if (!this.errorMessage.equals(other.errorMessage)) return false;
        }
        if (nodeId != other.nodeId) return false;
        if (this.host == null) {
            if (other.host != null) return false;
        } else {
            if (!this.host.equals(other.host)) return false;
        }
        if (port != other.port) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + errorCode;
        hashCode = 31 * hashCode + (errorMessage == null ? 0 : errorMessage.hashCode());
        hashCode = 31 * hashCode + nodeId;
        hashCode = 31 * hashCode + (host == null ? 0 : host.hashCode());
        hashCode = 31 * hashCode + port;
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "FindCoordinatorResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", errorCode=" + errorCode
            + ", errorMessage='" + errorMessage + "'"
            + ", nodeId=" + nodeId
            + ", host='" + host + "'"
            + ", port=" + port
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public String errorMessage() {
        return this.errorMessage;
    }
    
    public int nodeId() {
        return this.nodeId;
    }
    
    public String host() {
        return this.host;
    }
    
    public int port() {
        return this.port;
    }
    
    public FindCoordinatorResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public FindCoordinatorResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    public FindCoordinatorResponseData setErrorMessage(String v) {
        this.errorMessage = v;
        return this;
    }
    
    public FindCoordinatorResponseData setNodeId(int v) {
        this.nodeId = v;
        return this;
    }
    
    public FindCoordinatorResponseData setHost(String v) {
        this.host = v;
        return this;
    }
    
    public FindCoordinatorResponseData setPort(int v) {
        this.port = v;
        return this;
    }
}
