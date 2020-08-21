package dev.willingapp.willing.controllers;

import dev.willingapp.willing.models.Image;
import dev.willingapp.willing.models.Item;
import dev.willingapp.willing.repositories.ImageRepository;
import dev.willingapp.willing.repositories.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class ItemController {

    private final ItemRepository itemsDao;
    private final ImageRepository imagesDao;

    public ItemController(ItemRepository itemsDao, ImageRepository imagesDao) {
        this.itemsDao = itemsDao;
        this.imagesDao = imagesDao;
    }

    @GetMapping("/items/items")
    public String showItem(Model model) { return "/items/items";}

    @GetMapping("/items/create")
    public String createItems(Model model) {
        return "/items/items-create";
    }

    @PostMapping("/items/create")
    public String newlyCreatedItems(@RequestParam(name = "item-name") String itemName, @RequestParam(name = "item-description") String itemDescription, @RequestParam(name = "item-lineage") String itemLineage, @RequestParam(name = "images") String[] images, @RequestParam(name = "file-type") String[] fileType) {
        List<String> newImages = Arrays.asList(images);
        List<String> fileTypes = Arrays.asList(fileType);
        Item item = new Item(1L, itemName, itemDescription, itemLineage);
        itemsDao.save(item);
        for (int i = 0; i < newImages.size(); i++) {
            Image newImage = new Image();
            newImage.setFilename(newImages.get(i));
            newImage.setFileType(fileTypes.get(i));
            newImage.setItemImage(item);
            imagesDao.save(newImage);
        }

        return "albums";
    }

}
