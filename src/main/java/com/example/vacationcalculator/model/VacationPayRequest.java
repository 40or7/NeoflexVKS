package com.example.vacationcalculator.model;

public class VacationPayRequest {

    public double averageSalary;
    public int vacationDays;

    public String startDay;
    public String endDay;

    public VacationPayRequest(double averageSalary, int vacationDays) {
        this.averageSalary = averageSalary;
        this.vacationDays = vacationDays;
    }

    public double getAverageSalary() {

        return averageSalary;
    }

    public void setAverageSalary(double averageSalary) {

        this.averageSalary = averageSalary;
    }

    public int getVacationDays() {

        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {

        this.vacationDays = vacationDays;
    }
}