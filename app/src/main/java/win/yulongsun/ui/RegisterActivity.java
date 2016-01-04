package win.yulongsun.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.listener.SaveListener;
import win.yulongsun.R;
import win.yulongsun.model.User;

public class RegisterActivity extends AppCompatActivity {

    @Bind(R.id.username)
    AutoCompleteTextView username;
    @Bind(R.id.mobile)
    AutoCompleteTextView mobile;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.btn_register)
    Button btnRegister;
    @Bind(R.id.cb_register_is_read)
    CheckBox cbRegisterIsRead;
    @Bind(R.id.tv_register_protocol)
    TextView tvRegisterProtocol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        setTitle("用户注册");
    }

    @OnClick(R.id.btn_register)
    void register() {
        String mUsernameStr = username.getText().toString();
        String mMobileStr = mobile.getText().toString();
        String mPasswordStr = password.getText().toString();

        User user = new User();
        user.setUsername(mUsernameStr);
        user.setPassword(mPasswordStr);
        user.setMobilePhoneNumber(mMobileStr);
        user.save(RegisterActivity.this, new SaveListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(RegisterActivity.this, "success", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(RegisterActivity.this, "onFailure", Toast.LENGTH_LONG).show();
            }
        });
    }
}
