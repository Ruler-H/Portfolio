import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/authentication/*")
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AuthenticationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//루트 경로를 찾아오기
		String contextPath = request.getContextPath();
		//사용자의 요청 경로 찾기
		String requestURI = request.getRequestURI();
		//사용자의 요청 경로를 가지고 라우팅을 하는 것이 가능		사용자의 요청 경로에는 루트 경로가 포함되어 있다.
		//공통된 부분을 제외한 부분만 출력		여기까지의 작업은 프레임워크가 해준다.
		String routePath = requestURI.substring(contextPath.length() + 16);
		System.out.println(routePath);
		//전송 방식을 찾아온다. - GET과 POST
		String method = request.getMethod();
		//포워딩에 사용할 변수
		RequestDispatcher dispatcher = null;
		//라우팅
		switch(routePath) {
		//
		case "login" : 
			if(method.equals("GET")) {
				//login.jsp 파일로 포워딩
				dispatcher = request.getRequestDispatcher("../ex/login.jsp");
				dispatcher.forward(request, response);
			}else {
				//로그인 처리 - main.jsp로 이동하도록 작성		리다이렉트를 할 때 파일로 직접 리다이렉트 하지 말고
				//요청으로 리다이렉트 한 후 그 요청을 처리하는 곳에서 포워딩하도록 하는 것을 권장한다.
				response.sendRedirect("../ex/main.jsp");
			}
			break;
		case "main" :
			dispatcher = request.getRequestDispatcher("../ex/main.jsp");
			dispatcher.forward(request, response);
			break;
		case "write" :
			dispatcher = request.getRequestDispatcher("../ex/write.jsp");
			dispatcher.forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
