package com.example.ar_project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DogPick extends AppCompatActivity {

    RadioButton radioButton;
    RadioGroup radioGroup;
    TextView textView1, textView2;
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7,
            imageView8, imageView9, imageView10, warning;
    Button button;
    EditText editText;

    String kiloOrPound;
    public static String x;
    public static String y;
    public static String y2;
    public static String z;
    String empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_pick);

        //Remove navigation- & statusBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        warning = findViewById(R.id.warning_id);
        editText = findViewById(R.id.weight_id);
        button = findViewById(R.id.calculate_btn_id);
        textView1 = findViewById(R.id.heading_text_id);
        textView2 = findViewById(R.id.kgorpound_id);
        radioGroup = findViewById(R.id.radio_group_id);

        imageView1 = findViewById(R.id.dog_id_1);
        imageView2 = findViewById(R.id.dog_id_2);
        imageView3 = findViewById(R.id.dog_id_3);
        imageView4 = findViewById(R.id.dog_id_4);
        imageView5 = findViewById(R.id.dog_id_5);
        imageView6 = findViewById(R.id.dog_id_6);
        imageView7 = findViewById(R.id.dog_id_7);
        imageView8 = findViewById(R.id.dog_id_8);
        imageView9 = findViewById(R.id.dog_id_9);
        imageView10 = findViewById(R.id.dog_id_10);

        button.setVisibility(View.INVISIBLE);
        warning.setVisibility(View.INVISIBLE);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")) {
                    button.setVisibility(View.INVISIBLE);
                } else {
                    button.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                z = String.valueOf(editText.getText());
                if (textView1.getText().equals("Pick a dog")){
                    warning.setVisibility(View.VISIBLE);
                }
                else startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    public void checkDoggie(View v) {
        switch (v.getId()){
            case R.id.dog_id_1:
                y = "Cattle";
                y2 = "doggie.sfb";
                break;
            case R.id.dog_id_2:
                y = "Labrador";
                y2 = "doggie1.sfb";
                break;
            case R.id.dog_id_3:
                y = "Terrier";
                y2 = "doggie2.sfb";
                break;
            case R.id.dog_id_4:
                y = "Dalmatine";
                y2 = "doggie3.sfb";
                break;
            case R.id.dog_id_5:
                y = "Great Dane";
                y2 = "doggie4.sfb";
                break;
            case R.id.dog_id_6:
                y = "Shiba";
                y2 = "doggie5.sfb";
                break;
            case R.id.dog_id_7:
                y = "Boxer";
                y2 = "doggie6.sfb";
                break;
            case R.id.dog_id_8:
                y = "Doberman";
                y2 = "doggie7.sfb";
                break;
            case R.id.dog_id_9:
                y = "Corgi";
                y2 = "doggie8.sfb";
                break;
            case R.id.dog_id_10:
                y = "Greyhound";
                y2 = "doggie9.sfb";
                break;
        }
        warning.setVisibility(View.INVISIBLE);
        textView1.setText(y);
    }

    //Radio_Button
    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        kiloOrPound = String.valueOf(radioButton.getText());

        if ( kiloOrPound.equals("Kilograms")){
            x = "kg";
        }
        else if(kiloOrPound.equals("Pounds")){
            x = "lbs";
        }
        textView2.setText(x);
    }

}
