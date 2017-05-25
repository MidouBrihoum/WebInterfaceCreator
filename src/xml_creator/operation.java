package xml_creator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.w3c.dom.Document;
import static xml_creator.PreConditions.conditions;

import org.w3c.dom.Element;
import static xml_creator.addkeywords1.traitements;
import static xml_creator.operationinputs.traitement;




@WebServlet("/operation")
public class operation extends HttpServlet {
//	private static final long serialVersionUID = 1L;
         static int i=0;
	 static List<Element> operations = new  ArrayList<Element>();


    

 



   


	public operation() {
            
        super();

            }


        @Override
	protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		String name = request.getParameter("name");
                                   HttpSession session = request.getSession() ;
                                   
                                                           Document d = traitement.getDoc();
                                                           

                         Element input =  (Element)  session.getAttribute("input") ;
                         Element output =  (Element)  session.getAttribute("output") ;	
//deeleeet---------------------------------------------------------------------------
//                          Element     el1  = d.createElement("aa");
//                            Element     el2  = d.createElement("bb");
//                            List<Element> liste = new   ArrayList<Element>();
//                            liste.add(el2);
//                            liste.add(el1);
//                            
  //-------------------------------------------------
                            


                         
              operations.add(  traitement.OperationFromString(name, input, output, conditions));
                session.setAttribute("operationsList", operations);
          
                
                          	                		response.sendRedirect("confirmation.jsp");

              

		

	
	
	
        }
	

}
