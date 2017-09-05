package com.istqb.anandsoni.multichoicequest;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ShowQuestionResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_result);
        Bundle bundle = getIntent().getExtras();
        Questions question= (Questions) bundle.getSerializable("question");

        populateScreen(question);
        TextView textView = (TextView) findViewById(R.id.result);
         if(question.getAttemptedAnswer().equals("Not Attempted")){
             textView.setTextColor(Color.RED);
              textView.setText("NOT ATTEMPTED");
         }else if(!question.getAttemptedAnswer().equalsIgnoreCase(question
                .getCorrectAnswer())){
             textView.setTextColor(Color.RED);
             textView.setText("INCORRECT");
        }
         else {
             textView.setTextColor(Color.parseColor("#008000"));
             textView.setText("CORRECT");
         }
        Button backButton=(Button)findViewById(R.id.goBack);
         backButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 android.os.Process.killProcess(android.os.Process.myPid());
                 System.exit(1);
             }
         });
    }

    private void populateScreen(Questions question) {

        TextView questionText =(TextView)findViewById(R.id.textQuestion);
        questionText.setText(question.getQuestionNumber() + " " + question.getQuestion());
        populateRadioButton(question);

    }

    private void populateRadioButton(Questions question) {

        //First Radio button
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.myRadioGroup);
        radioGroup.clearCheck();

        RadioButton radio1 = (RadioButton) findViewById(R.id.one1);
        radio1.setText(question.getListOfOption().get(0));
        int parsedColor=Color.parseColor("#008000");
    if(question.getAttemptedAnswer().equals("1")){
        radio1.setTextColor(Color.RED);
    }
        if(question.getCorrectAnswer().equals("1")){
            radio1.setTextColor(parsedColor);
        }

        //Second Radio Button
        RadioButton radio2 = (RadioButton) findViewById(R.id.two2);
        radio2.setText(question.getListOfOption().get(1));
        if(question.getAttemptedAnswer().equals("2")){
            radio2.setTextColor(Color.RED);
        }
        if(question.getCorrectAnswer().equals("2")){
            radio2.setTextColor(parsedColor);
        }
        //Third Radio Button
        RadioButton radio3 = (RadioButton) findViewById(R.id.three3);
        radio3.setText(question.getListOfOption().get(2));

        if(question.getAttemptedAnswer().equals("3")){
            radio3.setTextColor(Color.RED);
        }
        if(question.getCorrectAnswer().equals("3")){
            radio3.setTextColor(parsedColor);
        }

        RadioButton radio4 = (RadioButton) findViewById(R.id.four4);
        radio4.setText(question.getListOfOption().get(3));
        if(question.getAttemptedAnswer().equals("4")){
            radio4.setTextColor(Color.RED);
        }
        if(question.getCorrectAnswer().equals("4")){
            radio4.setTextColor(parsedColor);
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.test_menu_file, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        if(id==R.id.faceBookUs){
            String url = "https://www.facebook.com/Istqb-500-834965406632781/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }
        else if(id==R.id.aboutIsqtb){
            Intent i = new Intent(this,AboutISTQB.class);
            startActivity(i);

        }
        else if(id==R.id.contactUS){
            Intent i = new Intent(this,ContactUs.class);
            startActivity(i);

        }
        else if(id==R.id.productInfo){
            Intent i = new Intent(this,ProductInfo.class);
            startActivity(i);

        }

        return super.onOptionsItemSelected(item);
    }


}
