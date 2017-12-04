package by.vandr.vkpars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKScopes;
import com.vk.sdk.util.VKUtil;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Application application = new Application();
        application.onCreate();
    }

    TextView textView;


    public void OnClick(View v) {


        VKSdk.login(this, VKScope.FRIENDS, VKScope.PHOTOS,VKScope.ADS,VKScope.AUDIO,VKScope.EMAIL,VKScope.DIRECT,VKScope.DOCS,VKScope.NOTIFICATIONS
        ,VKScope.NOHTTPS,VKScope.NOTES,VKScope.MESSAGES,VKScope.WALL,VKScope.OFFLINE,VKScope.PAGES,VKScope.STATUS,VKScope.VIDEO);
        VKRequest request = VKApi.users().get();
        textView = (TextView) findViewById(R.id.texts);
        textView.setText((VKUtil.getCertificateFingerprint(this, this.getPackageName())).toString());
    }



    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        textView = (TextView) findViewById(R.id.texts);
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                textView.setText("Good");
                ((Button)findViewById(R.id.buttonNexy)).setVisibility(View.VISIBLE);

            }

            @Override
            public void onError(VKError error) {
                textView.setText(VKSdk.SDK_APP_ID.toString());

// Произошла ошибка авторизации (например, пользователь запретил авторизацию)
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void startTestActivity() {
        startActivity(new Intent(this, TestActivity.class));
    }

    public void OnCklickNext(View view) {
        startActivity(new Intent(this, StartNews.class));

    }
}
