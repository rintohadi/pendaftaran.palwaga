package id.sch.smktelkom_mlg.tugas01.xiirpl1030.formpendaftaranpalwaga;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText znama;
    Button buton;
    TextView hasile;
    RadioButton r1,r2;
    CheckBox c1,c2,c3;
    Spinner spi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        znama = (EditText) findViewById(R.id.editNama);
        buton = (Button) findViewById(R.id.button);
        hasile = (TextView) findViewById(R.id.hasil);
        r1 = (RadioButton) findViewById(R.id.radioButton);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        c1 = (CheckBox) findViewById(R.id.checkBox);
        c2 = (CheckBox) findViewById(R.id.checkBox2);
        c3 = (CheckBox) findViewById(R.id.checkBox3);
        spi = (Spinner) findViewById(R.id.spinner);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });
    }

    private void doProcess() {
        if (isValid())
        {
            String nama = znama.getText().toString();
            String qwe = "\nGunung yang ingin dikunjungi : \n";
            int startlen = qwe.length();
            if(c1.isChecked()) qwe+=c1.getText()+"\n";
            if(c2.isChecked()) qwe+=c2.getText()+"\n";
            if(c3.isChecked()) qwe+=c3.getText()+"\n";

            if(qwe.length()==startlen) qwe+= "Tidak ada yang dipilih\n";
            String hasil = null;
            if(r1.isChecked())
            {
                hasil = r1.getText().toString();
            }
            else if(r2.isChecked())
            {
                hasil = r2.getText().toString();
            }
            if(hasil == null)
            {
                hasile.setText("anda belum memilih jenis kelamin");
            }
            else
            {
                hasile.setText("Nama : "+nama
                +"\nJenis kelamin : " + hasil+qwe+"jabatan yang diinginkan : "+spi.getSelectedItem().toString());
            }

        }
}

    private boolean isValid() {
        boolean valid = true;
        String nama = znama.getText().toString();

        if(nama.isEmpty()){
            znama.setError("Nama belum diisi");
            valid=true;
        }
        else{
            znama.setError(null);
        }
        return valid;
    }
    }
