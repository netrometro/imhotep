package br.upe.controllers.auth.filter.specific;

import br.upe.model.entities.User;
import br.upe.model.entities.UserRole;
import br.upe.service.DatabaseContext;
import br.upe.util.DatabaseUtils;

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
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "PatientLogged", urlPatterns = {"/logged/patient/*"})
public class PatientFilter implements Filter {

    private String contextPath;

    public PatientFilter() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        User u = (User) session.getAttribute("userlogged");

        if (u == null) {
            session.invalidate();
            res.sendRedirect(contextPath + "/index.jsp");
        }else {
            DatabaseContext dbContext = DatabaseUtils.getDatabaseContext();
            UserRole userRole = dbContext.getUserRoles().Find(u.getUserRoleId());

            if (!userRole.getName().equalsIgnoreCase(UserRole.PATIENT)) {
                res.sendRedirect(contextPath + "/index.jsp");
                return;
            }else{
                res.setHeader("Cache-control", "no-cache, no-store");
                res.setHeader("Pragma", "no-cache");
                res.setHeader("Expires", "-1");
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
        this.contextPath = filterConfig.getServletContext().getContextPath();
    }

}