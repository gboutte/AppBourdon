package com.example.issac.myapplication.IHM.company;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.issac.myapplication.MODEL.Company;
import com.example.issac.ppe2sanskt.R;

import org.json.JSONObject;

/*
importe : 0
Contient le formulaire d'ajout d'une entreprise, aucun import car champs vierges.
Lors de la validation, une url est gen et met en place une requête PHP pour l'ajout en base.

 */

public class Company_add extends AppCompatActivity {
    private Company uneCompany;
    private Button creation;
    private TextView companyName;         // le texte non éditable
    private TextView companyAddress1;
    private TextView companyAddress2;
    private TextView companyCity;
    private TextView companyPC;
    private TextView companyNum;
    private TextView companyFax;
    private TextView companyMail;
    private TextView companyInterName;
    private TextView companyInterNickName;
    private TextView companyInterNum;
    private TextView companyInterFax;
    private TextView companyInterMail;


    private EditText companyNameField;        // le texte que l'utilisateur compléte
    private EditText companyAddress1_field;
    private EditText companyAddress2_field;
    private EditText companyCity_field;
    private EditText companyPC_field;
    private EditText companyNum_field;
    private EditText companyFax_field;
    private EditText companyMail_field;
    private EditText companyInterName_field;
    private EditText companyInterNickName_field;
    private EditText companyInterNum_field;
    private EditText companyInterFax_field;
    private EditText companyInterMail_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_add);
        creation = (Button) findViewById(R.id.creation);
        companyNameField = (EditText) findViewById(R.id.name_field);
        companyAddress1_field = (EditText) findViewById(R.id.address1_field);
        companyAddress2_field = (EditText) findViewById(R.id.address2_field);       //assignation de variables aux champs
        companyCity_field = (EditText) findViewById(R.id.city_field);
        companyPC_field = (EditText) findViewById(R.id.pc_field);
        companyNum_field =(EditText) findViewById(R.id.num_field);
        companyFax_field = (EditText) findViewById(R.id.fax_field);

        companyMail_field = (EditText) findViewById(R.id.mail_field);
        companyInterName_field = (EditText) findViewById(R.id.interName_field);
        companyInterNickName_field = (EditText) findViewById(R.id.interNickName_field);
        companyInterNum_field = (EditText) findViewById(R.id.interNum_field);
        companyInterFax_field =(EditText) findViewById(R.id.interFax_field);
        companyInterMail_field = (EditText) findViewById(R.id.interMail_field);



        creation.setOnClickListener(new View.OnClickListener()
        {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onClick (View v){
                JSONObject res = new JSONObject();
                uneCompany = new Company();     // if de vérification, les champs doivent avoir au moins un caractère, sinon, pas de tentative d'ajout.
                if(companyAddress1_field.getText().toString().length() > 0 && companyAddress2_field.getText().toString().length() > 0 && companyPC_field.getText().toString().length() > 0 && companyNum_field.getText().toString().length() > 0 && companyFax_field.getText().toString().length() > 0
                        && companyInterName_field.getText().toString().length() > 0 && companyInterNickName_field.getText().toString().length() > 0 && companyInterNum_field.getText().toString().length() > 0 && companyInterFax_field.getText().toString().length() > 0
                        && companyMail_field.getText().toString().length() > 0 && companyInterMail_field.getText().toString().length() > 0 && companyCity_field.getText().toString().length() > 0)
                {
                    String urle = uneCompany.urlGen("create", companyNameField.getText().toString(),
                            companyAddress1_field.getText().toString(),
                            companyAddress2_field.getText().toString(),
                            companyPC_field.getText().toString(),
                            companyNum_field.getText().toString(),
                            companyFax_field.getText().toString(),
                            companyInterName_field.getText().toString(),
                            companyInterNickName_field.getText().toString(),
                            companyInterNum_field.getText().toString(),
                            companyInterFax_field.getText().toString(),
                            companyMail_field.getText().toString(),
                            companyInterMail_field.getText().toString(),
                            companyCity_field.getText().toString());// on prépare l'url pour la requête en fonction de l'action voulue + champ// écrit
                    res = uneCompany.getJsonFromURL(urle);       // on exécute l'action et on récup si elle fonctionne ou non (true or false)
                    uneCompany.putInObj(res);
                    Intent intent = new Intent(getApplicationContext(), Company_vue.class);
                    startActivity(intent);
                }
            }
        });

    }

    /*
    Matthieu
    02/06
    retourne des booléans true
    Mise en forme du bouton superieur du menu
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        //Button retourMenu = (Button) findViewById(R.id.action_bar);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, com.example.issac.myapplication.IHM.MainActivity.class);
        startActivity(intent);
        return true;
    }


}
