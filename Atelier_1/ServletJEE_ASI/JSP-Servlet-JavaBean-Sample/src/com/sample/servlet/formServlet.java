package com.sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.controler.CardDao;
import com.sample.model.Affinity;
import com.sample.model.CardBean;
import com.sample.model.Family;
import com.sun.tools.javac.util.List;

/**
 * Servlet implementation class formServlet
 */
@WebServlet("/formServlet")
public class formServlet extends HttpServlet {
	private static final String LCARD = "lcard";
	private static final long serialVersionUID = 1L;
	private CardDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public formServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result="";
		CardBean cardBean = new CardBean();
		List<Object> test = null;

		for( Entry<String, String[]> att_entry : request.getParameterMap().entrySet()) {
            result= result +"<h3>"+ "["+att_entry.getKey()+"]:"+att_entry.getValue()[0]+"</h3>";
            test.add(att_entry.getValue());
        }
		
		cardBean.setName((String)test.get(0));
		cardBean.setDescription((String)test.get(1));
		cardBean.setImgUrl((String)test.get(2));
		cardBean.setFamily(Family.POKEMON);
		cardBean.setAffinity(Affinity.FIRE);
		cardBean.setHp((int)test.get(5));
		cardBean.setEnergy((int)test.get(6));
		cardBean.setAttack((int)test.get(7));
		cardBean.setDefense((int)test.get(8));

        
        PrintWriter writer = response.getWriter();
        writer.println("<h1> Below the list of sent params:</h2>");
        writer.println(result);
        
        getDao();
        
        dao.addCardToList(cardBean);        
	}
	
	public void getDao(){
		if(this.getServletContext().getAttribute("DAO")!=null){
			this.dao=(CardDao)this.getServletContext().getAttribute("DAO");
		}else{
			this.dao=new CardDao();
			this.getServletContext().setAttribute("DAO",this.dao);
		}
	}

}
