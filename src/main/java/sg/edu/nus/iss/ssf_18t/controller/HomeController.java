package sg.edu.nus.iss.ssf_18t.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import sg.edu.nus.iss.ssf_18t.model.Session;


@Controller
@RequestMapping("")
public class HomeController {
    
    @GetMapping("")
    public ModelAndView homePage(HttpSession session) {
        ModelAndView mav = new ModelAndView("index");

        if (session.getAttribute("sessions") == null) {
            session.setAttribute("sessions", new ArrayList<Session>());
        }
        
        mav.setStatus(HttpStatusCode.valueOf(200));
        return mav;
    }
    
    
}
