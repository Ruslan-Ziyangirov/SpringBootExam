package com.example.springbootexam.controllers;

import com.example.springbootexam.dto.AdDto;
import com.example.springbootexam.model.Ad;
import com.example.springbootexam.service.AdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/ades")
public class AdController {
    private Logger logger = LoggerFactory.getLogger(AdController.class);

    @Autowired
    private AdService adService;


    @GetMapping("/{id}")
    public ResponseEntity<Ad> getAdById(@PathVariable Long id) {
        try {
            Ad ad = adService.getById(id);
            logger.info(ad.toString());
            return ResponseEntity.ok(ad);
        } catch (NoSuchElementException e) {
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/adeslist")
    @ResponseBody
    public ResponseEntity<List<Ad>> getUsers() {
        try {
            List<Ad> list = adService.getAllAdes();
            return ResponseEntity.ok(list);
        }catch (NoSuchElementException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Ad> addAd(AdDto adDto) {
        return ResponseEntity.ok(adService.add(adDto));
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Ad> updateUser(@PathVariable("id") Long id, @RequestBody AdDto adDto) {
        try {
            return ResponseEntity.ok(adService.updateAd(id, adDto));
        }catch (NoSuchElementException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        adService.deleteAd(id);
        return ResponseEntity.ok().build();
    }
}

