package br.upe.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.upe.dao.db.DAO;
import br.upe.dao.db.DBConection;
import br.upe.models.User;

public class UserDAO implements DAO<User> {

	public User getSingle(String login) {
        Connection conn = DBConection.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {   		
            String sql = "select "
            		+User.ID +", " 
            		+User.EMAIL+ ", " 
            		+User.FIRST_NAME+ ", "
            		+User.LAST_NAME+ ", "
            		+User.CPF+ ", "
            		+User.BIRTH_DATE+ ", "
            		+User.PASSWORD+ " " 
            		+ "from "+User.TABLE_NAME+" where "+User.EMAIL+"= ?;";
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return new User(
                		rs.getInt(User.ID),
                		rs.getString(User.EMAIL),
                		rs.getString(User.FIRST_NAME),
                		rs.getString(User.LAST_NAME),
                		rs.getString(User.CPF),
                		rs.getString(User.BIRTH_DATE),
                		rs.getString(User.PASSWORD));

            }
        } catch (SQLException ex) {
        } finally {
        	DBConection.close(rs, ps, conn);
        }
        return null;
    }

	@Override
	public List<User> getList() {
		return getList(0);
	}

	@Override
	public User getSingle(Object... chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getList(int top) {
		// TODO Auto-generated method stub
		return null;
	}

}