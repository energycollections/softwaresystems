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
import org.apache.kafka.common.errors.UnsupportedVersionException;
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


public class MetadataResponseData implements ApiMessage {
    private int throttleTimeMs;
    private MetadataResponseBrokerSet brokers;
    private String clusterId;
    private int controllerId;
    private MetadataResponseTopicSet topics;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("brokers", new ArrayOf(MetadataResponseBroker.SCHEMA_0), "Each broker in the response."),
            new Field("topics", new ArrayOf(MetadataResponseTopic.SCHEMA_0), "Each topic in the response.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("brokers", new ArrayOf(MetadataResponseBroker.SCHEMA_1), "Each broker in the response."),
            new Field("controller_id", Type.INT32, "The ID of the controller broker."),
            new Field("topics", new ArrayOf(MetadataResponseTopic.SCHEMA_1), "Each topic in the response.")
        );
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("brokers", new ArrayOf(MetadataResponseBroker.SCHEMA_1), "Each broker in the response."),
            new Field("cluster_id", Type.NULLABLE_STRING, "The cluster ID that responding broker belongs to."),
            new Field("controller_id", Type.INT32, "The ID of the controller broker."),
            new Field("topics", new ArrayOf(MetadataResponseTopic.SCHEMA_1), "Each topic in the response.")
        );
    
    public static final Schema SCHEMA_3 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("brokers", new ArrayOf(MetadataResponseBroker.SCHEMA_1), "Each broker in the response."),
            new Field("cluster_id", Type.NULLABLE_STRING, "The cluster ID that responding broker belongs to."),
            new Field("controller_id", Type.INT32, "The ID of the controller broker."),
            new Field("topics", new ArrayOf(MetadataResponseTopic.SCHEMA_1), "Each topic in the response.")
        );
    
    public static final Schema SCHEMA_4 = SCHEMA_3;
    
    public static final Schema SCHEMA_5 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("brokers", new ArrayOf(MetadataResponseBroker.SCHEMA_1), "Each broker in the response."),
            new Field("cluster_id", Type.NULLABLE_STRING, "The cluster ID that responding broker belongs to."),
            new Field("controller_id", Type.INT32, "The ID of the controller broker."),
            new Field("topics", new ArrayOf(MetadataResponseTopic.SCHEMA_5), "Each topic in the response.")
        );
    
    public static final Schema SCHEMA_6 = SCHEMA_5;
    
    public static final Schema SCHEMA_7 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("brokers", new ArrayOf(MetadataResponseBroker.SCHEMA_1), "Each broker in the response."),
            new Field("cluster_id", Type.NULLABLE_STRING, "The cluster ID that responding broker belongs to."),
            new Field("controller_id", Type.INT32, "The ID of the controller broker."),
            new Field("topics", new ArrayOf(MetadataResponseTopic.SCHEMA_7), "Each topic in the response.")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3,
        SCHEMA_4,
        SCHEMA_5,
        SCHEMA_6,
        SCHEMA_7
    };
    
    public MetadataResponseData(Readable readable, short version) {
        this.brokers = new MetadataResponseBrokerSet(0);
        this.topics = new MetadataResponseTopicSet(0);
        read(readable, version);
    }
    
    public MetadataResponseData(Struct struct, short version) {
        this.brokers = new MetadataResponseBrokerSet(0);
        this.topics = new MetadataResponseTopicSet(0);
        fromStruct(struct, version);
    }
    
    public MetadataResponseData() {
        this.throttleTimeMs = 0;
        this.brokers = new MetadataResponseBrokerSet(0);
        this.clusterId = "";
        this.controllerId = -1;
        this.topics = new MetadataResponseTopicSet(0);
    }
    
    @Override
    public short apiKey() {
        return 3;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 7;
    }
    
    @Override
    public void read(Readable readable, short version) {
        if (version >= 3) {
            this.throttleTimeMs = readable.readInt();
        } else {
            this.throttleTimeMs = 0;
        }
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.brokers.clear(0);
            } else {
                this.brokers.clear(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    this.brokers.add(new MetadataResponseBroker(readable, version));
                }
            }
        }
        if (version >= 2) {
            this.clusterId = readable.readNullableString();
        } else {
            this.clusterId = "";
        }
        if (version >= 1) {
            this.controllerId = readable.readInt();
        } else {
            this.controllerId = -1;
        }
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topics.clear(0);
            } else {
                this.topics.clear(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    this.topics.add(new MetadataResponseTopic(readable, version));
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        if (version >= 3) {
            writable.writeInt(throttleTimeMs);
        }
        writable.writeInt(brokers.size());
        for (MetadataResponseBroker element : brokers) {
            element.write(writable, version);
        }
        if (version >= 2) {
            writable.writeNullableString(clusterId);
        }
        if (version >= 1) {
            writable.writeInt(controllerId);
        }
        writable.writeInt(topics.size());
        for (MetadataResponseTopic element : topics) {
            element.write(writable, version);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        if (version >= 3) {
            this.throttleTimeMs = struct.getInt("throttle_time_ms");
        } else {
            this.throttleTimeMs = 0;
        }
        {
            Object[] nestedObjects = struct.getArray("brokers");
            this.brokers = new MetadataResponseBrokerSet(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.brokers.add(new MetadataResponseBroker((Struct) nestedObject, version));
            }
        }
        if (version >= 2) {
            this.clusterId = struct.getString("cluster_id");
        } else {
            this.clusterId = "";
        }
        if (version >= 1) {
            this.controllerId = struct.getInt("controller_id");
        } else {
            this.controllerId = -1;
        }
        {
            Object[] nestedObjects = struct.getArray("topics");
            this.topics = new MetadataResponseTopicSet(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topics.add(new MetadataResponseTopic((Struct) nestedObject, version));
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        if (version >= 3) {
            struct.set("throttle_time_ms", this.throttleTimeMs);
        }
        {
            Struct[] nestedObjects = new Struct[brokers.size()];
            int i = 0;
            for (MetadataResponseBroker element : this.brokers) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("brokers", (Object[]) nestedObjects);
        }
        if (version >= 2) {
            struct.set("cluster_id", this.clusterId);
        }
        if (version >= 1) {
            struct.set("controller_id", this.controllerId);
        }
        {
            Struct[] nestedObjects = new Struct[topics.size()];
            int i = 0;
            for (MetadataResponseTopic element : this.topics) {
                nestedObjects[i++] = element.toStruct(version);
            }
            struct.set("topics", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        if (version >= 3) {
            size += 4;
        } else {
            if (throttleTimeMs != 0) {
                throw new UnsupportedVersionException("Attempted to write a non-default throttleTimeMs at version " + version);
            }
        }
        size += 4;
        for (MetadataResponseBroker element : brokers) {
            size += element.size(version);
        }
        if (version >= 2) {
            size += 2;
            if (clusterId != null) {
                size += MessageUtil.serializedUtf8Length(clusterId);
            }
        }
        if (version >= 1) {
            size += 4;
        }
        size += 4;
        for (MetadataResponseTopic element : topics) {
            size += element.size(version);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MetadataResponseData)) return false;
        MetadataResponseData other = (MetadataResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (this.brokers == null) {
            if (other.brokers != null) return false;
        } else {
            if (!this.brokers.equals(other.brokers)) return false;
        }
        if (this.clusterId == null) {
            if (other.clusterId != null) return false;
        } else {
            if (!this.clusterId.equals(other.clusterId)) return false;
        }
        if (controllerId != other.controllerId) return false;
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
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + (brokers == null ? 0 : brokers.hashCode());
        hashCode = 31 * hashCode + (clusterId == null ? 0 : clusterId.hashCode());
        hashCode = 31 * hashCode + controllerId;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "MetadataResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", brokers=" + MessageUtil.deepToString(brokers.iterator())
            + ", clusterId='" + clusterId + "'"
            + ", controllerId=" + controllerId
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public MetadataResponseBrokerSet brokers() {
        return this.brokers;
    }
    
    public String clusterId() {
        return this.clusterId;
    }
    
    public int controllerId() {
        return this.controllerId;
    }
    
    public MetadataResponseTopicSet topics() {
        return this.topics;
    }
    
    public MetadataResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public MetadataResponseData setBrokers(MetadataResponseBrokerSet v) {
        this.brokers = v;
        return this;
    }
    
    public MetadataResponseData setClusterId(String v) {
        this.clusterId = v;
        return this;
    }
    
    public MetadataResponseData setControllerId(int v) {
        this.controllerId = v;
        return this;
    }
    
    public MetadataResponseData setTopics(MetadataResponseTopicSet v) {
        this.topics = v;
        return this;
    }
    
    static public class MetadataResponseBroker implements Message, ImplicitLinkedHashMultiSet.Element {
        private int nodeId;
        private String host;
        private int port;
        private String rack;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("node_id", Type.INT32, "The broker ID."),
                new Field("host", Type.STRING, "The broker hostname."),
                new Field("port", Type.INT32, "The broker port.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("node_id", Type.INT32, "The broker ID."),
                new Field("host", Type.STRING, "The broker hostname."),
                new Field("port", Type.INT32, "The broker port."),
                new Field("rack", Type.NULLABLE_STRING, "The rack of the broker, or null if it has not been assigned to a rack.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5,
            SCHEMA_6,
            SCHEMA_7
        };
        
        public MetadataResponseBroker(Readable readable, short version) {
            read(readable, version);
        }
        
        public MetadataResponseBroker(Struct struct, short version) {
            fromStruct(struct, version);
        }
        
        public MetadataResponseBroker() {
            this.nodeId = 0;
            this.host = "";
            this.port = 0;
            this.rack = "";
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 7;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.nodeId = readable.readInt();
            this.host = readable.readNullableString();
            this.port = readable.readInt();
            if (version >= 1) {
                this.rack = readable.readNullableString();
            } else {
                this.rack = "";
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeInt(nodeId);
            writable.writeString(host);
            writable.writeInt(port);
            if (version >= 1) {
                writable.writeNullableString(rack);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.nodeId = struct.getInt("node_id");
            this.host = struct.getString("host");
            this.port = struct.getInt("port");
            if (version >= 1) {
                this.rack = struct.getString("rack");
            } else {
                this.rack = "";
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("node_id", this.nodeId);
            struct.set("host", this.host);
            struct.set("port", this.port);
            if (version >= 1) {
                struct.set("rack", this.rack);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 4;
            size += 2;
            size += MessageUtil.serializedUtf8Length(host);
            size += 4;
            if (version >= 1) {
                size += 2;
                if (rack != null) {
                    size += MessageUtil.serializedUtf8Length(rack);
                }
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MetadataResponseBroker)) return false;
            MetadataResponseBroker other = (MetadataResponseBroker) obj;
            if (nodeId != other.nodeId) return false;
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + nodeId;
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "MetadataResponseBroker("
                + "nodeId=" + nodeId
                + ", host='" + host + "'"
                + ", port=" + port
                + ", rack='" + rack + "'"
                + ")";
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
        
        public String rack() {
            return this.rack;
        }
        
        @Override
        public int next() {
            return this.next;
        }
        
        @Override
        public int prev() {
            return this.prev;
        }
        
        public MetadataResponseBroker setNodeId(int v) {
            this.nodeId = v;
            return this;
        }
        
        public MetadataResponseBroker setHost(String v) {
            this.host = v;
            return this;
        }
        
        public MetadataResponseBroker setPort(int v) {
            this.port = v;
            return this;
        }
        
        public MetadataResponseBroker setRack(String v) {
            this.rack = v;
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
    
    public static class MetadataResponseBrokerSet extends ImplicitLinkedHashMultiSet<MetadataResponseBroker> {
        public MetadataResponseBrokerSet() {
            super();
        }
        
        public MetadataResponseBrokerSet(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public MetadataResponseBrokerSet(Iterator<MetadataResponseBroker> iterator) {
            super(iterator);
        }
        
        public MetadataResponseBroker find(int nodeId) {
            MetadataResponseBroker key = new MetadataResponseBroker();
            key.setNodeId(nodeId);
            return find(key);
        }
        
        public List<MetadataResponseBroker> findAll(int nodeId) {
            MetadataResponseBroker key = new MetadataResponseBroker();
            key.setNodeId(nodeId);
            return findAll(key);
        }
        
    }
    
    static public class MetadataResponseTopic implements Message, ImplicitLinkedHashMultiSet.Element {
        private short errorCode;
        private String name;
        private boolean isInternal;
        private List<MetadataResponsePartition> partitions;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("error_code", Type.INT16, "The topic error, or 0 if there was no error."),
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(MetadataResponsePartition.SCHEMA_0), "Each partition in the topic.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("error_code", Type.INT16, "The topic error, or 0 if there was no error."),
                new Field("name", Type.STRING, "The topic name."),
                new Field("is_internal", Type.BOOLEAN, "True if the topic is internal."),
                new Field("partitions", new ArrayOf(MetadataResponsePartition.SCHEMA_0), "Each partition in the topic.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("error_code", Type.INT16, "The topic error, or 0 if there was no error."),
                new Field("name", Type.STRING, "The topic name."),
                new Field("is_internal", Type.BOOLEAN, "True if the topic is internal."),
                new Field("partitions", new ArrayOf(MetadataResponsePartition.SCHEMA_5), "Each partition in the topic.")
            );
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 =
            new Schema(
                new Field("error_code", Type.INT16, "The topic error, or 0 if there was no error."),
                new Field("name", Type.STRING, "The topic name."),
                new Field("is_internal", Type.BOOLEAN, "True if the topic is internal."),
                new Field("partitions", new ArrayOf(MetadataResponsePartition.SCHEMA_7), "Each partition in the topic.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5,
            SCHEMA_6,
            SCHEMA_7
        };
        
        public MetadataResponseTopic(Readable readable, short version) {
            this.partitions = new ArrayList<MetadataResponsePartition>();
            read(readable, version);
        }
        
        public MetadataResponseTopic(Struct struct, short version) {
            this.partitions = new ArrayList<MetadataResponsePartition>();
            fromStruct(struct, version);
        }
        
        public MetadataResponseTopic() {
            this.errorCode = (short) 0;
            this.name = "";
            this.isInternal = false;
            this.partitions = new ArrayList<MetadataResponsePartition>();
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 7;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.errorCode = readable.readShort();
            this.name = readable.readNullableString();
            if (version >= 1) {
                this.isInternal = readable.readByte() != 0;
            } else {
                this.isInternal = false;
            }
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.partitions.clear();
                } else {
                    this.partitions.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.partitions.add(new MetadataResponsePartition(readable, version));
                    }
                }
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeShort(errorCode);
            writable.writeString(name);
            if (version >= 1) {
                writable.writeByte(isInternal ? (byte) 1 : (byte) 0);
            }
            writable.writeInt(partitions.size());
            for (MetadataResponsePartition element : partitions) {
                element.write(writable, version);
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.errorCode = struct.getShort("error_code");
            this.name = struct.getString("name");
            if (version >= 1) {
                this.isInternal = struct.getBoolean("is_internal");
            } else {
                this.isInternal = false;
            }
            {
                Object[] nestedObjects = struct.getArray("partitions");
                this.partitions = new ArrayList<MetadataResponsePartition>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.partitions.add(new MetadataResponsePartition((Struct) nestedObject, version));
                }
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("error_code", this.errorCode);
            struct.set("name", this.name);
            if (version >= 1) {
                struct.set("is_internal", this.isInternal);
            }
            {
                Struct[] nestedObjects = new Struct[partitions.size()];
                int i = 0;
                for (MetadataResponsePartition element : this.partitions) {
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
            size += 2;
            size += MessageUtil.serializedUtf8Length(name);
            if (version >= 1) {
                size += 1;
            }
            size += 4;
            for (MetadataResponsePartition element : partitions) {
                size += element.size(version);
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MetadataResponseTopic)) return false;
            MetadataResponseTopic other = (MetadataResponseTopic) obj;
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
            return "MetadataResponseTopic("
                + "errorCode=" + errorCode
                + ", name='" + name + "'"
                + ", isInternal=" + (isInternal ? "true" : "false")
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public String name() {
            return this.name;
        }
        
        public boolean isInternal() {
            return this.isInternal;
        }
        
        public List<MetadataResponsePartition> partitions() {
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
        
        public MetadataResponseTopic setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public MetadataResponseTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public MetadataResponseTopic setIsInternal(boolean v) {
            this.isInternal = v;
            return this;
        }
        
        public MetadataResponseTopic setPartitions(List<MetadataResponsePartition> v) {
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
    
    static public class MetadataResponsePartition implements Message {
        private short errorCode;
        private int partitionIndex;
        private int leaderId;
        private int leaderEpoch;
        private List<Integer> replicaNodes;
        private List<Integer> isrNodes;
        private List<Integer> offlineReplicas;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("error_code", Type.INT16, "The partition error, or 0 if there was no error."),
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("leader_id", Type.INT32, "The ID of the leader broker."),
                new Field("replica_nodes", new ArrayOf(Type.INT32), "The set of all nodes that host this partition."),
                new Field("isr_nodes", new ArrayOf(Type.INT32), "The set of nodes that are in sync with the leader for this partition.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("error_code", Type.INT16, "The partition error, or 0 if there was no error."),
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("leader_id", Type.INT32, "The ID of the leader broker."),
                new Field("replica_nodes", new ArrayOf(Type.INT32), "The set of all nodes that host this partition."),
                new Field("isr_nodes", new ArrayOf(Type.INT32), "The set of nodes that are in sync with the leader for this partition."),
                new Field("offline_replicas", new ArrayOf(Type.INT32), "The set of offline replicas of this partition.")
            );
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 =
            new Schema(
                new Field("error_code", Type.INT16, "The partition error, or 0 if there was no error."),
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("leader_id", Type.INT32, "The ID of the leader broker."),
                new Field("leader_epoch", Type.INT32, "The leader epoch of this partition."),
                new Field("replica_nodes", new ArrayOf(Type.INT32), "The set of all nodes that host this partition."),
                new Field("isr_nodes", new ArrayOf(Type.INT32), "The set of nodes that are in sync with the leader for this partition."),
                new Field("offline_replicas", new ArrayOf(Type.INT32), "The set of offline replicas of this partition.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5,
            SCHEMA_6,
            SCHEMA_7
        };
        
        public MetadataResponsePartition(Readable readable, short version) {
            this.replicaNodes = new ArrayList<Integer>();
            this.isrNodes = new ArrayList<Integer>();
            this.offlineReplicas = new ArrayList<Integer>();
            read(readable, version);
        }
        
        public MetadataResponsePartition(Struct struct, short version) {
            this.replicaNodes = new ArrayList<Integer>();
            this.isrNodes = new ArrayList<Integer>();
            this.offlineReplicas = new ArrayList<Integer>();
            fromStruct(struct, version);
        }
        
        public MetadataResponsePartition() {
            this.errorCode = (short) 0;
            this.partitionIndex = 0;
            this.leaderId = 0;
            this.leaderEpoch = -1;
            this.replicaNodes = new ArrayList<Integer>();
            this.isrNodes = new ArrayList<Integer>();
            this.offlineReplicas = new ArrayList<Integer>();
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 7;
        }
        
        @Override
        public void read(Readable readable, short version) {
            this.errorCode = readable.readShort();
            this.partitionIndex = readable.readInt();
            this.leaderId = readable.readInt();
            if (version >= 7) {
                this.leaderEpoch = readable.readInt();
            } else {
                this.leaderEpoch = -1;
            }
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.replicaNodes.clear();
                } else {
                    this.replicaNodes.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.replicaNodes.add(readable.readInt());
                    }
                }
            }
            {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.isrNodes.clear();
                } else {
                    this.isrNodes.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.isrNodes.add(readable.readInt());
                    }
                }
            }
            if (version >= 5) {
                int arrayLength = readable.readInt();
                if (arrayLength < 0) {
                    this.offlineReplicas.clear();
                } else {
                    this.offlineReplicas.clear();
                    for (int i = 0; i < arrayLength; i++) {
                        this.offlineReplicas.add(readable.readInt());
                    }
                }
            } else {
                this.offlineReplicas = new ArrayList<Integer>();
            }
        }
        
        @Override
        public void write(Writable writable, short version) {
            writable.writeShort(errorCode);
            writable.writeInt(partitionIndex);
            writable.writeInt(leaderId);
            if (version >= 7) {
                writable.writeInt(leaderEpoch);
            }
            writable.writeInt(replicaNodes.size());
            for (Integer element : replicaNodes) {
                writable.writeInt(element);
            }
            writable.writeInt(isrNodes.size());
            for (Integer element : isrNodes) {
                writable.writeInt(element);
            }
            if (version >= 5) {
                writable.writeInt(offlineReplicas.size());
                for (Integer element : offlineReplicas) {
                    writable.writeInt(element);
                }
            }
        }
        
        @Override
        public void fromStruct(Struct struct, short version) {
            this.errorCode = struct.getShort("error_code");
            this.partitionIndex = struct.getInt("partition_index");
            this.leaderId = struct.getInt("leader_id");
            if (version >= 7) {
                this.leaderEpoch = struct.getInt("leader_epoch");
            } else {
                this.leaderEpoch = -1;
            }
            {
                Object[] nestedObjects = struct.getArray("replica_nodes");
                this.replicaNodes = new ArrayList<Integer>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.replicaNodes.add((Integer) nestedObject);
                }
            }
            {
                Object[] nestedObjects = struct.getArray("isr_nodes");
                this.isrNodes = new ArrayList<Integer>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.isrNodes.add((Integer) nestedObject);
                }
            }
            if (version >= 5) {
                Object[] nestedObjects = struct.getArray("offline_replicas");
                this.offlineReplicas = new ArrayList<Integer>(nestedObjects.length);
                for (Object nestedObject : nestedObjects) {
                    this.offlineReplicas.add((Integer) nestedObject);
                }
            } else {
                this.offlineReplicas = new ArrayList<Integer>();
            }
        }
        
        @Override
        public Struct toStruct(short version) {
            Struct struct = new Struct(SCHEMAS[version]);
            struct.set("error_code", this.errorCode);
            struct.set("partition_index", this.partitionIndex);
            struct.set("leader_id", this.leaderId);
            if (version >= 7) {
                struct.set("leader_epoch", this.leaderEpoch);
            }
            {
                Integer[] nestedObjects = new Integer[replicaNodes.size()];
                int i = 0;
                for (Integer element : this.replicaNodes) {
                    nestedObjects[i++] = element;
                }
                struct.set("replica_nodes", (Object[]) nestedObjects);
            }
            {
                Integer[] nestedObjects = new Integer[isrNodes.size()];
                int i = 0;
                for (Integer element : this.isrNodes) {
                    nestedObjects[i++] = element;
                }
                struct.set("isr_nodes", (Object[]) nestedObjects);
            }
            if (version >= 5) {
                Integer[] nestedObjects = new Integer[offlineReplicas.size()];
                int i = 0;
                for (Integer element : this.offlineReplicas) {
                    nestedObjects[i++] = element;
                }
                struct.set("offline_replicas", (Object[]) nestedObjects);
            }
            return struct;
        }
        
        @Override
        public int size(short version) {
            int size = 0;
            size += 2;
            size += 4;
            size += 4;
            if (version >= 7) {
                size += 4;
            }
            size += 4;
            size += replicaNodes.size() * 4;
            size += 4;
            size += isrNodes.size() * 4;
            if (version >= 5) {
                size += 4;
                size += offlineReplicas.size() * 4;
            }
            return size;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MetadataResponsePartition)) return false;
            MetadataResponsePartition other = (MetadataResponsePartition) obj;
            if (errorCode != other.errorCode) return false;
            if (partitionIndex != other.partitionIndex) return false;
            if (leaderId != other.leaderId) return false;
            if (leaderEpoch != other.leaderEpoch) return false;
            if (this.replicaNodes == null) {
                if (other.replicaNodes != null) return false;
            } else {
                if (!this.replicaNodes.equals(other.replicaNodes)) return false;
            }
            if (this.isrNodes == null) {
                if (other.isrNodes != null) return false;
            } else {
                if (!this.isrNodes.equals(other.isrNodes)) return false;
            }
            if (this.offlineReplicas == null) {
                if (other.offlineReplicas != null) return false;
            } else {
                if (!this.offlineReplicas.equals(other.offlineReplicas)) return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + errorCode;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + leaderId;
            hashCode = 31 * hashCode + leaderEpoch;
            hashCode = 31 * hashCode + (replicaNodes == null ? 0 : replicaNodes.hashCode());
            hashCode = 31 * hashCode + (isrNodes == null ? 0 : isrNodes.hashCode());
            hashCode = 31 * hashCode + (offlineReplicas == null ? 0 : offlineReplicas.hashCode());
            return hashCode;
        }
        
        @Override
        public String toString() {
            return "MetadataResponsePartition("
                + "errorCode=" + errorCode
                + ", partitionIndex=" + partitionIndex
                + ", leaderId=" + leaderId
                + ", leaderEpoch=" + leaderEpoch
                + ", replicaNodes=" + MessageUtil.deepToString(replicaNodes.iterator())
                + ", isrNodes=" + MessageUtil.deepToString(isrNodes.iterator())
                + ", offlineReplicas=" + MessageUtil.deepToString(offlineReplicas.iterator())
                + ")";
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public int leaderId() {
            return this.leaderId;
        }
        
        public int leaderEpoch() {
            return this.leaderEpoch;
        }
        
        public List<Integer> replicaNodes() {
            return this.replicaNodes;
        }
        
        public List<Integer> isrNodes() {
            return this.isrNodes;
        }
        
        public List<Integer> offlineReplicas() {
            return this.offlineReplicas;
        }
        
        public MetadataResponsePartition setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public MetadataResponsePartition setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public MetadataResponsePartition setLeaderId(int v) {
            this.leaderId = v;
            return this;
        }
        
        public MetadataResponsePartition setLeaderEpoch(int v) {
            this.leaderEpoch = v;
            return this;
        }
        
        public MetadataResponsePartition setReplicaNodes(List<Integer> v) {
            this.replicaNodes = v;
            return this;
        }
        
        public MetadataResponsePartition setIsrNodes(List<Integer> v) {
            this.isrNodes = v;
            return this;
        }
        
        public MetadataResponsePartition setOfflineReplicas(List<Integer> v) {
            this.offlineReplicas = v;
            return this;
        }
    }
    
    public static class MetadataResponseTopicSet extends ImplicitLinkedHashMultiSet<MetadataResponseTopic> {
        public MetadataResponseTopicSet() {
            super();
        }
        
        public MetadataResponseTopicSet(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public MetadataResponseTopicSet(Iterator<MetadataResponseTopic> iterator) {
            super(iterator);
        }
        
        public MetadataResponseTopic find(String name) {
            MetadataResponseTopic key = new MetadataResponseTopic();
            key.setName(name);
            return find(key);
        }
        
        public List<MetadataResponseTopic> findAll(String name) {
            MetadataResponseTopic key = new MetadataResponseTopic();
            key.setName(name);
            return findAll(key);
        }
        
    }
}
