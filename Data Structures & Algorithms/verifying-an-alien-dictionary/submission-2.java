class Solution {
    private boolean isInSequence(String first, String second, HashMap<Character,Integer> map){
        //yahan hm check kr rhe hain ki first word or second word sequence mai ya nhi
        //agar same character hai to skip, first ka character chhota hai to return true else false
        //one more thing , agar first word neetcode hai or second neet then false or agar first word neet or second neetcode to true
        int i =0;
        for(i = 0;i<Math.min(first.length(),second.length());i++){
            if(map.get(first.charAt(i)) == map.get(second.charAt(i))){
                continue;
            }else if(map.get(first.charAt(i)) < map.get(second.charAt(i))){
                return true;
            }else{
                return false;
            }
        }
        if(i<first.length()){
            return false;
        }
        if(i<second.length()){
            return true;
        }
        return false;
    }
    public boolean isAlienSorted(String[] words, String order) {
        //dekho ye transitive property hold krega, if a & b and b & c are in seqqunce then a and c must be in the sequence
        //isliye hm do words ko compare krenge 
        //compare krne k liye we need ki first word ka kth char second word k kth char k pehle aana chaiye
        //iske liye hme hashmap mai order k char and their indexes rekhnge
        

        //storing char in order with their index
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        int first = 0;
        int second = 1;

        while(second<words.length){
            boolean ans = isInSequence(words[first],words[second],map);
            System.out.println(words[first]+" "+words[second]+" "+ans);
            if(!ans) return false;
            first++;
            second++;
        }
        return true;
    }
}