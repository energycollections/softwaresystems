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
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Struct;
import org.apache.kafka.common.protocol.types.Type;
import org.apache.kafka.common.utils.Bytes;


public class CreateDelegationTokenResponseData implements ApiMessage {
    private short errorCode;
    private String principalType;
    private String principalName;
    private long issueTimestampMs;
    private long expiryTimestampMs;
    private long maxTimestampMs;
    private String tokenId;
    private byte[] hmac;
    private int throttleTimeMs;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("error_code", Type.INT16, "The top-level error, or zero if there was no error."),
            new Field("principal_type", Type.STRING, "The principal type of the token owner."),
            new Field("principal_name", Type.STRING, "The name of the token owner."),
            new Field("issue_timestamp_ms", Type.INT64, "When this token was generated."),
            new Field("expiry_timestamp_ms", Type.INT64, "When this token expires."),
            new Field("max_timestamp_ms", Type.INT64, "The maximum lifetime of this token."),
            new Field("token_id", Type.STRING, "The token UUID."),
            new Field("hmac", Type.BYTES, "HMAC of the delegation token."),
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public CreateDelegationTokenResponseData(Readable readable, short version) {
        read(readable, version);
    }
    
    public CreateDelegationTokenResponseData(Struct struct, short version) {
        fromStruct(struct, version);
    }
    
    public CreateDelegationTokenResponseData() {
        this.errorCode = (short) 0;
        this.principalType = "";
        this.principalName = "";
        this.issueTimestampMs = 0L;
        this.expiryTimestampMs = 0L;
        this.maxTimestampMs = 0L;
        this.tokenId = "";
        this.hmac = Bytes.EMPTY;
        this.throttleTimeMs = 0;
    }
    
