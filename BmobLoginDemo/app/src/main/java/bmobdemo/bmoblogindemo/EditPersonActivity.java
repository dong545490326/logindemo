package bmobdemo.bmoblogindemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2016/1/2.
 */
public class EditPersonActivity extends Activity implements View.OnClickListener {
    private static final String GGG ="Log";
    private TextView ed_tv_nickname;
    private TextView ed_tv_age;
    private ImageButton ed_ib_icon;
    private Bitmap photoBit;
    private static final int IMAGE_REQUEST_CODE = 0;
    private static final int CAMERA_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_person);
        initView();
        initData();
    }

    private void initView() {
        ed_tv_nickname = (TextView) findViewById(R.id.ed_tv_nickname);
        ed_tv_age = (TextView) findViewById(R.id.ed_tv_age);
        ed_ib_icon = (ImageButton) findViewById(R.id.ed_ib_icon);
    }

    private void initData() {
        ed_ib_icon.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ed_ib_icon:
                if (isSdcardExisting()) {
                    Intent cameraIntent = new Intent("android.media.action.IMAGE_CAPTURE");//拍照
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, "data");
                    cameraIntent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
                } else {
                    Toast.makeText(EditPersonActivity.this, "请插入sd卡", Toast.LENGTH_LONG)
                            .show();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            return;
        } else {
            switch (requestCode) {
                case CAMERA_REQUEST_CODE:
                    Bundle extras = data.getExtras();
                    photoBit = (Bitmap) extras.get("data");
                    ed_ib_icon.setImageBitmap(photoBit);
                    Log.e(GGG,"成功");
                    Toast.makeText(EditPersonActivity.this,"成功设置",Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean isSdcardExisting() {
        final String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }
}


