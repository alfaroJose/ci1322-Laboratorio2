import java.net.URL;
import java.util.Scanner;

/**
 * Reads lines from a web page.  The url for the page can be
 * given as a command-line argument.  If no argument is specified,
 * the program will ask the user to enter the url.
 */
public class GetPage {

    public static void main(String[] args) {

        String url;  // The web address for the page to be read.
        if (args.length > 0)
            url = args[0];
        else {
            System.out.println("Enter a URL or press return to use the default: ");
            Scanner in = new Scanner(System.in);
            url = in.nextLine();
            in.close();
        }
        if (url.trim().length() == 0)
            url = "http://math.hws.edu/eck/index.html";

        Scanner page;  // A scanner for reading the content of the page.
        try {
            URL addr = new URL(url);
            page = new Scanner(addr.openStream());
        }
        catch (Exception e) {
            System.err.println("Could not open url '" + url + "'.");
            return;
        }

        while (page.hasNextLine()) {
            String line = page.nextLine();
            System.out.println(line);
        }

        page.close();
    }

}