package sg.edu.rp.dmsd.p03_classjournal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GradeAdapter extends ArrayAdapter<DailyGrades> {

    private Context context;
    private ArrayList<DailyGrades> dg;
    private TextView tvWeek;
    private ImageView ivGrade;
    private TextView  tvDailyGrade;
    private TextView tvGrade;

    public GradeAdapter(Context context, int resource, ArrayList<DailyGrades> objects) {
        super(context, resource, objects);
        dg = objects;
        this.context = context;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.layout3, parent, false);

        tvWeek = rowView.findViewById(R.id.textViewWeek);
        tvDailyGrade = rowView.findViewById(R.id.textViewDailyGrades);
        ivGrade = rowView.findViewById(R.id.imageView);
        tvGrade = rowView.findViewById(R.id.textViewGrade);


        DailyGrades currentDailygrade = dg.get(position);



        tvWeek.setText("week " + currentDailygrade.getWeek());
        ivGrade.setImageResource(R.drawable.dg);
        tvGrade.setText(currentDailygrade.getGrade());


        return rowView;
    }

}
