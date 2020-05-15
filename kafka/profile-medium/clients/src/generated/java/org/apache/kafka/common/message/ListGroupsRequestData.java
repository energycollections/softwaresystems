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

import org.apache.kafka.common.protocol.ApiMessage;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Struct;


public class ListGroupsRequestData implements ApiMessage {
    
    public static final Schema SCHEMA_0 =
        new Schema(
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2
    };
    
    public ListGroupsRequestData(Readable readable, short version) {
        read(readable, version);
    }
    
    public ListGroupsRequestData(Struct struct, short version) {
        fromStruct(struct, version);
    }
    
    public ListGroupsRequestData() {
    }
    
    @Override
    public short apiKey() {
        return 16;
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
    }
    
    @Override
    public void write(Writable writable, short version) {
    }
    
    @Override
    public void fromStruct(Struct struct, short version) {
    }
    
    @Override
    public Struct toStruct(short version) {
        Struct struct = new Struct(SCHEMAS[version]);
        return struct;
    }
    
    @Override
    public int size(short version) {
        int size = 0;
        return size;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ListGroupsRequestData)) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        return hashCode;
    }
    
    @Override
    public String toString() {
        return "ListGroupsRequestData("
            + ")";
    }
}
