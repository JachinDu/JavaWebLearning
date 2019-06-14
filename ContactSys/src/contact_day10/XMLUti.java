package contact_day10;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class XMLUti {

    public static Document getDocument() throws DocumentException {
        Document doc = new SAXReader().read("/Users/jc/Desktop/contact.xml");
        return doc;
    }

    public static void write2xml(Document doc) throws IOException {
        FileOutputStream out = new FileOutputStream("/Users/jc/Desktop/contact.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();

        XMLWriter writer = new XMLWriter(out,format);
        writer.write(doc);
        writer.close();
    }
}
