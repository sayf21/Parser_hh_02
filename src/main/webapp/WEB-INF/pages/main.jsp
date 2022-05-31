<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Web-analysis</title>

    <link rel="stylesheet" href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css"/>
    <link rel="stylesheet" href="http://bootstraptema.ru/plugins/font-awesome/4-4-0/font-awesome.min.css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css"
          integrity="sha384-3AB7yXWz4OeoZcPbieVW64vVXEwADiYyAEhwilzWsLw+9FgqpyjjStpPnpBO8o8S" crossorigin="anonymous">


    <style language="css" type="text/css">
        <%@include file="/WEB-INF/css/main.css"%>
    </style>

    <script language="JavaScript" type="text/javascript">
        <%@include file="/WEB-INF/scripts/main.js"%>
    </script>

    <style>
        select {
            width: 200px; /* Ширина списка в пикселах */
            margin: auto;
            text-align: center;
        }
    </style>


    <script src="https://npmcdn.com/particlesjs@2.2.2/dist/particles.min.js"></script>


</head>

<body>



<canvas class="background"></canvas>

<br>

<div class="container">
    <div class="row">



        <div class="col-md-14 col-sm-14">
            <div class="serviceBox">
                <div class="service-content">
                    <h2>Информационно-аналитическая система подбора вакансий</h2>

                    <h2><a href="https://t.me/og_parser" >@og_parser</a></h2>
                    <br>
                    <span style="font-size: 20px; margin: 21px 0;">Добро пожаловать! Как мы все знаем, чтобы выбрать
                        язык программирования нужно проанализировать рынок: заработные платы, условия, требумый опыт работы.
                        Именно это делает наша информационная система. Для улучшения читабельности мы вывели всю
                        информацию в наш телеграм канал.</span>
                </div>
            </div>
        </div>

    </div><!-- ./row -->
</div>

<br>
<div class="container">
    <div class="row">
        <div class="parent">
            <div class="serviceBox">
                <div class="service-icon">
                    <i class="fa fa-rocket"></i>
                </div>
                <div class="service-content">
                    <h2>Запуск бота</h2>
                    <h3>Произвести сбор информации по вакансиям</h3>
                </div>
                <br>
                <div class="read">
                    <a href="main2" class="btn btn-default">Click!</a>
                </div>
                <h4>Работу выполняли:</h4>
                <h4>Макеенко Николай</h4>
                <h4>Мамаджонов Абдурахмон</h4>
                <h4>Муллагалиев Павел</h4>
                <h4>Сайфетдинов Илья</h4>
                <h4>Ткачук Игорь</h4>
                <h4>Хакимов Илья</h4>
                <h4>Шамагулов Александр</h4>
                <br>
            </div>
        </div>
    </div><!-- ./row -->
</div>


</body>
</html>


