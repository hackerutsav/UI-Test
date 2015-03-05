package com.example.nagarro.pandora;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
/**
 * Created by nagarro on 08/02/15.
 */
public class StudentAdapter extends ArrayAdapter<Student>{

    public static final int HEADER_VIEW = 1;
    public static final int ITEM_VIEW = 2;
    List<Student> objects;
    Context context;
    LayoutInflater l;
    StudentAdapterListener listenerActivity;

    public interface StudentAdapterListener {
        public void studentEditButtonClicked(Student s);
    }

    @Override
    public int getCount() {
        int count = objects.size();
        if (count % 2 == 0) {
            return count/2 + count;
        } else {
            return count/2 + count + 1;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0)
            return HEADER_VIEW;
        else
            return ITEM_VIEW;
    }

    public void setStudentAdapterListener(StudentAdapterListener a) {
        listenerActivity = a;
    }

    public StudentAdapter(Context context, int resource, List<Student> objects, LayoutInflater l) {
        super(context, resource);
        this.objects = objects;
        this.context = context;
        this.l = l;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //LayoutInflater l = ((Activity)context).getLayoutInflater();
        if (position % 3 != 0) {
            View v = convertView;
            int index = position - position/3 -1;
            final Student s = objects.get(index);
            if (v == null) {
                v = l.inflate(R.layout.item_layout, null);// Layout  se view
            }


            TextView name = (TextView) v.findViewById(R.id.name);
            final TextView rollNumber = (TextView) v.findViewById(R.id.roll_number);
            Button b = (Button) v.findViewById(R.id.itemButton);
            b.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v2) {
                                         listenerActivity.studentEditButtonClicked(s);
                                     }
                                 }
            );

            rollNumber.setText(s.count + "");
            name.setText(s.name);
            return v;
        } else {
            View v = convertView;
            if (v == null) {
                v = l.inflate(R.layout.header_layout, null);// Layout  se view
            }
            return v;
        }
    }
}
