package by.vandr.vkpars.network.object;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountInfo {

    @SerializedName("response")
    @Expose
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
    public class Response {

        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("https_required")
        @Expose
        private Integer httpsRequired;
        @SerializedName("2fa_required")
        @Expose
        private Integer _2faRequired;
        @SerializedName("own_posts_default")
        @Expose
        private Integer ownPostsDefault;
        @SerializedName("no_wall_replies")
        @Expose
        private Integer noWallReplies;
        @SerializedName("intro")
        @Expose
        private Integer intro;
        @SerializedName("lang")
        @Expose
        private Integer lang;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Integer getHttpsRequired() {
            return httpsRequired;
        }

        public void setHttpsRequired(Integer httpsRequired) {
            this.httpsRequired = httpsRequired;
        }

        public Integer get2faRequired() {
            return _2faRequired;
        }

        public void set2faRequired(Integer _2faRequired) {
            this._2faRequired = _2faRequired;
        }

        public Integer getOwnPostsDefault() {
            return ownPostsDefault;
        }

        public void setOwnPostsDefault(Integer ownPostsDefault) {
            this.ownPostsDefault = ownPostsDefault;
        }

        public Integer getNoWallReplies() {
            return noWallReplies;
        }

        public void setNoWallReplies(Integer noWallReplies) {
            this.noWallReplies = noWallReplies;
        }

        public Integer getIntro() {
            return intro;
        }

        public void setIntro(Integer intro) {
            this.intro = intro;
        }

        public Integer getLang() {
            return lang;
        }

        public void setLang(Integer lang) {
            this.lang = lang;
        }

    }

}
