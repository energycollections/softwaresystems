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

import java.util.Iterator;
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
import org.apache.kafka.common.utils.ImplicitLinkedHashMultiSet;


public class AddPartitionsToTxnResponseData implements ApiMessage {
    private int throttleTimeMs;
    private AddPartitionsToTxnTopicResultSet results;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "Duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("results", new ArrayOf(AddPartitionsToTxnTopicResult.SCHEMA_0), "The results for each topic.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public AddPartitionsToTxnResponseData(Readable readable, short version) {
        this.results = new AddPartitionsToTxnTopicResultSet(0);
        read(readable, version);
    }
    
    public AddPartitionsToTxnResponseData(Struct struct, short version) {
        this.results = new AddPartitionsToTxnTopicResultSet(0);
        fromStruct(struct, version);
    }
    
    public AddPartitionsToTxnResponseData() {
        this.throttleTimeMs = 0;
        this.results = new AddPartitionsToTxnTopicResultSet(0);
    }
    
    @Override
    public short apiKey() {
        return 24;
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
        this.throttleTimeMs = readable.readInt();
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.results.clear(0);
            } else {
                this.results.clear(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    this.results.add(new AddPartitionsToTxnTopicResult(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(throttleTimeMs);
        writable.writeInt(results.size());
        for (AddPartitionsToTxnTopicResult element : results) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.throttleTimeMs = struct.getInt("throttle_time_ms");
        {
            Object[] nestedObjects = struct.getArray("results");
            this.results = new AddPartitionsToTxnTopicResultSet(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.results.add(new AddPartitionsToTxnTopicResult((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("throttle_time_ms", this.throttleTimeMs);
        {
            Struct[] nestedObjects = new Struct[results.size()];
            int i = 0;
            for (AddPartitionsToTxnTopicResult element : this.results) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("results", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        size += 4;
        for (AddPartitionsToTxnTopicResult element : results) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AddPartitionsToTxnResponseData)) return false;
        AddPartitionsToTxnResponseData other = (AddPartitionsToTxnResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (this.results == null) {
            if (other.results != null) return false;
        } else {
            if (!this.results.equals(other.results)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + (results == null ? 0 : results.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "AddPartitionsToTxnResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", results=" + MessageUtil.deepToString(results.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public AddPartitionsToTxnTopicResultSet results() {
        return this.results;
    }
    
    public AddPartitionsToTxnResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public AddPartitionsToTxnResponseData setResults(AddPartitionsToTxnTopicResultSet v) {
        this.results = v;
        return this;
    }
    
    static public class AddPartitionsToTxnTopicResult implements Message, ImplicitLinkedHashMultiSet.Element {
        private String name;
        private AddPartitionsToTxnPartitionResultSet results;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("results", new ArrayOf(AddPartitionsToTxnPartitionResult.SCHEMA_0), "The results for each partition")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public AddPartitionsToTxnTopicResult(Readable readable, short version) {
            this.results = new AddPartitionsToTxnPartitionResultSet(0);
            read(readable, version);
        }
        
        public AddPartitionsToTxnTopicResult(Struct struct, short version) {
            this.results = new AddPartitionsToTxnPartitionResultSet(0);
            fromStruct(struct, version);
        }
        
        public AddPartitionsToTxnTopicResult() {
            this.name = "";
            this.results = new AddPartitionsToTxnPartitionResultSet(0);
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
            this.name = readable.readNullableString();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.results.clear(0);
                } else {
                    this.results.clear(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        this.results.add(new AddPartitionsToTxnPartitionResult(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(results.size());
            for (AddPartitionsToTxnPartitionResult element : results) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("results");
                this.results = new AddPartitionsToTxnPartitionResultSet(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.results.add(new AddPartitionsToTxnPartitionResult((Struct) nestedObject, version));
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            {
                Struct[] nestedObjects = new Struct[results.size()];
                int i = 0;
                for (AddPartitionsToTxnPartitionResult element : this.results) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("results", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            size += 4;
            for (AddPartitionsToTxnPartitionResult element : results) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof AddPartitionsToTxnTopicResult)) return false;
            AddPartitionsToTxnTopicResult other = (AddPartitionsToTxnTopicResult) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "AddPartitionsToTxnTopicResult("
                + "name='" + name + "'"
                + ", results=" + MessageUtil.deepToString(results.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public AddPartitionsToTxnPartitionResultSet results() {
            return this.results;
        }
        
        @Override
        public int next() {
            return this.next;
        }
        
        @Override
        public int prev() {
            return this.prev;
        }
        
        public AddPartitionsToTxnTopicResult setName(String v) {
            this.name = v;
            return this;
        }
        
        public AddPartitionsToTxnTopicResult setResults(AddPartitionsToTxnPartitionResultSet v) {
            this.results = v;
            return this;
        }
        
        @Override
        public void setNext(int v) {
            this.next = v;
        }
        
        @Override
        public void setPrev(int v) {
            this.prev = v;
        }
    }
    
    static public class AddPartitionsToTxnPartitionResult implements Message, ImplicitLinkedHashMultiSet.Element {
        private int partitionIndex;
        private short errorCode;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition indexes."),
                new Field("error_code", Type.INT16, "The response error code.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public AddPartitionsToTxnPartitionResult(Readable readable, short version) {
            read(readable, version);
        }
        
        public AddPartitionsToTxnPartitionResult(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public AddPartitionsToTxnPartitionResult() {
            this.partitionIndex = 0;
            this.errorCode = (short) 0;
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
            this.partitionIndex = readable.readInt();
            this.errorCode = readable.readShort();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(partitionIndex);
            writable.writeShort(errorCode);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.partitionIndex = struct.getInt("partition_index");
            this.errorCode = struct.getShort("error_code");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("partition_index", this.partitionIndex);
            struct.set("error_code", this.errorCode);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            size += 2;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof AddPartitionsToTxnPartitionResult)) return false;
            AddPartitionsToTxnPartitionResult other = (AddPartitionsToTxnPartitionResult) obj;
            if (partitionIndex != other.partitionIndex) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "AddPartitionsToTxnPartitionResult("
                + "partitionIndex=" + partitionIndex
                + ", errorCode=" + errorCode
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        @Override
        public int next() {
            return this.next;
        }
        
        @Override
        public int prev() {
            return this.prev;
        }
        
        public AddPartitionsToTxnPartitionResult setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public AddPartitionsToTxnPartitionResult setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        @Override
        public void setNext(int v) {
            this.next = v;
        }
        
        @Override
        public void setPrev(int v) {
            this.prev = v;
        }
    }
    
    public static class AddPartitionsToTxnPartitionResultSet extends ImplicitLinkedHashMultiSet<AddPartitionsToTxnPartitionResult> {
        public AddPartitionsToTxnPartitionResultSet() {
            super();
        }
        
        public AddPartitionsToTxnPartitionResultSet(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public AddPartitionsToTxnPartitionResultSet(Iterator<AddPartitionsToTxnPartitionResult> iterator) {
            super(iterator);
        }
        
        public AddPartitionsToTxnPartitionResult find(int partitionIndex) {
            AddPartitionsToTxnPartitionResult key = new AddPartitionsToTxnPartitionResult();
            key.setPartitionIndex(partitionIndex);
            return find(key);
        }
        
        public List<AddPartitionsToTxnPartitionResult> findAll(int partitionIndex) {
            AddPartitionsToTxnPartitionResult key = new AddPartitionsToTxnPartitionResult();
            key.setPartitionIndex(partitionIndex);
            return findAll(key);
        }
        
    }
    
    public static class AddPartitionsToTxnTopicResultSet extends ImplicitLinkedHashMultiSet<AddPartitionsToTxnTopicResult> {
        public AddPartitionsToTxnTopicResultSet() {
            super();
        }
        
        public AddPartitionsToTxnTopicResultSet(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public AddPartitionsToTxnTopicResultSet(Iterator<AddPartitionsToTxnTopicResult> iterator) {
            super(iterator);
        }
        
        public AddPartitionsToTxnTopicResult find(String name) {
            AddPartitionsToTxnTopicResult key = new AddPartitionsToTxnTopicResult();
            key.setName(name);
            return find(key);
        }
        
        public List<AddPartitionsToTxnTopicResult> findAll(String name) {
            AddPartitionsToTxnTopicResult key = new AddPartitionsToTxnTopicResult();
            key.setName(name);
            return findAll(key);
        }
        
    }
}
