package com.example.productapp.Presentation.Repository;

import androidx.lifecycle.LiveData;

import com.example.productapp.Domain.Model.Product;

import java.util.List;

public interface RepositoryTasks {
    <T extends Product> LiveData<List<T>> getAllProducts();
    <T extends Product> void addProduct(T Product);
    <T extends Product> void deleteProduct(T Product);
}
