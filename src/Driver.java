public class Driver
{
    public static void main(String[] args)
    {
        //TODO: convert arrays in Scale and Chord to arraylists
        String[][] index = {
                {"C"},
                {"Db", "C#"},
                {"D"},
                {"Eb", "D#"},
                {"E"},
                {"F"},
                {"Gb", "F#"},
                {"G"},
                {"Ab", "G#"},
                {"A"},
                {"Bb", "A#"},
                {"B"}
        };
        Scale scale = new Scale();
        scale.setNotesInScale();
        Chord chord = new Chord(scale);
        chord.setNotesInChord();
    }
}
