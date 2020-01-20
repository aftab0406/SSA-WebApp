package com.ssa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssa.model.SsaModel;
import com.ssa.service.SsaService;

@Controller
public class SsaController {

	@Autowired
	private SsaService service;
	
	@RequestMapping(value = "/LoadForm")
	public String loadRegisterForm(Model model) {
		List<String> stateNameList = new ArrayList<String>();
		SsaModel ssaModel = new SsaModel();
		stateNameList = service.selectStateNameList();
		model.addAttribute("appModel", ssaModel);
		model.addAttribute("stateNames", stateNameList);
		return "register_page";
	}
	
	@RequestMapping(value = "/RegisterCitizenShip", method = RequestMethod.POST)
	public String handleNextBtn(SsaModel appModel,Model model) {
		String stateCode = service.getStateCode(appModel.getState());
		appModel.setState(stateCode);
		appModel = service.insertSsa(appModel);
		if(appModel.getSsaNo()>0) {
			//String ssn = String.valueOf(appModel.getSsaNo()).replaceFirst("(\\d{3}) (\\d{2}) (\\d{4})", "$1-$2-$3");
			String ssn = String.format("{0:000-00-0000}", String.valueOf(appModel.getSsaNo()));
			System.out.println(ssn);
			model.addAttribute("ssaNumber", ssn);
		}
		return "result_page";
	}
}
