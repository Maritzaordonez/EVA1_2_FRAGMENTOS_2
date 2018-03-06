package edu.tectii.eva1_2_fragmentos_2;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    RedFragment rfRojo;
    BlueFragment rfAzul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if(fragment.getClass() == RedFragment.class){
            rfRojo = (RedFragment) fragment;

        }else if (fragment.getClass() == BlueFragment.class){
            rfAzul =(BlueFragment) fragment;
        }
    }


    public void onMsgFromToMain(String sender, String sVal){
        Toast.makeText(this, "Fragmento" + sender, Toast.LENGTH_SHORT);
        if (sender.equals("RED_FRAG")){
            //Hacemos algo en el frag azul
            Toast.makeText(this,sender + sVal, Toast.LENGTH_SHORT).show();
        }else if (sender.equals("BLUE_FRAG")){
            //Hacemos algo en el frag rojo
            rfRojo.onMsgFromMain("Mensaje de" + sender + "=" + sVal);

        }
    }
}

