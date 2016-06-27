package com.example.xross.volleyjson;


import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

public class MainActivity extends Activity {

    // json object response url
    private String urlToken = "http://sfsuswe.com/413/get_token/?username=dmrobbin&password=913404159";

    private String quiztoken;

    private int score = 0;

    // json array response url
    private String urlQuestion = "http://sfsuswe.com/413/get_question/?token="+quiztoken ;


    private static String TAG = MainActivity.class.getSimpleName();
    private Button btnGetToken, btnGetQuestion,
            AnswerA,AnswerB,AnswerC,AnswerD,AnswerE,AnswerF;

    // Progress dialog
    private ProgressDialog pDialog;

    private TextView txtResponse;

    private TextView scoreBoard;

    private String correctAnswer, ansA,ansB,ansC,ansD,ansE,ansF;

    // temporary string to show the parsed response
    private String jsonResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        AnswerA = (Button) findViewById(R.id.btnAnswerA);
        AnswerB = (Button) findViewById(R.id.btnAnswerB);
        AnswerC = (Button) findViewById(R.id.btnAnswerC);
        AnswerD = (Button) findViewById(R.id.btnAnswerD);
        AnswerE = (Button) findViewById(R.id.btnAnswerE);
        AnswerF = (Button) findViewById(R.id.btnAnswerF);
        btnGetToken = (Button) findViewById(R.id.tokenRequest);
        btnGetQuestion = (Button) findViewById(R.id.questionRequest);
        txtResponse = (TextView) findViewById(R.id.txtResponse);
        scoreBoard = (TextView) findViewById(R.id.scoreView);
        btnGetQuestion.setVisibility(View.INVISIBLE);
/*
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
*/
        btnGetToken.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                getToken(); //getToken
                btnGetToken.setVisibility(View.INVISIBLE);
            }
        });

        btnGetQuestion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               getQuestion(); //getQuestion
            }
        });

        AnswerA.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                checkCorrect("a");
                getQuestion();
            }
        });

        AnswerB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                checkCorrect("b");
                getQuestion();
            }
        });

        AnswerC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                checkCorrect("c");
                getQuestion();
            }
        });

        AnswerD.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                checkCorrect("d");
                getQuestion();
            }
        });

        AnswerE.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                checkCorrect("e");
                getQuestion();
            }
        });

        AnswerF.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                checkCorrect("f");
                getQuestion();
            }
        });



    }


    private void getToken() {


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.GET,
                urlToken,  new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    // Parsing json object response
                    // response will be a json object
                    String token = response.getString("token");


                    jsonResponse = "";
                    jsonResponse +=token + "\n\n";

                    quiztoken=token;

                    txtResponse.setText(jsonResponse);
                    getQuestion();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);

        getQuestion();
        btnGetQuestion.setVisibility(View.VISIBLE);
    }

    /**
     * Method to make json array request where response starts with [
     * */
    private void getQuestion() {


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.GET,
                "http://sfsuswe.com/413/get_question/?token="+quiztoken,  new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    // Parsing json object response
                    // response will be a json object
                    String question = response.getString("question");
                    String answer_a = response.getString("answer_a");
                    String answer_b = response.getString("answer_b");
                    String answer_c = response.getString("answer_c");
                    String answer_d = response.getString("answer_d");
                    String answer_e = response.getString("answer_e");
                    String answer_f = response.getString("answer_f");
                    String correct = response.getString("correct");

                    jsonResponse = "";
                    jsonResponse += "Question: " + question + "\n\n";
                    jsonResponse += "answer_a: " + answer_a + "\n\n";
                    ansA="a";
                    jsonResponse += "answer_b: " + answer_b + "\n\n";
                    ansB="b";
                    jsonResponse += "answer_c: " + answer_c + "\n\n";
                    ansC="c";
                    jsonResponse += "answer_d: " + answer_d + "\n\n";
                    ansD="d";
                    jsonResponse += "answer_e: " + answer_e + "\n\n";
                    ansE="e";
                    jsonResponse += "answer_f: " + answer_f + "\n\n";
                    ansF="f";
                    correctAnswer =correct;
                    jsonResponse += "Correct "+correct+ "\n\n";

                    if(answer_e=="null"&& answer_f=="null") {
                        AnswerE.setVisibility(View.INVISIBLE);
                        AnswerF.setVisibility(View.INVISIBLE);

                    }else if(answer_e=="null") {
                        AnswerE.setVisibility(View.INVISIBLE);

                    }else if(answer_f=="null") {
                        AnswerF.setVisibility(View.INVISIBLE);
                        AnswerE.setVisibility(View.VISIBLE);

                    }else{
                        AnswerE.setVisibility(View.VISIBLE);
                        AnswerF.setVisibility(View.VISIBLE);

                    }

                    txtResponse.setText(jsonResponse);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }

    public boolean checkCorrect(String answer){

        if(answer == correctAnswer){
            score+=1;
            scoreBoard.setText("Correct! current score is: "+score);
            return true;
        }else {
            scoreBoard.setText("Incorrect! answer was: " +correctAnswer+ " current score is: "+score);
            return false;
        }

    }
}