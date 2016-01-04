package win.yulongsun.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import win.yulongsun.R;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        setTitle("用户中心");
    }
}
