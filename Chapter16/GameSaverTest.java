package Chapter16;
import java.io.*;
public class GameSaverTest {
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Elf", new String[]{"bow", "sword", "dust"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[]{"bare hands", "big ax"});
        GameCharacter three = new GameCharacter(120, "Magician", new String[]{"spells", "invisibility"});

        try {
            FileOutputStream fs = new FileOutputStream("Game.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            // TODO: handle exception
        }

        try {
            FileInputStream fs = new FileInputStream("Game.ser");
            ObjectInputStream os = new ObjectInputStream(fs);
            one = (GameCharacter) os.readObject();
            two = (GameCharacter) os.readObject();
            three = (GameCharacter) os.readObject();
            os.close();
            
            System.out.println("One's type is " + one.getType());
            System.out.println("Two's type is " + two.getType());
            System.out.println("Three's type is " + three.getType());


        } catch (Exception ex) {
            ex.printStackTrace();
            // TODO: handle exception
        }
    }
}
