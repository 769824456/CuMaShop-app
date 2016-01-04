package win.yulongsun.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import win.yulongsun.R;

/**
 * 忘记密码
 */
public class ForgetPwdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);
        setTitle("忘记密码");
    }
}
