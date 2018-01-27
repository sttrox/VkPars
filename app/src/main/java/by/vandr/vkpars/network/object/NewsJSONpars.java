
package by.vandr.vkpars.network.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsJSONpars {
    //https://vk.com/urbansketcher

    @SerializedName("response")
    @Expose
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
    public int getCount(){
        return response.getItems().size();
    }
}
