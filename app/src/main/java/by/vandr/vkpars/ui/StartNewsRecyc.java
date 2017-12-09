package by.vandr.vkpars.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiPost;

import java.sql.SQLOutput;

import by.vandr.vkpars.R;
import by.vandr.vkpars.core.NewsJSONpars;
import by.vandr.vkpars.ui.core.RecyclerSpacesItemDecoration;
import by.vandr.vkpars.ui.news.NewsApapterNew;

/**
 * Created by V on 04.12.2017.
 */

public class StartNewsRecyc extends Activity {
    Context ctx;
    Gson gson;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_new);
        ctx = this;
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // mRecyclerView.setPadding(30,30,30,30);
        //mRecyclerView.setHasFixedSize(false);
        //mRecyclerView.layout(6,66,66,66);

        mRecyclerView.addItemDecoration(new RecyclerSpacesItemDecoration(30));

        mLayoutManager = new LinearLayoutManager(ctx);
        mRecyclerView.setLayoutManager(mLayoutManager);

        String[] myDataset = new String[10];
        for (int i = 0; i < 10; i++) {
            myDataset[i] += i;
        }
        // specify an adapter (see also next example)
        gson = new GsonBuilder().setPrettyPrinting().create();
        // public NewsJSONpars getResponse(String next) {
        VKRequest currentRequest = new VKRequest(
                "newsfeed.get",
                VKParameters.from(
                        VKApiConst.FILTERS, "post",
                        //VKApiConst.OFFSET, offset,
                        VKApiConst.COUNT, "100"),
                VKApiPost.class);
        currentRequest.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                super.onComplete(response);
                NewsJSONpars newsJSONpars = gson.fromJson(response.responseString, NewsJSONpars.class);
                System.out.println("Start<<");
                mAdapter = new NewsApapterNew(newsJSONpars);
                mRecyclerView.setAdapter(mAdapter);
                //newsAdapter = new NewsAdapter(, newsJSONpars);
                //framesContainer.setAdapter(newsAdapter);
            }

            @Override
            public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {
                super.attemptFailed(request, attemptNumber, totalAttempts);
                System.out.println("aattemptFailed");
            }

            @Override
            public void onError(VKError error) {
                super.onError(error);
                Toast.makeText(ctx, error.toString(), Toast.LENGTH_LONG).show();
                System.out.println(error.apiError);
            }

            @Override
            public void onProgress(VKRequest.VKProgressType progressType, long bytesLoaded, long bytesTotal) {
                super.onProgress(progressType, bytesLoaded, bytesTotal);
                System.out.println("onProgress");
            }
        });
    }

}



