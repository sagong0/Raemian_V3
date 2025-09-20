package org.example.ramian_pj.conf;

import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.ReserveDTO;
import org.example.ramian_pj.dto.UserJoinDTO;
import org.example.ramian_pj.service.ReserveService;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class ReserveCheckInterceptor implements HandlerInterceptor {

    private final ReserveService reserveService;

    public ReserveCheckInterceptor(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        UserJoinDTO user = (UserJoinDTO) session.getAttribute("user");

        // 로그인은 LoginCheckInterceptor 에서 이미 걸러짐
        if (user != null) {

            ReserveDTO reserve = reserveService.getReservationByMemberId(user.getId());

            if (reserve == null) {
                // 1) Flash 메시지 작성
                FlashMap flashMap = RequestContextUtils.getOutputFlashMap(request);
                flashMap.put("msg", "예약 후 사용해주세요.");

                // 타깃 경로: 컨텍스트패스 제외 내부 경로로 지정해야 정확히 매칭됨
                flashMap.setTargetRequestPath(request.getContextPath() + "/reserve");

                // 2) FlashMap 저장
                FlashMapManager flashMapManager = RequestContextUtils.getFlashMapManager(request);
                if (flashMapManager != null) {
                    flashMapManager.saveOutputFlashMap(flashMap, request, response);
                }

                // 3) 리다이렉트
                response.sendRedirect( request.getContextPath() + "/reserve");
                return false;
            }
        }
        return true;
    }
}
