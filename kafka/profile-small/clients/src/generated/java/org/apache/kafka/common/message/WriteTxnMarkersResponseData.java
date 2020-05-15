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


public class WriteTxnMarkersResponseData implements ApiMessage {
    private List<WritableTxnMarkerResult> markers;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("markers", new ArrayOf(WritableTxnMarkerResult.SCHEMA_0), "The results for writing makers.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0
    };
    
    public WriteTxnMarkersResponseData(Readable readable, short version) {
        this.markers = new ArrayList<WritableTxnMarkerResult>();
        read(readable, version);
    }
    
    public WriteTxnMarkersResponseData(Struct struct, short version) {
        this.markers = new ArrayList<WritableTxnMarkerResult>();
        fromStruct(struct, version);
    }
    
    public WriteTxnMarkersResponseData() {
        this.markers = new ArrayList<WritableTxnMarkerResult>();
    }
    
    @Override
    public short apiKey() {
        return 27;
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
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.markers.clear();
            } else {
                this.markers.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.markers.add(new WritableTxnMarkerResult(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(markers.size());
        for (WritableTxnMarkerResult element : markers) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        {
            Object[] nestedObjects = struct.getArray("markers");
            this.markers = new ArrayList<WritableTxnMarkerResult>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.markers.add(new WritableTxnMarkerResult((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        {
            Struct[] nestedObjects = new Struct[markers.size()];
            int i = 0;
            for (WritableTxnMarkerResult element : this.markers) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("markers", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        for (WritableTxnMarkerResult element : markers) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof WriteTxnMarkersResponseData)) return false;
        WriteTxnMarkersResponseData other = (WriteTxnMarkersResponseData) obj;
        if (this.markers == null) {
            if (other.markers != null) return false;
        } else {
            if (!this.markers.equals(other.markers)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (markers == null ? 0 : markers.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "WriteTxnMarkersResponseData("
            + "markers=" + MessageUtil.deepToString(markers.iterator())
            + ")";
    }
    
    public List<WritableTxnMarkerResult> markers() {
        return this.markers;
    }
    
    public WriteTxnMarkersResponseData setMarkers(List<WritableTxnMarkerResult> v) {
        this.markers = v;
        return this;
    }
    
    static public class WritableTxnMarkerResult implements Message {
        private long producerId;
        private List<WritableTxnMarkerTopicResult> topics;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("producer_id", Type.INT64, "The current producer ID in use by the transactional ID."),
                new Field("topics", new ArrayOf(WritableTxnMarkerTopicResult.SCHEMA_0), "The results by topic.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0
        };
        
        public WritableTxnMarkerResult(Readable readable, short version) {
            this.topics = new ArrayList<WritableTxnMarkerTopicResult>();
            read(readable, version);
        }
        
        public WritableTxnMarkerResult(Struct struct, short version) {
            this.topics = new ArrayList<WritableTxnMarkerTopicResult>();
            fromStruct(struct, version);
        }
        
        public WritableTxnMarkerResult() {
            this.producerId = 0L;
            this.topics = new ArrayList<WritableTxnMarkerTopicResult>();
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
            this.producerId = readable.readLong();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.topics.clear();
                } else {
                    this.topics.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.topics.add(new WritableTxnMarkerTopicResult(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeLong(producerId);
            writable.writeInt(topics.size());
            for (WritableTxnMarkerTopicResult element : topics) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.producerId = struct.getLong("producer_id");
            {
                Object[] nestedObjects = struct.getArray("topics");
                this.topics = new ArrayList<WritableTxnMarkerTopicResult>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.topics.add(new WritableTxnMarkerTopicResult((Struct) nestedObject, version));
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("producer_id", this.producerId);
            {
                Struct[] nestedObjects = new Struct[topics.size()];
                int i = 0;
                for (WritableTxnMarkerTopicResult element : this.topics) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("topics", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 8;
            size += 4;
            for (WritableTxnMarkerTopicResult element : topics) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof WritableTxnMarkerResult)) return false;
            WritableTxnMarkerResult other = (WritableTxnMarkerResult) obj;
            if (producerId != other.producerId) return false;
            if (this.topics == null) {
                if (other.topics != null) return false;
            } else {
                if (!this.topics.equals(other.topics)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + ((int) (producerId >> 32) ^ (int) producerId);
            hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "WritableTxnMarkerResult("
                + "producerId=" + producerId
                + ", topics=" + MessageUtil.deepToString(topics.iterator())
                + ")";
        }
        
        public long producerId() {
            return this.producerId;
        }
        
        public List<WritableTxnMarkerTopicResult> topics() {
            return this.topics;
        }
        
        public WritableTxnMarkerResult setProducerId(long v) {
            this.producerId = v;
            return this;
        }
        
        public WritableTxnMarkerResult setTopics(List<WritableTxnMarkerTopicResult> v) {
            this.topics = v;
            return this;
        }
    }
    
    static public class WritableTxnMarkerTopicResult implements Message {
        private String name;
        private List<WritableTxnMarkerPartitionResult> partitions;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(WritableTxnMarkerPartitionResult.SCHEMA_0), "The results by partition.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0
        };
        
        public WritableTxnMarkerTopicResult(Readable readable, short version) {
            this.partitions = new ArrayList<WritableTxnMarkerPartitionResult>();
            read(readable, version);
        }
        
        public WritableTxnMarkerTopicResult(Struct struct, short version) {
            this.partitions = new ArrayList<WritableTxnMarkerPartitionResult>();
            fromStruct(struct, version);
        }
        
        public WritableTxnMarkerTopicResult() {
            this.name = "";
            this.partitions = new ArrayList<WritableTxnMarkerPartitionResult>();
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
            this.name = readable.readNullableString();
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.partitions.clear();
                } else {
                    this.partitions.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.partitions.add(new WritableTxnMarkerPartitionResult(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(partitions.size());
            for (WritableTxnMarkerPartitionResult element : partitions) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partitions");
                this.partitions = new ArrayList<WritableTxnMarkerPartitionResult>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitions.add(new WritableTxnMarkerPartitionResult((Struct) nestedObject, version));
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            {
                Struct[] nestedObjects = new Struct[partitions.size()];
                int i = 0;
                for (WritableTxnMarkerPartitionResult element : this.partitions) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("partitions", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            size += 4;
            for (WritableTxnMarkerPartitionResult element : partitions) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof WritableTxnMarkerTopicResult)) return false;
            WritableTxnMarkerTopicResult other = (WritableTxnMarkerTopicResult) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (this.partitions == null) {
                if (other.partitions != null) return false;
            } else {
                if (!this.partitions.equals(other.partitions)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + (partitions == null ? 0 : partitions.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "WritableTxnMarkerTopicResult("
                + "name='" + name + "'"
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<WritableTxnMarkerPartitionResult> partitions() {
            return this.partitions;
        }
        
        public WritableTxnMarkerTopicResult setName(String v) {
            this.name = v;
            return this;
        }
        
        public WritableTxnMarkerTopicResult setPartitions(List<WritableTxnMarkerPartitionResult> v) {
            this.partitions = v;
            return this;
        }
    }
    
    static public class WritableTxnMarkerPartitionResult implements Message {
        private int partitionIndex;
        private short errorCode;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no error.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0
        };
        
        public WritableTxnMarkerPartitionResult(Readable readable, short version) {
            read(readable, version);
        }
        
        public WritableTxnMarkerPartitionResult(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public WritableTxnMarkerPartitionResult() {
            this.partitionIndex = 0;
            this.errorCode = (short) 0;
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
            if (!(obj instanceof WritableTxnMarkerPartitionResult)) return false;
            WritableTxnMarkerPartitionResult other = (WritableTxnMarkerPartitionResult) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (errorCode != other.errorCode) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + errorCode;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "WritableTxnMarkerPartitionResult("
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
        
        public WritableTxnMarkerPartitionResult setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public WritableTxnMarkerPartitionResult setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
    }
}
