package com.parsing.service.HeadHunter;

import com.parsing.domain.ParsingResult;
import com.parsing.repository.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class HeadHunterSelenium {


    public void parsing(String counry, String exper, String langProg, String linkVac, ParsingRepository parsingRepository, PublishRepository publishRepository) throws InterruptedException {
        System.out.println("Дошло");
        int countForCloseWD = 0;

        while (true) {
            try {
                System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe"); //прописываем адрес для драйвера
                ProfilesIni listProfiles = new ProfilesIni();
                FirefoxProfile profile = listProfiles.getProfile("profileTools");
                FirefoxOptions opt = new FirefoxOptions();
                opt.setProfile(profile);
                WebDriver driver = null;
                driver = new FirefoxDriver(opt);
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                List<List<String>> linkForHeadHunter = new LinkForHH().linkForHH();
                int countLink = linkForHeadHunter.size();
                for (List<String> listFullInform : linkForHeadHunter) {
                    countForCloseWD++;
                    if (countForCloseWD == 10) {
                        countForCloseWD = 0;
                        driver.quit();
                        driver = new FirefoxDriver(opt);
                        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                        driver.manage().window().maximize();
                    }
                    String link = listFullInform.get(0);
                    while (true) {
                        try {
                            driver.get(link + 0);
                            Thread.sleep(5000);
                            break;
                        } catch (Exception e) {
                            System.out.println("Вылет из браузера!");
                        }
                    }
                    Document doc = Jsoup.parse(String.valueOf(driver.getPageSource()));
                    Thread.sleep(1000);
                    int countPage = 0;
                    int countVacancy = 0;
                    try {
                        Elements elements = doc.getElementsByAttributeValue("data-qa", "pager-page");
                        countPage = Integer.parseInt(String.valueOf(elements.get(elements.size() - 1)).split("<span>")[1].split("</span>")[0]);
                    } catch (Exception e) {
                    }
                    if (countPage == 0) {
                        countPage++;
                    }
                    for (int j = 0; j < countPage; j++) {
                        if (j != 0) {
                            driver.get(link + j);
                            Thread.sleep(5000);
                            doc = Jsoup.parse(String.valueOf(driver.getPageSource()));
                        }
                        Elements elementsForms = null;
                        try {
                            Thread.sleep(1000);
                            elementsForms = doc.getElementsByAttributeValueStarting("data-qa", "vacancy-serp__vacancy vacancy-serp__vacancy");
                        } catch (Exception e) {
                        }
                        if (elementsForms.size() == 0) {
                            break;
                        }
                        String idVacancy = "";
                        String nameVacancy = "";
                        String dateVacancy = "";
                        String salary = "";
                        String company = "";
                        String companyLink = "";
                        String country = listFullInform.get(1);
                        String city = "";
                        String metro = "";
                        String descriptionVacancy1 = "";
                        String descriptionVacancy2 = "";
                        String linlImg = "";
                        String workExperience = listFullInform.get(2);
                        String linkVacancy = "";
                        String responseVacancy = "";
                        String typeOfEmpoyment = listFullInform.get(3);
                        String schedule = listFullInform.get(4);
                        langProg = listFullInform.get(5);

                        for (int i = 0; i < elementsForms.size(); i++) {
                            List<String> listVacancy = new ArrayList<>();
                            nameVacancy = String.valueOf(elementsForms.get(i).getElementsByAttributeValueStarting("data-qa", "vacancy-serp__vacancy-title").text());
                            dateVacancy = String.valueOf(elementsForms.get(i).getElementsByAttributeValueStarting("class", "vacancy-serp-item__publication-date vacancy-serp-item__publication-date_short").text());

                            try {
                                salary = String.valueOf(elementsForms.get(i).getElementsByAttributeValueStarting("data-qa", "vacancy-serp__vacancy-compensation").text());
                            } catch (Exception e) {
                            }


                            try {
                                salary = String.valueOf(elementsForms.get(i).getElementsByAttributeValueStarting("data-qa", "vacancy-serp__vacancy-compensation").text());
                            } catch (Exception e) {
                            }

                            try {
                                company = String.valueOf(elementsForms.get(i).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                            } catch (Exception e) {

                            }

                            try {
                                companyLink = "https://hh.ru" + String.valueOf(elementsForms.get(i).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer")).split("href=\"")[1].split("\">")[0];
                            } catch (Exception e) {

                            }

                            try {
                                city = String.valueOf(elementsForms.get(i).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text().split(",")[0]);
                            } catch (Exception e) {
                                try {
                                    city = String.valueOf(elementsForms.get(i).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                                } catch (Exception x) {

                                }
                            }

                            try {
                                metro = String.valueOf(elementsForms.get(i).getElementsByClass("metro-station").text());
                            } catch (Exception e) {
                            }

                            try {
                                descriptionVacancy1 = String.valueOf(elementsForms.get(i).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy_snippet_responsibility").text());
                            } catch (Exception e) {
                            }

                            try {
                                descriptionVacancy2 = String.valueOf(elementsForms.get(i).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy_snippet_requirement").text());
                            } catch (Exception e) {
                            }

                            try {
                                linlImg = String.valueOf(elementsForms.get(i).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer-logo")).split("src=\"")[1].split("\" ")[0];
                            } catch (Exception e) {
                            }

                            try {
                                linlImg = String.valueOf(elementsForms.get(i).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer-logo")).split("src=\"")[1].split("\" ")[0];
                            } catch (Exception e) {
                            }

                            try {
                                linkVacancy = String.valueOf(elementsForms.get(i).getElementsByAttributeValueStarting("data-qa", "vacancy-serp__vacancy-title")).split("href=\"")[1].split("\">")[0];
                            } catch (Exception e) {
                            }

                            try {
                                idVacancy = String.valueOf(elementsForms.get(i).getElementsByAttributeValueStarting("data-qa", "vacancy-serp__vacancy_response")).split("vacancyId=")[1].split("&")[0];
                            } catch (Exception e) {
                            }

                            try {
                                responseVacancy = "https://hh.ru" + String.valueOf(elementsForms.get(i).getElementsByAttributeValueStarting("data-qa", "vacancy-serp__vacancy_response")).split("href=\"")[1].split("\">")[0];
                            } catch (Exception e) {

                            }

                            ParsingResult parsingResult = new ParsingResult();

                            try {
                                parsingResult.setId(Integer.parseInt(idVacancy));
                                parsingResult.setIdVacancy(idVacancy);
                                parsingResult.setLangProg(langProg);
                                parsingResult.setExper(exper);
                                parsingResult.setNameVacancy(nameVacancy);
                                parsingResult.setDateVacancy(dateVacancy);
                                parsingResult.setSalary(salary);
                                parsingResult.setCompany(company);
                                parsingResult.setCompanyLink(companyLink);
                                parsingResult.setCountry(country);
                                parsingResult.setCity(city);
                                parsingResult.setMetro(metro);
                                parsingResult.setDescriptionVacancy1(descriptionVacancy1);
                                parsingResult.setDescriptionVacancy2(descriptionVacancy2);
                                parsingResult.setLinlImg(linlImg);
                                parsingResult.setWorkExperience(workExperience);
                                parsingResult.setLinkVacancy(linkVacancy);
                                parsingResult.setResponseVacancy(responseVacancy);
                                parsingResult.setTypeOfEmpoyment(typeOfEmpoyment);
                                parsingResult.setSchedule(schedule);
                            } catch (Exception n) {
                            }


                            try {
                                parsingRepository.save(parsingResult);
                            } catch (Exception e) {
                                System.out.println("Попалась нестандартная анкета!");
                            }
                        }


                    }

                    new OutFromDB().outDromDB(parsingRepository, publishRepository);
                }

                driver.quit();
            } catch (Exception e) {
                System.out.println("Ошибка в SELENIUM!");
                e.printStackTrace();
            }
        }

    }

}
