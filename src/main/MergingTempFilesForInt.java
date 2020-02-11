
package main;

import java.io.*;
import java.util.List;

public class MergingTempFilesForInt {

    private List<File> listOfTempFiles;
    private int AllSlices;
    private String outputFileName;
    private int totalCountOfLines;
    private boolean isSortDescending;

    public MergingTempFilesForInt(List<File> listOfTempFiles, int totalCountOfLines, String outputFileName, boolean isSortDescending) {
        this.listOfTempFiles = listOfTempFiles;
        this.AllSlices = listOfTempFiles.size();
        this.outputFileName = outputFileName;
        this.totalCountOfLines = totalCountOfLines;
        this.isSortDescending = isSortDescending;
    }

    // Объединяем файлы и записываем на диск
    public void run() throws IOException {
        int[] topValue = new int[AllSlices];
        BufferedReader[] bufferedReaders = new BufferedReader[AllSlices];

        for (int i = 0; i < AllSlices; i++) {
            bufferedReaders[i] = new BufferedReader(new FileReader(listOfTempFiles.get(i)));
            String t = bufferedReaders[i].readLine();

            if (t != null)
                topValue[i] = Integer.parseInt(t);
            else
                topValue[i] = Integer.MAX_VALUE;
        }

        FileWriter fileWriter = new FileWriter(outputFileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (int i = 0; i < totalCountOfLines; i++) {

            int min = topValue[0];
            int minFile = 0;
            if (!isSortDescending) {

                for (int j = 0; j < AllSlices; j++) {
                    if (min > topValue[j]) {
                        min = topValue[j];
                        minFile = j;
                    }
                }

                printWriter.println(min);
                String t = bufferedReaders[minFile].readLine();
                if (t != null)
                    topValue[minFile] = Integer.parseInt(t);
                else
                    topValue[minFile] = Integer.MAX_VALUE;
            } else {

                for (int j = 0; j < AllSlices; j++) {
                    if (min < topValue[j]) {
                        min = topValue[j];
                        minFile = j;
                    }
                }

                printWriter.println(min);
                String t = bufferedReaders[minFile].readLine();
                if (t != null)
                    topValue[minFile] = Integer.parseInt(t);
                else
                    topValue[minFile] = Integer.MIN_VALUE;
            }

        }

        for (int i = 0; i < AllSlices; i++) {
            bufferedReaders[i].close();
            printWriter.close();
            fileWriter.close();
        }
    }
}

