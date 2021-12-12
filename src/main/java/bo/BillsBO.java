package bo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;

import dao.BillsDAO;
import model.Bills;

public class BillsBO {
	BillsDAO dao = new BillsDAO();

	public double getSumBills() {
		// TODO Auto-generated method stub
		return dao.getSumBills();
	}
	public List<Bills> getTranspost() {
		// TODO Auto-generated method stub
		return dao.getTranspost();
	}
	public List<Bills> getBills() {
		// TODO Auto-generated method stub
		return dao.getBills() ;
	}
	public List<Bills> getListOrder() {
		// TODO Auto-generated method stub
		return dao.getListOrder();
	}
	public List<Bills> getCancelOrder() {
		// TODO Auto-generated method stub
		return dao.getCancelOrder();
	}

	public boolean addBill(Bills bill) {
		return dao.addBills(bill);
		
	}
	public boolean updateStatus(long id,int status) {
		return dao.updateStatus(id,status);
	}

}
