package win.yulongsun.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.RequestSMSCodeListener;
import win.yulongsun.R;
import win.yulongsun.util.CommonUtils;

public class LoginActivity extends AppCompatActivity {

    int i = 60;
    @Bind(R.id.act_login_mobile)
    AutoCompleteTextView actLoginMobile;
    @Bind(R.id.et_login_code)
    EditText etLoginCode;
    @Bind(R.id.btn_get_code)
    Button btnGetCode;
    @Bind(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


    }

    public void getCode(View view) {
        String mobile = actLoginMobile.getText().toString();
        if (!CommonUtils.isPhoneNum(LoginActivity.this, mobile)) {
            return;
        }
        BmobSMS.requestSMSCode(this, mobile, "login", new RequestSMSCodeListener() {

            @Override
            public void done(Integer integer, BmobException e) {
                if (e == null) {//验证码发送成功
                    Toast.makeText(LoginActivity.this, "验证码发送成功", Toast.LENGTH_LONG).show();
                    Log.i("smile", "短信id：" + integer);//用于查询本次短信发送详情
                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; i > 0; i--) {
                    handler.sendEmptyMessage(-9);
                    if (i <= 0) {
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                handler.sendEmptyMessage(-8);
            }
        }).start();
    }

    /**
     * 接收消息
     */
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case -9:
                    btnGetCode.setText("重新发送(" + i + ")");
                    btnGetCode.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
                    break;
                case -8:
                    btnGetCode.setText("获取验证码");
                    btnGetCode.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    btnGetCode.setClickable(true);
                    i = 60;
                    break;
                default:
                    break;
            }
        }
    };


    /**登陆
     * @param view
     */
    public void login(View view){
//        BmobUser.signOrLoginByMobilePhone(this, "11位手机号码", "验证码", new LogInListener<User>() {
//            @Override
//            public void done(User user, BmobException e) {
//                if(user!=null){
//                    Log.i("smile","用户登陆成功");
//                }
//            }
//        });

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}

