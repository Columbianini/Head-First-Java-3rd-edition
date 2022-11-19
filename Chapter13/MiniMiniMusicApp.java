package Chapter13;

import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*; //We're using a static import here so we can use the constants in the ShortMessage class

public class MiniMiniMusicApp{
    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }

    public void play(){
        try{
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();

            ShortMessage msg1 = new ShortMessage(); // Make a message
            msg1.setMessage(NOTE_ON, 1, 44, 100); // The message type is NOTE_ON, the channel is 3 (e.g. Drum Note or Piano Note), the note is 44 (0-127), and the velocity is 100 (0 is soft that you barely hear anything)
            MidiEvent noteOn  = new MidiEvent(msg1, 100); // Duration of the msg1
            track.add(noteOn);

            ShortMessage msg2 = new ShortMessage();
            msg1.setMessage(NOTE_OFF, 1, 44, 100);
            MidiEvent noteOff  = new MidiEvent(msg2, 16);
            track.add(noteOff);

            player.setSequence(seq);

            player.start();
        } catch (Exception e){
            e.printStackTrace();
        }  
    }
}