package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
public class Email {
    private String emailText;
    private String label;
    public Email(String emailText, String label)
    {
        this.emailText=emailText;
        this.label=label;
    }

    public String getEmailText()
    {
        return emailText;
    }
    public String getLabel()
    {
        return label;
    }
    @Override
    public String toString() {
        return "Email{" +
                "emailText=" + emailText +
                ", label='" + label + '\'' +
                '}';
    }
}

class Contact implements Comparable<Contact>{

    private String firstName;
    private String lastName;
    private String title;
    private String company;
    private List<Email> emails;
    private List<Phone> phones;
    public Contact()
    {

        this.firstName = "";
        this.lastName = "";
        this.title = "";
        this.company = "";

    }
    public Contact(String firstName, String lastName, String title, String company,
                   ArrayList<Email> emails,ArrayList<Phone> phones) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.company = company;
        this.emails=emails;
        this.phones=phones;
    }



    public String getfirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getTitle() {
        return title;
    }
    public String getCompany() {
        return company;
    }
    public String getEmails() {
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(Email e:emails)
        {
            sb.append("{ emailText:");
            sb.append(e.getEmailText());
            sb.append(",label:");
            sb.append(e.getLabel());
            sb.append("},");
        }
        sb.append("]");
        return sb.toString();
    }
    public String getPhones() {
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(Phone e:phones)
        {
            sb.append("{ phoneNumber:");
            sb.append(e.getPhoneNumber());
            sb.append(",label:");
            sb.append(e.getLabel());
            sb.append("},");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "model.Contact{" +
                "firstName=" + firstName +
                ", lastName='" + lastName + '\'' +
                ", title=" + title +
                ", company=" + company +

                '}';
    }



    @Override
    public int compareTo(Contact otherContact) {
        return this.lastName.compareTo(otherContact.lastName);

    }
}



public class Phone {
    private String phoneNumber;
    private String label;
    public Phone(String phoneNumber, String label)
    {
        this.phoneNumber=phoneNumber;
        this.label=label;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public String getLabel()
    {
        return label;
    }
    @Override
    public String toString() {
        return "Phone{" +
                "phoneNumber=" + phoneNumber +
                ", label='" + label + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
    ArrayList<Contact> contacts=new ArrayList<Contact>();

    ArrayList<Email> emails1=new ArrayList<Email>();
        emails1.add(new Email("kamalhome@gmail.com","home"));
        emails1.add(new Email("kamalwork@gmail.com","work"));
        ArrayList<Phone> phones1=new ArrayList<Phone>();
        phones1.add(new Phone("12345678","home"));
        phones1.add(new Phone("223456778","work"));

        ArrayList<Email> emails2=new ArrayList<Email>();
        emails1.add(new Email("ramhome@gmail.com","home"));
        emails1.add(new Email("ramwork@gmail.com","work"));
        ArrayList<Phone> phones2=new ArrayList<Phone>();
        phones1.add(new Phone("474833348","home"));
        phones1.add(new Phone("3838383838","work"));

        contacts.add(new Contact("Kamal","Grg","Mr.","Futuregen",emails1,phones1));
        contacts.add(new Contact("Ram","Askar","Mr.","Microsoft",emails2,phones2));

        var sortedContact=contacts.stream().sorted().toList();
        //display list of contacts
        for(Contact cont :sortedContact)
        {
          System.out.print(cont);
        }

    }
    public static void showReportInJSON(ArrayList<Contact> contacts)
    {
        Collections.sort(contacts);

        //generate JSON
        StringBuilder sb=new StringBuilder();
        sb.append("[\n");
        for(Contact c :contacts)
        {
            sb.append("{");
            sb.append("\"firstName\"");
            sb.append(":");
            sb.append(c.getfirstName());
            sb.append(",");

            sb.append("\"lastName\"");
            sb.append(":");
            sb.append(c.getLastName());
            sb.append(",");

            sb.append("\"title\"");
            sb.append(":");
            sb.append(c.getTitle());
            sb.append(",");

            sb.append("\"company\"");
            sb.append(":");
            sb.append(c.getCompany());
            sb.append(",");


            sb.append("\"emails\"");
            sb.append(":");
            sb.append(c.getEmails());
            sb.append(",");

            sb.append("\"phones\"");
            sb.append(":");
            sb.append(c.getPhones());
            sb.append(",");

            sb.append("},\n");

        }

        sb.append("]");
        System.out.println(sb.toString());


    }
}