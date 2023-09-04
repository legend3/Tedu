package day05;

import java.util.Objects;

/**
 * CLassName: day05/Person
 * Description:
 * Copyright:   Copyright (c)2023
 *
 * @author: LEGEND
 * @version: 1.0
 * Create at:   2023/8/22 0:46
 * <p>
 * Modification History:
 * Date                 Author      Version     Description
 * ------------------------------------------------------------------
 * 2023/8/22 0:46      LEGEND        1.0         1.0 Version
 */
public class Person2 implements Comparable<Person2>{
    private String name;
    private int age;
    private String gender;

    Person2() {

    }

    public Person2(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private volatile int hasCode;
    @Override
    public int hashCode() {
        int result = hasCode;
        if(result == 0) {
            result = name.hashCode();
            result = 31 * result + Integer.hashCode(age);
            result = 31 * result + gender.hashCode();
            hasCode = result;
        }
        return hasCode;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person2 obj) {
        Person2 p = (Person2) obj;
        System.out.println(this+" compareTo:"+p);
        if (this.age > p.age) {
            return 1;
        }
        if (this.age < p.age) {
            return -1;
        }
        return this.name.compareTo(p.name);
    }
}
