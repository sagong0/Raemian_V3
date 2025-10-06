package org.example.ramian_pj.conf;

import org.example.ramian_pj.dto.AdminJoinDTO;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class AdminLoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object admin =  session.getAttribute("admin");

        if(admin == null){
            FlashMap flash = RequestContextUtils.getOutputFlashMap(request);
            flash.put("msg", "관리자 로그인이 필요합니다.");
            FlashMapManager fmm = RequestContextUtils.getFlashMapManager(request);
            Objects.requireNonNull(fmm).saveOutputFlashMap(flash, request, response);
            response.sendRedirect(request.getContextPath() + "/admin");
            return false;
        }

        return true;
    }
}
