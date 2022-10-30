package Chapter6;

import java.util.ArrayList;

public class Startup {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput); // will return -1 if element is not in the array
        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk " + name + " : ( ");
            } else {
                result = "hit";
            } // end if
        } // end outer if
        return result;
    }
}
