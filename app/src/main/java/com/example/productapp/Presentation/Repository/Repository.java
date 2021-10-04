package com.example.productapp.Presentation.Repository;

import android.app.Application;

import com.example.productapp.Presentation.Repository.Mock.MockBase;
import com.example.productapp.Presentation.Repository.Room.ProductRepository;

public class Repository {
    static RepositoryTasks repository;

    static public void init(Application application) {
        if (repository == null) {
            repository = new ProductRepository(application);
        }
    }

    static public RepositoryTasks getRepository() {
        if (repository == null) {
            repository = new MockBase();
        }
        return repository;
    }
}
