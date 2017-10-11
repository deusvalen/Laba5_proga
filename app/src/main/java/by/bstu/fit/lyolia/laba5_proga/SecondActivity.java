package by.bstu.fit.lyolia.laba5_proga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    TextView textView;
    Button button;
    RadioButton radioButton1;
    RadioButton radioButton2;
    String[] data = {"Человек", "Шимпанзе", "Горилла", "Макака"};
    double coeff = 0;
    double dcoeff = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = (EditText)(findViewById(R.id.editText));
        textView = (TextView)(findViewById(R.id.textView5)) ;
        button = (Button)(findViewById(R.id.button2));
        button.setOnClickListener(this);
        radioButton1 = (RadioButton)(findViewById(R.id.radioButton));
        radioButton2 = (RadioButton)(findViewById(R.id.radioButton2));
        radioButton1.setOnClickListener(this);
        radioButton2.setOnClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                switch (position){
                    case 0:
                        coeff = 0.075;
                        break;
                    case 1:
                        coeff = 0.023;
                        break;
                    case 2:
                        coeff = 0.018;
                        break;
                    case 3:
                        coeff = 0.003;
                        break;
                    default: coeff = 0; break;
                }
                Toast.makeText(getBaseContext(), "Позиция = " + position, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });
    }


    public void onClick(View v){
        switch (v.getId()) {
            case R.id.radioButton:
                dcoeff = -0.001;
                break;
            case R.id.radioButton2:
                dcoeff = 0.001;
                break;
            case R.id.button2:
                int mass = 0;
                  try{
                      mass = Integer.parseInt(editText.getText().toString());
                  }
                  catch (NumberFormatException exp)
                  {
                      mass = 0;
                  }
                  finally {
                      double result = mass*(coeff+dcoeff);
                      textView.setText("Масса мозга: " + Math.rint(100.0 * result) / 100.0);
                      break;
                  }

            default: break;
        }
    }
}
