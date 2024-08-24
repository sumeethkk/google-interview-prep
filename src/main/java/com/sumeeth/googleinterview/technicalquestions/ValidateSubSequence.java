package com.sumeeth.googleinterview.technicalquestions;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * <div class="html">
 * <p>
 *   Given two non-empty arrays of integers, write a function that determines
 *   whether the second array is a subsequence of the first one.
 * </p>
 * <p>
 *   A subsequence of an array is a set of numbers that aren't necessarily adjacent
 *   in the array but that are in the same order as they appear in the array. For
 *   instance, the numbers <span>[1, 3, 4]</span> form a subsequence of the array
 *   <span>[1, 2, 3, 4]</span>, and so do the numbers <span>[2, 4]</span>. Note
 *   that a single number in an array and the array itself are both valid
 *   subsequences of the array.
 * </p>
 * <h3>Sample Input</h3>
 * <pre><span class="CodeEditor-promptParameter">array</span> = [5, 1, 22, 25, 6, -1, 8, 10]
 * <span class="CodeEditor-promptParameter">sequence</span> = [1, 6, -1, 10]
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>true
 * </pre>
 * </div>
 */
public class ValidateSubSequence {
    public static void main(String[] args) {
        List<Integer> inputArray = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = Arrays.asList(1, 6, -1, 10);
        System.out.println(isValidSubsequenceV2(inputArray, sequence));

    }

    /**
     * Time COmplextity is O(n+m) as we are iterating only input array and just accessing sequence using index
     * @param array
     * @param sequence
     * @return
     */
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        if (!CollectionUtils.isEmpty(array) && !CollectionUtils.isEmpty(sequence)) {
            int arrInx = 0;
            int seqIdx = 0;

            while (arrInx < array.size() && seqIdx < sequence.size()) {
                if (sequence.get(seqIdx) == array.get(arrInx)) {
                    seqIdx++;
                }
                arrInx++;
                if (seqIdx == sequence.size()) {
                    return true;
                }

            }

        }

        return false;
    }

    /**
     * Time COmplextity is O(n) as we are iterating only input array and just accessing sequence using index
     * @param array
     * @param sequence
     * @return
     */
    public static boolean isValidSubsequenceV2(List<Integer> array, List<Integer> sequence) {
        int seqIdx = 0;
        if (!CollectionUtils.isEmpty(array) && !CollectionUtils.isEmpty(sequence)) {
            for (int val : array) {
                if(seqIdx == sequence.size()){
                    break;
                }
                if (sequence.get(seqIdx) ==val) {
                    seqIdx++;
                }
            }

        }
        return seqIdx == sequence.size();
    }

}
