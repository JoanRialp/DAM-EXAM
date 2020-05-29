package cat.udl.tidic.amd.dam_tips.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Question {

    @SerializedName("id")
    private int id;
    @SerializedName("question")
    private String question;
    @SerializedName("category")
    private String category;
    @SerializedName("answers")
    private List<Answer> answers;

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Question() {
    }

}
