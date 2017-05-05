/**
 * 
 */
package model.bean;

/**
 * Room.java
 *
 * Version 1.0
 *
 * Date: 03-05-2017
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 03-05-2017        	DuyenTB         Create
 */
public class Room {
	private int roomID;
	private String roomName;
	private int roomSeats;
	private String description;
	private float priceHour;
	private float priceFull;
	private int status;

	/**
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

}
