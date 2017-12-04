
package by.vandr.vkpars.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Preview {

    @SerializedName("photo")
    @Expose
    private Photo_ photo;
    @SerializedName("video")
    @Expose
    private Video video;

    public Photo_ getPhoto() {
        return photo;
    }

    public void setPhoto(Photo_ photo) {
        this.photo = photo;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

}
