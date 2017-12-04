
package by.vandr.vkpars.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import by.vandr.vkpars.object.Section;

public class Category {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("section")
    @Expose
    private Section section;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

}
