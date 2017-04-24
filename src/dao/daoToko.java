/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import com.mysql.jdbc.Connection;
import controller.c_koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.m_toko;

/**
 *
 * @author rongrong
 */
public class daoToko  implements implementToko{
   Connection connection;
   public String TampilData = "SELECT * FROM `barang`";
   public String UbahData = "UPDATE `barang` SET"
           + "`Nama_Barang`=?, `Harga`=?, `Kategori`=?, `Jenis`=? Where"
           + "`Kode_Barang`=?;";
   public String SimpanData = "INSERT INTO `barang` VALUES (?, ?, ?, ?, ?)";
   public String HapusData = "DELETE FROM `barang`";
   public String CariKategori = "SELECT `Kode_Barang`,"
           + "`Nama_Barang`, `Kategori`, `Jenis`, `Harga` FROM `barang`"
           + "WHERE Kategori like ?";
   
   public daoToko(){
       connection = c_koneksi.setKoneksi();
   }
   
   @Override
    public void TampilData(m_toko a) {

    }

    @Override
    public List<m_toko> getAll() {
        List<m_toko> lt=null;
        try {
            lt = new ArrayList<m_toko>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(TampilData);
            while (rs.next()){
                m_toko toko = new m_toko();
                toko.setkode(rs.getString("Kode_Barang"));
                toko.setnama(rs.getString("Nama_Barang"));
                toko.setkategori(rs.getString("Kategori"));
                toko.setjenis(rs.getString("Jenis"));
                toko.setharga(rs.getString("Harga"));
                lt.add(toko);
            }
        }catch (SQLException ex) {
            Logger.getLogger(daoToko.class.getName()).log(Level.SEVERE,null, ex);
        }
        return lt;
    }

    @Override
    public void HapusData(String kode) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(HapusData);
            statement.setString(1, kode);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(daoToko.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

    @Override
    public void SimpanData(m_toko toko) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SimpanData);
            statement.setString(1, toko.getkode());
            statement.setString(2, toko.getnama());
            statement.setString(3, toko.getkategori());
            statement.setString(4, toko.getjenis());
            statement.setString(5, toko.getharga());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()){
                toko.setkode(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoToko.class.getName()).log(Level.SEVERE,null, ex);
        }

    }

    @Override
    public void UbahData(m_toko toko) {
        PreparedStatement statement = null;
        try {
           statement = connection.prepareStatement(UbahData);
           statement.setString(1, toko.getkode());
           statement.setString(2, toko.getnama());
           statement.setString(3, toko.getkategori());
           statement.setString(4, toko.getjenis());
           statement.setString(5, toko.getharga());
           statement.executeUpdate();

        }catch (SQLException ex) {
            Logger.getLogger(daoToko.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public List<m_toko> getCariKategori(String kategori) {
        List<m_toko> lt=null;
        try {
            lt = new ArrayList<m_toko>();
            PreparedStatement st=connection.prepareStatement(CariKategori);
            st.setString(1, "%"+kategori+"%");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                m_toko toko = new m_toko();
                toko.setkode(rs.getString("Kode_Barang"));
                toko.setnama(rs.getString("Nama_Barang"));
                toko.setkategori(rs.getString("Kategori"));
                toko.setjenis(rs.getString("Jenis"));
                toko.setharga(rs.getString("Harga"));
                lt.add(toko);
            }
        }catch (SQLException ex) {
            Logger.getLogger(daoToko.class.getName()).log(Level.SEVERE,null, ex);
        }
        return lt;
    }

    public void CariKategori(int kode) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(CariKategori);
            statement.setInt(1, kode);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(daoToko.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}
