/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trysoalprakmodul2;

import DataMasuk.DataMahasiswa;
import DataMasuk.DataJurusan;
import Model.MahasiswaModel;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class TrySoalPrakModul2 {

    public MahasiswaModel mahasiswaModel = new MahasiswaModel();
    public Scanner input = new Scanner(System.in);
    public String npm, nama, no_telp, password;
    public Date tgl_lahir;
    public int pil, index_jurusan, index_mhs;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TrySoalPrakModul2 global = new TrySoalPrakModul2();
        System.out.println("Selamat Datang di Aplikasi Pendataan Mahasiswa !!");
        do {
            System.out.println("1. Pendaftaran Mahasiswa");
            System.out.println("2. Lihat data Mahasiswa");
            System.out.println("3. Edit data Mahasiswa");
            System.out.println("4. Hapus data Mahasiswa");
            System.out.println("5. Exit");
            System.out.print("Pilih Menu : ");
            global.pil = global.input.nextInt();
            switch (global.pil) {
                case 1:
                    global.viewPendaftaran();
                    break;
                case 2:
                    global.viewDataMahasiswa();
                    break;
                case 3:
                    global.viewEditDataMahasiswa();
                    break;
                case 4:
                    global.viewHapusDataMahasiswa();
                    break;
            }
        } while (global.pil != 5);
    }

    public void viewPendaftaran() {
        System.out.print("Input NPM = ");
        npm = input.next();
        System.out.print("Input Nama = ");
        nama = input.next();
        System.out.print("Input Tanggal Lahir = ");
        tgl_lahir = new Date(input.next());
        System.out.print("Input No. Telp = ");
        no_telp = input.next();
        System.out.print("Input Password = ");
        password = input.next();
        for (int i = 0; i < DataJurusan.jurusan.length; i++) {
            System.out.println(i + ". " + DataJurusan.jurusan[i]);
        }
        System.out.print("Pilih Jurusan = ");
        index_jurusan = input.nextInt();
        mahasiswaModel.insertMahasiswaModel(new DataMahasiswa(npm, nama,
                tgl_lahir, no_telp, password, index_jurusan));
        System.out.println("Data Berhasil DiTambahkan");
    }

    public void viewDataMahasiswa() {
        mahasiswaModel.view();
    }

    public void viewEditDataMahasiswa() {
        String jawab;
        mahasiswaModel.view();
        System.out.print("Pilih Nomor : ");
        index_mhs = input.nextInt();
        do {
            System.out.println("1. Npm : " + mahasiswaModel.getMahasiswa(index_mhs).getNpm());
            System.out.println("2. Nama : " + mahasiswaModel.getMahasiswa(index_mhs).getNama());
            System.out.println("3. Jurusan : " + DataJurusan.jurusan[mahasiswaModel.getMahasiswa(index_mhs).getIndex_jurusan()]);
            System.out.println("4. Tanggal Lahir : " + mahasiswaModel.getMahasiswa(index_mhs).getTgl_lahir());
            System.out.println("5. No. Telp : " + mahasiswaModel.getMahasiswa(index_mhs).getNo_telp());
            System.out.println("6. PasswordS : " + mahasiswaModel.getMahasiswa(index_mhs).getPassword());
            System.out.print("Pilih Angka Untuk Edit : ");
            pil = input.nextInt();
            switch (pil) {
                case 1:
                    System.out.println("NPM Sekarang : " + mahasiswaModel.getMahasiswa(index_mhs).getNpm());
                    System.out.print("Input NPM Baru : ");
                    npm = input.next();
                    mahasiswaModel.editMahasiswaModel(index_mhs, npm, "npm");
                    break;
                case 2:
                    System.out.println("Nama Sekarang : " + mahasiswaModel.getMahasiswa(index_mhs).getNama());
                    System.out.print("Input Nama Baru : ");
                    nama = input.next();
                    mahasiswaModel.editMahasiswaModel(index_mhs, nama, "nama");
                    break;
                case 3:
                    for (int i = 0; i < DataJurusan.jurusan.length; i++) {
                        System.out.println(i + ". " + DataJurusan.jurusan[i]);
                    }
                    System.out.println("Jurusan Sekarang : " + DataJurusan.jurusan[mahasiswaModel.getMahasiswa(index_mhs).getIndex_jurusan()]);
                    System.out.print("Pilih Jurusan Baru : ");
                    index_jurusan = input.nextInt();
                    mahasiswaModel.editMahasiswaModel(index_mhs, index_jurusan);
                    break;
                case 4:
                    System.out.println("Tanggal Lahir Sekarang : " + mahasiswaModel.getMahasiswa(index_mhs).getTgl_lahir());
                    System.out.print("Input Tgl. Lahir Baru : ");
                    tgl_lahir = new Date(input.next());
                    mahasiswaModel.editMahasiswaModel(index_mhs, tgl_lahir);
                    break;
                case 5:
                    System.out.println("No. Telp Sekarang : " + mahasiswaModel.getMahasiswa(index_mhs).getNo_telp());
                    System.out.print("Input No. Telp Baru : ");
                    no_telp = input.next();
                    mahasiswaModel.editMahasiswaModel(index_mhs, no_telp, "noTelp");
                    break;
                case 6:
                    System.out.println("Password Sekarang : " + mahasiswaModel.getMahasiswa(index_mhs).getPassword());
                    System.out.print("Input Password Baru : ");
                    password = input.next();
                    mahasiswaModel.editMahasiswaModel(index_mhs, password, "password");
                    break;
            }
            System.out.println("Data Berhasil DiEdit");
            System.out.println("Apakah Ingin Edit Lagi ? (y/t)");
            jawab = input.next();
        } while (jawab == "y");
    }

    public void viewHapusDataMahasiswa() {
        mahasiswaModel.view();
        System.out.print("Pilih Nomor : ");
        index_mhs = input.nextInt();
        mahasiswaModel.hapusMahasiswaModel(index_mhs);
        System.out.println("Data Berhasil Dihapus");
    }
}
