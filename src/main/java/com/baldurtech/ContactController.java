package com.baldurtech;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping; 

import java.util.ArrayList;
import java.util.List; 

@Controller
public class ContactController
{
    ContactService contactService;

    public ContactController(ContactService contactService)
    {
        this.contactService = contactService;
    }
    
    @RequestMapping(value = "contact/list", method = RequestMethod.GET)
    public void list(Model model)
    {
        List<Contact> contactList = new ArrayList<Contact>();
        contactList = contactService.list();
        model.addAttribute("contactList",contactList);
    }
}
