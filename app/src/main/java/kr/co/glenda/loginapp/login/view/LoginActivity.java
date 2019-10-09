package kr.co.glenda.loginapp.login.view;

import android.os.Bundle;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.glenda.loginapp.R;
import kr.co.glenda.loginapp.login.LoginContract;
import kr.co.glenda.loginapp.login.model.User;
import kr.co.glenda.loginapp.login.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginContract.View{
    private static String _TAG = "[GLENDA LOGINAPP]";
    private LoginContract.Presenter presenter;

    @BindView(R.id.txtId)
    EditText txtId;
    @BindView(R.id.txtPwd)
    EditText txtPwd;
    @BindView(R.id.btnLogin)
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        // 1.Butter knife 사용 전 소스
//        txtId = findViewById(R.id.txtId);
//        txtPwd = findViewById(R.id.txtPwd);
//        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(_TAG, String.format("id: %s, pwd: %s", txtId.getText().toString(), txtPwd.getText().toString()));
//            }
//        });

        //2.Butter knife를 이용한 소스
//        ButterKnife.bind(this);
//
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                save();
//            }
//        });

        //3.MVP패턴
        ButterKnife.bind(this);
        presenter = new LoginPresenter();
        presenter.setView(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setId(txtId.getText().toString());
                user.setPwd(txtPwd.getText().toString());;
                presenter.loginProc(user);
            }
        });
    }

//    private void save() {
//        Log.d(_TAG, String.format("id: %s, pwd: %s", txtId.getText().toString(), txtPwd.getText().toString()));
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void loginDone() {
        Looper.prepare();
        Toast.makeText(this, "공부 힘들다", Toast.LENGTH_SHORT).show();
        Looper.loop();
    }

    @Override
    protected void onDestroy() {
        presenter.removeView();
        super.onDestroy();
    }
}
