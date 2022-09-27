import java.util.Scanner;
public class Chord
{
    private Scale scale;
    private Note[] notesInChord;

    public Chord(Scale scale)
    {
        this.scale = scale;
    }

    public Note[] getListOfNotesInChord()
    {
        return notesInChord;
    }

    public void setListOfNotesInChord()
    {
        System.out.println("Now, let's define a chord. Define at least 3 notes in the scale by inputting values from these choices:");
        for(int i = 0; i < scale.getNotesInScale().length && scale.getNotesInScale()[i] != null; i++)
        {
            System.out.print(scale.getNotesInScale()[i].getBase12Val() + " ");
        }
        System.out.println("Upon entering at least 3 notes, you may choose to enter Q instead of the above choices to stop.");

        notesInChord = new Note[scale.getNotesInScale().length];
        for(int i = 0; i < notesInChord.length; i++)
        {

        }
    }
}
