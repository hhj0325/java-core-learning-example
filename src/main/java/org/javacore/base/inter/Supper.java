package org.javacore.base.inter;

/**
 * Created by huhaojian on 2018/9/11 0011.
 */
public class Supper implements Comparable<Supper> {
    private int age ;
    private String name ;

    public Supper() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int privateRetAge(){
        return age;
    }

    int nullRetAge(){
        return age;
    }

    protected int protectedRetAge(){
        return age;
    }

    public int publicRetAge(){
        return age;
    }


    @Override
    public int compareTo(Supper o) {
        return Integer.compare(age, o.getAge());
    }
}
