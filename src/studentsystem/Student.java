package studentsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String id;
    private String name;
    private int age;


    public Student() {
    }

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        int len = name.length();
        if(len < 2 || len >15){
            throw new NameFormatException(name + "格式有误，长度应该为3~15");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 17 || age >30){
            throw new NumberOutException(age + "范围有误，范围应该是17~30");
        }
        this.age = age;
    }

    public String toString() {
        return "Student{id = " + id + ", name = " + name + ", age = " + age + "}";
    }

}
