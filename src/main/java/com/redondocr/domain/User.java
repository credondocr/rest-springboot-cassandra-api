package com.redondocr.domain;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Set;

/**
 * Created by credondo on 6/17/16.
 */

@Table
public class User {

    @PrimaryKeyColumn(name = "userid", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String userid;
    @Column
    private Set<String> emails;
    @Column
    private String first_name;
    @Column
    private String last_name;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
