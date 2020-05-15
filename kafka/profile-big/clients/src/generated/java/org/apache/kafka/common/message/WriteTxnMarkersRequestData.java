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


public class WriteTxnMarkersRequestData implements ApiMessage {
    private List<WritableTxnMarker> markers;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("markers", new ArrayOf(WritableTxnMarker.SCHEMA_0), "The transaction markers to be written.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0
    };
    
    public WriteTxnMarkersRequestData(Readable readable, short version) {
        this.markers = new ArrayList<WritableTxnMarker>();
        read(readable, version);
    }
    
    public WriteTxnMarkersRequestData(Struct struct, short version) {
        this.markers = new ArrayList<WritableTxnMarker>();
        fromStruct(struct, version);
    }
    
    public WriteTxnMarkersRequestData() {
        this.markers = new ArrayList<WritableTxnMarker>();
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
                    this.markers.add(new WritableTxnMarker(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(markers.size());
        for (WritableTxnMarker element : markers) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        {
            Object[] nestedObjects = struct.getArray("markers");
            this.markers = new ArrayList<WritableTxnMarker>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.markers.add(new WritableTxnMarker((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        {
            Struct[] nestedObjects = new Struct[markers.size()];
            int i = 0;
            for (WritableTxnMarker element : this.markers) {
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
        for (WritableTxnMarker element : markers) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof WriteTxnMarkersRequestData)) return false;
        WriteTxnMarkersRequestData other = (WriteTxnMarkersRequestData) obj;
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
        return "WriteTxnMarkersRequestData("
            + "markers=" + MessageUtil.deepToString(markers.iterator())
            + ")";
    }
    
    public List<WritableTxnMarker> markers() {
        return this.markers;
    }
    
    public WriteTxnMarkersRequestData setMarkers(List<WritableTxnMarker> v) {
        this.markers = v;
        return this;
    }
    
    static public class WritableTxnMarker implements Message {
        private long producerId;
        private short producerEpoch;
        private boolean transactionResult;
        private List<WritableTxnMarkerTopic> topics;
        private int coordinatorEpoch;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("producer_id", Type.INT64, "The current producer ID."),
                new Field("producer_epoch", Type.INT16, "The current epoch associated with the producer ID."),
                new Field("transaction_result", Type.BOOLEAN, "The result of the transaction to write to the partitions (false = ABORT, true = COMMIT)."),
                new Field("topics", new ArrayOf(WritableTxnMarkerTopic.SCHEMA_0), "Each topic that we want to write transaction marker(s) for."),
                new Field("coordinator_epoch", Type.INT32, "Epoch associated with the transaction state partition hosted by this transaction coordinator")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0
        };
        
        public WritableTxnMarker(Readable readable, short version) {
            this.topics = new ArrayList<WritableTxnMarkerTopic>();
            read(readable, version);
        }
        
        public WritableTxnMarker(Struct struct, short version) {
            this.topics = new ArrayList<WritableTxnMarkerTopic>();
            fromStruct(struct, version);
        }
        
        public WritableTxnMarker() {
            this.producerId = 0L;
            this.producerEpoch = (short) 0;
            this.transactionResult = false;
            this.topics = new ArrayList<WritableTxnMarkerTopic>();
            this.coordinatorEpoch = 0;
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
            this.producerEpoch = readable.readShort();
            this.transactionResult = readable.readByte() != 0;
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.topics.clear();
                } else {
                    this.topics.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.topics.add(new WritableTxnMarkerTopic(readable, version));
                    }
                }
            }
            this.coordinatorEpoch = readable.readInt();
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeLong(producerId);
            writable.writeShort(producerEpoch);
            writable.writeByte(transactionResult ? (byte) 1 : (byte) 0);
            writable.writeInt(topics.size());
            for (WritableTxnMarkerTopic element : topics) {
                element.write(writable, version);
            }
            writable.writeInt(coordinatorEpoch);
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.producerId = struct.getLong("producer_id");
            this.producerEpoch = struct.getShort("producer_epoch");
            this.transactionResult = struct.getBoolean("transaction_result");
            {
                Object[] nestedObjects = struct.getArray("topics");
                this.topics = new ArrayList<WritableTxnMarkerTopic>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.topics.add(new WritableTxnMarkerTopic((Struct) nestedObject, version));
                }
            }
            this.coordinatorEpoch = struct.getInt("coordinator_epoch");
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("producer_id", this.producerId);
            struct.set("producer_epoch", this.producerEpoch);
            struct.set("transaction_result", this.transactionResult);
            {
                Struct[] nestedObjects = new Struct[topics.size()];
                int i = 0;
                for (WritableTxnMarkerTopic element : this.topics) {
                    nestedObjects[i++] = element.toStruct(version);
                }
                struct.set("topics", (Object[]) nestedObjects);
            }
            struct.set("coordinator_epoch", this.coordinatorEpoch);
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 8;
            size += 2;
            size += 1;
            size += 4;
            for (WritableTxnMarkerTopic element : topics) {
                size += element.size(version);
            }
            size += 4;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof WritableTxnMarker)) return false;
            WritableTxnMarker other = (WritableTxnMarker) obj;
            if (producerId != other.producerId) return false;
            if (producerEpoch != other.producerEpoch) return false;
            if (transactionResult != other.transactionResult) return false;
            if (this.topics == null) {
                if (other.topics != null) return false;
            } else {
                if (!this.topics.equals(other.topics)) return false;
            }
            if (coordinatorEpoch != other.coordinatorEpoch) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + ((int) (producerId >> 32) ^ (int) producerId);
            hashCode = 31 * hashCode + producerEpoch;
            hashCode = 31 * hashCode + (transactionResult ? 1231 : 1237);
            hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
            hashCode = 31 * hashCode + coordinatorEpoch;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "WritableTxnMarker("
                + "producerId=" + producerId
                + ", producerEpoch=" + producerEpoch
                + ", transactionResult=" + (transactionResult ? "true" : "false")
                + ", topics=" + MessageUtil.deepToString(topics.iterator())
                + ", coordinatorEpoch=" + coordinatorEpoch
                + ")";
        }
        
