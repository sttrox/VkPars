
package by.vandr.vkpars.object;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Poll {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("owner_id")
    @Expose
    private int ownerId;
    @SerializedName("created")
    @Expose
    private int created;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("votes")
    @Expose
    private String votes;
    @SerializedName("answer_id")
    @Expose
    private int answerId;
    @SerializedName("answers")
    @Expose
    private List<PollsAnswer> answers = null;
    @SerializedName("anonymous")
    @Expose
    private int anonymous;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public List<PollsAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<PollsAnswer> answers) {
        this.answers = answers;
    }

    public int getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(int anonymous) {
        this.anonymous = anonymous;
    }

}
