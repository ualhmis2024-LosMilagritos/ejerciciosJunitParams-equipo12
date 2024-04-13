package ual.hmis.sesion05.ejercicio3;


public class Ejercicio3 {
    public String encrypted(String password) {
        if (password.length() < 5) {
            System.out.println("Contraseña demasiado corta");
        } else if (password.length() >= 5 && password.length() <= 8) {
            StringBuilder newpass = new StringBuilder();
            for (int i = 0; i < password.length(); i++) {
                newpass.append("*");
            }
            return newpass.toString();
        } else if (password.length() >= 12 && password.length() <= 40) {
            return "************";
        } else if (password.length() > 40) {
            System.out.println("Contraseña demasiado larga");
            return null;
        }
        return null;
    }
}

