package Arrays.Sliding_Window;

import java.util.HashMap;

public class FruitIntoBaskets {

    public int totalFruit(int[] fruits) {

        
        int i=0;
        int j=0;
    //It would be much better to use an array instead of a HashMap
        HashMap<Integer, Integer> map=new HashMap<>();

        int maxFruits=0;

        while(j<fruits.length){

            map.putIfAbsent(fruits[j], 0);
            map.put(fruits[j], map.get(fruits[j])+1);

            if(map.size()<=2){
                maxFruits=Math.max(maxFruits, j-i+1);

            }
            else if(map.size()>2){
                while(map.size()>2){
                    if(map.get(fruits[i])==1){
                        map.remove(fruits[i]);
                    }else{
                        map.put(fruits[i], map.get(fruits[i])-1);
                    }

                    i++;
                }

                maxFruits=Math.max(maxFruits, j-i+1);
            }


            j++;

        }

        return maxFruits;

    }

}
