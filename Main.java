import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class MenuButton extends JButton {
    public MenuButton(JFrame frame) {
        super("Menu");
        setBounds(10, 10, 80, 30);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new GraficzneOkno(frame);
            }
        });
    }
}



class MigajTextField extends JTextField {
    public MigajTextField() {
        super("Migaj");
        setHorizontalAlignment(JTextField.CENTER);
        setBounds(450, 10, 100, 30);
        setEditable(false);
    }
}

class UmieszButton extends JButton {
    public UmieszButton() {
        super("Umiesz?");
        setBounds(462, 550, 100, 30);
    }
}

class ImageLabel extends JLabel {
    public ImageLabel(String imagePath, int x, int y) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);
        imageIcon = new ImageIcon(image);
        setIcon(imageIcon);
        setBounds(x, y, 200, 150);
    }
}

class GraficzneOkno extends JFrame {
    public GraficzneOkno(JFrame parentFrame) {
        super("Okno Graficzne");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JButton zamknijButton = new JButton("Zamknij");
        zamknijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Zamknij okno graficzne
                dispose();
            }
        });


        JPanel panel = new JPanel();
        panel.add(zamknijButton);
        add(panel);


        setLocationRelativeTo(parentFrame);
        setVisible(true);
    }
}


class Okno extends JFrame {
    public Okno() {
        super("Przykładowe Okno");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);


        MenuButton menuButton = new MenuButton(this);
        panel.add(menuButton);
        panel.add(new MigajTextField());


        String[] imagePaths = {"C:\\Users\\barba\\OneDrive\\Pulpit\\studia\\semestr5\\sorry.png", "C:\\Users\\barba\\OneDrive\\Pulpit\\studia\\semestr5\\please.png", "C:\\Users\\barba\\OneDrive\\Pulpit\\studia\\semestr5\\bye.png", "C:\\Users\\barba\\OneDrive\\Pulpit\\studia\\semestr5\\hello.png"}; // Podaj ścieżki do zdjęć
        for (int i = 0; i < 4; i++) {
            panel.add(new ImageLabel(imagePaths[i], 50 + i * 250, 250));
        }

        panel.add(new UmieszButton());


        add(panel);


        setVisible(true);
    }
}
public class Main {
    public static void main(String[] args) {
        Okno a = new Okno();

    };
}


