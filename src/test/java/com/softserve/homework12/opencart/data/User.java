package com.softserve.homework12.opencart.data;

interface IFirstname {
    ILastname setFirstname(String firstname);
}

interface ILastname {
    IEmail setLastname(String lastname);
}

interface IEmail {
    ITelephone setEmail(String email);
}

interface ITelephone {
    IAddress1 setTelephone(String telephone);
}

interface IAddress1 {
    ICity setAddress1(String address1);
}

interface ICity {
    IPostcode setCity(String city);
}

interface IPostcode {
    ICountry setPostcode(String postcode);
}

interface ICountry {
    IRegion setCountry(String country);
}

interface IRegion {
    IPassword setRegion(String region);
}

interface IPassword {
    ISubscribe setPassword(String password);
    //ISubscribe setToken(String token);
}

interface ISubscribe {
    IBuildUser setSubscribe(boolean subscribe);
}

interface IBuildUser {
    IBuildUser setFax(String fax);
    IBuildUser setCompany(String company);
    IBuildUser setAddress2(String address2);
    //User build();
    IUser build();
}


// POJO
public final class User implements IFirstname, ILastname, IEmail,
        ITelephone, IAddress1, ICity, IPostcode, ICountry,
        IRegion, IPassword, ISubscribe, IBuildUser, IUser {

    private String firstname;
    private String lastname;
    private String email;
    private String telephone;
    private String fax;      // not required
    private String company;  // not required
    private String address1;
    private String address2; // not required
    private String city;
    private String postcode;
    private String country;
    private String region;
    private String password;
    private boolean subscribe;

    /*-
    public User(String firstname, String lastname, String email, String telephone, String fax, String company,
            String address1, String address2, String city, String postcode, String country, String region,
            String password, boolean subscribe) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.telephone = telephone;
        this.fax = fax;
        this.company = company;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.region = region;
        this.password = password;
        this.subscribe = subscribe;
    }
    */

    //public User() {
    private User() {
        //this.firstname = "";
        //this.lastname = "";
        //this.email = "";
        //this.telephone = "";
        this.fax = "";
        this.company = "";
        //this.address1 = "";
        this.address2 = "";
        //this.city = "";
        //this.postcode = "";
        //this.country = "";
        //this.region = "";
        //this.password = "";
        //this.subscribe = true;
    }
    
    //public static User get() {
    public static IFirstname get() {
        return new User();
    }
    
    // setters
    
    //public void setFirstname(String firstname) {
    //public User setFirstname(String firstname) {
    public ILastname setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public IEmail setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ITelephone setEmail(String email) {
        this.email = email;
        return this;
    }

    public IAddress1 setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public IBuildUser setFax(String fax) {
        this.fax = fax;
        return this;
    }

    public IBuildUser setCompany(String company) {
        this.company = company;
        return this;
    }

    public ICity setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public IBuildUser setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public IPostcode setCity(String city) {
        this.city = city;
        return this;
    }

    public ICountry setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public IRegion setCountry(String country) {
        this.country = country;
        return this;
    }

    public IPassword setRegion(String region) {
        this.region = region;
        return this;
    }

    public ISubscribe setPassword(String password) {
        this.password = password;
        return this;
    }

    public IBuildUser setSubscribe(boolean subscribe) {
        this.subscribe = subscribe;
        return this;
    }
    
    //public User build() {
    public IUser build() {
        return this;
    }
    
    // gettres
    
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getFax() {
        return fax;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getPassword() {
        return password;
    }

    public boolean isSubscribe() {
        return subscribe;
    }

    @Override
    public String toString() {
        return "User [firstname=" + firstname 
                + "\nlastname=" + lastname 
                + "\nemail=" + email 
                + "\ntelephone=" + telephone 
                + "\nfax=" + fax 
                + "\ncompany=" + company 
                + "\naddress1=" + address1
                + "\naddress2=" + address2 
                + "\ncity=" + city 
                + "\npostcode=" + postcode 
                + "\ncountry=" + country 
                + "\nregion=" + region
                + "\npassword=" + password 
                + "\nsubscribe=" + subscribe + "]";
    }
    
    
}
