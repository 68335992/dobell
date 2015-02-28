package com.loveahu.util;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Types;
import java.util.Date;

public class MysqlUtil {

	public static boolean typeEqual(Type javaType,int dbType){
		switch (dbType) {
		case Types.BIGINT:
		case Types.INTEGER:
			return Long.TYPE==javaType||Long.class==javaType||Integer.TYPE==javaType||Integer.class==javaType;
		case Types.BOOLEAN:
			return Boolean.TYPE==javaType||Boolean.class==javaType;
		case Types.CHAR:
		case Types.VARCHAR:
			return String.class==javaType;
		case Types.DATE:
		case Types.TIMESTAMP:
			return Date.class==javaType;
		case Types.DECIMAL:			
			return BigDecimal.class==javaType;
		case Types.DOUBLE:
			return Double.class==javaType||Double.TYPE==javaType;
		case Types.FLOAT:
			return Double.class==javaType||Double.TYPE==javaType||Float.TYPE==javaType||Float.TYPE==javaType;
		case Types.SMALLINT:			
			return Integer.class==javaType||Integer.TYPE==javaType;
		case Types.TINYINT:
			return Byte.class==javaType||Byte.TYPE==javaType;
			
			
		case Types.BLOB:
		case Types.ARRAY:			
		case Types.BIT:
		case Types.BINARY:
		default:
			return true;
		}
		
	}
}
