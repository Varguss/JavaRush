package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for(Student student : students)
            if(student.getAverageGrade() == averageGrade)
                return student;
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        if(students.size() == 0)
            return null;

        double maxAverageGrade = students.get(0).getAverageGrade();
        Student result = students.get(0);

        for(int i = 1; i < students.size(); i++)
            if(students.get(i).getAverageGrade() > maxAverageGrade) {
                maxAverageGrade = students.get(i).getAverageGrade();
                result = students.get(i);
            }

        return result;
    }

    public Student getStudentWithMinAverageGrade() {
        if(students.size() == 0)
            return null;

        double minAverageGrade = students.get(0).getAverageGrade();
        Student result = students.get(0);

        for(int i = 1; i < students.size(); i++)
            if(students.get(i).getAverageGrade() < minAverageGrade) {
                minAverageGrade = students.get(i).getAverageGrade();
                result = students.get(i);
            }

        return result;
    }

    public void expel(Student student) {
        if(students.contains(student))
            students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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
}