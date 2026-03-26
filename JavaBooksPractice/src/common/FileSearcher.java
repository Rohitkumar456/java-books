package common;

import java.io.File;

public class FileSearcher implements Runnable{
    private File sourceFile;
    private String fileNameToBeSearched;

    public FileSearcher(File source, String target){
        this.sourceFile = source;
        this.fileNameToBeSearched = target;
    }

    @Override
    public void run() {
        if(sourceFile!=null){
            if(sourceFile.isDirectory()){
                searchDirectory(sourceFile);
            }else{
                searchFile(sourceFile);
            }
        }
    }

    public void searchFile(File file){
        if(file.getName().equals(fileNameToBeSearched)){
            System.out.println("File found at location: "+ file.getAbsolutePath());
            System.exit(1);
        }
    }

    public void searchDirectory(File file){
        File[] files = file.listFiles();
        if(files!=null){
            for (File currentFile : files) {
                if (currentFile.isDirectory()) {
                    Thread th = new Thread(new FileSearcher(currentFile, fileNameToBeSearched));
                    th.start();
                } else {
                    searchFile(currentFile);
                }
            }
        }

    }
}