    @Override
    public short apiKey() {
        return 38;
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
        this.errorCode = readable.readShort();
        this.principalType = readable.readNullableString();
        this.principalName = readable.readNullableString();
        this.issueTimestampMs = readable.readLong();
        this.expiryTimestampMs = readable.readLong();
        this.maxTimestampMs = readable.readLong();
        this.tokenId = readable.readNullableString();
        this.hmac = readable.readNullableBytes();
        this.throttleTimeMs = readable.readInt();
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeShort(errorCode);
        writable.writeString(principalType);
        writable.writeString(principalName);
        writable.writeLong(issueTimestampMs);
        writable.writeLong(expiryTimestampMs);
        writable.writeLong(maxTimestampMs);
        writable.writeString(tokenId);
        writable.writeBytes(hmac);
        writable.writeInt(throttleTimeMs);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.errorCode = struct.getShort("error_code");
        this.principalType = struct.getString("principal_type");
        this.principalName = struct.getString("principal_name");
        this.issueTimestampMs = struct.getLong("issue_timestamp_ms");
        this.expiryTimestampMs = struct.getLong("expiry_timestamp_ms");
        this.maxTimestampMs = struct.getLong("max_timestamp_ms");
        this.tokenId = struct.getString("token_id");
        this.hmac = struct.getByteArray("hmac");
        this.throttleTimeMs = struct.getInt("throttle_time_ms");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("error_code", this.errorCode);
        struct.set("principal_type", this.principalType);
        struct.set("principal_name", this.principalName);
        struct.set("issue_timestamp_ms", this.issueTimestampMs);
        struct.set("expiry_timestamp_ms", this.expiryTimestampMs);
        struct.set("max_timestamp_ms", this.maxTimestampMs);
        struct.set("token_id", this.tokenId);
        struct.setByteArray("hmac", this.hmac);
        struct.set("throttle_time_ms", this.throttleTimeMs);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 2;
        size += 2;
        size += MessageUtil.serializedUtf8Length(principalType);
        size += 2;
        size += MessageUtil.serializedUtf8Length(principalName);
        size += 8;
        size += 8;
        size += 8;
        size += 2;
        size += MessageUtil.serializedUtf8Length(tokenId);
        size += 4;
        size += hmac.length;
        size += 4;
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CreateDelegationTokenResponseData)) return false;
        CreateDelegationTokenResponseData other = (CreateDelegationTokenResponseData) obj;
        if (errorCode != other.errorCode) return false;
        if (this.principalType == null) {
            if (other.principalType != null) return false;
        } else {
            if (!this.principalType.equals(other.principalType)) return false;
        }
        if (this.principalName == null) {
            if (other.principalName != null) return false;
        } else {
            if (!this.principalName.equals(other.principalName)) return false;
        }
        if (issueTimestampMs != other.issueTimestampMs) return false;
        if (expiryTimestampMs != other.expiryTimestampMs) return false;
        if (maxTimestampMs != other.maxTimestampMs) return false;
        if (this.tokenId == null) {
            if (other.tokenId != null) return false;
        } else {
            if (!this.tokenId.equals(other.tokenId)) return false;
        }
        if (!Arrays.equals(this.hmac, other.hmac)) return false;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + errorCode;
        hashCode = 31 * hashCode + (principalType == null ? 0 : principalType.hashCode());
        hashCode = 31 * hashCode + (principalName == null ? 0 : principalName.hashCode());
        hashCode = 31 * hashCode + ((int) (issueTimestampMs >> 32) ^ (int) issueTimestampMs);
        hashCode = 31 * hashCode + ((int) (expiryTimestampMs >> 32) ^ (int) expiryTimestampMs);
        hashCode = 31 * hashCode + ((int) (maxTimestampMs >> 32) ^ (int) maxTimestampMs);
        hashCode = 31 * hashCode + (tokenId == null ? 0 : tokenId.hashCode());
        hashCode = 31 * hashCode + Arrays.hashCode(hmac);
        hashCode = 31 * hashCode + throttleTimeMs;
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "CreateDelegationTokenResponseData("
            + "errorCode=" + errorCode
            + ", principalType='" + principalType + "'"
            + ", principalName='" + principalName + "'"
            + ", issueTimestampMs=" + issueTimestampMs
            + ", expiryTimestampMs=" + expiryTimestampMs
            + ", maxTimestampMs=" + maxTimestampMs
            + ", tokenId='" + tokenId + "'"
            + ", hmac=" + Arrays.toString(hmac)
            + ", throttleTimeMs=" + throttleTimeMs
            + ")";
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public String principalType() {
        return this.principalType;
    }
    
    public String principalName() {
        return this.principalName;
    }
    
    public long issueTimestampMs() {
        return this.issueTimestampMs;
    }
    
    public long expiryTimestampMs() {
        return this.expiryTimestampMs;
    }
    
    public long maxTimestampMs() {
        return this.maxTimestampMs;
    }
    
    public String tokenId() {
        return this.tokenId;
    }
    
    public byte[] hmac() {
        return this.hmac;
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public CreateDelegationTokenResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    public CreateDelegationTokenResponseData setPrincipalType(String v) {
        this.principalType = v;
        return this;
    }
    
    public CreateDelegationTokenResponseData setPrincipalName(String v) {
        this.principalName = v;
        return this;
    }
    
    public CreateDelegationTokenResponseData setIssueTimestampMs(long v) {
        this.issueTimestampMs = v;
        return this;
    }
    
    public CreateDelegationTokenResponseData setExpiryTimestampMs(long v) {
        this.expiryTimestampMs = v;
        return this;
    }
    
    public CreateDelegationTokenResponseData setMaxTimestampMs(long v) {
        this.maxTimestampMs = v;
        return this;
    }
    
    public CreateDelegationTokenResponseData setTokenId(String v) {
        this.tokenId = v;
        return this;
    }
    
    public CreateDelegationTokenResponseData setHmac(byte[] v) {
        this.hmac = v;
        return this;
    }
    
    public CreateDelegationTokenResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
}
