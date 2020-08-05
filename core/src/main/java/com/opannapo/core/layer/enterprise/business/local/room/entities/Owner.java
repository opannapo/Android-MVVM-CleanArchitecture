package com.opannapo.core.layer.enterprise.business.local.room.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by napouser on 05,August,2020
 */
@Entity(tableName = "owner")
public class Owner {
    @PrimaryKey(autoGenerate = true)
    int id;
    String email;
    String firstName;
    String lastName;

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
