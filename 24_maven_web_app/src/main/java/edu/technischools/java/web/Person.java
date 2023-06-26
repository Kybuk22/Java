package edu.technischools.java.web;

public class Person {
    private String name;
    private int age;
    private boolean over18;

    public Person(String name, int age, boolean over18) {
        this.name = name;
        this.age = age;
        this.over18 = over18;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isOver18() {
        return over18;
    }

    public void setOver18(boolean over18) {
        this.over18 = over18;
    }

    public String toJSON() {
        return "{\"name\":\"" + name + "\",\"age\":" + age + ",\"over18\":" + over18 + "}";
    }
}