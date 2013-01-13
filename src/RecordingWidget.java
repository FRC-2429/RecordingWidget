
import edu.wpi.first.smartdashboard.gui.Widget;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.smartdashboard.types.DataType;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ethan_000
 */
public class RecordingWidget extends Widget implements ITableListener{
    
    public static final DataType[] TYPES = {RecordingType.get()};

    
    String currentFile = "None";
    boolean recording;
    boolean playing;
    
    ITable table;
    
    RecordingWidgetGUI gui;
    
    @Override
    public void setValue(Object value) {
        table = (ITable) value;
        table.addTableListener(this);
    }

      
    @Override
    public void init() {
        
       add(gui = new RecordingWidgetGUI());
       
       
       
  
       
       gui.FileChoiceButton.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                table.putString("File", gui.FileTextField.getText()); 
            }
        });
       
       gui.RecordButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                table.putString("Command","Record");
            }
        });
       
       gui.PlayButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                table.putString("Command","Play");
            }
        });
       
        gui.StopButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                table.putString("Command","Stop");
            }
        });
        
    }

    @Override
    public void propertyChanged(Property property) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void valueChanged(ITable itable, String string, Object o, boolean bln) {
        switch (string) {
            case "FileStatus":
                gui.FileStatusLabel.setText((String) o);
                break;
            case "Status":
                gui.StatusLabel.setText((String) o);
                break;
                
                
        }
        
    }
    
    
    
}
