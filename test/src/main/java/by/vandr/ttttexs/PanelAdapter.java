package by.vandr.ttttexs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import static by.vandr.ttttexs.R.color.colorPrimaryDark;

/**
 * Created by V on 13.11.2017.
 */

public class PanelAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater layoutInflater;
    ArrayList<FieldFrame> channelFrame ;

    PanelAdapter(Context context,ArrayList<FieldFrame> arrayList){
        ctx = context;
        channelFrame = arrayList;
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return channelFrame.size();
    }

    @Override
    public Object getItem(int i) {
        return channelFrame.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View tempView = view;
        if (tempView == null) {
            tempView = layoutInflater.inflate(R.layout.channel_layout, viewGroup, false);
            final View finalTempView = tempView;
            ((Button)tempView.findViewById(R.id.want_to_watch_button)).setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View view) {
                    ((RelativeLayout) finalTempView.findViewById(R.id.program_frame)).setBackgroundColor(Color.argb(227, 25, 34, 255));
                }
            });
        }
        return tempView;
    }



    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
