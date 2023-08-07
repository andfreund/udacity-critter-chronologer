package com.udacity.jdnd.course3.critter.user;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

// using table per class inheritance since polymorphic queries are not expected
// and this inheritance type yields the best performance for non-polymorphic queries
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Nationalized
    private String name;
}
