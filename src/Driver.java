public class Driver
{
    public static void main(String[] args)
    {
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
        for(int i = 0; i < scale.getNotesInScale().length && scale.getNotesInScale()[i] != null; i++)
        {
            int j = 0;
            if(scale.getNotesInScale()[i].flat_sharp_na == '#')
            {
                j = 1;
            }
            try
            {
                System.out.print(index[scale.getNotesInScale()[i].convertToBase10() + scale.getTonic().convertToBase10()][j] + " ");
            }
            catch(IndexOutOfBoundsException ioobe)
            {
                System.out.print(index[scale.getNotesInScale()[i].convertToBase10() + scale.getTonic().convertToBase10() - 12][j] + " ");
            }
        }
        System.out.println();
        Chord chord = new Chord(scale);
        chord.setListOfNotesInChord();
    }
}
