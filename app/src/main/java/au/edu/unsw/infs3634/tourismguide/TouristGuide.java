package au.edu.unsw.infs3634.tourismguide;

import java.util.ArrayList;

public class TouristGuide {
    private String name;
    private int rank;
    private double rating;
    private String cost;
    private String attraction;
    private String location;
    private String review;
    private int image;

public TouristGuide() {
    }

    public TouristGuide(String name, int rank, double rating, String cost, String attraction, String location, String review, int image) {
        this.name = name;
        this.rank = rank;
        this.rating = rating;
        this.cost = cost;
        this.attraction = attraction;
        this.location = location;
        this.review = review;
        this.image = image;
    }

    // Populate arrayList of my 10 most favourite tourist attraction sights in Sydney
    public static ArrayList<TouristGuide> getTouristGuides(){
        ArrayList<TouristGuide> touristGuideList = new ArrayList<>();

    touristGuideList.add(new TouristGuide("Sydney Harbour Bridge",1,5,"$$$","Landmarks","Sydney","Located in the heart of Sydney, the Sydney Harbour Bridge is a sight to behold, whether it be walking across the bridge or over it on a tour! Worth a visit and many photos!", R.drawable.sydneyharbourbridge));
    touristGuideList.add(new TouristGuide("Sydney Opera House",2,5,"$$","Landmarks","Sydney","The Sydney Opera House is a ‘must see’ attraction in Australia, and it will fully live up to your expectations! The views of it from both land and sea are great from all angles and is worth a detour!", R.drawable.sydneyoperahouse));
    touristGuideList.add(new TouristGuide("Royal Botanic Garden",3,5,"$", "Gardens","Sydney","Being in the heart of the City, we enjoyed every experience we had - the walks, the birds, the flowers, the museum, the gardeners - all wonderful!", R.drawable.royalbotanicgardenssydney));
    touristGuideList.add(new TouristGuide("Hyde Park",4,4.5,"$","Recreational Parks","Town Hall","Hyde Park is great anytime of the year for walks, picnics, skating or just for a 10 minutes break from the busy city! I highly recommend this park to everyone who wants to have a break!", R.drawable.hydepark));
    touristGuideList.add(new TouristGuide("Chinese Garden Of Friendship", 5, 4.5, "$", "Gardens", "Darling Harbour", "Chinese Garden of Friendship is so peaceful - it is so unique and relaxing to walk around - it is amazing that in a busy city like Sydney you can escape for a while into the tranquil surroundings of China!", R.drawable.chinesegardenoffriendship));
    touristGuideList.add(new TouristGuide("Bondi Beach",6,4.5,"$$","Beaches","Bondi","Bondi Beach is a great place for the sun, sand and sea! Other than the beach, there are lots of restaurants and shops in the area! A great place to rest and relax!", R.drawable.bondibeach));
    touristGuideList.add(new TouristGuide("Sydney Tower Eye",7,4,"$$","Observation Towers","Sydney CBD","If you want a 360 degree view of Sydney, Sydney Tower Eye is the place! A great bird's eye view and food options for everyone to enjoy!",R.drawable.sydneytowereye));
    touristGuideList.add(new TouristGuide("Luna Park",8,4,"$$","Theme Parks","Milsons Point","Luna Park is a comfortable place to enjoy some time, with funfair rides, food and drink available and great views across the water to the city and its iconic landmarks!",R.drawable.lunapark));
    touristGuideList.add(new TouristGuide("Centennial Park",9,4,"$", "Recreational Parks","Randwick","Centennial Park has something for everyone - tons of activities for children, horse riding, cycling, running, dog walking, sport, moonlight cinema, concerts or picnicking!", R.drawable.centennialpark));
    touristGuideList.add(new TouristGuide("Taronga Zoo",10,3.5,"$$","Zoos","Mosman","Of all the different zoos I've seen so far,  Taronga Zoo has got to be one of the greatest zoo in the world: incredibly inventive enclosures, fascinating rare species, friendly staff and the Sky Safari, a cable car that lets you have a wonderful view from above!", R.drawable.tarongazoo));

    return touristGuideList;
    }

    //Returns a tourist guide attraction based on rank
    public static TouristGuide touristGuideSearch(int rank){
        ArrayList<TouristGuide> touristGuideList = getTouristGuides();
        TouristGuide myTouristGuideList = null;

        if (rank == 1){
            myTouristGuideList = touristGuideList.get(0);
        } else if (rank == 2){
            myTouristGuideList = touristGuideList.get(1);
        } else if (rank == 3){
            myTouristGuideList = touristGuideList.get(2);
        } else if (rank == 4){
            myTouristGuideList = touristGuideList.get(3);
        } else if (rank == 5){
            myTouristGuideList = touristGuideList.get(4);
        } else if (rank == 6){
            myTouristGuideList = touristGuideList.get(5);
        } else if (rank == 7){
            myTouristGuideList = touristGuideList.get(6);
        } else if (rank == 8){
            myTouristGuideList = touristGuideList.get(7);
        } else if (rank == 9){
            myTouristGuideList = touristGuideList.get(8);
        } else if (rank == 10){
            myTouristGuideList = touristGuideList.get(9);
        }
        return myTouristGuideList;
    }

    public String getRatingString(){
        String ratingString = Double.toString(rating);
        if (rating % 1 == 0) {
            // rating is a whole int
            int ratingInt = (int) rating;
            ratingString = Integer.toString(ratingInt);
        }
        return ratingString;
    }

    // Getter and setter methods for all tourist guide specifications
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getAttraction() {
        return attraction;
    }

    public void setAttraction(String attraction) {
        this.attraction = attraction;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

