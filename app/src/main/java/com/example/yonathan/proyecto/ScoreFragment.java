package com.example.yonathan.proyecto;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yonathan.proyecto.Board.BadActivity;
import com.example.yonathan.proyecto.Board.GoodActivity;
import com.example.yonathan.proyecto.Board.NeutralActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {




    public ScoreFragment() {
        // Required empty public constructor
    }
    private TextView time,score,badscore;
    int addtime;
    int total,intentos;

CountDownTimer timers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_score, container, false);

        // Inflate the layout for this fragment
        time = v.findViewById(R.id.timer);
        score= v.findViewById(R.id.txtpuntos);
        badscore=v.findViewById(R.id.badscore);




      timers = new CountDownTimer(20000, 1000) {

            public void onTick(long millisUntilFinished) {
                if(intentos == 3){
                    Intent intent = new Intent(getActivity(), BadActivity.class);
                }
                time.setText("Tiempo: " + (millisUntilFinished+addtime) / 1000);


            }

            public void onFinish() {
                time.setText("done!");

                    if(total <=10){
                        Intent intent = new Intent(getActivity(), BadActivity.class);
                        startActivity(intent);
                    }
                    else if(total <= 40){
                        Intent intent = new Intent(getActivity(), NeutralActivity.class);
                        startActivity(intent);
                    }
                    else if(total <=100){
                        Intent intent = new Intent(getActivity(), GoodActivity.class);
                        startActivity(intent);
                    }

               // Intent intent = new Intent(getActivity(), MenuActivity.class);
                //startActivity(intent);

            }




        }.start();

        return v;
    }

    public void updateInfo(int Score){
       // total = 41;
         total = total + Score;

        score.setText(String.valueOf(total));
        addtime = 4000;
        //score.setText(String.valueOf(Score));

    }

    public void updatebadscore(int Score){

            intentos = intentos + Score;

       // badscore.setText(String.valueOf(Score));
        badscore.setText(String.valueOf(intentos));
    }
    public void onStop(){
        ScoreFragment.super.onStop();
        timers.cancel();
    }



}
