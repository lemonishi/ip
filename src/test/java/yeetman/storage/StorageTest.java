package yeetman.storage;

import org.junit.jupiter.api.Test;
import yeetman.exception.YeetManException;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StorageTest {

    @Test
    public void givenInvalidFilePath_whenLoad_throwException() {
        Storage storage = new Storage("");
        assertThrows(YeetManException.class, storage::load);
    }
}