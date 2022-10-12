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

    boolean valid_input(char currIn)
    {
        for(int i = 0; i < scale.getNotesInScale().length; i++)
        {
            if(scale.getNotesInScale()[i].getBase12Val() == currIn)
                return true;
        }
        return false;
    }

    int getScalePracticalLength()
    {
        int i = 0;
        while(scale.getNotesInScale()[i] != null)
        {
            i++;
        }
        return i;
    }

    public void setNotesInChord()
    {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        int scalePracticalLength = getScalePracticalLength();
        System.out.println("Now, let's define a chord. Define at least 3 notes in the scale by inputting values from these choices:");
        for(int i = 0; i < scalePracticalLength; i++)
        {
            System.out.print(scale.getNotesInScale()[i].getBase12Val() + " ");
        }
        System.out.println("Upon entering at least 3 notes, you may choose to enter Q instead of the above choices to stop.");

        System.out.println(scale.getNotesInScale().length);

        notesInChord = new Note[scale.getNotesInScale().length];
        char currIn;
        for(int i = 0; i < scalePracticalLength; i++)
        {
            currIn = sc.next().charAt(0);

        }
    }
}
