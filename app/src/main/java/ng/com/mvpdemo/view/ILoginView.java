package ng.com.mvpdemo.view;

/**
 * Created by niangang on 2016/2/16.
 */
public interface ILoginView {

    public void onClearText();

    public void onLoginResult(boolean result, int code);

    public void onSetProgressBarVisibility(int visibility);

}
