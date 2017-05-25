package xml_creator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLCreator {
	Document doc;
	Element rootElement;
	Element keywordsElement;

	 public XMLCreator() {
		super();
		//this.doc = doc;
	}

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

   
         
     



    


    public Element getRootElement() {
        return rootElement;
    }

	void traitement ( List<String> KeywordList, List<Element> messageListe,List<Element> operationListe)   //X est le nom de Operations
	 {
		 try {
                        rootElement = doc.createElement("definition");
                          doc.appendChild(rootElement);				
				// abstr element
				Element abstr = doc.createElement("abstr");
				rootElement.appendChild(abstr);
				abstr.setAttribute("id", "abstract");				// set attribute to abstr element

				
				
				Element keywords = doc.createElement("keywords");
				List<Element> keywordList = GetKeywordListFromStringList(KeywordList);
                                putListOfElementOnRootElement(keywordList, keywords)	;	//ll
                          
                                 // abstr.appendChild(keywords);
                                
                                
                                
                                
// mettres les message dans la racine abstr depuis une listre de Msgs
				Element operations = doc.createElement("operations");
				putListOfElementOnRootElement(operationListe, operations)	;

                               abstr.appendChild(keywords);
                        putListOfElementOnRootElement(messageListe, abstr)	;

                              abstr.appendChild(operations);


				
				
				
				
				
				
			
				
				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File("/Users/retina/Desktop/test/file.xml"));

				// Output to console for testing
				// StreamResult result = new StreamResult(System.out);

				transformer.transform(source, result);
				System.out.println("File saved!");

			  } catch (Exception pce) {
				pce.printStackTrace();
			 
			
                          }
	 }
	 
	 
	 
	//---------------------------------Les fonctions------------------------------------------------------------
	 
	 
	List<Element> GetKeywordListFromStringList (List<String> L){    // retourne l'element keywords depuis une liste de String
                    List<Element> list=  new ArrayList<Element>();
			for (int i = 0; i < L.size(); i++) {
				Element keyword = doc.createElement("keyword");
                                keyword.setTextContent(L.get(i));
                                list.add(keyword);
			}
			return list;
			}
	 
	 
	 Element PartFrom2Strings (String name, String type){
			Element part = doc.createElement("part");
			part.setAttribute("name", name);
			part.setAttribute("type", type);			
			return part;
			}
	 
	 
	 Element SetMessageFromPartList(List<Element> partlist,String MessageName ) 
	 {		
			Element message = doc.createElement("message");	 
			for (int i = 0; i < partlist.size(); i++) {
			Element tempel = partlist.get(i);
			message.appendChild(tempel);
			message.setAttribute("name", MessageName);
			 }
		return message;
	 }
	 
	 
	 Element SetinOutFromMessageName(String InOut, String MessageName  ) 
	 {		
			Element InpOut = doc.createElement(InOut);	 
					
			InpOut.setAttribute("message", MessageName);
			 
			return InpOut;
		 }

	 
	 Element ConditionfromStrings (String PrePostcondition, String name,String content){ // retourne un element pré/postCondition depuis son nom , contenue, et type ( pre/post)
			Element condition = doc.createElement(PrePostcondition);
			condition.setAttribute("name", name);
			condition.setTextContent(content);	
	return condition;
			}
	 
	 
	 Element OperationFromString ( String name,Element input, Element output, List<Element> prepost){ // retourne un element operation
		 Element operation = doc.createElement("operation");
			operation.setAttribute("name", name);
			operation.appendChild(input);
			operation.appendChild(output);
			 Element conditions = doc.createElement("conditions");
			 operation.appendChild(conditions);
				for (int i = 0; i < prepost.size(); i++) {
					conditions.appendChild(	prepost.get(i));	
				}
			return operation;
			}
	 
	 
	 
	 void putListOfElementOnRootElement(List<Element> child, Element Root)
	 {
		 for (int i = 0; i < child.size(); i++) {
				
				Element tempmessg = child.get(i);
				Root.appendChild(tempmessg);

			}
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	public static void main(String args[]) {

	
	
	}

	
	
	
}