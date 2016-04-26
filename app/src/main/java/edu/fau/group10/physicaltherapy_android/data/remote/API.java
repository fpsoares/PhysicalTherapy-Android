package edu.fau.group10.physicaltherapy_android.data.remote;

import android.content.Context;
import java.util.List;
import java.util.concurrent.TimeUnit;
import edu.fau.group10.physicaltherapy_android.BuildConfig;
import edu.fau.group10.physicaltherapy_android.Exercise.ExerciseContent;
import edu.fau.group10.physicaltherapy_android.data.model.ApiExercises;
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
    String BASE_URL = "http://162.252.122.230:3010/api/";

    @GET("ApiUser") Call<List<ApiUser>> getUsers();

    @GET("ApiExercises") Call<List<ApiExercises>> getExercises();

    @GET("sets") Call<List<ApiExercises>> getExercises();

    @GET("user?firstName={firstName}") Call<User> getUser(@Path("firstName") String firstName);

    @DELETE("user?firstName={firstName}") Call<Object> deleteUser(@Path("firstName") String firstName);

    @FormUrlEncoded @POST("user") Call<Object> createUser(@Field("email") String email, @Field("firstName") String name);

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
