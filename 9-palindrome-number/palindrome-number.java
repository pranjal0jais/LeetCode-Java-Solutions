class Solution {
    public boolean isPalindrome(int x) {
        int temp = x, n = 0;
        if(x < 0 || (x != 0 && x%10 == 0)){
            return false;
        }
        else{
            while(temp != 0){
                n = n*10 + temp%10;
                temp /= 10;
            }
            if(x == n){
                return true;
            }
            else{
                return false;
            }
        }
    }
}