import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.pool.database.DBConnect;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;



public class GetFullCalendarData extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		 doPost(req,resp);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List resultList= new ArrayList();
		List idList=new ArrayList();
		
		String uid=req.getParameter("uid");
		String uroom=req.getParameter("uroom");
		String sql="select trim(bk.id) id from research.bookmeetingroom bk where "
		          +"trim(bk.m_no)='"+uid+"' "
		          +"and trim(bk.bookRoom)='"+uroom+"'";
		String sqlAll="select * from research.Bookmeetingroom bk where "
				 +"trim(bk.bookRoom)='"+uroom+"'";
		try {
			DBConnect db = new DBConnect();
			DBConnect db1 = new DBConnect();
	
	
			 ResultSet res=null;
			 ResultSet resId=null;
			 if (sqlAll != null) {
				  res= db.executeQuery(sqlAll);

				}
			 if (sql != null) {
				  resId= db1.executeQuery(sql);

				}
			 
			 while(resId.next()){
				 idList.add(resId.getInt("id"));
			 }
			 db1.close();
			 
				 
	//		ResultSet res=db.executeQuery();
			while(res.next()){
				
				MeetingRoom mr=new MeetingRoom();
				mr.setId(res.getInt("id"));
				mr.setStart(res.getTimestamp("startTime"));
				mr.setEnd(res.getTimestamp("endTime"));
				mr.setTitle(res.getString("title"));
	
				if(idList.contains(res.getInt("id")))
					//我自己的预订，设置为蓝色
						{mr.setEditable(true);
						 mr.setColor("#3a87ad");}
				else{
					//其他人的预订设置为粉色
					mr.setColor("#FFC0CB");
				}
				resultList.add(mr);
				
				// lstData.add(result.getString("columname"));
		//		resultList.add(res.getString("bugID").trim());
				
			}
			db.close();
			
			
		
			//JsonConfig是net.sf.json.JsonConfig中的,这个为固定写法    
		       JsonConfig jsonConfig = new JsonConfig();    
		        jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());    

			
		        //将List转化为JSON
		        JSONArray json=JSONArray.fromObject(resultList,jsonConfig);
		        //设置编码
		        resp.setCharacterEncoding("gbk");
		        //写入到前台
		        resp.getWriter().write(json.toString());
		     
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
		
		
		
	
	