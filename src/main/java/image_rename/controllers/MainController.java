package image_rename.controllers;

import image_rename.repositories.PinRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/api")
public class MainController {

    @Autowired
    private PinRecordRepository pinRecordRepository;

    @GetMapping(path="/renameAll")
    public @ResponseBody String renameImageFiles () {

        return "Saved";
    }
}
