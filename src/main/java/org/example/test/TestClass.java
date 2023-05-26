package org.example.test;

import org.example.dto.model.Avtor;
import org.example.dto.model.Book;
import org.example.dto.repository.AvtorRepository;
import org.example.service.MyConnection;
import org.junit.*;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//4.1.1
public class TestClass {
    private final int[] mas = new int[5];
    private final int[] mas2 = new int[5];
    MyConnection myConnection = new MyConnection();

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

//    Иницализация массива
    @Before
    public void init() {
        for (int i = 0; i < mas.length; i++) {
            mas[i] = 10;
        }
    }

//    Метод, говорящий, что все тесты завершены
    @After
    public void testPassed() {
        System.out.println("Тесты завершены");
    }

//    А тут тесты для первого задания
    @Test
    public void test1() {
        for (int i = 0; i < mas2.length; i++) {
            mas2[i] = 10;
        }
        Assert.assertArrayEquals(mas, mas2);
    }

    @Test
    public void test2() {
        Assert.assertEquals(mas[1], 10);

    }

    @Test
    public void test3() {
        Assert.assertNotEquals(mas[1], 9);
    }

    @Test
    public void test4() {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            sum += mas[i];
        }
        Assert.assertTrue(sum > 10);
    }

//    А тут тесты для проверки методов из лабы 4
    @Test
    public void testConnectToDataBase() throws SQLException, ClassNotFoundException {
        assert myConnection.getConnection().isValid(0);
    }

    @Test
    public void getListAvtor() throws SQLException, ClassNotFoundException {
        List<Avtor> expectedAvtors = new ArrayList<>();
        expectedAvtors.add(new Avtor(1, "Даниил", "Васильев", 1999, "m"));
        expectedAvtors.add(new Avtor(2, "Барабан", "Барабанов", 1990, "m"));
        expectedAvtors.add(new Avtor(3, "Петрова", "Юлия", 1975, "z"));
        List<Avtor> actualAvtors = AvtorRepository.findAll();
        Assert.assertEquals(expectedAvtors.size(), actualAvtors.size());

    }

    @Test
    public void testImportData() throws IOException {
        File log = folder.newFile("import.txt");
        FileWriter logWr = new FileWriter(log);
        logWr.append("Строка данных");
        logWr.flush();
        logWr.close();
    }

    @Test
    public void testCountBooks() {
        List<Avtor> avtors = AvtorRepository.findAll();
        Assert.assertTrue(avtors.size() > 15);
    }


}
