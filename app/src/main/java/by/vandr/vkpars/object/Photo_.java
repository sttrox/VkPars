
package by.vandr.vkpars.object;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import by.vandr.vkpars.object.Size;

public class Photo_ {

    @SerializedName("sizes")
    @Expose
    private List<Size> sizes = null;

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

}
