package net.l8nk.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public abstract class DataProviderBase<entity> {
	public final static int NULL_ID = -1;
	
	protected abstract ArrayList<entity> fillData(ResultSet resultSet) throws SQLException;
	
}
