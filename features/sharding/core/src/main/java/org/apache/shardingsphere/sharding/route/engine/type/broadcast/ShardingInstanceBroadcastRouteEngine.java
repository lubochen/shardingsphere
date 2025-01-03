/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.sharding.route.engine.type.broadcast;

import lombok.RequiredArgsConstructor;
import org.apache.shardingsphere.infra.metadata.database.resource.ResourceMetaData;
import org.apache.shardingsphere.infra.route.context.RouteContext;
import org.apache.shardingsphere.infra.route.context.RouteMapper;
import org.apache.shardingsphere.infra.route.context.RouteUnit;
import org.apache.shardingsphere.sharding.route.engine.type.ShardingRouteEngine;
import org.apache.shardingsphere.sharding.rule.ShardingRule;

import java.util.Collections;

/**
 * Sharding broadcast route engine for database instance.
 */
@RequiredArgsConstructor
public final class ShardingInstanceBroadcastRouteEngine implements ShardingRouteEngine {
    
    private final ResourceMetaData resourceMetaData;
    
    @Override
    public RouteContext route(final ShardingRule shardingRule) {
        RouteContext result = new RouteContext();
        for (String each : shardingRule.getDataSourceNames()) {
            if (resourceMetaData.getAllInstanceDataSourceNames().contains(each)) {
                result.getRouteUnits().add(new RouteUnit(new RouteMapper(each, each), Collections.emptyList()));
            }
        }
        return result;
    }
}
