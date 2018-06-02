package Controller;

import javax.swing.filechooser.FileFilter;
import java.io.File;


public class Files extends FileFilter{
    private String description;
    private String extension;

    public Files(){
        this.description = "XML (*.xml)";
        this.extension ="xml";
    }

    @Override
    public String getDescription(){
        return description;
    }
    public boolean accept(File file){
        if(file.isDirectory()){
            return true;
        }
        else {
            String path = file.getAbsolutePath().toLowerCase();
            if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
                return true;
            }
        }
        return false;
        }
    }

