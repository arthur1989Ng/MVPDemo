package ng.com.mvpdemo.model;

/**
 * Created by niangang on 2016/2/16.
 */
public class UserModel implements IUser {
    private String username;
    private String password;

    public UserModel(String name, String pwd) {
        this.username = name;
        this.password = pwd;
    }


    @Override
    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int checkUserValidity(String name, String passwd) {
        if (name == null || passwd == null || !name.equals(getPassword()) || !passwd.equals(getPassword())) {
            return -1;
        }
        return 0;
    }

}