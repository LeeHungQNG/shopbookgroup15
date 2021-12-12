/**
*Project name: ShopBanHang
*Version : 1.0
*Created date : 14 thg 3, 2019
*Description: Create by MyPC
*Copyright (c) 2019 by TeddyShoes. All rights reserved.
*/
package bo;

import java.util.ArrayList;
import java.util.List;

import dao.AddressDAO;
import model.District;
import model.Province;
import model.Village;
import model.Ward;

/**
 * @author MyPC
 *
 */
public class AddressBO {
	//
	AddressDAO dao = new AddressDAO();

	public List<Province> getListProvince(){
		return  dao.getProvince();
	}
	public List<District> getDistrictById(String idp) {
		return dao.getListDistrictById(idp);
	}
	public List<Ward> getWardById(String idd){
		return  dao.getWardById(idd);
	}
	public List<Village> getListVillageByid(String idw){
		return  dao.getListVillageById(idw);
	}
	public Province getProvinceByID(String tp) {
		// TODO Auto-generated method stub
		return dao.getProvinceByID(tp);
	}
	public District getDistrict(String qh) {
		// TODO Auto-generated method stub
		return dao.getDistrictByID(qh);
	}
	public Ward getWardByID(String idw) {
		return dao.getWardByID(idw);
		
	}

}
