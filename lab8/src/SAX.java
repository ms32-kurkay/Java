
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SAX {
    private static void downloadUsingStream(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
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
            downloadUsingStream(url,"test.xml");

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            SAXHandler handler = new SAXHandler();
            parser.parse(new File("test.xml"), handler);

            for (Currency c : currencies){
                System.out.println(dailyExRate.getDate());
                System.out.println(c.toString());
            }

        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static class SAXHandler extends DefaultHandler {
        private String charCode;
        private float rate;
        private int scale;
        private int id;
        private int numCode;
        private String name;

        private String Date;

        private String lastElementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("Currency"))
                id = Integer.parseInt(attributes.getValue("Id"));
            if (qName.equals("DailyExRates"))
                Date = attributes.getValue("Date");
            lastElementName = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ((name != null) && (charCode != null) && (rate != 0) && (scale != 0) && (numCode != 0) && (id != 0)) {
                Currency currency = new Currency(charCode, rate, scale, numCode, name, id);
                currencies.add(currency);

                dailyExRate = new DailyExRate(currencies, Date);

                charCode = null;
                rate = 0;
                scale = 0;
                numCode = 0;
                name = null;
                id = 0;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String information = new String(ch, start, length);
            information = information.replace("\n", "").trim();
            if (!information.isEmpty()) {
                if (lastElementName.equals("NumCode"))
                    numCode = Integer.parseInt(information);
                if (lastElementName.equals("CharCode"))
                    charCode = information;
                if (lastElementName.equals("Scale"))
                    scale = Integer.parseInt(information);
                if (lastElementName.equals("Name"))
                    name = information;
                if (lastElementName.equals("Rate"))
                    rate = Float.parseFloat(information);
            }
        }
    }
}