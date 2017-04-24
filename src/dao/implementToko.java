/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.m_toko;

/**
 *
 * @author rongrong
 */
public interface implementToko {

    public List<m_toko> getAll();

    public void HapusData(String kode);

    public void SimpanData(m_toko toko);

    public void UbahData(m_toko toko);

    public List<m_toko> getCariKategori(String kategori);
    
    public void TampilData(m_toko a);

    
    
}
