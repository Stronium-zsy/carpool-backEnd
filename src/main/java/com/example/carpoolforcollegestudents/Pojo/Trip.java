package com.example.carpoolforcollegestudents.Pojo;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class Trip {
    @NotNull
    @NotEmpty
    public String departure;
    @NotNull
    @NotEmpty
    public String destination;

    public String startDate;

    public String endDate;
    public String tripName;

    public int tripId;
    public int userId;
    public int numofpeople;
}
