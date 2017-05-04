/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Room;

/**
 * @author HCD-Fresher204
 *
 */
public class RoomDAO {
	DataAccess da = new DataAccess();
	Connection connection=null;
	Statement stmt=null;
	private static int noOfRecords;
	private int num = 0;
	
	public ArrayList<Room> getListRoom() {
		connection = da.getConnect();
		String sql = "SELECT * FROM  ROOM ";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		ArrayList<Room> list = new ArrayList<Room>();
		Room room;
		try {
			while (rs.next()) {
				room = new Room();
				room.setRoomID(rs.getInt("ROOMID"));
				room.setRoomName(rs.getString("ROOMNAME"));
				room.setRoomSeats(rs.getInt("ROOMSEATS"));
				room.setDescription(rs.getString("Description"));
				room.setPriceHour(rs.getFloat("PRICEHOUR"));
				room.setPriceFull(rs.getFloat("PRICEFULL"));
				room.setStatus(rs.getInt("STATUS"));
				list.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return list;
	}
	public ArrayList<Room> getListRoom(int offset, int noOfRecords) {
		String sql = "SELECT * "
				+ " FROM ( SELECT r.*, ROW_NUMBER() over (ORDER BY roomName ) as ct from  ROOM r ) " +
					"sub WHERE ( ct > "
				+ offset + " AND ct <= " + noOfRecords + " ) ";
		System.out.println(sql);
		ArrayList<Room> list = new ArrayList<Room>();
		Room room = null;
		ResultSet rs = null;
		try {
			connection = da.getConnect();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				room = new Room();
				
				room.setRoomID(rs.getInt("ROOMID"));
				room.setRoomName(rs.getString("ROOMNAME"));
				room.setRoomSeats(rs.getInt("ROOMSEATS"));
				room.setDescription(rs.getString("Description"));
				room.setPriceHour(rs.getFloat("PRICEHOUR"));
				room.setPriceFull(rs.getFloat("PRICEFULL"));
				room.setStatus(rs.getInt("STATUS"));
				list.add(room);
			}
			rs.close();
			rs = stmt.executeQuery("select count(*) as num from ROOM");
			if (rs.next())
				this.noOfRecords = rs.getInt("num");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
	public Room getRoomDetail(int roomID) {
		// TODO Auto-generated method stub
		connection = da.getConnect();
		String sql=	String.format("SELECT * "+
					" FROM ROOM WHERE ROOMID = %s", roomID);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Room room = new Room();
		try {
			while(rs.next()){
				room.setRoomID(rs.getInt("ROOMID"));
				room.setRoomName(rs.getString("ROOMNAME"));
				room.setRoomSeats(rs.getInt("ROOMSEATS"));
				room.setDescription(rs.getString("DESCRIPTION"));
				room.setPriceHour(rs.getFloat("PRICEHOUR"));
				room.setPriceFull(rs.getFloat("PRICEFULL"));
				room.setStatus(rs.getInt("STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;
	}
	public void addRoom(String roomName, int roomSeats, String description, float priceHour, float priceFull, int status) {
		connection = da.getConnect();
		String sql=	String.format("INSERT INTO ROOM(roomName,roomSeats,description,priceHour,priceFull,status) "+
					" VALUES ( N'%s',%s,N'%s',%s,%s,%s )", roomName, roomSeats, description, priceHour,priceFull,status);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateRoom(int roomID, String roomName, int roomSeats, String description, float priceHour, float priceFull, int status) {
		// TODO Auto-generated method stub
		connection = da.getConnect();
		String sql=	String.format("UPDATE ROOM "+
				" SET ROOMNAME = N'%s', ROOMSEATS = %s, DESCRIPTION = N'%s', PRICEHOUR = %s, PRICEFULL = %s, STATUS = 0 " +
				" WHERE ROOMID = '%s'", roomName, roomSeats, description, priceHour, priceFull, roomID);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteRoom(int roomID) {
		// TODO Auto-generated method stub
		connection = da.getConnect();
		String sql=	String.format("DELETE FROM ROOM WHERE ROOMID = %s", roomID);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isDuplicateRoomName(String roomName) {
		connection = da.getConnect();
		String sql = String.format("SELECT count(RoomName) as num FROM ROOM WHERE roomName = N'%s'", roomName);
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				num = rs.getInt("num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("numName = "+num);
		if(num!=0) 
			return true;
		return false;
	}
	
	/**
	 * @return the noOfRecords
	 */
	public static int getNoOfRecords() {
		return noOfRecords;
	}

	/**
	 * @param noOfRecords
	 *            the noOfRecords to set
	 */
	public void setNoOfRecords(int noOfRecords) {
		this.noOfRecords = noOfRecords;
	}
}
