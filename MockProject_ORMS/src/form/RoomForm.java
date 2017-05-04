/**
 * 
 */
package form;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author HCD-Fresher204
 *
 */
public class RoomForm extends ActionForm{
	private int roomID;
	private String roomName;
	private int roomSeats;
	private String description;
	private float priceHour;
	private float priceFull;
	private String submit;
	private String action;
	private String notification;
	
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getRoomSeats() {
		return roomSeats;
	}
	public void setRoomSeats(int roomSeats) {
		this.roomSeats = roomSeats;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPriceHour() {
		return priceHour;
	}
	public void setPriceHour(float priceHour) {
		this.priceHour = priceHour;
	}
	public float getPriceFull() {
		return priceFull;
	}
	public void setPriceFull(float priceFull) {
		this.priceFull = priceFull;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
