package com.example.huecas002;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegistroActivity extends AppCompatActivity {

    TextView textView;
    TextView textView1;

    private EditText mEditnombre;
    private EditText mEditapellido;
    private EditText mEditmail;
    private EditText mEditcontrasenia;
    private Button mButtonRegister;
    private String userId;
    private String nombre = "";
    private String apellido = "";
    private String mail = "";
    private String contrasenia = "";

    FirebaseAuth mAuth;
    FirebaseFirestore db;
    DatabaseReference mDatareference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        mDatareference = FirebaseDatabase.getInstance().getReference();

        //EditText del activity
        mEditnombre = (EditText) findViewById(R.id.txtNombreRegistro);
        mEditapellido = (EditText) findViewById(R.id.txtApellidoRegistro);
        mEditmail = (EditText) findViewById(R.id.txtEmailRegistro);
        mEditcontrasenia = (EditText) findViewById(R.id.txtContraseñaRegistro);
        mButtonRegister = (Button) findViewById(R.id.btnRegitrocompleto);

        //Boton de registrarse
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = mEditnombre.getText().toString();
                apellido = mEditapellido.getText().toString();
                mail = mEditmail.getText().toString();
                contrasenia = mEditcontrasenia.getText().toString();

                if (nombre.isEmpty()){
                    Toast.makeText(RegistroActivity.this, "Ingrese su nombre", Toast.LENGTH_SHORT).show();
                }
                else if (apellido.isEmpty()){

                    Toast.makeText(RegistroActivity.this, "Ingrese su apellido", Toast.LENGTH_SHORT).show();
                }
                else if (mail.isEmpty()){
                    Toast.makeText(RegistroActivity.this, "Ingrese un mail", Toast.LENGTH_SHORT).show();
                }
                else if (!mail.contains("@") || !mail.contains(".")){
                    Toast.makeText(RegistroActivity.this, "Ingrese un mail que contenga @ y .", Toast.LENGTH_SHORT).show();
                }
                else if (contrasenia.isEmpty()){
                    Toast.makeText(RegistroActivity.this, "Ingrese una contraseña", Toast.LENGTH_SHORT).show();
                }
                else{
                    registerUser();
                }

            }
        });

        textView = (TextView) findViewById(R.id.omitirRegistro);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(RegistroActivity.this, "Omitio el registro", Toast.LENGTH_LONG).show();
            }
        });
        textView1 = (TextView) findViewById(R.id.omitirRegistro2);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void registerUser(){
        mAuth.createUserWithEmailAndPassword(mail, contrasenia).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Map<String, Object> map = new HashMap<>();
                    map.put("nombre", nombre);
                    map.put("apellido", apellido);
                    map.put("mail", mail);
                    map.put("contrasenia", contrasenia);

                    String id = mAuth.getCurrentUser().getUid();

                    mDatareference.child("Usuarios").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()){
                                startActivity(new Intent(RegistroActivity.this, MainActivity.class));
                                finish();
                            }
                            else{
                                Toast.makeText(RegistroActivity.this, "No se pudieron crear los datos correctamente", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(RegistroActivity.this, "No se pudo registrar este usuario", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}