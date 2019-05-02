package sg.edu.rp.dmsd.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvC347;
    ArrayList<String> al;
    ArrayAdapter<String> aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        tvC347 = findViewById(R.id.textViewC347);

        al = new ArrayList<String>();
        al.add("C347");

        tvC347.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DailyGrades week1 = new DailyGrades(1,"B","C347");
                DailyGrades week2 = new DailyGrades(2,"C","C347");
                DailyGrades week3 = new DailyGrades(3,"A","C347");

                Intent i = new Intent(MainActivity.this
                ,DailyGradesActivity.class);
                i.putExtra("daily",week1);
                i.putExtra("daily2",week2);
                i.putExtra("daily3",week3);
                startActivity(i);
            }
        });



    }
}
