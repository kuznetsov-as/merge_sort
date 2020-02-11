package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParsingCommandLineArguments {
    private boolean sortDescending;
    private boolean sortString;
    private String outputFileName;
    private List<String> inputFileNames = new ArrayList<>();

    public boolean isSortDescending() {
        return sortDescending;
    }

    public boolean isSortString() {
        return sortString;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public List<String> getInputFileNames() {
        return inputFileNames;
    }

    public void run(String[] args) {
        if (args.length < 3) {
            System.out.println("Количество введенных параметров не соответствует минимальному значению.");
            System.exit(1);
        } else {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < 2; i++) {
                stringBuilder.append(args[i]);
            }

            String parameterAssistant = stringBuilder.toString();


            if (parameterAssistant.contains("-a")) {
                sortDescending = false;
                outputFileName = args[2];
                inputFileNames.addAll(Arrays.asList(args).subList(3, args.length));
            } else if (parameterAssistant.contains("-d")) {
                sortDescending = true;
                outputFileName = args[2];
                inputFileNames.addAll(Arrays.asList(args).subList(3, args.length));
            } else {
                outputFileName = args[1];
                inputFileNames.addAll(Arrays.asList(args).subList(2, args.length));
            }

            if (parameterAssistant.contains("-i")) {
                sortString = false;
            } else if (parameterAssistant.contains("-s")) {
                sortString = true;
            } else {
                System.out.println("Ввод параметров осуществлен некорректно.");
                System.exit(1);
            }
        }
    }
}
