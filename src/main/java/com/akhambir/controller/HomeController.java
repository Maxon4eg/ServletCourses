package com.akhambir.controller;

import com.akhambir.servlet.Request;
import com.akhambir.servlet.ViewModel;

public class HomeController implements Controller {


    @Override
    public ViewModel process(Request request) {
        return new ViewModel("home");
    }
}
