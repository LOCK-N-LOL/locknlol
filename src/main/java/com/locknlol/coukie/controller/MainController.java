package com.locknlol.coukie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author Haylie
 * @since 2017. 5. 16..
 */

@Controller
public class MainController {

    @RequestMapping("/")
    public String main() {
        return "index";
    }

    @RequestMapping("//riot.txt")
    public void getFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String docName = URLEncoder.encode("riot.txt","UTF-8");
        response.setContentType("text/plain");
        PrintWriter txtPrinter = response.getWriter();

        // 2. 소스코드 출력
        String contents = "8ea8ab20-7d80-4a6a-9e81-336085bcd287";
        String snippet = URLDecoder.decode(contents, "UTF-8");
        txtPrinter.print(contents);
        response.flushBuffer();

    }
}
