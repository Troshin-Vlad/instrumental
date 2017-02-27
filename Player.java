import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.HashMap;
import java.util.Map;

public class Player {

    public static final int CHANNEL_DEFAULT = 0;
    public Map<Integer, String> instruments = new HashMap(128);

    private Synthesizer synthesizer = null;
    private MidiChannel[] channels = null;
    private int timeout = 1500;
    private String instrument = "Celesta";

    public Player(){
        try {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            channels = synthesizer.getChannels();
            initInstruments();

            changeInstrument(0, instrument);
        }
        catch(MidiUnavailableException err){
            err.printStackTrace();
        }
    }

    public boolean changeInstrument(int channel, String instrument){
        int instr = 41;
        boolean have = false;

        for(Map.Entry item : instruments.entrySet()){
            if(instrument.equals(item.getValue())){
                changeInstrument(0, (int) item.getKey() );
                this.instrument = instrument;
                have = true;
            }
        }

        return have;
    }

    public boolean changeInstrument(int channel, int newInstrument){
        if( (newInstrument >= 1) && (newInstrument <= 128) ){
            channels[channel].programChange(newInstrument);
            return true;
        }
        else{
            return false;
        }
    }

    public void playMusic(int note){
        playMusic(note, this.timeout);
    }

    public void playMusic(int note,int sleep){
        playMusic(CHANNEL_DEFAULT, note, sleep,90);
    }

    public void playMusic(int chan, int note, int sleep, int vel){
        channels[chan].noteOn(note,vel);

        try {
            Thread.sleep(sleep);
        }
        catch(InterruptedException err){
            err.printStackTrace();
        }

        channels[chan].noteOff(note);
    }

    public String getInstrument(){
        return this.instrument;
    }

    public void setTimeout(int value){
        this.timeout = value;
    }

    public int getTimeout(){
        return this.timeout;
    }

    public void close(){
        if(synthesizer != null) {
            synthesizer.close();
        }
    }

    public void displayInstruments(){
        for(Map.Entry item : instruments.entrySet()){
            System.out.println(" " + item.getValue());
        }
    }

