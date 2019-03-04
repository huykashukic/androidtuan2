package com.example.win7.team1_listgridspin_customapplication;

public class Subjects {
    String idSubject, nameSubject;

    public Subjects() {
    }

    public Subjects(String idSubject, String nameSubject) {
        this.idSubject = idSubject;
        this.nameSubject = nameSubject;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    @Override
    public String toString() {
        return getNameSubject();
    }
}

