package com.garytokman.tokmangary_ce06.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gtokman1 on 8/11/16.
 */
public class People {
    public static List<Person> getPeople() {

        List<Person> people = new ArrayList<>();

        people.add(new Person("Gary", "Tokman", "11/07/94", 1));


        return people;
    }
}
