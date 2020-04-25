package com.satya.pm.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satya.pm.exception.AssetDoesNotExistException;
import com.satya.pm.exception.AssetUpdateException;
import com.satya.pm.repository.model.Asset;
import com.satya.pm.service.AssetService;

@RestController
@RequestMapping(value = "/asset")
public class AssetController {
	
	@Autowired
	private AssetService assetService;

	@GetMapping
	public ResponseEntity<List<Asset>> getAssets() {
		return new ResponseEntity(assetService.getAssets(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<List<Asset>> saveAsset(@RequestBody Asset asset) throws AssetUpdateException {
		assetService.saveAsset(asset);
		return new ResponseEntity(assetService.getAssets(), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Asset> updateAsset(@RequestBody Asset asset) throws AssetDoesNotExistException, AssetUpdateException {
		assetService.saveAsset(asset);
		return new ResponseEntity(assetService.getAssets(), HttpStatus.OK);
	}

}
