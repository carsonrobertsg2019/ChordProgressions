public class Driver
{
    public static void main(String[] args)
    {
        Note[] listOfNotes = new Note[12];
        Scale scale = new Scale(listOfNotes);
        scale.setNotesInScale();
        for(int i = 0; i < scale.getNotesInScale().length; i++)
        {
            System.out.println(scale.getNotesInScale()[i].getBase12Val() + " ");
        }
    }
}
