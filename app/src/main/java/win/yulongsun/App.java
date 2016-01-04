package win.yulongsun;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by yulongsun on 2016/1/4.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(App.this, "ffbd83f4172faa75996eb76b663887f9");
    }
}
