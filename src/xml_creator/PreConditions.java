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
import static xml_creator.operationinputs.traitement;




@WebServlet("/PreConditions")
public class PreConditions extends HttpServlet {
//	private static final long serialVersionUID = 1L;
         static int i=0;
	 public static List<Element> conditions = new  ArrayList<Element>();

 

 



   


	public PreConditions() {
            
        super();

            }


        @Override
	protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		   if (request.getParameter("fin") != null) {
                 

                              	
                
                  
                                  

          	                		response.sendRedirect("PostConditions.jsp");

        }else {
		String name = request.getParameter("name");
                String type = request.getParameter("type");
                Element condition = traitement.ConditionfromStrings("precondition", name, type);
                conditions.add(condition);
                
                          	                		response.sendRedirect("PreConditions.jsp");

              

		

	
	
	}
        }
	

}
