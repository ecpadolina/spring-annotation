package ecp.spring.model;

import javax.persistence.Embeddable;
import javax.persistence.Column;

@Embeddable
public class Address{

  @Column(name = "house_no")
  private String houseNo;
  @Column(name = "street")
  private String street;
  @Column(name = "barangay")
  private String barangay;
  @Column(name = "subdivision")
  private String subdivision;
  @Column(name = "municipality")
  private String municipality;
  @Column(name = "province")
  private String province;
  @Column(name = "zipcode")
  private int zipcode;
  
  public Address(String houseNo, String street, String barangay, String subdivision, String municipality,
                          String province, int zipcode){
    this.houseNo = houseNo;
    this.street = street;
    this.barangay = barangay;
    this.subdivision = subdivision;
    this.municipality = municipality;
    this.province = province;
    this.zipcode = zipcode;
  }
  
  public Address(){}
  
  public void setHouseNo(String houseNo){
    this.houseNo = houseNo;
  }
  
  public void setStreet(String street){
    this.street = street;
  }
  
  public void setBarangay(String barangay){
    this.barangay = barangay;
  }
  
  public void setSubdivision(String subdivision){
    this.subdivision = subdivision;
  }
  
  public void setMunicipality(String municipality){
    this.municipality = municipality;
  }
  
  public void setProvince(String province){
    this.province = province;
  }
  
  public void setZipcode(int zipcode){
    this.zipcode = zipcode;
  }
  
  public String getHouseNo(){
    return houseNo;
  }
  
  public String getStreet(){
    return street;
  }
  
  public String getBarangay(){
    return barangay;
  }
  
  public String getSubdivision(){
    return subdivision;
  }
  
  public String getMunicipality(){
    return municipality;
  }
  
  public String getProvince(){
    return province;
  }
  
  public int getZipcode(){
    return zipcode;
  }
  
  public String toString(){
    return getHouseNo() + " " + getStreet() + " St. " + getSubdivision() + " " + getBarangay() + " " + getMunicipality() + " " + getProvince() + ", " + getZipcode();
  }
}
