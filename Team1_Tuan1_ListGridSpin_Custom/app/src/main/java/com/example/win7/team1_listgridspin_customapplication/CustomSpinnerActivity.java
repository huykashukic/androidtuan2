package com.example.win7.team1_listgridspin_customapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomSpinnerActivity extends AppCompatActivity {
    EditText edt_nameCountry;
    Spinner spin_1;
    ArrayList<Country> ls;
    CountryArrayAdapter arrayAdapterLs = null;

    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_spinner);
        anhxa();
        //ls = CountryModel.getListCountriesDemo();
        ls= new ArrayList<Country>();
        ls.add(new Country("Viet Nam",R.drawable.ic_flag_vietnam));
        //ls.add(new Country("Laos",R.drawable.ic_flag_laos));


        arrayAdapterLs = new CountryArrayAdapter( CustomSpinnerActivity.this,R.layout.layout_cus_spinner,ls);
        spin_1.setAdapter(arrayAdapterLs);

        spin_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                vitri = i;
                Country c = ls.get(i);
                edt_nameCountry.setText(c.getNameCountry());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    void anhxa() {
        edt_nameCountry = findViewById(R.id.edt_nameCountry);
        spin_1 = findViewById(R.id.sp_Country);
    }

    public void Add(View view) {
        String data = edt_nameCountry.getText().toString();
        for (int i = 0; i < data.length(); i++) {
            if (Character.isLetter(data.charAt(i))) {
                Country c = new Country();
                c.setNameCountry(edt_nameCountry.getText().toString());
                c.setImg_id(R.drawable.ic_flag_vietnam);

                //if (CountryModel.addCountry(c))
                if(ls.contains(c)){
                    Toast.makeText(CustomSpinnerActivity.this,"Ban Khong Duoc Nhap Trùng Noi Dung",Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    ls.add(c);
                    arrayAdapterLs.notifyDataSetChanged();
                    Toast.makeText(CustomSpinnerActivity.this,"Them thanh cong",Toast.LENGTH_LONG).show();
                }
                break;

            }else {
                Toast.makeText(CustomSpinnerActivity.this,"Nhập nội dung là chữ",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void Delete(View view) {
        if (vitri < 0 ){
            Toast.makeText(CustomSpinnerActivity.this,"Chưa chọn item muốn xóa!",Toast.LENGTH_SHORT).show();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Bạn có chắc muốn xóa?");
        builder.setNegativeButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //CountryModel.removeCountry(vitri);
                ls.remove(vitri);
                arrayAdapterLs.notifyDataSetChanged();
                vitri = -1;
                edt_nameCountry.setText("");
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

    public void Modify(View view) {
        if (vitri < 0 ){
            Toast.makeText(CustomSpinnerActivity.this,"Chưa chọn item muốn sửa!",Toast.LENGTH_SHORT).show();
            return;
        }
        //CountryModel.updateCountry(vitri,R.drawable.ic_flag_indonesia);
        Country cmod = ls.get(vitri);
        cmod.setNameCountry(edt_nameCountry.getText().toString());
        arrayAdapterLs.notifyDataSetChanged();
        Toast.makeText(CustomSpinnerActivity.this,"Cập nhật thành công!",Toast.LENGTH_SHORT).show();
    }
}
