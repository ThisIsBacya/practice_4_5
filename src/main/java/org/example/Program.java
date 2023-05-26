package org.example;

import org.example.dto.model.Reader;
import org.example.dto.model.Avtor;
import org.example.dto.repository.AvtorRepository;
import org.example.service.MyConnection;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class Program {


    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {
        MyConnection myConnection = new MyConnection();
        myConnection.getConnection();
        AvtorRepository avtorRepository = new AvtorRepository(myConnection.getConnection());
        Avtor avtor1 = new Avtor(15, "Vasilev", "Daniil", 1999, "m");
//        avtorRepository.createAvtor(avtor1);
//        List<Avtor> avtors1 = AvtorRepository.findAll();
//        List<Avtor> avtors = AvtorRepository.absolutPosition(4);
//        Map<Long, Avtor> avtors2;
//        avtors2 = parseAvtorsFile("F:\\0091\\project1\\import.txt");
//        AvtorRepository.createAvtors(avtors2);
//        List<Avtor> avtorList = avtorRepository.findAll();
//        for (Avtor avtor : avtorList){
//            System.out.printf(
//                    "id = %s | fam = %s | name = %s | god_r = %s | pol = %s\n",
//                    avtor.getId(), avtor.getFam(), avtor.getName().trim(), avtor.getGod_r(), avtor.getPol()
//            );
//        }

        create_reader(3);
    }

    public static Map<Long, Avtor> parseAvtorsFile(String path) throws FileNotFoundException {
        Scanner avtorScanner = new Scanner(new File(path));
        Map<Long, Avtor> avtors = new HashMap<>();

        while (avtorScanner.hasNext()) {
            Avtor avtor = new Avtor();
            String nextLine = avtorScanner.nextLine();
            String[] data = nextLine.split(",");
            for (int i = 0; i < 5; i++) {
                if (i == 0) {
                    avtor.setId(Integer.parseInt(data[i]));
                }
                if (i == 1) {
                    avtor.setFam(data[i]);
                }
                if (i == 2) {
                    avtor.setName(data[i]);
                }
                if (i == 3) {
                    avtor.setGod_r(Integer.parseInt(data[i]));
                }
                if (i == 4) {
                    avtor.setPol(data[i]);
                }
            }
            avtors.put((long) avtor.getId(), avtor);
        }
        return avtors;
    }


    public static Reader[] create_reader(int length) {
        Reader[] readers = new Reader[length];
        int i = 0;
        while (i < length) {
            readers[i].setFIO("Daniil" + Integer.toString(i));
            readers[i].setBilet(i);
            readers[i].setDepartment("Programmer" + Integer.toString(i));
            readers[i].setYear_of_birth(i);
            readers[i].setPhone(String.valueOf(i));
            i++;
        }
        return readers;
    }
}
