package edu.fau.group10.physicaltherapy_android.data.remote;

import android.content.Context;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import edu.fau.group10.physicaltherapy_android.BuildConfig;
import edu.fau.group10.physicaltherapy_android.data.model.ApiExercises;
import edu.fau.group10.physicaltherapy_android.data.model.ApiProvider;
import edu.fau.group10.physicaltherapy_android.data.model.ApiSets;
import edu.fau.group10.physicaltherapy_android.data.model.ApiUser;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by felipe on 4/25/2016.
 */
public class API {

    //String BASE_URL = "http://10.0.2.2:5000/";
    //String BASE_URL = "http://162.252.122.230:3010/api/";
    String BASE_URL = "http://192.168.5.10:3000/api/";

    // TODO: 4/26/2016 figure out why this code is complaining about empty method, REST Tutorial does not complain about code

    @GET("ApiUser")
    public static Call<List<ApiUser>> getUsers() {
        return null;
    }

    @GET("ApiExercises")
    public static Call<List<ApiExercises>> getExercises(List<Integer> exercise_ids) {
        return null;
    }

    // TODO: 4/26/2016 Create sets model from JSON output, also provider company and @POST for log 
    @GET("set")
    public static Call<ApiSets> getSet() {
        return null;
    }

    @GET("provider")
    public static Call<ApiProvider> getProvider() {
        return null;
    }

    @FormUrlEncoded
    @POST("logs")
    public Call<Object> createLogEntry(@Field("vista_id") String vista_id, @Field("exercise_id") String exercise_id, @Field("date_time") String date_time, @Field("elapsed_time") String elapsed_time) {
        return null;
    }

    @GET("user?firstName={firstName}")
    public Call<ApiUser> getUser(@Path("firstName") String firstName) {
        return null;
    }

    @DELETE("user?firstName={firstName}")
    Call<Object> deleteUser(@Path("firstName") String firstName) {
        return null;
    }

    /*@FormUrlEncoded @POST("user") Call<Object> createUser(@Field("email") String email, @Field("firstName") String name);*/

    public class Factory {
        private API service;

        public static API getInstance(Context context) {
            if (service == null) {

                OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
                builder.readTimeout(15, TimeUnit.SECONDS);
                builder.connectTimeout(10, TimeUnit.SECONDS);
                builder.writeTimeout(10, TimeUnit.SECONDS);

                //builder.certificatePinner(new CertificatePinner.Builder().add("*.androidadvance.com", "sha256/RqzElicVPA6LkKm9HblOvNOUqWmD+4zNXcRb+WjcaAE=")
                //    .add("*.xxxxxx.com", "sha256/8Rw90Ej3Ttt8RRkrg+WYDS9n7IS03bk5bjP/UXPtaY8=")
                //    .add("*.xxxxxxx.com", "sha256/Ko8tivDrEjiY90yGasP6ZpBU4jwXvHqV`QI0GS3GNdA=")
                //    .add("*.xxxxxxx.com", "sha256/VjLZe/p3W/PJnd6lL8JVNBCGQBZynFLdZSTIqcO0SJ8=")
                //    .build());

                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    builder.addInterceptor(interceptor);
                }

                int cacheSize = 10 * 1024 * 1024; // 10 MiB
                Cache cache = new Cache(context.getCacheDir(), cacheSize);
                builder.cache(cache);

                Retrofit retrofit = new Retrofit.Builder().client(builder.build()).addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build();
                service = retrofit.create(API.class);
                return service;
            } else {
                return service;
            }
        }
    }

}
