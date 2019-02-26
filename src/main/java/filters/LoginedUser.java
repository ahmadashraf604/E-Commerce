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
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tahoon
 */
@WebFilter(filterName = "LoginedUser",urlPatterns = {"/user_profile.jsp","/user_edit_profile.jsp","/MyCart.jsp",})
public class LoginedUser implements Filter {

    public LoginedUser() {
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
        
        User user = (User) ((HttpServletRequest) request).getSession().getAttribute("user");
        
        if (user != null )
        {
            chain.doFilter(request, response);
        } else {
           
             ((HttpServletResponse) response).sendRedirect("/E-Commerce/login.jsp");
//        User user = (User) ((HttpServletRequest) request).getSession().getAttribute("user");
//       // User user = new User();
//       /// /////////////////   user = null 
//         if (user != null && user.getEmail().equalsIgnoreCase("mohamed.tahoon15@gmail.com")) {
//            chain.doFilter(request, response);
//        } else {
//            ((HttpServletResponse) response).sendRedirect("/E-Commerce/login.jsp");
//        }    
//    }
        }}
    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}
