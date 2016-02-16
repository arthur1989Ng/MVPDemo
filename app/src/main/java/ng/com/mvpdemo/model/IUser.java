package ng.com.mvpdemo.model;

/**
 * Created by niangang on 2016/2/16.
 */
public interface IUser {
    String getUserName();

    String getPassword();
    int checkUserValidity(String name, String passwd);


}
