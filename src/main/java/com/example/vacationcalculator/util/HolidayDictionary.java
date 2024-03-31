package com.example.vacationcalculator.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class HolidayDictionary {
    private final Set<LocalDate> holidays;

    public boolean isHoliday(LocalDate date){
        return holidays.contains(date);
    }
    public HolidayDictionary (){
        holidays = new HashSet<>();
        holidays.add(LocalDate.of(LocalDate.now().getYear(),1,1));
        holidays.add(LocalDate.of(LocalDate.now().getYear(),1,2));
        holidays.add(LocalDate.of(LocalDate.now().getYear(),1,3));
        holidays.add(LocalDate.of(LocalDate.now().getYear(),1,4));
        holidays.add(LocalDate.of(LocalDate.now().getYear(),1,5));
        holidays.add(LocalDate.of(LocalDate.now().getYear(),1,6));
        holidays.add(LocalDate.of(LocalDate.now().getYear(),1,7));
        holidays.add(LocalDate.of(LocalDate.now().getYear(),1,8));
        holidays.add(LocalDate.of(LocalDate.now().getYear(),2,23));
        holidays.add(LocalDate.of(LocalDate.now().getYear(),3,8));
        holidays.add(LocalDate.of(LocalDate.now().getYear(),5,1));
        holidays.add(LocalDate.of(LocalDate.now().getYear(),5,9));
        holidays.add(LocalDate.of(LocalDate.now().getYear(),6,12));
        holidays.add(LocalDate.of(LocalDate.now().getYear(),11,4));
        holidays.add(LocalDate.of(LocalDate.now().getYear(),12,31));
    }
}
