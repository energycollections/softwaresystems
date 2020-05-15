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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.kafka.common.protocol.ApiMessage;
import org.apache.kafka.common.protocol.Message;
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.ArrayOf;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Struct;
import org.apache.kafka.common.protocol.types.Type;
import org.apache.kafka.common.utils.Bytes;


public class DescribeDelegationTokenResponseData implements ApiMessage {
    private short errorCode;
    private List<DescribedDelegationToken> tokens;
    private int throttleTimeMs;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
            new Field("tokens", new ArrayOf(DescribedDelegationToken.SCHEMA_0), "The tokens."),
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public DescribeDelegationTokenResponseData(Readable readable, short version) {
        this.tokens = new ArrayList<DescribedDelegationToken>();
        read(readable, version);
    }
    
    public DescribeDelegationTokenResponseData(Struct struct, short version) {
        this.tokens = new ArrayList<DescribedDelegationToken>();
        fromStruct(struct, version);
    }
    
    public DescribeDelegationTokenResponseData() {
        this.errorCode = (short) 0;
        this.tokens = new ArrayList<DescribedDelegationToken>();
        this.throttleTimeMs = 0;
    }
    
    @Override
    public short apiKey() {
        return 41;
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
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.tokens.clear();
            } else {
                this.tokens.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.tokens.add(new DescribedDelegationToken(readable, version));
                }
            }
        }
        this.throttleTimeMs = readable.readInt();
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeShort(errorCode);
        writable.writeInt(tokens.size());
        for (DescribedDelegationToken element : tokens) {
            element.write(writable, version);
        }
        writable.writeInt(throttleTimeMs);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.errorCode = struct.getShort("error_code");
        {
            Object[] nestedObjects = struct.getArray("tokens");
            this.tokens = new ArrayList<DescribedDelegationToken>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.tokens.add(new DescribedDelegationToken((Struct) nestedObject, version));
            }
        }
        this.throttleTimeMs = struct.getInt("throttle_time_ms");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("error_code", this.errorCode);
        {
            Struct[] nestedObjects = new Struct[tokens.size()];
            int i = 0;
            for (DescribedDelegationToken element : this.tokens) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("tokens", (Object[]) nestedObjects);
        }
        struct.set("throttle_time_ms", this.throttleTimeMs);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 2;
        size += 4;
        for (DescribedDelegationToken element : tokens) {
            size += element.size(version);
        }
        size += 4;
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DescribeDelegationTokenResponseData)) return false;
        DescribeDelegationTokenResponseData other = (DescribeDelegationTokenResponseData) obj;
        if (errorCode != other.errorCode) return false;
        if (this.tokens == null) {
            if (other.tokens != null) return false;
        } else {
            if (!this.tokens.equals(other.tokens)) return false;
        }
        if (throttleTimeMs != other.throttleTimeMs) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + errorCode;
        hashCode = 31 * hashCode + (tokens == null ? 0 : tokens.hashCode());
        hashCode = 31 * hashCode + throttleTimeMs;
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "DescribeDelegationTokenResponseData("
            + "errorCode=" + errorCode
            + ", tokens=" + MessageUtil.deepToString(tokens.iterator())
            + ", throttleTimeMs=" + throttleTimeMs
            + ")";
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public List<DescribedDelegationToken> tokens() {
        return this.tokens;
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public DescribeDelegationTokenResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    public DescribeDelegationTokenResponseData setTokens(List<DescribedDelegationToken> v) {
        this.tokens = v;
        return this;
    }
    
    public DescribeDelegationTokenResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    static public class DescribedDelegationToken implements Message {
        private String principalType;
        private String principalName;
        private long issueTimestamp;
        private long expiryTimestamp;
        private long maxTimestamp;
        private String tokenId;
        private byte[] hmac;
        private List<DescribedDelegationTokenRenewer> renewers;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("principal_type", Type.STRING, "The token principal type."),
                new Field("principal_name", Type.STRING, "The token principal name."),
                new Field("issue_timestamp", Type.INT64, "The token issue timestamp in milliseconds."),
                new Field("expiry_timestamp", Type.INT64, "The token expiry timestamp in milliseconds."),
                new Field("max_timestamp", Type.INT64, "The token maximum timestamp length in milliseconds."),
                new Field("token_id", Type.STRING, "The token ID."),
                new Field("hmac", Type.BYTES, "The token HMAC."),
                new Field("renewers", new ArrayOf(DescribedDelegationTokenRenewer.SCHEMA_0), "Those who are able to renew this token before it expires.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public DescribedDelegationToken(Readable readable, short version) {
            this.renewers = new ArrayList<DescribedDelegationTokenRenewer>();
            read(readable, version);
        }
        
        public DescribedDelegationToken(Struct struct, short version) {
            this.renewers = new ArrayList<DescribedDelegationTokenRenewer>();
            fromStruct(struct, version);
        }
        
        public DescribedDelegationToken() {
            this.principalType = "";
            this.principalName = "";
            this.issueTimestamp = 0L;
            this.expiryTimestamp = 0L;
            this.maxTimestamp = 0L;
            this.tokenId = "";
            this.hmac = Bytes.EMPTY;
            this.renewers = new ArrayList<DescribedDelegationTokenRenewer>();
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
            this.principalType = readable.readNullableString();
            this.principalName = readable.readNullableString();
            this.issueTimestamp = readable.readLong();
            this.expiryTimestamp = readable.readLong();
            this.maxTimestamp = readable.readLong();
            this.tokenId = readable.readNullableString();
            this.hmac = readable.readNullableBytes();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.renewers.clear();
                } else {
                    this.renewers.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.renewers.add(new DescribedDelegationTokenRenewer(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(principalType);
            writable.writeString(principalName);
            writable.writeLong(issueTimestamp);
            writable.writeLong(expiryTimestamp);
            writable.writeLong(maxTimestamp);
            writable.writeString(tokenId);
            writable.writeBytes(hmac);
            writable.writeInt(renewers.size());
            for (DescribedDelegationTokenRenewer element : renewers) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.principalType = struct.getString("principal_type");
            this.principalName = struct.getString("principal_name");
            this.issueTimestamp = struct.getLong("issue_timestamp");
            this.expiryTimestamp = struct.getLong("expiry_timestamp");
            this.maxTimestamp = struct.getLong("max_timestamp");
            this.tokenId = struct.getString("token_id");
            this.hmac = struct.getByteArray("hmac");
            {
                Object[] nestedObjects = struct.getArray("renewers");
                this.renewers = new ArrayList<DescribedDelegationTokenRenewer>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.renewers.add(new DescribedDelegationTokenRenewer((Struct) nestedObject, version));
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("principal_type", this.principalType);
            struct.set("principal_name", this.principalName);
            struct.set("issue_timestamp", this.issueTimestamp);
            struct.set("expiry_timestamp", this.expiryTimestamp);
            struct.set("max_timestamp", this.maxTimestamp);
            struct.set("token_id", this.tokenId);
            struct.setByteArray("hmac", this.hmac);
            {
                Struct[] nestedObjects = new Struct[renewers.size()];
                int i = 0;
                for (DescribedDelegationTokenRenewer element : this.renewers) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("renewers", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
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
            for (DescribedDelegationTokenRenewer element : renewers) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DescribedDelegationToken)) return false;
            DescribedDelegationToken other = (DescribedDelegationToken) obj;
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
            if (issueTimestamp != other.issueTimestamp) return false;
            if (expiryTimestamp != other.expiryTimestamp) return false;
            if (maxTimestamp != other.maxTimestamp) return false;
            if (this.tokenId == null) {
                if (other.tokenId != null) return false;
            } else {
                if (!this.tokenId.equals(other.tokenId)) return false;
            }
            if (!Arrays.equals(this.hmac, other.hmac)) return false;
            if (this.renewers == null) {
                if (other.renewers != null) return false;
            } else {
                if (!this.renewers.equals(other.renewers)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (principalType == null ? 0 : principalType.hashCode());
            hashCode = 31 * hashCode + (principalName == null ? 0 : principalName.hashCode());
            hashCode = 31 * hashCode + ((int) (issueTimestamp >> 32) ^ (int) issueTimestamp);
            hashCode = 31 * hashCode + ((int) (expiryTimestamp >> 32) ^ (int) expiryTimestamp);
            hashCode = 31 * hashCode + ((int) (maxTimestamp >> 32) ^ (int) maxTimestamp);
            hashCode = 31 * hashCode + (tokenId == null ? 0 : tokenId.hashCode());
            hashCode = 31 * hashCode + Arrays.hashCode(hmac);
            hashCode = 31 * hashCode + (renewers == null ? 0 : renewers.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DescribedDelegationToken("
                + "principalType='" + principalType + "'"
                + ", principalName='" + principalName + "'"
                + ", issueTimestamp=" + issueTimestamp
                + ", expiryTimestamp=" + expiryTimestamp
                + ", maxTimestamp=" + maxTimestamp
                + ", tokenId='" + tokenId + "'"
                + ", hmac=" + Arrays.toString(hmac)
                + ", renewers=" + MessageUtil.deepToString(renewers.iterator())
                + ")";
        }
        
        public String principalType() {
            return this.principalType;
        }
        
        public String principalName() {
            return this.principalName;
        }
        
        public long issueTimestamp() {
            return this.issueTimestamp;
        }
        
        public long expiryTimestamp() {
            return this.expiryTimestamp;
        }
        
        public long maxTimestamp() {
            return this.maxTimestamp;
        }
        
        public String tokenId() {
            return this.tokenId;
        }
        
        public byte[] hmac() {
            return this.hmac;
        }
        
        public List<DescribedDelegationTokenRenewer> renewers() {
            return this.renewers;
        }
        
        public DescribedDelegationToken setPrincipalType(String v) {
            this.principalType = v;
            return this;
        }
        
        public DescribedDelegationToken setPrincipalName(String v) {
            this.principalName = v;
            return this;
        }
        
        public DescribedDelegationToken setIssueTimestamp(long v) {
            this.issueTimestamp = v;
            return this;
        }
        
        public DescribedDelegationToken setExpiryTimestamp(long v) {
            this.expiryTimestamp = v;
            return this;
        }
        
        public DescribedDelegationToken setMaxTimestamp(long v) {
            this.maxTimestamp = v;
            return this;
        }
        
        public DescribedDelegationToken setTokenId(String v) {
            this.tokenId = v;
            return this;
        }
        
        public DescribedDelegationToken setHmac(byte[] v) {
            this.hmac = v;
            return this;
        }
        
        public DescribedDelegationToken setRenewers(List<DescribedDelegationTokenRenewer> v) {
            this.renewers = v;
            return this;
        }
    }
    
    static public class DescribedDelegationTokenRenewer implements Message {
        private String principalType;
        private String principalName;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("principal_type", Type.STRING, "The renewer principal type"),
                new Field("principal_name", Type.STRING, "The renewer principal name")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public DescribedDelegationTokenRenewer(Readable readable, short version) {
            read(readable, version);
        }
        
        public DescribedDelegationTokenRenewer(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public DescribedDelegationTokenRenewer() {
            this.principalType = "";
            this.principalName = "";
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
            this.principalType = readable.readNullableString();
            this.principalName = readable.readNullableString();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(principalType);
            writable.writeString(principalName);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.principalType = struct.getString("principal_type");
            this.principalName = struct.getString("principal_name");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("principal_type", this.principalType);
            struct.set("principal_name", this.principalName);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(principalType);
            size += 2;
            size += MessageUtil.serializedUtf8Length(principalName);
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DescribedDelegationTokenRenewer)) return false;
            DescribedDelegationTokenRenewer other = (DescribedDelegationTokenRenewer) obj;
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
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (principalType == null ? 0 : principalType.hashCode());
            hashCode = 31 * hashCode + (principalName == null ? 0 : principalName.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "DescribedDelegationTokenRenewer("
                + "principalType='" + principalType + "'"
                + ", principalName='" + principalName + "'"
                + ")";
        }
        
        public String principalType() {
            return this.principalType;
        }
        
        public String principalName() {
            return this.principalName;
        }
        
        public DescribedDelegationTokenRenewer setPrincipalType(String v) {
            this.principalType = v;
            return this;
        }
        
        public DescribedDelegationTokenRenewer setPrincipalName(String v) {
            this.principalName = v;
            return this;
        }
    }
}
