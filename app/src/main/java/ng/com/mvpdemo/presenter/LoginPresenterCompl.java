package ng.com.mvpdemo.presenter;


import android.os.Handler;
import android.os.Looper;

import ng.com.mvpdemo.model.IUser;
import ng.com.mvpdemo.model.UserModel;
import ng.com.mvpdemo.view.ILoginView;

/**
 * Created by niangang on 2016/2/16.
 */
public class LoginPresenterCompl implements ILoginPresenter {


    private IUser iUser;
    private ILoginView iLoginView;

    private Handler handler;

    public LoginPresenterCompl(ILoginView loginView) {

        this.iLoginView = loginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());


    }


    @Override
    public void doLogin(String name, String pwd) {
        boolean isLoginSuccess = true;
        final int code = iUser.checkUserValidity(name, pwd);
        if (code != 0)
            isLoginSuccess = false;

        final boolean loginResult = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                iLoginView.onLoginResult(loginResult, code);
            }
        }, 5000);

    }

    @Override
    public void clear() {

        iLoginView.onClearText();

    }

    @Override
    public void setProgressBarVisible(int visible) {
        iLoginView.onSetProgressBarVisibility(visible);


    }

    private void initUser() {
        iUser = new UserModel("mvp", "mvp");
    }
}
