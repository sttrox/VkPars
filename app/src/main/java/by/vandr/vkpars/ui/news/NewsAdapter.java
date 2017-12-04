package by.vandr.vkpars.ui.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import by.vandr.vkpars.R;
//import by.vandr.vkpars.core.CircularTransformation;
import by.vandr.vkpars.object.CopyHistory;
import by.vandr.vkpars.object.Group;
import by.vandr.vkpars.object.Item;
import by.vandr.vkpars.core.NewsJSONpars;
import by.vandr.vkpars.object.Profile;

/**
 * Created by V on 23.11.2017.
 */

public class NewsAdapter extends BaseAdapter {

    NewsJSONpars newsJSONpars = new NewsJSONpars();
    Context ctx;
    LayoutInflater inflater;

    public NewsAdapter(Context ctx, NewsJSONpars newsJSONpars) {
        this.ctx = ctx;
        this.newsJSONpars = newsJSONpars;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {

        System.out.println(newsJSONpars.getCount());
        return newsJSONpars.getCount();
    }

    @Override
    public Item getItem(int position) {
        return newsJSONpars.getResponse().getItems().get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = getItem(position);
        String name = "";
        String urlAvatar = "";

        int id = item.getSourceId();

        if (id < 0) {
            Group group = newsJSONpars.getResponse().getGroup(id);
            name = group.getName();
            urlAvatar = group.getPhoto50();

        } else {
            Profile profile = newsJSONpars.getResponse().getProfile(id);
            name = profile.getFirstName() + profile.getLastName();
            urlAvatar = profile.getPhoto50();
        }

        LinearLayout root = new LinearLayout(ctx);
        root.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);


        View viewNewsPartCaption = (inflater.inflate(R.layout.part_news_caption, parent, false));

        ImageView imageAvatarCaption = (ImageView) viewNewsPartCaption.findViewById(R.id.newsCaptionImage);
        Glide.with(ctx)
                .load(urlAvatar)
                .into(imageAvatarCaption);

        TextView textCaptionHeading = (TextView) viewNewsPartCaption.findViewById(R.id.newsCaptionTextHaeding);
        textCaptionHeading.setText(name);



        TextView textCaptionDate = (TextView) viewNewsPartCaption.findViewById(R.id.newsCaptionTextDate);
        Date date = new Date(item.getDate()*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM YYYY HH:mm"); //ss
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+3"));
        String datePost = sdf.format(date);

        textCaptionDate.setText(datePost);
        //addCaption
        root.addView(viewNewsPartCaption, layoutParams);


        if (newsJSONpars.getResponse().getItems().get(position).getCopyHistory() != null) {
            CopyHistory copyHistory = newsJSONpars.getResponse().getItems().get(position).getCopyHistory();
            String nameRepost;
            String urlRepostAvatar;
            int idTemp = copyHistory.getFromId();
            if (idTemp > 0) {
                Profile profile = newsJSONpars.getResponse().getProfile(idTemp);
                nameRepost = profile.getFirstName()
                        + " "
                        + profile.getLastName();
                urlRepostAvatar = profile.getPhoto50();
            } else {
                Group group = newsJSONpars.getResponse().getGroup(idTemp);
                nameRepost = group.getName();
                urlRepostAvatar = group.getPhoto50();
            }

            View viewNewsPartRepost = inflater.inflate(R.layout.part_news_repost, parent, false);
            ImageView imageNewsRepostAvatar = (ImageView) viewNewsPartRepost.findViewById(R.id.newsImageRepostAvatar);

            Glide.with(ctx)
                    .load(urlRepostAvatar)
                    .into(imageNewsRepostAvatar);

            TextView textRepostHeading = (TextView) viewNewsPartRepost.findViewById(R.id.newsRepostCaption);
            textRepostHeading.setText(nameRepost);

            Date dateRepost = new Date((long)item.getDate()*1000L);
            SimpleDateFormat sdfRepost = new SimpleDateFormat("YYYY MM dd HH:mm:ss");
            ///sdfRepost.setTimeZone(TimeZone.getTimeZone("GMT-4"));
            String dateRePost = sdf.format(dateRepost);

            TextView textRepostDate = (TextView) viewNewsPartRepost.findViewById(R.id.newsRepostDate);
            textRepostDate.setText(dateRePost);
            //addCaption

            LinearLayout.LayoutParams paramsRepost = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            paramsRepost.leftMargin = 12;
            root.addView(viewNewsPartRepost, paramsRepost);
        }
        if (item.getText() != null) {
            TextView textView = new TextView(ctx);
            textView.setText(item.getText());
            LinearLayout.LayoutParams paramsRepost = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            root.addView(textView,paramsRepost);
        }

        return root;
    }
}
