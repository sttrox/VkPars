package by.vandr.vkpars.network.api;

import by.vandr.vkpars.network.object.AccountInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by V on 14.01.2018.
 */

public interface AcountInfo {
    @GET("account.getInfo")
    Call<AccountInfo> getInfo(
            @Query("fields") String fields,
            @Query("access_token") String access_token,
            @Query("v") String V);



}
