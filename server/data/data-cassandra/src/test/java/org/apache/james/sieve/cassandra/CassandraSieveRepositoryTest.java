/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.james.sieve.cassandra;

import org.apache.james.backends.cassandra.CassandraCluster;
import org.apache.james.sieverepository.api.SieveRepository;
import org.apache.james.sieverepository.lib.AbstractSieveRepositoryTest;

public class CassandraSieveRepositoryTest extends AbstractSieveRepositoryTest {
    private CassandraCluster cassandra;

    public CassandraSieveRepositoryTest() {
        cassandra = CassandraCluster.create(new CassandraSieveRepositoryModule());
    }

    @Override
    protected SieveRepository createSieveRepository() throws Exception {
        return new CassandraSieveRepository(cassandra.getConf());
    }

    @Override
    protected void cleanUp() throws Exception {
        cassandra.clearAllTables();
    }
}