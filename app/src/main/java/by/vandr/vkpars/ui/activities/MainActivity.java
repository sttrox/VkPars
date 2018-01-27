package by.vandr.vkpars.ui.activities;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import by.vandr.vkpars.R;
import by.vandr.vkpars.network.object.NewsJSONpars;

import by.vandr.vkpars.network.api.NewsFeed;
import by.vandr.vkpars.utils.ConstantManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static by.vandr.vkpars.ui.activities.LoginActivity.APP_PREFERENCES_NAME;
import static by.vandr.vkpars.ui.activities.LoginActivity.PREFERENCES_TOKEN;



public class MainActivity extends BaseActivity {
    private static final String TAG = ConstantManager.TAG_PREFIX_DEV + "Main Activity";
    private CoordinatorLayout mCoordinatorLayout;
    Context ctx;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private static NewsFeed newsFeed;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupActionBar();
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_coordinator);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer);
        ctx = this;


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(ConstantManager.BASE_PATH_METHOD) //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create(gson)) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        newsFeed = retrofit.create(NewsFeed.class); //Создаем объект, при помощи которого будем выполнять запрос
      //  Application application = new Application();
       // application.onCreate();
    }

    TextView textView;

    public static NewsFeed getApi() {
        return newsFeed;
    }

    public void OnClick(View v) {
//        Controller controller = new Controller();
//        controller.start(ctx);
        showMessageSnackBar(mCoordinatorLayout,"Yes");
        //showProgress();

        setupActionBar();
        Log.d(TAG, "OK");
        SharedPreferences preferences = getSharedPreferences(APP_PREFERENCES_NAME, MODE_PRIVATE);


        newsFeed.getNews(
                "post",
                0,
                0,
                0,
                100,
                null,
                null,
                10,
                null,
                preferences.getString(PREFERENCES_TOKEN, ""),
                "5.69")
                .enqueue(new Callback<NewsJSONpars>() {
                    @Override
                    public void onResponse(Call<NewsJSONpars> call, retrofit2.Response<NewsJSONpars> response) {
                        System.out.println(response.raw());
                        System.out.println(response.body().getCount());
                        startActivity(new Intent(getApplicationContext(),TestActivity.class));
                        hideProgress();

                    }
                    @Override
                    public void onFailure(Call<NewsJSONpars> call, Throwable t) {
                   }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);

    }

    private void startTestActivity() {
        startActivity(new Intent(this, NewsActivity.class));
    }

    public void OnCklickNext(View view) {
        //setupActionBar();
        showMessageSnackBar(mCoordinatorLayout,"Yes");
        startTestActivity();

        // startActivity(new Intent(this, TestActivity.class));

    }

    private void runWithDelay() {
        final Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                hideProgress();
            }
        }, 200);
    }

    private void setupActionBar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_list_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

}
