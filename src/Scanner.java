import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Scanner {
    StringBuilder sb = new StringBuilder();
    String line;
    String[] strM;
    Integer indexHasNextInt = 0;
    Integer indexHasNext = 0;
    Integer indexReturnInt = 0;
    Integer stringLengthForCount = 0;

    public Scanner(String input) {
        line = input;
        strM = line.split("[\\ \\,\\.]");
    }

    public Scanner(InputStream stream) throws IOException {
        try (BufferedInputStream buf = new BufferedInputStream(stream)) {
            int c;
            while ((c = buf.read()) >= 0) {
                sb.append(Character.toString((char) c));
                line = sb.toString();
                strM = line.split("[\\ \\,\\.]");
                stream.close();
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public boolean hasNextInt() {
        boolean boolReturn;
        indexHasNext++;
        String[] holder = strM;
        int checkPoint = 0;
        ArrayList<String> arrayHolder = new ArrayList<>();
        for (int i = 0; i < holder.length; i++) {
            for(int k = 0; k < strM[i].length(); k++) {
                if(Character.isDigit(strM[i].charAt(k))) {
                    checkPoint += 1;
                } else {
                    continue;
                }
            }
            if (checkPoint == strM[i].length()) arrayHolder.add(strM[i]);
            checkPoint = 0;

        }
        holder = arrayHolder.toArray(new String[arrayHolder.size()]);
        holder = noSpace(holder);
        System.out.println(Arrays.toString(holder));
        if(holder.length >= indexHasNext)
            boolReturn = true;
        else
            boolReturn = false;
        return boolReturn;
    }

    public boolean hasNext() {
        boolean boolReturn;
        indexHasNext++;
        ArrayList<String> holder = new ArrayList<>(Arrays.asList(strM));
        for(int i = 0; i < holder.size(); i++) {
            if (holder.get(i) == "") {
                holder.remove(i);
            } else continue;
        }
        strM = holder.toArray(new String[holder.size()]);
        if(strM.length >= indexHasNext) {
            boolReturn = true;
        } else {
            boolReturn = false;
        }
        return boolReturn;
    }

    public String next() {
        String point = "";
        StringBuffer sb = new StringBuffer();
        stringLengthForCount++;
        for(int i = 0; i < stringLengthForCount; i++) {
            point = strM[i];
        }
        sb.append(point);
        String returnString = sb.toString();
        return returnString;
    }

    public String[] noSpace(String[] inputMas) {
        ArrayList<String> arrayString = new ArrayList<>();
        for(int i = 0; i < inputMas.length; i++) {
            if (inputMas[i] != ""){
                arrayString.add(inputMas[i]);
            } else continue;
        }
        String[] outputMas = arrayString.toArray(new String[arrayString.size()]);
        return outputMas;
    }

    public String nextLine() {

        return line;
    }

}