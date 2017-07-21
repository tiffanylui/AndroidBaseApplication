package base.tiffany.baseandroidapp;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by tiffanylui on 2017-07-21.
 */

public class Api {
    String baseUrl = "test.url";

    private Retrofit mRestAdapter;
    private ApiService mService;

    private static Api sInstance;

    private Api(){
        mRestAdapter = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static Api getInstance(){
        if (sInstance == null){
            sInstance = new Api();
        }
        return sInstance;
    }

    ApiService getService(){
        if (mService == null){
            mService = mRestAdapter.create(ApiService.class);
        }
        return mService;
    }

    public Observable<GetResponse> getResponse(){
        return getService().getResponse();
    }
}
