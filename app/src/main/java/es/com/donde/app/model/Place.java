package es.com.donde.app.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by santiago on 6/3/14.
 */
public class Place extends Votable {
        String address;
        float latitude;
        float longitude;

        private static List<Place> places = new ArrayList<Place>();

        public static Place notSpecified () { return Place.resolve("No especificado"); }
        public static Place resolve (String address) {
            for (Place place : places){
                if (place.address.equalsIgnoreCase(address)) return place;
            }
            Place place = new Place();
            place.address = address;
            places.add(place);
            return place;
        }

    public String getAddress() {
        return address;
    }
}
