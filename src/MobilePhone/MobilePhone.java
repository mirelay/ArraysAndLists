package MobilePhone;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contacts> contactList = new ArrayList<Contacts>();

    public void printContacts() {
        for(int i = 0; i < contactList.size(); i++) {
            printContact(i);
        }
    }

    public void printContact(int position) {
        System.out.println(contactList.get(position).getName() + " - phone: " + contactList.get(position).getPhoneNumber());
    }

    public void addContact(String name, String phoneNumber) {
        if(!inContacts(name)) {
            contactList.add(new Contacts(name, phoneNumber));
        } else {
            System.out.println("Contact with name " + name + " already exists!");
        }
    }

    public void modifyContact(String name, String newPhoneNumber) {
        int position = findContact(name);
        if(position>=0) {
            contactList.get(position).setPhoneNumber(newPhoneNumber);
            System.out.println("New phone number " + newPhoneNumber + " is set for contact " + name);
        } else {
            System.out.println("Contact does not exist");
        }
    }

    public void removeContact(String name) {
        int position = findContact(name);
        if(position >= 0) {
            contactList.remove(position);
            System.out.println("Contact " + name + " deleted!");
        } else {
            System.out.println("Contact does not exist");
        }
    }

    public boolean inContacts(String name) {
        int position = findContact(name);
        if(position>=0) {
            return true;
        }
        return false;
    }

    private int findContact(String name) {
        for(int i = 0; i < contactList.size(); i++) {
            if(name.equals(contactList.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public void returnContact(String name) {
        int position = findContact(name);
        if(position >= 0) {
            printContact(position);
        } else {
            System.out.println("Contact does not exist");
        }
    }
}
