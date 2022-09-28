package com.utopian.utility;

import java.sql.Connection;

public class DemoChkConn {

	public static void main(String[] args) {
		Connection conn = DBUtil.provideConnection();

		System.out.println(conn);
	}

}
