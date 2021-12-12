/**
*Project name: ShopBanHang
*Version : 1.0
*Created date : 12 thg 3, 2019
*Description: Create by MyPC
*Copyright (c) 2019 by TeddyShoes. All rights reserved.
*/
package bo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import dao.UsersDAO;
import model.Users;

/**
 * @author MyPC
 *
 */
public class UsersBO {
	UsersDAO s = new UsersDAO();

	public Users checkLogin(String un, String pass) {
		return s.checkLogin(un, pass);
	}

	public boolean addAccount(Users user) throws Exception {
		return s.addAccount(user);
	}

	public boolean checkAccount(String userName, String email) {
		return false;
	}

	public boolean UpdateAccount(Users user) {
		return s.updateUser(user);
	}

	public List<Users> getListUsers() {
		return s.getListUsers();
	}

	public boolean deleteUser(long id) {
		return s.deleteUser(id);
	}

	public Users getUsersById(long id) {
		return s.getUsersById(id);
	}

	public boolean UpdatePass(String matkhau, long id) throws Exception {
		return s.editPasswordAccount(matkhau, id);
	}

	public Users getUsersByName(String name) {
		return s.getUsersByName(name);
	}

}
