package com.dev.aman.cryptostring.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.aman.cryptostring.R;

public class EncryptionActivity extends AppCompatActivity {

    private TextView mEncrytedString;
    private Button mEncryptBtn;
    private EditText mEnterString;
    private ImageView mBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);

        init();
        onClick();
        textWatcher();

        mEncryptBtn.setClickable(false);
        mEncryptBtn.getBackground().setAlpha(65);
    }

    private void init() {
        mBack = findViewById(R.id.back);
        mEncrytedString = findViewById(R.id.encryptedString);
        mEncryptBtn = findViewById(R.id.encryptString);
        mEnterString = findViewById(R.id.enteredEncryptString);
    }

    private void onClick() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mEncryptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEncryptrdString();
            }
        });
    }

    private void setEncryptrdString() {
        mEncrytedString.setText(mEnterString.getText().toString());
    }

    private void textWatcher() {
        mEnterString.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!s.toString().equals("")){
                    mEncryptBtn.setClickable(true);
                    mEncryptBtn.getBackground().setAlpha(255);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}