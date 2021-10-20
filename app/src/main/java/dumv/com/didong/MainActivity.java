package dumv.com.didong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnGoTo2;
    Button btnGoTo3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGoTo2 = (Button)  findViewById(R.id.buttonGoTo2);
        btnGoTo3 = (Button) findViewById(R.id.buttonGoTo3);

        btnGoTo2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent mh2 = new Intent(MainActivity.this, ChoigameActivity.class);
                startActivity(mh2);
            }
        });


        btnGoTo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mh3 = new Intent(MainActivity.this, HuongDan.class);
                startActivity(mh3);
            }
        });
    }
}
