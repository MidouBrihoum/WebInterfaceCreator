package xml_creator;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import static xml_creator.addkeywords1.i;
import static xml_creator.addkeywords1.traitements;




@WebServlet("/operationinputs")
public class operationinputs extends HttpServlet {
//	private static final long serialVersionUID = 1L;
	 static List<Element> partlist = new  ArrayList<Element>();
         static List<Element> messageList = new  ArrayList<Element>();

         static  Element part;
 public  static  Element message;
  public  static  Element input;
   public  static  XMLCreator traitement  ;


   


	public operationinputs() {
            
        super();
    traitement=traitements;

            }


        @Override
	protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		   if (request.getParameter("fin") != null) {
                       i++;
                       String messageName = ("input "+(i));
                       message = traitement.SetMessageFromPartList(partlist, messageName);
                     messageList.add(message);
                        input = traitement.SetinOutFromMessageName("input", messageName);

                                  HttpSession session = request.getSession() ;
                                  session.setAttribute("messagein",message) ;	
                                  session.setAttribute("input",input) ;	

          	                		response.sendRedirect("operationOutputs.jsp");

        }else {
		String name = request.getParameter("name");
                String type = request.getParameter("type");
                Element part = traitement.PartFrom2Strings(name, type);
                partlist.add(part);
                
                
                        	                		response.sendRedirect("operationinputs.jsp");


		

	
	
	}
        }
	

}
