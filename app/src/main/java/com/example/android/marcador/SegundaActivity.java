package com.example.android.marcador;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {
    Button boton;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        boton = (Button) findViewById(R.id.boton);
        texto = (TextView) findViewById(R.id.texto);
    }

    void snack(View v){
        //Creando un Snackbar
        Snackbar snackbar = Snackbar.make(v,"Esto es un SnackBar",Snackbar.LENGTH_LONG)
                //Darle una accion al Snackbar simepre poner View.OnClickListener e implementar el metodo
                .setAction("Accion", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cualquier accion
                texto.setText("Listo!");
            }
        });
        snackbar.show();
    }
}
