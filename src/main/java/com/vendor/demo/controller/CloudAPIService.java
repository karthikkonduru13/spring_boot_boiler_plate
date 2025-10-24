package com.vendor.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendor.demo.model.CloudVendor;
import com.vendor.demo.repository.CloudVendorRepository;

@RestController
@RequestMapping("/cloudvendor")

public class CloudAPIService {

    @Autowired
    private CloudVendorRepository cloudVendorRepository;

    // Create Vendor
    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudVendor.setVendorId("c" + System.currentTimeMillis());
        cloudVendorRepository.save(cloudVendor);
        return "cloud vendor created successfully: " + cloudVendor.getVendorId();
    }

    // Get Vendor Details
    @GetMapping("/{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable String vendorId) {
        return cloudVendorRepository.findById(vendorId).orElse(null);
    }

    // Delete Vendor
    @DeleteMapping("/{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable String vendorId) {
        cloudVendorRepository.deleteById(vendorId);
        return "cloud vendor deleted successfully";
    }

  @GetMapping
  public String checkAPIStatus() {
      return "the MicroService API is up and running - om sai ram - v2";
  }

}
