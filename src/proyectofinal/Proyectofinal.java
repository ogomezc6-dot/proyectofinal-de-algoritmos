/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinal;

import java.util.Scanner;

public class Proyectofinal {

    public static void main(String[] args) {

        try (Scanner entrada = new Scanner(System.in)) {
            int opcion;
            
                  
            // Contadores y acumuladores generales de la caja
            int ventasRealizadas = 0;
            int productosVendidos = 0;
            double totalVendido = 0;
            
            int ventasEfectivo = 0;
            int ventasTarjeta = 0;
            int ventasTransferencia = 0;
            
            double ventaMayor = 0;
            double ventaMenor = 0;
            
            // El menu se repite hasta seleccionar la opcion 4
            do {
                System.out.println("/////SISTEMA DE VENTAS/////");
                System.out.println("1. Registrar una venta");
                System.out.println("2. Consultar caja");
                System.out.println("3. Mostrar estadisticas");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opcion: ");
                
                opcion = entrada.nextInt();
                
                switch (opcion) {
                    
                    case 1 ->  {
                        int cantidadProductos;
                        
                        System.out.print("Cuantos productos diferentes tiene la compra? ");
                        cantidadProductos = entrada.nextInt();
                        
                        while (cantidadProductos <= 0) {
                            System.out.print("Debe ingresar un numero mayor que cero: ");
                            cantidadProductos = entrada.nextInt();
                        }
                        
                        // Variables correspondientes a esta venta
                        double subtotal = 0;
                        double descuento;
                        double montoDescuento;
                        double iva;
                        double total;
                        
                        // Ingresar cada producto de la venta
                        for (int i = 1; i <= cantidadProductos; i++) {
                            System.out.println("\n--- PRODUCTO " + i + " ---");
                            
                            int codigo;
                            String nombre;
                            double precio;
                            int cantidad;
                            
                            System.out.print("Codigo: ");
                            codigo = entrada.nextInt();
                            entrada.nextLine();
                            
                            System.out.print("Nombre: ");
                            nombre = entrada.nextLine();
                            
                            System.out.print("Precio unitario: Q");
                            precio = entrada.nextDouble();
                            
                            while (precio <= 0) {
                                System.out.print("El precio debe ser mayor que cero: Q");
                                precio = entrada.nextDouble();
                            }
                            
                            System.out.print("Cantidad: ");
                            cantidad = entrada.nextInt();
                            
                            while (cantidad <= 0) {
                                System.out.print("La cantidad debe ser mayor que cero: ");
                                cantidad = entrada.nextInt();
                            }
                            
                            double subtotalProducto = precio * cantidad;
                            subtotal = subtotal + subtotalProducto;
                            productosVendidos = productosVendidos + cantidad;
                            
                            System.out.println("Codigo: " + codigo);
                            System.out.println("Producto: " + nombre);
                            System.out.printf("Subtotal del producto: Q%.2f%n", subtotalProducto);
                        }
                        
                        // Aplicar el descuento segun el subtotal
                        if (subtotal < 200) {
                            descuento = 0;
                        } else if (subtotal < 500) {
                            descuento = subtotal * 0.05;
                        } else if (subtotal < 1000) {
                            descuento = subtotal * 0.08;
                        } else {
                            descuento = subtotal * 0.10;
                        }
                        
                        montoDescuento = subtotal - descuento;
                        iva = montoDescuento * 0.12;
                        total = montoDescuento + iva;
                        
                        System.out.println("\n--- CALCULO DE LA COMPRA ---");
                        System.out.printf("Subtotal: Q%.2f%n", subtotal);
                        System.out.printf("Descuento: Q%.2f%n", descuento);
                        System.out.printf("Monto con descuento: Q%.2f%n", montoDescuento);
                        System.out.printf("IVA (12%%): Q%.2f%n", iva);
                        System.out.printf("Total a pagar: Q%.2f%n", total);
                        
                        // Seleccionar forma de pago
                        int formaPago;
                        
                        System.out.println("\n--- FORMA DE PAGO ---");
                        System.out.println("1. Efectivo");
                        System.out.println("2. Tarjeta");
                        System.out.println("3. Transferencia");
                        System.out.print("Seleccione una opcion: ");
                        formaPago = entrada.nextInt();
                        
                        while (formaPago < 1 || formaPago > 3) {
                            System.out.print("Opcion no valida. Ingrese 1, 2 o 3: ");
                            formaPago = entrada.nextInt();
                        }
                        
                        double efectivoRecibido = 0;
                        double cambio = 0;
                        String nombrePago = "";
                        
                        switch (formaPago) {
                            case 1 -> nombrePago = "Efectivo";
                            case 2 -> nombrePago = "Tarjeta";
                            case 3 -> nombrePago = "Transferencia";
                        }
                        
                        // Si es efectivo, comprobar que alcance para pagar
                        if (formaPago == 1) {
                            System.out.print("Efectivo recibido: Q");
                            efectivoRecibido = entrada.nextDouble();
                            
                            while (efectivoRecibido < total) {
                                System.out.println("El efectivo es insuficiente.");
                                System.out.print("Ingrese nuevamente el efectivo: Q");
                                efectivoRecibido = entrada.nextDouble();
                            }
                            
                            cambio = efectivoRecibido - total;
                        }
                        
                        // Resumen final de la venta
                        System.out.println("\n--- RESUMEN FINAL ---");
                        System.out.println("Productos diferentes: " + cantidadProductos);
                        System.out.printf("Subtotal: Q%.2f%n", subtotal);
                        System.out.printf("Descuento: Q%.2f%n", descuento);
                        System.out.printf("Monto con descuento: Q%.2f%n", montoDescuento);
                        System.out.printf("IVA: Q%.2f%n", iva);
                        System.out.printf("Total: Q%.2f%n", total);
                        System.out.println("Forma de pago: " + nombrePago);
                        
                        if (formaPago == 1) {
                            System.out.printf("Efectivo recibido: Q%.2f%n", efectivoRecibido);
                            System.out.printf("Cambio: Q%.2f%n", cambio);
                        }

                        // Actualizar datos generales de la caja
                        ventasRealizadas++;
                        totalVendido = totalVendido + total;
                        
                        if (ventasRealizadas == 1) {
                            ventaMayor = total;
                            ventaMenor = total;
                        } else {
                            if (total > ventaMayor) {
                                ventaMayor = total;
                            }
                            if (total < ventaMenor) {
                                ventaMenor = total;
                            }
                        }
                        
                    switch (formaPago) {
                        case 1 -> ventasEfectivo++;
                        case 2 -> ventasTarjeta++;
                        default -> ventasTransferencia++;
                    }
                        
                        System.out.println("Venta registrada correctamente.");
                    }
                    
                    case 2 ->  {
                        System.out.println("\n--- CONSULTA DE CAJA ---");
                        System.out.println("Ventas realizadas: " + ventasRealizadas);
                        System.out.println("Unidades de productos vendidos: " + productosVendidos);
                        System.out.printf("Total vendido: Q%.2f%n", totalVendido);
                        System.out.println("Ventas en efectivo: " + ventasEfectivo);
                        System.out.println("Ventas con tarjeta: " + ventasTarjeta);
                        System.out.println("Ventas por transferencia: " + ventasTransferencia);
                    }

                    case 3 ->  {
                        System.out.println("\n--- ESTADISTICAS ---");
                        
                        if (ventasRealizadas == 0) {
                            System.out.println("No existen ventas registradas.");
                        } else {
                            double promedio = totalVendido / ventasRealizadas;
                            
                            System.out.println("Numero total de ventas: " + ventasRealizadas);
                            System.out.println("Cantidad total de productos vendidos: " + productosVendidos);
                            System.out.printf("Total de dinero vendido: Q%.2f%n", totalVendido);
                            System.out.printf("Promedio por venta: Q%.2f%n", promedio);
                            System.out.println("Ventas en efectivo: " + ventasEfectivo);
                            System.out.println("Ventas con tarjeta: " + ventasTarjeta);
                            System.out.println("Ventas por transferencia: " + ventasTransferencia);
                            System.out.printf("Venta de mayor valor: Q%.2f%n", ventaMayor);
                            System.out.printf("Venta de menor valor: Q%.2f%n", ventaMenor);
                        }
                    }
                    
                    case 4 -> System.out.println("Saliendo del programa...");
                        
                    default -> System.out.println("Opcion no valida. Seleccione del 1 al 4.");
                }
                
            } while (opcion != 4);
        }
    }
}

