package com.example.issac.ppe2sanskt.IHM;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.issac.ppe2sanskt.MODEL.commercial;
import com.example.issac.ppe2sanskt.MODEL.specialisation;
import com.example.issac.ppe2sanskt.R;

import org.json.JSONObject;

public class commercial_add extends AppCompatActivity {
    private commercial unCommercial;
    private Button creation;
    private TextView commercialNickName;         // le texte non éditable
    private TextView commercialName;
    private TextView commercialAddress1;
    private TextView commercialAddress2;
    private TextView commercialCP;
    private TextView commercialCity;

    private EditText commercialNickNameField;        // le texte que l'utilisateur compléte
    private EditText commercialNameField;
    private EditText commercialAddress1Field;
    private EditText commercialAddress2Field;
    private EditText commercialCPField;
    private EditText commercialCityField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commercial_add);
        creation = (Button) findViewById(R.id.creation);
        commercialNickNameField = (EditText) findViewById(R.id.nickName);
        commercialNameField = (EditText) findViewById(R.id.name);
        commercialAddress1Field = (EditText) findViewById(R.id.address1);
        commercialAddress2Field = (EditText) findViewById(R.id.address2);
        commercialCPField =(EditText) findViewById(R.id.pc);
        commercialCityField = (EditText) findViewById(R.id.city);

    creation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
            JSONObject res = new JSONObject();
            unCommercial = new commercial();
            String url = unCommercial.urlGen("create", commercialNickNameField.getText().toString(),
                    commercialNameField.getText().toString(),
                    commercialAddress1Field.getText().toString(),
                    commercialAddress2Field.getText().toString(),
                    commercialCPField.getText().toString(),
                    commercialCityField.getText().toString());     // on prépare l'url pour la requête en fonction de l'action voulue + champ écrit
            res = unCommercial.getJsonFromURL(url);       // on exécute l'action et on récup si elle fonctionne ou non (true or false)
            unCommercial.putInObj(res);
            }
        });
    }

}
