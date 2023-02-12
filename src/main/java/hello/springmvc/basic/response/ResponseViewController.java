package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseView1() {
        ModelAndView mav = new ModelAndView("response/hello").addObject("data", "hello");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!!");
        return "response/hello";
    }

    /**
     * Controller를 사용하고 HttpServletResponse, OutputStream(Writer) 같은 HTTP메시지바디를 처리하는 파라미터가 없으면
     * 요청 URL을 참고해서 논리 뷰 이름으로 사용
     * 이 방식은 명시성이 너무 떨어지고 이렇게 딱 맞는 경우도 많이 없어서, 권장하지 않는다
     * @param model
     */
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello@@@");
    }
}
