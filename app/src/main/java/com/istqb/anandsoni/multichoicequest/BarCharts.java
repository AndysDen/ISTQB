package com.istqb.anandsoni.multichoicequest;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BarCharts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_charts);
         setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        Bundle bundle = getIntent().getExtras();
        ResultHolder resultHolder=(ResultHolder)bundle.getSerializable("resultHolder");

        List<BarEntry> entries= populateEntries(resultHolder);
        //ArrayList<BarEntry> entries = new ArrayList<>();
//        entries.add(new BarEntry(4f, 0));
//        entries.add(new BarEntry(8f, 1));
//        entries.add(new BarEntry(6f, 2));
//        entries.add(new BarEntry(12f, 3));
//        entries.add(new BarEntry(18f, 4));
//        entries.add(new BarEntry(9f, 5));
        BarDataSet dataset = new BarDataSet(entries, "# of Correct Answer");
        ArrayList<String> labels = addLabels(resultHolder.getSetOfTestResult().size());


//        labels.add("January");
//        labels.add("February");
//        labels.add("March");
//        labels.add("April");
//        labels.add("May");
//        labels.add("June");

        BarChart chart = new BarChart(this);
        setContentView(chart);

        BarData data = new BarData(labels, dataset);
        chart.setData(data);
    }

    public List<BarEntry> populateEntries(ResultHolder resultHolder){
        Set<TestResults> testResult=resultHolder.getSetOfTestResult();
        ArrayList<BarEntry> barEntryArrayList = new ArrayList<BarEntry>();
        int counter=0;
        for(TestResults results:testResult){
         barEntryArrayList.add(new BarEntry(results.getNoOfCorrectAnswer(),counter));
            counter++;

        }
    return barEntryArrayList;

    }

    private ArrayList<String> addLabels(int noOfAttempts){
        ArrayList<String> listOfLabels= new ArrayList<String>();
         int attempt=0;
        for(int i=1;i<=noOfAttempts;i++){
            listOfLabels.add("Attempt "+i);
        }


        return listOfLabels;
    }

}
