package com.garytokman.tokmangary_ce06.model;

import com.garytokman.tokmangary_ce06.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gtokman1 on 8/11/16.
 */
public class People {
    public static List<Person> getPeople() {

        List<Person> people = new ArrayList<>();

        people.add(new Person("Bob", "Smith", "11/07/94", R.drawable.person1));
        people.add(new Person("Sam", "Johnson", "11/07/95", R.drawable.person2));
        people.add(new Person("Ryan", "Gorton", "11/07/64", R.drawable.person3));
        people.add(new Person("Joe", "Dimmie", "11/07/84", R.drawable.person4));
        people.add(new Person("Rex", "Jorn", "11/07/84", R.drawable.person5));
        people.add(new Person("Tom", "Jordan", "11/07/94", R.drawable.person6));
        people.add(new Person("Jake", "Bryant", "11/07/95", R.drawable.person7));
        people.add(new Person("Aaron", "Pepi", "11/07/54", R.drawable.person8));
        people.add(new Person("Jame", "Juan", "11/07/96", R.drawable.person9));
        people.add(new Person("Jim", "James", "11/07/98", R.drawable.person10));

        return people;
    }
}
