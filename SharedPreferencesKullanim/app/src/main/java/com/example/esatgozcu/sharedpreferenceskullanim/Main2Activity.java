package com.example.esatgozcu.sharedpreferenceskullanim;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView textView;
    Button deleteButton;
    Button changeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = (TextView)findViewById(R.id.textView);
        deleteButton = (Button)findViewById(R.id.deleteButton);
        changeButton = (Button)findViewById(R.id.changeButton);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.esatgozcu.sharedpreferenceskullanim", Context.MODE_PRIVATE);
        // Giriş yapan kullanıcını isimini yazdırıyoruz
        String name = sharedPreferences.getString("userName","name");
        textView.setText(name);
    }

    // Sil butonuna tıklayınca
    public void delete(View view)
    {
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.esatgozcu.sharedpreferenceskullanim", Context.MODE_PRIVATE);

        // Değişkeni siliyoruz
        sharedPreferences.edit().remove("userName").apply();

        // Tekrardan isim girilmesi için false yapıyoruz
        sharedPreferences.edit().putBoolean("first", false).apply();

        textView.setText("Name");
    }

    // Değiştir butonuna tıklayınca
    public void change(View view)
    {
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.esatgozcu.sharedpreferenceskullanim", Context.MODE_PRIVATE);
        // Tekrardan isim girilmesi için false yapıyoruz
        sharedPreferences.edit().putBoolean("first", false).apply();

        /*
        Verileri değiştirirken verinin tekrardan üstüne yazıyoruz
         */

        // Diğer sayfaya geçiş yapıyoruz
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
