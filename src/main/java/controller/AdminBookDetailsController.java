package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import bo.BookBO;
import bo.BookDetailBO;
import bo.CategoryBO;
import model.BookDetail;
import model.Books;
import model.Category;

/**
 * Servlet implementation class AdminProductDetailsController
 */
@WebServlet("/AdminBookDetailsController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AdminBookDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminBookDetailsController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String idPD = request.getParameter("id");
		long id = Long.parseLong(idPD);
		BookDetailBO productsBO = new BookDetailBO();
		HttpSession session = request.getSession();
		List<BookDetail> listP = productsBO.getListBookDetails(id);
		session.setAttribute("idP", id);
		Gson gson = new GsonBuilder().create();
		JsonArray jarray = gson.toJsonTree(listP).getAsJsonArray();
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("products", jarray);
		request.setAttribute("jsonProductsD", jarray);
		RequestDispatcher rd = request.getRequestDispatcher("admin\\managadetails.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		BookDetailBO dao = new BookDetailBO();
		HttpSession session = request.getSession();
		BookBO dao2 = new BookBO();
		Long id_book = (Long) session.getAttribute("idP"); // lấy idp từ view
		//  dùng load nhiều ảnh từ view lên để kiểm tra xem có ảnh hay không 
		if (ServletFileUpload.isMultipartContent(request)) {
			List<FileItem> formItems = null;
			try {
				// chứa tất cả ảnh vào File iteam 
				formItems = new ServletFileUpload(new DiskFileItemFactory())
						.parseRequest(new ServletRequestContext(request));
			} catch (FileUploadException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// kiểm tra xem formitem có null hay ko để load và lưu ảnh
			if (formItems != null && formItems.size() > 0) {
				for (FileItem item : formItems) {
					if (!item.isFormField()) {
						String appPath = request.getServletContext().getRealPath("");
						appPath = appPath.replace('\\', '/');
						long time= System.currentTimeMillis();
						// lấy đường dẫn file ảnh trong project()
						String fullSavePath = null;
						if (appPath.endsWith("/")) {
							fullSavePath = appPath + "viewroot/img/shop/DetailProduct/";
						} else {
							fullSavePath = appPath + "/" + "viewroot/img/shop/DetailProduct/";
						}
						String fileName = time+ new File(item.getName()).getName();
						File file = new File(fullSavePath, fileName);
						try {
							item.write(file);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						BookDetail bookDetail = new BookDetail();
						bookDetail.setImageLink(fileName);
						bookDetail.setIdBook(id_book);
						dao.addBookDetail(bookDetail);

					}
				}
				// lấy sản phẩm theo id
				Books p = dao2.getBookByID(id_book);
				List<BookDetail> lstPd = dao.getBookDetailByID(id_book);
				request.setAttribute("lstProductDetail", lstPd);
				request.setAttribute("product", p);
				// hiển thị thông tin chi tiết sản phẩm theo id
				String url="AdminBookDetailsController?id="+id_book;
				response.sendRedirect(url);
			}
		}
	}

}
