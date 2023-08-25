import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 
import java.util.HashMap; 
import java.util.Map; 
 
public class WordCounterGUI extends JFrame { 
    private JTextArea jTextArea; 
    private JButton countButton; 
    private JLabel resultLabel; 
 
    public WordCounterGUI() { 
        setTitle("Word Counter"); 
        setSize(400, 300); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(new BorderLayout()); 
 
        jTextArea = new JTextArea(); 
        JScrollPane scrollPane = new JScrollPane(jTextArea); 
        add(scrollPane, BorderLayout.CENTER); 
 
        countButton = new JButton("Count Words"); 
        countButton.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent e) { 
                countWords(); 
            } 
        }); 
 
        resultLabel = new JLabel("Total words: 0"); 
        add(resultLabel, BorderLayout.SOUTH); 
 
        JPanel buttonPanel = new JPanel(); 
        buttonPanel.add(countButton); 
        add(buttonPanel, BorderLayout.NORTH); 
    } 
 
    private void countWords() { 
        String inputText = jTextArea.getText(); 
        String[] words = inputText.split("[\\s\\p{Punct}]+"); 
        int wordCount = words.length; 
 
        // Counting unique words and their frequency 
        Map<String, Integer> wordFrequency = new HashMap<>(); 
        for (String word : words) { 
            word = word.toLowerCase(); 
            if (!wordFrequency.containsKey(word)) { 
                wordFrequency.put(word, 1); 
            } else { 
                wordFrequency.put(word, wordFrequency.get(word) + 1); 
            } 
        } 
 
        // Displaying unique word count and word frequency 
        resultLabel.setText("Total words: " + wordCount + " | Unique words: " + wordFrequency.size()); 
 
        // Displaying word frequency 
        StringBuilder frequencyText = new StringBuilder("<html>Word Frequency:<br>"); 
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) { 
            frequencyText.append(entry.getKey()).append(": ").append(entry.getValue()).append("<br>"); 
        } 
        frequencyText.append("</html>"); 
         
        JOptionPane.showMessageDialog(this, new JLabel(frequencyText.toString())); 
    } 
 
    public static void main(String[] args) { 
        SwingUtilities.invokeLater(new Runnable() { 
            @Override 
            public void run() { 
                WordCounterGUI gui = new WordCounterGUI(); 
                gui.setVisible(true); 
            } 
        }); 
    } 
}
