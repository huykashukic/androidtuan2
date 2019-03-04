package com.example.win7.team1_listgridspin_customapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Click_CusListView(View view) {
        Intent it = new Intent(MainActivity.this,CustomListViewActivity.class);
        startActivity(it);
    }

    public void Click_CusSpin(View view) {
        Intent it = new Intent(MainActivity.this,CustomSpinnerActivity.class);
        startActivity(it);
    }
}
