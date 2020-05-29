package cat.udl.tidic.amd.dam_tips.dao;

import com.google.gson.JsonObject;

import cat.udl.tidic.amd.dam_tips.models.Question;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AccountDAO {

    @Headers("Content-Type:application/json; charset=UTF-8")

    @POST("account/create_token")
    Call<JsonObject> createTokenUser();

    @POST("account/delete_token")
    Call<Void> deleteTokenUser(@Body JsonObject token);

    @GET("trivial/question")
    Call<Question> questionList(@Query("category") String category);
}
