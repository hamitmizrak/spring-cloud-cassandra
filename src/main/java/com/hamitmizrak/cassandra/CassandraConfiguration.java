package com.hamitmizrak.cassandra;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

//Cassandra: spring initial
@Configuration
@EnableCassandraRepositories(basePackages = {"com.hamitmizrak"})
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Value("${spring.cloud.cassandra.keyspace.name}")
    private String cassandraKeyspaceData;

    @Value("${spring.cloud.cassandra.port}")
    private int cassandraPort;

    @Value("${spring.cloud.cassandra.contact.point}")
    private String cassandraPoint;

    @Value("${spring.cloud.cassandra.username}")
    private String username;

    @Value("${spring.cloud.cassandra.password}")
    private String password;

    //Overrides
    @Override
    protected String getKeyspaceName() {
        return cassandraKeyspaceData;
    }

    @Override
    protected int getPort() {
        return cassandraPort;
    }

    @Override
    protected String getContactPoints() {
        return cassandraPoint;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        //CqlSession session = CqlSession.builder() .build();
        return new String[]{"com.hamitmizrak"};
    }

    //username password
    @Bean
    @Override
    public CqlSessionFactoryBean cassandraSession() {
        CqlSessionFactoryBean cassandraSession = super.cassandraSession();//super session should be called only once
        cassandraSession.setUsername(username);
        cassandraSession.setPassword(password);
        return cassandraSession;
    }
}
