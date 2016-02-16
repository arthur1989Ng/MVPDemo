package ng.com.mvpdemo.presenter;

import ng.com.mvpdemo.model.UserModel;

/**
 * Created by niangang on 2016/2/16.
 */
public interface ILoginPresenter {
    void doLogin(String name, String pwd);

    void clear();

    void setProgressBarVisible(int visible);
}
