package com.digiteka.digiteka_sdk_mobile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.digiteka.sdk.Digiteka;


//import mg.ima.digitekaplayerweb.DigitekaEvent;
//import com.digiteka.sdk.Digiteka;



public class Demo extends AppCompatActivity /*implements DigitekaEvent*/ {

    int NB_topleft ;
    int NB_topright ;
    int NB_bottomleft ;
    int NB_bottomright ;

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String consentString = mPreferences.getString("IABTCF_TCString", "");

        if(savedInstanceState!=null){ // TODO : Restored Data

            NB_topleft = savedInstanceState.getInt("top_left") ; // 1
            NB_topright = savedInstanceState.getInt("top_right") ; // 0
            NB_bottomleft = savedInstanceState.getInt("bottom_left") ;

        }else {

            Intent intent = getIntent();
            NB_topleft = intent.getIntExtra("top_left",0);
            NB_topright = intent.getIntExtra("top_right",0);
            NB_bottomleft = intent.getIntExtra("bottom_left",0);

        }

        //integration du digiteka
        //digitekaWeb = new DigitekaWeb();
        View containerDigiteka = findViewById(R.id.container_digiteka);

        if(NB_topleft!=0){ // 1

            Digiteka.init(containerDigiteka, //container du player
                    this,//contexte de l'application
                    750,// Hauteur du digiteka
                    "pqvp3r", //ID de la vidéo
                    1 , //Mode de déclenchement du Player
                    "https://www.20minutes.fr/arts-stars/television/2981275-20210222-marseillais-dubai-quand-ca-allait-tapais-poing-table-previent-jessica-aidi-bookeuse", //urlreferrer
                    //"BOj8iv4Oj8iwYAHABAlxCS-AAAAnF7_______9______9uz_Ov_v_f__33e87_9v_l_7_-___u_-3zd4-_1vf99yfm1-7etr3tp_87ues2_Xur__59__3z3_9phPrsk89r633A", //Consent String
                    consentString,
                    "01132356","54",
                    false/*,//Paramètre du SDK
                    50,"top_left",3,5*/); //Paramètre du Visible Player
        }
        else if(NB_topright!=0){
            Digiteka.init(containerDigiteka,
                    this,
                    750,
                    "pqvp3r",
                    2 ,
                    "https://www.20minutes.fr/arts-stars/television/2981275-20210222-marseillais-dubai-quand-ca-allait-tapais-poing-table-previent-jessica-aidi-bookeuse",
                    //"BOj8iv4Oj8iwYAHABAlxCS-AAAAnF7_______9______9uz_Ov_v_f__33e87_9v_l_7_-___u_-3zd4-_1vf99yfm1-7etr3tp_87ues2_Xur__59__3z3_9phPrsk89r633A",
                    consentString,
                    "01132356","54",
                    true,
                    50,"top_right",3,5);
        }
        else if(NB_bottomleft!=0){
            Digiteka.init(containerDigiteka,
                    this,
                    750,
                    "pqvp3r",
                    0 ,
                    "https://www.20minutes.fr/arts-stars/television/2981275-20210222-marseillais-dubai-quand-ca-allait-tapais-poing-table-previent-jessica-aidi-bookeuse",
                    //"BOj8iv4Oj8iwYAHABAlxCS-AAAAnF7_______9______9uz_Ov_v_f__33e87_9v_l_7_-___u_-3zd4-_1vf99yfm1-7etr3tp_87ues2_Xur__59__3z3_9phPrsk89r633A",
                    consentString,
                    "01132356","54",
                    true,
                    50,"bottom_left",3,5);
        }

        Log.e("rgpd_consent","IABTCF_TCString = "+consentString);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        //TODO : Saved DATA
        outState.putInt("top_left",NB_topleft);
        outState.putInt("top_right",NB_topright);
        outState.putInt("bottom_left",NB_bottomleft);
        Log.e("PUT DATA","OK") ;

    }


    /*@Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(Demo.this, MainActivity.class);
        startActivity(i);
        finish();

    }*/

    /*@Override
    public void sdkReady() {

    }

    @Override
    public void onError() {
    }*/

}