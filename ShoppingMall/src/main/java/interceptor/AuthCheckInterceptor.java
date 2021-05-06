package interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception {
		HttpSession session = request.getSession(false);
		if (session != null) {
			Object authInfo = session.getAttribute("authInfo");
			if (authInfo != null) {
				return true;
			}
		}
		String login=request.getContextPath() + "/login";
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter printwriter = response.getWriter();
		printwriter.print("<script>alert('로그인이 필요합니다.'); location.href='"+login+"'; </script>");
		printwriter.flush();
		printwriter.close();
		return false;
	}

}
