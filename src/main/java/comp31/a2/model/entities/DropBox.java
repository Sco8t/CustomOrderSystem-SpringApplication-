package comp31.a2.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DropBox {


    String user;

    public DropBox(String user) {
        super();
        this.user = user;
    }
    
}
