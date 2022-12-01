-- CQL: Cassandra Query Language
-- schema
CREATE KEYSPACE springbootcloud WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

-- Aktif Schema seçmek
use springbootcloud;

-- table
CREATE TABLE emp(
    emp_id int PRIMARY KEY,
    emp_name text,
    emp_city text,
    emp_sal varint,
    emp_phone varint
);

select * from emp;