package form;

import org.apache.struts.action.ActionForm;

public class AjaxCreateNewRoomForm extends ActionForm{
	private int roomID;
	private String roomName;
	private int roomSeats;
	private String description;
	private float priceHour;
	private float priceFull;
	private String submit;
	private String action;
	private String notification;
	private int errorFirst = 0;
	
	AjaxCreateNewRoomForm(){
		 
	 }
	public AjaxCreateNewRoomForm(int roomID, String roomName, int roomSeats, String description, float priceHour,
			float priceFull) {
		super();
		this.roomID = roomID;
		this.roomName = roomName;
		this.roomSeats = roomSeats;
		this.description = description;
		this.priceHour = priceHour;
		this.priceFull = priceFull;
	}
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

	public int getErrorFirst() {
		return errorFirst;
	}

	public void setErrorFirst(int errorFirst) {
		this.errorFirst = errorFirst;
	}
	
	
	
}
