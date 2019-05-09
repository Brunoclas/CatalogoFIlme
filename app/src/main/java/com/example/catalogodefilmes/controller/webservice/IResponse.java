package com.example.catalogodefilmes.controller.webservice;

import com.example.catalogodefilmes.model.Movie;

import java.util.List;

public interface IResponse {
    void responseRetorfit(List<Movie> movies);
}
