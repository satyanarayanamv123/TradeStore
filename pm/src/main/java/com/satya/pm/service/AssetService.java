package com.satya.pm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satya.pm.exception.AssetDoesNotExistException;
import com.satya.pm.exception.AssetUpdateException;
import com.satya.pm.repository.AssetRepository;
import com.satya.pm.repository.model.Asset;

@Service
public class AssetService {
	
	@Autowired
	public AssetRepository assetRepository;
	
	public List<Asset>  getAssets() {
		return assetRepository.findAll();
	}
	
	public void saveAsset(Asset asset) throws AssetUpdateException  {
		assetRepository.save(asset);
	}
	
	public void updateAsset(Asset asset) throws AssetDoesNotExistException, AssetUpdateException {
		Optional<Asset> assetItem= assetRepository.findById(asset.getId());
		if(assetItem.isPresent()) {
			Asset dbAssetItem = assetItem.get();
			dbAssetItem.setName(asset.getName());
			dbAssetItem.setEstimatedValue(asset.getEstimatedValue());
			dbAssetItem.setSellingPrice(asset.getSellingPrice());
			dbAssetItem.setType(asset.getType());
			assetRepository.save(asset);
		} else {
			throw new AssetDoesNotExistException("User does not exist");
		}		
		
	}
}
