package com.example.projectwastebin.Sellers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectwastebin.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SellerLoginActivity extends AppCompatActivity {

    private Button loginSellerBtn;
    private EditText emailInput, passwordInput;
    private ProgressDialog loadingBar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_login);

        emailInput= findViewById(R.id.seller_login_email);
        passwordInput= findViewById(R.id.seller_login_password);

        loginSellerBtn= findViewById(R.id.seller_login_btn);
        loadingBar = new ProgressDialog(this);
        mAuth= FirebaseAuth.getInstance();

        loginSellerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                loginSeller();
            }
        });
    }

    private void loginSeller(){
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();


        if (email.isEmpty()) {
            emailInput.setError("Email is required");
            emailInput.requestFocus();
            return;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.setError("Please provide valid email!");
            emailInput.requestFocus();
            return;
        } else if (password.isEmpty()) {
            passwordInput.setError("Phone number is required");
            passwordInput.requestFocus();
            return;
        } else if (password.length() < 6) {
            passwordInput.setError("Min password length should be 6 characters!");
            passwordInput.requestFocus();
            return;
        }
        else {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();

                                if(user.isEmailVerified()){

//                                    loadingBar.setTitle("Login");
//                                    loadingBar.setMessage("Please wait....");
//                                    loadingBar.setCanceledOnTouchOutside(false);
//                                    loadingBar.show();

                                    Intent intent= new Intent(SellerLoginActivity.this, SellerHomeActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    finish();
                                }else {
                                    user.sendEmailVerification();
                                    Toast.makeText(SellerLoginActivity.this, "Check your email to verify your account", Toast.LENGTH_LONG).show();
                                }
                                //      Toast.makeText(SellerLoginActivity.this, "You are Login Successfully", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(SellerLoginActivity.this, "Incorrect Password or Email", Toast.LENGTH_LONG).show();
                            }
                        }
                    });

        }


    }
}