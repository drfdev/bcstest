package drf.dev.interview.bcs.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JspController {
    private static Logger logger = LoggerFactory.getLogger(JspController.class);
    public JspController() {
        // empty
    }
    @RequestMapping(value = { "/", "/index" },
            method = RequestMethod.GET)
    public String indexJsp(Model model) {
        logger.info("CALL index.jsp");
        return "index";
    }
}
