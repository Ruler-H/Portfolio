package kr.co.bh.todo.filter;

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
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/write.do")
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//주의할 점은 매개변수인 request가 HttpServletRequest가 아니라서 강제 형 변환을 해서 사용해야 한다.
		HttpServletRequest req = (HttpServletRequest)request;
		String id = (String)req.getSession().getAttribute("id");
		//로그인이 되어 있지 않다면
		if(id == null) {
			HttpServletResponse rep = (HttpServletResponse)response;
			//이전 요청을 세션에 저장
			req.getSession().setAttribute("path", req.getRequestURI());
			rep.sendRedirect("login.do");
		}else {
			//원래 요청을 처리
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
