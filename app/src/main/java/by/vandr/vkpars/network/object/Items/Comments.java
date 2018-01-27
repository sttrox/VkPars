
package by.vandr.vkpars.network.object.Items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comments {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("groups_can_post")
    @Expose
    private boolean groupsCanPost;
    @SerializedName("can_post")
    @Expose
    private int canPost;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isGroupsCanPost() {
        return groupsCanPost;
    }

    public void setGroupsCanPost(boolean groupsCanPost) {
        this.groupsCanPost = groupsCanPost;
    }

    public int getCanPost() {
        return canPost;
    }

    public void setCanPost(int canPost) {
        this.canPost = canPost;
    }

}
