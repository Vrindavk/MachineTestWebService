package com.ust.dao;

import java.util.List;

import com.ust.model.VendorContact;

public interface IVendorContact {
	public abstract int insertVendorContactDetails(VendorContact vendorContact);

	public abstract List<VendorContact> getAllDetails();

	public abstract int disableVendor(int vId);

	public abstract int updateVendorDetails(VendorContact vendorContact);

	public abstract List<VendorContact> searchVendorDetails(String searchString);

	public abstract VendorContact getVendorById(int vId);

}
