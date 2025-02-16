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

package org.apache.shardingsphere.mode.node.path.metadata;

/**
 * Database node path generator.
 */
public final class DatabaseNodePathGenerator {
    
    private static final String ROOT_NODE = "/metadata";
    
    /**
     * Get database root path.
     *
     * @return schema root path
     */
    public String getRootPath() {
        return ROOT_NODE;
    }
    
    /**
     * Get database path.
     *
     * @param databaseName database name
     * @return database path
     */
    public String getDatabasePath(final String databaseName) {
        return String.join("/", ROOT_NODE, databaseName);
    }
}
