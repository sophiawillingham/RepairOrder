package com.example.repairorder;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class RepairOrderActivity extends AppCompatActivity { // parent class for android activities

    double numbers = 0.0;

    TextView subtotalPrice;

    EditText orderET;
    EditText orderEI;
    EditText orderPaint;
    EditText orderParts;
    EditText orderLabor;

    Button submitB; // 1. create button

    View.OnClickListener buttonListener = new View.OnClickListener() { // 3. create listener
        @Override
        public void onClick(View v) { //5.
            //Random gen = new Random();
            //double number = gen.nextDouble();

            String orderTypeValue = orderET.getText().toString();

            //Integer it = Integer.getInteger(orderTypeValue); //returns the integer

            String InspectionValue = orderEI.getText().toString();
            Double ot = Double.parseDouble(orderTypeValue); //returns the double

            String PaintValue = orderET.getText().toString();
            Double pt = Double.parseDouble(PaintValue); //returns the double

            String PartsValue = orderET.getText().toString();
            Double ppt = Double.parseDouble(PartsValue); //returns the double

            String LaborValue = orderET.getText().toString();
            Double lv = Double.parseDouble(LaborValue); //returns the double

            double number = ot+pt+ppt+lv;
            String n = "$" + number;
            subtotalPrice.setText(n);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) { // this is what is created when launched

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_repair_order); //UI laid out by this line
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> { //make sure ran properly
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        subtotalPrice= findViewById(R.id.subtotalValue); //locate any thing in UI
        submitB = findViewById(R.id.submitButton); // 2.
        submitB.setOnClickListener(buttonListener); // 4. registering the listener to the button
        orderET = findViewById(R.id.editOrderType);
        orderEI = findViewById(R.id.editInspection);
        orderPaint = findViewById(R.id.editPaint);
        orderParts = findViewById(R.id.editParts);
        orderLabor = findViewById(R.id.editLabor);
//        Random gen = new Random();
//        double number = gen.nextDouble();
//        String n = "$" + number;
//        subtotalPrice.setText(n); //UI
//        String value = subtotalPrice.getText().toString(); //What's in the UI into the code
//        Log.i("TEST", value);

    }
}

