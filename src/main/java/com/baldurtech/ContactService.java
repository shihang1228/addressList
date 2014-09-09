package com.baldurtech;

import java.util.List;
import java.util.ArrayList;
 
public class ContactService 
{
    public List<Contact> list()
    {
        List<Contact> contactList = new ArrayList<Contact>();
        Contact contact = new Contact();
        contact.setName("xushuangshuang");
        contact.setMobile("18235408753");
        contactList.add(contact);
        return contactList;
        
    }
}