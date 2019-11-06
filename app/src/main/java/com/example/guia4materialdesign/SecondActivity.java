package com.example.guia4materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.inmite.android.lib.validations.form.FormValidator;
import eu.inmite.android.lib.validations.form.annotations.MaxLength;
import eu.inmite.android.lib.validations.form.annotations.MinLength;
import eu.inmite.android.lib.validations.form.annotations.NotEmpty;
import eu.inmite.android.lib.validations.form.callback.SimpleErrorPopupCallback;
import Entidades.Contacto;
import static com.example.guia4materialdesign.MainActivity.lstContactos;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.edtNombre)
    @NotEmpty(messageId = R.string.ValidarNombre, order = 1)
    EditText edtNombre;

    @BindView(R.id.edtTel)
    @NotEmpty(messageId =R.string.ValidarTelefono, order = 2)
    @MinLength(value = 8, messageId = R.string.Tamanio, order = 3)
    @MaxLength(value = 8, messageId = R.string.Tamanio, order = 4)
    EditText edtTel;

    @BindView(R.id.edtOrg)
    @NotEmpty(messageId =R.string.ValidarOrganizacion, order = 5)
    EditText edtOrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
    }

    public void OnClickGuardar(View v){
        if(FormValidator.validate(this, new SimpleErrorPopupCallback(this))){
            Contacto con = new Contacto(lstContactos.size() + 1, edtNombre.getText().toString(),
                                            edtTel.getText().toString(), edtOrg.getText().toString());

            lstContactos.add(con);

            Intent in = new Intent();
            in.putExtra("k", "Contacto añadido con éxito");
            setResult(RESULT_OK, in);
            this.finish();
        }
    }

    public void OnClickDatos(View v){
        Intent in = new Intent(this, Datos.class);
        startActivity(in);
    }
}
