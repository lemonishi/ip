package yeetman.storage;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import yeetman.exception.YeetManException;

public class StorageTest {

    @Test
    public void givenInvalidFilePath_whenLoad_throwException() {
        Storage storage = new Storage("");
        assertThrows(YeetManException.class, storage::load);
    }
}
