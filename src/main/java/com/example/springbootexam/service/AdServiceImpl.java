package com.example.springbootexam.service;

import com.example.springbootexam.dto.AdDto;
import com.example.springbootexam.model.Ad;
import com.example.springbootexam.model.User;
import com.example.springbootexam.repository.AdRepository;
import com.example.springbootexam.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdRepository adRepository;

    private Logger logger = LoggerFactory.getLogger(AdServiceImpl.class);


    @Override
    public Ad add(AdDto adDto) {
        Date date = new Date();
        Ad ad = Ad.builder()
                .author(adDto.getAuthor())
                .date(date)
                .text(adDto.getText())
                .build();
        return adRepository.save(ad);
    }

    @Override
    public Ad getById(Long id) {
        Optional<Ad> userOptional = adRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            logger.warn("Объявление с id={} не найдена", id);
            throw new NoSuchElementException("Объявление с id=" + id + " не найдена");
        }
    }

    @Override
    public List<Ad> getAllAdes() {
        return adRepository.findAll();
    }

    @Override
    public Ad updateAd(Long adId, AdDto adDto) {
        Ad adUpdate = adRepository.findById(adId).orElseThrow(IllegalArgumentException::new);
        adUpdate.setAuthor(adDto.getAuthor());
        adUpdate.setText(adDto.getText());
        adRepository.save(adUpdate);
        return adUpdate;
    }

    @Override
    public void deleteAd(Long adId) {
        Ad adDelete = adRepository.findById(adId).orElseThrow(IllegalArgumentException::new);
        adRepository.delete(adDelete);
    }
}
