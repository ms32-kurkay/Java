import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DOM {
    private static void downloadUsingStream(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = bis.read(buffer, 0, 1024)) != -1) {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

    private static List<Currency> currencies = new ArrayList<>();
    private static DailyExRate dailyExRate;

    public static void main(String[] args) {
        String url = "http://www.nbrb.by/Services/XmlExRates.aspx";

        try {
            downloadUsingStream(url, "test.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("test.xml"));
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("Currency");

            for(int i = 0; i < nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    int id = Integer.parseInt(element.getAttribute("Id"));
                    Node node1 = element.getElementsByTagName("CharCode").item(0);
                    String charCode = node1.getTextContent();
                    Node node2 = element.getElementsByTagName("NumCode").item(0);
                    int numCode = Integer.parseInt(node2.getTextContent());
                    Node node3 = element.getElementsByTagName("Scale").item(0);
                    int scale = Integer.parseInt(node3.getTextContent());
                    Node node4 = element.getElementsByTagName("Name").item(0);
                    String name = node4.getTextContent();
                    Node node5 = element.getElementsByTagName("Rate").item(0);
                    float rate = Float.parseFloat(node5.getTextContent());
                    Currency currency = new Currency(charCode, rate, scale, numCode, name, id);
                    currencies.add(currency);
                }
            }

            dailyExRate = new DailyExRate(currencies, document.getDocumentElement().getAttribute("Date"));

            for (Currency c : currencies){
                System.out.println(dailyExRate.getDate());
                System.out.println(c.toString());
            }

        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}