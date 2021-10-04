package com.example.productapp.Presentation.Repository.Mock;

import androidx.lifecycle.MutableLiveData;

import com.example.productapp.Domain.Model.Product;
import com.example.productapp.Presentation.Repository.RepositoryTasks;

import java.util.ArrayList;
import java.util.List;

public class MockBase implements RepositoryTasks {
    MutableLiveData<List<Product>> data;
    List<Product> list;

    public MutableLiveData<List<Product>> getAllProducts() {
        return data;
    }

    public MockBase() {
        list = new ArrayList<>();

        Product Product1 = new Product("Куртка",1500);
        list.add(Product1);

        data = new MutableLiveData<>(list);
    }

    public <T extends Product> void addProduct(T Product) {
        list.add(Product);
        data.setValue(list);
    }

    @Override
    public <T extends Product> void deleteProduct(T Product) {
        list.remove(Product);

        data.setValue(list);
    }
}
