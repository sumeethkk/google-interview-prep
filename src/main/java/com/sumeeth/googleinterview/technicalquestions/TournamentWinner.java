package com.sumeeth.googleinterview.technicalquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

/**
 * <div class="html">
 * <p>
 *   There's an algorithms tournament taking place in which teams of programmers
 *   compete against each other to solve algorithmic problems as fast as possible.
 *   Teams compete in a round robin, where each team faces off against all other
 *   teams. Only two teams compete against each other at a time, and for each
 *   competition, one team is designated the home team, while the other team is the
 *   away team. In each competition there's always one winner and one loser; there
 *   are no ties. A team receives 3 points if it wins and 0 points if it loses. The
 *   winner of the tournament is the team that receives the most amount of points.
 * </p>
 * <p>
 *   Given an array of pairs representing the teams that have competed against each
 *   other and an array containing the results of each competition, write a
 *   function that returns the winner of the tournament. The input arrays are named
 *   <span>competitions</span> and <span>results</span>, respectively. The
 *   <span>competitions</span> array has elements in the form of
 *   <span>[homeTeam, awayTeam]</span>, where each team is a string of at most 30
 *   characters representing the name of the team. The <span>results</span> array
 *   contains information about the winner of each corresponding competition in the
 *   <span>competitions</span> array. Specifically, <span>results[i]</span> denotes
 *   the winner of <span>competitions[i]</span>, where a <span>1</span> in the
 *   <span>results</span> array means that the home team in the corresponding
 *   competition won and a <span>0</span> means that the away team won.
 * </p>
 * <p>
 *   It's guaranteed that exactly one team will win the tournament and that each
 *   team will compete against all other teams exactly once. It's also guaranteed
 *   that the tournament will always have at least two teams.
 * </p>
 * <h3>Sample Input</h3>
 * <pre><span class="CodeEditor-promptParameter">competitions</span> = [
 *   ["HTML", "C#"],
 *   ["C#", "Python"],
 *   ["Python", "HTML"],
 * ]
 * <span class="CodeEditor-promptParameter">results</span> = [0, 0, 1]
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>"Python"
 * <span class="CodeEditor-promptComment">// C# beats HTML, Python Beats C#, and Python Beats HTML.</span>
 * <span class="CodeEditor-promptComment">// HTML - 0 points </span>
 * <span class="CodeEditor-promptComment">// C# -  3 points</span>
 * <span class="CodeEditor-promptComment">// Python -  6 points</span>
 * </pre>
 * </div>
 */
public class TournamentWinner {


    public static void main(String[] args) {
        List<List<String>> competitions = new ArrayList();
        competitions.add(Arrays.asList("A","B"));
        competitions.add(Arrays.asList("B","C"));
        competitions.add(Arrays.asList("A","C"));
        competitions.add(Arrays.asList("A","D"));
        competitions.add(Arrays.asList("D","B"));
        competitions.add(Arrays.asList("D","F"));
        competitions.add(Arrays.asList("D","K"));

        List<Integer> results = Arrays.asList(1,0,0,1,1,1,1);

        System.out.println("Match happened among: "+competitions);
        System.out.println("Match Results: "+competitions);
        System.out.println("Tournament Winner is ..... Team:"+tournamentWinner(competitions,results));

    }

    public static String tournamentWinner(List<List<String>> competitions, List<Integer> results) {
        if(competitions.size() != results.size()){
            throw new RuntimeException("Some competitions results are missing");
        }
        // Write your code here.
        int winningPoint=3;
        AtomicReference<String> tournamentWinner = new AtomicReference<>("");
        HashMap<String, Integer> teamWin = new HashMap<String, Integer>();
        teamWin.put(tournamentWinner.get(),0);
        IntStream.range(0, competitions.size())
                .forEach(index -> {
                    String matchWinner="";
                    matchWinner = results.get(index) == 1 ?competitions.get(index).get(0):competitions.get(index).get(1);
                    //check existing  team win count
                    if (teamWin.get(matchWinner) != null) {
                        int currWin = teamWin.get(matchWinner);
                        teamWin.put(matchWinner, winningPoint+currWin);
                    } else {
                        teamWin.put(matchWinner, winningPoint);
                    }

                    if(teamWin.get(matchWinner) > teamWin.get(tournamentWinner.get()) ){
                        tournamentWinner.set(matchWinner);
                    }

                });



        return tournamentWinner.get();
    }

}
