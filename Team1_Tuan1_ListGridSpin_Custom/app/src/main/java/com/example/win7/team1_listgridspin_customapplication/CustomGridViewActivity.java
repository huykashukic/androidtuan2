package com.example.win7.team1_listgridspin_customapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;


public class CustomGridViewActivity extends AppCompatActivity {
    EditText edt_nameCountry;
    GridView grid_1;
    ArrayList<Country> ls;
    CountryArrayAdapter arrayAdapterLs;

    int vitri = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_grid_view);
        //Anh Xa
        AnhXa();

        /*Cách 1*/
        ls = CountryModel.getListCountriesDemo();
        arrayAdapterLs = new CountryArrayAdapter(CustomGridViewActivity.this,R.layout.layout_cus_grid,ls);
        grid_1.setAdapter(arrayAdapterLs);

        //Dang ki su kien click tren GridView
        grid_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Country c = ls.get(i);
                edt_nameCountry.setText(c.getNameCountry().toString());
                vitri = i ;
                Log.d("kq", i+"");
            }
        });

    }
    void AnhXa(){
        edt_nameCountry = findViewById(R.id.edt_nameCountry);
        grid_1 = findViewById(R.id.grid_1);
    }
    public void btnThem(View view) {
        String s = edt_nameCountry.getText().toString();
        if(s.length()==0){
            Toast.makeText(CustomGridViewActivity.this,"Ban Khong Duoc Bo Trong Noi Dung",Toast.LENGTH_LONG).show();
            return;
        }
        Country c = new Country();
        c.setNameCountry(s);
        c.setImg_id(R.drawable.ic_flag_vietnam);
        if(ls.contains(c)){
            Toast.makeText(CustomGridViewActivity.this,"Ban Khong Duoc Nhap Trùng Noi Dung",Toast.LENGTH_LONG).show();
            return;
        }
        Boolean kq = CountryModel.addCountry(c);
        if (kq)
            arrayAdapterLs.notifyDataSetChanged();
    }

    public void btnXoa(View view) {
        if(vitri<0){
            Toast.makeText(CustomGridViewActivity.this,"Bạn Phải Chọn GridView Cần Xóa",Toast.LENGTH_LONG).show();
            return;
        }
        Boolean kq = CountryModel.removeCountry(vitri);
        if (kq)
            arrayAdapterLs.notifyDataSetChanged();
        vitri = -1;
    }

    public void btnSua(View view) {
        if(vitri<0){
            Toast.makeText(CustomGridViewActivity.this,"Bạn Phải Chọn GridView Cần Sửa",Toast.LENGTH_LONG).show();
            return;
        }

        ls = CountryModel.updateCountry(vitri,R.drawable.ic_flag_indonesia);
        arrayAdapterLs.notifyDataSetChanged();
        Toast.makeText(CustomGridViewActivity.this,"Cập Nhật Thành Công",Toast.LENGTH_LONG).show();
        vitri=-1;
    }
}
