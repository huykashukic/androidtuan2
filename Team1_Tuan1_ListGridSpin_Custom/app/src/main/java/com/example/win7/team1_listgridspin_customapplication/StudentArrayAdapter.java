package com.example.win7.team1_listgridspin_customapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StudentArrayAdapter extends ArrayAdapter<Student> {
    Context context;
    int idLayout;
    ArrayList<Student> arrayStudent;

    public StudentArrayAdapter(Context context, int resource, ArrayList<Student> objects) {
        super(context, resource, objects);
        this.context=context;
        this.idLayout=resource;
        this.arrayStudent = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_cus_listview,null);
            holder = new ViewHolder();
            holder.tvIdStudent = convertView.findViewById(R.id.tv_idStudent);
            holder.tvNameStudent = convertView.findViewById(R.id.tv_nameStudent);
            holder.tvSubjects = convertView.findViewById(R.id.tv_subjects);
            holder.imgStudent = convertView.findViewById(R.id.img_student);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvIdStudent.setText(arrayStudent.get(position).getIdStudent());
        Subjects subjects = SubjectsModel.getSubjectsByID(arrayStudent.get(position).getSubjects());
        holder.tvSubjects.setText(subjects.getNameSubject());
        holder.tvNameStudent.setText(arrayStudent.get(position).getNameStudent());
        holder.imgStudent.setImageResource(R.drawable.icon);
        return convertView;
    }
    public class ViewHolder {
        TextView tvIdStudent, tvNameStudent, tvSubjects;
        ImageView imgStudent;
    }
}
