package com.parsing.service.TelegramBot;

import com.parsing.domain.ParsingResult;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TelegramBotUpdate {

    public static void telegramBotStart(List<ParsingResult> parsingResults) throws IOException, InterruptedException {


        for (ParsingResult parRes : parsingResults) {


            while (true) {
                try {
                    String text = "";
                    List<String> list = new ArrayList<>();

                    while (true) {

                        list.add("");
                        list.add("<b>Вакансия: </b><a href='" + parRes.getLinkVacancy() + "'>" + parRes.getNameVacancy() + "</a>");
                        list.add("<b>Компания: </b><a href='" + parRes.getCompanyLink() + "'>" + parRes.getCompany().replace("<","").replace(">","") + "</a>");
                        if (parRes.getMetro().length() == 0) {
                            list.add("<b>Локация:</b> #" + parRes.getCity().replace("-","").replace(" ",""));
                        } else {
                            list.add("<b>Локация:</b> #" + parRes.getCity().replace("-","").replace(" ","") + ", м." + parRes.getMetro());
                        }
                        if (parRes.getSalary().length() != 0) {
                            list.add("<b>Уровень зп: </b>" + parRes.getSalary());
                        } else {
                            list.add("<b>Уровень зп: </b>не указана" );
                        }
                        list.add("<b>Тип занятости: </b>" + parRes.getTypeOfEmpoyment());
                        list.add("<b>График работы: </b>" + parRes.getSchedule());
                        list.add("<b>Требуемый опыт: </b>" + parRes.getWorkExperience());
                        list.add("");
                        list.add("<b>Краткое описание вакансии:</b>");
                        list.add("");
                        if (parRes.getDescriptionVacancy1().length() != 0) {
                            list.add(parRes.getDescriptionVacancy1().replace("<","").replace(">",""));
                        }
                        if (parRes.getDescriptionVacancy2().length() != 0) {
                            if (parRes.getDescriptionVacancy1().length() != 0){
                                list.add("");
                            }
                            list.add(parRes.getDescriptionVacancy2().replace("<","").replace(">",""));
                        }

                        list.add("");
                        list.add("<b>Вакансия публиковалась ранее.\nОбновлено работодателем: " + parRes.getDateVacancy() + ".21</b>");

                        list.add("#" + parRes.getCity().replace("-","").replace(" ","")+" #"+parRes.getTypeOfEmpoyment().replace(" ","_")+" #"+parRes.getSchedule().replace(" ","_")+" #"+parRes.getWorkExperience().replace(" ","_"));


                        for (String xxx : list) {

                            text = text + "\n" + xxx;

                        }



                        Thread.sleep(1000);
                        text = URLEncoder.encode(text, "UTF-8");



                        text = text + "&parse_mode=HTML&disable_web_page_preview=false";
                        System.out.println(text);
                        Thread.sleep(7000);


                        System.out.println(text);

                        if (!text.substring(1, 4).equals("250")){
                            break;
                        }else if (!text.substring(1, 4).equals("252")){
                            break;
                        }else{
                            System.out.println("Ошибка формата!");
                        }


                    }
                    //text = URLDecoder.decode(text, "UTF-8");//
                    //System.out.println(text);
                    //Thread.sleep(3000);
                    String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
                    String apiToken = "5308410405:AAGSNvBTbFXrIiQju3eLt2A_VRW7r0fL_js";

                    String chatId = "@og_parser";

                    System.out.println("Страна");
                    System.out.println(parRes.getCountry());

//                    if (parRes.getCountry().equals("Россия") && parRes.getLangProg().equals("JAVA")){
//                        chatId = "@og_parser";
//                    }else if (parRes.getCountry().equals("Беларусь") && parRes.getLangProg().equals("JAVA")){
//                        chatId = "@og_parser";
//                    }else if (parRes.getCountry().equals("Беларусь") && parRes.getLangProg().equals("tester") || (parRes.getCountry().equals("Беларусь") && parRes.getLangProg().equals("QA"))){
//                        chatId = "@og_parser";
//                    }else if ((parRes.getCountry().equals("Россия") && parRes.getLangProg().equals("tester")) || (parRes.getCountry().equals("Россия") && parRes.getLangProg().equals("QA"))){
//                        chatId = "@og_parser";
//                    }else if (parRes.getCountry().equals("Украина") && parRes.getLangProg().equals("JAVA")){
//                        chatId = "@og_parser";
//                    }else if (parRes.getCountry().equals("Украина") && parRes.getLangProg().equals("tester") || (parRes.getCountry().equals("Украина") && parRes.getLangProg().equals("QA"))){
//                        break;
//                    }




                    //Thread.sleep(2000);
                    urlString = String.format(urlString, apiToken, chatId, text);
                    URL url = new URL(urlString);
                    Thread.sleep(2000);
                    URLConnection conn = url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    InputStream is = null;
                    Thread.sleep(2000);
                    is = new BufferedInputStream(conn.getInputStream());

                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String inputLine = "";
                    while ((inputLine = br.readLine()) != null) {
                        sb.append(inputLine);
                    }
                    String response = sb.toString();
                    br.close();
                    is.close();
                    break;
                } catch (Exception e) {
                    System.out.println("Обрыв, подключаемся!");
                    e.printStackTrace();
                    System.out.println(e);
                    Thread.sleep(3000);
                }

            }


        }


    }


}
