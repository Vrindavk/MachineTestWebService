package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.VendorContact;

public class VendorContactDao implements IVendorContact {
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
	this.template = template;
	}

	@Override
	public int insertVendorContactDetails(VendorContact vendorContact) {
		// TODO Auto-generated method stub
		String sqlOne="insert into vendor(vName,vAdd,vLoc,vService, "
				+ "Vpin,isActive) values('"+
				vendorContact.getvName()+"','"+
				vendorContact.getvAdd()+"','"+
				vendorContact.getvLoc()+"','"+
				vendorContact.getvService()+"',"+
				vendorContact.getvPin()+",'Y') ";
		template.update(sqlOne);
		
		//get maximum of vendor id from vendor table
		Integer maxVId=getMaxOfVendorId();
		System.out.println(maxVId);
		
		//inserting into contact details table
		String sqlTwo="insert into contact(cName,Cdep,email,phone,cvId) "
				+ "values('"+vendorContact.getcName()+"','"+
				vendorContact.getcDep()+"','"+
				vendorContact.getEmail()+"','"+
				vendorContact.getPhone()+"',? )";
		return template.update(sqlTwo,new Object[] {maxVId});		
	}
	private Integer getMaxOfVendorId() {
		
		String sql = "select MAX(vId)from vendor";
		Integer seq = template.queryForObject(sql, new Object[] {}, Integer.class);
		return seq;
	}
	

	@Override
	public List<VendorContact> getAllDetails() {
		// TODO Auto-generated method stub
		return template.query(
				"select v.vId,v.vName,v.vAdd,v.vLoc,v.vService,v.vpin,c.cName,c.cDep,c.Email,c.phone from Vendor v join Contact c"
				+ " on(v.vId=c.cVId) where v.isActive='Y' order by v.vId desc",
				new RowMapper<VendorContact>() {
				public VendorContact mapRow(ResultSet rs, int row) throws SQLException {
				VendorContact vendorContactPerson = new VendorContact();
				vendorContactPerson.setvId(rs.getInt(1));
				vendorContactPerson.setvName(rs.getString(2));
				vendorContactPerson.setvAdd(rs.getString(3));
			    vendorContactPerson.setvLoc(rs.getString(4));
				vendorContactPerson.setvService(rs.getString(5));
				vendorContactPerson.setvPin(rs.getDouble(6));
				vendorContactPerson.setcName(rs.getString(7));
				vendorContactPerson.setcDep(rs.getString(8));
				vendorContactPerson.setEmail(rs.getString(9));
			    vendorContactPerson.setPhone(rs.getString(10));
				return vendorContactPerson;
				}
				});
				}
	

	@Override
	public int disableVendor(int vId) {
		// TODO Auto-generated method stub
		String sql = "update vendor set isActive='N' where vId=?";
		return template.update(sql, new Object[] { vId });
	}

	@Override
	public int updateVendorDetails(VendorContact vendorContact) {
		// TODO Auto-generated method stub
		String sqlOne="update vendor set vName='"+vendorContact.getvName()
	      +"',vAdd='"+vendorContact.getvAdd()+"',vLoc='"
	      +vendorContact.getvLoc()+"',vService='"
	      +vendorContact.getvService()+"',vpin="+
	      vendorContact.getvPin()+" where vId=?";
template.update(sqlOne,new Object[] {vendorContact.getvId()});

//to update contact table
String sqlTwo="update contact set cName='"+vendorContact.getcName()
	      +"',cdep='"+vendorContact.getcDep()
	      +"',email='"+vendorContact.getEmail()+"',phone='"
	      +vendorContact.getPhone()+"' where cvId=?";

return template.update(sqlTwo,new Object[] {vendorContact.getvId()});
	}

	

	@Override
	public List<VendorContact> searchVendorDetails(String searchString) {
		// TODO Auto-generated method stub
		return template.query("select v.vid,v.vname,v.vloc,v.vservice,c.cname,"
    			+ "c.cdep,c.phone,v.vadd,c.email,v.isactive,v.vpin from vendor v join contact c"
    			+ " on(v.vid=c.cvid) where v.isactive='Y' and v.vname LIKE '%"+searchString
    			+"%' or v.vloc LIKE '%"+searchString+"%' or v.vservice LIKE '%"+searchString+"%'",
						new RowMapper<VendorContact>() {
							public VendorContact mapRow(ResultSet rs, int row)
									throws SQLException {
								VendorContact  vencon = new VendorContact();
								 vencon.setvId(rs.getInt(1));
								 vencon.setvName(rs.getString(2));
								 vencon.setvLoc(rs.getString(3));
								 vencon.setvService(rs.getString(4));
								 vencon.setcName(rs.getString(5));
								 vencon.setcDep(rs.getString(6));
								 vencon.setPhone(rs.getString(7));
								 vencon.setvAdd(rs.getString(8));
								 vencon.setEmail(rs.getString(9));
								 vencon.setIsActive(rs.getString(10));
								 vencon.setvPin(rs.getDouble(11));
								return  vencon;
							}
						});
	}	

	

	@Override
	public VendorContact getVendorById(int vId) {
		// TODO Auto-generated method stub
		String sql = "select v.vId,v.vName,v.vAdd,v.vLoc,v.vService,v.vPin,c.cName,c.cDep,c.email,c.phone from vendor v join contact c on(v.vId=c.cvId) where v.isActive='Y' and v.vId=?";
		return template.queryForObject(sql, new Object[] {vId},
				new BeanPropertyRowMapper<VendorContact>(VendorContact.class));
	}

}
