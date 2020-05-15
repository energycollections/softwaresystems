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


public class AddPartitionsToTxnRequestData implements ApiMessage {
    private String transactionalId;
    private long producerId;
    private short producerEpoch;
    private AddPartitionsToTxnTopicSet topics;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("transactional_id", Type.STRING, "The transactional id corresponding to the transaction."),
            new Field("producer_id", Type.INT64, "Current producer id in use by the transactional id."),
            new Field("producer_epoch", Type.INT16, "Current epoch associated with the producer id."),
            new Field("topics", new ArrayOf(AddPartitionsToTxnTopic.SCHEMA_0), "The partitions to add to the transation.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public AddPartitionsToTxnRequestData(Readable readable, short version) {
        this.topics = new AddPartitionsToTxnTopicSet(0);
        read(readable, version);
    }
    
    public AddPartitionsToTxnRequestData(Struct struct, short version) {
        this.topics = new AddPartitionsToTxnTopicSet(0);
        fromStruct(struct, version);
    }
    
    public AddPartitionsToTxnRequestData() {
        this.transactionalId = "";
        this.producerId = 0L;
        this.producerEpoch = (short) 0;
        this.topics = new AddPartitionsToTxnTopicSet(0);
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
        this.transactionalId = readable.readNullableString();
        this.producerId = readable.readLong();
        this.producerEpoch = readable.readShort();
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topics.clear(0);
            } else {
                this.topics.clear(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    this.topics.add(new AddPartitionsToTxnTopic(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeString(transactionalId);
        writable.writeLong(producerId);
        writable.writeShort(producerEpoch);
        writable.writeInt(topics.size());
        for (AddPartitionsToTxnTopic element : topics) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        this.transactionalId = struct.getString("transactional_id");
        this.producerId = struct.getLong("producer_id");
        this.producerEpoch = struct.getShort("producer_epoch");
        {
            Object[] nestedObjects = struct.getArray("topics");
            this.topics = new AddPartitionsToTxnTopicSet(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topics.add(new AddPartitionsToTxnTopic((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        struct.set("transactional_id", this.transactionalId);
        struct.set("producer_id", this.producerId);
        struct.set("producer_epoch", this.producerEpoch);
        {
            Struct[] nestedObjects = new Struct[topics.size()];
            int i = 0;
            for (AddPartitionsToTxnTopic element : this.topics) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("topics", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 2;
        size += MessageUtil.serializedUtf8Length(transactionalId);
        size += 8;
        size += 2;
        size += 4;
        for (AddPartitionsToTxnTopic element : topics) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AddPartitionsToTxnRequestData)) return false;
        AddPartitionsToTxnRequestData other = (AddPartitionsToTxnRequestData) obj;
        if (this.transactionalId == null) {
            if (other.transactionalId != null) return false;
        } else {
            if (!this.transactionalId.equals(other.transactionalId)) return false;
        }
        if (producerId != other.producerId) return false;
        if (producerEpoch != other.producerEpoch) return false;
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
        hashCode = 31 * hashCode + (transactionalId == null ? 0 : transactionalId.hashCode());
        hashCode = 31 * hashCode + ((int) (producerId >> 32) ^ (int) producerId);
        hashCode = 31 * hashCode + producerEpoch;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "AddPartitionsToTxnRequestData("
            + "transactionalId='" + transactionalId + "'"
            + ", producerId=" + producerId
            + ", producerEpoch=" + producerEpoch
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public String transactionalId() {
        return this.transactionalId;
    }
    
    public long producerId() {
        return this.producerId;
    }
    
    public short producerEpoch() {
        return this.producerEpoch;
    }
    
    public AddPartitionsToTxnTopicSet topics() {
        return this.topics;
    }
    
    public AddPartitionsToTxnRequestData setTransactionalId(String v) {
        this.transactionalId = v;
        return this;
    }
    
    public AddPartitionsToTxnRequestData setProducerId(long v) {
        this.producerId = v;
        return this;
    }
    
    public AddPartitionsToTxnRequestData setProducerEpoch(short v) {
        this.producerEpoch = v;
        return this;
    }
    
    public AddPartitionsToTxnRequestData setTopics(AddPartitionsToTxnTopicSet v) {
        this.topics = v;
        return this;
    }
    
    static public class AddPartitionsToTxnTopic implements Message, ImplicitLinkedHashMultiSet.Element {
        private String name;
        private List<Integer> partitions;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The name of the topic."),
                new Field("partitions", new ArrayOf(Type.INT32), "The partition indexes to add to the transaction")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public AddPartitionsToTxnTopic(Readable readable, short version) {
            this.partitions = new ArrayList<Integer>();
            read(readable, version);
        }
        
        public AddPartitionsToTxnTopic(Struct struct, short version) {
            this.partitions = new ArrayList<Integer>();
            fromStruct(struct, version);
        }
        
        public AddPartitionsToTxnTopic() {
            this.name = "";
            this.partitions = new ArrayList<Integer>();
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
                    this.partitions.clear();
                } else {
                    this.partitions.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.partitions.add(readable.readInt());
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeString(name);
            writable.writeInt(partitions.size());
            for (Integer element : partitions) {
                writable.writeInt(element);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.name = struct.getString("name");
            {
                Object[] nestedObjects = struct.getArray("partitions");
                this.partitions = new ArrayList<Integer>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitions.add((Integer) nestedObject);
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("name", this.name);
            {
                Integer[] nestedObjects = new Integer[partitions.size()];
                int i = 0;
                for (Integer element : this.partitions) {
                    nestedObjects[i++] = element;
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
            size += partitions.size() * 4;
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof AddPartitionsToTxnTopic)) return false;
            AddPartitionsToTxnTopic other = (AddPartitionsToTxnTopic) obj;
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
            return "AddPartitionsToTxnTopic("
                + "name='" + name + "'"
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<Integer> partitions() {
            return this.partitions;
        }
        
        @Override
        public int next() {
            return this.next;
        }
        
        @Override
        public int prev() {
            return this.prev;
        }
        
        public AddPartitionsToTxnTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public AddPartitionsToTxnTopic setPartitions(List<Integer> v) {
            this.partitions = v;
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
    
    public static class AddPartitionsToTxnTopicSet extends ImplicitLinkedHashMultiSet<AddPartitionsToTxnTopic> {
        public AddPartitionsToTxnTopicSet() {
            super();
        }
        
        public AddPartitionsToTxnTopicSet(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public AddPartitionsToTxnTopicSet(Iterator<AddPartitionsToTxnTopic> iterator) {
            super(iterator);
        }
        
        public AddPartitionsToTxnTopic find(String name) {
            AddPartitionsToTxnTopic key = new AddPartitionsToTxnTopic();
            key.setName(name);
            return find(key);
        }
        
        public List<AddPartitionsToTxnTopic> findAll(String name) {
            AddPartitionsToTxnTopic key = new AddPartitionsToTxnTopic();
            key.setName(name);
            return findAll(key);
        }
        
    }
}
