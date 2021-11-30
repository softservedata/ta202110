package com.softserve.homework10.data;


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

    
    public IUser getNewUser() { return getInvalidUser();}


    public IUser getInvalidUser() {
        return User.get()
                .setFirstname("InvalidName")
                .setLastname("boomboom")
                .setEmail("zzxxx99@gmail.com")
                .setTelephone("boomboom")
                .setAddress1("address2")
                .setCity("city_7")
                .setPostcode("postcode")
                .setCountry("country")
                .setRegion("region")
                .setPassword("boom90")
                .setSubscribe(true)
                .setFax("fax")
                .setCompany("company")
                .setAddress2("address3")
                .build();

    }

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