package com.example.repairorder;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RepairOrderActivity extends AppCompatActivity {

    // Views
    TextView subtotalPrice;
    EditText orderET, orderEI, orderPaint, orderParts, orderLabor;
    Button submitB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair_order);

        // Find views
        subtotalPrice = findViewById(R.id.subtotalValue);
        orderET = findViewById(R.id.editOrderType);
        orderEI = findViewById(R.id.editInspection);
        orderPaint = findViewById(R.id.editPaint);
        orderParts = findViewById(R.id.editParts);
        orderLabor = findViewById(R.id.editLabor);
        submitB = findViewById(R.id.submitButton);
        Spinner repairSpinner = findViewById(R.id.repair_type_spinner);

        // Set Spinner Adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.repair_types,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        repairSpinner.setAdapter(adapter);

        // Spinner listener
        repairSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String repair = parent.getItemAtPosition(position).toString();
                Toast.makeText(RepairOrderActivity.this, "Picked: " + repair, Toast.LENGTH_SHORT).show();

                // Set default price for selected repair
                switch (repair) {
                    case "Oil Change": orderET.setText("30"); break;
                    case "Tire Rotation": orderET.setText("25"); break;
                    case "Brake Inspection": orderET.setText("50"); break;
                    case "Paint Job": orderET.setText("200"); break;
                    case "Engine Repair": orderET.setText("500"); break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        // Button listener
        submitB.setOnClickListener(v -> {
            double total = safeParse(orderET) + safeParse(orderEI)
                    + safeParse(orderPaint) + safeParse(orderParts)
                    + safeParse(orderLabor);
            subtotalPrice.setText("$" + String.format("%.2f", total));
        });
    }

    // Helper to safely parse doubles
    private double safeParse(EditText et) {
        String val = et.getText().toString().trim();
        if (val.isEmpty()) return 0.0;
        try {
            return Double.parseDouble(val);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
