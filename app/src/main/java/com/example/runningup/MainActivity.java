package com.example.runningup;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends TabActivity implements OnCheckedChangeListener {

    private TabHost mTabHost;
    private Intent CircleIntent;
    private Intent FoundIntent;
    private Intent SportIntent;
    private Intent MessageIntent;
    private Intent MindIntent;

    //图片展示测试
    private GridLayout viewlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.maintabs);

        this.CircleIntent = new Intent(MainActivity.this,SportsCircleActivity.class);
        this.FoundIntent = new Intent(MainActivity.this,FoundActivity.class);
        this.SportIntent = new Intent(MainActivity.this,SportsActivity.class);
        this.MessageIntent = new Intent(MainActivity.this,MessageActivity.class);
        this.MindIntent = new Intent(MainActivity.this,MindActivity.class);

        ((RadioButton)findViewById(R.id.radio_button0)).
                setOnCheckedChangeListener(this);
        ((RadioButton)findViewById(R.id.radio_button1)).setOnCheckedChangeListener(this);
        ((RadioButton)findViewById(R.id.radio_button2)).setOnCheckedChangeListener(this);
        ((RadioButton)findViewById(R.id.radio_button3)).setOnCheckedChangeListener(this);
        ((RadioButton)findViewById(R.id.radio_button4)).setOnCheckedChangeListener(this);

        setupIntent();

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked){
            switch (buttonView.getId()){
                case R.id.radio_button0:
                    this.mTabHost.setCurrentTabByTag("SportCircle");
                    break;
                case R.id.radio_button1:
                    this.mTabHost.setCurrentTabByTag("Found");
                    break;
                case R.id.radio_button2:
                    this.mTabHost.setCurrentTabByTag("Sport");
                    break;
                case R.id.radio_button3:
                    this.mTabHost.setCurrentTabByTag("Message");
                    break;
                case R.id.radio_button4:
                    this.mTabHost.setCurrentTabByTag("Mind");
                    break;
            }
        }
    }

    private void setupIntent() {
        this.mTabHost = getTabHost();
        TabHost localTabHost = this.mTabHost;

        localTabHost.addTab(buildTabSpec("SportCircle",R.string.radio_1,
                R.mipmap.icon_1_n,this.CircleIntent));
        localTabHost.addTab(buildTabSpec("Found",R.string.radio_2,
                R.mipmap.icon_2_n,this.FoundIntent));
        localTabHost.addTab(buildTabSpec("Sport",R.string.radio_3,
                R.mipmap.icon_3_n,this.SportIntent));
        localTabHost.addTab(buildTabSpec("Message",R.string.radio_4,
                R.mipmap.icon_4_n,this.MessageIntent));
        localTabHost.addTab(buildTabSpec("Mind",R.string.radio_5,
                R.mipmap.icon_5_n,this.MindIntent));

    }

    private TabHost.TabSpec buildTabSpec(String tag,int resLabel,int resIcon,final Intent content){
        return this.mTabHost.newTabSpec(tag).setIndicator(getString(resLabel),
                getResources().getDrawable(resIcon)).setContent(content);
    }

//    private void setlayout() {
//
//        //获取屏幕宽度
////        WindowManager windowManager = this.getWindowManager();
////        int width = windowManager.getDefaultDisplay().getWidth();
////        int height = windowManager.getDefaultDisplay().getHeight();
//
//       int count = 1;
//        for (int i = 0; i < 3; i++)
//            for (int j = 0; j < 3; j++) {
////                Button btn = new Button(this);
////             btn.setText(String.valueOf(count));
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
//                viewlayout.addView(btn, params);
//            }
//    }



}
