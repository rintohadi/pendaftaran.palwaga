package id.sch.smktelkom_mlg.tugas01.xiirpl1030.formpendaftaranpalwaga;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText znama;
    Button buton;
    TextView hasile;
    RadioButton r1,r2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        znama = (EditText) findViewById(R.id.editNama);
        buton = (Button) findViewById(R.id.button);
        hasile = (TextView) findViewById(R.id.hasil);
        r1 = (RadioButton) findViewById(R.id.radioButton);
        r2 = (RadioButton) findViewById(R.id.radioButton2);

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
            hasile.setText("Nama   : "+nama);
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
                hasile.setText("Nama        : "+nama
                +"\nJenis kelamin   : " + hasil);
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
