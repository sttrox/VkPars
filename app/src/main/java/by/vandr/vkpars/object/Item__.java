
package by.vandr.vkpars.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item__ {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("album_id")
    @Expose
    private int albumId;
    @SerializedName("owner_id")
    @Expose
    private int ownerId;
    @SerializedName("photo_75")
    @Expose
    private String photo75;
    @SerializedName("photo_130")
    @Expose
    private String photo130;
    @SerializedName("photo_604")
    @Expose
    private String photo604;
    @SerializedName("width")
    @Expose
    private int width;
    @SerializedName("height")
    @Expose
    private int height;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("date")
    @Expose
    private int date;
    @SerializedName("post_id")
    @Expose
    private int postId;
    @SerializedName("access_key")
    @Expose
    private String accessKey;
    @SerializedName("likes")
    @Expose
    private Likes__ likes;
    @SerializedName("reposts")
    @Expose
    private Reposts__ reposts;
    @SerializedName("comments")
    @Expose
    private Comments__ comments;
    @SerializedName("can_comment")
    @Expose
    private int canComment;
    @SerializedName("can_repost")
    @Expose
    private int canRepost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getPhoto75() {
        return photo75;
    }

    public void setPhoto75(String photo75) {
        this.photo75 = photo75;
    }

    public String getPhoto130() {
        return photo130;
    }

    public void setPhoto130(String photo130) {
        this.photo130 = photo130;
    }

    public String getPhoto604() {
        return photo604;
    }

    public void setPhoto604(String photo604) {
        this.photo604 = photo604;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public Likes__ getLikes() {
        return likes;
    }

    public void setLikes(Likes__ likes) {
        this.likes = likes;
    }

    public Reposts__ getReposts() {
        return reposts;
    }

    public void setReposts(Reposts__ reposts) {
        this.reposts = reposts;
    }

    public Comments__ getComments() {
        return comments;
    }

    public void setComments(Comments__ comments) {
        this.comments = comments;
    }

    public int getCanComment() {
        return canComment;
    }

    public void setCanComment(int canComment) {
        this.canComment = canComment;
    }

    public int getCanRepost() {
        return canRepost;
    }

    public void setCanRepost(int canRepost) {
        this.canRepost = canRepost;
    }

}
