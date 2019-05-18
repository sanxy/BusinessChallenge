package com.businesschallenge.ui.lock;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.businesschallenge.DataProccessor;
import com.businesschallenge.R;
import com.businesschallenge.model.Business;
import com.businesschallenge.utils.AppExecutors;
import com.businesschallenge.utils.JsonUtils;
import com.businesschallenge.utils.SingleLiveEvent;
import java.util.ArrayList;
import java.util.List;

public class BusinessListViewModel extends AndroidViewModel {

    private Context mContext;

    private final MutableLiveData<List<Business>> mObservableSandwiches;

    private final SingleLiveEvent<Integer> mOpenBusinessEvent = new SingleLiveEvent<>();

    public BusinessListViewModel(@NonNull Application application) {
        super(application);

        // initialize data
        mContext = application.getApplicationContext();
        AppExecutors mExecutors = AppExecutors.getInstance();
        mObservableSandwiches = new MutableLiveData<>();
        final List<Business> businessList = new ArrayList<>();

        // mObservableSandwiches.setValue(null);
        // parse json array on background thread
        mExecutors.diskIO().execute(() -> {


            String[] sandwiches = mContext.getResources().getStringArray(R.array.business_details);
            for (String sandwiche : sandwiches) {
                Business business = null;
                business = JsonUtils.parseBusinessJson(sandwiche);
                businessList.add(business);
            }

            if (!businessList.isEmpty()) {

                // update business MutableLiveData from background thread
                mObservableSandwiches.postValue(businessList);
            }
        });
    }

    public LiveData<List<Business>> getBusinessList() {
        return mObservableSandwiches;
    }

    public MutableLiveData<Integer> getOpenBusinessEvent() {
        return mOpenBusinessEvent;
    }

}
