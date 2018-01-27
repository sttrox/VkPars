package by.vandr.vkpars.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import by.vandr.vkpars.R;

/**
 * Created by V on 25.01.2018.
 */

public class EmptyActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
    }
}
