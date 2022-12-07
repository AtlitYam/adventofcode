import fileutils.FileLoader;
import utils.Files;
import utils.Folders;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class DaySeven {
    public static void main(String[] args) {
        Instant startTime = Instant.now();
        String filePath = "resources/DaySevenChallenge.txt";

        List<Object> fileStructure = FileLoader.loadFolderStructureFromFile(filePath);

        List<Folders> folders = (List<Folders>) fileStructure.get(0);
        List<Files> files = (List<Files>) fileStructure.get(1);

        Integer freeSystemSpace = DaySevenImpl.calculateFreeSpace(folders, files, (int) 7e7);
        Integer requiredSpaceForUpdate = (int) (3e7 - freeSystemSpace);

        // For the first challenge we need to find the folders larger than 100.000 and add those up
        System.out.printf("The total size of all folders smaller than 100000 is %s%n", DaySevenImpl.getTotalSizeOfFoldersSmallerThan(folders, files, (int) 1e5));

        // For the second challenge we need to find the smallest folder of at least 8.381.165
        System.out.printf("The smallest folder of at least %s has a size of %s%n", requiredSpaceForUpdate, DaySevenImpl.getFirstFolderOfAtleastSize(folders, files, requiredSpaceForUpdate));

        System.out.printf("(Completed in %sms)%n", Duration.between(startTime, Instant.now()).toMillis());
    }
}
