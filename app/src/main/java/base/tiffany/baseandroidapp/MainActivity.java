package base.tiffany.baseandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(this);

        initView();
    }

    private void initView() {
        startApi();
    }

    private void startApi() {
        Api.getInstance().getResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<GetResponse>() {
                    @Override
                    public void call(GetResponse getResponse) {
                        Log.d("GetResponse", "Result:" + getResponse.getJsonKey());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.d("GetResponse", "Error" + throwable.getMessage());
                    }
                });
    }

}
