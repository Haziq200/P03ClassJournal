package sg.edu.rp.dmsd.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DailyGradesActivity extends AppCompatActivity {

    ListView lvGrade;
    ArrayAdapter aa;
    ArrayList<DailyGrades> dg;
    private Intent dataIntent;

    Button btnInfo;
    Button btnAdd;
    Button btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        lvGrade = (ListView) this.findViewById(R.id.ListViewDaily);
        btnInfo = findViewById(R.id.buttonInfo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnEmail = findViewById(R.id.buttonEmail);


        Intent i = getIntent();
        DailyGrades dg1 = (DailyGrades) i.getSerializableExtra("daily");
        DailyGrades dg2 = (DailyGrades) i.getSerializableExtra("daily2");
        DailyGrades dg3 = (DailyGrades) i.getSerializableExtra("daily3");


        dg = new ArrayList<DailyGrades>();
        dg.add(new DailyGrades(1, "B", "C347"));
        dg.add(new DailyGrades(2, "C", "C347"));
        dg.add(new DailyGrades(3, "A", "C347"));

        aa = new GradeAdapter(this, R.layout.layout2, dg);
        lvGrade.setAdapter(aa);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("https://www.rp.edu.sg/soi/full-time-diplomas/details/r47"));
                startActivity(rpIntent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT, "");
                email.putExtra(Intent.EXTRA_TEXT, "");
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email, "Choose an Email client :"));


            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DailyGradesActivity.this, ThirdActivity.class);
                int numofweeks = dg.get(dg.size() - 1).getWeek();
                i.putExtra("weekno", numofweeks);
                startActivityForResult(i, REQUEST_CODE_1);

            }
        });



    }

    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent dataIntent){
        super.onActivityResult(requestCode, resultCode, dataIntent);


        // The returned result data is identified by requestCode.
        // The request code is specified in startActivityForResult(intent, REQUEST_CODE_1); method.
        switch (requestCode) {
            // This request code is set by startActivityForResult(intent, REQUEST_CODE_1) method.
            case REQUEST_CODE_1:
                if (resultCode == RESULT_OK) {
                    String grade = dataIntent.getStringExtra("grade");
                    dg.add(new DailyGrades(dg.get(dg.size() - 1).getWeek() + 1),grade,"C347");
                    aa.notifyDataSetChanged();
                }
        }
    }
}
