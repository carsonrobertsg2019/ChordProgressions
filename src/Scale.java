import java.util.Scanner;

public class Scale
{
    private Note[] notesInScale;
    private Note tonic;
    public Scale()
    {
        notesInScale = new Note[12];
        tonic = new Note('0','\u0000');
    }

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

    private boolean unique_input(char currIn)
    {
        boolean unique = true;
        for(int j = 0; notesInScale[j] != null; j++)
        {
            if(notesInScale[j].getBase12Val() == currIn)
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
        //TODO: this is pretty bad still but it works at least lol... too bad!
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

    char defineTonic(char currIn, Scanner sc)
    {
        while(!valid_input(currIn))
        {
            boolean isTonic = true;
            invalid_input(isTonic);
            currIn = sc.next().charAt(0);
        }
        return currIn;
    }

    private char sharpOrFlat(char currIn, Scanner sc)
    {
        char flat_sharp_na = '\u0000';
        if(isAccidental(currIn))
        {
            inputSharpFlatNa();
            flat_sharp_na = sc.next().charAt(0);
            while(flat_sharp_na != '#' && flat_sharp_na != 'b')
            {
                invalidAccidental();
                flat_sharp_na = sc.next().charAt(0);
            }
        }
        return flat_sharp_na;
    }

    private Note[] sort(Note[] arr)
    {
        try
        {
            int n = arr.length;
            for (int i = 1; i < n; ++i) {
                Note key = arr[i];
                int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
                while (j >= 0 && arr[j].convertToBase10() > key.convertToBase10())
                {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }
            return arr;
        }
        catch(Exception NullPointerException) {
            return arr;
        }
    }

    private void invalidAccidental()
    {
        System.out.println("Invalid accidental. Try again.");
    }

    public void setNotesInScale()
    {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object

        inputTonic();
        char currIn = defineTonic(sc.next().charAt(0), sc);
        char flat_sharp_na = sharpOrFlat(currIn, sc);

        tonic = new Note(currIn, flat_sharp_na);
        startup();
        notesInScale[0] = new Note('0', tonic.getFlat_sharp_na());
        for(int i = 1; i < notesInScale.length; i++)
        {
            currIn = sc.next().charAt(0);
            if(currIn == 'Q')
            {
                if(i > 2)
                {
                    break;
                }
                else
                {
                    quit_too_early(i);
                    i--;
                }
            }
            else if(!valid_input(currIn))
            {
                boolean isTonic= false;
                invalid_input(isTonic);
                i--;
            }
            else if(!unique_input(currIn))
            {
                non_unique_input();
                i--;
            }
            else
            {
                flat_sharp_na = sharpOrFlat(currIn, sc);
                Note newNote = new Note(currIn, flat_sharp_na);
                notesInScale[i] = newNote;
            }
        }
        notesInScale = sort(notesInScale);
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
