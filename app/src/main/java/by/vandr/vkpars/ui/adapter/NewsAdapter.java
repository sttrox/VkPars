package by.vandr.vkpars.ui.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.view.ViewGroup.LayoutParams;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import by.vandr.vkpars.R;
import by.vandr.vkpars.network.object.NewsJSONpars;
import by.vandr.vkpars.network.object.Items.Attachment;
import by.vandr.vkpars.network.object.Items.CopyHistory;
import by.vandr.vkpars.network.object.Items.Item;
import by.vandr.vkpars.network.object.Items.Photo;
import by.vandr.vkpars.network.object.Response;
import by.vandr.vkpars.utils.ConstantManager;

/**
 * Created by V on 09.01.2018.
 */

/**
 * Класс адаптера наследуется от RecyclerView.Adapter с указанием класса,
 * который будет хранить ссылки на виджеты элемента списка, т.е. класса,
 * имплементирующего ViewHolder. В нашем случае класс объявлен внутри класса адаптера.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private static final String TAG = ConstantManager.TAG_PREFIX_DEV + "News Adapter";

    private NewsJSONpars newsJSONpars;
    private List<Photo> mPhotos;
    private final LayoutParams mLayoutParamsMW = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    private final LayoutParams mLayoutParamsWM = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
    private Context mCtx;

    public NewsAdapter(NewsJSONpars newsJSONpars, Context mContext) {
        mCtx = mContext;
        this.newsJSONpars = newsJSONpars;
        Log.d(TAG, "New");
    }

    /**
     * Создание новых View и ViewHolder элемента списка, которые впоследствии могут переиспользоваться.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        Log.d(TAG, "onCreateViewHolder"+ position);

        LinearLayout linearLayout = new LinearLayout(mCtx); //Сохдание основоной разметки CardView
        linearLayout.setOrientation(LinearLayout.VERTICAL); //Установселенеи основной раземетки в вертикальный вид
        linearLayout.setLayoutParams(mLayoutParamsWM);      //установление размера разметки
        LayoutInflater inflater = LayoutInflater.from(mCtx);//для добавление костомных вьюшек на CardView
        View partCaption = inflater.inflate(R.layout.part_news_caption, linearLayout, false);
        //нахождение заголовка поста
        linearLayout.addView(partCaption);                  //добавление заголовка поста в LinerLayout

        Item mItem = newsJSONpars.getResponse().getItems().get(position);
        //находим объект записи

        if (mItem.getCopyHistory() != null) {               //еслить ли репост, то
            View partRepostCaption = inflater.inflate(R.layout.part_news_repost, linearLayout, false);
            //нахождение заголовка репоста
            linearLayout.addView(partRepostCaption);        //добавление заголовка репостнутой записи
        }

        if (!mItem.getText().equals("")) {                  //есть ли текста у освновной записи, то
            TextView text = new TextView(mCtx);             //создаём TextView
            text.setId(6742 * 742);                         //Присваеваем Id 6742*742
            text.setPadding(10, 10, 5, 20); //устанавливаем внешние границы от CardView
            linearLayout.addView(text);                     //добавляем текстовое поле на LinerLayout -> CardView
        }

        if (mItem.getAttachments() != null) {               //есть ли прикреплённые даные, то
            mPhotos = getPhotos(mItem.getAttachments());    //ищем среди них картинки
        }

        if (mPhotos != null) {                              //если нашли картинки
            for (int i = 0; i < mPhotos.size() - 1; i++) {  //проходим по каждой картинке
                Photo tPhoto = mPhotos.get(i);              // получаем Object Photo
                ImageView mImagePhoto = new ImageView(mCtx);//создаём ImageView
                mImagePhoto.setId(tPhoto.hashCode());       // устанавлаваем id ImageView равный hash Photo
                System.out.println(tPhoto.hashCode());      //Выводим Id объекта Photo
                linearLayout.addView(mImagePhoto, mLayoutParamsMW); // добавляем image на LinearLayout->CardView
            }
        }

        CardView cardView = new CardView(mCtx);         //создание освновной CardView для данного элемента
        cardView.addView(linearLayout,mLayoutParamsWM); //разметка на CardView
        ViewHolder v = new ViewHolder(cardView, mItem); //создаём VievHolder с CardView
        return v;                                       //отдаём ViewHolder
    }

    /**
     * Заполнение виджетов View данными из элемента списка с номером i
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //* loc -- local */
        CardView tempCardView = holder.mCardView;
        Response tempResponse = newsJSONpars.getResponse();
        RequestOptions options = new RequestOptions();
        options.circleCrop();

        TextView textCaption = (TextView) tempCardView.findViewById(R.id.newsCaptionTextHaeding);
                                                                        //нахождение TextView заголовка
        int id = holder.mItem.getSourceId();                            //id записи
        String name;                                                    //название группы/юзера

        if (holder.mItem.getCopyHistory() != null) {                    //если есть репост, то
            String nameRepost;                                          //название группы/юхера репоста
            String urlRepostAvatar;                                     //ссылка на аватар группы/юзера
            CopyHistory copyHistory = holder.mItem.getCopyHistory();    //объект пост-репост
            int idRepost = copyHistory.getFromId();                     //откуда id
            if (idRepost < 0) {                                         //если группа, то
                urlRepostAvatar = tempResponse.getGroup(idRepost).getPhoto100();
                                                                        //получаем сылку на аватар
                nameRepost = tempResponse.getGroup(idRepost).getName(); //получаем название группы
            } else {                                                    //если юзер, то
                urlRepostAvatar = tempResponse.getProfile(idRepost).getPhoto100();
                                                                        //получаем аватар
                nameRepost = tempResponse.getProfile(idRepost).getFirstName()
                        + " "
                        + tempResponse.getProfile(idRepost).getLastName();
                                                                        //получаем имя и фамилию
            }
            TextView textCaptionRepost = (TextView) tempCardView.findViewById(R.id.newsRepostCaption);
                                                                        //заголовок репоста
            textCaptionRepost.setText(nameRepost);                      //устанавливаем в заголовок название

            ImageView imageNewsRepostAvatar = (ImageView) tempCardView.findViewById(R.id.newsImageRepostAvatar);
                                                                        //находим аватар репоста аватар репоста

            Glide.with(tempCardView.getContext())                       //предаём конекст
                    .load(urlRepostAvatar)                              //передаём ссылку на репост
                    .apply(options)                                     //устанавливаем параметры скуругления аватаров
                    .into(imageNewsRepostAvatar);                       //передаём ImageView куда ставить аватар
        }
        String urlAvatar;                                               //ссылка на аватар поста
        if (id < 0) {
            urlAvatar = tempResponse.getGroup(id).getPhoto100();
            name = tempResponse.getGroup(id).getName();
        } else {
            name = tempResponse.getProfile(id).getFirstName()
                    + " "
                    + tempResponse.getProfile(id).getLastName();
            urlAvatar = tempResponse.getProfile(id).getPhoto100();
        }

        textCaption.setText(name);
        ImageView imageNewsAvatar = (ImageView) tempCardView.findViewById(R.id.newsCaptionImage);


        Glide.with(tempCardView.getContext())
                .load(urlAvatar)
                .apply(options)
                .into(imageNewsAvatar);

        if (!holder.mItem.getText().equals("")) {
            TextView text = (TextView) tempCardView.findViewById(6742 * 742);
            text.setText(holder.mItem.getText());
        }
        if (mPhotos != null) {
            for (int i = 0; i < mPhotos.size() - 1; i++) {
                Photo tPhoto = mPhotos.get(i);
                final ImageView mImagePhoto = (ImageView) tempCardView.findViewById(tPhoto.hashCode());
                System.out.println(tPhoto.hashCode());
                Glide.with(tempCardView.getContext())
                        .load(maxImageUrl(tPhoto))
                        .into(mImagePhoto);

            }
        }
    }

    @Override
    public int getItemCount() {
        return newsJSONpars.getCount();
    }

    /**
     * Реализация класса ViewHolder, хранящего ссылки на виджеты.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        protected CardView mCardView;
        protected Item mItem;


        private ViewHolder(View itemView, final Item item) {
            super(itemView);
            mCardView = (CardView) itemView;
            mItem = item;
            mCardView.setLayoutParams(mLayoutParamsMW);
            final Context ctx = mCardView.getContext();
            mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!item.getText().equals("")) {
                        TextView tttt = (TextView) mCardView.findViewById(6742 * 742);
                        tttt.setText("toasT");
                    } else {
                        TextView ttt = new TextView(ctx);
                        LinearLayout lin = (LinearLayout) mCardView.getRootView();
                        lin.addView(ttt);
                    }
                }
            });
        }
    }


    private List<Photo> getPhotos(List<Attachment> attachment) {
        ArrayList<Photo> tempPh = new ArrayList<Photo>();
        for (Attachment att : attachment) {
            if ((att != null) & (att.getPhoto() != null)) {
                System.out.println(att.getPhoto());
                tempPh.add(att.getPhoto());
            }
        }
        return tempPh;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    private String getUrlAvatarUser(int id){
        return newsJSONpars.getResponse().getProfile(id).getPhoto100();
    }

    private String getUrlAvatarGroup(int id){
        return newsJSONpars.getResponse().getGroup(id).getPhoto100();
    }

    private String getNameUser(int id){
       return newsJSONpars.getResponse().getProfile(id).getFirstName()
               + " "
               + newsJSONpars.getResponse().getProfile(id).getLastName();
    }

    private String getNameGroup(int id){
        return newsJSONpars.getResponse().getGroup(id).getName();
    }

    private String maxImageUrl(Photo tPhoto) {

        if (tPhoto.getPhoto2560() != null) {
            return tPhoto.getPhoto2560();
        } else if (tPhoto.getPhoto1280() != null) {
            return tPhoto.getPhoto1280();
        } else if (tPhoto.getPhoto807() != null) {
            return tPhoto.getPhoto807();
        } else if (tPhoto.getPhoto604() != null) {
            return tPhoto.getPhoto604();
        } else if (tPhoto.getPhoto130() != null) {
            return tPhoto.getPhoto130();
        } else if (tPhoto.getPhoto75() != null) {
            return tPhoto.getPhoto75();
        }
        return null;
    }
}
