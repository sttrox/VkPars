package by.vandr.vkpars;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiPost;

import java.util.Random;

import by.vandr.vkpars.core.NewsJSONpars;
import by.vandr.vkpars.ui.news.NewsAdapter;

/**
 * Created by V on 23.11.2017.
 */
//https://javadevblog.com/primer-raboty-s-viewpager-v-android.html
    //https://javadevblog.com/primer-sozdaniya-navigation-drawer-v-android.html
public class StartNews extends Activity{
    ListView framesContainer;
    NewsAdapter newsAdapter;
    String offset;
    Context ctx;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root_news);

        final Gson gson = new GsonBuilder().setPrettyPrinting().create();

        this.ctx = getApplicationContext();
        offset = "";
        framesContainer = (ListView) findViewById(R.id.newsRoot);


        System.out.println("MMMM");
        VKRequest currentRequest  = new VKRequest(
                "newsfeed.get",
                VKParameters.from(
                        VKApiConst.FILTERS,"post",
                        //VKApiConst.OFFSET, offset,
                        VKApiConst.COUNT,"100"),
                VKApiPost.class);
        currentRequest.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                super.onComplete(response);
                NewsJSONpars newsJSONpars = gson.fromJson(response.responseString, NewsJSONpars.class);
                newsAdapter = new NewsAdapter(getApplicationContext(), newsJSONpars);
                framesContainer.setAdapter(newsAdapter);
            }

            @Override
            public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {
                super.attemptFailed(request, attemptNumber, totalAttempts);
                System.out.println("aattemptFailed");
            }

            @Override
            public void onError(VKError error) {
                super.onError(error);
                Toast.makeText(ctx, error.apiError.toString(), Toast.LENGTH_LONG).show();
                System.out.println(error.apiError);
            }

            @Override
            public void onProgress(VKRequest.VKProgressType progressType, long bytesLoaded, long bytesTotal) {
                super.onProgress(progressType, bytesLoaded, bytesTotal);
                System.out.println("onProgress");
            }
        });

        framesContainer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int x =(new Random().nextInt(300)-position*4);
                int y =(new Random().nextInt(300));
                Toast toast = Toast.makeText(ctx, "Press a "+position, Toast.LENGTH_LONG);
                toast.setGravity(1,x,y);
                toast.show();

            }

        });

    }
}
