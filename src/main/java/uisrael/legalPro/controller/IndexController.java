package uisrael.legalPro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping("/")
	public String abrirIndex() {
		return "index";//Index principal
	}

}
