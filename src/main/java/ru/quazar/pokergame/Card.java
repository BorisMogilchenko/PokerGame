package ru.quazar.pokergame;

import ru.quazar.pokergame.enums.Rank;
import ru.quazar.pokergame.enums.Suit;


public record Card(Rank cardRank, Suit cardSuit) {

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + cardRank +
                ", suit=" + cardSuit +
                '}';
    }

}
