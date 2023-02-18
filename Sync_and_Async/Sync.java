package Sync_and_Async;

import java.io.FileReader;

public class Sync {

    public static void main(String[] args) {

        FileReader.read(Constants.MP4_FULL_PATH);
        Log.debug("do other things ...");

        // 2nd log is produced after the FileReader log
    }
}