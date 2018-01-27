package by.vandr.vkpars.ui.activities;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.VectorDrawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import by.vandr.vkpars.R;
import by.vandr.vkpars.utils.ConstantManager;

/**
 * Created by V on 12.01.2018.
 */

public class BaseActivity extends AppCompatActivity {
    private final static String TAG = ConstantManager.TAG_PREFIX_DEV + "BaseActivity";
    protected ProgressDialog mProgressDialog;

    public void showProgress(){
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this, R.style.custom_dialog);
            mProgressDialog.setCancelable(false);
            mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(50,30,100,70)));
            mProgressDialog.show();
            mProgressDialog.setContentView(R.layout.progress_splash);
        }else{
            mProgressDialog.setContentView(R.layout.progress_splash);
            mProgressDialog.show();
        }


    }

    public void hideProgress() {
        if (mProgressDialog != null) {
            if (mProgressDialog.isShowing()) {
                mProgressDialog.hide();
            }
        }
    }

    public void showError(String message,  Exception error) {
        showMessage(message);
        Log.e(TAG, String.valueOf(error));
    }

    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG);
    }

    public void showMessageSnackBar(CoordinatorLayout coordinatorLayout,String message) {
        Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG).show();
    }
}
