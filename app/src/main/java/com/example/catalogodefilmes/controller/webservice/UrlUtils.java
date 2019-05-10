    package com.example.catalogodefilmes.controller.webservice;

    public class UrlUtils{
            public static final String BASE_URL = "https://api.themoviedb.org/3/";

            public static IService getService(){
                return ConfigRetrofit.getClient(BASE_URL).create(IService.class);
            }
    }
