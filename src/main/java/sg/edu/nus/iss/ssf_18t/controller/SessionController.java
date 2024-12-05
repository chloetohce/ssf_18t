package sg.edu.nus.iss.ssf_18t.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpSession;
import sg.edu.nus.iss.ssf_18t.model.Session;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/sessions")
public class SessionController {
    
    @GetMapping("")
    public String allSessions(HttpSession session, Model model) {
        model.addAttribute("sessions", (List<Session>)session.getAttribute("sessions"));

        return "session-all";
    }

    @GetMapping("/create")
    public String createForm(HttpSession session, Model model) {
        model.addAttribute("session", new Session());
        return "session-create";
    }
    
    @PostMapping("/create")
    public String postCreateForm(@ModelAttribute("session") Session s, HttpSession session, Model model) {
        List<Session> sessions = (List<Session>) session.getAttribute("sessions");
        System.out.println("Before: " + sessions.toString());
        sessions.add(s);
        System.out.println("After: " + ((List<Session>)session.getAttribute("sessions")).toString());
        // session.setAttribute("sessions", sessions);
        
        return "redirect:/";
    }

    @GetMapping("/del")
    public String invalidate(HttpSession session) {
        session.removeAttribute("sessions");
        session.invalidate();
        return "redirect:/";
    }
    
    
    
}
