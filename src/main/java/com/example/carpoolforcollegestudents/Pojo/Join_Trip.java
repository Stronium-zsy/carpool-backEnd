package com.example.carpoolforcollegestudents.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Join_Trip {
    public int messageId;
    public int sender;
    public int receiver;
    public String messageContent;
    public Timestamp time;
    public String status;
    public int tripId;
    public String departure;
    public String destination;
    public String startDate;
    public String endDate;
    public String tripName;
    public int userId;
    public int numofpeople;
    public String username;
    public int joinid;
}

