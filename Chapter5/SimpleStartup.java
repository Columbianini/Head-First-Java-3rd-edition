public class SimpleStartup{
    int[] locationCells;
    int numOfHits = 0;

    String checkYourself(int guess){
        String result = "missed";
        for (int i : locationCells) {
            if(i==guess){
                numOfHits++;
                if (numOfHits == 3){
                    result = "kill";
                    break;
                }else{
                    result = "hit";
                    break;
                }
            }
        }
        System.out.println(result);
        return result;
    }

    void setLocationCells(int[] loc){
        locationCells = loc;
    }
}