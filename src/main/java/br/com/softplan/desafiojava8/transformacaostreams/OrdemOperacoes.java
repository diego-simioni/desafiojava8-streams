package br.com.softplan.desafiojava8.transformacaostreams;

import java.util.stream.Stream;

public class OrdemOperacoes {

    public static void main(String[] args) {
        Stream.of("abacaxi", "banana", "melão", "acerola", "manga", "uva", "abacate")
              .filter(a -> {
                  System.out.println("filter: " + a);
                  return a.startsWith("a");
              })
              .sorted((a, b) -> {
                  System.out.println("sorted: " + a + " " + b);
                  return a.compareTo(b);
              })
              .map(s -> {
                  System.out.println("map: " + s);
                  return s.toUpperCase();
              })
              .forEach(s -> System.out.println("forEach: " + s));
    }

}
