package com.example.springbootexam.service;

import com.example.springbootexam.dto.AdDto;
import com.example.springbootexam.dto.UserDto;
import com.example.springbootexam.model.Ad;
import com.example.springbootexam.model.User;

import java.util.List;

public interface AdService {
    Ad add(AdDto adDto);
    Ad getById(Long id);
    List<Ad> getAllAdes();
    Ad updateAd(Long adId, AdDto adDto);
    void deleteAd(Long adId);
}
