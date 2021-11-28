package com.softserve.homework10.opencart.data;

public final class UserRepository {
    private static volatile UserRepository instance = null;

    private UserRepository() {
    }

    public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    public IUser getDefault() {
        return getHahaha();
    }
    
    public IUser getHahaha() {
        return User.get()
            .setFirstname("hahaha")
            .setLastname("hahaha")
            .setEmail("hahaha@gmail.com")
            .setTelephone("hahaha")
            .setAddress1("address1")
            .setCity("city_5")
            .setPostcode("postcode")
            .setCountry("country")
            .setRegion("region")
            .setPassword("qwerty")
            .setSubscribe(true)
            .setFax("fax")
            .setCompany("company")
            .setAddress2("address2")
            .build();
    }
    
    public IUser getAwdrt() {
        return User.get()
                .setFirstname("my")
                .setLastname("hahaha")
                .setEmail("xdknxusqvjeovowpfk@awdrt.com")
                .setTelephone("hahaha")
                .setAddress1("address1")
                .setCity("city_5")
                .setPostcode("postcode")
                .setCountry("country")
                .setRegion("region")
                .setPassword("awdrt123")
                .setSubscribe(true)
                .setFax("fax")
                .setCompany("company")
                .setAddress2("address2")
                .build();
    }    
    
    public IUser notValidUser() {
        return User.get()
                .setFirstname("name")
                .setLastname("familia")
                .setEmail("email@")
                .setTelephone("555-555")
                .setAddress1("address1")
                .setCity("5")
                .setPostcode("postcode")
                .setCountry("country")
                .setRegion("region")
                .setPassword("123")
                .setSubscribe(true)
                .setFax("fax")
                .setCompany("company")
                .setAddress2("address2")
                .build();
    }

    /*-
    public IUser getNewUser() {
        
    }
    
    public IUser getInvalidUser() {
        
    }
    */
    
    /*-
    public List<IUser> fromCsv(String filename) {
        return User.getByLists(new CSVReader(filename).getAllCells());
    }

    public List<IUser> fromCsv() {
        return fromCsv("users.csv");
    }

    public List<IUser> fromExcel(String filename) {
        return User.getByLists(new ExcelReader(filename).getAllCells());
    }

    public List<IUser> fromExcel() {
        return fromExcel("users.xlsx");
    }
    */
}
