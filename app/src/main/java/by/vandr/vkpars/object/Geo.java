
package by.vandr.vkpars.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import by.vandr.vkpars.object.Place;

public class Geo {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("coordinates")
    @Expose
    private String coordinates;
    @SerializedName("place")
    @Expose
    private Place place;
    @SerializedName("showmap")
    @Expose
    private int showmap;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public int getShowmap() {
        return showmap;
    }

    public void setShowmap(int showmap) {
        this.showmap = showmap;
    }

}
