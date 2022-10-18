<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <#include "base.ftl">

    <#macro title>About</#macro><!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"></script>

    <style>
        p{
            color: #2b2b2c;
        }
        .carousel-caption {
            bottom: 180px;
            padding-left: 100px;
            padding-right: 100px;
        }

        .carousel-caption h5 {
            font-size: 100px;
        }

        .carousel-item {
            height: 93vh;
        }

        .item img {
            position: absolute;
            top: 0;
            left: 0;
            min-height: 300px;
        }
    </style>
</head>
<body>
<#macro content>
    <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
                    aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                    aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                    aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="img/nirvana.jpg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>What kinda music</h5>
                    <p>Site about music</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="img/The_Cure.jpg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>You can read and create articles</h5>
                    <p style="color: #eeeeee">It is very easy. Try it <a href="createArticle">Create articles</a> and <a href="articles">Read articles</a></p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="img/logo.jpg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Don't miss events. Our site is full of new and interesting events</h5>
                    <p>Vot <a href="events">Events</a> </p>
                </div>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</#macro>
</body>
</html>