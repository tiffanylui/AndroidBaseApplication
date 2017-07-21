package base.tiffany.baseandroidapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tiffanylui on 2017-07-21.
 */

public class GetResponse {

    @SerializedName("json_key")
    String mJsonKey;

    public String getJsonKey(){
        return mJsonKey;
    }

}
