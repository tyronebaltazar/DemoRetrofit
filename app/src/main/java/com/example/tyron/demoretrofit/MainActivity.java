package com.example.tyron.demoretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    ReqResApiService myAPI;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = ReqResApiAdapter.getInstance();

        myAPI = retrofit.create(ReqResApiService.class);

        fetchData();
    }

    private void fetchData() {
        myAPI.getUserPage("2")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(pageResponse -> {
                    System.out.println("ASDJKSAKDJAWD: " + pageResponse.getPage());
                });
    }
}
