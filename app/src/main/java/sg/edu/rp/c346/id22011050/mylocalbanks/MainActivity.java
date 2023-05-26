package sg.edu.rp.c346.id22011050.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button DBS;
    Button OCBC;
    Button UOB;
    String wordClicked="";
    String language = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBS = findViewById(R.id.buttonCallDBS);
        OCBC = findViewById(R.id.buttonCallOCBC);
        UOB = findViewById(R.id.buttonCallUOB);
        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);


    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

            menu.setHeaderTitle("Select the actions");
            menu.add(0,0,0,"Website");
            menu.add(0,1,1,"Call");
            menu.add(0,2,2,"Toggle Favourite");

        if (v == DBS){
            wordClicked = "dbs";
        }else if (v == OCBC){
            wordClicked = "ocbc";
        }else {
            wordClicked = "uob";
        }

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            DBS.setText("DBS");
            OCBC.setText("OCBC");
            UOB.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            DBS.setText("星展銀行");
            OCBC.setText("华侨银行");
            UOB.setText("大华银行");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);

            } else if (item.getItemId() == 1) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 1800111111));
                startActivity(intent);
            }else if (item.getItemId()==2){
                DBS.setTextColor(Color.RED);
            }
        }else if (wordClicked.equalsIgnoreCase("ocbc")){
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);

            } else if (item.getItemId() == 1) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 1800363333));
                startActivity(intent);
            }else if (item.getItemId()==2){
            OCBC.setTextColor(Color.RED);

            }
        }else if (wordClicked.equalsIgnoreCase("uob")){
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);

            } else if (item.getItemId() == 1) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 1800222212));
                startActivity(intent);
            }else if (item.getItemId()==2){
                UOB.setTextColor(Color.RED);
            }
        }
        return super.onContextItemSelected(item);
    }


}