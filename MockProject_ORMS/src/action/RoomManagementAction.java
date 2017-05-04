/**
 * 
 */
package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.RoomManagementForm;
import model.bean.Room;
import model.bo.RoomBO;
import model.dao.RoomDAO;

/**
 * @author HCD-Fresher204
 *
 */
public class RoomManagementAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		RoomManagementForm roomManagementForm = (RoomManagementForm) form;
		
		int page = 1;
		int recordsPerPage = 5;
		int noOfRecords=0;
		int noOfPages=0;
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
			System.out.println("page get = "+page);
		}
		ArrayList<Integer> listPage = new ArrayList<Integer>();
		ArrayList<Room> listRoom = null;
		RoomBO roomBO = new RoomBO();
		//listRoom = roomBO.getListRoom();
		listRoom = roomBO.getListRoom((page-1)*recordsPerPage,
				 recordsPerPage*page);
		
		noOfRecords = RoomDAO.getNoOfRecords();
		noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		for(int i=1;i<=noOfPages;i++){
			listPage.add(i);
		}
		
		try {
			roomManagementForm.setListRoom(listRoom);
			roomManagementForm.setListPage(listPage);
			roomManagementForm.setCurrentPage(page);
			roomManagementForm.setNoOfPages(noOfPages);
		} catch (NullPointerException npe) {
			System.out.println("Exception in "+ npe);
		}
		return mapping.findForward("dsRoom");
	}
}
