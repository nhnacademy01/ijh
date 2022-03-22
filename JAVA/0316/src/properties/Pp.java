package properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Pp {
    public static void main(String[] args) throws IOException {
        Pp pp = new Pp();
        pp.store();
    }

    private void store() throws IOException {
        Properties card = new Properties();
        card.setProperty("name", "Comtin");
        card.setProperty("company", "NHN");
        card.setProperty("org", "Dooray");
        card.setProperty("tel", "031-8038-1234");

        System.out.println(card);

        FileOutputStream out = new FileOutputStream("card.properties");
        card.store(out, "Card");
    }
}
