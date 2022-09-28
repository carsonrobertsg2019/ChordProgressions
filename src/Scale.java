import java.util.Scanner;

public class Scale
{
    private Note[] notesInScale;
    private Note tonic = new Note('0','\u0000');
    public Scale() { }

    private void startup()
    {
        System.out.println("Now define at least 3 notes in the scale by inputting values from these choices: \n" +
                "1 2 3 4 5 6 7 8 9 T E \n" +
                "Upon entering at least 3 notes, you may choose to enter Q instead of the above choices to stop. \n" +
                "This program operates under the 12TET system, so once you have made 12 choices, the program will end automatically.");
    }

    private void invalid_input(boolean tonic)
    {
        if(tonic)
        {
            System.out.println("Sorry, but you need to enter a valid choice. Valid choices are defined as: \n" +
                    "0 1 2 3 4 5 6 7 8 9 T E");
        }
        else
        {
            System.out.println("Sorry, but you need to enter a valid choice. Valid choices are defined as: \n" +
                    "1 2 3 4 5 6 7 8 9 T E");
        }
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

    private void inputTonic()
    {
        System.out.println("First, define the note that the scale starts on. Your choices are: \n" +
                "0  1  2  3  4  5  6  7  8  9  T  E\n" +
                "The notes that correspond to those characters are as follows: \n" +
                "C  Db D  Eb E  F  Gb G  Ab A  Bb B\n" +
                "   C#    D#       F#    G#    A#");
    }

    private void inputSharpFlatNa()
    {
        System.out.println("Determine if this note is sharp or flat. \n" +
                "For sharp, enter # and for flat enter b");
    }

    private boolean isAccidental(char input)
    {
        //TODO: this is pretty bad still but it works at least lol
        if(tonic.getBase12Val() == '0')
        {
            return input == '1' ||
                    input == '3' ||
                    input == '6' ||
                    input == '8' ||
                    input == 'T';
        }
        else if(tonic.getBase12Val() == '1')
        {
            return input == '2' ||
                    input == '5' ||
                    input == '7' ||
                    input == '9';
        }
        else if(tonic.getBase12Val() == '2')
        {
            return input == '1' ||
                    input == '4' ||
                    input == '6' ||
                    input == '8' ||
                    input == 'E';
        }
        else if(tonic.getBase12Val() == '3')
        {
            return input == '3' ||
                    input == '5' ||
                    input == '7' ||
                    input == 'T';
        }
        else if(tonic.getBase12Val() == '4')
        {
            return input == '2' ||
                    input == '4' ||
                    input == '6' ||
                    input == '9' ||
                    input == 'E';
        }
        else if(tonic.getBase12Val() == '5')
        {
            return input == '1' ||
                    input == '3' ||
                    input == '5' ||
                    input == '8' ||
                    input == 'T';
        }
        else if(tonic.getBase12Val() == '6')
        {
            return input == '2' ||
                    input == '4' ||
                    input == '7' ||
                    input == '9';
        }
        else if(tonic.getBase12Val() == '7')
        {
            return input == '1' ||
                    input == '3' ||
                    input == '6' ||
                    input == '8' ||
                    input == 'E';
        }
        else if(tonic.getBase12Val() == '8')
        {
            return input == '2' ||
                    input == '5' ||
                    input == '7' ||
                    input == 'T';
        }
        else if(tonic.getBase12Val() == '9')
        {
            return input == '1' ||
                    input == '4' ||
                    input == '6' ||
                    input == '9' ||
                    input == 'E';
        }
        else if(tonic.getBase12Val() == 'T')
        {
            return input == '3' ||
                    input == '5' ||
                    input == '8' ||
                    input == 'T';
        }
        else if(tonic.getBase12Val() == 'E')
        {
            return input == '2' ||
                    input == '4' ||
                    input == '7' ||
                    input == '9' ||
                    input == 'E';
        }
        return false;
    }

    private void invalidAccidental()
    {
        System.out.println("Invalid accidental. Try again.");
    }
    private void writeToConsole(int messageType, int i, boolean tonic)
    {
        if(messageType == 0)
            startup();
        else if(messageType == 1)
            invalid_input(tonic);
        else if(messageType == 2)
            non_unique_input();
        else if(messageType == 3)
            quit_too_early(i);
        else if(messageType == 4)
            inputTonic();
        else if(messageType == 5)
            inputSharpFlatNa();
        else if(messageType == 6)
            invalidAccidental();
    }

    public void setNotesInScale()
    {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object

        writeToConsole(4, -1, false);
        char tonic_char = sc.next().charAt(0);
        while(!valid_input(tonic_char))
        {
            writeToConsole(1,-1, true);
            tonic_char = sc.next().charAt(0);
        }
        char flat_sharp_na = '\u0000';
        if(isAccidental(tonic_char)) {
            writeToConsole(5, -1, false);
            flat_sharp_na = sc.next().charAt(0);
        }

        tonic = new Note(tonic_char, flat_sharp_na);
        writeToConsole(0, -1, false);
        notesInScale = new Note[12];
        char currIn;
        notesInScale[0] = new Note('0', tonic.getFlat_sharp_na());
        for(int i = 1; i < notesInScale.length; i++)
        {
            currIn = sc.next().charAt(0);
            if(valid_input(currIn))
            {
                if(unique_input(currIn, notesInScale))
                {
                    flat_sharp_na = '\u0000';
                    if(isAccidental(currIn)) {
                        writeToConsole(5, -1, false);
                        flat_sharp_na = sc.next().charAt(0);
                        while(flat_sharp_na != '#' && flat_sharp_na != 'b')
                        {
                            writeToConsole(6,-1, false);
                            flat_sharp_na = sc.next().charAt(0);
                        }
                    }
                    Note newNote = new Note(currIn, flat_sharp_na);
                    notesInScale[i] = newNote;
                }
                else
                {
                    writeToConsole(2, -1, false);
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
                    writeToConsole(3, i, false);
                    i--;
                }
            }
            else
            {
                writeToConsole(1, -1, false);
                i--;
            }
        }
    }

    public Note[] getNotesInScale()
    {
        return notesInScale;
    }

    public Note getTonic()
    {
        return tonic;
    }
}
