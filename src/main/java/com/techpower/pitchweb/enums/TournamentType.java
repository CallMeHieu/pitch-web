package com.techpower.pitchweb.enums;

public enum TournamentType {
    TOURNAMENT_5VS5_FUTSAL("Giải bóng đá 5 người - futsal"),
    TOURNAMENT_5VS5("Giải bóng đá phủi 5 người"),
    TOURNAMENT_7VS7("Giải bóng đá phủi 7 người"),
    TOURNAMENT_8VS8("Giải bóng đá phủi 8 người"),
    TOURNAMENT_11VS11("Giải bóng đá 11 người");
    private final String value;

    TournamentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
