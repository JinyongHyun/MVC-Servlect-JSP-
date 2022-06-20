package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    //반환타입 -request나 response는 컨트롤러에서는 사용하지 않는다.
    //단순 파라미터 값이 필요한 것이기 때문에 이를 model객체로 처리한다.
    //우리가 만드는 프레임워크에 종속적, 서블릿에 종속적이지 않음
    ModelView process(Map<String,String> paramMap);
}
