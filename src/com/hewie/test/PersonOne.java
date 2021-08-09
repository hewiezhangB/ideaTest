package com.hewie.test;

public class PersonOne implements Comparable<PersonOne> {

    private String name;
    private Integer age;

    public PersonOne() {

    }
    public PersonOne(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(PersonOne o) {
        //正序
//        return age.compareTo(o.getAge());
        //倒序
        return o.getAge().compareTo(age);
    }
}
