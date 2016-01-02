package bmobdemo.bmoblogindemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends Activity implements View.OnClickListener {
    private EditText et_name;
    private EditText et_password;
    private Button signin;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(MainActivity.this,"9cc1a3ba7ed55aa49eb86d306cdf5a23");
        initView();
        initData();
    }

    private void initView() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
        signin = (Button) findViewById(R.id.signin);
        login = (Button) findViewById(R.id.login);
    }

    private void initData() {
        signin.setOnClickListener(this);
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String name = et_name.getText().toString();
        String password = et_password.getText().toString();
        switch (v.getId()) {
            case R.id.signin:
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
                    Toast.makeText(this, "用户名和密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                BmobUser user = new BmobUser();
                user.setUsername(name);
                user.setPassword(password);
                user.signUp(this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(MainActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        Toast.makeText(MainActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.login:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
        }
    }
}
