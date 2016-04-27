package edu.fau.group10.physicaltherapy_android.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.fau.group10.physicaltherapy_android.BaseActivity;
import edu.fau.group10.physicaltherapy_android.R;
import edu.fau.group10.physicaltherapy_android.data.model.ApiUser;
import edu.fau.group10.physicaltherapy_android.data.model.ApiExercises;
import edu.fau.group10.physicaltherapy_android.data.remote.API;
import edu.fau.group10.physicaltherapy_android.utils.DialogFactory;

import java.util.Arrays;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.button_get_all) Button button_get_all;
    @Bind(R.id.button_delete) Button button_delete;
    @Bind(R.id.button_get_one) Button button_get_one;
    @Bind(R.id.button_post) Button button_post;
    @Bind(R.id.editText_email) EditText editText_email;
    @Bind(R.id.editText_name) EditText editText_name;
    @Bind(R.id.editText_record_id) EditText editText_record_id;
    @Bind(R.id.textView_output) TextView textView_output;
    @Bind(R.id.linlayout_main) LinearLayout linlayout_main;

    private MainActivity mContext;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().setElevation(0);
        mContext = MainActivity.this;
    }

    @OnClick(R.id.button_get_all) public void onClick_button_get_all() {

        API exerciseAPI = API.Factory.getInstance(mContext);

        List<Integer> exercise_list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11);

        exerciseAPI.getExercises(exercise_list).enqueue(new Callback<List<ApiExercises>>() {
            @Override public void onResponse(Call<List<ApiExercises>> call, Response<List<ApiExercises>> response) {
                if (response.isSuccessful()) {

                    List<ApiExercises> exercisesList = response.body();
                    textView_output.setText(exercisesList.toString());
                } else {
                    DialogFactory.showErrorSnackBar(mContext, linlayout_main, new Throwable("failed with error code " + response.code()));
                }
            }

            @Override public void onFailure(Call<List<ApiExercises>> call, Throwable t) {
                DialogFactory.showErrorSnackBar(mContext, linlayout_main, t);
            }
        });
    }

    @OnClick(R.id.button_get_one) public void onClick_button_get_one() {

        API exerciseAPI = API.Factory.getInstance(mContext);

/*        exerciseAPI.getExercises(editText_record_id.getText().toString().trim()).enqueue(new Callback<ApiExercises>() {
            @Override public void onResponse(Call<ApiExercises> call, Response<ApiExercises> response) {
                if (response.isSuccessful()) {

                    ApiExercises exercise = response.body();
                    textView_output.setText(exercise.toString());
                } else {
                    DialogFactory.showErrorSnackBar(mContext, linlayout_main, new Throwable("failed with error code " + response.code()));
                }
            }

            @Override public void onFailure(Call<ApiExercises> call, Throwable t) {
                DialogFactory.showErrorSnackBar(mContext, linlayout_main, t);
            }
        });*/
    }

    @OnClick(R.id.button_delete) public void onClick_button_delete() {

        API exerciseAPI = API.Factory.getInstance(mContext);

/*        exerciseAPI.deleteUser(editText_record_id.getText().toString().trim()).enqueue(new Callback<Object>() {
            @Override public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {

                    textView_output.setText("deleted.");
                } else {
                    DialogFactory.showErrorSnackBar(mContext, linlayout_main, new Throwable("failed with error code " + response.code()));
                }
            }

            @Override public void onFailure(Call<Object> call, Throwable t) {
                DialogFactory.showErrorSnackBar(mContext, linlayout_main, t);
            }
        });*/
    }

    @OnClick(R.id.button_post) public void onClick_button_post() {

        API exerciseAPI = API.Factory.getInstance(mContext);

        String email = editText_email.getText().toString().trim();
        String name = editText_name.getText().toString().trim();

/*        exerciseAPI.createUser(email, name).enqueue(new Callback<Object>() {
            @Override public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {
                    textView_output.setText("created!");
                } else {
                    DialogFactory.showErrorSnackBar(mContext, linlayout_main, new Throwable("failed with error code " + response.code()));
                }
            }

            @Override public void onFailure(Call<Object> call, Throwable t) {
                DialogFactory.showErrorSnackBar(mContext, linlayout_main, t);
            }
        });*/
    }
}
