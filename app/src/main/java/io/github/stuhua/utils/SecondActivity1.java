package io.github.stuhua.utils;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by liulh on 2017/4/15.
 * Android命名规范之区块划分
 */

public class SecondActivity1 extends Activity implements View.OnClickListener {
    public static final String ACTION = "";//1. 静态常量
    private TextView mMainTV;// 2. UI控件成员变量声明区
    private IMain mIMain;
    private int i;// 3. 普通成员变量声明区

    //4. 内部接口声明区
    private interface IMain {
        public void onSet();
    }

    //5. 初始化相关方法区
    public void init() {

    }

    //6. 事件响应方法区
    @Override
    public void onClick(View view) {

    }

    //7. 普通逻辑方法区
    public void Calc() {

    }

    //9. 重载的逻辑方法区
    @Override
    public View findViewById(int id) {
        return super.findViewById(id);
    }

    //9. 发起异步任务方法区
    public void downLoad() {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

    //10. 异步任务回调方法区
    public void onSet() {
        mIMain.onSet();
    }

    //11. 生命周期回调方法区（出去onCreate()方法）
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //12. 内部类声明区
    class InnerClass {

    }
}
