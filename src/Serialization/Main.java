package Serialization;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Profile> profiles = new ArrayList<Profile>();
    public static void main(String[] arg) {
        profiles = (ArrayList<Profile>) desreData("profils1");
        System.out.println(profiles.size());
        Profile profile = new Profile();
        profile.setName(JOptionPane.showInputDialog(null, "Введите имя"));
        profile.setSuretname(JOptionPane.showInputDialog(null, "Введите фамилию"));
        profiles.add(profile);
        for (Profile p : profiles) {
            System.out.println(p.getName() + " " + p.getSuretname());

        }
        System.out.println(profiles.size());
        serData("profils1",profile   );
    }

    private static void serData(String file_name, Object obj) {
        try {
            FileOutputStream fileOut = new FileOutputStream(file_name + ".txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            fileOut.close();
            out.close();

        } catch(FileNotFoundException e) {
            System.out.println("фаил н найден");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("ошибка ввода/вывода");
            System.exit(2);
        }

    }

    private static Object desreData(String file_name) {
        Object retObgect = null;
        try {
            FileInputStream filein = new FileInputStream(file_name + ".txt");
            ObjectInputStream in = new ObjectInputStream(filein);
            try {
                retObgect = in.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println("клас не найден");
                System.exit(3);
            }
            filein.close();
            in.close();

        } catch(FileNotFoundException e) {
            System.out.println("фаил н найден");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("ошибка ввода/вывода");
            System.exit(2);
        }
return retObgect;

    }
}
