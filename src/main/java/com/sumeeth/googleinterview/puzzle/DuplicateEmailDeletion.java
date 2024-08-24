package com.sumeeth.googleinterview.puzzle;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Problem Statement –
 * The principal has a problem with repetitions.
 * Everytime someone sends the same email twice he becomes angry and starts yelling.
 * His personal assistant filters the mails so that all the unique mails are sent only once,
 * and if there is someone sending the same mail again and again, he deletes them.
 * Write a program which will see the list of roll numbers of the student and
 * find how many emails are to be deleted.
 * <p>
 * Sample Input:
 * 6
 * 1
 * 3
 * 3
 * 4
 * 3
 * 3
 * <p>
 * Sample Output:
 * 3
 */
public class DuplicateEmailDeletion {
    public static void main(String[] args) {
        List<Integer> roleList = List.of(6, 1, 3, 3, 4, 4, 4, 3, 3, 3);
        System.out.println("deleted :" + findNumberOfEmailsTobeDeleted(roleList));
    }

    private static Long findNumberOfEmailsTobeDeleted(List<Integer> roleList) {
        Map<Integer, Long> freqMap = roleList.stream()
                .collect(Collectors.groupingBy(Function.identity()
                        , Collectors.counting()));

        return freqMap.values().stream().filter(i -> i > 1).map(i -> i - 1)
               .reduce(0L, Long::sum);

    }
}
