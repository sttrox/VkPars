package by.vandr.vkpars.network.object.Items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attachment {


    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("video")
    @Expose
    private Video video;

    @SerializedName("photo")
    @Expose
    private Photo photo;
    @SerializedName("audio")
    @Expose
    private Audio audio;
    @SerializedName("doc")
    @Expose
    private Doc doc;
    @SerializedName("market")
    @Expose
    private Market market;
    @SerializedName("poll")
    @Expose
    private Poll poll;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

}
