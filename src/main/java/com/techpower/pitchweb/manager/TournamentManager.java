package com.techpower.pitchweb.manager;

import com.techpower.pitchweb.model.Tournament;
import org.springframework.stereotype.Repository;

@Repository
public class TournamentManager extends BaseManager<Tournament> {
    public TournamentManager() {
        super("tournament", Tournament.class);
    }

    public Tournament createTournament(Tournament tournament, String currentUserId) {
        return (Tournament) create(tournament, currentUserId);
    }
}
