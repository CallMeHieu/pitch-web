package com.techpower.pitchweb.model;

import com.techpower.pitchweb.enums.TournamentType;
import lombok.Data;

import java.util.Date;

@Data
public class Tournament {
    private String name;
    private Date eventDate;
    private String address;
    private String content;
    private TournamentType type;
}
