
package com.mycompany.lab010pooi2312051;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Hospital {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private Map<Paciente, Medico> asignaciones;
    

    public Hospital() {
        pacientes = new ArrayList<>();
        medicos = new ArrayList<>();
        asignaciones = new HashMap<>();
    }
    public List<Paciente> getListaPacientes() {
        return pacientes;
    }
    
    // Operación 1: Registrar los datos de los pacientes uno a uno
    public void registrarPaciente(Paciente paciente, Medico medico) {
        pacientes.add(paciente);
        asignaciones.put(paciente, medico);
        System.out.println("Paciente registrado exitosamente.");
    }

    // Operación 2: Eliminar los datos de un paciente dado su posición en la lista
    public void eliminarPaciente(int posicion) {
        if (posicion >= 0 && posicion < pacientes.size()) {
            Paciente pacienteEliminado = pacientes.remove(posicion);
            asignaciones.remove(pacienteEliminado);
            System.out.println("Paciente eliminado exitosamente.");
        } else {
            System.out.println("Posición no válida. No se pudo eliminar al paciente.");
        }
    }

    // Operación 3: Modificar los datos de un paciente de la lista
    public void modificarPaciente(int posicion, Paciente nuevoPaciente) {
        if (posicion >= 0 && posicion < pacientes.size()) {
            Paciente pacienteAntiguo = pacientes.get(posicion);
            pacientes.set(posicion, nuevoPaciente);
            asignaciones.put(nuevoPaciente, asignaciones.get(pacienteAntiguo));
            asignaciones.remove(pacienteAntiguo);
            System.out.println("Paciente modificado exitosamente.");
        } else {
            System.out.println("Posición no válida. No se pudo modificar al paciente.");
        }
    }

    // Operación 4: Mostrar el peso que más se repite en la lista
    public void mostrarPesoMasRepetido() {

    }
    public double calcularPesoMasRepetido() {
    Map<Double, Integer> frecuenciaPesos = new HashMap<>();

    for (Paciente paciente : pacientes) {
            double peso = paciente.getPeso();
            frecuenciaPesos.put(peso, frecuenciaPesos.getOrDefault(peso, 0) + 1);
        }

        double pesoMasRepetido = 0;
        int maxFrecuencia = 0;

        for (Map.Entry<Double, Integer> entry : frecuenciaPesos.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                pesoMasRepetido = entry.getKey();
            }
        }

        return pesoMasRepetido;
    }

    public int contarPacientesConPesoRepetido() {
        double pesoMasRepetido = calcularPesoMasRepetido();
        int cantidadPacientes = 0;

        for (Paciente paciente : pacientes) {
            if (paciente.getPeso() == pesoMasRepetido) {
                cantidadPacientes++;
            }
        }

        return cantidadPacientes;
    }

    public double[] obtenerPesoMayorYMenor() {
        if (pacientes.isEmpty()) {
            return new double[]{0.0, 0.0};
        }

        double pesoMayor = Double.MIN_VALUE;
        double pesoMenor = Double.MAX_VALUE;

        for (Paciente paciente : pacientes) {
            double peso = paciente.getPeso();
            if (peso > pesoMayor) {
                pesoMayor = peso;
            }
            if (peso < pesoMenor) {
                pesoMenor = peso;
            }
        }

        return new double[]{pesoMayor, pesoMenor};
    }
    // Operación 7: Dividir rango de pesos y mostrar cantidad de personas en cada rango
public Map<String, Integer> dividirRangoPesos() {
        Map<String, Integer> cantidadPorRango = new HashMap<>();

        if (pacientes.isEmpty()) {
            return cantidadPorRango;
        }

        double pesoMayor = Double.MIN_VALUE;
        double pesoMenor = Double.MAX_VALUE;

        for (Paciente paciente : pacientes) {
            double peso = paciente.getPeso();
            if (peso > pesoMayor) {
                pesoMayor = peso;
            }
            if (peso < pesoMenor) {
                pesoMenor = peso;
            }
        }

        double rango1 = pesoMenor + (pesoMayor - pesoMenor) / 4;
        double rango2 = rango1 + (pesoMayor - pesoMenor) / 4;
        double rango3 = rango2 + (pesoMayor - pesoMenor) / 4;

        int contadorRango1 = 0;
        int contadorRango2 = 0;
        int contadorRango3 = 0;
        int contadorRango4 = 0;

        for (Paciente paciente : pacientes) {
            double peso = paciente.getPeso();
            if (peso <= rango1) {
                contadorRango1++;
            } else if (peso <= rango2) {
                contadorRango2++;
            } else if (peso <= rango3) {
                contadorRango3++;
            } else {
                contadorRango4++;
            }
        }

        cantidadPorRango.put("40kg - " + (int) rango1 + "kg", contadorRango1);
        cantidadPorRango.put((int) rango1 + 1 + "kg - " + (int) rango2 + "kg", contadorRango2);
        cantidadPorRango.put((int) rango2 + 1 + "kg - " + (int) rango3 + "kg", contadorRango3);
        cantidadPorRango.put((int) rango3 + 1 + "kg - " + (int) pesoMayor + "kg", contadorRango4);

        return cantidadPorRango;
    }

    // Operación 8: Mostrar lista de pacientes ordenados por apellidos
public void mostrarPacientesOrdenadosPorNombre() {
        List<Paciente> listaPacientesOrdenadosPorNombre = new ArrayList<>(pacientes);

        Collections.sort(listaPacientesOrdenadosPorNombre, new Comparator<Paciente>() {
            @Override
            public int compare(Paciente paciente1, Paciente paciente2) {
                return paciente1.getNombre().compareToIgnoreCase(paciente2.getNombre());
            }
        });

        System.out.println("Lista de pacientes ordenados por nombre:");
        for (Paciente paciente : listaPacientesOrdenadosPorNombre) {
            System.out.println("DNI: " + paciente.getDNI() + ", Nombre: " + paciente.getNombre());
        }
    }
    public void indicarDoctorQueAtendio(Paciente paciente) {
        Medico medico = asignaciones.get(paciente);
        if (medico != null) {
            System.out.println("El paciente fue atendido por el doctor: " + medico.getNombre());
        } else {
            System.out.println("No se encontró información sobre el doctor que atendió a este paciente.");
        }
    }

    public void buscarDoctoresPorEspecialidad(String especialidad) {
        List<Medico> doctoresEnEspecialidad = new ArrayList<>();
        for (Medico medico : medicos) {
            if (medico.getEspecialidad().equalsIgnoreCase(especialidad)) {
                doctoresEnEspecialidad.add(medico);
            }
        }

        if (!doctoresEnEspecialidad.isEmpty()) {
            System.out.println("Doctores en la especialidad '" + especialidad + "':");
            for (Medico medico : doctoresEnEspecialidad) {
                System.out.println(medico.getNombre());
            }
        } else {
            System.out.println("No hay doctores en la especialidad '" + especialidad + "'.");
        }
        
}
    }