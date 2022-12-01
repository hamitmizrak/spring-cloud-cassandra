package com.hamitmizrak.entity;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

//Lombok
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= {"id"})
@ToString
@Builder
@Log4j2

//Cassandra
@Table(value="accounts")
public class AccountCassandra implements Serializable {

    // cassandra: @PrimaryKey
    @PrimaryKey
    private String id= UUID.randomUUID().toString();

    // cassandra: @PrimaryKey
    @Column(value = "uname")
    @Setter
    private String username;

    @Column(value = "email")
    @Setter
    private String email;

    @Column(value = "passwd")
    @Setter
    private String passwd;

    @Column(value = "created_date")
    private Date createdDate;

    @Column(value = "is_active")
    private Boolean active;

    //just constructor id
    public AccountCassandra(String id) {
        this.id = id;
    }
}
