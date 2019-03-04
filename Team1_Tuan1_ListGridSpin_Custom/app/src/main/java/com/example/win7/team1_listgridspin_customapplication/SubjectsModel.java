package com.example.win7.team1_listgridspin_customapplication;

import java.util.ArrayList;

public class SubjectsModel {
    private static ArrayList<Subjects> arrSubjects = null;

    public static ArrayList<Subjects> getListSubjectsDemo() {
        if (arrSubjects == null) {
            SubjectsModel subjectsModel = new SubjectsModel();
            subjectsModel.init();
        }
        return arrSubjects;
    }

    private void init() {
        arrSubjects = new ArrayList<Subjects>();
        Subjects s1 = new Subjects("1","Lập trình Android");
        Subjects s2 = new Subjects("2","Lập trình C#");
        Subjects s3 = new Subjects("3","Lập trình web nâng cao");
        arrSubjects.add(s1);
        arrSubjects.add(s2);
        arrSubjects.add(s3);
    }
    public static Subjects getSubjectsByID(String idSubjects){
        for (Subjects s: arrSubjects) {
            if (s.getIdSubject().equalsIgnoreCase(idSubjects)){
                return s;
            }
        }
        return null;
    }
}
