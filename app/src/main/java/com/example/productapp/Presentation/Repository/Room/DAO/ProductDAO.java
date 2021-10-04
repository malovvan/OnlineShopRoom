package com.example.productapp.Presentation.Repository.Room.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.productapp.Presentation.Repository.Model.ProductDTO;

import java.util.List;

@Dao
public interface ProductDAO {
    @Insert
    void addProduct(ProductDTO Product);

    @Delete
    void deleteProduct(ProductDTO Product);

    @Query("SELECT * FROM Product")
    LiveData<List<ProductDTO>> getAllProducts();
}
