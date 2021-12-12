
package bo;


import java.util.List;

import dao.CartDAO;
import model.Cart;
import model.Item;
import model.Users;

/**
 * @author MyPC
 *
 */
public class CartBO {
	// 
	CartDAO dao = new CartDAO();

	public Cart getCart(long id) {
		// TODO Auto-generated method stub
		return dao.getCart(id);
	}

	public boolean updateItem(Item item) {
		return dao.updateItem(item);
		
	}

	public Cart addItem(Item item) {
		return dao.addItem(item);
		
	}

	public Cart addCart(Cart cart) {
		return dao.addCart(cart);
		
	}

	public List<Item> getListItem(long id) {
		// TODO Auto-generated method stub
		return dao.getListItem(id);
	}
	//dùng để lấy cart của tk
	public Cart getCartByIDU(long id) {
		// TODO Auto-generated method stub
		return dao.getCartByIDU(id);
	}

	public boolean deleteCart(long id) {
		return dao.deleteCart(id);
		// TODO Auto-generated method stub
		
	}

	public boolean updateCart(Cart cart) {
		return dao.updateCart(cart);
		// TODO Auto-generated method stub
		
	}

	public boolean deleteProductByIDCart(long idSP, long id) {
		return dao.deleteProductByIDCart(idSP,id);
		
	}

	public boolean updateCartByIDCart(long cartid, long idSP, int amount) {
		return dao.updateCartByIDCart(cartid, idSP,amount);
		// TODO Auto-generated method stub
		
	}

	public int getListItemByID(long id, long idSP) {
		// TODO Auto-generated method stub
		return dao.getListItemByID(id, idSP).get(0).getQuantity();
	}

}
