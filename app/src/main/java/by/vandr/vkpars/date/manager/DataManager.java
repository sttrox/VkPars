package by.vandr.vkpars.date.manager;



/**
 * Created by V on 14.01.2018.
 */

public class DataManager {
    private static DataManager INSTANSE = null;
    private PreferencesManager mPreferenceManager;

    private DataManager() {
        this.mPreferenceManager = new PreferencesManager();
    }

    public static DataManager getINSTANSE() {
        if (INSTANSE == null) {
            INSTANSE = new DataManager();
        }
        return INSTANSE;
    }

    public PreferencesManager getPreferenceManager() {
        return mPreferenceManager;
    }
}
