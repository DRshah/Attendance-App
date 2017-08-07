package com.example.db;

import java.io.IOException;
import java.sql.SQLException;


import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

public class DatabaseConfigUtil extends OrmLiteConfigUtil{

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SQLException 
	 */
	
	private static final Class<?>[] Classes = new Class[]{StudentDB.class};
	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		writeConfigFile("ormlite_config.txt",Classes);
	}

}
