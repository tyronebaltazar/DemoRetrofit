package com.example.tyron.demoretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<pageResponse> call = ReqResApiAdapter.getApiService().getUserPage("2");
        call.enqueue(new PageResponseCallback());
    }

    class PageResponseCallback implements Callback<pageResponse> {
        @Override
        public void onResponse(Call<pageResponse> call, Response<pageResponse> response) {
            if (response.isSuccessful()) {
                pageResponse pageResponse = response.body();
                for (dataPages data : pageResponse.getData()) {
                    System.out.println("Sysout------ Id:" + data.getId());
                    System.out.println("Sysout------ FirstName:" + data.getFirst_name());
                    System.out.println("Sysout----------");

                }
            }
        }

        @Override
        public void onFailure(Call<pageResponse> call, Throwable t) {
            Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
