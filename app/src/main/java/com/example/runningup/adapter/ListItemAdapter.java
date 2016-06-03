package com.example.runningup.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jack on 2016/5/26.
 */
public class ListItemAdapter extends BaseAdapter{
    private Context mContext;




    public  ListItemAdapter(Context mContext){
        super();
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }


    private class ViewHolder{
        ImageView user_headView;
        TextView user_name,time,title,distance,like,comment;
        GridView imageGridView;
    }
}
