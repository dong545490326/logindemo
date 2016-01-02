package bmobdemo.bmoblogindemo;

import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2016/1/2.
 */
public class UserBean extends BmobUser {
    private String nickname;
    private String age;
    private  Boolean sex;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
}