        public long producerId() {
            return this.producerId;
        }
        
        public short producerEpoch() {
            return this.producerEpoch;
        }
        
        public boolean transactionResult() {
            return this.transactionResult;
        }
        
        public List<WritableTxnMarkerTopic> topics() {
            return this.topics;
        }
        
        public int coordinatorEpoch() {
            return this.coordinatorEpoch;
        }
        
        public WritableTxnMarker setProducerId(long v) {
            this.producerId = v;
            return this;
        }
        
        public WritableTxnMarker setProducerEpoch(short v) {
            this.producerEpoch = v;
            return this;
        }
        
        public WritableTxnMarker setTransactionResult(boolean v) {
            this.transactionResult = v;
            return this;
        }
        
        public WritableTxnMarker setTopics(List<WritableTxnMarkerTopic> v) {
            this.topics = v;
            return this;
        }
        
        public WritableTxnMarker setCoordinatorEpoch(int v) {
            this.coordinatorEpoch = v;
            return this;
        }
    }
    
    static public class WritableTxnMarkerTopic implements Message {
        private String name;
        private List<Integer> partitionIndexes;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partition_indexes", new ArrayOf(Type.INT32), "The indexes of the partitions to write transaction markers for.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0
        };
        
        public WritableTxnMarkerTopic(Readable readable, short version) {
            this.partitionIndexes = new ArrayList<Integer>();
            read(readable, version);
        }
        
        public WritableTxnMarkerTopic(Struct struct, short version) {
            this.partitionIndexes = new ArrayList<Integer>();
            fromStruct(struct, version);
        }
        
        public WritableTxnMarkerTopic() {
            this.name = "";
            this.partitionIndexes = new ArrayList<Integer>();
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
                    this.partitionIndexes.clear();
                } else {
                    this.partitionIndexes.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.partitionIndexes.add(readable.readInt());
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(partitionIndexes.size());
            for (Integer element : partitionIndexes) {
                writable.writeInt(element);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partition_indexes");
                this.partitionIndexes = new ArrayList<Integer>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitionIndexes.add((Integer) nestedObject);
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            {
                Integer[] nestedObjects = new Integer[partitionIndexes.size()];
                int i = 0;
                for (Integer element : this.partitionIndexes) {
                    nestedObjects[i++] = element;
                }
                struct.set("partition_indexes", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            size += 4;
            size += partitionIndexes.size() * 4;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof WritableTxnMarkerTopic)) return false;
            WritableTxnMarkerTopic other = (WritableTxnMarkerTopic) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (this.partitionIndexes == null) {
                if (other.partitionIndexes != null) return false;
            } else {
                if (!this.partitionIndexes.equals(other.partitionIndexes)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + (partitionIndexes == null ? 0 : partitionIndexes.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "WritableTxnMarkerTopic("
                + "name='" + name + "'"
                + ", partitionIndexes=" + MessageUtil.deepToString(partitionIndexes.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<Integer> partitionIndexes() {
            return this.partitionIndexes;
        }
        
        public WritableTxnMarkerTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public WritableTxnMarkerTopic setPartitionIndexes(List<Integer> v) {
            this.partitionIndexes = v;
            return this;
        }
    }
}
