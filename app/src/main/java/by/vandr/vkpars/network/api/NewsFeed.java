package by.vandr.vkpars.network.api;

/**
 * Created by V on 08.01.2018.
 */

import by.vandr.vkpars.network.object.NewsJSONpars;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface NewsFeed {
        @GET("newsfeed.get")
        Call<NewsJSONpars> getNews(
                @Query("filters") String resourceName,
                @Query("return_banned") int flagbaner,
                @Query("start_time") int start_time,
                @Query("end_time") int end_time,
                @Query("max_photos") int max_photos,
                @Query("source_ids") String source_ids,
                @Query("start_from") String start_from,
                @Query("count") int count,
                @Query("fields") String fields,
                @Query("access_token") String access_token,
                @Query("v") String V);

}
