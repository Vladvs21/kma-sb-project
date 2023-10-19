package com.example.financial_manager.components;

import com.example.financial_manager.managers.AssetManager;
import com.example.financial_manager.entities.AssetEntity;
import com.example.financial_manager.repositories.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AssetManagerImpl implements AssetManager {

    @Autowired
    private AssetsRepository assets;
    @Override
    public void addAsset(double price, String name) {
       // assets.save(new AssetEntity(price,name));
    }

    @Override
    public void deleteAsset(Long id) {
        assets.deleteById(id);
    }

    @Override
    public void updateAssetPrice(Long id, double price) {
        try {
            Optional<AssetEntity> asset = assets.findById(id);
            if(asset.isPresent()){
                AssetEntity updatedExpense = asset.get();
                updatedExpense.setAssetPrice(price);
                assets.save(updatedExpense);
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAssetName(Long id, String name) {
        try {
            Optional<AssetEntity> asset = assets.findById(id);
            if(asset.isPresent()){
                AssetEntity updatedExpense = asset.get();
                updatedExpense.setAssetName(name);
                assets.save(updatedExpense);
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<AssetEntity> getAllAssets() {
        return assets.findAll();
    }

    @Override
    public double calculateTotalAssets() {
        return assets.findAll().stream().mapToDouble(AssetEntity::getAssetPrice).sum();
    }
}
