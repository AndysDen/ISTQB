package com.istqb.anandsoni.multichoicequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionTemaplate extends AppCompatActivity {

    private Map<String,List<Questions>> mapOfQuestions= new HashMap<String,List<Questions>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
         try {
             super.onCreate(savedInstanceState);
             InputStream is =getResources().openRawResource(R.raw.questions);
             mapOfQuestions= LoadQuestionData.loadData(is);

             Bundle bundle = getIntent().getExtras();

             //Extract the data  …
             String flow = bundle.getString("category");



         }catch(IOException ioe){
             ioe.printStackTrace();
         }catch(XmlPullParserException xe){
             xe.printStackTrace();
         }
            }
}
