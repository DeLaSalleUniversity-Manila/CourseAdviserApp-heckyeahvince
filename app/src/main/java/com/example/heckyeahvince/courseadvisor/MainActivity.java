package com.example.heckyeahvince.courseadvisor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private CourseFlowchart courseflowchart = new CourseFlowchart();

    public void onClickFindCourse(View view){
        Spinner spinner = (Spinner) findViewById(R.id.termMenu);

        String term = String.valueOf(spinner.getSelectedItem());

        List<String> courseList = courseflowchart.getCourses(term);

        StringBuilder coursesFormatted = new StringBuilder();

        for (String course: courseList)
            coursesFormatted.append(course).append('\n');

        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("Flowchart", (CharSequence) coursesFormatted);
        i.putExtra("Term Tag", term);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
