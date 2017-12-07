package prvaaplikacija.recycleviewer;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mende on 07.12.2017.
 */

public class CustomStudentsAdapter extends RecyclerView.Adapter<CustomStudentsAdapter.ViewHolder> {

    List<Student> studentList = new ArrayList<>();
    Context context;
    public CustomStudentsAdapter(Context _context) {
        context=_context;
    }

    public void setItems(List<Student> students) {
        studentList=students;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.recyclerview_row,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student student = studentList.get(position);

        holder.textView.setText(student.getsName());
        if(student.getsOnline()) {
            holder.textView2.setText("Online");
            holder.textView2.setBackgroundColor(Color.GREEN);
        } else {
            holder.textView2.setBackgroundColor(Color.RED);
            holder.textView2.setText("Offline");
        }

        Picasso.with(context)
                .load(R.mipmap.ic_launcher)
                .centerInside()
                .fit()
                .into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text)
        TextView textView;
        @BindView(R.id.text2)
        TextView textView2;
        @BindView(R.id.imageView)
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }


    }
}
