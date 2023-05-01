package com.RestPhoneBook.api.service;

import com.RestPhoneBook.api.model.PhoneBook;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PhoneBookService {
    private static List<PhoneBook> list = new ArrayList<>();
    //for connection with db by JPA

    static {
        list.add(new PhoneBook(121, "ram", 152463));
        list.add(new PhoneBook(126, "pinky", 154463));
        list.add(new PhoneBook(127, "chunky", 152063));
    }

    //get all contacts
    public List<PhoneBook> getAllContact() {
        return list;
    }

    //get contact by id
    public PhoneBook getContactById(int id) {
        PhoneBook phoneBook = null;
        try {
            phoneBook = list.stream().filter(e -> e.getId() == id).findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return phoneBook;
    }

    //adding contact--CREATE
    public PhoneBook add(PhoneBook pb) {
        list.add(pb);
        return pb;
    }

    //DELETE
    public void deleteContact(int cid) {
       /* list=list.stream().filter(phoneBook -> {
            if(phoneBook.getId()!=cid){
                return true;
            }else{
                return false;
            }
        }).collect(Collectors.toList());*/
        list = list.stream().filter(phoneBook -> phoneBook.getId() != cid).collect(Collectors.toList());
    }

    //UPDATE
    public void updateContact(PhoneBook phoneBook, int contactId) {
        list = list.stream().map(b -> {
            if (b.getId() == contactId) {
                b.setName(phoneBook.getName());
                b.setNumber(phoneBook.getNumber());
            }
            return b;
        }).collect(Collectors.toList());
    }


}
