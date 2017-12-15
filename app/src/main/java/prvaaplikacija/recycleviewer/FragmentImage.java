package prvaaplikacija.recycleviewer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Mende on 15.12.2017.
 */

public class FragmentImage extends Fragment {

    private Unbinder mUnbinder;
    @BindView(R.id.imageFullScreen)
    ImageView imageFullScreen;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_image,null);
        mUnbinder = ButterKnife.bind(this, view);

        String url = getArguments().getString("SLIKA_URL");


        Picasso.with(getActivity())
                .load(url.toString())
                .centerInside()
                .fit()
                .into(imageFullScreen);
        return view;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }



}

