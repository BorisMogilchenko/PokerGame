package ru.quazar.pokergame;

import ru.quazar.pokergame.enums.Rank;
import ru.quazar.pokergame.enums.Suit;

import java.util.ArrayList;
import java.util.List;

public class CardParser {

    public ArrayList<Card> gamerCards(String hand) {
        List<String> cardsWithHand = List.of(hand.split(" "));
        if (cardsWithHand.size() != 5) {
            throw new IllegalArgumentException("Invalid constructor argument");
        }

        ArrayList<Card> result = new ArrayList<>();
        for (String card : cardsWithHand) {
            result.add(CardParser.parserString(card));
        }

        return result;
    }

    private static Card parserString(String card) {

        var patternRank = card.charAt(0);
        var patternSuit = card.charAt(1);

        Rank rank;
        if (Character.isDigit(patternRank)) {
            var number = Character.getNumericValue(patternRank);
            if (number < 2 || number > 9) {
                throw new IllegalArgumentException("Invalid card nominal");
            } else {
                rank = Rank.values()[number - 2];
            }
        } else {
            switch (patternRank) {
                case 'T' -> rank = Rank.TEN;
                case 'J' -> rank = Rank.JACK;
                case 'Q' -> rank = Rank.QUEEN;
                case 'K' -> rank = Rank.KING;
                case 'A' -> rank = Rank.ACE;
                default -> throw new IllegalArgumentException("Invalid card nominal");
            }
        }
        Suit suit = Suit.findByName(patternSuit);
        if (suit == null) {
            throw new IllegalArgumentException("Invalid card suit");
        }
        return new Card(rank, suit);
    }
}
