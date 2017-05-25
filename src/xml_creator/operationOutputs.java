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
import static xml_creator.addkeywords1.j;
import static xml_creator.operationinputs.traitement;
import static xml_creator.operationinputs.messageList;




@WebServlet("/operationoutputs")
public class operationOutputs extends HttpServlet {
//	private static final long serialVersionUID = 1L;
	 static List<Element> partlist = new  ArrayList<Element>();
         	 static List<Element> Keywordlist = new  ArrayList<Element>();

       //  static  Document doc = null;
         static  Element part;
 public  static  Element message;
  public  static  Element output;

 



   


	public operationOutputs() {
            
        super();

            }


        @Override
	protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		   if (request.getParameter("fin") != null) {
                       j++
                       String messageName = ("output "+(j));
                       message = traitement.SetMessageFromPartList(partlist, messageName);
                                            messageList.add(message);

                        output = traitement.SetinOutFromMessageName("output", messageName);

                                  HttpSession session = request.getSession() ;
                                  session.setAttribute("messageout",message) ;	
                                  session.setAttribute("output",output) ;
                  
                                  

          	                		response.sendRedirect("PreConditions.jsp");

        }else {
		String name = request.getParameter("name");
                String type = request.getParameter("type");
                Element part = traitement.PartFrom2Strings(name, type);
                partlist.add(part);
                
                          	                		response.sendRedirect("operationOutputs.jsp");

              

		

	
	
	}
        }
	

}
