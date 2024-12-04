package Utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class HeadsAndTails {
    private final String identifier;
    @Setter
    private Integer x;
    @Setter
    private Integer y;
}
