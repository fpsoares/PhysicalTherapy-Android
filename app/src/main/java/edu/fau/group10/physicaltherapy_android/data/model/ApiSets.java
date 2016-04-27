package edu.fau.group10.physicaltherapy_android.data.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ApiSets {

    @SerializedName("_id")
    @Expose
    public String Id;
    @SerializedName("set_id")
    @Expose
    public String setId;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("exercises_id")
    @Expose
    public String exercisesId;

    @Override
    public String toString() {
        return "ApiSets{" +
                "Id='" + Id + '\'' +
                ", setId='" + setId + '\'' +
                ", name='" + name + '\'' +
                ", exercisesId='" + exercisesId + '\'' +
                '}';
    }
}
