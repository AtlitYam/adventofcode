import Utils.Files;
import Utils.FilesAndFoldersHelper;
import Utils.Folders;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class DaySevenImpl {
    public static Integer getTotalSizeOfFoldersSmallerThan(List<Folders> folders, List<Files> files, Integer sizeLimit) {
        return getAllFolderSizes(folders, files).filter(folderSize -> folderSize <= sizeLimit).mapToInt(Integer::intValue).sum();
    }

    public static Integer getFirstFolderOfAtleastSize(List<Folders> folders, List<Files> files, Integer minimumSize) {
        return getAllFolderSizes(folders, files).filter(folderSize -> folderSize >= minimumSize).min(Comparator.naturalOrder()).orElse(-1);
    }

    public static Integer calculateFreeSpace(List<Folders> folders, List<Files> files, Integer totalSystemSpace) {
        return totalSystemSpace - getAllFolderSizes(folders, files).max(Comparator.naturalOrder()).orElse(-1);
    }

    public static Stream<Integer> getAllFolderSizes(List<Folders> folders, List<Files> files) {
        return folders.stream().map(folder -> FilesAndFoldersHelper.getSizeOfFolder(folders, files, folder));
    }
}
