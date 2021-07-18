package account_Package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountantDao {
public static int insert(AccountantBean bean)  {
	int status =0;
	
	try {
		Connection con = Db.getcon();
		PreparedStatement ps = con.prepareStatement("insert into student(id,name,email,password,address,contact)values(?,?,?,?,?,?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setString(3, bean.getEmail());
		ps.setString(4, bean.getPassword());
		ps.setString(5, bean.getAddress());
		ps.setString(6, bean.getContact());
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return status;
		
}
public static boolean validate(String email,String password) {
	boolean status = false;
	
	try {
		Connection con = Db.getcon();
		PreparedStatement ps = con.prepareStatement("select * from student where email=?,password=?");
	ps.setString(1, email);
	ps.setString(2, password);
	ResultSet rs = ps.executeQuery();
	status = rs.next();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
}
public static int delete(int id) {
	int status = 0;
	
	try {
		Connection con = Db.getcon();
		PreparedStatement ps = con.prepareStatement("delete from student where id =?");
		ps.setInt(1, id);
		status = ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
}
public static int update(AccountantBean bean) {
	int status = 0;
	
	try {
		Connection con = Db.getcon();
		PreparedStatement ps = con.prepareStatement("update student set name=?,email=?,password=?,address=?,contact=? where id =?");
		ps.setString(1, bean.getName());
		ps.setString(2, bean.getEmail());
		ps.setString(3, bean.getPassword());
		ps.setString(4, bean.getAddress());
		ps.setString(5, bean.getContact());
		ps.setInt(6,bean.getId());
		ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
}
public static List<AccountantBean> getAllRecords(){
	List<AccountantBean> list = new ArrayList<AccountantBean>();
	
	try {
		Connection con = Db.getcon();
		PreparedStatement ps = con.prepareStatement("select*from student");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			AccountantBean bean = new AccountantBean();
			bean.setName(rs.getString(1));
			bean.setEmail(rs.getString(2));
			bean.setPassword(rs.getString(3));
			bean.setAddress(rs.getString(4));
			bean.setContact(rs.getString(5));
			bean.setId(rs.getInt(6));
			list.add(bean);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}
public static AccountantBean getRecordsById(int id) {
	AccountantBean bean = new AccountantBean();
	
	try {
		Connection con = Db.getcon();
		
	PreparedStatement ps = con.prepareStatement("select * from student where id =?");
ps.setInt(1, id);
ResultSet rs = ps.executeQuery();
while(rs.next()) {
	
	bean.setName(rs.getString(1));
	bean.setEmail(rs.getString(2));
	bean.setPassword(rs.getString(3));
	bean.setAddress(rs.getString(4));
	bean.setContact(rs.getString(5));
	bean.setId(rs.getInt(6));
}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return bean;
}
}
