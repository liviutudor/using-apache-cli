package liv.tudor;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.StringJoiner;

public class CmdLineParams {
    private String fileName;
    private String encoding;
    private String databaseHost;
    private String databaseName;
    private String username;

    public CmdLineParams(String... args) {
        this.fileName = args[0];
        this.encoding = args[1];
        this.databaseHost = args[2];
        this.databaseName = args[3];
        this.username = args[4];
    }

    public String getFileName() {
        return fileName;
    }

    public String getUsername() {
        return username;
    }

    public String getEncoding() {
        return encoding;
    }

    public String getDatabaseHost() {
        return databaseHost;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void check() {
        File f = new File(params.getFileName());
        if (!f.exists()) {
            System.out.println("File " + params.getFileName() + " not found");
            showHelp();
            System.exit((1));
        }
        try {
            Charset.forName(params.getEncoding());
        } catch (IllegalCharsetNameException e) {
            System.out.println("Invalid encoding : " + params.getEncoding());
            showHelp();
            System.exit(1);
        }

        try {
            //connect to database
        } catch (Exception e) {
            System.out.println("Cannot connect to database");
            showHelp();
            System.exit(1);
        }

    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CmdLineParams.class.getSimpleName() + "[", "]")
                .add("fileName='" + fileName + "'")
                .add("encoding='" + encoding + "'")
                .add("databaseHost='" + databaseHost + "'")
                .add("databaseName='" + databaseName + "'")
                .toString();
    }
}
