package cat.udl.tidic.amd.dam_tips.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import cat.udl.tidic.amd.dam_tips.R;


import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.app.progresviews.ProgressWheel;

import java.util.List;

import cat.udl.tidic.amd.dam_tips.models.Answer;
import cat.udl.tidic.amd.dam_tips.views.Games;

public class DialogQuestion extends DialogFragment {

    private View rootView;
    private Games activity;
    private List<Answer> respostes;
    private String respostaFinal = "null";

    public static DialogQuestion newInstance(Games activity) {
        DialogQuestion dialog = new DialogQuestion();
        dialog.activity = activity;
        return dialog;
    }

    public void addpregunta(List<Answer> mrespostes, Games gamesView){
        respostes = mrespostes;
        activity = gamesView;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        initViews();
        AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setView(rootView)
                .setTitle("Answers")
                .setCancelable(true)
                .setPositiveButton("Back", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       if(!respostaFinal.equals("null"))
                       {
                           activity.setResult(respostaFinal);
                       }
                    }
                })
                .create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        return alertDialog;
    }

    private void initViews() {
        rootView = LayoutInflater.from(getContext()).inflate(R.layout.activity_question, null, false);
        TextView resposata1 = rootView.findViewById(R.id.dialog_resposat1);
        TextView resposata2 = rootView.findViewById(R.id.dialog_resposat2);
        TextView resposata3 = rootView.findViewById(R.id.dialog_resposat3);
        TextView resposata4 = rootView.findViewById(R.id.dialog_resposat4);
        Button resp1 = rootView.findViewById(R.id.dialog_resp1);
        Button resp2 = rootView.findViewById(R.id.dialog_resp2);
        Button resp3 = rootView.findViewById(R.id.dialog_resp3);
        Button resp4 = rootView.findViewById(R.id.dialog_resp4);

        TextView result = rootView.findViewById(R.id.dialog_resultat);


        String[] valorsRespostes = new String[4];

        int contador = 0;

        for(Answer model : respostes) {
            if(contador == 0) {
                resposata1.setText(model.getAnswer());
                valorsRespostes[0] = model.getIs_correct();
            }
            if(contador == 1) {
                resposata2.setText(model.getAnswer());
                valorsRespostes[1] = model.getIs_correct();
            }
            if(contador == 2) {
                resposata3.setText(model.getAnswer());
                valorsRespostes[2] = model.getIs_correct();
            }
            if(contador == 3) {
                resposata4.setText(model.getAnswer());
                valorsRespostes[3] = model.getIs_correct();
            }
            contador++;
        }

        resp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valorsRespostes[0].equals("true"))
                {
                    result.setText("Correct");
                    resp1.setEnabled(false);
                    resp2.setEnabled(false);
                    resp3.setEnabled(false);
                    resp4.setEnabled(false);
                    respostaFinal = "true";
                }
                else
                {
                    result.setText("Incorrect");
                    resp1.setEnabled(false);
                    resp2.setEnabled(false);
                    resp3.setEnabled(false);
                    resp4.setEnabled(false);
                    respostaFinal = "false";
                }

            }
        });
        resp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valorsRespostes[1].equals("true"))
                {
                    result.setText("Correct");
                    resp1.setEnabled(false);
                    resp2.setEnabled(false);
                    resp3.setEnabled(false);
                    resp4.setEnabled(false);
                    respostaFinal = "true";
                }
                else
                {
                    result.setText("Incorrect");
                    resp1.setEnabled(false);
                    resp2.setEnabled(false);
                    resp3.setEnabled(false);
                    resp4.setEnabled(false);
                    respostaFinal = "false";
                }

            }
        });
        resp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valorsRespostes[2].equals("true"))
                {
                    result.setText("Correct");
                    resp1.setEnabled(false);
                    resp2.setEnabled(false);
                    resp3.setEnabled(false);
                    resp4.setEnabled(false);
                    respostaFinal = "true";
                }
                else
                {
                    result.setText("Incorrect");
                    resp1.setEnabled(false);
                    resp2.setEnabled(false);
                    resp3.setEnabled(false);
                    resp4.setEnabled(false);
                    respostaFinal = "false";
                }

            }
        });
        resp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valorsRespostes[3].equals("true"))
                {
                    result.setText("Correct");
                    resp1.setEnabled(false);
                    resp2.setEnabled(false);
                    resp3.setEnabled(false);
                    resp4.setEnabled(false);
                    respostaFinal = "true";
                }
                else
                {
                    result.setText("Incorrect");
                    resp1.setEnabled(false);
                    resp2.setEnabled(false);
                    resp3.setEnabled(false);
                    resp4.setEnabled(false);
                    respostaFinal = "false";
                }

            }
        });
    }



}
