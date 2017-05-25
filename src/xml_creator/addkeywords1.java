package xml_creator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Element;




@WebServlet("/addkeywords1")
public class addkeywords1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 static List<String> KeywordsStringList = new  ArrayList<String>();	
	 static List<Element> KeywordList = new  ArrayList<Element>();;
         static  Document doc ;
      static  XMLCreator traitements = new XMLCreator()  ;
   	 static Element keywordsElement  ;
     	 static	Element rootElement;
static  Element keywords;
         static int i=0; // pour les inputs incrémentale
         static int j=0; // pour les outputs incrémentale

   


	public addkeywords1() {
                    super();
                     

         try {   
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder docBuilder;
            
                docBuilder = docFactory.newDocumentBuilder();
            

	// root elements definition
	doc = docBuilder.newDocument();
	traitements.setDoc(doc);
        
            


		
        } catch (ParserConfigurationException ex) {
                Logger.getLogger(addkeywords1.class.getName()).log(Level.SEVERE, null, ex);
            }

            }


        @Override
	protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		   if (request.getParameter("fin") != null) {
                        for (int j = 0; j < KeywordsStringList.size(); j++) {
                 System.out.println("--------------------------------");

		System.out.println(KeywordsStringList.get(j));  }
                         HttpSession session = request.getSession() ;
	  	session.setAttribute("KeywordsStringList",KeywordsStringList) ;	
                
                /*
                On doit verivié le cas Vide
                */
                        
          	                		response.sendRedirect("operationinputs.jsp");

        }else {
		String s = request.getParameter("keyword");
		System.out.println(s);
                KeywordsStringList.add(s);
                                
               
                
               
                
	                		response.sendRedirect("getkeywords.jsp");
                                        

	
	}
        }
	

}
