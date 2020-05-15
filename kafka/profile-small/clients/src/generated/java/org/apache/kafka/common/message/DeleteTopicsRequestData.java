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
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.ArrayOf;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Struct;
import org.apache.kafka.common.protocol.types.Type;


public class DeleteTopicsRequestData implements ApiMessage {
    private List<String> topicNames;
    private int timeoutMs;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topic_names", new ArrayOf(Type.STRING), "The names of the topics to delete"),
            new Field("timeout_ms", Type.INT32, "The length of time in milliseconds to wait for the deletions to complete.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3
    };
    
    public DeleteTopicsRequestData(Readable readable, short version) {
        this.topicNames = new ArrayList<String>();
        read(readable, version);
    }
    
    public DeleteTopicsRequestData(Struct struct, short version) {
        this.topicNames = new ArrayList<String>();
        fromStruct(struct, version);
    }
    
    public DeleteTopicsRequestData() {
        this.topicNames = new ArrayList<String>();
        this.timeoutMs = 0;
    }
    
    @Override
    public short apiKey() {
        return 20;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 3;
    }
    
    @Override
    public void read(Readable readable, short version) {
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.topicNames.clear();
            } else {
                this.topicNames.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.topicNames.add(readable.readNullableString());
                }
            }
        }
        this.timeoutMs = readable.readInt();
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(topicNames.size());
        for (String element : topicNames) {
            writable.writeString(element);
        }
        writable.writeInt(timeoutMs);
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        {
            Object[] nestedObjects = struct.getArray("topic_names");
            this.topicNames = new ArrayList<String>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.topicNames.add((String) nestedObject);
            }
        }
        this.timeoutMs = struct.getInt("timeout_ms");
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        {
            String[] nestedObjects = new String[topicNames.size()];
            int i = 0;
            for (String element : this.topicNames) {
                nestedObjects[i++] = element;
            }
            struct.set("topic_names", (Object[]) nestedObjects);
        }
        struct.set("timeout_ms", this.timeoutMs);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        for (String element : topicNames) {
            size += 2;
            size += MessageUtil.serializedUtf8Length(element);
        }
        size += 4;
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DeleteTopicsRequestData)) return false;
        DeleteTopicsRequestData other = (DeleteTopicsRequestData) obj;
        if (this.topicNames == null) {
            if (other.topicNames != null) return false;
        } else {
            if (!this.topicNames.equals(other.topicNames)) return false;
        }
        if (timeoutMs != other.timeoutMs) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (topicNames == null ? 0 : topicNames.hashCode());
        hashCode = 31 * hashCode + timeoutMs;
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "DeleteTopicsRequestData("
            + "topicNames=" + MessageUtil.deepToString(topicNames.iterator())
            + ", timeoutMs=" + timeoutMs
            + ")";
    }
    
    public List<String> topicNames() {
        return this.topicNames;
    }
    
    public int timeoutMs() {
        return this.timeoutMs;
    }
    
    public DeleteTopicsRequestData setTopicNames(List<String> v) {
        this.topicNames = v;
        return this;
    }
    
    public DeleteTopicsRequestData setTimeoutMs(int v) {
        this.timeoutMs = v;
        return this;
    }
}
