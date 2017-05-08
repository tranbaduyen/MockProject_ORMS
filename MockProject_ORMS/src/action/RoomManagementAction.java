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
import model.dao.DataAccess;

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
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		RoomManagementForm roomManagementForm = (RoomManagementForm) form;
		DataAccess da;
		da = new DataAccess();
		if(da.getConnect()==null){
			return mapping.findForward("error");
		}
		else{
			int page = 1;
			int recordsPerPage = 10;
			int noOfRecords = 0;
			int noOfPages = 0;
			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			ArrayList<Integer> listPage;
			listPage = new ArrayList<Integer>();
			ArrayList<Room> listRoom = null;
			RoomBO roomBO;
			roomBO = new RoomBO();
			listRoom = roomBO.getListRoom((page - 1) * recordsPerPage, recordsPerPage * page);
	
			noOfRecords = roomBO.getNoOfRecords();
			System.out.println(noOfRecords);
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			for (int i = 1; i <= noOfPages; i++) {
				listPage.add(i);
			}
	
			try {
				roomManagementForm.setListRoom(listRoom);
				roomManagementForm.setListPage(listPage);
				roomManagementForm.setCurrentPage(page);
				roomManagementForm.setNoOfPages(noOfPages);
			}
			catch (NullPointerException npe) {;}
			
			return mapping.findForward("dsRoom");
		}
	}
}
