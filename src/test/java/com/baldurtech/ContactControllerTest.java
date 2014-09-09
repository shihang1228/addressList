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
        
        assertEquals("XuShuangshuang", contactList.get(0).getName());
    }
}

