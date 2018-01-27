package by.vandr.vkpars.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import by.vandr.vkpars.date.manager.DataManager;
import by.vandr.vkpars.date.manager.PreferencesManager;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by V on 27.01.2018.
 */

public class  GlobalRetrofit {


    private static Retrofit INSTANSE = null;
    private static Gson mGson;

    private static Retrofit GlobalRetrofit() {
        mGson =new GsonBuilder()
                .setLenient()
                .create();
        return new Retrofit.Builder()
                .baseUrl(ConstantManager.BASE_PATH_METHOD) //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create(mGson)) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
    }

    public static Retrofit getRetrofit() {
        if (INSTANSE == null) {

            INSTANSE = GlobalRetrofit() ;
        }
        return INSTANSE;
    }

//    public PreferencesManager getPreferenceManager() {
//        return mPreferenceManager;
//    }

}
