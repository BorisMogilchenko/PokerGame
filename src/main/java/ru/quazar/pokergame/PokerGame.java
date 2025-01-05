package ru.quazar.pokergame;

import java.util.*;
import java.util.Collections;
import ru.quazar.pokergame.enums.Category;

public class PokerGame {

    public static void main(String[] args) {

        List<PokerHand> hands = new ArrayList<>();

        hands.add(new PokerHand("KS 2H 5C JD TD"));
        hands.add(new PokerHand("2C 3C AC 4C 5C"));
        hands.add(new PokerHand("KD AD QD JD TD"));
        hands.add(new PokerHand("TS KS AS JS QS"));


        public Map<Category, ArrayList<Card>> getGamerCombination() {
            var gamerHands =
            var pokerHand = new CardParser();
            Map<Category, ArrayList<Card>> categoryMap = new LinkedHashMap<>();

            Map<Category, ArrayList<Card>> gamerHands =

            return gamerHands;
        }

        private Map<Category, ArrayList<Card>> sortGamerHands() {

            Category[] categories = Category.values();
            for (Category category : categories) {
                categoryMap.put(category, null);
            }

            return categoryMap;
        }

        Collections.sort(hands);
        System.out.println(hands);
    }
}