    public void initInstruments(){
        instruments.put(1, "Acoustic piano");
        instruments.put(2, "Bright piano");
        instruments.put(3, "Grand piano");
        instruments.put(4, "Honky-tonk piano");
        instruments.put(5, "Rhodes piano1");
        instruments.put(6, "Chorused piano2");
        instruments.put(7, "Harpsichord");
        instruments.put(8, "Clavinet");
        instruments.put(9, "Celesta");
        instruments.put(10, "Glockenspiel");
        instruments.put(11, "Music Box");
        instruments.put(12, "Vibraphone");
        instruments.put(13, "Marimba");
        instruments.put(14, "Xylophone");
        instruments.put(15, "Tubular Bells");
        instruments.put(16, "Dulcimer");
        instruments.put(17, "Hammmond");
        instruments.put(18, "Percussive Organ");
        instruments.put(19, "Rock Organ");
        instruments.put(20, "Church Organ");
        instruments.put(21, "Reed Organ");
        instruments.put(22, "Accordion");
        instruments.put(23, "Harmonica");
        instruments.put(24, "Tango accordion");
        instruments.put(25, "Nylon Guitar");
        instruments.put(26, "Steel Guitar");
        instruments.put(27, "Jazz Guitar");
        instruments.put(28, "Clean Guitar");
        instruments.put(29, "Muted Guitar");
        instruments.put(30, "Overdriven Guitar");
        instruments.put(31, "Distortion Guitar");
        instruments.put(32, "Guitar Harmonics");
        instruments.put(33, "Acoustiс Bass");
        instruments.put(34, "Finger Bass");
        instruments.put(35, "Piked Bass");
        instruments.put(36, "Fretless Bass");
        instruments.put(37, "Slap Bass1");
        instruments.put(38, "Slap Bass2");
        instruments.put(39, "Synth Bass1");
        instruments.put(40, "Synth Bass2");
        instruments.put(41, "Violin");
        instruments.put(42, "Viola");
        instruments.put(43, "Cello");
        instruments.put(44, "Double Bass");
        instruments.put(45, "Tremolo Strings");
        instruments.put(46, "Pizzicato Strings");
        instruments.put(47, "Orchestral Harp");
        instruments.put(48, "Timpani");
        instruments.put(49, "Strings1");
        instruments.put(50, "Strings2");
        instruments.put(51, "Synth Strings1");
        instruments.put(52, "Synth Strings2");
        instruments.put(53, "Choir Aahs");
        instruments.put(54, "Voice oohs");
        instruments.put(55, "Synth Voice");
        instruments.put(56, "Orchestra Hit");
        instruments.put(57, "Trumpet");
        instruments.put(58, "Trombone");
        instruments.put(59, "Tuba");
        instruments.put(60, "Muted Trumpet");
        instruments.put(61, "French Horn");
        instruments.put(62, "Brass");
        instruments.put(63, "Synth Brass 1");
        instruments.put(64, "Synth Brass 2");
        instruments.put(65, "Soprano Sax");
        instruments.put(66, "Alto Sax");
        instruments.put(67, "Tenor Sax");
        instruments.put(68, "Baritone Sax");
        instruments.put(69, "Oboe");
        instruments.put(70, "English Horn");
        instruments.put(71, "Bassoon");
        instruments.put(72, "Clarinet");
        instruments.put(73, "Piccolo");
        instruments.put(74, "Flute");
        instruments.put(75, "Recorder");
        instruments.put(76, "Pan Flute");
        instruments.put(77, "Bottle Blow");
        instruments.put(78, "Shakuhachi");
        instruments.put(79, "Whistle");
        instruments.put(80, "Osarina");
        instruments.put(81, "Square Wave");
        instruments.put(82, "Sawtooth");
        instruments.put(83, "Calliope");
        instruments.put(84, "Chiff Lead");
        instruments.put(85, "Charang");
        instruments.put(86, "Solo Synth Lead");
        instruments.put(87, "Bright Saw");
        instruments.put(88, "Bass Lead");
        instruments.put(89, "Fantasia");
        instruments.put(90, "Warm Pad");
        instruments.put(91, "Poly Synth");
        instruments.put(92, "Space Pad");
        instruments.put(93, "Bowed Glass");
        instruments.put(94, "Metall");
        instruments.put(95, "Halo Pad");
        instruments.put(96, "Sweep Pad");
        instruments.put(97, "Ice rain");
        instruments.put(98, "Soundtrack");
        instruments.put(99, "Crystal");
        instruments.put(100, "Atmosphere");
        instruments.put(101, "Brightness");
        instruments.put(102, "Goblin");
        instruments.put(103, "Echo theme");
        instruments.put(104, "Star theme");
        instruments.put(105, "Sitar");
        instruments.put(106, "Banjo");
        instruments.put(107, "Shamisen");
        instruments.put(108, "Koto");
        instruments.put(109, "Kalimba");
        instruments.put(110, "Bagpipe");
        instruments.put(111, "Fiddle");
        instruments.put(112, "Shanai");
        instruments.put(113, "Tinkle Bell");
        instruments.put(114, "Agogo");
        instruments.put(115, "Steel Drums");
        instruments.put(116, "Woodblock");
        instruments.put(117, "Taiko Drum");
        instruments.put(118, "Melodic Drum");
        instruments.put(119, "Synth Drum");
        instruments.put(120, "Reverse Cymbal");
        instruments.put(121, "Guitar Fret");
        instruments.put(122, "Breath");
        instruments.put(123, "Seashore");
        instruments.put(124, "Bird Tweet");
        instruments.put(125, "Telephone Ring");
        instruments.put(126, "Helicopter");
        instruments.put(127, "Applause");
        instruments.put(128, "Gunshot");
    }

    public void playNotes(boolean display){
        int notes[] = {24,26,28,29,31,33,35};

        for(int i = 0;i < notes.length;i++){
            if(display)
                System.out.println("note: " + notes[i]);
            playMusic(notes[i]);
        }

    }

}
