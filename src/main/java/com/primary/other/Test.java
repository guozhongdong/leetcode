package com.primary.other;

/**
 * @author gzd
 * @create 2018-06-11 22:02
 * @desc
 **/
public class Test {

    public void test(){
        Student s = new Student();
        s.id = "1";
        s.name="hello";
        System.out.println(s);
        test1(s);
    }

    private void test1(Student student) {


        //Lock lock = new
        //System.out.println(student);
    }
    public static void main(String[] args){
       new Test().test();
    }
}
