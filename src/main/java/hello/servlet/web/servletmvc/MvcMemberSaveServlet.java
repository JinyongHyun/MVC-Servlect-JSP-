package hello.servlet.web.servletmvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberSaveServlet",urlPatterns = "/Servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository=MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username=req.getParameter("username"); //form에서 온것을 파라미터로 꺼내서 담는다
        int age=Integer.parseInt(req.getParameter("age")); //getParameter의 응답결과는 항상 String -> 숫자로 변환필요

        Member member=new Member(username,age);
        memberRepository.save(member);
        
        //model에 테이터 보관
        req.setAttribute("member",member);

        String viewPath = "/WEB-INF/view/save-result.jsp";
        RequestDispatcher dispatcher=req.getRequestDispatcher(viewPath);
        dispatcher.forward(req,resp);

    }
}
