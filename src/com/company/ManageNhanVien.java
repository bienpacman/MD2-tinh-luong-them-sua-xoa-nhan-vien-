package com.company;

import java.util.Scanner;

public class ManageNhanVien {
    NhanVien[] nhanViens = new NhanVien[0];
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        System.out.println("===========Menu=============");
        System.out.println("1. Thêm Nhân Viên");
        System.out.println("2 Sửa nhân viên");
        System.out.println("3 Xóa Nhân Viên");
        System.out.println("4 Tính lương");
        System.out.println("5 Show");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                showCreateNV();
                break;
            case 2 :
                editNV();
                break;
            case 3 :
                deleteNV();
                break;
            case 4:
                showTinhLuong();
                break;
            case 5:
                for (NhanVien nv: nhanViens) {
                    System.out.println(nv);
                }
        }
    }

    public NhanVien createNhanVien(boolean isFullTime) {
        System.out.println("Nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi");
        int age = Integer.parseInt(scanner.nextLine());
        if (isFullTime) {
            System.out.println("Nhập hệ số");
            int number = Integer.parseInt(scanner.nextLine());
            return new FullTime(id, name, age, number);
        } else {
            System.out.println("Nhập số buổi ");
            int number = Integer.parseInt(scanner.nextLine());
            return new PartTime(id, name, age, number);
        }
    }

    public void add(NhanVien nhanVien) {
        NhanVien[] newNV = new NhanVien[nhanViens.length + 1];
        for (int i = 0; i < nhanViens.length; i++) {
            newNV[i] = nhanViens[i];
        }
        newNV[newNV.length - 1] = nhanVien;
        nhanViens = newNV;
    }

    public void showCreateNV() {
        System.out.println("1. Tạo FullTime");
        System.out.println("2. Tạo PartTime");
        int choice1 = Integer.parseInt(scanner.nextLine());
        switch (choice1) {
            case 1:
                NhanVien nhanVienFull = createNhanVien(true);
                add(nhanVienFull);
                break;
            case 2:
                NhanVien nhanVienPartTime = createNhanVien(false);
                add(nhanVienPartTime);
                break;
        }
    }

    public void editNV() {
        System.out.println("Nhập id nhân viên muốn sửa : ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < nhanViens.length; i++) {
            if (nhanViens[i].getId() == id) {
                nhanViens[i] = createNhanVien(nhanViens[i] instanceof FullTime);
            }
        }
    }

    public void deleteNV() {
        NhanVien[] newNV = new NhanVien[nhanViens.length];
        System.out.println("Nhập id muốn xóa");
        int id = Integer.parseInt(scanner.nextLine());
        int index = -1;
        for (int i = 0; i < nhanViens.length; i++) {
            if (nhanViens[i].getId() == id) {
                index = i;
            }
        }
        if (index != -1) {
            for (int i = 0; i < newNV.length; i++) {
                if (i < index) {
                    newNV[i] = nhanViens[i];
                } else {
                    newNV[i] = nhanViens[i + 1];
                }
            }
        }
        nhanViens = newNV;
    }

    public void showTinhLuong() {
        System.out.println("1 FullTime");
        System.out.println("2 PartTime");
        int choice2 = Integer.parseInt(scanner.nextLine());
        switch (choice2) {
            case 1:
                for (NhanVien nv : nhanViens) {
                    if (nv instanceof FullTime) {
                        System.out.println(nv.getName() + " = " + nv.tinhLuong());
                    }
                }
                break;
            case 2:
                for (NhanVien nv : nhanViens) {
                    if ((nv instanceof PartTime)) {
                        System.out.println(nv.getName() + "= " + nv.tinhLuong());
                    }
                }
                break;
        }
    }
}
