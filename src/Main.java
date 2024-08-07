import java.util.*;

public class Main {
    public static void main(String[] args) {
        //initialize value
        String array[] = new String[]{"Abc","bCd"};

        //initialize value
        String anotherArray[] = new String[]{"Pendanaan","Terproteksi","Untuk","Dampak","Berarti"};

        //use method
        System.out.println(groupByMostFrequent(array));
        System.out.println(groupByMostFrequent(anotherArray));
    }

    public static String groupByMostFrequent(String[] array){
        //initialize result to return
        String result = "";

        //make a new hashmap
        HashMap<String, Integer> strMap = new HashMap<>();

        //Add individual characters and then add those to strMap using the put method
        for(String arr: array){
            //ini to charArr[]
            char charArr[] = arr.toCharArray();
            //loop each characters
            for (int i=0; i<charArr.length; i++){
                //if character is available then +1 if its not then add them both (char, +1)
                strMap.put(String.valueOf(charArr[i]), strMap.getOrDefault(String.valueOf(charArr[i]),0) +1);
            }
        }

        //put hashmap to arraylist because hashmap cannot get index
        ArrayList<Map.Entry<String, Integer>> tempSort= new ArrayList<>(strMap.entrySet());

        //use bubble sort
        for (int i=0; i< tempSort.size()-1;i++){
            for (int j=0; j<tempSort.size()-j-1;j++){
                if (tempSort.get(j).getValue() < tempSort.get(j+1).getValue() || (tempSort.get(j).getValue().equals(tempSort.get(j+1).getValue()) && tempSort.get(j).getKey().compareTo(tempSort.get(j+1).getKey()) > 0)) {
                    //Swap using collections library
                    Collections.swap(tempSort, j, j + 1);
                }
            }
        }

        //Add all of those to the result string
        for (int i=0;i<tempSort.size();i++){
            result += tempSort.get(i).getKey();
        }
        return result;
    }
}
