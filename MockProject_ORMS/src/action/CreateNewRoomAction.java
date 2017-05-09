/**
 * 
 */
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.ValidateData;
import form.RoomForm;
import model.bo.RoomBO;
import model.dao.DataAccess;

/**
 * CreateNewRoomAction.java
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
public class CreateNewRoomAction extends Action {
	
	/**
	 * Ham execute
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
		RoomBO roomBO;
		roomBO = new RoomBO();
		
		DataAccess da;
		da = new DataAccess();
		if(da.getConnect()==null){
			return mapping.findForward("error");
		}
		else{
			// Validate du lieu
			if ("Save".equals(roomForm.getSubmit())) {
				ActionErrors actionErrors = new ActionErrors();
				if (ValidateData.isEmpty(roomForm.getRoomName())) {
					actionErrors.add("roomNameError", new ActionMessage("error.roomName.trong"));
					roomForm.setErrorFirst(1);
				}
				if (roomBO.isDuplicateRoomName(roomForm.getRoomName())) {
					actionErrors.add("roomNameError", new ActionMessage("error.roomName.trung"));
					roomForm.setErrorFirst(1);
				}
				if (ValidateData.isAllNumber(roomForm.getRoomName())) {
					actionErrors.add("roomNameError", new ActionMessage("error.roomName.so"));
					roomForm.setErrorFirst(1);
				}
				if (ValidateData.isMaxlength50String(roomForm.getRoomName())) {
					actionErrors.add("roomNameError", new ActionMessage("error.roomName.maxlength"));
					roomForm.setErrorFirst(1);
				}
				if(ValidateData.isSpecialCharacters(roomForm.getRoomName())){
					actionErrors.add("roomNameError", new ActionMessage("error.roomName.kituDB"));
					roomForm.setErrorFirst(1);
				}
				
				if (ValidateData.isEmpty(roomForm.getRoomSeats())) {
					actionErrors.add("roomSeatsError", new ActionMessage("error.roomSeats.trong"));
					roomForm.setErrorFirst(2);
				}
				if (!ValidateData.isNumberOnly(roomForm.getRoomSeats())) {
					actionErrors.add("roomSeatsError", new ActionMessage("error.roomSeats.chuoi"));
				}
				if (ValidateData.isNegative(roomForm.getRoomSeats())) {
					actionErrors.add("roomSeatsError", new ActionMessage("error.roomSeats.negative"));
					roomForm.setErrorFirst(2);
				}
				if (ValidateData.isMoreThan500Seats(roomForm.getRoomSeats())) {
					actionErrors.add("roomSeatsError", new ActionMessage("error.roomSeats.more500Seats"));
					roomForm.setErrorFirst(2);
				}
				
				if (ValidateData.isEmpty(roomForm.getDescription())) {
					actionErrors.add("descriptionError", new ActionMessage("error.description.trong"));
					roomForm.setErrorFirst(3);
				}
				if(ValidateData.isSpecialCharacters(roomForm.getDescription())){
					actionErrors.add("descriptionError", new ActionMessage("error.description.kituDB"));
					roomForm.setErrorFirst(3);
				}
	
				if (ValidateData.isEmpty(roomForm.getPriceHour())) {
					actionErrors.add("priceHourError", new ActionMessage("error.priceHour.trong"));
					roomForm.setErrorFirst(4);
				}
				if (!ValidateData.isFloatNumber(roomForm.getPriceHour())) {
					actionErrors.add("priceHourError", new ActionMessage("error.priceHour.chuoi"));
					roomForm.setErrorFirst(4);
				}
				if (ValidateData.isNegative(roomForm.getPriceHour())) {
					actionErrors.add("priceHourError", new ActionMessage("error.priceHour.negative"));
					roomForm.setErrorFirst(4);
				}
				
				if (ValidateData.isEmpty(roomForm.getPriceFull())) {
					actionErrors.add("priceFullError", new ActionMessage("error.priceFull.trong"));
					roomForm.setErrorFirst(5);
				}
				if (!ValidateData.isFloatNumber(roomForm.getPriceFull())) {
					actionErrors.add("priceFullError", new ActionMessage("error.priceFull.chuoi"));
					roomForm.setErrorFirst(5);
				}
				if (ValidateData.isNegative(roomForm.getPriceFull())) {
					actionErrors.add("priceFullError", new ActionMessage("error.priceFull.negative"));
					roomForm.setErrorFirst(5);
				}
				
				saveErrors(request, actionErrors);
				
				if (actionErrors.size() > 0) {
					return mapping.findForward("createError");
				}
			}
			
			// nhan nut Save o trang Create New Room
			if ("Save".equals(roomForm.getSubmit())) { 
				String roomName = roomForm.getRoomName();
				int roomSeats = roomForm.getRoomSeats();
				String description = roomForm.getDescription();
				float priceHour = roomForm.getPriceHour();
				float priceFull = roomForm.getPriceFull();
				int status = 0;
				try {
					roomBO.addRoom(roomName, roomSeats, description, priceHour, priceFull, status);
				}
				catch (Exception e) {
					return mapping.findForward("error");
				}
				return mapping.findForward("createSuccess");
			} else { // chuyen sang trang Create New Room
				roomForm.setErrorFirst(1);
				return mapping.findForward("create");
			}
		}
	}
}
