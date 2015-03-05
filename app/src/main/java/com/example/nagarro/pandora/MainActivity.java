package com.example.nagarro.pandora;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener, StudentAdapter.StudentAdapterListener {
    ArrayList<Student> data;
    StudentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_layout);
        Log.i("lifecycle","on create called");
        ListView lv = (ListView)findViewById(R.id.listView);


        data = new ArrayList<Student>();

        Student s1 = new Student("Pulkit", "1");
        Student s2 = new Student("Utsav", "2");

        data.add(s1);
        data.add(s2);
        data.add(s1);
        data.add(s2);
        data.add(s1);
        data.add(s2);
        data.add(s1);
        data.add(s2);
        data.add(s1);
        data.add(s2);
        data.add(s1);
        data.add(s2);
        LayoutInflater l = getLayoutInflater();
        adapter = new StudentAdapter(this, 0, data, l);

        lv.setAdapter(adapter);

        adapter.setStudentAdapterListener(this);

        lv.setOnItemClickListener(this);
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i("lifecycle","on start called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("lifecycle","on resume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("lifecycle","on pause called");
    }

    @Override
    protected void onStop() {
        super.onPause();
        Log.i("lifecycle","on pause called");
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
        } else if (id == R.id.add) {
            Student s = new Student("name", "roll number");
            data.add(s);
            adapter.notifyDataSetChanged();
            return true;

        } else if (id == R.id.remove) {
            data.remove(data.size() - 1);
            adapter.notifyDataSetChanged();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Student s = (Student)parent.getAdapter().getItem(position);
        Toast t = Toast.makeText(this, s.name, Toast.LENGTH_LONG);
        t.show();

    }

    @Override
    public void studentEditButtonClicked(Student s) {
        Toast.makeText(this, s.name,Toast.LENGTH_LONG).show();
        TextView tv = (TextView)findViewById(R.id.name);
        tv.setText(s.name);
    }


