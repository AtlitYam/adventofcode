package Utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Boxes {
    private final String name;
    private Integer x;
    private Integer y;

    public Boxes(String name, Integer x, Integer y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
}
