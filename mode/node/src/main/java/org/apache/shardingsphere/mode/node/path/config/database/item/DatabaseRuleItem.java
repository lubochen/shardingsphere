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

package org.apache.shardingsphere.mode.node.path.config.database.item;

/**
 * Database rule item.
 */
public final class DatabaseRuleItem {
    
    private final String itemType;
    
    private final String itemName;
    
    public DatabaseRuleItem(final String value) {
        String[] values = value.split("/");
        if (1 == values.length) {
            itemType = values[0];
            itemName = null;
        } else {
            itemType = values[0];
            itemName = values[1];
        }
    }
    
    @Override
    public String toString() {
        return null == itemName ? itemType : String.join("/", itemType, itemName);
    }
}
