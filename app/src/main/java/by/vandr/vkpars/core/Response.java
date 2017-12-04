package by.vandr.vkpars.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.vandr.vkpars.object.Group;
import by.vandr.vkpars.object.Item;
import by.vandr.vkpars.object.Profile;

public class Response {

    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("profiles")
    @Expose
    private List<Profile> profiles = null;
    @SerializedName("groups")
    @Expose
    private List<Group> groups = null;
    @SerializedName("next_from")
    @Expose
    private String nextFrom;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Group getRepostGroup(int id) {

        // System.out.println(idTemp +" **0");
        int idTemp = 0;
        for (Group group : groups) {
            if (group != null) {
                if (group.getId() == idTemp) {
                    return group;
                }
            }
        }
        return null;
    }

    public Group getGroup(int id) {
        for (Group group : groups) {
            if (group != null) {
                if (-1 * group.getId() == id) {
                    return group;
                }
            }
        }
        return null;
    }

    public Profile getProfile(int id) {
        for (Profile profile : profiles) {
            if (profile.getId() == id) {
                return profile;
            }
        }
        return null;
    }

    public String getNextFrom() {
        return nextFrom;
    }

    public void setNextFrom(String nextFrom) {
        this.nextFrom = nextFrom;
    }

}
