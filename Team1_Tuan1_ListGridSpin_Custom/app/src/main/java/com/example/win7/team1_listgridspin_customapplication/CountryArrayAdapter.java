package com.example.win7.team1_listgridspin_customapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryArrayAdapter extends BaseAdapter {
    Context myContext;
    int myLayout;
    List<Country> myLstCountry;

    public CountryArrayAdapter(Context myContext, int myLayout, List<Country> myLstCountry) {
        this.myContext = myContext;
        this.myLayout = myLayout;
        this.myLstCountry = myLstCountry;
    }


    @Override
    public int getCount() {
        return myLstCountry.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            LayoutInflater inflater = (LayoutInflater)myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(myLayout,null);
            holder = new ViewHolder();
            holder.tv_cus = view.findViewById(R.id.tv_cus1);
            holder.img_cus = view.findViewById(R.id.img_cus1);
            view.setTag(holder);
        }else holder = (ViewHolder)view.getTag();
        //gan gia tri lai cho List Country
        holder.tv_cus.setText(myLstCountry.get(i).getNameCountry());
        holder.img_cus.setImageResource(myLstCountry.get(i).getImg_id());

        return view;
    }
    private class ViewHolder{
        private TextView tv_cus;
        private ImageView img_cus;
    }
}
