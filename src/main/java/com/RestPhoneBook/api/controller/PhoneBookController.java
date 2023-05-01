package com.RestPhoneBook.api.controller;

import com.RestPhoneBook.api.model.PhoneBook;
import com.RestPhoneBook.api.service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhoneBookController {

    @Autowired
    private PhoneBookService phoneBookService;

    /*@RequestMapping(value = "/contacts",method = RequestMethod.GET)*/
   /* @GetMapping("/contacts")
    public String getContacts(){
        return "this is for testing";
    }*/
    @GetMapping("/contacts")
    public PhoneBook getContacts() {
        PhoneBook book = new PhoneBook();
        book.setId(123);
        book.setName("Ram");
        book.setNumber(8578475);
        return book;
    }

    @GetMapping("/contactList")
    public List<PhoneBook> getAllContact() {
        return this.phoneBookService.getAllContact();
    }

    //handling http status for all contact GET

    /* @GetMapping("/contactList")
     public ResponseEntity<List<PhoneBook>> getAllContact() {
         List<PhoneBook> list = this.phoneBookService.getAllContact();
         if (list.size() <= 0) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         return ResponseEntity.of(Optional.of(list));
     }*/
    @GetMapping("/contactById/{id}")
    public PhoneBook getContactById(@PathVariable("id") int id) {
        return this.phoneBookService.getContactById(id);
    }

    /* //handling http status for single contact GET
     @GetMapping("/contactById/{id}")
     public ResponseEntity<PhoneBook> getContactById(@PathVariable("id") int id) {
         PhoneBook phoneBook = this.phoneBookService.getContactById(id);
         if (phoneBook == null) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         return ResponseEntity.of(Optional.of(phoneBook));
     }*/
    @PostMapping("/contact")
    public PhoneBook addContact(@RequestBody PhoneBook phoneBook) {
        PhoneBook pb = this.phoneBookService.add(phoneBook);
        System.out.print(phoneBook);
        return pb;
    }
//handling http status for update contact 201
    /*@PostMapping("/contact")
    public ResponseEntity<PhoneBook> addContact(@RequestBody PhoneBook phoneBook) {
        PhoneBook pb = null;
        try {
            pb = this.phoneBookService.add(phoneBook);
            System.out.print(pb);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }*/

    @DeleteMapping("/contact/{contactId}")
    public void deleteContact(@PathVariable("contactId") int contactId) {
        this.phoneBookService.deleteContact(contactId);
    }

    //handling http status for delete contact 404
    /*@DeleteMapping("/contact/{contactId}")
    public ResponseEntity<Void> deleteContact(@PathVariable("contactId") int contactId) {
        try {
            this.phoneBookService.deleteContact(contactId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }*/
    @PutMapping("/contact/{contactId}")
    public PhoneBook updateContact(@RequestBody PhoneBook phoneBook, @PathVariable("contactId") int contactId) {
        this.phoneBookService.updateContact(phoneBook, contactId);
        return phoneBook;
    }

    //handling http status for PUT
 /*   @PutMapping("/contact/{contactId}")
    public ResponseEntity<PhoneBook> updateContact(@RequestBody PhoneBook phoneBook, @PathVariable("contactId") int contactId) {
        try {
            this.phoneBookService.updateContact(phoneBook, contactId);
            //return ResponseEntity.status(HttpStatus.OK).build();
            return ResponseEntity.ok().body(phoneBook);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }*/

}
