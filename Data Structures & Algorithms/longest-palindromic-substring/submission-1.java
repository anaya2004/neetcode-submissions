//isko krne se pehle palindromic substring ka solution 2 dekho

class Solution {
    private String countPalindrome(String s,int c1,int c2,boolean isOdd){
        String ans = "";
        int i; int j;
        if(isOdd){
            ans = ans + s.charAt(c1);
            i = c1-1;
            j= c1+1;
        }else{
            i = c1;
            j = c2;
        }

        while(i>=0 && j<s.length()){
            if(s.charAt(i) == s.charAt(j)){
                ans = s.charAt(i) + ans + s.charAt(j);
                i--;
                j++;
            }else{
                break;
            }
        }
        return ans;
    }
    public String longestPalindrome(String s) {
        String res = "";

        for(int i = 0;i<s.length();i++){
            //taking i as a centre for both odd and even length Strings
            String odd = countPalindrome(s,i,i,true);     //sending true so that the function knows we are tracking odd length string with centra character as i
            String even = countPalindrome(s,i,i+1,false);

            if(odd.length()>=even.length()){
                if(res.length()<odd.length()){
                    res = odd;
                }
            }else{
                if(res.length()<even.length()){
                    res = even;
                }
            }
        }
        return res;
    }
}
