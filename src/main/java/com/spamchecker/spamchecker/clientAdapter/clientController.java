package com.spamchecker.spamchecker.clientAdapter;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class clientController {

    private clientService cService;

    public clientController(clientService cService){
        this.cService = cService;
    }
    
    @GetMapping("/{email}")
    public ResponseDTO check(@PathVariable String email) throws IOException, InterruptedException{
        var responseJson = cService.getResponse(email);
        return responseJson;
    }
}
