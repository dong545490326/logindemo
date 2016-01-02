package bmobdemo.bmoblogindemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2016/1/2.
 */
public class LoginActivity extends Activity implements View.OnClickListener{
    private EditText login_name;
    private EditText login_password;
    private Button login_login;
    private Button login_signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initView();
        initData();
    }


    private void initView() {
       login_login= (Button) findViewById(R.id.login_login);
        login_name= (EditText) findViewById(R.id.login_name);
        login_password= (EditText) findViewById(R.id.login_password);
        login_signin= (Button) findViewById(R.id.login_signin);
    }
    private void initData() {
        login_login.setOnClickListener(this);
        login_signin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name=login_name.getText().toString();
        String password=login_password.getText().toString();
        switch (v.getId()){
            case R.id.login_login:
                if (TextUtils.isEmpty(name)||TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this,"用户名和密码不能为空",Toast.LENGTH_SHORT).show();
                }
                BmobUser user=new BmobUser();
                user.setUsername(name);
                user.setPassword(password);
                user.login(LoginActivity.this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.login_signin:
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
