import java.util.Scanner;

public class Scale
{
    private Note[] notesInScale;
    public Scale(Note[] notesInScale)
    {
        this.notesInScale = notesInScale;
    }

    private void startup()
    {
        System.out.println("Hello! First, let's define a scale. Define at least 3 notes in the scale by inputting values from these choices: \n" +
                "0 1 2 3 4 5 6 7 8 9 T E \n" +
                "Upon entering at least 3 notes, you may choose to enter Q instead of the above choices to stop. \n" +
                "This program operates under the 12TET system, so once you have made 12 choices, the program will end automatically.");
    }

    private void invalid_input()
    {
        System.out.println("Sorry, but you need to enter a valid choice. Valid choices are defined as: \n" +
                "0 1 2 3 4 5 6 7 8 9 T E \n" +
                "Please try again, or you may enter Q to quit, assuming you have already entered 3 notes.");
    }

    private void non_unique_input()
    {
        System.out.println("Sorry, but you need to enter unique choices. \n" +
                "The scale 0 2 3 5 6 7 9 is no different from the scale 0 2 3 4 4 5 6 9 9 \n" +
                "Please try again, or you may enter Q to quit, assuming you have already entered 3 notes.");
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

    private boolean valid_input(char currIn)
    {
        return java.lang.Character.getNumericValue(currIn) <= 9 || currIn == 'T' || currIn == 'E';
    }

    private boolean unique_input(char currIn, Note[] listOfNotes)
    {
        boolean unique = true;
        for(int j = 0; listOfNotes[j] != null; j++)
        {
            if(listOfNotes[j].getBase12Val() == currIn)
            {
                unique = false;
            }
        }
        return unique;
    }

    private void writeToConsole(int messageType, int i)
    {
        if(messageType == 0)
            startup();
        else if(messageType == 1)
            invalid_input();
        else if(messageType == 2)
            non_unique_input();
        else if(messageType == 3)
            quit_too_early(i);
    }

    public void setNotesInScale()
    {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        writeToConsole(0, -1);
        notesInScale = new Note[12];
        char currIn; //i for invalid
        for(int i = 0; i < notesInScale.length; i++)
        {
            currIn = sc.next().charAt(0);
            if(valid_input(currIn))
            {
                if(unique_input(currIn, notesInScale))
                {
                    Note newNote = new Note(currIn);
                    notesInScale[i] = newNote;
                }
                else
                {
                    writeToConsole(2, -1);
                    i--;
                }
            }
            else if(currIn == 'Q')
            {
                if(i > 2)
                {
                    break;
                }
                else
                {
                    writeToConsole(3, i);
                    i--;
                }
            }
            else
            {
                writeToConsole(1, -1);
                i--;
            }
        }
    }

    public Note[] getNotesInScale()
    {
        return notesInScale;
    }
}
