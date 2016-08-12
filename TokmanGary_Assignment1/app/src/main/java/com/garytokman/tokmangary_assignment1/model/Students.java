package com.garytokman.tokmangary_assignment1.model;

import com.garytokman.tokmangary_assignment1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gtokman1 on 8/12/16.
 */
public class Students {
    public static List<Person> getStudents() {

        List<Person> students = new ArrayList<>();

        students.add(new Person("Sean Fowler", 22, R.drawable.person1));
        students.add(new Person("Donald Simmons", 25, R.drawable.person2));
        students.add(new Person("Tyler Alexander", 32, R.drawable.person3));
        students.add(new Person("Roy Elliott", 23, R.drawable.person4));
        students.add(new Person("Henry Diaz", 29, R.drawable.person5));

        students.add(new Person("Shirley Fox", 27, R.drawable.person6));
        students.add(new Person("Judith Cox", 28, R.drawable.person7));
        students.add(new Person("Karen Tucker", 33, R.drawable.person8));
        students.add(new Person("Barbara Sanchez", 22, R.drawable.person9));
        students.add(new Person("Margaret Adams", 21, R.drawable.person10));

        return students;
    }
}
