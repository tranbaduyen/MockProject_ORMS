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

/**
 * RoomManagementAction.java
 *
 * Version 1.0
 *
 * Date: 03-05-2017
 *
 * Copyright
 *
 * Modification Logs: 
 * DATE 			AUTHOR 		DESCRIPTION
 * -----------------------------------------------------------------------
 * 03-05-2017 		DuyenTB 	Create
 */
public class RoomManagementAction extends Action {
	
	/**
	 * Method execute action
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return mapping.findForward()
	 * @throws Exception
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		RoomManagementForm roomManagementForm = (RoomManagementForm) form;
		int currentPage = 1;
		int recordsPerPage = 10;
		int noOfRecords = 0;
		int noOfPages = 0;
		int indexStart = 0;
		int indexEnd = 0;
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		ArrayList<Integer> listPage;
		listPage = new ArrayList<Integer>();
		ArrayList<Room> listRoom = null;
		RoomBO roomBO;
		roomBO = new RoomBO();
		try{
			indexStart = (currentPage - 1) * recordsPerPage;
			indexEnd = recordsPerPage * currentPage;
			listRoom = roomBO.getListRoom(indexStart, indexEnd);
			noOfRecords = roomBO.getNoOfRecords();
		}
		catch (Exception e) {
			
			//Exeption throw -> redirect to Error page
			return mapping.findForward("error");
		}
		noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		for (int i = 1; i <= noOfPages; i++) {
			listPage.add(i);
		}

		try {
			roomManagementForm.setListRoom(listRoom);
			roomManagementForm.setListPage(listPage);
			roomManagementForm.setCurrentPage(currentPage);
			roomManagementForm.setNoOfPages(noOfPages);
		} catch (NullPointerException npe) {
			
			//Exeption throw -> redirect to Error page
			return mapping.findForward("error");
		}

		return mapping.findForward("dsRoom");
	}

}
