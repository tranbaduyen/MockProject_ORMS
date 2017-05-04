/**
 * 
 */
package model.bean;

/**
 * @author HCD-Fresher204
 *
 */
public class Room {
	private int roomID;
	private String roomName;
	private int roomSeats;
	private String description;
	private float priceHour;
	private float priceFull;
	private int status;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
