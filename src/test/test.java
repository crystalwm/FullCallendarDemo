package test;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import oracle.pool.database.DBConnect;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args)    
			throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
	    List resultList = new ArrayList();
	//    String uid = req.getParameter("uid");
	//  String sql = "select distinct bs.bugid bugID from bug.bug_send bs where trim(bs.sendid)='" + uid + "'";
	    String sql="select  m.m_no m_no from research.members m";
	    try {
	      DBConnect db = new DBConnect(sql);
	      System.out.println("Connection Successful!"); 

	      ResultSet res = db.executeQuery();
	      while (res.next())
	      {
	        resultList.add(res.getString("m_no").trim());
	      }

	//      JSONArray json = JSONArray.fromObject(resultList);

	//      resp.setCharacterEncoding("gbk");

//	      resp.getWriter().write(json.toString());
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }

	}

}
