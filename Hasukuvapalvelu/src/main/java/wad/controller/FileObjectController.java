
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import wad.repository.FileObjectRepository;

@Controller
public class FileObjectController {
    
    @Autowired
    private FileObjectRepository fileObjectRepo;
    
}
