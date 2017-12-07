package prvaaplikacija.recycleviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        CustomStudentsAdapter adapter = new CustomStudentsAdapter();
        adapter.setItems(generateList());
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);

    }

    ArrayList<Student> generateList() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Metodija",true));
        students.add(new Student("ndjenjde",true));
        students.add(new Student("Ela",true));
        students.add(new Student("Neta",true));
        students.add(new Student("firjfri",true));
        students.add(new Student("firjfri",true));
        students.add(new Student("firjfri",true));
        students.add(new Student("firjfri",true));
        students.add(new Student("firjfri",true));
        students.add(new Student("firjfri",true));
        students.add(new Student("firjfri",true));
        students.add(new Student("firjfri",true));
        students.add(new Student("firjfri",true));
        students.add(new Student("firjfri",true));
        students.add(new Student("firjfri",true));
        students.add(new Student("firjfri",true));
        students.add(new Student("firjfri",true));
        students.add(new Student("firjfri",true));
        students.add(new Student("firjfri",true));
        students.add(new Student("firjfri",true));
        students.add(new Student("firjfri",true));


        return students;


    }


}
