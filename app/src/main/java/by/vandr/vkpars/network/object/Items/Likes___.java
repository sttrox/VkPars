
package by.vandr.vkpars.network.object.Items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Likes___ {

    @SerializedName("user_likes")
    @Expose
    private int userLikes;
    @SerializedName("count")
    @Expose
    private int count;

    public int getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(int userLikes) {
        this.userLikes = userLikes;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
