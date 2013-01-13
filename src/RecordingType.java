
import edu.wpi.first.smartdashboard.types.NamedDataType;


public class RecordingType extends NamedDataType{
    
    public static final String LABEL = "RecordingType";

    private RecordingType() {
        super(LABEL, RecordingWidget.class);
    }

    public static NamedDataType get() {
        if (NamedDataType.get(LABEL) != null) {
            return NamedDataType.get(LABEL);
        } else {
            return new RecordingType();
        }
    }
}
