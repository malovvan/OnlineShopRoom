package com.example.productapp.Presentation.Repository.Room;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.productapp.Domain.Model.Product;
import com.example.productapp.Presentation.Repository.Model.ProductDTO;
import com.example.productapp.Presentation.Repository.RepositoryTasks;
import com.example.productapp.Presentation.Repository.Room.DAO.ProductDAO;

import java.util.List;

public class ProductRepository implements RepositoryTasks {
    private ProductDAO mProductDao;
    private LiveData<List<ProductDTO>> mAllProducts = new MutableLiveData<>();

    public ProductRepository(Application application) {
        ProductRoomDatabase db = ProductRoomDatabase.getDatabase(application);
        mProductDao = db.ProductDao();
        mAllProducts = mProductDao.getAllProducts();
    }

    public LiveData<List<ProductDTO>> getAllProducts() {
        return mAllProducts;
    }

    @Override
    public <T extends Product> void addProduct(T Product) {
        ProductRoomDatabase.databaseWriteExecutor.execute(() -> {
            mProductDao.addProduct(((ProductDTO) Product));
        });
    }

    @Override
    public <T extends Product> void deleteProduct(T Product) {
        ProductRoomDatabase.databaseWriteExecutor.execute(() -> {
            mProductDao.deleteProduct(((ProductDTO) Product));
        });
    }
}
