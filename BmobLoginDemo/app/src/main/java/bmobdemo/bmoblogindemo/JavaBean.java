package bmobdemo.bmoblogindemo;

import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2016/1/2.
 */
public class JavaBean extends BmobUser {
    private String name;
    private Integer password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }
}
