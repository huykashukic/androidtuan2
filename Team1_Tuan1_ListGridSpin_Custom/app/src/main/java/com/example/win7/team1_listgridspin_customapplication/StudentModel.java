package com.example.win7.team1_listgridspin_customapplication;

import java.util.ArrayList;

public class StudentModel {
    public static String[] name = new String[]{"Trần Thanh Thiên", "Nguyễn Thành Tài", "Nguyễn Trần Hoài Nam"};
    public static String[] id = new String[]{"16029541", "16029542", "16029543"};
    public static ArrayList<Subjects> arrsubjects;
    private static ArrayList<Student> ls = null;

    public static ArrayList<Student> getListStudentsDemo() {
        if (ls == null) {
            StudentModel studentModel = new StudentModel();
            studentModel.init();
        }
        return ls;
    }

    private void init() {
        arrsubjects = SubjectsModel.getListSubjectsDemo();
        ls = new ArrayList<Student>();
        for (int i = 0; i < name.length; i++) {
            Student c = new Student(id[i],name[i],arrsubjects.get(i).getIdSubject());
            ls.add(c);
        }
    }

    public static boolean addStudent(Student s) {
        if (s != null) {
            ls.add(s);
            return true;
        }
        return false;
    }

    public static boolean removeStudent(int i) {
        ls.remove(i);
        return true;
    }

    public static ArrayList<Student> updateStudent(int i, Student newS) {
        Student c = ls.get(i);
        c.setNameStudent(newS.getNameStudent());
        c.setSubjects(newS.getSubjects());
        return ls;
    }

    public  ArrayList<Student> getList() {
        return ls;
    }
}
