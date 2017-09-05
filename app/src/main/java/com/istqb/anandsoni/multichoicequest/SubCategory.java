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

public class SubCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;

        if (getIntent().getBooleanExtra("EXIT", false)) {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }

        super.onCreate(savedInstanceState);





            setContentView(R.layout.javatest);

          configureForNextButton(context);
        configureForBackButton(context);

    }

    private void configureForBackButton(final Context context) {
    /*    Button button = (Button)findViewById(R.id.back);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,QuestionCollection.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }); */
    }

    private void configureForNextButton(final Context context) {
        Button button = (Button)findViewById(R.id.next);

         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(context, AllTestList.class);
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
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
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
