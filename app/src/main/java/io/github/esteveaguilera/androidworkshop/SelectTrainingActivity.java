package io.github.esteveaguilera.androidworkshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import io.github.esteveaguilera.androidworkshop.passdata.ActivityA;

public class SelectTrainingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_training);

        findViewById(R.id.but_training_pass_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectTrainingActivity.this, ActivityA.class));
            }
        });
    }
}
