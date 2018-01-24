package com.example.esatgozcu.sharedpreferenceskullanim;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.editText);
        nextButton=(Button)findViewById(R.id.nextButton);

        // SharedPreferences nesnemizi oluşturuyoruz.
        // İlk parametre package name giriyoruz.
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.esatgozcu.sharedpreferenceskullanim", Context.MODE_PRIVATE);

        /*
         sharedPreferences.getBoolean(anahtar kelime , varsayılan değer)
         */

        // Eğer kullanıcı daha önce giriş yaptı ise diğer sayfaya geçiş yapacak
        if (sharedPreferences.getBoolean("first",false))
        {
            // Diğer sayfaya geçiş yapıyoruz
            Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(intent);
        }

    }

    // İleri butonuna tıkladığımızda
    public void next(View view)
    {

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.esatgozcu.sharedpreferenceskullanim", Context.MODE_PRIVATE);

        // Kullanıcının ismini name değişkenine atıyoruz
        String name = editText.getText().toString();

        /*
        sharedPreferences.edit().putString(anahtar kelime , kayıt edilecek veri)
         */

        // name değişkenini kayıt ediyoruz
        sharedPreferences.edit().putString("userName", name).apply();

        // Kullanıcı ilk girdiğinde first anahtar kelimesini true yapıyoruz.
        sharedPreferences.edit().putBoolean("first", true).apply();

        // Diğer sayfaya geçiş yapıyoruz
        Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(intent);
    }
}
