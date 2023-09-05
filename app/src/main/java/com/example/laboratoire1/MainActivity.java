package com.example.laboratoire1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickChk_afficher(View view) {
        CheckBox cb_afficher = (CheckBox) findViewById(R.id.chk_afficher);
        EditText et_mdp = (EditText) findViewById(R.id.et_mdp);

        if (cb_afficher.isChecked())
            et_mdp.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        else
            et_mdp.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    public void onClickBtn_valider(View view) {
        Button btn_valider = (Button) findViewById(R.id.btn_valider);
        TextView tv_erreur = (TextView) findViewById(R.id.tv_erreur);
        EditText et_mdp = (EditText) findViewById(R.id.et_mdp);
        int bleu = ContextCompat.getColor(this, R.color.bleu);
        int rouge = ContextCompat.getColor(this, R.color.rouge);
        String valide = getResources().getString(R.string.tv_erreurCorrect);
        String invalide = getResources().getString(R.string.tv_erreurIncorrect);

        if (isValidPassword(et_mdp.getText().toString().trim())) {
            tv_erreur.setText(valide);
            tv_erreur.setTextColor(bleu);
        } else {
            tv_erreur.setText(invalide);
            tv_erreur.setTextColor(rouge);
        }
    }

    public boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%&()\\[\\]{}_=<>+\\-!?*/|:;.,‘\"~^]).{10,}$";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
}