package hello.servlet.web.frontcontroller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

//모든 컨트롤러에서 연산결과를 화면에서 보여주기 위해 dispatcher foward를 반복사용
//Myvies를 사용해서 분리, 별도로 view 처리
//각각의 컨트롤러에서 했던 로직을 MyView에 만든 것
public class MyView {

    private String viewPath;

    //초기화 생성자
    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modelTORequestAttribute(model, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }

    private void modelTORequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        model.forEach((key,value)->request.setAttribute(key,value));
    }
}

