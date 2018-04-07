package com.zk.tastatistical;

import android.app.Application;


import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

/**
 * Created by ${zk} on 2018/4/6 0006.
 * 欢迎每一天
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initYouMeng();
    }

    private void initYouMeng() {
        /*
         * 如果在注册清单里 声明APP KEY,就可以使用这个初始化方法
         *
         * 初始化common库
         * 参数1:上下文，不能为空
         * 参数2:APP_KEY  如果设置为null
         * 参数3:Channel  如果设置为null
         * 参数4:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
         * 参数5:Push推送业务的secret 需要集成Push功能必须传入的sercet,否则为空

         */
        UMConfigure.init(getApplicationContext(), null, null, UMConfigure.DEVICE_TYPE_PHONE, null);

        /**
         * 设置组件化的Log开关
         * 参数: boolean 默认为false，如需查看LOG设置为true
         */
        UMConfigure.setLogEnabled(true);

        /**
         * 设置日志加密
         * 参数：boolean 默认为false（不加密）
         */
        UMConfigure.setEncryptEnabled(true);
        //统计默认的页面统计方式
        MobclickAgent.openActivityDurationTrack(false);
        /**
         *  设置场景类型接口
         *  Application 上下文
         *  模式
         */
        MobclickAgent.setScenarioType(getApplicationContext(), MobclickAgent.EScenarioType.E_UM_NORMAL);


    }
}
