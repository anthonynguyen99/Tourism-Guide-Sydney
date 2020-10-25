package au.edu.unsw.infs3634.tourismguide;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TouristGuideAdapter extends RecyclerView.Adapter<TouristGuideAdapter.MyViewHolder> {
    private ArrayList<TouristGuide> mDataset;
    private LaunchListener mLaunchListener;

    public TouristGuideAdapter(ArrayList<TouristGuide> mDataset, LaunchListener mLaunchListener) {
        this.mDataset = mDataset;
        this.mLaunchListener = mLaunchListener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView touristAttractionImg;
        public TextView nameText;
        public TextView rankText;
        public TextView ratingText;
        public TextView costText;
        public TextView attractionText;
        public TextView locationText;

        LaunchListener myLaunchListener;

        public MyViewHolder(View itemView, LaunchListener myLaunchListener) {
            super(itemView);

            this.touristAttractionImg = itemView.findViewById(R.id.touristAttractionImg);
            this.nameText = itemView.findViewById(R.id.nameText);
            this.rankText = itemView.findViewById(R.id.rankText);
            this.ratingText = itemView.findViewById(R.id.ratingText);
            this.costText = itemView.findViewById(R.id.costText);
            this.attractionText = itemView.findViewById(R.id.attractionText);
            this.locationText = itemView.findViewById(R.id.locationText);

            this.myLaunchListener = myLaunchListener;

            itemView.setOnClickListener(this);

            Log.d("TAG", "myViewHolder: #3");

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            myLaunchListener.launch(position);
        }
    }

    @Override
    public TouristGuideAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_view, parent, false);

        MyViewHolder vh = new MyViewHolder(v, mLaunchListener);
        Log.d("TAG", "onCreateViewHolder: #4");

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TouristGuide curr = mDataset.get(position);

        //Set fields for tourist attractions
        holder.touristAttractionImg.setImageResource(curr.getImage());
        holder.nameText.setText(curr.getName());
        holder.rankText.setText(Integer.toString(curr.getRank()));
        holder.ratingText.setText(curr.getRatingString());
        holder.costText.setText(curr.getCost());
        holder.attractionText.setText(curr.getAttraction());
        holder.locationText.setText(curr.getLocation());

        Log.d("TAG", "onBindViewHolder: #5");
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface LaunchListener {
        void launch(int position);
    }
}

