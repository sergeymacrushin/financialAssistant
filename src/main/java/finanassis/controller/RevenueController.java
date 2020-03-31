package finanassis.controller;

import finanassis.model.Revenue;
import finanassis.service.RevenueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RevenueController {

    private RevenueService revenueService;

    @Autowired
    public void setRevenueService(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @RequestMapping(value = "/revenues/{id}",method = RequestMethod.GET)
    public ModelAndView allRevenue(@PathVariable("id") int id) {
        List<Revenue> revenues = revenueService.allRevenues(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("revenues");
        modelAndView.addObject("revenuesList", revenues);
        modelAndView.addObject("id_u", id);
        return modelAndView;
    }

    @RequestMapping(value="/deleteRevenue/{id}", method = RequestMethod.GET)
    public ModelAndView deleteRevenue(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Revenue revenue = revenueService.getById(id);
        revenueService.delete(revenue);
        modelAndView.setViewName( "redirect:/revenues/"+revenue.getId_user());
        return modelAndView;
    }

    @RequestMapping(value = "/editRevenue/{id}", method = RequestMethod.GET)
    public ModelAndView editPageRevenue(@PathVariable("id") int id) {
        Revenue revenue = revenueService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPageRevenue");
        modelAndView.addObject("revenue", revenue);
        return modelAndView;
    }

    @RequestMapping(value = "/editRevenue", method = RequestMethod.POST)
    public ModelAndView editRevenue(@ModelAttribute("revenue") Revenue revenue) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/revenues/"+revenue.getId_user());
        revenueService.edit(revenue);
        return modelAndView;
    }

    @RequestMapping(value = "/addRevenue/{id_u}", method = RequestMethod.GET)
    public ModelAndView addPageCost(@PathVariable("id_u") int id_u) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPageRevenue");
        modelAndView.addObject("id_u", id_u);
        return modelAndView;
    }

    @RequestMapping(value = "/addRevenue", method = RequestMethod.POST)
    public ModelAndView addCost(@ModelAttribute("revenue") Revenue revenue) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/revenues/"+revenue.getId_user());
        revenueService.add(revenue);
        return modelAndView;
    }
}
