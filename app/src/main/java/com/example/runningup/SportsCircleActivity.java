package com.example.runningup;

import android.app.Activity;
import android.bluetooth.BluetoothA2dp;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.PipedReader;

/**
 * Created by jack on 2016/4/13.
 */
public class SportsCircleActivity extends Activity{

    private ListView listView ;
    private MyAdapter adapter = new MyAdapter();
    private ImageAdapter imageAdapter = new ImageAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sport_circle);

        listView = (ListView)findViewById(R.id.circle_listView);
        listView.setAdapter(adapter);



    }


    private class ImageAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 9;
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
            ViewHolder imageviewHolder = null;
            if (imageviewHolder ==null){
                convertView = View.inflate(SportsCircleActivity.this, R.layout.image_viewitem, null);
                imageviewHolder = new ViewHolder();

                imageviewHolder.imageView = (ImageView)convertView.findViewById(R.id.circle_imageview);

                convertView.setTag(imageviewHolder);
            }else {
                imageviewHolder =(ViewHolder) convertView.getTag();
            }

            imageviewHolder.imageView.setImageResource(R.mipmap.girl);


            return convertView;
        }
    }


    private class MyAdapter extends BaseAdapter {

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
            if (convertView == null) {
                convertView = View.inflate(SportsCircleActivity.this, R.layout.circle_item, null);
                viewHolder = new ViewHolder();

                viewHolder.user_headView = (ImageView) convertView.findViewById(R.id.user_headView);
                viewHolder.user_name = (TextView) convertView.findViewById(R.id.user_name);
                viewHolder.time = (TextView) convertView.findViewById(R.id.time);
                viewHolder.title = (TextView) convertView.findViewById(R.id.title);
                viewHolder.distance = (TextView) convertView.findViewById(R.id.distance);
                viewHolder.like = (TextView) convertView.findViewById(R.id.like);
                viewHolder.comment = (TextView) convertView.findViewById(R.id.comment);
               // viewHolder.imageLayout = (GridLayout) convertView.findViewById(R.id.imageLayout);
                viewHolder.imageGridView = (GridView) convertView.findViewById(R.id.imageGridView);

                convertView.setTag(viewHolder);
            } else {
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

            //点击事件监听
            viewHolder.like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SportsCircleActivity.this,"sdfafa",Toast.LENGTH_SHORT).show();
                }
            });

            //setImage(viewHolder.imageLayout);
//            int count = 1;
//            for (int i = 0; i < 3; i++)
//                for (int j = 0; j < 3; j++) {
////                Button btn = new Button(this);
////                btn.setText(String.valueOf(count));
//                    ImageView btn = new ImageView(SportsCircleActivity.this);
//                    btn.setImageResource(R.mipmap.girl);
//                    count++;
//                    GridLayout.Spec rowSpec = GridLayout.spec(i);     //设置它的行和列
//                    GridLayout.Spec columnSpec = GridLayout.spec(j);
//                    GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, columnSpec);
//                    params.setGravity(Gravity.LEFT);
//                    params.width = 200;
//                    params.height = 200;
//                    params.setMargins(5, 5, 5, 5);
//                    viewHolder.imageLayout.addView(btn, params);
//                }
            return convertView;
        }
    }


        private class ViewHolder {
            ImageView user_headView;
            TextView user_name, time, title, distance, like, comment;
            //GridLayout imageLayout;
            GridView imageGridView;
            ImageView imageView;
        }



}
