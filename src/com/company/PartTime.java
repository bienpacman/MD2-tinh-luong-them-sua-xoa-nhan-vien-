package com.company;

public class PartTime extends NhanVien{
    private int numberTime;

    public PartTime() {
    }

    public PartTime(int numberTime) {
        this.numberTime = numberTime;
    }

    public PartTime(int id, String name, int age, int numberTime) {
        super(id, name, age);
        this.numberTime = numberTime;
    }

    public int getNumberTime() {
        return numberTime;
    }

    public void setNumberTime(int numberTime) {
        this.numberTime = numberTime;
    }

    @Override
    public double tinhLuong() {
        return numberTime* 200;
    }

    @Override
    public String toString() {
        return "PartTime{" +
                "numberTime=" + numberTime + " " +super.toString() +
                '}';
    }
}
