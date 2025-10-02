import javax.swing.JOptionPane;

public class MonthCounting {
    public static void main (String[] args){
        int month = -1;
        while (true) {
            String input = JOptionPane.showInputDialog(null, "Nhap thang: ", JOptionPane.INFORMATION_MESSAGE);
            if (input.matches("\\d+")) {
                month = Integer.parseInt(input);
            }
            else {
                switch (input) {
                    case "jan": case "jan.": case "january": month = 1; break;
                    case "feb": case "feb.": case "february": month = 2; break;
                    case "mar": case "march": case "mar.": month = 3; break;
                    case "apr": case "april": case "apr.": month = 4; break;
                    case "may": case "may.": month = 5; break;
                    case "jun": case "june": case "jun.": month = 6; break;
                    case "jul": case "july": case "jul.": month = 7; break;
                    case "aug": case "august": case "aug.": month = 8; break;
                    case "sep": case "september": case "sep.": month = 9; break;
                    case "oct": case "october": case "oct.": month = 10; break;
                    case "nov": case "november": case "nov.": month = 11; break;
                    case "dec": case "december": case "dec.":month = 12; break;
                    default: month = -1; 
                }
            }
            if (month >= 1 && month <= 12) {
                break; 
            } else {
                System.out.println("nhap lai");
            }
        }
        int year;
        while (true) {
            try {
                String str = JOptionPane.showInputDialog(null, "Nhập năm (>= 0):");
                if (str == null) return; // bấm Cancel
                year = Integer.parseInt(str.trim());
                if (year >= 0) break;
            } catch (NumberFormatException ignored) {}
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số nguyên hợp lệ ≥ 0.");
        }
        int days;
        if (month == 2) {
            boolean leap = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
            days = leap ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            days = 30;
        } else {
            days = 31;
        }
        JOptionPane.showMessageDialog(null, "So ngay trong thang do la: " + days);
        }}
