package au.edu.unsw.infs3634.tourismguide;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    Activity parent = getActivity();

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Connect bundle
        int rank = getArguments().getInt(MainActivity.KEY);
        Log.d("TAG", "onActivityCreated: rank is = " + rank);

        // Specify all views
        ImageView touristAttractionImg = getView().findViewById(R.id.touristAttractionImg);
        TextView nameText = getView().findViewById(R.id.nameText);
        TextView rankText = getView().findViewById(R.id.rankText);
        RatingBar ratingBar = getView().findViewById(R.id.ratingBar);
        TextView costText = getView().findViewById(R.id.costText);
        TextView attractionText = getView().findViewById(R.id.attractionText);
        TextView locationText = getView().findViewById(R.id.locationText);
        TextView reviewText = getView().findViewById(R.id.reviewText);

        // Get tourist guide attraction information to set to fields
        TouristGuide curr = TouristGuide.touristGuideSearch(rank);
        touristAttractionImg.setImageResource(curr.getImage());
        nameText.setText(curr.getName());
        rankText.setText(Integer.toString(curr.getRank()));
        ratingBar.setRating((float) curr.getRating());
        costText.setText(curr.getCost());
        attractionText.setText(curr.getAttraction());
        locationText.setText(curr.getLocation());
        reviewText.setText(curr.getReview());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }
}
