package com.coding.strings;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //String S = "madam";
        //System.out.println(isPalindrome(S));
        //String S2 = "5?36@6?35";
        //isPalindrome2(S2);
        //String S = "ebeebserrtrerr";
        //System.out.println(getMaxOccuringChar(S));
        //StringBuilder S = new StringBuilder("Hello World");
        //System.out.println(replaceSpaces(S));
        //System.out.println(checkIsPermutation("ab","eidboaoo"));
        //String ans = removeDuplicates("abbaca");
        //System.out.println(ans);
        //char[] c = {'a','b','b','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c'};
        //System.out.println(stringCompress(c));
        //System.out.println(isAnagram("rat", "tatr"));
        //System.out.println(reverseWords("the sky is blue"));
        //System.out.println(isSubsequence("abc","ahbgdc"));
        //String S1 = "takeyouforward";
        //System.out.println(firstRepeating(S1.toCharArray()));
        //System.out.println(removeOccurrences("daabccbaabcbc","abc"));
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
    }
    public static boolean isPalindrome(String S){
        char[] arr = S.toCharArray();
        int s=0;
        int e=arr.length -1;
        while (s<e){
            if(arr[s] != arr[e])
                return false;
            s++;e--;
        }
        return true;
    }
    static void isPalindrome2(String S){
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if((ch>='a' && ch<='z') || (ch>='0' && ch<='9'))
                sb.append(ch);
            if (ch>='A' && ch<='Z')
                sb.append(toLowerCase(ch));
        }
        boolean ans = isPalindrome(sb.toString());
        System.out.println(ans);
    }

    private static char toLowerCase(char ch) {
        return (char) (ch-'A'+'a');
    }

    public static void reverse(char[] arr){
        int s=0;
        int e=arr.length;
        while (s<e){
            char temp = arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;e--;

        }

    }
    static char getMaxOccuringChar(String S){
        int arr[] = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int num = ch - 'a';
            arr[num]++;
        }
        int maxCount=-1;//stores max count value in that index
        int ans=-1;//stores index of array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxCount){
                ans=i;
                maxCount=arr[i];
            }
        }
        char finalAns = (char) ('a'+ans);
        return finalAns;
    }
    static boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length())
            return false;
        int[] map1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
             map1[c-'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            map1[c-'a']--;
        }
        for(int e:map1){
            if(e != 0)
                return false;
        }
        return true;

    }
    public static StringBuilder replaceSpaces(StringBuilder str) {
        // Write your code here.
        int spaceCount = 0;

        // Count Number of Spaces.
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceCount = spaceCount + 1;
            }
        }
        // Store thr current length of the string in a variable.
        int oldLength = str.length();

        // Find the new length.
        int newLength;
        newLength = oldLength + (spaceCount * 2);
        // Resize the current string.

        for (int i = 0; i < newLength - oldLength; i++) {
            str.append(' ');
        }
        // Index to end of string.
        int index = newLength - 1;

        // Fill string from end.
        for (int k = oldLength - 1; k >= 0; k--) {
            if (str.charAt(k) == ' ') {
                str.setCharAt(index, '0');
                str.setCharAt(index - 1, '4');
                str.setCharAt(index - 2, '@');
                index = index - 3;
            }
            else {
                str.setCharAt(index, str.charAt(k));
                index = index - 1;
            }
        }

        return str;
    }
    //replace spaces with %20
    public static String replaceSpaces2(String S){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if(ch == ' ')
                sb.append("%20");
            else
                sb.append(ch);
        }
        return sb.toString();
    }
    static boolean checkIsPermutation(String s1,String s2){
        if(s1.length()>s2.length())
            return false;
        //first make map of characters in s1
        int[] map1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map1[c-'a']++;
        }
        //Make a sliding window of size s1 and check if same char array for both s1,s2
        int i = 0;
        int[] map2 = new int[26];
        int windowSize = s1.length();
        //process 1st window for s2
        while (i<windowSize){
            int index = s2.charAt(i)-'a';
            map2[index]++;
            i++;
        }
        //check for 1st window
        if(checkEqual(map1, map2))
            return true;
        //now remove 1st index in previous window and add current index of current window
        while (i<s2.length()){
            char newChar = s2.charAt(i);
            map2[newChar-'a']++;


            char oldChar = s2.charAt(i-windowSize);
            map2[oldChar-'a']--;
            i++;
            if(checkEqual(map1, map2))
                return true;
        }
        return false;
    }

    public static String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<Character>();
        int n = s.length();
        int m = part.length();

        for (int i = 0; i < n; i++){
            stack.add(s.charAt(i));
            if (stack.size() >= m){
                String l = "";
                for (int j = m - 1; j >= 0; j--){
                    if (part.charAt(j) != stack.peek()){
                        int f = 0;
                        while (f != l.length()){
                            stack.add(l.charAt(f));
                            f++;
                        }
                        break;
                    }
                    else{
                        l = stack.peek() + l;
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.peek());
            stack.pop();
        }
        sb.reverse();
        return sb.toString();
    }
    public String removeOccurrences2(String s, String part) {
        while(s.length()!=0 && s.contains(part)){
            s= s.replaceFirst(part,"");
        }
        return s;
    }
    static boolean checkEqual(int a[] ,int b[]) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i])
                return false;

        }
        return true;
    }

    static String reverseWords(String S){
        ArrayDeque<String> st = new ArrayDeque<>();
        for(String a: S.trim().split(" ")){
            if(!a.isEmpty()){
                st.push(a);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()){
            sb.append(st.pop());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    static boolean isSubsequence(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();

        int ptr1=0;
        int ptr2=0;

        while(ptr1<len1 && ptr2<len2){
            if(s1.charAt(ptr1)==s2.charAt(ptr2))
                ptr1++;
            ptr2++;
        }
        return ptr1==len1;
    }

    static String removeDuplicates(String s) {
        char[] c = s.toCharArray();
        int i=0;
        int n=s.length();
        for (int j = 0; j < n; j++,i++) {
            c[i]=c[j];
            if(i>0 && c[i-1]==c[i])//delete the 2 same chars
                i-=2;
        }
        return new String(c,0,i);
    }
    //remove duplicates from string
    public static String removeDuplicates2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(sb.length() == 0 || sb.charAt(sb.length()-1) != ch)
                sb.append(ch);
        }
        return sb.toString();
    }

    static int firstRepeating(char[] str) {
        int[] firstIndex = new int[256];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < str.length; i++) {
            firstIndex[str[i]]++;
        }
        for (int i = 0; i < str.length; i++) {
            if (firstIndex[str[i]] > 1) {
                return i;
            }
        }
        return -1;
    }
    //first repeating character
    public static int firstRepeating2(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(freq[ch-'a'] > 1)
                return i;
        }
        return -1;
    }
    static int stringCompress(char[] c){
        int index=0, count=0;
        for (int i = 0; i < c.length; i++) {
            count++;
            // We keep note of number of characters in sequence.
            /* When the next character is not as same as the previous one,
             * we modify the array from the beginning with the current character.
             * Note that the array will only become shorter as we keep updating the data.
             * So there is no need to create another array.
             */
            if( i+1==c.length || c[i] != c[i+1]){
                c[index++]=c[i];
                // If there are multiple characters, we add the number to the array.
                if (count != 1) {
                    for (char ch : Integer.toString(count).toCharArray()) {
                        c[index++] = ch;
                    }
                }
                // We initialize count to zero for the next character check.
                count = 0;
            }
        }
        return index;
    }
    //code for finding length of longest substring without repeating characters
    static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    //code to Check if strings are rotations of each other or not
    static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String temp = s1 + s1;
        return temp.contains(s2);
    }
}
