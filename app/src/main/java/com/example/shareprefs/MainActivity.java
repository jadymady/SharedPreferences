package com.example.shareprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_name,et_pass,et_mail;
    Button btn_Save;

    SharedPreferences sharedPreferences;

    public static final String MyPREFERENCES ="MyPrefs";

    public static final String Name="nameKey";
    public static final String Pass="passKey";
    public static final String Email="emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name=findViewById(R.id.et_name);
        et_pass=findViewById(R.id.et_pass);
        et_mail=findViewById(R.id.et_mail);
        btn_Save=findViewById(R.id.btn_Save);

        sharedPreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(Name,et_name.getText().toString());
                editor.putString(Pass,et_pass.getText().toString());
                editor.putString(Email, et_mail.getText().toString());
                editor.commit();
                Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();
            }
        });

    }
}