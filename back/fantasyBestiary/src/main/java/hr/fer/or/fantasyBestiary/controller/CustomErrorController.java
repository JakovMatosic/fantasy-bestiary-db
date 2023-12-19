package hr.fer.or.fantasyBestiary.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomErrorController implements ErrorController {

	private final ResourceLoader resourceLoader;

    public CustomErrorController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    
    @RequestMapping("/error")
    @ResponseBody
    public String handleError() throws IOException {
        // Load the HTML file from the resources folder
        Resource resource = resourceLoader.getResource("classpath:templates/error.html");

        // Read the contents of the HTML file into a string
        try (InputStream inputStream = resource.getInputStream();
             Scanner scanner = new Scanner(inputStream, "UTF-8")) {

            // Use a StringBuilder to accumulate the content
            StringBuilder content = new StringBuilder();

            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine());
                content.append("\n"); // Optional: Add newline character if needed
            }

            return content.toString();
        }
    }
}
