package org.example.ramian_pj.conf;

import org.example.ramian_pj.dto.UserJoinDTO;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        UserJoinDTO user = (UserJoinDTO) session.getAttribute("user");

        if(user == null){
            session.setAttribute("msg","로그인 후 이용 가능한 서비스입니다.");
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        return true;
    }
}
