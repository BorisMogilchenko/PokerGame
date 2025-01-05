package ru.quazar.pokergame;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static ru.quazar.pokergame.GamerHand.*;

public class PokerHand implements Comparable<PokerHand> {

    private final String hand;

    public PokerHand(String hand) {
        this.hand = hand;
    }

    public <hand> GamerHand gamerCards(ArrayList<hand>) {

        var pokerHands = new GamerHand;

        return pokerHands.checkCategory(ArrayList<hand>);
    }

    static <T, K, D, A, M extends Map<K, D>> Collector<T, ?, M>
    groupingBy(Function<? super T, ? extends K> classifier, Supplier<M> mapFactory,
               Collector<? super T, A, D> downstream)

    Map<String, String> cityToCountry = Map.of("Paris", "France", "Nice", "France", "Madrid", "Spain");

    Map<String, Set<String>> countryToCities = cityToCountry
            .entrySet()
            .stream()
            .collect(Collectors.groupingBy(Map.Entry::getValue, LinkedHashMap::new, Collectors.mapping(Map.Entry::getKey, Collectors.toSet())));

    assertThat(countryToCities)
  .isExactlyInstanceOf(LinkedHashMap .class)
  .containsOnly(entry("France", Set.of("Paris", "Nice")), entry("Spain",Set.of("Madrid")));


    @Override
    public String toString() {
        return "PokerHand[" +
                "pokerHand = " + hand + ']';
    }

    @Override
    public int compareTo(PokerHand o) {
        return 0;
    }
}
