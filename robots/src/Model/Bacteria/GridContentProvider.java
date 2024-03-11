package Model.Bacteria;

import java.awt.*;

public interface GridContentProvider {
    GridContentType getContent(Point coordinates);
}
