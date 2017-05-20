package com.infotech.client;

import java.sql.CallableStatement;
import java.sql.Connection;

import com.infotech.util.DBUtil;

public class ClientTest {

	public static void main(String[] args) {
		String UPDATESQL="{CALL updateSalById(?,?)}";
		try(Connection connection = DBUtil.getConnection();
				CallableStatement cs= connection.prepareCall(UPDATESQL)) {
			
			cs.setDouble(1, 71000.00);
			cs.setInt(2, 1);
			
			cs.addBatch();
			
			cs.setDouble(1, 9000.00);
			cs.setInt(2, 2);
			
			cs.addBatch();
			
			cs.setDouble(1, 91000.00);
			cs.setInt(2, 3);
			
			cs.addBatch();
			
			int[] executeBatch = cs.executeBatch();
			for (int i : executeBatch) {
				System.out.println(i);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
