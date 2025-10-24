package com.vendor.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vendor.demo.model.CloudVendor;

@Repository

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {
  
}
