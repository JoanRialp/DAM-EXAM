package cat.udl.tidic.amd.dam_tips.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Answer {

    @SerializedName("id")
    private int id;
    @SerializedName("answer")
    private String answer;
    @SerializedName("is_correct")
    private String is_correct;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getIs_correct() {
        return is_correct;
    }

    public void setIs_correct(String is_correct) {
        this.is_correct = is_correct;
    }

}
