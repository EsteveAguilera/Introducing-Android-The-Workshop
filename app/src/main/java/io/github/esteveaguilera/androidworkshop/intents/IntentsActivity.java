package io.github.esteveaguilera.androidworkshop.intents;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;

import io.github.esteveaguilera.androidworkshop.BuildConfig;
import io.github.esteveaguilera.androidworkshop.R;

public class IntentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents);

        final EditText etTextToShare = (EditText) findViewById(R.id.et_text_to_share);

        findViewById(R.id.but_share_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = etTextToShare.getText().toString();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, text);
                intent.setType("text/plain");
                startActivity(intent);
            }
        });

        findViewById(R.id.but_share_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(IntentsActivity.this.getResources(), R.mipmap.ic_launcher);
                saveBitmapToCache(IntentsActivity.this, bitmap, "image.png");
                Uri imageURI = getBitmapUriFromCache(IntentsActivity.this, "image.png");

                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_STREAM, imageURI);
                intent.setType("image/png");
                startActivity(intent);
            }
        });
    }

    private static final String IMAGE_FOLDER = "images";
    private static final String PNG_EXTENSION = ".png";

    public static void saveBitmapToCache(Context context, Bitmap bitmap, String imageName) {
        File cacheDir = new File(context.getCacheDir(), IMAGE_FOLDER);
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        File cacheFile = new File(cacheDir, imageName + PNG_EXTENSION);
        try {
            cacheFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(cacheFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Uri getBitmapUriFromCache(Context context, String imageName) {
        File cacheDir = new File(context.getCacheDir(), IMAGE_FOLDER);
        File cacheFile = new File(cacheDir, imageName + PNG_EXTENSION);
        return FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".intents", cacheFile);
    }
}
