package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.IVendorContact;
import com.ust.model.VendorContact;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class VendorContactController {
	@Autowired
	IVendorContact dao;
	@RequestMapping(value = "/vendordetails",method = RequestMethod.GET)
	public List getAllVendorContactDetails(){
		List list;
		list = dao.getAllDetails();
		return list;
	}
	@RequestMapping(value="/insertvendorcontact",method=RequestMethod.POST)
	public void insertVendorContactDetails(@RequestBody VendorContact vc){
		dao.insertVendorContactDetails(vc);
		}
	
	@RequestMapping(value = "/disablevendor/{id}", method = RequestMethod.PUT)
	void disableVendor(@PathVariable("id") int vId){
		
		dao.disableVendor(vId);
	}
	
	@RequestMapping(value = "/updatevendor/{id}", method = RequestMethod.PUT)
	public void updateVendorContactDetails(@RequestBody VendorContact vc){
		
		dao.updateVendorDetails(vc);
	}	
	
	@RequestMapping(value = "/vendorbyid/{vId}", method = RequestMethod.GET)
	public VendorContact getStaffById(@PathVariable("vId") int vId) {
		VendorContact vendorContact =dao.getVendorById(vId);
		return vendorContact;
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/vendordetails/{searchString}", method = RequestMethod.GET)
	public List getVendorDetails( @PathVariable("searchString") String searchString) {
		List list;
		if (searchString.equals("null")) {
			list = dao.getAllDetails();
		} else {
			list = dao.searchVendorDetails(searchString);
		}
		return list;
	}

}
