package com.example.temperatureconvertor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText temperatureEditText;
    private RadioGroup unitRadioGroup;
    private Button convertButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatureEditText = findViewById(R.id.temperatureEditText);
        unitRadioGroup = findViewById(R.id.unitRadioGroup);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        String temperatureStr = temperatureEditText.getText().toString();
        if (temperatureStr.isEmpty()) {
            resultTextView.setText("Please enter a temperature.");
            return;
        }

        double temperature = Double.parseDouble(temperatureStr);
        int selectedId = unitRadioGroup.getCheckedRadioButtonId();

        if (selectedId == R.id.celsiusRadioButton) {
            double fahrenheit = (temperature * 9/5) + 32;
            displayResult(fahrenheit, "Fahrenheit");
        } else if (selectedId == R.id.fahrenheitRadioButton) {
            double celsius = (temperature - 32) * 5/9;
            displayResult(celsius, "Celsius");
        }
    }

    private void displayResult(double convertedValue, String unit) {
        DecimalFormat df = new DecimalFormat("#.##");
        String result = df.format(convertedValue) + " " + unit;
        resultTextView.setText(result);
    }
}
