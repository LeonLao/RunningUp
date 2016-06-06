package com.example.runningup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.runningup.R;

/**
 * Created by jack on 2016/6/6.
 */
public class ImageAdapter extends BaseAdapter{

    private Context mContext;
    int width;

    public ImageAdapter(Context mContext,int width){
        super();
        this.mContext = mContext;
        this.width = width;
    }

    //封装组虚拟数据
    public int [] icon = {R.mipmap.girl,R.mipmap.girl,R.mipmap.girl,
            R.mipmap.girl,R.mipmap.girl,R.mipmap.girl,
            R.mipmap.girl,R.mipmap.girl, R.mipmap.girl};



    @Override
    public int getCount() {
        return icon.length;
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
        ViewHolder viewHolder = null;
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = View.inflate(mContext,R.layout.image_item,null);

            convertView.setLayoutParams(new AbsListView.LayoutParams((int)(parent.getWidth()/3)-1,(int)(parent.getWidth()/3) -1));

            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView)convertView.findViewById(R.id.image);

            convertView.setTag(viewHolder);
        }else {
            viewHolder =(ViewHolder)convertView.getTag();
            convertView.setLayoutParams(new AbsListView.LayoutParams((int)(parent.getWidth()/3)-1,(int)(parent.getWidth()/3) -1));
        }

        viewHolder.imageView.setBackgroundResource(icon[position]);

        return convertView;
    }

    private class ViewHolder{
        ImageView imageView;
    }

}
