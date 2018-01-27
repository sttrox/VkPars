
package by.vandr.vkpars.network.object.Items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attachment_ {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("photo")
    @Expose
    private Photo photo;
    @SerializedName("audio")
    @Expose
    private Audio audio;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

}
