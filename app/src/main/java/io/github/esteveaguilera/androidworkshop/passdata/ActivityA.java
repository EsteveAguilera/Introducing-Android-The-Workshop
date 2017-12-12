package io.github.esteveaguilera.androidworkshop.passdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.github.esteveaguilera.androidworkshop.R;

public class ActivityA extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_EMAIL = "extra_email";

    private EditText etName;
    private EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        etName = (EditText) findViewById(R.id.et_name);
        etEmail = (EditText) findViewById(R.id.et_email);

        Button butPassData = (Button) findViewById(R.id.but_pass_data);

        butPassData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityA.this, ActivityB.class);
                intent.putExtra(EXTRA_NAME, etName.getText().toString());
                intent.putExtra(EXTRA_EMAIL, etEmail.getText().toString());
                startActivity(intent);
            }
        });
    }
}
