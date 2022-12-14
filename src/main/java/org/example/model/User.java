package org.example.model;

import org.example.enums.Status;

public class User implements Comparable<User>{
    private String name;
    private int age;
    private Status status;

    public User(String name, int age, Status status) {
        this.name = name;
        this.age = age;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", status=" + status +
                '}';
    }

    @Override
    public int compareTo(User o) {
        if(this.getStatus().equals(Status.TEACHER) && (o.getStatus().equals(Status.SENIOR_STUDENT) || o.getStatus().equals(Status.JUNIOR_STUDENT))) {
            return 1;
        } else if (this.getStatus().equals(Status.SENIOR_STUDENT) && (o.getStatus().equals(Status.TEACHER) || o.getStatus().equals(Status.JUNIOR_STUDENT))) {
            return 1;
        } else {
            return 1;
        }
    }
}
