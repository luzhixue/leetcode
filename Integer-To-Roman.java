public class Solution {
    public String intToRoman(int num) {
        int[] scales = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        HashMap<Integer, String> dict = getDict();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < scales.length; i++){
            if(scales[i] > num) continue;
            while(scales[i] <= num){
                sb.append(dict.get(scales[i]));
                num -= scales[i];
            }
            if(num == 0) break;
        }
        return sb.toString();
    }
    
    public HashMap<Integer, String> getDict(){
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        return map;
    }
}
