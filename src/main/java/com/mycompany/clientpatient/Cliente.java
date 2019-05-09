package com.mycompany.clientpatient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.util.Scanner;
import javax.ws.rs.core.MediaType;

public class Cliente {

    public static void main(String[] args) {
        try {

            Client client = Client.create();
            WebResource webResource = null;
            ClientResponse response = null;
            int opcion = -1;
            Scanner lectura = new Scanner(System.in);
            System.out.println("Bienvenido sistema gestion empleados");
         
            do {
                System.out.println("1. Listar 2. Crear. 3. Borrar. 4.  Salir");
                opcion = lectura.nextInt();
                switch (opcion) {
                    case 1:
                        webResource = client.resource("http://localhost:8080/myapp/patient");

                        response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

                        if (response.getStatus() != 200) {
                            throw new RuntimeException("Failed : HTTP error code : "
                                    + response.getStatus());
                        }

                        String output = response.getEntity(String.class);
                        System.out.println("Output from Server .... \n");
                        System.out.println(output);
                        break;

                    case 2:
                        webResource = client
                                .resource("http://localhost:8080/myapp/patient");

                        ObjectMapper mapper = new ObjectMapper();
                        Patient paciente = new Patient();
                        
                        System.out.println("Ingrese el patNo");
                        paciente.setPatNo(lectura.nextLine());
                        System.out.println("Ingrese el nombre");
                        paciente.setName(lectura.nextLine()); 
                        System.out.println("Ingrese el direccion");
                        paciente.setAddress(lectura.nextLine());
                        System.out.println("Ingrese el telefono");
                        paciente.setTelephone(lectura.nextLine());
                        System.out.println("Ingrese la fecha de nacimiento");
                        paciente.setDate_of_birth(lectura.nextLine());
                        System.out.println("Ingrese el contacto de emergencia");
                        paciente.setEmergency_contact(lectura.nextLine());
                        System.out.println("Ingrese el tipo de paciente");
                        paciente.setType_of_patient(Boolean.parseBoolean(lectura.nextLine()));
                        System.out.println("Ingrese el medicare");
                        paciente.setMedicare(Integer.parseInt(lectura.nextLine()));
                        System.out.println("Ingrese la compania aseguradora");
                        paciente.setIns_company(lectura.nextLine());
                        System.out.println("Ingrese el numero");
                        paciente.setIns_number(lectura.nextLine());
                        
                        String input = mapper.writeValueAsString(paciente);
                        //Luego se utilizara Jackson
                        //String input = "{\"empNo\":\"E11\",\"empName\":\"" + nombre + "\",\"position\":\"Salesman\"}";

                        response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);

                        if (response.getStatus() != 200) {
                            System.out.println(response.toString());
                            throw new RuntimeException("Failed : HTTP error code : "
                                    + response.getStatus());
                        }

                        output = response.getEntity(String.class);
                        System.out.println(output);
                        break;

                    case 3:
                        System.out.println("Indique el ID del empleado");
                        String id = lectura.next();
                        webResource = client.resource("http://localhost:8080/myapp/patient/" + id);

                        response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

                        if (response.getStatus() != 200) {
                            throw new RuntimeException("Failed : HTTP error code : "
                                    + response.getStatus());
                        }
                        output = response.getEntity(String.class);
                        System.out.println("Output from Server .... \n");
                        System.out.println(output);
                        break;
                    default:
                        System.out.println("Opcion invalida");

                }

            } while (opcion != 4);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
