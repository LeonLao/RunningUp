package com.example.runningup;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.PipedReader;

/**
 * Created by jack on 2016/4/13.
 */
public class SportsCircleActivity extends Activity{

    private ListView listView ;
    private MyAdapter adapter = new MyAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sport_circle);

        listView = (ListView)findViewById(R.id.circle_listView);



    }
    private class MyAdapter extends BaseAdapter{

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
                convertView = View.inflate(SportsCircleActivity.this,R.layout.circle_item,null);
                viewHolder = new ViewHolder();
                viewHolder.user_headView = (ImageView)convertView.findViewById(R.id.user_headView);
                viewHolder.user_name = (TextView)convertView.findViewById(R.id.user_name);
                viewHolder.time = (TextView)convertView.findViewById(R.id.time);
                viewHolder.title = (TextView)convertView.findViewById(R.id.title);
                viewHolder.distance = (TextView)convertView.findViewById(R.id.distance);
                viewHolder.like = (TextView)convertView.findViewById(R.id.like);
                viewHolder.comment = (TextView)convertView.findViewById(R.id.comment);
                viewHolder.imageLayout = (GridLayout)convertView.findViewById(R.id.imageLayout);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder)convertView.getTag();
            }

            viewHolder.user_headView.setImageResource(R.mipmap.girl);
            viewHolder.user_name.setText("这是用户名");
            viewHolder.time.setText("这是时间");
            viewHolder.title.setText("这是标题");
            viewHolder.distance.setText("998km");
            viewHolder.like.setText("998个赞");
            viewHolder.comment.setText("998个评论");

            //setImage(viewHolder.imageLayout);


            return null;
        }
    }

//    private void setImage(GridLayout imageLayout) {
//        int count = 1;
//        for (int i = 0; i < 3; i++)
//            for (int j = 0; j < 3; j++) {
////                Button btn = new Button(this);
////                btn.setText(String.valueOf(count));
//                ImageView btn = new ImageView(this);
//                btn.setImageResource(R.mipmap.girl);
//                count++;
//                GridLayout.Spec rowSpec = GridLayout.spec(i);     //设置它的行和列
//                GridLayout.Spec columnSpec = GridLayout.spec(j);
//                GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, columnSpec);
//                params.setGravity(Gravity.LEFT);
//                params.width = 200;
//                params.height = 200;
//                params.setMargins(5,5,5,5);
//                imageLayout.addView(btn, params);

  //  }

        private class ViewHolder{
        ImageView user_headView;
        TextView user_name,time,title,distance,like,comment;
        GridLayout imageLayout;
    }



}
