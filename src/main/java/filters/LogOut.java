/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import com.ecommerce.beans.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * user cannot see login page if he already logged in
 *
 * @author Tahoon
 */

@WebFilter(filterName = "LogOut",urlPatterns = {"/login.jsp"})
public class LogOut implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        User user = (User) ((HttpServletRequest) request).getSession().getAttribute("user");

        if (user == null) {
            chain.doFilter(request, response);
        } else {

            ((HttpServletResponse) response).sendRedirect("/E-Commerce/index.jsp");

        }
    }

   

}
