import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class TestSonnet {

    @Before
    public void setup(){
        ROT13 rot13 = new ROT13();

        rot13.encryptSonnet(new File("sonnet18.txt"));
        rot13.decryptSonnet(new File("sonnet18.enc"));
    }

    @Test
    public void sonnetTest(){// I have no idea why capital N is the only letter that messes up my code
        try {
            BufferedReader actual = new BufferedReader(new FileReader("sonnet18.txt"));
            BufferedReader expected = new BufferedReader(new FileReader("sonnet18.dec"));
            String line1 = "";
            String line2 = "";
            while ((line1 = actual.readLine()) != null && (line2 = expected.readLine()) != null){
                Assert.assertEquals(line1, line2);
            }
            actual.close();
            expected.close();
        } catch (IOException e){
            e.printStackTrace();
        }



    }
}
