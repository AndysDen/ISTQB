package com.istqb.anandsoni.multichoicequest;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;

public class QuestionCollection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (getIntent().getBooleanExtra("EXIT", false)) {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
        super.onCreate(savedInstanceState);
        RelativeLayout relativeLayout=(RelativeLayout)findViewById(R.id.relativeView);
      final Context context = this;
        setContentView(R.layout.activity_question_collection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);
        configureOnClickListenrForSelectTest(context);
        configureOnClickListenrForFacebook(context);
        configureOnClickListenrForAboutUs(context);
        Button button=(Button)findViewById(R.id.JavaTest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,SubCategory.class);
                Bundle bundle = new Bundle();
                bundle.putString("category","JAVA");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private void configureOnClickListenrForAboutUs(final Context context) {


//        Button button=(Button)findViewById(R.id.aboutUs);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context,AppAudience.class);
//                startActivity(intent);
//            }
//        });
    }


    public void configureOnClickListenrForSelectTest(final Context context){
        Button button=(Button)findViewById(R.id.JavaTest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,SubCategory.class);
                Bundle bundle = new Bundle();
                bundle.putString("category","JAVA");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    public void configureOnClickListenrForFacebook(final Context context){
//        Button button=(Button)findViewById(R.id.facebook);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(context,AboutISTQB.class);
//                startActivity(i);
//            }
//        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question_collection, menu);

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
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        }
        else if(id==R.id.faceBookUs){
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
