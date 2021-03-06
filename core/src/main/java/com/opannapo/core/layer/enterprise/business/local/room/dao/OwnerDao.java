package com.opannapo.core.layer.enterprise.business.local.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.opannapo.core.layer.application.domain.Owner;

/**
 * Created by napouser on 05,August,2020
 */
@Dao
public interface OwnerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Owner owner);

    @Update
    void update(Owner owner);

    @Query("SELECT * FROM OWNER WHERE id = :id LIMIT 1")
    Owner get(int id);
}
