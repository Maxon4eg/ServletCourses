package com.akhambir.controller;

import com.akhambir.servlet.Request;
import com.akhambir.servlet.ViewModel;

public interface Controller {

    ViewModel process(Request request);
}
