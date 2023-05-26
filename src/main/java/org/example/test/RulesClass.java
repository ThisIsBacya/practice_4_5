package org.example.test;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.Timeout;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RulesClass {
    @Rule
    public final Timeout timeout = new Timeout(1000);

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    @Ignore
    public void anotherInfinity() {
        int num = 0;
        while (true) {
            num++;
        }
    }

    @Test(expected = NullPointerException.class)
    public void testExpectedException() throws IOException {
        throw new NullPointerException();
    }

    @Test
    public void testFileWriting() throws IOException {
        File log = folder.newFile("temp.txt");
        FileWriter logWr = new FileWriter(log);
        logWr.append("Строка данных");
        logWr.flush();
        logWr.close();
        File fl = folder.newFile("temp_new.txt");
    }
}
