import java.io.*;
import java.util.Scanner;

import static java.lang.Character.*;

public class ROT13  {

    Character start;
    Character end;


    ROT13(Character cs, Character cf) {
        this.start = cs;
        this.end = cf;
    }

    ROT13() {
        this.start = 'a';
        this.end = 'n';
    }


    public String crypt(String text) throws UnsupportedOperationException {
        int phase = end - start;
        StringBuilder output = new StringBuilder();

        for(char c : text.toCharArray()){
            if(c > 65 && c <= 90){
                c %= 65;
                c += phase;
                c %= 26;
                c += 65;
                output.append(c);
            } else if (c >= 97 && c <= 122){
                c %= 97;
                c += phase;
                c %= 26;
                c += 97;
                output.append(c);
            } else {
                output.append(c);
            }
        }
        return output.toString();
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        int phase = 26 - (end - start);
        StringBuilder output = new StringBuilder();

        for(char c : text.toCharArray()){
            if(c > 65 && c <= 90){
                c %= 65;
                c += phase;
                c %= 26;
                c += 65;
                output.append(c);
            } else if (c >= 97 && c <= 122){
                c %= 97;
                c += phase;
                c %= 26;
                c += 97;
                output.append(c);
            } else {
                output.append(c);
            }

        }
        return output.toString();
    }

    public static String rotate(String s, Character c) {
        return s.substring(s.indexOf(c)) + s.substring(0, s.indexOf(c));
    }

    public void encryptSonnet(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("sonnet18.enc")));
            String line = "";
            while ((line = reader.readLine()) != null){
                writer.write(encrypt(line) + "\n");
            }
            reader.close();
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void decryptSonnet(File file){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("sonnet18.dec")));
            String line = "";
            while ((line = reader.readLine()) != null){
                writer.write(decrypt(line) + "\n");
            }
            reader.close();
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
