package edu.fau.group10.physicaltherapy_android.data.model;

/**
 * Created by felipe on 4/26/2016.
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ApiExercises {

    @SerializedName("_id")
    @Expose
    public String Id;
    @SerializedName("exercise_id")
    @Expose
    public String exerciseId;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("base_url")
    @Expose
    public String baseUrl;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("Description")
    @Expose
    public String Description;

    @Override
    public String toString() {
        return "ApiExercises{" +
                "Id='" + Id + '\'' +
                ", exerciseId='" + exerciseId + '\'' +
                ", name='" + name + '\'' +
                ", baseUrl='" + baseUrl + '\'' +
                ", url='" + url + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}