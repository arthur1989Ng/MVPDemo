package ng.com.mvpdemo.view;

/**
 * Created by niangang on 2016/2/16.
 */
public interface ILoginView {

    void onClearText();

    void onLoginResult(boolean result, int code);

    void onSetProgressBarVisibility(int visibility);

}
