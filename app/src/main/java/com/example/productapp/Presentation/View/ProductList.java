package com.example.productapp.Presentation.View;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.productapp.Domain.Model.Product;
import com.example.productapp.Presentation.View.Adapters.ProductListAdapter;
import com.example.productapp.Presentation.ViewModel.ProductListViewModel;
import com.example.Productapp.R;
import com.example.Productapp.databinding.ProductListFragmentBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProductList extends Fragment {

    private ProductListViewModel mViewModel;
    private ProductListFragmentBinding mBinding;

    public static ProductList newInstance() {
        return new ProductList();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = ProductListFragmentBinding.inflate(getLayoutInflater(), container, false);

        mBinding.ProductListRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        mBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_ProductList_to_addProduct);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull @NotNull RecyclerView recyclerView, @NonNull @NotNull RecyclerView.ViewHolder viewHolder, @NonNull @NotNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull @NotNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                mViewModel.deleteProduct(((ProductListAdapter) mBinding.ProductListRecycler.getAdapter()).getData().get(position));
            }
        }).attachToRecyclerView(mBinding.ProductListRecycler);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProductListViewModel.class);

        mViewModel.getProductList().observe(getViewLifecycleOwner(), (List<Product> ProductList) -> {
            mBinding.ProductListRecycler.setAdapter(new ProductListAdapter(ProductList));
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBinding = null;
        mViewModel = null;
    }
}