package com.hewie.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author hewie
 * */
public class PersonTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("A",12));
        list.add(new Person("B",11));
        list.add(new Person("C",6));
        list.add(new Person("D",26));
        list.add(new Person("E",59));
        list.add(new Person("F",36));
        list.add(new Person("G",2));
        for (Person person : list) {
            System.out.println(person.getAge());
        }
        System.out.println("-----------------------------");
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
//                return o1.getAge().compareTo(o2.getAge());
                //倒叙
                return o2.getAge().compareTo(o1.getAge());
            }
        });
        for (Person person : list) {
            System.out.println(person.getAge());
        }

        System.out.println("***********************************");

        List<PersonOne> perList = new ArrayList<PersonOne>();
        perList.add(new PersonOne("A",13));
        perList.add(new PersonOne("B",3));
        perList.add(new PersonOne("C",92));
        perList.add(new PersonOne("D",23));
        perList.add(new PersonOne("E",22));
        perList.add(new PersonOne("F",8));
        perList.add(new PersonOne("G",55));
        perList.add(new PersonOne("H",19));

        for (PersonOne personOne:perList) {
            System.out.println(personOne.getAge());
        }

        System.out.println("-----------------------");
        Collections.sort(perList);

        for (PersonOne per:perList) {
            System.err.println(per.getAge());
        }

//        List<Person> list = new ArrayList<Person>();
//        list.add(new Person("E", 16));
//        list.add(new Person("C", 14));
//        list.add(new Person("A", 12));
//        list.add(new Person("B", 13));
//        list.add(new Person("D", 15));
//        for (Person person : list) {
//            System.out.println(person.getAge());
//        }
//        System.out.println("####################");
//        Collections.sort(list);
//        for (Person person : list) {
//            System.out.println(person.getAge());
//        }
    }
}
