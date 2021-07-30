package com.nordbank.jpamysql.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String firstName;

    private String lastName;
}

