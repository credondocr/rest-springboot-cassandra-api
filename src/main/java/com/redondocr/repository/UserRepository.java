package com.redondocr.repository;

import com.redondocr.domain.User;
import org.springframework.data.cassandra.repository.CassandraRepository;

/**
 * Created by credondo on 6/17/16.
 */
public interface UserRepository extends CassandraRepository<User> {
}
