

package com.istqb.anandsoni.multichoicequest;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;



import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class
        choose_question extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chose_question);
        Button btn1 = (Button)findViewById(R.id.text1);
        processButton(btn1);

        Button btn2 = (Button)findViewById(R.id.text2);
        processButton(btn2);

        Button btn3 = (Button)findViewById(R.id.text3);
        processButton(btn3);

        Button btn4 = (Button)findViewById(R.id.text4);
        processButton(btn4);

        Button btn5 = (Button)findViewById(R.id.text5);
        processButton(btn5);

        Button btn6 = (Button)findViewById(R.id.text6);
        processButton(btn6);

        Button btn7 = (Button)findViewById(R.id.text7);
        processButton(btn7);

        Button btn8 = (Button)findViewById(R.id.text8);
        processButton(btn8);

        Button btn9 = (Button)findViewById(R.id.text9);
        processButton(btn9);

        Button btn10 = (Button)findViewById(R.id.text10);
        processButton(btn10);

        Button btn11 = (Button)findViewById(R.id.text11);
        processButton(btn11);

        Button btn12 = (Button)findViewById(R.id.text12);
        processButton(btn12);

        Button btn13 = (Button)findViewById(R.id.text13);
        processButton(btn13);

        Button btn14 = (Button)findViewById(R.id.text14);
        processButton(btn14);

        Button btn15 = (Button)findViewById(R.id.text15);
        processButton(btn15);

        Button btn16 = (Button)findViewById(R.id.text16);
        processButton(btn16);

        Button btn17 = (Button)findViewById(R.id.text17);
        processButton(btn17);

        Button btn18 = (Button)findViewById(R.id.text18);
        processButton(btn18);

        Button btn19 = (Button)findViewById(R.id.text19);
        processButton(btn19);

        Button btn20 = (Button)findViewById(R.id.text20);
        processButton(btn20);




    }

    private void processButton(Button button){
        final String text=button.getText().toString();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                processIntent(text);
            }
        });
    }
    private void processIntent(String text){

        Intent data = new Intent();
        data.putExtra("value",text);
        setResult(RESULT_OK,data);
        finish();


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
