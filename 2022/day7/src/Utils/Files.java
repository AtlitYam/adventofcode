package Utils;

import lombok.Getter;

@Getter
public class Files {
    private final String parentFolder;
    private final String fileName;
    private final Integer fileSize;

    public Files(String parentFolder, String fileName, Integer fileSize) {
        this.parentFolder = parentFolder;
        this.fileName = fileName;
        this.fileSize = fileSize;
    }
}
