package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n01.model.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping
public class WebController {
    @Autowired
    EnterpriseService service;

    @GetMapping("/getAll")
    public String getAll(Model model){
        model.addAttribute("branches",service.getAll());
        return "listAll";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "redirect:/getAll";
    }

    @GetMapping("/edit/{id}")
    public String update(Model model,@PathVariable int id){
        model.addAttribute("Branch",service.getOne(id));
        model.addAttribute("Method","put");
        return "form";
    }

    @PostMapping("/save")
    public String save(Branch branch){
        service.save(branch);
        return "redirect:/getAll";
    }

    @PutMapping("/update")
    public String update(Branch branch){
        service.save(branch);
        return "redirect:/getAll";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("Branch",new Branch());
        model.addAttribute("Method","POST");
        return "form";
    }
}
