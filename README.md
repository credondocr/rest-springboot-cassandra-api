# Rest Springboot API with cassandra 

##Cassandra docker image##

[Casandra docker document](https://hub.docker.com/r/poklet/cassandra/)


##Technology Stack##
* Java 8
* Spring Framework
* Cassandra

##TODO##
* Implement Swagger and basic ui for showing the rest implementation in a real life.
* Unit Test

##Create Scheme##

create keyspace example with replication = {'class':'SimpleStrategy', 'replication_factor':1}

##Create Table##
CREATE TABLE user (   userid text PRIMARY KEY,   first_name text,   last_name text,   emails set<text>, );
