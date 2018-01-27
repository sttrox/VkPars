package by.vandr.vkpars.date.manager;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import by.vandr.vkpars.utils.ConstantManager;
import by.vandr.vkpars.utils.VkPars;

/**
 * Created by V on 14.01.2018.
 */

public class PreferencesManager {
    SharedPreferences mSharedPreferences;

    private static String ACCESS_TOKEN = ConstantManager.ACCESS_TOKEN;
    private static String USER_ID = ConstantManager.USER_ID;

    public PreferencesManager() {
        mSharedPreferences = VkPars.getmSharedPreferences();
    }

    public void savaTokenAndId(String token, int id) {

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(USER_ID,id);
        editor.putString(ACCESS_TOKEN, token);
    }

    public String loadToken() {
        return mSharedPreferences.getString(ACCESS_TOKEN, null);
    }

    public int getUserId() {
        return mSharedPreferences.getInt(USER_ID, 0);
    }

}
