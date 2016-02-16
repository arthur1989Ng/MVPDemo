package ng.com.mvpdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ng.com.mvpdemo.presenter.ILoginPresenter;
import ng.com.mvpdemo.presenter.LoginPresenterCompl;
import ng.com.mvpdemo.view.ILoginView;

public class MainActivity extends AppCompatActivity implements OnClickListener, ILoginView {


    private Button mBtnLogin, mBtnClear;
    private EditText mETName, mETPwd;
    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initView();
    }


    private void initView() {
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnClear = (Button) findViewById(R.id.btn_clear);
        mETName = (EditText) findViewById(R.id.et_name);
        mETPwd = (EditText) findViewById(R.id.et_pw);

        mBtnLogin.setOnClickListener(this);
        mBtnClear.setOnClickListener(this);

        loginPresenter = new LoginPresenterCompl(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_login:
                loginPresenter.doLogin(mETName.getText().toString(), mETPwd.getText().toString());

                mBtnLogin.setEnabled(false);
                mBtnClear.setEnabled(false);

                break;

            case R.id.btn_clear:
                loginPresenter.clear();
                break;
        }

    }

    @Override
    public void onClearText() {
        mETName.setText("");
        mETPwd.setText("");
    }

    @Override
    public void onLoginResult(boolean result, int code) {

        mBtnLogin.setEnabled(true);
        mBtnClear.setEnabled(true);

        if (result) {
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Login Fail, code = " + code, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {

    }
}
