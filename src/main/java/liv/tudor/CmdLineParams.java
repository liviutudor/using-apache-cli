package liv.tudor;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CmdLineParams {

  public static final String OPTION_FILE_SHORT = "f";
  public static final Options OPTIONS = new Options();

  static {
    Option file = new Option(OPTION_FILE_SHORT, "input-file_path", true, "Filename to import");
    file.setRequired(true);
    OPTIONS.addOption(file);
    OPTIONS.addOption("enc", true, "Encoding of the import file");
    OPTIONS.addOption("host", true, "DB host");
    OPTIONS.addOption("db", true, "Database name");
  }


  private CommandLine commandLine;

  public CmdLineParams(String... args) throws ParseException {
    CommandLineParser parser = new DefaultParser();
    commandLine = parser.parse(OPTIONS, args);
  }

  public String getFileName() {
    return commandLine.getOptionValue(OPTION_FILE_SHORT);
  }

  public String getEncoding() {
    return commandLine.getOptionValue("enc");
  }

  public String getDatabaseHost() {
    return commandLine.getOptionValue("host");
  }

  public String getDatabaseName() {
    return commandLine.getOptionValue("db");
  }

}
