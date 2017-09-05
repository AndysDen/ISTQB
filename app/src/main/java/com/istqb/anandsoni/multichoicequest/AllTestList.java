package com.istqb.anandsoni.multichoicequest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllTestList extends AppCompatActivity {

    public Map<String,List<Questions>> mapOfQuestions = new HashMap<String,List<Questions>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        InputStream is =getResources().openRawResource(R.raw.questions);
        try {
            mapOfQuestions = LoadQuestionData.loadData(is);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }catch(XmlPullParserException xppe){
            xppe.printStackTrace();
        }
        final Context context = this;

           super.onCreate(savedInstanceState);
           setContentView(R.layout.testpaperlist);


        Button testPaper1=(Button)findViewById(R.id.test1);
         testPaper1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(context, TestPaper.class);
                 Bundle bundle = new Bundle();
                 ArrayList<Questions> questionsList=(ArrayList)  mapOfQuestions.get("one");
                // bundle.pputString("category", "JAVA");
                 intent.putExtra("testList", questionsList);
                // intent.putExtras(bundle);
                 //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                 startActivity(intent);
// Intent intent = new Intent(context,BarCharts.class);
//                 startActivity(intent);
             }
         });
        Button testPaper2=(Button)findViewById(R.id.test2);
        testPaper2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TestPaper.class);
                Bundle bundle = new Bundle();
                ArrayList<Questions> questionsList=(ArrayList)  mapOfQuestions.get("two");
                // bundle.pputString("category", "JAVA");
                intent.putExtra("testList", questionsList);
                // intent.putExtras(bundle);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
        Button testPaper3=(Button)findViewById(R.id.test3);
        testPaper3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TestPaper.class);
                Bundle bundle = new Bundle();
                ArrayList<Questions> questionsList=(ArrayList)  mapOfQuestions.get("three");
                // bundle.pputString("category", "JAVA");
                intent.putExtra("testList", questionsList);
                // intent.putExtras(bundle);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
        Button testPaper4=(Button)findViewById(R.id.test4);
        testPaper4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TestPaper.class);
                Bundle bundle = new Bundle();
                ArrayList<Questions> questionsList=(ArrayList)  mapOfQuestions.get("four");
                // bundle.pputString("category", "JAVA");
                intent.putExtra("testList", questionsList);
                // intent.putExtras(bundle);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
        Button testPaper5=(Button)findViewById(R.id.test5);
        testPaper5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TestPaper.class);
                Bundle bundle = new Bundle();
                ArrayList<Questions> questionsList=(ArrayList)  mapOfQuestions.get("five");
                // bundle.pputString("category", "JAVA");
                intent.putExtra("testList", questionsList);
                // intent.putExtras(bundle);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.instruction_menu_file, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.closeApplication) {
            Intent homeIntent = new Intent(this,SubCategory.class);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            homeIntent.putExtra("EXIT", true);
            startActivity(homeIntent);
        }

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
