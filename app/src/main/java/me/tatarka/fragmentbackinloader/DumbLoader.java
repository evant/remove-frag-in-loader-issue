package me.tatarka.fragmentbackinloader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.Loader;


public class DumbLoader extends Loader<Void> {
    public DumbLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                deliverResult(null);
            }
        });
    }
}
