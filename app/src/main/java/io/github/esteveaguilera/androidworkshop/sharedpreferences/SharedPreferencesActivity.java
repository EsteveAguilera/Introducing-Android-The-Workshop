package io.github.esteveaguilera.androidworkshop.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.github.esteveaguilera.androidworkshop.R;

public class SharedPreferencesActivity extends AppCompatActivity {

    public static final String KEY_FIRST_VALUE = "key_first_value";
    public static final String KEY_SECOND_VALUE = "key_second_value";

    private EditText etFirstValue;
    private EditText etSecondValue;

    private TextView tvFirstValue;
    private TextView tvSecondValue;

    private Button butSave;
    private Button butClear;
    private Button butLoad;
    private Button butClearSharedPreferences;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        loadViews();

        butSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_FIRST_VALUE, etFirstValue.getText().toString());
                editor.putInt(KEY_SECOND_VALUE, Integer.valueOf(etSecondValue.getText().toString()));
                editor.apply();
                showMessage("Values saved!");
            }
        });

        butLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvFirstValue.setText(sharedPreferences.getString(KEY_FIRST_VALUE, "default value"));
                tvSecondValue.setText(String.valueOf(sharedPreferences.getInt(KEY_SECOND_VALUE, 42)));
            }
        });

        butClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvFirstValue.setText("");
                tvSecondValue.setText("");
            }
        });

        butClearSharedPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear().apply();
                showMessage("Shared Preferences cleared!");
            }
        });

    }

    private void loadViews() {
        etFirstValue = (EditText) findViewById(R.id.et_first_value);
        etSecondValue = (EditText) findViewById(R.id.et_second_value);
        tvFirstValue  = (TextView) findViewById(R.id.tv_first_value);
        tvSecondValue = (TextView) findViewById(R.id.tv_second_value);
        butSave = (Button) findViewById(R.id.but_save);
        butClear = (Button) findViewById(R.id.but_clear_texts);
        butLoad = (Button) findViewById(R.id.but_load);
        butClearSharedPreferences = (Button) findViewById(R.id.but_clear_preferences);
    }

    private void showMessage(String message) {
        Toast.makeText(SharedPreferencesActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
