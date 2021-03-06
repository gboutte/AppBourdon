package com.example.issac.myapplication.IHM;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.issac.ppe2sanskt.R;

/*
    Ce projet n'est qu'un brouillon et un rappel du fonctionnement des activités, pour jump d'une activité à l'autre.

    Créer une activité :
        Il faut un fichier class, un fichier xml et quelques lignes à ajouter dans main_activity et le manifest


        - créez un fichier dans res->layout-> [nom].xml | mettez y vos styles, boutons, etc...

        - créez un fichier de classe dans java->[votre dossier, ici j'ai pris par défaut]->[nom].class

        - créez quelques lignes dans manifest de manière à avoir au moins :

                        <activity android:name=".[nom]">
                        </activity>

        - créez quelques lignes dans votre main_activity :
                Un bouton : private Boutton [nom];
                Une liaison entre la variable et le bouton réel : [nom] = (Button) findViewById(R.id.[nom bouton]);

                Un truc qui se passe quand vous cliquez sur le bouton :
                            [nom].setOnClickListener(new OnClickListener() {
                                public void onClick(View v) {
                                    [fonction ou directos un truc du genre :
                                            startActivity(new Intent([activité actuelle].this, [nom].class));
                                    ]
                                }
                            });

 */

public class MainActivity extends AppCompatActivity {
    private Button exit;                                                // on déclare à l'avance tout les boutons ici dans l'activité
    private Button specialisation_vue;
    private Button commercial_add;
    private Button company_vue;
    private Button importance_add;
    private Button btnEntry_vue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {                // lorsque que l'activité est lancée
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                         // le contenu affiché est celui du fichier "activity_main.xml"
        exit = (Button) findViewById(R.id.exit);                        // Le bouton exit est lié au bouton portant l'id "exit"
        specialisation_vue = (Button) findViewById(R.id.specialisation_vue);              // Le bouton user_view est lié au bouton portant l'id "user_view"
        commercial_add = (Button) findViewById(R.id.commercial_add);
        company_vue = (Button) findViewById(R.id.company_vue);
        importance_add = (Button) findViewById(R.id.importance_add);
        btnEntry_vue = (Button) findViewById(R.id.entry_vue);






        exit.setOnClickListener(new OnClickListener() {                                        // quand on clique sur le bouton exit
                public void onClick(View v) {                           // fonction qui se déclenche quand on clique
                    finish();                                           // fin de l'app
                    System.exit(0);                              // android quitte l'application
                }
            });
        specialisation_vue.setOnClickListener(new OnClickListener() {            // quand on clique sur le bouton user_view
                    public void onClick(View v) {
                        switchTo_specialisation_vue();                           // la fonction switchTo va changer l'activité
                    }
                });




        commercial_add.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                switchTo_commercial_add();
            }
        });

        importance_add.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                importance_add();
            }
        });

        company_vue.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                switchTo_company_vue();
            }
        });

        btnEntry_vue.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                switchTo_entry_vue();
            }
        });



    }

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

/*
10/04
Matthieu
Procedure qui permet de changer d'activité, passe de l'activité courante à la liste des clients, l'ajout des clients, ou des options
activity (this) to (user_list)
*/


    public void switchTo_specialisation_add() {
        Intent intent = new Intent(this, com.example.issac.myapplication.IHM.specialisation.Specialisation_add.class);
        startActivity(intent);
    }

    public void switchTo_specialisation_vue() {
        Intent intent = new Intent(this, com.example.issac.myapplication.IHM.specialisation.Specialisation_vue.class);
        startActivity(intent);
    }

    public void switchTo_commercial_add() {
        Intent intent = new Intent(this, com.example.issac.myapplication.IHM.Commercial_add.class);
        startActivity(intent);
    }


    public void switchTo_company_vue() {
        Intent intent = new Intent(this, com.example.issac.myapplication.IHM.company.Company_vue.class);
        startActivity(intent);
    }

    public void switchTo_entry_vue() {
        Intent intent = new Intent(this, com.example.issac.myapplication.IHM.entry.Entry_vue.class);
        startActivity(intent);
    }

    public void importance_add() {
        Intent intent = new Intent(this, com.example.issac.myapplication.IHM.Importance_management.class);
        startActivity(intent);
    }

}
