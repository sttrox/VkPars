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
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiUser;

import com.vk.sdk.api.model.VKUsersArray;

import org.json.JSONException;

//import by.vandr.vkpars.object.Post;
import by.vandr.vkpars.ui.core.UsersAdapter;

/**
 * Created by V on 13.11.2017.
 */

public class StartSearch extends Activity{
    ListView framesContainer;
    Toast toast;
    UsersAdapter usersAdapter;
   // VKUsersArray usersArray;

    public void getFaveUsers(){
        VKRequest currentRequest  = new VKRequest(
                "fave.getUsers",
                VKParameters.from(VKApiConst.OFFSET, "0",VKApiConst.COUNT,"100"),
                VKRequest.HttpMethod.GET,
                VKUsersArray.class);

        currentRequest.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                VKUsersArray usArr = new VKUsersArray();
                super.onComplete(response);
                try {
                    System.out.println(response.json);

                    usArr.parse(response.json);

                    frameFild(usArr);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        currentRequest.start();

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_search);
        getFaveUsers();

        framesContainer = (ListView)findViewById(R.id.list_item_user);
        framesContainer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toast = Toast.makeText(view.getContext(),usersAdapter.getItem(position).first_name,Toast.LENGTH_LONG);
                toast = Toast.makeText(view.getContext(),getFilesDir().getAbsolutePath(),Toast.LENGTH_LONG);

                toast.show();
            }
        });
    }

    public  void  frameFild(VKUsersArray vkUsersArray){
        usersAdapter = new UsersAdapter(getApplicationContext(),  vkUsersArray);
        framesContainer.setAdapter(usersAdapter);
    }
}
