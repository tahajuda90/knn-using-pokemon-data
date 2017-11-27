/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmeanscba;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class koneksi {
    Connection hub;
    public  Connection kondb() {
        Connection hub=null;
        try {
            hub = DriverManager.getConnection("jdbc:mysql://localhost/tutorial", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hub;
    }
    public ResultSet getvaldb(Connection hub,String Quer) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = hub.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery(Quer);
        } catch (SQLException ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ArrayList getname(){
        ArrayList arr = new ArrayList();
        ResultSet rs = null;
        String sql="SELECT `name` FROM `pokemon`";
        String trgt="name";
        try {
            hub=kondb();
            rs=getvaldb(hub,sql);
            while (rs.next()) {
                arr.add(rs.getString(trgt));
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return arr;
    }
    
    public int getttal(String nama){
        ResultSet rs = null;
        int hasil=0;
        String sql="SELECT `total` FROM `pokemon` WHERE `name` = '"+nama+"'";
        String trgt="total";
        try {
            hub=kondb();
            rs=getvaldb(hub,sql);
            while (rs.next()) {
                hasil=rs.getInt(trgt);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return hasil;
    }
    
    public int gethp(String nama){
        ResultSet rs = null;
        int hasil=0;
        String sql="SELECT `hp` FROM `pokemon` WHERE `name` = '"+nama+"'";
        String trgt="hp";
        try {
            hub=kondb();
            rs=getvaldb(hub,sql);
            while (rs.next()) {
                hasil=rs.getInt(trgt);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return hasil;
    }
    
    public int getatk(String nama){
        ResultSet rs = null;
        int hasil =0;
        String sql="SELECT `attack` FROM `pokemon` WHERE `name` = '"+nama+"'";
        String trgt="attack";
        try {
            hub=kondb();
            rs=getvaldb(hub,sql);
            while (rs.next()) {
                hasil=rs.getInt(trgt);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return hasil;
    }
    
    public int getdef(String nama){
        ResultSet rs = null;
        int hasil=0;
        String sql="SELECT `defense` FROM `pokemon` WHERE `name` = '"+nama+"'";
        String trgt="defense";
        try {
            hub=kondb();
            rs=getvaldb(hub,sql);
            while (rs.next()) {
               hasil=rs.getInt(trgt);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return hasil;
    }
    
    public int getspd(String nama){
        ResultSet rs = null;
        int hasil =0;
        String sql="SELECT `speed` FROM `pokemon` WHERE `name` = '"+nama+"'";
        String trgt="speed";
        try {
            hub=kondb();
            rs=getvaldb(hub,sql);
            while (rs.next()) {
                hasil=rs.getInt(trgt);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return hasil;
    }
    
    
    public int[][] matrix(){
        ResultSet rs = null;
        ArrayList nama = getname();
        int[][] data = new int[nama.size()][4];
        String sql ="SELECT `hp`,`attack`,`defense`,`speed`FROM `pokemon`";
        try {
            hub=kondb();
            rs=getvaldb(hub,sql);
            int i=0;
            while (rs.next()) {
                data[i][0]=rs.getInt("hp");
                data[i][1]=rs.getInt("attack");
                data[i][2]=rs.getInt("defense");
                data[i][3]=rs.getInt("speed");
                i++;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }   
       
        return data;
    }
}
