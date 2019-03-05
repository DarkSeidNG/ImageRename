package image_rename.controllers;

import image_rename.repositories.PinRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

@Controller
@RequestMapping(path="/api")
public class MainController {

    @Autowired
    private PinRecordRepository pinRecordRepository;

    @GetMapping(path="/renameAll")
    public @ResponseBody String renameImageFiles () {

        File[] imageFiles = findImages();
        if (imageFiles != null) {
            for (final File imageFile : imageFiles) {
                renameImage(imageFile);
            }
        }
        return "Saved";
    }

    private File[] findImages() {
        File dir = new File("/home/iorji/Pictures/test");

        if (dir.isDirectory()) {
            return dir.listFiles();
        }
        return null;
    }

    private void renameImage(File imageFile){
        try {
            String imagePin = imageFile.getName().replaceAll("[^0-9]+", "");
            int imageId = pinRecordRepository.findByPin(Integer.parseInt(imagePin)).getUniq_id();
            File renamedImage = new File("/home/iorji/Pictures/test/" + imageId + ".jpg");

            if (imageFile.renameTo(renamedImage)) {
                System.out.println("Rename succesful");
            } else {
                System.out.println("Rename failed");
            }
        } catch (Exception e) {
            // TODO: handle exception
            //e.printStackTrace();
        }
    }

}
