package sg.edu.rp.dmsd.p03_classjournal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView tvWeek;
    Button btnSubmit;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout4);

        tvWeek = findViewById(R.id.textViewWeek);
        btnSubmit = findViewById(R.id.buttonSubmit);
        rg = findViewById(R.id.rg);

        Intent i = getIntent();
        final int numofweek = i.getIntExtra("numofweek", 0) + 1;
        tvWeek.setText("numofweek " + numofweek);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedButtonId);
                String grade = rb.getText().toString();


                Intent intent = new Intent();
                intent.putExtra("grade", grade);
                setResult(RESULT_OK, intent);
                finish();

            }
        });


    }

}
