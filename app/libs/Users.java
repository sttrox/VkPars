package by.vandr.vkpars.object;

import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.model.VKApiUserFull;
import com.vk.sdk.api.model.VKUsersArray;

/**
 * Created by V on 13.11.2017.
 */

public class Users {
    VKUsersArray usersArray;
    VKApiUserFull ar;

    public Users(VKUsersArray usersArrays){
        this.usersArray = usersArrays;
    }

    public int getId() {
        return ar.id;
    }

    /*    public void setId(int id) {
        this.id = id;
    }*/

    public String getFirstName() {
        return ar.first_name;
    }

    public void setFirstName(String firstName) {
        ar.first_name= firstName;
    }

    public String getLastName() {
        return ar.last_name;
    }

    /*    public void setLastName(String lastName) {
        this.lastName = lastName;
    }*/

//    public String getDeactivated() {
//        return deactivated;
//    }
//
//    public void setDeactivated(String deactivated) {
//        this.deactivated = deactivated;
//    }
//
//    public String getAbout() {
//        return about;
//    }
//
//    public void setAbout(String about) {
//        this.about = about;
//    }

    String firstName;
    String lastName;
    String deactivated; // содержит значение deleted или banned
    String about;

}
