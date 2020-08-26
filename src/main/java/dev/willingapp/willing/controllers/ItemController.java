package dev.willingapp.willing.controllers;

import dev.willingapp.willing.models.*;
import dev.willingapp.willing.repositories.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ItemController {

    private final UserRepository usersDao;
    private final AlbumRepository albumsDao;
    private final ItemRepository itemsDao;
    private final ImageRepository imagesDao;
    private final InterestRepository interestsDao;

    public ItemController(UserRepository usersDao, AlbumRepository albumsDao, ItemRepository itemsDao, ImageRepository imagesDao, InterestRepository interestsDao) {
        this.usersDao = usersDao;
        this.albumsDao = albumsDao;
        this.itemsDao = itemsDao;
        this.imagesDao = imagesDao;
        this.interestsDao = interestsDao;
    }

    @GetMapping("/items/items")
    public String showItem(Model model) { return "items/items";}

    @GetMapping("/items/{id}")
    public String showSingleItem(@PathVariable long id, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = usersDao.getOne(user.getId());
        Item item = itemsDao.getOne(id);
        List<Image> images = item.getImages();
        List<Image> photos = new ArrayList<>();
        List<Image> videos = new ArrayList<>();
        List<Interest> interests = interestsDao.findAll();
        for (Interest x : interests) {
            if (x.getInterestedUser().getId() == thisUser.getId() && x.getItem().getId() == id) {
                model.addAttribute("hasRank", true);
                model.addAttribute("interest", x);
                break;
            }
        }
        boolean isOwner = false;
        boolean hasPhotos = false;
        for (Image x : images) {
            if (x.getFileType().equalsIgnoreCase("video/mp4")) {
                videos.add(x);
            } else if (x.getFileType().equalsIgnoreCase("image/jpeg")) {
                photos.add(x);
            }
        }
        if (item.getAlbumForItems().getOwner().getId() == thisUser.getId()) {
            isOwner = true;
            model.addAttribute("isOwner", true);
        }
        if (!images.isEmpty()) {
            hasPhotos = true;
            Image singleImage = photos.remove(0);
            model.addAttribute("hasPhotos", hasPhotos);
            model.addAttribute("singleImage", singleImage);
        }

        model.addAttribute("user", thisUser);
        model.addAttribute("item", item);
        model.addAttribute("photos", photos);
        model.addAttribute("videos", videos);
        return "items/item";
    }

    @GetMapping("/items/{id}/edit")
    public String editItem(@PathVariable long id, Model model) {
        Item item = itemsDao.getOne(id);
        List<Image> images = item.getImages();
        List<Image> photos = new ArrayList<>();
        List<Image> videos = new ArrayList<>();
        for (Image x : images) {
            if (x.getFileType().equalsIgnoreCase("video/mp4")) {
                videos.add(x);
            } else if (x.getFileType().equalsIgnoreCase("image/jpeg")) {
                photos.add(x);
            }
        }
        model.addAttribute("item", item);
        model.addAttribute("photos", photos);
        model.addAttribute("videos", videos);
        return "items/edit";
    }

    @PostMapping("/items/{id}/edit")
    public String editedItem(@PathVariable long id, @RequestParam(name = "item-name") String name, @RequestParam(name = "item-description") String description, @RequestParam(name = "item-lineage") String lineage, @RequestParam(name = "images") String[] images, @RequestParam(name = "file-type") String[] fileType) {
        Item item = itemsDao.getOne(id);
        item.setTitle(name);
        item.setDescription(description);
        item.setLineage(lineage);
        itemsDao.save(item);
        List<String> newImages = Arrays.asList(images);
        List<String> fileTypes = Arrays.asList(fileType);
        for (int i = 0; i < newImages.size(); i++) {
            Image newImage = new Image();
            newImage.setAlbumWithImages(item.getAlbumForItems());
            newImage.setFilename(newImages.get(i));
            newImage.setFileType(fileTypes.get(i));
            newImage.setItemImage(item);
            imagesDao.save(newImage);
        }
        return "redirect:/items/" + id;
    }

    @GetMapping("/albums/{id}/items/create")
    public String createItems(@PathVariable long id, Model model) {
        model.addAttribute("album", albumsDao.getOne(id));
        return "items/items-create";
    }

    @PostMapping("/albums/{id}/items/create")
    public String newlyCreatedItems(@PathVariable long id, @RequestParam(name = "item-name") String itemName, @RequestParam(name = "item-description") String itemDescription, @RequestParam(name = "item-lineage") String itemLineage, @RequestParam(name = "images") String[] images, @RequestParam(name = "file-type") String[] fileType) {
        List<String> newImages = Arrays.asList(images);
        List<String> fileTypes = Arrays.asList(fileType);
        Album album = albumsDao.getOne(id);
        Item item = new Item(album, itemName, itemDescription, itemLineage);
        itemsDao.save(item);
        for (int i = 0; i < newImages.size(); i++) {
            Image newImage = new Image();
//            newImage.setAlbumWithImages(album);
            newImage.setFilename(newImages.get(i));
            newImage.setFileType(fileTypes.get(i));
            newImage.setItemImage(item);
            imagesDao.save(newImage);
        }
        return "redirect:/albums/" + album.getId();
    }

    @PostMapping("/albums/{albumId}/items/{itemId}/delete")
    public String deleteItem(@PathVariable long albumId, @PathVariable long itemId) {
        itemsDao.delete(itemsDao.getOne(itemId));
        return "redirect:/albums/" + albumId;
    }

    @PostMapping("/items/{itemId}/image/{imageId}")
    public String deleteImage(@PathVariable long itemId, @PathVariable long imageId) {
        Image deleteImage = imagesDao.getOne(imageId);
        imagesDao.delete(deleteImage);
        return "redirect:/items/" + itemId + "/edit";
    }

    @PostMapping("/items/{itemsId}/user/{userId}/{rank}")
    public String interest(@PathVariable long itemsId, @PathVariable long userId, @PathVariable int rank, Model model) {
        Item item = itemsDao.getOne(itemsId);
        User user = usersDao.getOne(userId);
        Interest interest = new Interest();
        List<Interest> interests = new ArrayList<>();
        if (user.getInterests().isEmpty()) {
            interest.setInterestedUser(user);
            interest.setItem(item);
            interest.setInterestRanking(rank);
            interestsDao.save(interest);
            user.getInterests().add(interest);
            usersDao.save(user);
            return "redirect:/items/" + itemsId;
        } else {
            int num = 0;
            for (Interest x : user.getInterests()) {
                if (x.getItem().getId() == itemsId) {
                    num += 1;
                }
            }
            if (num == 0) {
                    interest.setInterestedUser(user);
                    interest.setItem(item);
                    interest.setInterestRanking(rank);
                    interestsDao.save(interest);
                    user.getInterests().add(interest);
                    usersDao.save(user);
                    return "redirect:/items/" + itemsId;
            }
        }
//        else {
//            for (Interest x : user.getInterests()) {
//                if (x.getItem().getId() == itemsId && x.getInterestRanking() == rank) {
//                    return "redirect:/items/" + itemsId;
//                } else if (x.getItem().getId() == itemsId && x.getInterestRanking() != rank) {
//                    Interest deleteInterest = interestsDao.getOne(x.getId());
//                    interestsDao.delete(deleteInterest);
//                    interest.setInterestedUser(user);
//                    interest.setItem(item);
//                    interest.setInterestRanking(rank);
//                    interestsDao.save(interest);
//                    interests.add(interest);
//                    user.setInterests(interests);
//                    usersDao.save(user);
//                    return "redirect:/items/" + itemsId;
//                }
//            }
//        }
//        interest.setInterestedUser(user);
//        interest.setItem(item);
//        interest.setInterestRanking(rank);
//        user.getInterests().add(interest);
//        usersDao.save(user);
//        interestsDao.save(interest);
        return "redirect:/items/" + itemsId;
    }

}
