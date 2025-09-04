package com.example.repairorder;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RepairOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_repair_order);

        // --- Get references ---
        EditText editOrderType = findViewById(R.id.editTextTextEmailAddress4);
        EditText editTechnician = findViewById(R.id.editTextTextEmailAddress6);
        EditText editInspection = findViewById(R.id.editTextTextEmailAddress3);
        EditText editPaint = findViewById(R.id.editTextTextEmailAddress10);
        EditText editParts = findViewById(R.id.editTextTextEmailAddress11);
        EditText editLabor = findViewById(R.id.editTextTextEmailAddress9);

        TextView subtotalText = findViewById(R.id.tamount1);
        TextView taxText = findViewById(R.id.amount2);
        TextView totalText = findViewById(R.id.amount3);

        // --- Edge-to-edge padding ---
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // --- Set initial text ---
        editOrderType.setText("Oil Change");
        editTechnician.setText("John Doe");
        editInspection.setText("Complete");
        editPaint.setText("$50.0");
        editParts.setText("$120.0");
        editLabor.setText("$80.0");

        subtotalText.setText("$250.0");
        taxText.setText("$20.0");
        totalText.setText("$270.0");

        // --- Get text from
    }
}