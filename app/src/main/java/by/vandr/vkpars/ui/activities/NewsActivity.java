package by.vandr.vkpars.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import by.vandr.vkpars.R;
import by.vandr.vkpars.network.api.NewsFeed;
import by.vandr.vkpars.network.object.NewsJSONpars;
import by.vandr.vkpars.ui.adapter.NewsAdapter;
import by.vandr.vkpars.utils.ConstantManager;
import by.vandr.vkpars.utils.GlobalRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

import static by.vandr.vkpars.ui.activities.LoginActivity.APP_PREFERENCES_NAME;
import static by.vandr.vkpars.ui.activities.LoginActivity.PREFERENCES_TOKEN;

/**
 * Created by V on 27.01.2018.
 */

public class NewsActivity extends BaseActivity {
    RecyclerView mRecyclerView;
    Retrofit mRetrofit;
    NewsFeed mNewsFeed;
    Context ctx;
    final static String TAG = ConstantManager.TAG_PREFIX_DEV + "News Activity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ctx = this;

        showProgress();

        mRecyclerView = (RecyclerView) findViewById(R.id.act_news_recycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRetrofit = new GlobalRetrofit().getRetrofit();
        mNewsFeed = mRetrofit.create(NewsFeed.class);
        mNewsFeed.getNews(
                "post",
                0,
                0,
                0,
                100,
                null,
                null,
                10,
                null,
                getSharedPreferences(APP_PREFERENCES_NAME, MODE_PRIVATE).getString(PREFERENCES_TOKEN, ""),
                "5.69")
                .enqueue(new Callback<NewsJSONpars>() {
                    @Override
                    public void onResponse(Call<NewsJSONpars> call, retrofit2.Response<NewsJSONpars> response) {

                        Log.d(TAG, " Start");
                        NewsJSONpars newsJSONpars = response.body();
                        Log.d(TAG, String.valueOf( newsJSONpars.getCount()));
                        NewsAdapter newsAdapter = new NewsAdapter(newsJSONpars, ctx);
                        mRecyclerView.setAdapter(newsAdapter);
                        hideProgress();
                        Log.d(TAG, "Done");

                        Log.d(TAG, newsJSONpars.getResponse().getItems().get(1).getText());
                        Log.d(TAG, newsJSONpars.getResponse().getItems().get(2).getText());
                        Log.d(TAG, newsJSONpars.getResponse().getItems().get(3).getText());
                        Log.d(TAG, newsJSONpars.getResponse().getItems().get(4).getText());
                        Log.d(TAG, newsJSONpars.getResponse().getItems().get(5).getText());
                        Log.d(TAG, newsJSONpars.getResponse().getItems().get(6).getText());
                    }

                    @Override
                    public void onFailure(Call<NewsJSONpars> call, Throwable t) {
                    }
                });
    }


}
