package com.sumeeth.googleinterview.concepts.ds.array;

/**
 * 2 players A and B take turns alternatively to play a game in which they have N numbers on a paper.
 * <p>In one turn, a player can replace one of the numbers by any of its factor (except for 1 & the number itself).</p>
 * <p>The player who is unable to make a move looses the game. Find the winner of the game if A starts the game and both play optimally.</p>
 *
 * Input: nums = [5, 7, 3]
 * Output: B
 * Explanation: Since all the numbers are prime,
 * so A will not be able to make the first move.
 *
 * Input: nums = [2, 4, 7, 11]
 * Outptut: A
 * Explanation: In the first move A will replace 4
 * by 2, so the numbers will become [2, 2, 7, 11]
 * now B will not be able to make a move since all
 * the remaining numbers can only be divided by 1
 * or the number itself.
 */
public class BrainGame {

    public static void main(String[] args) {
//        int [] nums = new int[]{5,7,3};
        int [] nums = new int[]{2, 4, 7, 11};
        System.out.println(isAWinner(nums) ?" A is winner":"B is winner");
    }

    private static boolean isAWinner(int[] moves) {
        boolean isAMove = true;
        int i=0;
        int move=0;
        while(i< moves.length){
            move=findFirstFactor(moves[i]);
            if(isAMove){
                if(move < 1) return false;
            }else{
                if(move < 1) return true;
            }
            isAMove=!isAMove;

        }
        return isAMove ? true:false; //by default A is winner

    }

    private static int findFirstFactor(int num){
        for(int i=2; i< num;i++){
            if(num %i ==0)return i;
        }
        return -1;

    }
}
