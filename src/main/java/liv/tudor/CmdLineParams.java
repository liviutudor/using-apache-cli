package liv.tudor;

import java.util.StringJoiner;

public class CmdLineParams {
    private String fileName;
    private String encoding;
    private String databaseHost;
    private String databaseName;

    public CmdLineParams(String... args) {
        this.fileName = args[0];
        this.encoding = args[1];
        this.databaseHost = args[2];
        this.databaseName = args[3];
    }

    public String getFileName() {
        return fileName;
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
