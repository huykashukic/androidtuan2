package com.example.win7.team1_listgridspin_customapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class CustomListViewActivity extends AppCompatActivity {
    EditText edtIdStudent,edtNameStudent;
    ListView listView1;
    Spinner spnSubjects;

    ArrayList<Student> ls;
    StudentArrayAdapter arrayAdapterLs;

    ArrayList<Subjects> arraySubjects;
    ArrayAdapter<Subjects> adapterSubjects;

    int clickPosition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        edtNameStudent = (EditText) findViewById(R.id.edt_nameStudent);
        edtIdStudent = (EditText) findViewById(R.id.edt_idStudent);
        spnSubjects = (Spinner)findViewById(R.id.spn_subjects);
        listView1 = (ListView) findViewById(R.id.listView1);

        arraySubjects = SubjectsModel.getListSubjectsDemo();
        adapterSubjects = new ArrayAdapter<Subjects>(this,R.layout.support_simple_spinner_dropdown_item,arraySubjects);
        spnSubjects.setAdapter(adapterSubjects);


        ls = StudentModel.getListStudentsDemo();
        arrayAdapterLs = new StudentArrayAdapter(this,R.layout.layout_cus_listview,ls);
        listView1.setAdapter(arrayAdapterLs);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clickPosition = position;
                Student s = ls.get(position);
                edtNameStudent.setText(s.getNameStudent());
                edtIdStudent.setText(s.getIdStudent());
                Subjects subjects = SubjectsModel.getSubjectsByID(s.getSubjects());
                spnSubjects.setSelection(arraySubjects.indexOf(subjects));

            }
        });
    }

    public void btnThem(View view) {
        if (!edtNameStudent.getText().toString().isEmpty() && !edtIdStudent.getText().toString().isEmpty()){

            Student c = new Student();
            c.setNameStudent(edtNameStudent.getText().toString());
            c.setIdStudent(edtIdStudent.getText().toString());
            Subjects subjects = (Subjects) spnSubjects.getSelectedItem();
            c.setSubjects(subjects.getIdSubject());

            if (StudentModel.addStudent(c))
                arrayAdapterLs.notifyDataSetChanged();

        }else {
            Toast.makeText(CustomListViewActivity.this,"Chưa đủ nhập nội dung",Toast.LENGTH_SHORT).show();
        }
    }

    public void btnSua(View view) {
        if (clickPosition < 0 ){
            Toast.makeText(CustomListViewActivity.this,"Chưa chọn item muốn sửa!",Toast.LENGTH_SHORT).show();
            return;
        }
        Student s = new Student();
        s.setNameStudent(edtNameStudent.getText().toString());
        Subjects subjects = (Subjects) spnSubjects.getSelectedItem();
        s.setSubjects(subjects.getIdSubject());
        StudentModel.updateStudent(clickPosition,s);
        arrayAdapterLs.notifyDataSetChanged();
        Toast.makeText(CustomListViewActivity.this,"Cập nhật thành công!",Toast.LENGTH_SHORT).show();
    }

    public void btnXoa(View view) {
        if (clickPosition < 0 ){
            Toast.makeText(CustomListViewActivity.this,"Chưa chọn item muốn xóa!",Toast.LENGTH_SHORT).show();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Bạn có chắc muốn xóa?");
        builder.setNegativeButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StudentModel.removeStudent(clickPosition);
                arrayAdapterLs.notifyDataSetChanged();
                clickPosition = -1;
                edtNameStudent.setText("");
                edtIdStudent.setText("");
                spnSubjects.setSelection(0);
            }
        });
       builder.setPositiveButton("Hủy", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               dialog.dismiss();
           }
       });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
