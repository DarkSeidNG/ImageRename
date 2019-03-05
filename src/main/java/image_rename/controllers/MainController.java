package image_rename.controllers;

import image_rename.constants.GlobalConstants;
import image_rename.models.PinRecord;
import image_rename.repositories.PinRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

/**
 * The principal API Controller.
 */
@Controller
@RequestMapping(path="/api")
public class MainController {

    @Autowired
    private PinRecordRepository pinRecordRepository;

    @GetMapping(path="/")
    public @ResponseBody String hello () {
        return "hello alien!";
    }

    /**
     * renameImage endpoint that is called to rename all images in a particular directory.
     *
     * @return the string
     */
    @GetMapping(path="/renameAll")
    public @ResponseBody String renameImageFiles () {

        File[] imageFiles = findImages(); //get an array of all images
        if (imageFiles != null) {
            for (final File imageFile : imageFiles) {
                renameImage(imageFile);
            }
        }
        else{
            return GlobalConstants.IMAGES_NOT_FOUND;
        }

        return GlobalConstants.IMAGES_FOUND;
    }

    /**
     * Method to find all images in a specified directory
     * @return
     */
    private File[] findImages() {
        File dir = new File(GlobalConstants.IMAGE_DIRECTORY);

        if (dir.isDirectory()) {
            return dir.listFiles();
        }
        return null;
    }

    /**
     * Rename Image method that takes the image file, retrieve the pin from the image
     * search for the pin on the db and if found rename the image to the [uniq_id].jpg
     * @param imageFile
     */
    private void renameImage(File imageFile){
        try {
            String imagePin = imageFile.getName().replaceAll("[^0-9]+", "");
            PinRecord pinRecord = pinRecordRepository.findByPin(Integer.parseInt(imagePin));
            if (pinRecord != null){
                int imageId = pinRecord.getUniq_id();
                if (imageId != -1) {
                    File renamedImage = new File(GlobalConstants.IMAGE_DIRECTORY + imageId + GlobalConstants.FILE_EXTENSION);

                    if (imageFile.renameTo(renamedImage)) {
                        System.out.println(GlobalConstants.SUCCESS_MESSAGE);
                    } else {
                        System.out.println(GlobalConstants.FAILURE_MESSAGE);
                    }
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
            //e.printStackTrace();
        }
    }


}
