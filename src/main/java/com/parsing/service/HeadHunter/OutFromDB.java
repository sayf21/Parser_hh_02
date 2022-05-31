package com.parsing.service.HeadHunter;


import com.parsing.domain.ParsingResult;
import com.parsing.domain.PublishedResult;
import com.parsing.repository.ParsingRepository;
import com.parsing.repository.PublishRepository;
import com.parsing.service.TelegramBot.TelegramBot;
import com.parsing.service.TelegramBot.TelegramBotUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class OutFromDB {


    public void outDromDB(ParsingRepository parsingRepository, PublishRepository publishRepository) throws InterruptedException  {

        List<ParsingResult> publishedResultsList = parsingRepository.findAllPublishInformation();

        try {
            TelegramBot.telegramBotStart(publishedResultsList);
        }catch (Exception e){
            System.out.println("Проблема с ботом!!!");
        }

        try {
            List<ParsingResult> updateParsingResult = new ArrayList<>();
            updateParsingResult = parsingRepository.updatePublishInformation();
            if (updateParsingResult.size()!=0){
                TelegramBotUpdate.telegramBotStart(updateParsingResult);
            }

        }catch (Exception e){
            System.out.println("Проблема с ботом при обновлении вакансии!!!");
        }

        try {
            parsingRepository.truncatePublish();
        }catch (Exception e){
            System.out.println("Ошибка копирования в БД 1");
        }

        try {
            parsingRepository.copyInPublishFromRezault();
        }catch (Exception e){
            System.out.println("Ошибка копирования в БД 2");
        }
    }
}
