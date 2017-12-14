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
    public CustomImagesAdapter(Context _context) {
        context=_context;
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
        ImageData image = ImageDataArrayList.get(position);

        holder.textView.setText(image.getTags());

        Picasso.with(context)
                .load(image.getWebformatURL())
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
