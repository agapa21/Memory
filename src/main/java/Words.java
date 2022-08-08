import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.*;

public class Words {

    String[] allWords;
    Integer[] selectedWords;
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    private int n = 0;

    Words(){
        getWords();
    }

    public void getWords()
    {
        try {
            List<String> listOfStrings = new ArrayList<String>();
            BufferedReader bf = new BufferedReader(new FileReader("Words.txt"));

            String line = bf.readLine();

            while (line != null)
            {
                n++;
                listOfStrings.add(line);
                line = bf.readLine();
            }
            bf.close();

            allWords = listOfStrings.toArray(new String[0]);
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public void randomizeWords(int pairs) {
        Random randomGenerator = new Random();

        while (numbers.size() < pairs*2) {
            int random = randomGenerator.nextInt(n);
            if (!numbers.contains(random)) {
                numbers.add(random);
                numbers.add(random);
            }
        }
        Collections.shuffle(numbers);
        Collections.shuffle(numbers);
        selectedWords = numbers.toArray(new Integer[0]);
    }

    public Integer[] returnWordsNumber()
    {
        return selectedWords;
    }
}