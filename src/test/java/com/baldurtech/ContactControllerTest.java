package com.baldurtech;

import org.springframework.ui.Model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.ArrayList;

public class ContactControllerTest
{
    ContactService contactService;
    Model model;
    ContactController contactController;
    @Before
    public void setUp()
    {
        contactService = mock(ContactService.class);
        contactController = new ContactController(contactService);
        model = mock(Model.class);
    }
    
    @Test
    public void cotact_list_应该由Controller中的list方法来处理()
    {   
        List<Contact> contactList = new ArrayList<Contact>();
        Contact contact = new Contact();
        contact.setName("XuShuangshuang");
        contactList.add(contact);

        when(contactService.list()).thenReturn(contactList);
        
        contactController.list(model);
        
        verify(contactService).list();
        verify(model).addAttribute("contactList", contactList);
        
        assertEquals("XuShuangshuang", contactController.list(model).get(0).getName());
    }
    
    @Test
    public void contact_show_应该由Controller中的show方法来处理()
    {
        Contact contact = new Contact();
        contact.setId(1L);
        contact.setName("ShiHang");
        
        when(contactService.getById(1L)).thenReturn(contact);
        
        contactController.show("1", model);
 
        verify(contactService).getById(1L);
        verify(model).addAttribute("contact", contact);
        
        assertEquals("ShiHang", contactController.show("1", model).getName());
    }
}

