package com.example.counter1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getSharedPreferences("dane", MODE_PRIVATE);
        int licznik = sp.getInt("licznik", 0);
        int orientacja = getResources().getConfiguration().orientation;

        if (sp.getInt("orientacja", orientacja) != orientacja) {
            licznik++;
        }

        sp.edit().putInt("licznik", licznik).putInt("orientacja", orientacja).apply();

        ((TextView) findViewById(R.id.tv)).setText(String.valueOf(licznik));
    }

    }