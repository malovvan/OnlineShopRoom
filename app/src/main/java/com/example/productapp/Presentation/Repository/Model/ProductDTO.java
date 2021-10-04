package com.example.productapp.Presentation.Repository.Model;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.productapp.Domain.Model.Product;

import org.jetbrains.annotations.NotNull;



@Entity(tableName = "Product")
public class ProductDTO extends Product {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo
    public int id;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }
}
