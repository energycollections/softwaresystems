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


public class DescribeGroupsRequestData implements ApiMessage {
    private List<String> groups;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("groups", new ArrayOf(Type.STRING), "The names of the groups to describe")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2
    };
    
    public DescribeGroupsRequestData(Readable readable, short version) {
        this.groups = new ArrayList<String>();
        read(readable, version);
    }
    
    public DescribeGroupsRequestData(Struct struct, short version) {
        this.groups = new ArrayList<String>();
        fromStruct(struct, version);
    }
    
    public DescribeGroupsRequestData() {
        this.groups = new ArrayList<String>();
    }
    
    @Override
    public short apiKey() {
        return 15;
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
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.groups.clear();
            } else {
                this.groups.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.groups.add(readable.readNullableString());
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(groups.size());
        for (String element : groups) {
            writable.writeString(element);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        {
            Object[] nestedObjects = struct.getArray("groups");
            this.groups = new ArrayList<String>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.groups.add((String) nestedObject);
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        {
            String[] nestedObjects = new String[groups.size()];
            int i = 0;
            for (String element : this.groups) {
                nestedObjects[i++] = element;
            }
            struct.set("groups", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        for (String element : groups) {
            size += 2;
            size += MessageUtil.serializedUtf8Length(element);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DescribeGroupsRequestData)) return false;
        DescribeGroupsRequestData other = (DescribeGroupsRequestData) obj;
        if (this.groups == null) {
            if (other.groups != null) return false;
        } else {
            if (!this.groups.equals(other.groups)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (groups == null ? 0 : groups.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "DescribeGroupsRequestData("
            + "groups=" + MessageUtil.deepToString(groups.iterator())
            + ")";
    }
    
    public List<String> groups() {
        return this.groups;
    }
    
    public DescribeGroupsRequestData setGroups(List<String> v) {
        this.groups = v;
        return this;
    }
}
