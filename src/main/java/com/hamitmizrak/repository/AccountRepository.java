package com.hamitmizrak.repository;

import com.hamitmizrak.entity.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.stereotype.Repository;

@Repository
//@EnableCassandraRepositories
public interface AccountRepository extends CassandraRepository<Account,String> {
}
