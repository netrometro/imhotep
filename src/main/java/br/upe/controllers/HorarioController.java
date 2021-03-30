package br.upe.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import br.upe.models.Doctor;

@WebServlet("/horarios")
public class HorarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public HorarioController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		 ArrayList<DateTime> horarios = new ArrayList<DateTime>();
		 doctors.add(new Doctor(0, "testeDoctor@gmail.com", "Pedro", "Rodrigues", "123,123,123-00", new DateTime(1988-05-10), "123", horarios));
		 doctors.add(new Doctor(1, "testeDoctor1@gmail.com", "Lucas", "Rodrigues", "123,123,123-00", new DateTime(1990-8-10), "123", horarios));
		 doctors.add(new Doctor(2, "testeDoctor2@gmail.com", "thays", "Rodrigues", "123,123,123-00", new DateTime(1994-10-10), "123", horarios));
		request.setAttribute(getServletName(), response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}
}
