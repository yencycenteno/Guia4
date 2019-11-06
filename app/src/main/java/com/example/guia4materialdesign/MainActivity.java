package com.example.guia4materialdesign;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import Adaptadores.AdaptadorContactos;
import Entidades.Contacto;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static List<Contacto> lstContactos;
    AdaptadorContactos adapContactos;

    @BindView(R.id.fabAdd)
    FloatingActionButton fabAdd;

    @BindView(R.id.rvContactos)
    RecyclerView rvContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        lstContactos = new ArrayList<>();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvContactos.setLayoutManager(layoutManager);

        adapContactos = new AdaptadorContactos(lstContactos);
        rvContactos.setAdapter(adapContactos);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(in, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:{
                if(requestCode == RESULT_OK){
                    String msg = data.getStringExtra("k");
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                }
            } break;
        }
    }
}
