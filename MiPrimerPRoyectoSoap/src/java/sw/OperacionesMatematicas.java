/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Cliente;
import modelo.Deposito_Retiro;

/**
 *
 * @author sandr
 */
@WebService(serviceName = "OperacionesMatematicas")
public class OperacionesMatematicas {

    /**
     * This is a sample web service operation
     *
     * @param txt
     * @return
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     *
     * @param euros
     * @return
     */
    @WebMethod(operationName = "euroADolar")
    public Double euroADolar(@WebParam(name = "euros") double euros) {
        //TODO write your implementation code here:
        return euros * 1.15;
    }

    ArrayList<Cliente> clientes = new ArrayList();

    /**
     * Web service operation
     */
//    @WebMethod(operationName = "loggin")
//    public String loggin(@WebParam(name = "user") String user, @WebParam(name = "password") String password) {
//        String message;
//
//        if (user.equals("sandrita") && password.equals("sandrix123")) {
//            message = "Inicio de sesion valido";
//            return message; // Acceso concedido
//        } else {
//            message = "Inicio de sesion invalido";
//            return message; // Acceso denegado
//        }
//    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "suma")
    public Double suma(@WebParam(name = "num1") double num1, @WebParam(name = "num2") double num2) {
        //TODO write your implementation code here:
        return num1 + num2;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "resta")
    public Double resta(@WebParam(name = "num1") double num1, @WebParam(name = "num2") double num2) {
        //TODO write your implementation code here:
        return num1 - num2;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "multiplicacion")
    public Double multiplicacion(@WebParam(name = "num1") double num1, @WebParam(name = "num2") double num2) {
        //TODO write your implementation code here:
        return num1 * num2;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "division")
    public Double division(@WebParam(name = "num1") double num1, @WebParam(name = "num2") double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new ArithmeticException("División por cero no permitida.");
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "formulaCuadratica")
    public String formulaCuadratica(@WebParam(name = "a") double a, @WebParam(name = "b") double b, @WebParam(name = "c") double c) {
        double discriminante = b * b - 4 * a * c;
        if (discriminante > 0) {
            double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            return "Dos raíces reales: Raíz1=" + raiz1 + ", Raíz2=" + raiz2;
        } else if (discriminante == 0) {
            double raizUnica = -b / (2 * a);
            return "Una raíz real única: Raíz=" + raizUnica;
        } else {
            return "Raíces complejas (imaginarias)";
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registro")
    public boolean registro(@WebParam(name = "user") Cliente user) {
        //TODO write your implementation code here:
        return clientes.add(user);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public Cliente login(@WebParam(name = "user") Cliente user) {
        Cliente cliente1 = new Cliente();

        for (Cliente cliente : clientes) {
            if (cliente.getUser().equals(user.getUser()) && cliente.getPass().equals(user.getPass())) {
                cliente1 = cliente;
            }
        }
        return cliente1; // Inicio de sesión fallido
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "retirar")
    public Deposito_Retiro retirar(@WebParam(name = "numero") Deposito_Retiro numero) {
        Deposito_Retiro retiro = new Deposito_Retiro();
        for (Cliente cliente : clientes) {
            if (cliente.getUser().equals(numero.getUser())) {
                cliente.setSaldo(cliente.getSaldo() - numero.getCantidad());
                retiro.setCantidad(cliente.getSaldo());
                break;
            }
        }

        return retiro;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "depositar")
    public Deposito_Retiro depositar(@WebParam(name = "numero") Deposito_Retiro numero) {
        //TODO write your implementation code here:
        Deposito_Retiro depositar = new Deposito_Retiro();
        for (Cliente cliente : clientes) {
            if (cliente.getUser().equals(numero.getUser())) {
                cliente.setSaldo(cliente.getSaldo() + numero.getCantidad());
                depositar.setCantidad(cliente.getSaldo());
                break;
            }
        }

        return depositar;
    }

}
