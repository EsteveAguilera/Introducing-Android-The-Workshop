package io.github.esteveaguilera.androidworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etUser = (EditText) findViewById(R.id.et_write_your_name);
        Button butStart = (Button) findViewById(R.id.but_start);

        butStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etUser.getText().toString();
                String welcomeMessage = "Welcome to the training " + userName + "!";

                Toast.makeText(MainActivity.this, welcomeMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
