
package com.mycompany.lab010pooi2312051;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LAB010POOI2312051 {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1.Registrar paciente");
            System.out.println("2.Eliminar paciente");
            System.out.println("3.Modificar paciente");
            System.out.println("4.Mostrar peso que más se repite");
            System.out.println("5.Mostrar cantidad de pacientes con peso repetido");
            System.out.println("6.Mostrar peso mayor y menor");
            System.out.println("7.Dividir rango de pesos y mostrar cantidad de personas en cada rango");
            System.out.println("8.Mostrar lista de pacientes ordenados por apellidos");
            System.out.println("9.Indicar qué doctor atendió a un paciente");
            System.out.println("10.Buscar doctores por especialidad");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                     System.out.print("Ingrese DNI del paciente: ");
                    String dni = scanner.next();
                    System.out.print("Ingrese nombre del paciente: ");
                    String nombrePaciente = scanner.next();
                    System.out.print("Ingrese dirección del paciente: ");
                    String direccionPaciente = scanner.next();
                    System.out.print("Ingrese peso del paciente: ");
                    double pesoPaciente = scanner.nextDouble();
                    System.out.print("Ingrese temperatura del paciente: ");
                    double temperaturaPaciente = scanner.nextDouble();

                    Paciente pacienteNuevo = new Paciente(dni, nombrePaciente, direccionPaciente, pesoPaciente, temperaturaPaciente);

                    Medico medicoAsignado = new Medico(12345, "NombreMedico", "EspecialidadMedico");

                    hospital.registrarPaciente(pacienteNuevo, medicoAsignado);
                    break;
                case 2:
                    List<Paciente> listaPacientes = hospital.getListaPacientes();
                    System.out.println("Lista de pacientes:");

                    for (int i = 0; i < listaPacientes.size(); i++) {
                        Paciente paciente = listaPacientes.get(i);
                        System.out.println(i + ". DNI: " + paciente.getDNI() + ", Nombre: " + paciente.getNombre());
                    }

                    // Pedir al usuario que elija un paciente para eliminar
                    System.out.print("Ingrese el número del paciente a eliminar: ");
                    int opcionEliminar = scanner.nextInt();

                    // Verificar si la opción es válida
                    if (opcionEliminar >= 0 && opcionEliminar < listaPacientes.size()) {
                        hospital.eliminarPaciente(opcionEliminar);
                    } else {
                        System.out.println("Opción no válida. No se pudo eliminar al paciente.");
                    }
                    break;
                    
                    case 3:
                        List<Paciente> listaPacientesModificar = hospital.getListaPacientes();
                        System.out.println("Lista de pacientes:");

                        for (int i = 0; i < listaPacientesModificar.size(); i++) {
                            Paciente paciente = listaPacientesModificar.get(i);
                            System.out.println(i + ". DNI: " + paciente.getDNI() + ", Nombre: " + paciente.getNombre());
                        }

                        System.out.print("Ingrese el número del paciente a modificar: ");
                        int opcionModificar = scanner.nextInt();

                        if (opcionModificar >= 0 && opcionModificar < listaPacientesModificar.size()) {
                            Paciente pacienteSeleccionado = listaPacientesModificar.get(opcionModificar);

                            System.out.print("Ingrese nuevo DNI del paciente: ");
                            String nuevoDNI = scanner.next();
                            System.out.print("Ingrese nuevo nombre del paciente: ");
                            String nuevoNombre = scanner.next();
                            System.out.print("Ingrese nueva dirección del paciente: ");
                            String nuevaDireccion = scanner.next();
                            System.out.print("Ingrese nuevo peso del paciente: ");
                            double nuevoPeso = scanner.nextDouble();
                            System.out.print("Ingrese nueva temperatura del paciente: ");
                            double nuevaTemperatura = scanner.nextDouble();

                            Paciente nuevoPaciente = new Paciente(nuevoDNI, nuevoNombre, nuevaDireccion, nuevoPeso, nuevaTemperatura);

                            hospital.modificarPaciente(opcionModificar, nuevoPaciente);
                        } else {
                            System.out.println("Opción no válida. No se pudo modificar al paciente.");
                        }
                        break;
                 case 4:
                    double pesoMasRepetido = hospital.calcularPesoMasRepetido();
                    System.out.println("El peso que más se repite en la lista es: " + pesoMasRepetido);
                    break;
                case 5:
                    int cantidadPacientesPesoRepetido = hospital.contarPacientesConPesoRepetido();
                    System.out.println("La cantidad de pacientes con el peso que más se repite es: " + cantidadPacientesPesoRepetido);
                    break;
                case 6:
                    double[] pesosMayorYMenor = hospital.obtenerPesoMayorYMenor();
                    System.out.println("Peso mayor: " + pesosMayorYMenor[0]);
                    System.out.println("Peso menor: " + pesosMayorYMenor[1]);
                    break;
                case 7:
                    Map<String, Integer> cantidadPorRango = hospital.dividirRangoPesos();
                    System.out.println("Cantidad de personas en cada rango de pesos:");

                    for (Map.Entry<String, Integer> entry : cantidadPorRango.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue() + " personas");
                    }
                    break;
                case 8:
                    hospital.mostrarPacientesOrdenadosPorNombre();
                    break;

                case 0:
                    System.out.println("Retirarse del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
            }
        } while (opcion != 0);
    }
}