package io.github.esteveaguilera.androidworkshop.passdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.github.esteveaguilera.androidworkshop.R;

public class ActivityB extends AppCompatActivity {

    private String name;
    private String email;
    private TextView tvName;
    private TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        tvName = (TextView) findViewById(R.id.tv_name);
        tvEmail = (TextView) findViewById(R.id.tv_email);

        Bundle arguments = getIntent().getExtras();

        if (arguments != null) {
            if (arguments.getString(ActivityA.EXTRA_NAME) != null) {
                name = arguments.getString(ActivityA.EXTRA_NAME);
            }
            if (arguments.getString(ActivityA.EXTRA_EMAIL) != null) {
                email = arguments.getString(ActivityA.EXTRA_EMAIL);
            }
        }

        tvName.setText(name);
        tvEmail.setText(email);
    }
}
