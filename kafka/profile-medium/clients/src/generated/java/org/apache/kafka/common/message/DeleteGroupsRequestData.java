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


public class DeleteGroupsRequestData implements ApiMessage {
    private List<String> groupsNames;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("groups_names", new ArrayOf(Type.STRING), "The group names to delete.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public DeleteGroupsRequestData(Readable readable, short version) {
        this.groupsNames = new ArrayList<String>();
        read(readable, version);
    }
    
    public DeleteGroupsRequestData(Struct struct, short version) {
        this.groupsNames = new ArrayList<String>();
        fromStruct(struct, version);
    }
    
    public DeleteGroupsRequestData() {
        this.groupsNames = new ArrayList<String>();
    }
    
    @Override
    public short apiKey() {
        return 42;
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
        {
            int arrayLength = readable.readInt();
            if (arrayLength < 0) {
                this.groupsNames.clear();
            } else {
                this.groupsNames.clear();
                for (int i = 0; i < arrayLength; i++) {
                    this.groupsNames.add(readable.readNullableString());
                }
            }
        }
    }
    
    @Override
    public void write(Writable writable, short version) {
        writable.writeInt(groupsNames.size());
        for (String element : groupsNames) {
            writable.writeString(element);
        }
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
        {
            Object[] nestedObjects = struct.getArray("groups_names");
            this.groupsNames = new ArrayList<String>(nestedObjects.length);
            for (Object nestedObject : nestedObjects) {
                this.groupsNames.add((String) nestedObject);
            }
        }
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        {
            String[] nestedObjects = new String[groupsNames.size()];
            int i = 0;
            for (String element : this.groupsNames) {
                nestedObjects[i++] = element;
            }
            struct.set("groups_names", (Object[]) nestedObjects);
        }
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        size += 4;
        for (String element : groupsNames) {
            size += 2;
            size += MessageUtil.serializedUtf8Length(element);
        }
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DeleteGroupsRequestData)) return false;
        DeleteGroupsRequestData other = (DeleteGroupsRequestData) obj;
        if (this.groupsNames == null) {
            if (other.groupsNames != null) return false;
        } else {
            if (!this.groupsNames.equals(other.groupsNames)) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (groupsNames == null ? 0 : groupsNames.hashCode());
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "DeleteGroupsRequestData("
            + "groupsNames=" + MessageUtil.deepToString(groupsNames.iterator())
            + ")";
    }
    
    public List<String> groupsNames() {
        return this.groupsNames;
    }
    
    public DeleteGroupsRequestData setGroupsNames(List<String> v) {
        this.groupsNames = v;
        return this;
    }
}
