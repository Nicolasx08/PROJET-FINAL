package serveur;


    import java.io.File;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.net.ServerSocket;
    import java.net.Socket;
    import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

    import main.Main;
    import org.w3c.dom.*;
    import planete.*;

public class Serveur {
    public static void main(String[] args) {

        try {
            ServerSocket serveur = new ServerSocket(8080);

            Socket socket = serveur.accept();


        } catch (Exception ex) {
            System.out.println("Serveur marche pas " + ex);
        }
    }
    public static void clean(Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int n = childNodes.getLength() - 1; n >= 0; n--)
        {
            Node child = childNodes.item(n);
            int nodeType = child.getNodeType();

            if (nodeType == Node.ELEMENT_NODE)
                clean(child);
            else if (nodeType == Node.TEXT_NODE){
                String trimmedNodeValue = child.getNodeValue().trim();
                if (trimmedNodeValue.length() == 0)
                    node.removeChild(child);
                else
                    child.setNodeValue(trimmedNodeValue);
            }
            else if (nodeType == Node.COMMENT_NODE)
                node.removeChild(child);
        }
    }
    public static void chercherInfo(){
        try {
            File file = new File("Donnees.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
        }catch (Exception e){
            System.out.println("Chercher info marche pas");
        }
    }
}

