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

import org.w3c.dom.Element;
import static xml_creator.PreConditions.conditions;
import static xml_creator.addkeywords1.KeywordsStringList;
import static xml_creator.addkeywords1.doc;
import static xml_creator.operation.operations;
import static xml_creator.operation.operationsC;
import static xml_creator.operationOutputs.partlist;
import static xml_creator.operationinputs.traitement;
import static xml_creator.operationinputs.messageList;
import static xml_creator.operationinputs.partlist;




@WebServlet("/applicationName")
public class applicationName extends HttpServlet {
//	private static final long serialVersionUID = 1L;
         static int i=0;

       //  static  Document doc = null;
         static  Element part;
 public  static  Element message;
  public  static  Element output;

 



   


	public applicationName() {
            
        super();

            }


        @Override
	protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		   if (request.getParameter("fin") != null) {
                       
                                String name = request.getParameter("name");                 

                                  HttpSession session = request.getSession() ;
                                  
                                  traitement.setDoc(doc);
                                    traitement.traitement(KeywordsStringList, messageList, operations,operationsC,name);
                                 

          	                		response.sendRedirect("merci.jsp");

        }else {
                       
                operationinputs.partlist.clear();
                operationOutputs.partlist.clear();
                conditions.clear();

                
                          	                		response.sendRedirect("operationinputs.jsp");

              

		

	
	
	}
        }
	

}
