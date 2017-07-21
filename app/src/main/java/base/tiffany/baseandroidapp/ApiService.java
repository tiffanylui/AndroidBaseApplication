package base.tiffany.baseandroidapp;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by tiffanylui on 2017-07-21.
 */

public interface ApiService {

    @GET("/")
    Observable<GetResponse> getResponse();
}
