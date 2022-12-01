package com.hamitmizrak.repository;

import com.hamitmizrak.entity.AccountCassandra;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
//@EnableCassandraRepositories
public interface AccountRepository extends CassandraRepository<AccountCassandra,String> {
}
