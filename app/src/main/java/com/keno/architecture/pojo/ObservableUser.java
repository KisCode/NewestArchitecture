package com.keno.architecture.pojo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.keno.architecture.BR;

public class ObservableUser extends BaseObservable {
    private String firstName;
    public String lastName;

    public ObservableUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
//        notifyChange();  //刷新全部变量
        notifyPropertyChanged(BR.firstName);  //刷新指定变量
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);  //刷新指定变量
    }

    @Bindable({"firstName", "lastName"})
    public String getName() {
        return firstName + lastName;
    }
}
