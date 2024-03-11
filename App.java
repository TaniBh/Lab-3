import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App extends JFrame {
    // Declaring a JTextArea
    private JTextArea textArea;

    // App Class Constructor.
    public App() {
        // JFrame settings
        // Setting Title
        setTitle("CSV Loader Application");
        // Setting Dimensions of Window
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE); // Setting background color

        // 1. Create a new button named loadButton with text "LoadCSV"
        JButton loadButton = new JButton("Load CSV");
        // Setting button background and foreground colors
        loadButton.setBackground(new Color(52, 152, 219)); // Set to a shade of blue
        loadButton.setForeground(Color.WHITE); // Set text color to white
        // Setting button font
        loadButton.setFont(new Font("Arial", Font.BOLD, 14)); // Set font to Arial, bold, size 14

        // 5. Add an ActionListener to the button
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call loadCsv method when the button is clicked
                loadCsv("your_file_path.csv");
            }
        });

        // 2. Initialize a new TextArea and 3. Set it to be uneditable
        textArea = new JTextArea();
        textArea.setEditable(false);
        // Setting text area font
        textArea.setFont(new Font("Arial", Font.PLAIN, 12)); // Set font to Arial, size 12
        // Setting text area background and foreground colors
        textArea.setBackground(Color.WHITE); // Set background color to white
        textArea.setForeground(Color.BLACK); // Set text color to black

        // 4. Create a JScrollPane within the text area
        JScrollPane scrollPane = new JScrollPane(textArea);
        // Setting scroll pane border
        scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Adding padding

        // Add components to the frame
        add(loadButton, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void loadCsv(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
            textArea.setText(content.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to load the CSV file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App().setVisible(true);
            }
        });
    }
}
