package com.example.productapp.Presentation.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.productapp.Domain.Model.Product;
import com.example.productapp.Presentation.Repository.Repository;

import java.util.List;

public class ProductListViewModel extends ViewModel {

    public LiveData<List<Product>> getProductList() {
        return Repository.getRepository().getAllProducts();
    }

    public void deleteProduct(Product Product) {
        Repository.getRepository().deleteProduct(Product);
    }
}