import org.xml.sax.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class XMLTest {
    public static void main(String[] args){
        DownloadManager downloader = new DownloadManager();

        Document xmlDoc = getDocument("./src/wms.xml");
        System.out.println("File found : " + xmlDoc.getDocumentElement().getNodeName());
        Node rootLayer = xmlDoc.getElementsByTagName("Layer").item(0);
        NodeList layers = findNodes(rootLayer, "Layer");
        System.out.println("Available layers: " + layers.getLength());
        for (int i = 0; i < layers.getLength(); i++) {
            Node title = findNodes(layers.item(i),"Title").item(0);
            System.out.println(title.getTextContent());
        }
    }

    private static Document getDocument(String docString) {
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
            factory.setValidating(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new InputSource(docString));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static void printTags(Node nodes){
        if(nodes.hasChildNodes()  || nodes.getNodeType()!=3){
            System.out.println(nodes.getNodeName()+" : "+nodes.getTextContent());
            NodeList nl=nodes.getChildNodes();
            for(int j=0;j<nl.getLength();j++)printTags(nl.item(j));
        }
    }
    public static Element toElement(Node nd){
        if (nd instanceof Element){
            Element docElement = (Element) nd;
            return docElement;
        }return null;
    }
    public static NodeList findNodes(Node nd, String name){
        Element ele = toElement(nd);
        return ele.getElementsByTagName(name);
    }
}
