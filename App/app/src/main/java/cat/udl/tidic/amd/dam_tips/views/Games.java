package cat.udl.tidic.amd.dam_tips.views;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.progresviews.ProgressWheel;

import java.util.Random;

import cat.udl.tidic.amd.dam_tips.R;
import cat.udl.tidic.amd.dam_tips.dao.AccountDAO;
import cat.udl.tidic.amd.dam_tips.dao.AccountDAOImpl;
import cat.udl.tidic.amd.dam_tips.dialog.DialogQuestion;
import cat.udl.tidic.amd.dam_tips.models.Question;
import params.com.stepprogressview.StepProgressView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Games  extends CustomActivty{

    private AccountDAO accountDAO = new AccountDAOImpl();
    private Question llistaQuestions = null;

    private int contador1 = 0;
    private int contador2 = 0;
    private int contador3 = 0;
    private int contador4 = 0;

    private TextView categoria;
    private TextView pregunta;
    private TextView guanyar;
    private Button round;
    private ImageView vida1;
    private ImageView vida2;
    private ImageView vida3;
    private StepProgressView stepProgressView2;
    private int porcentage = 0;
    private int index = 0;
    private ProgressWheel progresso_general;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initView();
    }

    protected void initView(){
        categoria = findViewById(R.id.game_categoria);
        round = findViewById(R.id.roll);
        pregunta = findViewById(R.id.game_pregunta);
        vida1 = findViewById(R.id.vida1);
        vida2 = findViewById(R.id.vida2);
        vida3 = findViewById(R.id.vida3);
        progresso_general = findViewById(R.id.progresso_general);
        stepProgressView2 = findViewById(R.id.stepProgressView2);
        guanyar = findViewById(R.id.games_guanyar);

        getQuestions("os");

        round.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogQuestion dialog = DialogQuestion.newInstance(Games.this);
                dialog.setCancelable(false);
                dialog.addpregunta(llistaQuestions.getAnswers(), Games.this);
                dialog.show(getSupportFragmentManager(),"TerminosCondicionesTag");
            }
        });
    }

    private void getQuestions(String category){

        accountDAO.questionList(category).enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                Log.d(TAG, "Url: " + call.request().url());
                Log.d(TAG, "req: " + call.request().toString());
                if(response.code() == 200) {
                    Log.d(TAG, "Se ha obtenido correctamente la lista de assignaturas.");

                    llistaQuestions = response.body();
                    Log.d(TAG, "llista retornada2 " + llistaQuestions);

                    pregunta.setText(llistaQuestions.getQuestion());
                    categoria.setText(llistaQuestions.getCategory());
                }else{
                    Log.d(TAG, "No se ha obtenido correctamente la lista de assignaturas.");
                    Log.d(TAG, "API code | message: " + response.code()+ " | " +response.message());
                }
            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {
                Log.d(TAG, "Error en la comunicación con API: " + t.getMessage());
            }
        });
    }

    public void setResult(String result)
    {
        if(result.equals("true"))
        {
            porcentage = porcentage + 9;
            index = index + 1;
            progresso_general.setPercentage(porcentage);
            progresso_general.setStepCountText( String.valueOf(index));
            stepProgressView2.setCurrentProgress(porcentage);

            switch (llistaQuestions.getCategory()) {
                case "os":
                    contador1++;
                    break;
                case "db":
                    contador2++;
                    break;
                case "net":
                    contador3++;
                    break;
                case "patterns":
                    contador4++;
                    break;
            }
        }

        else{
            progresso_general.setPercentage(porcentage+8);
            progresso_general.setStepCountText( String.valueOf(index+1));

            if(vida1.getVisibility() == View.VISIBLE)
            {
                vida1.setVisibility(View.INVISIBLE);
            }
            else if(vida2.getVisibility() == View.VISIBLE)
            {
                vida2.setVisibility(View.INVISIBLE);
            }
            else
            {
                vida3.setVisibility(View.INVISIBLE);
                guanyar.setText("You Lose");
                round.setEnabled(false);
            }
        }

        if (contador1 < 3)
        {
            getQuestions("os");
        }
        else if (contador2 < 3)
        {
            getQuestions("db");
        }
        else if (contador3 < 3)
        {
            getQuestions("net");
        }
        else if (contador4 < 3)
        {
            getQuestions("patterns");
        }
        else
        {
            guanyar.setText("You Win");
            round.setEnabled(false);
        }

    }

}
