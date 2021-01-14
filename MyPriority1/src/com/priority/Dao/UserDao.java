package com.priority.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.priority.entity.User;

public class UserDao {

		JdbcTemplate template;

		public void setTemplate(JdbcTemplate template) {
			this.template = template;
		}
		
			public int save(User u){    
			    String sql="insert into Priority_users(name,connection,relationship,career,wealth) values('"+u.getName()+"',"+u.getConnection()+",'"+u.getRelationship()+"',"+u.getCareer()+",'"+u.getWealth()+"')";    
			    return template.update(sql);    
			}    

			public int update(User u){    
			    String sql="update Priority_users set name='"+u.getName()+"', connection="+u.getConnection()+", relationship='"+u.getRelationship()+"', career="+u.getCareer()+", wealth='"+u.getWealth()+"' where id="+u.getId()+"";    
			    return template.update(sql);    
			}  
			public int delete(int id){    
			    String sql="delete from Priority_users where id="+id+"";    
			    return template.update(sql);    
			}  
			
			public User getUserById(int id){    
			    String sql="select * from Priority_users where id=?";    
			    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<User>(User.class));    
			}    
			public List<User> getUsers(){    
			    return template.query("select * from Priority_users",new RowMapper<User>(){    
			        public User mapRow(ResultSet rs, int row) throws SQLException {    
			            User u=new User();    
			            u.setId(rs.getInt(1));    
			            u.setName(rs.getString(2));    
			            u.setConnection(rs.getFloat(3));    
			            u.setRelationship(rs.getFloat(4));  
			            u.setCareer(rs.getFloat(5));
			            u.setWealth(rs.getFloat(6));
			            return u;    
			        }    
			    });    
			}    
			
}
	
	
	/*
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}
	
	public int save(User u){    
	    String sql="insert into Priority_users(name,connection,relationship,career,wealth) values('"+u.getName()+"',"+u.getConnection()+",'"+u.getRelationship()+"',"+u.getCareer()+",'"+u.getWealth()+"')";    
	    return template.update(sql);    
	}    
	public int update(User u){    
	    String sql="update Priority_users set name='"+u.getName()+"', connection="+u.getConnection()+", relationship='"+u.getRelationship()+"', career="+u.getCareer()+", wealth='"+u.getWealth()+"' where id="+u.getId()+"";    
	    return template.update(sql);    
	}    
	public int delete(long id){    
	    String sql="delete from Priority_users where id="+id+"";    
	    return template.update(sql);    
	}    
	public User getUserById(long id){    
	    String sql="select * from Priority_users where id=?";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<User>(User.class));    
	}    
	public List<User> getUsers(){    
	    return template.query("select * from Priority_users",new RowMapper<User>(){    
	        public User mapRow(ResultSet rs, int row) throws SQLException {    
	            User u=new User();    
	            u.setId(rs.getLong(1));    
	            u.setName(rs.getString(2));    
	            u.setConnection(rs.getFloat(3));    
	            u.setRelationship(rs.getFloat(4));  
	            u.setCareer(rs.getFloat(5));
	            u.setWealth(rs.getFloat(6));
	            return u;    
	        }    
	    });    
	}    
	
}*/
