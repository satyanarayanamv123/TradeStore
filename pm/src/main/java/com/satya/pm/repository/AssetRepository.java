package com.satya.pm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satya.pm.repository.model.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long> {

}
