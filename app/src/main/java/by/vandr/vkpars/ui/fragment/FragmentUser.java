package by.vandr.vkpars.ui.fragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKBatchRequest;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.methods.VKApiUsers;
import com.vk.sdk.api.model.VKApiPost;
import com.vk.sdk.api.model.VKApiUser;
import com.vk.sdk.api.model.VKList;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.util.VKStringJoiner;

import by.vandr.vkpars.R;


/**
 * Created by V on 08.11.2017.
 */

public class FragmentUser extends Fragment implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);   }
   // TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user, container, false);
         Button button = (Button) v.findViewById(R.id.btnAddOfUser);

        button.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View v) {
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        lParams.gravity = Gravity.CENTER;

        final TextView textView;
        textView = (TextView)getActivity().findViewById(R.id.textUser);

        final VKRequest request = VKApi.users().get(VKParameters.from(VKApiConst.USER_IDS,"1"));
        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                super.onComplete(response);
                VKList<VKApiUser> users = (VKList<VKApiUser>) response.parsedModel;
                // textView.setText(response.parsedModel);
                for(VKApiUser user:users ){
                    textView.setText(user.first_name);
                }
            }
        });
    }
}
