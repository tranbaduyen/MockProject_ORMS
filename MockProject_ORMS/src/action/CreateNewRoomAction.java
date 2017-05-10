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
		RoomBO roomBO;
		roomBO = new RoomBO();

		// Validate data before submit
		if ("Save".equals(roomForm.getSubmit())) {
			ActionErrors actionErrors = new ActionErrors();
			
			roomForm.setErrorFirst(0);
			
			//check RoomName not input
			if (ValidateData.isEmpty(roomForm.getRoomName())) {
				actionErrors.add("roomNameError", new ActionMessage("error.roomName.trong"));
				roomForm.setErrorFirst(1);
			}
			
			//check RoomName is duplicate in database
			if (roomBO.isDuplicateRoomName(roomForm.getRoomName())) {
				actionErrors.add("roomNameError", new ActionMessage("error.roomName.trung"));
				roomForm.setErrorFirst(1);
			}
			
			//check RoomName input all number
			if (ValidateData.isAllNumber(roomForm.getRoomName())) {
				actionErrors.add("roomNameError", new ActionMessage("error.roomName.so"));
				roomForm.setErrorFirst(1);
			}
			
			//check RoomName input maxlength >50
			if (ValidateData.isMaxlength50String(roomForm.getRoomName())) {
				actionErrors.add("roomNameError", new ActionMessage("error.roomName.maxlength"));
				roomForm.setErrorFirst(1);
			}
			
			//check RoomName use special characters
			if (ValidateData.isSpecialCharacters(roomForm.getRoomName())) {
				actionErrors.add("roomNameError", new ActionMessage("error.roomName.kituDB"));
				roomForm.setErrorFirst(1);
			}
			
			//check RoomSeats not input
			if (ValidateData.isEmpty(roomForm.getRoomSeats())) {
				actionErrors.add("roomSeatsError", new ActionMessage("error.roomSeats.trong"));
				if (roomForm.getErrorFirst() == 0)
					roomForm.setErrorFirst(2);
			}
			
			//check RoomSeats input character different Number type
			if (!ValidateData.isNumberOnly(roomForm.getRoomSeats())) {
				actionErrors.add("roomSeatsError", new ActionMessage("error.roomSeats.chuoi"));
				if (roomForm.getErrorFirst() == 0)
					roomForm.setErrorFirst(2);
			}
			
			//check RoomSeats use special characters
			if (ValidateData.isSpecialCharactersNumber(roomForm.getRoomSeats())) {
				actionErrors.add("roomSeatsError", new ActionMessage("error.roomSeats.kituDB"));
				if (roomForm.getErrorFirst() == 0)
					roomForm.setErrorFirst(2);
			}
			
			//check RoomSeats input negative value
			if (ValidateData.isNegative(roomForm.getRoomSeats())) {
				actionErrors.add("roomSeatsError", new ActionMessage("error.roomSeats.negative"));
				if (roomForm.getErrorFirst() == 0)
					roomForm.setErrorFirst(2);
			}
			
			//check RoomSeats input > 500 seats
			if (ValidateData.isMoreThan500Seats(roomForm.getRoomSeats())) {
				actionErrors.add("roomSeatsError", new ActionMessage("error.roomSeats.more500Seats"));
				if (roomForm.getErrorFirst() == 0)
					roomForm.setErrorFirst(2);
			}
			
			//check Description not input
			if (ValidateData.isEmpty(roomForm.getDescription())) {
				actionErrors.add("descriptionError", new ActionMessage("error.description.trong"));
				if (roomForm.getErrorFirst() == 0)
					roomForm.setErrorFirst(3);
			}
			
			//check Description use special characters 
			if (ValidateData.isSpecialCharacters(roomForm.getDescription())) {
				actionErrors.add("descriptionError", new ActionMessage("error.description.kituDB"));
				if (roomForm.getErrorFirst() == 0)
					roomForm.setErrorFirst(3);
			}
			
			//check PriceHour not input
			if (ValidateData.isEmpty(roomForm.getPriceHour())) {
				actionErrors.add("priceHourError", new ActionMessage("error.priceHour.trong"));
				if (roomForm.getErrorFirst() == 0)
					roomForm.setErrorFirst(4);
			}
			
			//check PriceHour input character different Float type
			if (!ValidateData.isFloatNumber(roomForm.getPriceHour())) {
				actionErrors.add("priceHourError", new ActionMessage("error.priceHour.chuoi"));
				if (roomForm.getErrorFirst() == 0)
					roomForm.setErrorFirst(4);
			}
			
			//check PriceHour use special characters
			if (ValidateData.isSpecialCharactersFloat(roomForm.getPriceHour())) {
				actionErrors.add("priceHourError", new ActionMessage("error.priceHour.kituDB"));
				if (roomForm.getErrorFirst() == 0)
					roomForm.setErrorFirst(4);
			}
			
			//check PriceHour input negative value
			if (ValidateData.isNegative(roomForm.getPriceHour())) {
				actionErrors.add("priceHourError", new ActionMessage("error.priceHour.negative"));
				if (roomForm.getErrorFirst() == 0)
					roomForm.setErrorFirst(4);
			}
			
			//check PriceFull not input
			if (ValidateData.isEmpty(roomForm.getPriceFull())) {
				actionErrors.add("priceFullError", new ActionMessage("error.priceFull.trong"));
				if (roomForm.getErrorFirst() == 0)
					roomForm.setErrorFirst(5);
			}
			
			//check PriceFull input character different Float type
			if (!ValidateData.isFloatNumber(roomForm.getPriceFull())) {
				actionErrors.add("priceFullError", new ActionMessage("error.priceFull.chuoi"));
				if (roomForm.getErrorFirst() == 0)
					roomForm.setErrorFirst(5);
			}
			
			//check PriceFull use special characters
			if (ValidateData.isSpecialCharactersFloat(roomForm.getPriceFull())) {
				actionErrors.add("priceFullError", new ActionMessage("error.priceFull.kituDB"));
				if (roomForm.getErrorFirst() == 0)
					roomForm.setErrorFirst(5);
			}
			
			//check PriceFull input negative value
			if (ValidateData.isNegative(roomForm.getPriceFull())) {
				actionErrors.add("priceFullError", new ActionMessage("error.priceFull.negative"));
				if (roomForm.getErrorFirst() == 0)
					roomForm.setErrorFirst(5);
			}

			saveErrors(request, actionErrors);

			if (actionErrors.size() > 0) {
				return mapping.findForward("createError");
			}
		}

		// Execute Add new Room when click 'Save' in Create New Room page
		if ("Save".equals(roomForm.getSubmit())) {
			String roomName = roomForm.getRoomName();
			int roomSeats = roomForm.getRoomSeats();
			String description = roomForm.getDescription();
			float priceHour = roomForm.getPriceHour();
			float priceFull = roomForm.getPriceFull();
			int status = 0;
			try {
				
				//Validate OK -> execute addRoom() method
				roomBO.addRoom(roomName, roomSeats, description, priceHour, priceFull, status);
			} catch (Exception e) {
				
				//Exeption throw -> redirect to Error page
				return mapping.findForward("error");
			}
			return mapping.findForward("createSuccess");
		} else { 
			roomForm.setErrorFirst(0);
			
			// redirect to Create New Room page
			return mapping.findForward("create");
		}

	}
}
