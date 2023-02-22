package com.example.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    private FirebaseAuth usuario = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DatabaseReference usuarios = referencia.child("usuarios");


        //DatabaseReference usuarioPesquisa = usuarios.child("-NLN-FKB45dQ5D-_BG76");
        Query usuarioPesquisa = usuarios.orderByKey().limitToFirst(3);


        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               /* Usuario dadosUsuario = dataSnapshot.getValue(Usuario.class);
                Log.i("Dados usuario: ", "Nome: " + dadosUsuario.getNome() + "idade: " + dadosUsuario.getIdade());*/

                Log.i("Dados usuario: ", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });






       /*
        Usuario usuario = new Usuario();
        usuario.setNome("Melissa");
        usuario.setSobrenome("Silva");
        usuario.setIdade(35);

        usuarios.push().setValue(usuario);*/

        /*Deslogar Usuário*/
        // usuario.signOut();

        /*Logar Usuário
        usuario.signInWithEmailAndPassword("israelpossidonio01@gmail.com",
                "Suporte@2020").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.i("signIn", "Sucesso ao logar usuário");
                }else{
                    Log.i("signIn", "Erro ao logar usuário");

                }
            }
        });*/

        /*Verifica se o usuário está logado

        if (usuario.getCurrentUser() != null){
            Log.i("CurrentUser", "Usuário logado");
        }else{
            Log.i("CurrentUser", "Usuário não está logado");
        }*/






         /*Cadastro de usuário */
         /*
        usuario.createUserWithEmailAndPassword("israelpossidonio01@gmail.com", "Suporte@2020")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("CreateUser", "Sucesso ao cadastrar usuário");
                        }else{
                            Log.i("CreateUser", "Erro ao cadastrar usuário");

                        }
                    }
                });*/


        /*
       DatabaseReference usuarios = referencia.child("usuarios");

       usuarios.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               Log.i("FIREBASE", dataSnapshot.getValue().toString());
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });

       Usuario usuario = new Usuario();
       usuario.setNome("Braga");
       usuario.setSobrenome("B");
       usuario.setIdade(30);

       usuarios.child("001").setValue(usuario);

        DatabaseReference produtos = referencia.child("produtos");

        Produto produto = new Produto();

        produto.setMarca("Nestle");
        produto.setDescricao("Creme de Leite");
        produto.setPreco(3.50);

        produtos.child("001").setValue(produto);

        */






    }
}
