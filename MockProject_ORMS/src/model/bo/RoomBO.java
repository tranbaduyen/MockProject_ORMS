/**
 * 
 */
package model.bo;

import java.util.ArrayList;

import model.bean.Room;
import model.dao.RoomDAO;

/**
 * @author HCD-Fresher204
 *
 */
public class RoomBO {
	RoomDAO roomDAO = new RoomDAO();
	
	public ArrayList<Room> getListRoom() {
		return roomDAO.getListRoom();
	}
	public ArrayList<Room> getListRoom(int offset,int noOfRecords) {
		return roomDAO.getListRoom(offset, noOfRecords);
	}
	public Room getRoomDetail(int roomID){
		return roomDAO.getRoomDetail(roomID);
	}
	public void addRoom(String roomName, int roomSeats, String description, float priceHour, float priceFull, int status) {
		// TODO Auto-generated method stub
		roomDAO.addRoom(roomName, roomSeats, description, priceHour, priceFull, status);
	}
	public void updateRoom(int roomID, String roomName, int roomSeats, String description, float priceHour, float priceFull, int status) {
		// TODO Auto-generated method stub
		roomDAO.updateRoom(roomID, roomName, roomSeats, description, priceHour, priceFull, status);
	}
	public void deleteRoom(int roomID){
		roomDAO.deleteRoom(roomID);
	}
	public boolean isDuplicateRoomName(String roomName){
		return roomDAO.isDuplicateRoomName(roomName);
	}
}
