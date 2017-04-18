package io.github.stuhua.utils;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by liulh on 2017/4/18.
 */

public class SecondActivity extends Activity {
    private Timer mTimer;
    private TimerTask mTimerTast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTimer = new Timer();
        mTimerTast = new TimerTask() {
            @Override
            public void run() {
                LogUtils.print("run...");
            }
        };
        mTimer.schedule(mTimerTast, 0, 1000);
    }

    public void method() {
        ScheduledExecutorService newScheduledThreadPool = Executors
                .newScheduledThreadPool(2);
        newScheduledThreadPool.schedule(mTimerTast, 1000, TimeUnit.MILLISECONDS);
    }
}
