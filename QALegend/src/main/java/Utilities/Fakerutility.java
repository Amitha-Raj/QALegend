package Utilities;

import java.lang.foreign.AddressLayout;
import java.util.Random;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class Fakerutility {
	
	public static String getFirstFakename() {
		Faker faker =new Faker();
		Address address = faker.address();
		String firstname=address.firstName();
		return firstname;
	}
	
	public static String getFakeLastName() {
		Faker faker =new Faker();
		Address address = faker.address();
		String lastname=address.lastName();
		return lastname;
		
	}
	public static String getFakecityname() {
		Faker faker =new Faker();
		Address address = faker.address();
		String cityname=address.city();
		return cityname;
		
	}
	public static String getFakeAddress() {
		Faker faker =new Faker();
		Address address = faker.address();
		String fulladdress =address.fullAddress();
		return fulladdress;
		
	}
	public static String getFakeZipcode() {
		Faker faker =new Faker();
		Address address = faker.address();
		String zipcode=address.zipCode();
		return zipcode;
	}
	
	public static int randomNumberGenerator() {
		Random rand = new Random();
		int randomnumber=rand.nextInt(100000);
		return randomnumber;
	}
	public static String generatePhoneNumber() {
        Random rand = new Random();

        // Ensure first digit is not 0 (phone numbers don't start with 0)
        int firstDigit = rand.nextInt(9) + 1; // 1 to 9

        // Generate the remaining 9 digits (0 to 9)
        StringBuilder phoneNumber = new StringBuilder();
        phoneNumber.append(firstDigit);
        for (int i = 0; i < 9; i++) {
            phoneNumber.append(rand.nextInt(10));
        }

        return phoneNumber.toString();
    }
	

}
