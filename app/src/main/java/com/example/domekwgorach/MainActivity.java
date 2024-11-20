package com.example.domekwgorach;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int clickcount = 0;
    private Button polub;
    private Button usun;
    private Button zapisz;
    private TextView like_count;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        like_count = findViewById(R.id.like_count);
        polub = findViewById(R.id.btn_polub);
        usun = findViewById(R.id.btn_usun);
        zapisz = findViewById(R.id.btn_zapisz);
        polub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickcount++;
                like_count.setText(clickcount + " polubień");
            }
        });
        usun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickcount--;
                like_count.setText(clickcount + " polubień");
                if(clickcount < 0){
                    like_count.setText("0 polubień");
                    clickcount = 0;
                }

            }
        });

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.image), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}