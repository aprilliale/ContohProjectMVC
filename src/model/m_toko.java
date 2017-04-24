/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author rongrong
 */
public class m_toko {
    public String Nama_Barang, Jenis, Harga, Kategori;
    public String Kode_Barang;

    public void setkode(String kode) {
        this.Kode_Barang= kode;
    }

    public void setnama(String nama) {
        this.Nama_Barang= nama;
    }

    public void setharga(String harga) {
        this.Harga= harga;
    }

    public void setkategori(String kategori) {
        this.Kategori=kategori;
    }

    public void setjenis(String jenis) {
        this.Jenis= jenis;
    }

    public String getkode() {
        return Kode_Barang;
    }

    public String getnama() {
        return Nama_Barang;
    }

    public String getkategori() {
       return Kategori;
    }

    public String getjenis() {
        return Jenis;
    }

    public String getharga() {
        return Harga;
    }
    
}
