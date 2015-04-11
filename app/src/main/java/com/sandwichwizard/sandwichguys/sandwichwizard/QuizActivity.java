package com.sandwichwizard.sandwichguys.sandwichwizard;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Kyle on 3/12/2015.
 */
public class QuizActivity extends FragmentActivity {
    // the values placed into the answers array follow this index mapping
    private final int MEAT_INDEX = 0;
    private final int SPICY_INDEX = 1;
    private final int MESSY_INDEX = 2;
    private final int HEALTHY1_INDEX = 3;
    private final int HEALTHY2_INDEX = 4;
    private final int FUNSIES1_INDEX = 5;
    private final int CHEESE_INDEX = 6;
    private final int RISK1_INDEX = 7;
    private final int RISK2_INDEX = 8;
    private final int FRUITY_INDEX = 9;
    private final int HEAT_INDEX = 10;

    // QuizManager quizManager;
    String[] questions = new String[]{
            "On a scale of cow to puma, how carnivorous are you feeling?",
            "On a scale of 1-3, how spicy would you like your sandwich? (1 being the least and 3 being the most)",
            "On a scale of 1-3, how messy would you like your sandwich? (1 being the least and 3 being the most)",
            "Are you pregnant or at risk for heart complications?",
            "Would you like your sandwich to be healthy?",
            "Sometimes I am so immersed in nature or art that I feel as if my whole state of consciousness has somehow been temporarily changed.",
            "At times I somehow feel the presence of someone who is not physically there.",
            "On a scale of 1-3, how cheesy are you feeling? (1 being the least and 3 being the most)",
            "Of these two situations I would prefer: \n(1) Being seasick every day for a week while on an ocean voyage" +
                    "\n(2) Having to stand on the window ledge of the 25th Floor of a hotel because there's a fire in my room",
            "Of these two situations I would prefer: \n(1) Bringing my whole family to the circus and then not being able to " +
                    "get in because a clerk sold me tickets for the wrong night.\n(2) Being at the circus when two lions suddenly " +
                    "get loose down in the ring",
            "Are you feeling fruity?",
            "How steamy would you like your sandwich? (1 being the least and 3 being the most)"
    };

    String[] responses = {"cow,bear,puma", "1,2,3", "1,2,3", "No,Yes", "No,Yes", "True,False",
            "True,False", "1,2,3", "1,2", "1,2", "No,Yes", "1,2,3"};
    // address of progress bar for modification
    ProgressBar progressBar;
    // address of question area for modification
    TextView questionArea;
    // initializes button view items for responses
    Button response1;
    Button response2;
    Button response3;
    Button response4;
    int[] answers = new int[questions.length];
    // index of current question
    int currQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_screen);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        questionArea = (TextView) findViewById(R.id.textView);
        response1 = (Button) findViewById(R.id.answer_1);
        response1.setVisibility(View.INVISIBLE);
        response1 = (Button) findViewById(R.id.answer_2);
        response2 = (Button) findViewById(R.id.answer_3);
        response3 = (Button) findViewById(R.id.answer_4);
        // response1.setOnClickListener(new View.OnClickListener() {
        // @Override
        // public void onClick(View v) { buttonPress(0); }
        // });
        response1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(0);
            }
        });
        response2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(1);
            }
        });
        response3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress(2);
            }
        });
        // quizGenerator = new QuizGenerator();
        // quizGenerator.createQuiz();
        progressBar.setMax(questions.length);
        progressBar.setProgress(0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presentQuestion(currQuestion);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void presentQuestion(int index) {
        questionArea.setText(questions[index]);
        String[] splitResponses = responses[index].split(",");
        response1.setText(splitResponses[0]);
        response2.setText(splitResponses[1]);
        response3.setVisibility(View.INVISIBLE);
        if (splitResponses.length > 2) {
            response3.setText(splitResponses[2]);
            response3.setVisibility(View.VISIBLE);
        }
    }

    private void buttonPress(int buttonNum) {
        answers[currQuestion] = buttonNum;
        // presents next question if there is one
        currQuestion++;
        progressBar.setProgress(currQuestion);
        if (currQuestion < questions.length)
            presentQuestion(currQuestion);
        else
            getResults();
    }

    private void getResults() {
        String sandwichID = "";
        for (int i = 0; i < answers.length; i++)
            sandwichID += answers[i] + "";
        Log.d("result", sandwichID);
        // FIXME make a results fragment. Returns to main activity until that is done
        this.finish();
        // Intent intent = new Intent(this, ResultsActivity.class);
        // startActivity(intent);
    }
}