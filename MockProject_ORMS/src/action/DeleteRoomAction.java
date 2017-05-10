/**
 * 
 */
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.RoomForm;
import model.bo.RoomBO;
import model.dao.DataAccess;

/**
 * DeleteRoomAction.java
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
public class DeleteRoomAction extends Action {
	
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

		RoomForm roomForm = (RoomForm) form;
		RoomBO roomBO ;
		roomBO = new RoomBO();
		DataAccess da;
		da = new DataAccess();
		if(da.getConnect()==null){
			return mapping.findForward("error");
		}
		else{
			int roomID = roomForm.getRoomID();
			roomBO.deleteRoom(roomID);

			return mapping.findForward("deleteSuccess");
		}
	}
}
