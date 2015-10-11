package com.babaktamjidi.adressbook;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author Babak Tamjidi (baboly@msn.com)
 */
public class Person {

    private  SimpleIntegerProperty id;
    private  SimpleStringProperty name;
    private  SimpleStringProperty surname;
    private  SimpleStringProperty adress;
    private  SimpleLongProperty phone;
    private  SimpleIntegerProperty zip;
    
    
//    public Person model;
//    
//    public Person(Person model) {
//        this.model = model;
//    }
    

    public Person(int id, String name) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
    }
    
    public Person(int id, String name, String surname, String adress, long phone, int zip){
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.adress = new SimpleStringProperty(adress);
        this.phone = new SimpleLongProperty(phone);
        this.zip = new SimpleIntegerProperty(zip);    
        
    }
    
    public int getId() {
        return id.get();
    }

    public long getPhone() {
        return phone.get();
    }

    public int getZip() {
        return zip.get();
    }

    public String getName() {
        return name.getValueSafe();
    }

    public String getSurname() {
        return surname.getValueSafe();
    }

    public String getAdress() {
        return adress.getValueSafe();
    }
    
    public void setName(String name) {
        this.name.set(name);
    }
    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public void setAdress(String adress) {
        this.adress.set(adress);
    }
    
    public void setPhone(Long phone) {
    this.phone.set(phone);
    }
    
    public void setZip(int zip) {
    this.zip.set(zip);
    }       
    
    

}
    

