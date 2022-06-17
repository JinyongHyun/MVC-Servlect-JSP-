package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV1 implements ControllerV1 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        String username = request.getParameter("username"); //form에서 온것을 파라미터로 꺼내서 담는다
        int age = Integer.parseInt(request.getParameter("age"));//getParameter의 응답결과는 항상 String -> 숫자로 변환필요
        Member member = new Member(username, age);
        memberRepository.save(member);

        //model에 테이터 보관
        request.setAttribute("member", member);
        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}