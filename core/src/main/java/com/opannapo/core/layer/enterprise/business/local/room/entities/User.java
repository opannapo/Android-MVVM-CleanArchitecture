package com.opannapo.core.layer.enterprise.business.local.room.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by napouser on 05,August,2020
 */
@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    int id;
    String email;
    String first_name;
    String last_name;
    String avatar;
}
