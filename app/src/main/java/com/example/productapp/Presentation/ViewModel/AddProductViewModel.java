package com.example.productapp.Presentation.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.productapp.Domain.Model.Person;
import com.example.productapp.Presentation.Repository.Model.ProductDTO;
import com.example.productapp.Presentation.Repository.Repository;

import java.time.LocalDateTime;

public class AddProductViewModel extends ViewModel {
    public void AddProduct(
            String name,
                         String price
                         ){
        int MaxPeopleCount = 0;
        if (!price.isEmpty()) {
            MaxPeopleCount = Integer.parseInt(price);
        }
        ProductDTO Product = new ProductDTO();
        Product.setName(name);
        Product.setPrice(MaxPeopleCount);

        Repository.getRepository().addProduct(Product);
    }
}