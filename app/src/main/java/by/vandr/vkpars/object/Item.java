
package by.vandr.vkpars.object;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("source_id")
    @Expose
    private int sourceId;
    @SerializedName("date")
    @Expose
    private long date;
    @SerializedName("post_id")
    @Expose
    private int postId;
    @SerializedName("post_type")
    @Expose
    private String postType;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("marked_as_ads")
    @Expose
    private int markedAsAds;
    @SerializedName("attachments")
    @Expose
    private List<Attachment> attachments = null;
    @SerializedName("post_source")
    @Expose
    private PostSource postSource;
    @SerializedName("comments")
    @Expose
    private Comments comments;
    @SerializedName("likes")
    @Expose
    private Likes likes;
    @SerializedName("reposts")
    @Expose
    private Reposts reposts;
    @SerializedName("views")
    @Expose
    private Views views;
    @SerializedName("photos")
    @Expose
    private Photos photos;
    @SerializedName("photo_tags")
    @Expose
    private PhotoTags photoTags;
    @SerializedName("friends")
    @Expose
    private Friends friends;
    @SerializedName("notes")
    @Expose
    private Notes notes;
    @SerializedName("copy_history")
    @Expose
    //private List<CopyHistory> copyHistory = null;
    private List<CopyHistory> copyHistory = null;

    @SerializedName("signer_id")
    @Expose
    private int signerId;

    @SerializedName("video")
    @Expose
    private Video_ video;
    @SerializedName("friends_only")
    @Expose
    private int friendsOnly;
    @SerializedName("geo")
    @Expose
    private Geo geo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public long getDate() {
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

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getMarkedAsAds() {
        return markedAsAds;
    }

    public void setMarkedAsAds(int markedAsAds) {
        this.markedAsAds = markedAsAds;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public PostSource getPostSource() {
        return postSource;
    }

    public void setPostSource(PostSource postSource) {
        this.postSource = postSource;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    public Reposts getReposts() {
        return reposts;
    }

    public void setReposts(Reposts reposts) {
        this.reposts = reposts;
    }

    public Views getViews() {
        return views;
    }

    public void setViews(Views views) {
        this.views = views;
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public PhotoTags getPhotoTags() {
        return photoTags;
    }

    public void setPhotoTags(PhotoTags photoTags) {
        this.photoTags = photoTags;
    }

    public Friends getFriends() {
        return friends;
    }

    public void setFriends(Friends friends) {
        this.friends = friends;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public CopyHistory getCopyHistory() {
        if ( copyHistory!=null) {
            return copyHistory.get(0);
        }
        return null;
    }

    public void setCopyHistory(List<CopyHistory> copyHistory) {
        this.copyHistory = copyHistory;
    }

    public long getSignerId() {
        return signerId;
    }

    public void setSignerId(int signerId) {
        this.signerId = signerId;
    }

    public Video_ getVideo() {
        return video;
    }

    public void setVideo(Video_ video) {
        this.video = video;
    }

    public int getFriendsOnly() {
        return friendsOnly;
    }

    public void setFriendsOnly(int friendsOnly) {
        this.friendsOnly = friendsOnly;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

}
