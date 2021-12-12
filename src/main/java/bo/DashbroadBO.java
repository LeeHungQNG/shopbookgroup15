package bo;

import java.util.ArrayList;
import java.util.List;

import dao.DashboardDAO;
import model.Bills;

public class DashbroadBO {
	DashboardDAO dao = new DashboardDAO();
			public List<Bills> getDashboard(String tungay, String denngay) {
				return dao.getDashboard(tungay, denngay);
			}

}
