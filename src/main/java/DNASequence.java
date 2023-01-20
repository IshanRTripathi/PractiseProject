/*
The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences
(substrings) that occur more than once in a DNA molecule. You may return the answer in any order.



Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]

* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DNASequence {
    public static void main(String[] args) {
        var response1 = repeatingDNASequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(response1);
        var response2 = repeatingDNASequences("AAAAAAAAAAAAA");
        System.out.println(response2);
    }

    static List<String> repeatingDNASequences(String dna) {
        if(dna.isBlank() || dna.length() < 10) {
            return null;
        }
        Set<String> set = new HashSet<>();
        Set<String> response = new HashSet<>();
        int l = 0, r = 10;
        while(r<dna.length()) {
            String currentSubstring = dna.substring(l, r);
            if(set.contains(currentSubstring) && !response.contains(currentSubstring)) {
                response.add(currentSubstring);
            } else {
                set.add(currentSubstring);
            }
            r++;
            l++;
        }
        return new ArrayList<>(set);
    }
}
