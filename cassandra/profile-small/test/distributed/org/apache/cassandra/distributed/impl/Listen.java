/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.cassandra.distributed.impl;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;
import org.apache.cassandra.distributed.api.IListen;

public class Listen implements IListen
{
    final Instance instance;
    public Listen(Instance instance)
    {
        this.instance = instance;
    }

    public Cancel schema(Runnable onChange)
    {
        final AtomicBoolean cancel = new AtomicBoolean();
        instance.isolatedExecutor.execute(() -> {
            UUID prev = instance.schemaVersion();
            while (true)
            {
                if (cancel.get())
                    return;

                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(10L));

                UUID cur = instance.schemaVersion();
                if (!prev.equals(cur))
                    onChange.run();
                prev = cur;
            }
        });
        return () -> cancel.set(true);
    }
}
