package com.sumeeth.googleinterview.concepts.ds.trees;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Graph {

    private static class FxRate {
        String toCurrency;
        BigDecimal fxRate;

        public FxRate(String toCurrency, BigDecimal fxRate) {
            this.toCurrency = toCurrency;
            this.fxRate = fxRate;
        }

        public static BigDecimal inverseRate(BigDecimal fxRate) {
            return BigDecimal.ONE.divide(fxRate, 6, RoundingMode.HALF_DOWN);
        }

        @Override
        public String toString() {
            return "FxRate{" +
                    "toCurrency='" + toCurrency + '\'' +
                    ", fxRate=" + fxRate +
                    '}';
        }
    }

    public static void main(String[] args) {
        String fromCurr = "USD";
        String toCurr = "GBP";
        List<List<Object>> fxRates = Arrays.asList(
                Arrays.asList("USD", "JPY", 136.25),
                Arrays.asList("JPY", "AUD", 0.011),
                Arrays.asList("AUD", "GBP", 0.57),
                Arrays.asList("USD", "INR", 79.07),
                Arrays.asList("INR", "EUR", 0.012),
                Arrays.asList("EUR", "GBP", 0.86)
        );
        Map<String, List<FxRate>> g = createGraph(fxRates);
        printGraph(g);
        System.out.println("Find fxRate from " + fromCurr + " toCurr " + toCurr + " is: " + findFxRate(fromCurr, toCurr, g));
    }

    public static BigDecimal findFxRate(String fromCurr, String toCurr, Map<String, List<FxRate>> graph) {
        return findFxRate(fromCurr, toCurr, BigDecimal.ONE, graph, new HashSet<>());
    }

    private static BigDecimal findFxRate(String fromCurr, String toCurr, BigDecimal calcFxRate, Map<String, List<FxRate>> graph, Set<String> visitedCurrency) {
        if (visitedCurrency.contains(fromCurr)) {
            System.out.println("Already visited :" + fromCurr + " returning fxrate: " + calcFxRate);
            return calcFxRate;
        } else {
            System.out.println("Visiting :" + fromCurr);
            visitedCurrency.add(fromCurr);
            for (FxRate rate : graph.get(fromCurr)) {
                if (!visitedCurrency.contains(rate.toCurrency)) {
                    if (rate.toCurrency == toCurr) {
                        System.out.println("findFxRate found:" + rate.toCurrency + "->" + toCurr + " :" + calcFxRate + "X" + rate.fxRate);
                        return calcFxRate.multiply(rate.fxRate);
                    } else {
                        System.out.println("findFxRate :" + rate.toCurrency + "->" + toCurr + " :" + calcFxRate + "X" + rate.fxRate);
                        return findFxRate(rate.toCurrency, toCurr, calcFxRate.multiply(rate.fxRate), graph, visitedCurrency);
                    }
                }
            }
        }
        return BigDecimal.ZERO;
    }

    public static void printGraph(Map<String, List<FxRate>> g) {
        g.entrySet().stream().forEach(entry -> {
            System.out.println("Key: " + entry.getKey() + " values: " + entry.getValue());
        });
    }

    public static Map<String, List<FxRate>> createGraph(List<List<Object>> fxRates) {
        Map<String, List<FxRate>> fxMap = new HashMap<>();
        fxRates.stream().forEach(entry -> {
            if (fxMap.containsKey(entry.get(0))) {
                List<FxRate> r = fxMap.get(entry.get(0));
                r.add(new FxRate(String.valueOf(entry.get(1)), (BigDecimal.valueOf((Double) entry.get(2)))));
                fxMap.put(String.valueOf(entry.get(0)), r);
            } else {
                List<FxRate> r = new ArrayList<>();
                r.add(new FxRate(String.valueOf(entry.get(1)), (BigDecimal.valueOf((Double) entry.get(2)))));
                fxMap.put(String.valueOf(entry.get(0)), r);
            }

            //reverse entry
            if (fxMap.containsKey(entry.get(1))) {
                List<FxRate> r = fxMap.get(entry.get(1));
                r.add(new FxRate(String.valueOf(entry.get(0)), FxRate.inverseRate((BigDecimal.valueOf((Double) entry.get(2))))));
                fxMap.put(String.valueOf(entry.get(1)), r);
            } else {
                List<FxRate> r = new ArrayList<>();
                r.add(new FxRate(String.valueOf(entry.get(0)), FxRate.inverseRate((BigDecimal.valueOf((Double) entry.get(2))))));
                fxMap.put(String.valueOf(entry.get(1)), r);
            }

        });
        return fxMap;
    }
}
