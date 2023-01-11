package com.practice.simulationproblems;
/*
 * Click `Run` to execute the snippet below!
 */
import java.util.List;
import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public static void main(String[] args) {

        HashMap<Integer,Student> studentMap = new HashMap<>();
        Student ashley= new Student("Ashley",29,87, 4);
        Student milly = new Student("Milly",54,17,3.2);
        Student jordan = new Student("Jordan", 21,23, 1);
        Student rudy=  new Student("Rudy",45, 81, 2);


        // System.out.println("Ashley's age is "+  ashley.getAge());


        studentMap.put(ashley.getSSN(), ashley);
        studentMap.put(jordan.getSSN(), jordan);
        studentMap.put(rudy.getSSN(), rudy);
        studentMap.put(milly.getSSN(),milly);

        StudentTracker tracker = new StudentTracker(studentMap);

        double average = tracker.getAverageGPA();
        System.out.println("The average GPA is " + average);

    }


}


class Student {

    private String name;
    private int age;
    private int ssn;
    private double gpa;

    Student(String name, int age, int ssn, double gpa) {
        this.age = age;
        this.ssn = ssn;
        this.gpa = gpa;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public int getSSN() {
        return ssn;
    }

    public double getSingleGPA() {
        return gpa;
    }

    public String getName() {
        return name;
    }

}

class StudentTracker {
    private HashMap<Integer, Student> ssnMap;

    StudentTracker(HashMap<Integer, Student> ssnMap) {
        this.ssnMap = ssnMap;
    }

    public Student getStudent(int ssn) {
        return ssnMap.get(ssn);
    }

    public double getAverageGPA() {
        double allGrades = 0;
        int entries = ssnMap.size();
        for (Map.Entry<Integer, Student> i : ssnMap.entrySet()) {
            allGrades += i.getValue().getSingleGPA();
        }
        return allGrades / entries;
    }
//    public ArrayList<Student> getStudentsInOrderOfGPA(HashMap<Integer,Student> ssnMap){
//        //What I need to be able to retrieve: Student, along with their GPA
//        //If i pass in the HashMap, I could iterate through it and get the student object.
//        //How can it know what an Entry data type is? Is that built in?
//        Set<Map.Entry<Integer,Student>> entrySet= ssnMap.entrySet();
//
//     List<Student> studentList = new ArrayList<>();
//     for(Map.Entry<Integer, Student> i: ssnMap.entrySet()){
//         studentList.add(i.getValue() );
//     }
//
//    return  Collections.sort(studentList);
//
//
//
//    }


}
