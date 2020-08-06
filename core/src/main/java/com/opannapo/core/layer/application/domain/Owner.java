package com.opannapo.core.layer.application.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * Created by napouser on 05,August,2020
 */
@Entity(tableName = "owner", indices = {@Index(value = "id")})
public class Owner implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    int id;
    String email;
    String firstName;
    String lastName;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.email);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
    }

    public Owner() {
    }

    protected Owner(Parcel in) {
        this.id = in.readInt();
        this.email = in.readString();
        this.firstName = in.readString();
        this.lastName = in.readString();
    }

    public static final Creator<Owner> CREATOR = new Creator<Owner>() {
        @Override
        public Owner createFromParcel(Parcel source) {
            return new Owner(source);
        }

        @Override
        public Owner[] newArray(int size) {
            return new Owner[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
