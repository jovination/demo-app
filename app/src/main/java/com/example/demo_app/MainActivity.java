package com.example.demo_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText First_name;
    EditText Second_name;
    Button Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        First_name = findViewById(R.id.firstnameEditText);
        Second_name = findViewById(R.id.secondNameEditText);
        Next = findViewById(R.id.nextInButton);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FirstName = First_name.getText().toString();
                String SecondName = Second_name.getText().toString();

                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                i.putExtra("firstName", FirstName);
                i.putExtra("secondName", SecondName);
                startActivity(i);
            }
        });
    }
}