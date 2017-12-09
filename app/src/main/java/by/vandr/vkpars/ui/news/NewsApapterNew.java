package by.vandr.vkpars.ui.news;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import by.vandr.vkpars.R;
import by.vandr.vkpars.core.NewsJSONpars;
import by.vandr.vkpars.object.CopyHistory;
import by.vandr.vkpars.object.Item;

/**
 * Created by V on 04.12.2017.
 */

public class NewsApapterNew extends RecyclerView.Adapter<NewsApapterNew.ViewHolder> {
    NewsJSONpars newsJSONpars;
    ViewGroup.LayoutParams mLayoutParams;

    public NewsApapterNew(NewsJSONpars news) {
        newsJSONpars = news;
        mLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    /**
     * Создание новых View и ViewHolder элемента списка, которые впоследствии могут переиспользоваться.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        CardView cardView = new CardView(parent.getContext());
        System.out.println(position);
        System.out.println("<><");

        LinearLayout linearLayout = new LinearLayout(parent.getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View partCaption =inflater.inflate(R.layout.part_news_caption, linearLayout, false);

        Item item = newsJSONpars.getResponse().getItems().get(position);
        linearLayout.addView(partCaption);

        if (item.getCopyHistory() != null) {
            View partRepostCaption =inflater.inflate(R.layout.part_news_repost, linearLayout, false);
            linearLayout.addView(partRepostCaption);
        }

        if (!item.getText().equals("")) {
            TextView text = new TextView(parent.getContext());
            text.setId(6742 * 742);
            text.setPadding(10,10,5,20);
            linearLayout.addView(text);
        }

        cardView.addView(linearLayout,new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        ViewHolder v = new ViewHolder(cardView, item);
        return v;
    }

    /**
     * Заполнение виджетов View данными из элемента списка с номером i
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        TextView textCaption = (TextView) holder.mCardView.findViewById(R.id.newsCaptionTextHaeding);
        int id = holder.mItem.getSourceId();
        String name;
        if (holder.mItem.getCopyHistory() != null) {
            String nameRepost;
            String urlRepostAvatar;
            CopyHistory copyHistory = holder.mItem.getCopyHistory();
            int idRepost = copyHistory.getFromId();
            if (idRepost < 0) {

                urlRepostAvatar = newsJSONpars.getResponse().getGroup(idRepost).getPhoto100();
                nameRepost = newsJSONpars.getResponse().getGroup(idRepost).getName();
            } else {

                urlRepostAvatar = newsJSONpars.getResponse().getProfile(idRepost).getPhoto100();
                nameRepost = newsJSONpars.getResponse().getProfile(idRepost).getFirstName()
                        + " "
                        + newsJSONpars.getResponse().getProfile(idRepost).getLastName();
            }
            TextView textCaptionRepost = (TextView) holder.mCardView.findViewById(R.id.newsRepostCaption);
            textCaptionRepost.setText(nameRepost);

            ImageView imageNewsRepostAvatar = (ImageView) holder.mCardView.findViewById(R.id.newsImageRepostAvatar);

            Glide.with(holder.mCardView.getContext())
                    .load(urlRepostAvatar)
                    .into(imageNewsRepostAvatar);
      }

        String urlAvatar;
        if (id < 0) {
            urlAvatar = newsJSONpars.getResponse().getGroup(id).getPhoto100();
            name = newsJSONpars.getResponse().getGroup(id).getName();
        } else {
            name = newsJSONpars.getResponse().getProfile(id).getFirstName()
                    + " "
                    + newsJSONpars.getResponse().getProfile(id).getLastName();
            urlAvatar = newsJSONpars.getResponse().getProfile(id).getPhoto100();
        }
        textCaption.setText(name);
        ImageView imageNewsAvatar = (ImageView) holder.mCardView.findViewById(R.id.newsCaptionImage);

        Glide.with(holder.mCardView.getContext())
                .load(urlAvatar)
                .into(imageNewsAvatar);

        if (!holder.mItem.getText().equals("")) {
            TextView text = (TextView) holder.mCardView.findViewById(6742 * 742);
            text.setText(holder.mItem.getText());
        }

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return newsJSONpars.getCount();
    }

    /**
     * Реализация класса ViewHolder, хранящего ссылки на виджеты.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        public CardView mCardView;
        public Item mItem;


        public ViewHolder(View itemView, Item item) {
            super(itemView);
            mCardView = (CardView) itemView;
            mItem = item;
            mCardView.setLayoutParams(mLayoutParams);
        }
    }


}
