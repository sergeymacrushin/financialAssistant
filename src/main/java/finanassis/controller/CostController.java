package finanassis.controller;

import finanassis.model.Cost;
import finanassis.service.CostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;


@Controller
public class CostController {

    private CostService costService;

    @Autowired
    public void setCostService(CostService costService) {
        this.costService = costService;
    }

    @RequestMapping(value = "/costs/{id}",method = RequestMethod.GET)
    public ModelAndView allCosts(@PathVariable("id") int id) {
        List<Cost> costs = costService.allCosts(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("costs");
        modelAndView.addObject("costsList", costs);
        modelAndView.addObject("id_u", id);
        return modelAndView;
    }

    @RequestMapping(value="/deleteCost/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCost(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Cost cost = costService.getById(id);
        costService.delete(cost);
        modelAndView.setViewName( "redirect:/costs/"+cost.getId_user());
        return modelAndView;
    }

    @RequestMapping(value = "/editCost/{id}", method = RequestMethod.GET)
    public ModelAndView editPageCost(@PathVariable("id") int id) {
        Cost cost = costService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPageCost");
        modelAndView.addObject("cost", cost);
        return modelAndView;
    }

    @RequestMapping(value = "/editCost", method = RequestMethod.POST)
    public ModelAndView editRevenue(@ModelAttribute("cost") Cost cost) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/costs/"+cost.getId_user());
        costService.edit(cost);
        return modelAndView;
    }

    @RequestMapping(value = "/addCost/{id_u}", method = RequestMethod.GET)
    public ModelAndView addPageCost(@PathVariable("id_u") int id_u) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPageCost");
        modelAndView.addObject("id_u", id_u);
        return modelAndView;
    }

    @RequestMapping(value = "/addCost", method = RequestMethod.POST)
    public ModelAndView addCost(@ModelAttribute("cost") Cost cost) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/costs/"+cost.getId_user());
        costService.add(cost);
        return modelAndView;
    }
}
