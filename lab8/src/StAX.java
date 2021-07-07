import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StAX {
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
        Currency currency = null;
        DailyExRate dailyExRate = null  ;
        try {
            downloadUsingStream(url, "test.xml");
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader reader = factory.createXMLEventReader(new FileInputStream("test.xml"));
            while(reader.hasNext()){
                XMLEvent xmlEvent = reader.nextEvent();
                if(xmlEvent.isStartElement()){
                    StartElement start = xmlEvent.asStartElement();
                    if(start.getName().getLocalPart().equals("Currency")){
                        currency = new Currency();
                        Attribute idAttr = start.getAttributeByName(new QName("Id"));
                        if(idAttr != null){
                            currency.setId(Integer.parseInt(idAttr.getValue()));
                        }
                    }
                    if(start.getName().getLocalPart().equals("DailyExRates")){
                        dailyExRate = new DailyExRate();
                        Attribute dateAttr = start.getAttributeByName(new QName("Date"));
                        if(dateAttr != null){
                            dailyExRate.setDate(dateAttr.getValue());
                        }
                    }
                        if(start.getName().getLocalPart().equals("CharCode")) {
                            xmlEvent = reader.nextEvent();
                            currency.setCharCode(xmlEvent.asCharacters().getData());
                        }
                        if(start.getName().getLocalPart().equals("Rate")) {
                            xmlEvent = reader.nextEvent();
                            currency.setRate(Float.parseFloat(xmlEvent.asCharacters().getData()));
                        }
                       if(start.getName().getLocalPart().equals("Scale")) {
                            xmlEvent = reader.nextEvent();
                            currency.setScale(Integer.parseInt(xmlEvent.asCharacters().getData()));
                        }
                        if(start.getName().getLocalPart().equals("NumCode")) {
                            xmlEvent = reader.nextEvent();
                            currency.setNumCode(Integer.parseInt(xmlEvent.asCharacters().getData()));
                        }
                        if(start.getName().getLocalPart().equals("Name")) {
                            xmlEvent = reader.nextEvent();
                            currency.setName(xmlEvent.asCharacters().getData());
                        }
                    }
                    if(xmlEvent.isEndElement()){
                        EndElement end = xmlEvent.asEndElement();
                        if(end.getName().getLocalPart().equals("Currency")){
                            currencies.add(currency);
                        }
                        dailyExRate.setCurrency(currencies);
                    }
                }
            for(Currency c: currencies){
                System.out.println(dailyExRate.getDate());
                System.out.println(c.toString());
            }

        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }

    }
}
