package by.vandr.vkpars.utils;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;

import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import by.vandr.vkpars.network.api.AcountInfo;
import by.vandr.vkpars.network.object.AccountInfo;
import by.vandr.vkpars.ui.activities.LoginActivity;
import by.vandr.vkpars.ui.activities.MainActivity;
import by.vandr.vkpars.ui.activities.TestActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static by.vandr.vkpars.ui.activities.LoginActivity.APP_PREFERENCES_NAME;
import static by.vandr.vkpars.ui.activities.LoginActivity.PREFERENCES_TOKEN;

/**
 * Created by V on 14.01.2018.
 */

public class VkPars extends Application {
    private static final String TAG = ConstantManager.TAG_PREFIX_DEV + "VKPars";

    public static SharedPreferences mSharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //System.out.println();
        getInfo();
        Log.d(TAG, "token:" + mSharedPreferences.getString(PREFERENCES_TOKEN, "NULL"));
    }

    public static SharedPreferences getmSharedPreferences() {
        return mSharedPreferences;
    }

    private void getInfo() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantManager.BASE_PATH_METHOD) //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create(gson)) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();

        AcountInfo info = retrofit.create(AcountInfo.class);
        info.getInfo("", mSharedPreferences.getString(PREFERENCES_TOKEN, ""), ConstantManager.VERSION_VALUE)
                .enqueue(new Callback<AccountInfo>() {

                    @Override
                    public void onResponse(Call<AccountInfo> call, Response<AccountInfo> response) {
                        startActivity(response.body().getResponse() == null);
                    }

                    @Override
                    public void onFailure(Call<AccountInfo> call, Throwable t) {
                        System.out.println("BAD");
                    }
                });

    }

    private void startActivity(Boolean check) {
        if (check) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        } else {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }
}