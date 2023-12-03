import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String, String> nums = new HashMap<String, String>();

        nums.put("one", "1");
        nums.put("two", "2");
        nums.put("three", "3");
        nums.put("four", "4");
        nums.put("five", "5");
        nums.put("six", "6");
        nums.put("seven", "7");
        nums.put("eight", "8");
        nums.put("nine", "9");

        //reading in
        BufferedReader reader;
        int sum = 0;
        //READING FILE IN.
        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\zaras\\Documents\\Worksheet 1\\dayone\\src\\calivalues"));
            List<String> fileLines = new ArrayList<>();
            String line = reader.readLine();

            while (line != null) {
                fileLines.add(line);
                line = reader.readLine();
            }
            reader.close();

            //finished reading
            // START OF STRING

            StringBuilder result = new StringBuilder();
            List<String> temp = new ArrayList<>();

            StringBuilder currentDigits = null;
            for (int x = 0; x < fileLines.size(); x++) {
                String currentLine = fileLines.get(x);
                currentDigits = new StringBuilder();
                for (int indexOfchar = 0; indexOfchar < currentLine.length(); indexOfchar++) {
                    char currentChar = currentLine.charAt(indexOfchar);
                    if (Character.isDigit(currentChar)) {
                        currentDigits.append(currentChar);
                    } else if (Character.isLetter(currentChar)) {
                        StringBuilder wordNum = new StringBuilder();
                        while (indexOfchar < currentLine.length() && Character.isLetter(currentLine.charAt(indexOfchar))) {
                            wordNum.append(currentLine.charAt(indexOfchar));
                            indexOfchar++;
                        }
                        indexOfchar--;
                        if (nums.containsKey(wordNum.toString())) {
                            currentDigits.append(nums.get(wordNum.toString()));
                        }
                    }

                }
                temp.add(currentDigits.toString());
                System.out.println(temp.get(x));
                currentDigits = new StringBuilder();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}