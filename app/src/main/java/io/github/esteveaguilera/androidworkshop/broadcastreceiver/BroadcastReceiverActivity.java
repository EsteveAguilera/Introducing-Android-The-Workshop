package io.github.esteveaguilera.androidworkshop.broadcastreceiver;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import io.github.esteveaguilera.androidworkshop.R;

public class BroadcastReceiverActivity extends AppCompatActivity {

    private BroadcastReceiver broadcastReceiver;
    private TextView tvBRStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);

        Button butStartBR = (Button) findViewById(R.id.but_start_broadcast_receiver);
        Button butStopBR = (Button) findViewById(R.id.but_stop_broadcast_receiver);
        tvBRStatus = (TextView) findViewById(R.id.tv_broadcast_status);

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if(intent.getAction().equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
                    int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);

                    if (state == BluetoothAdapter.STATE_ON) {
                        Toast.makeText(BroadcastReceiverActivity.this, "Bluetooth on", Toast.LENGTH_SHORT).show();
                    }else if (state == BluetoothAdapter.STATE_OFF){
                        Toast.makeText(BroadcastReceiverActivity.this, "Bluetooth off", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };

        butStartBR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFilter intentFilter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
                registerReceiver(broadcastReceiver, intentFilter);
                tvBRStatus.setText(R.string.broadcast_running);
                tvBRStatus.setTextColor(getResources().getColor(R.color.color_broadcast_running));
            }
        });

        butStopBR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unregisterReceiver(broadcastReceiver);
                tvBRStatus.setText(R.string.broadcast_stopped);
                tvBRStatus.setTextColor(getResources().getColor(R.color.color_broadcast_stopped));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}
