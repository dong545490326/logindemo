package bmobdemo.bmoblogindemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/1/2.
 */
public class EditPersonActivity extends Activity implements View.OnClickListener {
    private TextView ed_tv_nickname;
    private TextView ed_tv_age;
    private ImageButton ed_ib_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_person);
        initView();
        initData();
    }

    private void initView() {
        ed_tv_nickname= (TextView) findViewById(R.id.ed_tv_nickname);
        ed_tv_age= (TextView) findViewById(R.id.ed_tv_age);
        ed_ib_icon= (ImageButton) findViewById(R.id.ed_ib_icon);
    }
    private void initData() {
        ed_ib_icon.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ed_ib_icon:

        }

    }
}
