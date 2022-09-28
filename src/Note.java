public class Note
{
    private char base12;
    private char flat_sharp_na;
    public Note(char base12, char flat_sharp_na)
    {
        //DO NOT modify base12 after initializing it in the constructor
        this.base12 = base12;
        this.flat_sharp_na = flat_sharp_na;
    }

    public char getBase12Val()
    {
        return base12;
    }

    public int convertToBase10()
    {
        if(getBase12Val() == 'T')
            return 10;
        if(getBase12Val() == 'E')
            return 11;
        else return getBase12Val() - 48;
    }

    public char getFlat_sharp_na()
    {
        return flat_sharp_na;
    }
}
