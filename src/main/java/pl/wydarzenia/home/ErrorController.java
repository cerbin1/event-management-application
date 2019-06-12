package pl.wydarzenia.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    private static final String ERROR = "/error";

    @GetMapping(ERROR)
    public String handleError() {
        return ERROR;
    }

    @Override
    public String getErrorPath() {
        return ERROR;
    }
}
