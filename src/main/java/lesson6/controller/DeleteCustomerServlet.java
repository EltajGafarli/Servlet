package lesson6.controller;

import lesson6.DAO.CustomerDAO;
import lesson6.entity.Customer;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCustomerServlet extends HttpServlet {

    @Override
    @SneakyThrows
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        Long id = Long.parseLong(request.getParameter("id"));

        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = customerDAO.getCustomerByID(id);
        customerDAO.delete(customer);

        response.sendRedirect("/customers");
    }

}
