/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DataMasuk.DataMahasiswa;
import DataMasuk.DataJurusan;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author User
 */
public class MahasiswaModel implements ModelInterfaces{
    private ArrayList<DataMahasiswa> mahasiswaEntityArrayList;
    private DataMahasiswa mahasiswaEntity = new DataMahasiswa();
    
    public MahasiswaModel() {
        mahasiswaEntityArrayList = new ArrayList<DataMahasiswa>();
    }
    
    public DataMahasiswa getMahasiswa(int index) {
        return mahasiswaEntityArrayList.get(index);
    }
    
    @Override
    public void view() {
        int i=0;
        for (DataMahasiswa mahasiswaEntity : mahasiswaEntityArrayList) {
            System.out.println(i+". NPM : " + mahasiswaEntity.getNpm() +
                                "\n   Nama : " + mahasiswaEntity.getNama() +
                                "\n   Jurusan : " + DataJurusan.jurusan[mahasiswaEntity.getIndex_jurusan()] +
                                "\n   Tanggal Lahir : " + mahasiswaEntity.getTgl_lahir() +
                                "\n   No. Telp : " + mahasiswaEntity.getNo_telp() +
                                "\n   Password : " + mahasiswaEntity.getPassword());
            i++;
        }
    }
    
    public void insertMahasiswaModel(DataMahasiswa mahasiswa) {
        mahasiswaEntityArrayList.add(mahasiswa);
    }
    
    public void editMahasiswaModel(int index, String data, String ubah) {
        switch(ubah) {
            case "npm" :
                mahasiswaEntityArrayList.get(index).setNpm(data);
                break;
            case "nama" :
                mahasiswaEntityArrayList.get(index).setNama(data);
                break;
            case "noTelp" :
                mahasiswaEntityArrayList.get(index).setNo_telp(data);
                break;
            case "password" :
                mahasiswaEntityArrayList.get(index).setPassword(data);
                break;
        }
    }
    
    public void editMahasiswaModel(int index, Date data) {
        mahasiswaEntityArrayList.get(index).setTgl_lahir(data);
    }
    
    public void editMahasiswaModel(int index, int data) {
        mahasiswaEntityArrayList.get(index).setIndex_jurusan(data);
    }
    
    public void hapusMahasiswaModel(int index) {
        mahasiswaEntityArrayList.remove(mahasiswaEntityArrayList.get(index));
    }
}
