import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Projem {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Banka Uygulaması");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        
        JTextField hesapNumarasiTextField = new JTextField(15);
        JTextField miktarTextField = new JTextField(10);
        JLabel bakiyeLabel = new JLabel("Mevcut Bakiye: 0.0");

        frame.add(new JLabel("Hesap Numarası:"));
        frame.add(hesapNumarasiTextField);
        frame.add(new JLabel("Miktar:"));
        frame.add(miktarTextField);
        frame.add(bakiyeLabel);
        
        double[] bakiye = {0.0};
        boolean[] hesapAcilmis = {false};
        
        JButton hesapAcButton = new JButton("Hesap Aç");
        hesapAcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!hesapAcilmis[0]) {
                    hesapAcilmis[0] = true;
                    JOptionPane.showMessageDialog(frame, "Hesap açıldı.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Hesap zaten açık.");
                }
            }
        });
        frame.add(hesapAcButton);
        
        JButton hesapKapatButton = new JButton("Hesap Kapat");
        hesapKapatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hesapAcilmis[0]) {
                    hesapAcilmis[0] = false;
                    bakiye[0] = 0.0;
                    bakiyeLabel.setText("Mevcut Bakiye: " + bakiye[0]);
                    JOptionPane.showMessageDialog(frame, "Hesap kapatıldı.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Hesap açık değil.");
                }
            }
        });
        frame.add(hesapKapatButton);
        
        JButton paraYatirButton = new JButton("Para Yatır");
        paraYatirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hesapAcilmis[0]) {
                    try {
                        double miktar = Double.parseDouble(miktarTextField.getText());
                        if (miktar > 0) {
                            bakiye[0] += miktar;
                            bakiyeLabel.setText("Mevcut Bakiye: " + bakiye[0]);
                            JOptionPane.showMessageDialog(frame, "Para yatırıldı.");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Pozitif bir miktar girin.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Geçerli bir miktar girin.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Önce hesap açın.");
                }
            }
        });
        frame.add(paraYatirButton);
        
        JButton paraCekButton = new JButton("Para Çek");
        paraCekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hesapAcilmis[0]) {
                    try {
                        double miktar = Double.parseDouble(miktarTextField.getText());
                        if (miktar > 0) {
                            if (miktar <= bakiye[0]) {
                                bakiye[0] -= miktar;
                                bakiyeLabel.setText("Mevcut Bakiye: " + bakiye[0]);
                                JOptionPane.showMessageDialog(frame, "Para çekildi.");
                            } else {
                                JOptionPane.showMessageDialog(frame, "Yetersiz bakiye.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "Pozitif bir miktar girin.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Geçerli bir miktar girin.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Önce hesap açın.");
                }
            }
        });
        frame.add(paraCekButton);
        
        JButton bakiyeGosterButton = new JButton("Kalan Para");
        bakiyeGosterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Mevcut Bakiye: " + bakiye[0]);
            }
        });
        frame.add(bakiyeGosterButton);
        
        frame.pack();
        frame.setVisible(true);
    }
}
