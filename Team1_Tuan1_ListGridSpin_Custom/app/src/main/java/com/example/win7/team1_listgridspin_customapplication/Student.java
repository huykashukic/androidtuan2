package com.example.win7.team1_listgridspin_customapplication;

import java.io.Serializable;

public class Student implements Serializable {
    String idStudent, nameStudent, IdSubjects;

    public Student() {
    }

    public Student(String idStudent, String nameStudent, String IdSubjects) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.IdSubjects = IdSubjects;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getSubjects() {
        return IdSubjects;
    }

    public void setSubjects(String IdSubjects) {
        this.IdSubjects = IdSubjects;
    }
}
