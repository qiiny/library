package top.qiin.library.util;


import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import top.qiin.library.bean.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @program: demo6
 * @description:
 * @author: qin
 * @create: 2019-12-30 22:20
 **/
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if (user==null){
            PrintWriter pw = response.getWriter();
            pw.flush();
            response.setCharacterEncoding("utf-8");
            pw.println("请登录");
            return false;
        }
        boolean haveAnnotataion =handler.getClass().isAssignableFrom(HandlerMethod.class);
        System.out.println(haveAnnotataion);
        if (haveAnnotataion){
            OnlyAdmin oa=((HandlerMethod)handler).getMethodAnnotation(OnlyAdmin.class);
            if (oa!=null){
                Object user1 = request.getSession().getAttribute("user");
                System.out.println("qie"+user1);
                if (((Student)user1).getAdministrator()!=1){
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("text/json;charset=utf-8");
                    PrintWriter pw = response.getWriter();
                    pw.flush();
                    pw.println("{\"msg\":\"你未有该权限\"}");
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request,
                                               HttpServletResponse response, Object handler) throws Exception {
        // TODO Auto-generated method stub
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        super.postHandle(request, response, handler, modelAndView);
    }

}
