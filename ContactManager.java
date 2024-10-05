import java.util.*;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + "\nNúmero de teléfono: " + phoneNumber + "\nEmail: " + email;
    }
}

public class ContactManager {
    private List<Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<>();
    }

    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del contacto: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese el número de teléfono: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Ingrese el email: ");
        String email = scanner.nextLine();
        contacts.add(new Contact(name, phoneNumber, email));
        System.out.println("Contacto agregado correctamente.");
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No hay contactos en la lista.");
            return;
        }
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("\nContacto " + (i + 1) + ":");
            System.out.println(contacts.get(i));
        }
    }

    public void searchContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del contacto a buscar: ");
        String searchName = scanner.nextLine();
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(searchName)) {
                System.out.println("\nContacto encontrado:");
                System.out.println(contact);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contacto no encontrado.");
        }
    }

    public void deleteContact() {
        viewContacts();
        if (contacts.isEmpty()) {
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número del contacto a eliminar: ");
        while (true) {
            try {
                int contactIndex = scanner.nextInt() - 1;
                if (contactIndex >= 0 && contactIndex < contacts.size()) {
                    contacts.remove(contactIndex);
                    System.out.println("Contacto eliminado correctamente.");
                    return;
                } else {
                    System.out.println("Número de contacto inválido. Por favor, ingrese un número válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpiar el buffer de entrada
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Ver contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Salir");

            System.out.print("Ingrese su opción: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (choice) {
                case 1:
                    contactManager.addContact();
                    break;
                case 2:
                    contactManager.viewContacts();
                    break;
                case 3:
                    contactManager.searchContact();
                    break;
                case 4:
                    contactManager.deleteContact();
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        }
    }
}