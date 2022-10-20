import java.util.Scanner;
public class Chord
{
    private Scale scale;
    private Note[] notesInChord;
    private int scalePracticalLength;

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
        while(i < scale.getNotesInScale().length)
        {
            if(scale.getNotesInScale()[i] == null)
                break;
            i++;
        }
        return i;
    }

    private void quit_too_early(int i)
    {
        if(3 - i == 1)
        {
            System.out.println("Sorry, but you need to enter 1 more note.");
        }
        else
        {
            System.out.println("Sorry, but you need to enter " + (3 - i) + " more notes.");
        }
    }

    private void invalid_input()
    {
        System.out.println("Sorry, but you need to enter a valid choice. Valid choices are defined as: \n");
        for(int i = 0; i < scalePracticalLength; i++)
        {
            System.out.print(scale.getNotesInScale()[i].getBase12Val() + " ");
        }
    }

    public void setNotesInChord()
    {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        scalePracticalLength = getScalePracticalLength();
        System.out.println("Now, let's define a chord. Define at least 3 notes in the scale by inputting values from these choices:");
        for(int i = 0; i < scalePracticalLength; i++)
        {
            System.out.print(scale.getNotesInScale()[i].getBase12Val() + " ");
        }
        System.out.println("\nUpon entering at least 3 notes, you may choose to enter Q instead of the above choices to stop. \n" +
                "Note: the order in which you enter the notes will determine the chord's voicing.");

        notesInChord = new Note[scale.getNotesInScale().length];
        char currIn;
        int i = 0;
        while(true)
        {
            currIn = sc.next().charAt(0);
            if(currIn == 'Q')
            {
                if(i > 2)
                {
                    break;
                }
                else {
                    quit_too_early(i);
                    i--;
                }
            }
            else if(!valid_input(currIn))
            {
                invalid_input();
                i--;
            }
            else
            {
                char sharp_flat_na = '\u0000';
                for (int j = 0; j < scalePracticalLength; j++)
                {
                    if(currIn == scale.getNotesInScale()[j].getBase12Val())
                    {
                        sharp_flat_na = scale.getNotesInScale()[j].getFlat_sharp_na();
                    }
                }
                Note newNote = new Note(currIn, sharp_flat_na);
                notesInChord[i] = newNote;
            }
            i++;
        }
    }
}
