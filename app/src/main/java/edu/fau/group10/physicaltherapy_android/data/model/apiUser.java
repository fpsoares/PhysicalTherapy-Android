package edu.fau.group10.physicaltherapy_android.data.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ApiUser {

    @SerializedName("_id")
    @Expose
    public String Id;
    @SerializedName("firstName")
    @Expose
    public String firstName;
    @SerializedName("lastName")
    @Expose
    public String lastName;
    @SerializedName("dob")
    @Expose
    public double dob;
    @SerializedName("phone")
    @Expose
    public String phone;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("password")
    @Expose
    public String password;
    @SerializedName("vista_id")
    @Expose
    public int vistaId;

    @Override
    public String toString() {
        return "ApiUser{" +
                "Id='" + Id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", vistaId=" + vistaId +
                '}';
    }
}
