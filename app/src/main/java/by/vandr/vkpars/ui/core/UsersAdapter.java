package by.vandr.vkpars.ui.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.model.VKApiUser;

import com.vk.sdk.api.model.VKUsersArray;

import by.vandr.vkpars.R;

/**
 * Created by V on 13.11.2017.
 */
public class UsersAdapter extends BaseAdapter {
    Context ctx;
    VKUsersArray usersArray;
    //LayoutInflater layoutInflater;

    public UsersAdapter(Context context, VKUsersArray usersArray){
        this.ctx = context;
        this.usersArray = usersArray;
    }


    @Override
    public int getCount() {
        System.out.println("getCount "+usersArray.size());
        return usersArray.size();
    }

    @Override
    public VKApiUser getItem(int position) {

        return usersArray.get(position);
    }

    @Override
    public long getItemId(int position) {
//position--;

        return position;
    }


    static class ViewHolder{
        TextView textView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater)  ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_user, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView)convertView.findViewById(R.id.textFielName);
            convertView.setTag(viewHolder);
        } else {
            viewHolder=(ViewHolder)convertView.getTag();
        }

        viewHolder.textView.setText((getItem(position)).first_name+" "+(getItem(position)).last_name);
        return convertView;
    }
}
