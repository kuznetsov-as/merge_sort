package main;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ParsingCommandLineArguments arguments = new ParsingCommandLineArguments();
        arguments.run(args);

        if (arguments.isSortString()) {
            for (int i = 0; i < arguments.getInputFileNames().size(); i++) {
                String fileName = arguments.getInputFileNames().get(i);
                File file = new File(fileName);
                int countOfLinesInTheFile = LineCounter.run(file);
                FileSplitterForString fileSplitter = new FileSplitterForString(countOfLinesInTheFile, file, arguments.isSortDescending());
                fileSplitter.run();
            }

            MergingTempFilesForString mergingTempFiles = new MergingTempFilesForString(FileSplitterForString.getListOfTempFiles(),
                    FileSplitterForString.getTotalCountOfLines(),
                    arguments.getOutputFileName(),
                    arguments.isSortDescending());
            mergingTempFiles.run();

        } else {
            for (int i = 0; i < arguments.getInputFileNames().size(); i++) {
                String fileName = arguments.getInputFileNames().get(i);
                File file = new File(fileName);
                int countOfLinesInTheFile = LineCounter.run(file);
                FileSplitterForInt fileSplitter = new FileSplitterForInt(countOfLinesInTheFile, file, arguments.isSortDescending());
                fileSplitter.run();
            }

            MergingTempFilesForInt mergingTempFiles = new MergingTempFilesForInt(FileSplitterForInt.getListOfTempFiles(),
                    FileSplitterForInt.getTotalCountOfLines(),
                    arguments.getOutputFileName(),
                    arguments.isSortDescending());
            mergingTempFiles.run();
        }

        System.out.println("Done!");
    }
}
