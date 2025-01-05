package ru.quazar.pokergame;

import ru.quazar.pokergame.enums.Category;
import ru.quazar.pokergame.enums.Rank;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static ru.quazar.pokergame.enums.Category.*;
import static ru.quazar.pokergame.enums.Rank.*;

public record GamerHand(Category category, Rank...  ranks) implements Comparable<GamerHand> {

    public GamerHand checkCategory(ArrayList<Card> cardTemplates) {
        if (cardTemplates.size() != 5) {
            throw new IllegalArgumentException();
        }
        var flush = cardTemplates.stream().map(Card::cardSuit).distinct().count() == 1;
        var counts = cardTemplates.stream().collect(groupingBy(Card::cardRank, counting()));
        var ranks = counts.entrySet().stream().sorted(
                comparing(Map.Entry<Rank, Long>::getValue).thenComparing(Map.Entry::getKey).reversed()
        ).map(Map.Entry::getKey).toArray(Rank[]::new);
        if (ranks.length == 4) {
            return new GamerHand(PAIR, ranks);
        } else if (ranks.length == 3) {
            return new GamerHand(counts.get(ranks[0]) == 2 ? TWO_PAIRS : THREE_OF_KIND, ranks);
        } else if (ranks.length == 2) {
            return new GamerHand(counts.get(ranks[0]) == 3 ? FULL_HOUSE : FOUR_OF_KIND, ranks);
        } else if (ranks[0].ordinal() - ranks[4].ordinal() == 4) {
            return new GamerHand(flush ? STRAIGHT_FLUSH : STRAIGHT, ranks[0]);
        } else if (ranks[0].equals(TEN) && ranks[1].equals(ACE)) { // T-J-Q-K-A
            return new GamerHand(flush ? ROYAL_FLUSH : STRAIGHT_FLUSH, FIVE);
        } else {
            return new GamerHand(flush ? FLUSH : HIGH_CARD, ranks);
        }

    }

    @Override
    public int compareTo(GamerHand that) { // first compare by category, then compare ranks lexicographically
        return comparing(GamerHand::category).thenComparing(GamerHand::ranks, Arrays::compare).compare(this, that);
    }

}
