package com.parsing.service.HeadHunter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkForHH {

    List<List<String>> linkForHH(){

        List<List<String>> linkForHeadHunter = new ArrayList<>();

        String langProg = "JAVA";
//        String langProg = "QA";
//        String langProg = "тестир";

        Map<String, String> langMap = new HashMap<>();

        langMap.put("JAVA", "&text=java");
//        langMap.put("tester", "&text=тестир");
//        langMap.put("QA", "&text=QA");



        Map<String, String> countryMap = new HashMap<>();
//        countryMap.put("Беларусь", "&area=16");
        countryMap.put("Россия", "&area=113");
//        countryMap.put("Украина", "&area=5");

        Map<String, String> experienceMap = new HashMap<>();
        //Опыт работы
//        String noMatter = "&experience=doesNotMatter"; //Не имеет значения
        String noExperience = "&experience=noExperience"; //Без опыта
//        String betweenOneAndThree = "&experience=between1And3"; //от 1 до 3 лет
//        String betweenThreeAndSix = "&experience=between3And6"; //от 3 до 6 лет
//        String moreThanSix = "&experience=moreThan6"; //более 6 лет

//        experienceMap.put("не имеет значения",noMatter);
        experienceMap.put("без опыта",noExperience);
//        experienceMap.put("от 1 до 3 лет",betweenOneAndThree);
//        experienceMap.put("от 3 до 6 лет",betweenThreeAndSix);
//        experienceMap.put("более 6 лет",moreThanSix);


        Map<String, String> employmentMap = new HashMap<>();
        //Тип занятости
        String employmentFull = "&employment=full"; //Полная занятость
        String employmentPart = "&employment=part"; //Частичная занятость
        String employmentProject = "&employment=project"; //Разовая работа
        String employmentProbation = "&employment=probation"; //Стажировка

        employmentMap.put("полная занятость",employmentFull);
        employmentMap.put("частичная занятость",employmentPart);
        employmentMap.put("разовая работа",employmentProject);
        employmentMap.put("стажировка",employmentProbation);


        Map<String, String> scheduleMap = new HashMap<>();
        //График работы
        String scheduleFullDay = "&schedule=fullDay"; //Полный день
//        String scheduleShift = "&schedule=shift"; //Сменный график
//        String employmentFlexible = "&schedule=flexible"; //Гибкий график
//        String employmentRemote = "&schedule=remote"; //Удаленная работа

        scheduleMap.put("полный день",scheduleFullDay);
//        scheduleMap.put("сменный график",scheduleShift);
//        scheduleMap.put("гибкий график",employmentFlexible);
//        scheduleMap.put("удаленная работа",employmentRemote);

        String lang = "";
        String langName = "";
        String country = "";
        String countryName = "";
        String experience = "";
        String experienceName = "";
        String employment = "";
        String employmentName = "";
        String schedule = "";
        String scheduleName = "";

        String linkForPars ="https://hh.ru/search/vacancy?st=searchVacancy&text=langProg&search_field=name"+country+"&salary=&currency_code=USD"+experience+employment+schedule+"&order_by=relevance&search_period=0&items_on_page=100&no_magic=true&L_save_area=true&page=";

        for (Map.Entry<String, String> langMapa : langMap.entrySet()){

            lang = langMapa.getValue();
            langName = langMapa.getKey();

            for (Map.Entry<String, String> countryMapa : countryMap.entrySet()){

                country = countryMapa.getValue();
                countryName = countryMapa.getKey();

                for (Map.Entry<String, String> experienceMapa : experienceMap.entrySet()){
                    experience = experienceMapa.getValue();
                    experienceName = experienceMapa.getKey();

                    for (Map.Entry<String, String> employmentMapa : employmentMap.entrySet()){
                        employment = employmentMapa.getValue();
                        employmentName = employmentMapa.getKey();

                        for (Map.Entry<String, String> scheduleMapa : scheduleMap.entrySet()){
                            schedule = scheduleMapa.getValue();
                            scheduleName = scheduleMapa.getKey();

                            linkForPars ="https://hh.ru/search/vacancy?st=searchVacancy"+lang+"&search_field=name"+country+"&salary=&currency_code=USD"+experience+employment+schedule+"&order_by=relevance&search_period=0&items_on_page=100&no_magic=true&L_save_area=true&page=";

                            List<String> listOneLink = new ArrayList<>();
                            listOneLink.add(linkForPars);
                            listOneLink.add(countryName);
                            listOneLink.add(experienceName);
                            listOneLink.add(employmentName);
                            listOneLink.add(scheduleName);
                            listOneLink.add(langName);


                            linkForHeadHunter.add(listOneLink);

                        }
                    }

                }
            }
        }

        return linkForHeadHunter;
    }

}
