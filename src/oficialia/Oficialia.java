/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oficialia;

/**
 *
 * @author Héctor Alan López Díaz <alanlopez1995@hotmail.com>
 */
public class Oficialia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Email alan = new Email("alanlopez1995@hotmail.com", "Soyegglnumero2",Host.HOTMAIL);
        alan.sendMail("alanlopez1995@hotmail.com", "prueba", "Prueba correo ubuntu");
    }
    
}
