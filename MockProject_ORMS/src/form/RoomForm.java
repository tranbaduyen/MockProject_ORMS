/**
 * 
 */
package form;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * RoomForm.java
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
public class RoomForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int roomID;
	private String roomName;
	private int roomSeats;
	private String description;
	private float priceHour;
	private float priceFull;
	private String submit;
	private String action;
	private String notification;

	/**
	 * @return roomID
	 */
	public int getRoomID() {
		return roomID;
	}

	/**
	 * @param roomID
	 */
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	/**
	 * @return roomName
	 */
	public String getRoomName() {
		return roomName;
	}

	/**
	 * @param roomName
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	/**
	 * @return
	 */
	public int getRoomSeats() {
		return roomSeats;
	}

	/**
	 * @param roomSeats
	 */
	public void setRoomSeats(int roomSeats) {
		this.roomSeats = roomSeats;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return priceHour
	 */
	public float getPriceHour() {
		return priceHour;
	}

	/**
	 * @param priceHour
	 */
	public void setPriceHour(float priceHour) {
		this.priceHour = priceHour;
	}

	/**
	 * @return priceFull
	 */
	public float getPriceFull() {
		return priceFull;
	}

	/**
	 * @param priceFull
	 */
	public void setPriceFull(float priceFull) {
		this.priceFull = priceFull;
	}

	/**
	 * @return submit
	 */
	public String getSubmit() {
		return submit;
	}

	/**
	 * @param submit
	 */
	public void setSubmit(String submit) {
		this.submit = submit;
	}

	/**
	 * @return action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return notification
	 */
	public String getNotification() {
		return notification;
	}

	/**
	 * @param notification
	 */
	public void setNotification(String notification) {
		this.notification = notification;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.
	 * ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}
}
