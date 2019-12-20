package com.example.y.aidl_demo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AIDLService extends Service {
    private IBinder binder = new PersonQueryBinder();
    private String[] names = {"语文","数学","外语","物理","化学","生物"};

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private String query(int num){
        if (num > 0 && num < 6) {
            return names[num -1];
        }
        return null;
    }

    private final class PersonQueryBinder extends IPerson.Stub{

        @Override
        public String queryPerson(int num) {
            return query(num);
        }
    }
}
