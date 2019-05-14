package advprogramming.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convert_OnClick(View view) {
        EditText tempToConvert = findViewById(R.id.TempTextBox);
        RadioGroup radioGroup = findViewById(R.id.ConvertRadioGroup);
        RadioButton fButton = findViewById(R.id.FahrenheitButton);
        RadioButton cButton = findViewById(R.id.CentigradeRadioButton);
        RadioButton buttonSelected = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());

        String temperature = tempToConvert.getText().toString();
            if(tempToConvert.getText() == null) {
                System.out.println("null");
            }
            else if(buttonSelected == fButton) {
                tempToConvert.setText(ConvertToFahrenheit(temperature));
            }
            else {
                tempToConvert.setText(ConvertToCentigrade(temperature));
            }
    }

    public String ConvertToFahrenheit(String temp) {
        double temperature = Double.parseDouble(temp);
        temperature = (temperature * 1.8) + 32;
        return Double.toString(temperature);

    }

    public String ConvertToCentigrade(String temp) {
        double temperature = Double.parseDouble(temp);
        temperature = (temperature - 32) / 1.8;
        return Double.toString(temperature);
    }
}
