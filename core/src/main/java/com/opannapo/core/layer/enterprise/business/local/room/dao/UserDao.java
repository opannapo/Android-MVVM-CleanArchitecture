package com.opannapo.core.layer.enterprise.business.local.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.opannapo.core.layer.enterprise.business.local.room.entities.User;

import java.util.List;

/**
 * Created by napouser on 05,August,2020
 */
@Dao
public interface UserDao {
    @Query("SELECT * FROM USER ORDER BY ID")
    List<User> findAll();

    @Insert
    void insertOne(User user);

    @Update
    void updateOne(User user);

    @Delete
    void deleteOne(User user);

    @Query("SELECT * FROM USER WHERE id = :id")
    User loadPersonById(int id);
}
