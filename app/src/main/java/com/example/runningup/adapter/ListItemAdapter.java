package com.example.runningup.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.runningup.R;

/**
 * Created by jack on 2016/5/26.
 */
public class ListItemAdapter extends BaseAdapter{

    int width;
    private ImageAdapter imageAdapter;
    private Context mContext;
    private boolean click = true;

    public  ListItemAdapter(Context mContext,ImageAdapter imageAdapter){
        super();
        this.mContext = mContext;
        //this.width = width;
        this.imageAdapter = imageAdapter;
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
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = View.inflate(mContext, R.layout.circle_item,null);
            viewHolder = new ViewHolder();

            viewHolder.user_headView = (ImageView) convertView.findViewById(R.id.user_headView);
            viewHolder.user_name = (TextView) convertView.findViewById(R.id.user_name);
            viewHolder.time = (TextView) convertView.findViewById(R.id.time);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.distance = (TextView) convertView.findViewById(R.id.distance);
            viewHolder.like = (TextView) convertView.findViewById(R.id.like);
            viewHolder.comment = (TextView) convertView.findViewById(R.id.comment);
            viewHolder.imageGridView = (GridView) convertView.findViewById(R.id.myView);
            viewHolder.likeimage = (ImageView)convertView.findViewById(R.id.dislikeimage);

            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.user_headView.setImageResource(R.mipmap.girl);
        viewHolder.user_name.setText("这是用户名");
        viewHolder.time.setText("这是时间");
        viewHolder.title.setText("这是标题");
        viewHolder.distance.setText("998km");
        viewHolder.like.setText("998个赞");
        viewHolder.comment.setText("998个评论");
        viewHolder.imageGridView.setAdapter(imageAdapter);


        final ViewHolder finalViewHolder = viewHolder;
        viewHolder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click){
                    finalViewHolder.likeimage.setImageResource(R.mipmap.like);
                    Toast.makeText(mContext,"已点赞",Toast.LENGTH_SHORT).show();
                    click= false;
                }else {
                    finalViewHolder.likeimage.setImageResource(R.mipmap.dislike);
                    Toast.makeText(mContext,"已取消点赞",Toast.LENGTH_SHORT).show();
                    click = true;
                }

            }
        });

        return convertView;
    }



    private class ViewHolder{
        ImageView user_headView,likeimage;
        TextView user_name,time,title,distance,like,comment;
        GridView imageGridView;
    }
}
