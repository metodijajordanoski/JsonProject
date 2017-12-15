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

public class CustomImagesAdapter extends RecyclerView.Adapter<CustomImagesAdapter.ViewHolder> {

    List<ImageData> ImageDataArrayList = new ArrayList<>();
    Context context;
    OnRecyclerviewClickListener onRecyclerviewClickListener;


    public CustomImagesAdapter(Context _context,OnRecyclerviewClickListener _onRecyclerviewClickListener) {
        context=_context;
        onRecyclerviewClickListener=_onRecyclerviewClickListener;
    }

    public void setItems(List<ImageData> images) {
        ImageDataArrayList=images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.recyclerview_images_row,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ImageData image = ImageDataArrayList.get(position);

        holder.textView.setText(image.getTags());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecyclerviewClickListener.onRowClick(image);
            }
        });

        Picasso.with(context)
                .load(image.getPreviewURL())
                .centerInside()
                .fit()
                .into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return ImageDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textI)
        TextView textView;
        @BindView(R.id.imageI)
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }


    }
}
