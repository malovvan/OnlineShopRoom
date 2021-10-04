package com.example.productapp.Presentation.View.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productapp.Domain.Model.Product;
import com.example.Productapp.databinding.ProductListElementBinding;

import org.jetbrains.annotations.NotNull;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {
    private final List<Product> data;

    public ProductListAdapter(List<Product> data) {
        this.data = data;
    }

    @NonNull
    @NotNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ProductListElementBinding binding = ProductListElementBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ProductViewHolder holder, int position) {
        holder.binding.productName.setText(data.get(position).getName());
        holder.binding.productPrice.setText(String.valueOf(data.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public List<Product> getData() {
        return data;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{

        ProductListElementBinding binding;

        public ProductViewHolder(ProductListElementBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
