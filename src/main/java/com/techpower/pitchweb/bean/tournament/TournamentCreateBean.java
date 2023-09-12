package com.techpower.pitchweb.bean.tournament;

import com.techpower.pitchweb.enums.TimeValue;
import com.techpower.pitchweb.enums.TournamentType;
import com.techpower.pitchweb.model.Tournament;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@Getter
@Setter
@Component
@ManagedBean
@ViewScoped
public class TournamentCreateBean {
    private final String title = "Thêm mới giải đấu";
    private final TournamentType[] tournamentTypes = TournamentType.values();
    private Tournament newTournament = new Tournament();

    public void createTournament() {
        Tournament tournament = new Tournament();
        tournament = newTournament;
    }
}
