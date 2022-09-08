package com.sdet;

public class StringProbs {
	public static void main(String[] args) {
		
		String text="aaBBa@";
		System.out.println(checkPalindrome(text));
		
	
	}
    public static char toLowerCase(char ch){
        char temp = (char) (ch - 'A' + 'a');
            return temp;
    }
    
	public static boolean checkPalindrome(String str) {
        StringBuilder s1= new StringBuilder("");
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);           
            if (ch>='a' && ch<='z')
                s1.append(ch);
            if (ch>='A' && ch<='Z')
                s1.append(toLowerCase(ch));
            if (ch>='0' && ch<='9')
                s1.append(ch);
        }
        System.out.println(s1);
        System.out.println(s1.reverse());
        if(s1 == (s1.reverse()))
            return true;
        else
            return false;      	 
	}



}
