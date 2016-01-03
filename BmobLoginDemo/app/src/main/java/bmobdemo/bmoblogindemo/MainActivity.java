package bmobdemo.bmoblogindemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends Activity implements View.OnClickListener {
    private EditText et_name;
    private EditText et_password;
    private Button signin;
    private EditText et_age;
    private EditText et_nickname;
    private CheckBox cb_sex_girl;
    private CheckBox cb_sex_boy;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(MainActivity.this, "9cc1a3ba7ed55aa49eb86d306cdf5a23");
        initView();
        initData();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void initView() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
        signin = (Button) findViewById(R.id.signin);
        et_age = (EditText) findViewById(R.id.et_age);
        et_nickname = (EditText) findViewById(R.id.et_nickname);

    }

    private void initData() {
        signin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String name = et_name.getText().toString();
        String password = et_password.getText().toString();
        String nickname = et_nickname.getText().toString();
        String age = et_age.getText().toString();
        switch (v.getId()) {
            case R.id.signin:
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
                    Toast.makeText(this, "用户名和密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                UserBean user = new UserBean();
                user.setUsername(name);
                user.setPassword(password);
                user.setNickname(nickname);
                user.setAge(age);
                user.signUp(this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(MainActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(intent1);
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        Toast.makeText(MainActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://bmobdemo.bmoblogindemo/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://bmobdemo.bmoblogindemo/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
