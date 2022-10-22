import java.util.ArrayList;

public class SimpleStartup{
    ArrayList<Integer> locationCells;
    String checkYourself(int guess){
        String result = "missed";
        if(locationCells.contains(guess)){
            int index = locationCells.indexOf(guess);
            locationCells.remove(index);
            result = locationCells.isEmpty()?"kill":"hit";
        }
        System.out.println(result);
        return result;
    }

    void setLocationCells(ArrayList<Integer> loc){
        locationCells = loc;
    }
}