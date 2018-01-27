package by.vandr.vkpars.network.object.Items;

/**
 * Created by V on 08.01.2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Answer {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("votes")
    @Expose
    private int votes;
    @SerializedName("rate")
    @Expose
    private int rate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

}