package project1;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class ItalyXMLParser {
    public ItalyXMLParser() {
        super();
    }

    public static void main(String[] args) {
        //XMLParser xmlp = new XMLParser();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setIgnoringElementContentWhitespace(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File("C:\\Ecovues\\Italy_Xml.xml");
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("------");
    //FatturaElettronicaHeader
            NodeList list = doc.getElementsByTagName("FatturaElettronicaHeader");
                    Element element = (Element) list.item(0);
                    String sogget = element.getElementsByTagName("SoggettoEmittente").item(0).getTextContent();
                    System.out.println("sogget: "+sogget);
            
            //DatiTrasmissione
                    NodeList datilist = element.getElementsByTagName("DatiTrasmissione");
                    Element datielement = (Element) datilist.item(0);
                    
                    String prog = datielement.getElementsByTagName("ProgressivoInvio").item(0).getTextContent();
                    String form = datielement.getElementsByTagName("FormatoTrasmissione").item(0).getTextContent();
                    String codi = datielement.getElementsByTagName("CodiceDestinatario").item(0).getTextContent();
                    
                    NodeList idlist = datielement.getElementsByTagName("IdTrasmittente");
                    Element idelement = (Element) idlist.item(0);

                    String idpa = idelement.getElementsByTagName("IdPaese").item(0).getTextContent();
                    String idco = idelement.getElementsByTagName("IdCodice").item(0).getTextContent();
                    
                    NodeList idtrlist = datielement.getElementsByTagName("ContattiTrasmittente");
                    Element idtrelement = (Element) idtrlist.item(0);
                    
                    String tele = idtrelement.getElementsByTagName("Telefono").item(0).getTextContent();
                    System.out.println("prog: "+prog);
                    //System.out.println("prog: "+prog);
            
            //CedentePrestatore
            address("CedentePrestatore",element); //Supplier
            
            //CessionarioCommittente
            address("CessionarioCommittente",element);//Customer
            
            //TerzoIntermediarioOSoggettoEmittente
            address("TerzoIntermediarioOSoggettoEmittente",element);
            
  //FatturaElettronicaBody
        NodeList bodylist = doc.getElementsByTagName("FatturaElettronicaBody");
        Element bodyelement = (Element) bodylist.item(0);
         //DatiGenerali
            NodeList genelist = bodyelement.getElementsByTagName("DatiGenerali");
            Element geneelement = (Element) genelist.item(0);
            
            NodeList genedoclist = geneelement.getElementsByTagName("DatiGeneraliDocumento");
            Element genedocelement = (Element) genedoclist.item(0);
            
            String tipo = genedocelement.getElementsByTagName("TipoDocumento").item(0).getTextContent();
            String divisa = genedocelement.getElementsByTagName("Divisa").item(0).getTextContent();
            String invdate = genedocelement.getElementsByTagName("Data").item(0).getTextContent();
            String nume = genedocelement.getElementsByTagName("Numero").item(0).getTextContent();
            String impor = genedocelement.getElementsByTagName("ImportoTotaleDocumento").item(0).getTextContent();
            String caus = genedocelement.getElementsByTagName("Causale").item(0).getTextContent();
            System.out.println("caus:"+caus);
            
         //DatiBeniServizi -Lines
            NodeList benilist = bodyelement.getElementsByTagName("DatiBeniServizi");
            Element beneelement = (Element) benilist.item(0);
            
            NodeList lineslist = beneelement.getElementsByTagName("DettaglioLinee");
            for (int temp = 0; temp < lineslist.getLength(); temp++) {
                Element lineselement = (Element) lineslist.item(temp);
                String  linenum = lineselement.getElementsByTagName("NumeroLinea").item(0).getTextContent();
                String  desc = lineselement.getElementsByTagName("Descrizione").item(0).getTextContent();
                String  quantity = lineselement.getElementsByTagName("Quantita").item(0).getTextContent();
                String  unitprice = lineselement.getElementsByTagName("PrezzoUnitario").item(0).getTextContent();
                String  total = lineselement.getElementsByTagName("PrezzoTotale").item(0).getTextContent();
                String  vat = lineselement.getElementsByTagName("AliquotaIVA").item(0).getTextContent();
                System.out.println("total: "+total);
                
                NodeList artilist = lineselement.getElementsByTagName("CodiceArticolo");
                Element artielement = (Element) artilist.item(0);
                
                String  tipo1 = artielement.getElementsByTagName("CodiceTipo").item(0).getTextContent();
                String  valore = artielement.getElementsByTagName("CodiceValore").item(0).getTextContent();
                System.out.println("tipo:"+tipo1);
                
            //DatiPagamento
            NodeList pagamlist = bodyelement.getElementsByTagName("DatiPagamento");
            Element pagamelement = (Element) pagamlist.item(0);
                
                String  pagam = pagamelement.getElementsByTagName("CondizioniPagamento").item(0).getTextContent();
                
                NodeList dettalist = pagamelement.getElementsByTagName("DettaglioPagamento");
                Element dettaelement = (Element) dettalist.item(0);
                
                String  benef = dettaelement.getElementsByTagName("Beneficiario").item(0).getTextContent();
                String  modal = dettaelement.getElementsByTagName("ModalitaPagamento").item(0).getTextContent();
                String  data = dettaelement.getElementsByTagName("DataScadenzaPagamento").item(0).getTextContent();
                String  impo = dettaelement.getElementsByTagName("ImportoPagamento").item(0).getTextContent();
                String  isti = dettaelement.getElementsByTagName("IstitutoFinanziario").item(0).getTextContent();
                String  iban = dettaelement.getElementsByTagName("IBAN").item(0).getTextContent();
                
                System.out.println("impo:"+impo);
                
                
            }
                   
                
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void address(String elementName,org.w3c.dom.Element element){
        NodeList cedelist = element.getElementsByTagName(elementName);
        Element cedeelement = (Element) cedelist.item(0);
        //DatiAnagrafici
        NodeList datilist1 = cedeelement.getElementsByTagName("DatiAnagrafici");
        Element datielement1 = (Element) datilist1.item(0);
        
        String codice = datielement1.getElementsByTagName("CodiceFiscale").item(0).getTextContent();
        String regime="";
        if(elementName.equals("CedentePrestatore"))
         regime = datielement1.getElementsByTagName("RegimeFiscale").item(0).getTextContent();
        
        
        NodeList idfilist = datielement1.getElementsByTagName("IdFiscaleIVA");
        Element idfielement = (Element) idfilist.item(0);

        String idpa1 = idfielement.getElementsByTagName("IdPaese").item(0).getTextContent();
        String idco1 = idfielement.getElementsByTagName("IdCodice").item(0).getTextContent();
        
        NodeList anaglist = datielement1.getElementsByTagName("Anagrafica");
        Element anagelement = (Element) anaglist.item(0);
        
        String denom = anagelement.getElementsByTagName("Denominazione").item(0).getTextContent();
        if(!elementName.equals("TerzoIntermediarioOSoggettoEmittente")){
        //Sede
        NodeList sedelist = cedeelement.getElementsByTagName("Sede");
        Element sedeelement = (Element) sedelist.item(0);
        
        String indi = sedeelement.getElementsByTagName("Indirizzo").item(0).getTextContent();
        String cap = sedeelement.getElementsByTagName("CAP").item(0).getTextContent();
        String comu = sedeelement.getElementsByTagName("Comune").item(0).getTextContent();
        String prov = sedeelement.getElementsByTagName("Provincia").item(0).getTextContent();
        String nazi = sedeelement.getElementsByTagName("Nazione").item(0).getTextContent();
        
            System.out.println("nazi: "+nazi);
        }
        System.out.println("idco1: "+idco1);
       
        
    }
}
