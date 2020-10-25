package au.edu.unsw.infs3634.tourismguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TouristGuideAdapter.LaunchListener, AdapterView.OnItemSelectedListener {

    private RecyclerView myRecyclerView;
    private TouristGuideAdapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;
    private ArrayList<TouristGuide> currList;
    private boolean isDualPane = false;

    public static final String KEY = "ActivityMain";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check dualplane mode
        ConstraintLayout fragmentContainer = findViewById(R.id.fragmentContainer);
        if (fragmentContainer != null && fragmentContainer.getVisibility() == View.VISIBLE) {
            isDualPane = true;
        }

        //Set up custom toolbar
        Toolbar myToolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);

        //Set up spinner dropdown
        Spinner filterSpinner = findViewById(R.id.filterSpinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(
                this, R.array.attraction, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        filterSpinner.setAdapter(arrayAdapter);
        filterSpinner.setOnItemSelectedListener(this);

        //Create recyclerView
        myRecyclerView = findViewById(R.id.myRecyclerView);
        myRecyclerView.setHasFixedSize(true);

        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);

        Log.d("TAG", "onCreate: #1");

        //Create adapter
        ArrayList<TouristGuide> touristGuides = TouristGuide.getTouristGuides();
        currList = touristGuides;
        myAdapter = new TouristGuideAdapter(touristGuides, this);
        myRecyclerView.setAdapter(myAdapter);

        Log.d("TAG", "onCreate: #2");
    }

    @Override
    // Check launch for screens
    public void launch(int position) {
        int rank = getRank(position);
        if (isDualPane == false){
            launchActivity(rank);
        } else {
            attachDetailFragment(rank);
        }
    }

    // Launch details in new activity
    private void launchActivity(int rank){
        Intent launchIntent = new Intent(this, DetailActivity.class);
        launchIntent.putExtra(KEY, rank);
        startActivity(launchIntent);
    }

    //Binds detailFragment to scrollView in MainActivity (tablets)
    private void attachDetailFragment(int rank) {
        DetailFragment fragment = new DetailFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment == null) {
            transaction.add(R.id.fragmentContainer, fragment);
        } else {
            transaction.replace(R.id.fragmentContainer, fragment);
        }
        transaction.commit();

        // Send rank info as a bundle to fragment
        Bundle rankBundle = new Bundle();
        rankBundle.putInt(KEY, rank);
        fragment.setArguments(rankBundle);
    }

    private int getRank(int position){
        //Get rank based on each Tourist Attraction in the currList
        int rank = currList.get(position).getRank();
        return rank;
    }


    // Methods to handle spinner drop down list action
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selected = parent.getItemAtPosition(position).toString();
        resetRecycler(getFilteredList(selected));
        Log.d("TAG", "onItemSelected: #6");

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    // Rebuild recyclerView to show filtered items
    private void resetRecycler(ArrayList<TouristGuide> filteredList){
        myAdapter = new TouristGuideAdapter(filteredList, this);
        myRecyclerView.setAdapter(myAdapter);
        Log.d("TAG", "resetRecycler: #7");
    }

    // Return filtered arraylist to use as customised dataset
    private ArrayList<TouristGuide> getFilteredList(String attraction) {
        ArrayList<TouristGuide> filteredList = new ArrayList<>();
        ArrayList<TouristGuide> defaultList = TouristGuide.getTouristGuides();

        for (int i = 0; i < defaultList.size(); i++) {
            TouristGuide currDefault = defaultList.get(i);

            //Add tourist attractions to new filtered list if it contains the specified attraction
            if (currDefault.getAttraction().contains(attraction) || attraction.equals("All")) {
                filteredList.add(currDefault);
            }
        }

        currList = filteredList;
        return filteredList;
    }
}
