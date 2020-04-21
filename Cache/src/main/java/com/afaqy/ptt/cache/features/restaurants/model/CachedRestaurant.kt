package com.afaqy.ptt.cache.features.restaurants.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.afaqy.ptt.cache.features.restaurants.db.RestaurantConstants

@Entity(tableName = RestaurantConstants.TABLE_NAME)
data class CachedRestaurant(
    @PrimaryKey
    @ColumnInfo(name = RestaurantConstants.COLUMN_RESTAURANT_ID)
    val id: Long,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String
)