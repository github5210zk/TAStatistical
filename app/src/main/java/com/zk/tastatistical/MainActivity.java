package com.zk.tastatistical;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.umeng.analytics.MobclickAgent;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void test(View v) {
        //统计点击的次数
        onEvent(MainActivity.this, "test", "测试");
        Log.e(TAG, "点击了~~~~~~~~~");
    }

    /**
     * @param context 当前宿主进程的ApplicationContext上下文。
     * @param eventID 为当前统计的事件ID。
     * @param label   事件的标签属性。
     */
    public static void onEvent(Context context, String eventID, String label) {
        MobclickAgent.onEvent(context, eventID, label);
    }


    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);          //统计时长


    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);             //统计时长
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}