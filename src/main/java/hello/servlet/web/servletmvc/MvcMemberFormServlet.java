package hello.servlet.web.servletmvc;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // jsp 경로 설정
        String viewPath = "/WEB-INF/views/new-form.jsp";
        //컨트롤러에서 view로 이동할 때 사용
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        //서블릿에서 jsp 호출가능
        //다른 서블릿이나 JSP로 이동할 수 있는 기능이다. 
        // 서버 내부에서 다시 호출이 발생한다. ->url 변경 없다(메서드처럼) ->클라이언트에서 서버로 호출할때 서버 안에서만 응답을 만든다
        //바로 url 치면 안됨. 컨틀롤러 거쳐야 뷰단에 표시됨
        //WEB-INF 안에 있는 파일은 컨트롤러를 통하지 않으면 호출이 안된다는 뜻이다.
        dispatcher.forward(request, response);
    }
}