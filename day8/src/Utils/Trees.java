package Utils;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Trees {
    private final Integer treeHeight;
    private final Integer x;
    private final Integer y;
    @Setter
    private boolean counted;

    public Trees(Integer treeHeight, Integer x, Integer y, boolean counted) {
        this.treeHeight = treeHeight;
        this.x = x;
        this.y = y;
        this.counted = counted;
    }
}
