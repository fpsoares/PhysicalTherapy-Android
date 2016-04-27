package edu.fau.group10.physicaltherapy_android.data.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ApiLogs {

    @SerializedName("vista_id")
    @Expose
    public String vistaId;
    @SerializedName("exercise_id")
    @Expose
    public String exerciseId;
    @SerializedName("date_time")
    @Expose
    public String dateTime;
    @SerializedName("elapsedTime")
    @Expose
    public int elapsedTime;

    @Override
    public String toString() {
        return "ApiLogs{" +
                "vistaId='" + vistaId + '\'' +
                ", exerciseId='" + exerciseId + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", elapsedTime=" + elapsedTime +
                '}';
    }
}
