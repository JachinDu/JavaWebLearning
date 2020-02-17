public class Solution {
    public boolean isNumeric(char[] str) {
        int len = str.length;
        boolean hasDot = false;
        for(int i = 0; i < len; i++){
            if(str[i] == '+' || str[i] == '-'){
                if((!hasDot || str[i-1] == 'e' || str[i-1] == 'E')
                        && i + 1 < len && str[i+1] >= 0
                        && str[i+1] <= 9){
                    continue;
                }else{
                    return false;
                }
            }else if(str[i] == 'e' || str[i] == 'E'){
                if(i + 1 < len && ((str[i+1] >= 0 && str[i+1] <= 9)
                        || str[i+1] == '+' || str[i+1] == '-')){
                    continue;
                }else{
                    return false;
                }
            }else if(str[i] == '.'){
                if(!hasDot && i + 1 < len){
                    hasDot = true;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}