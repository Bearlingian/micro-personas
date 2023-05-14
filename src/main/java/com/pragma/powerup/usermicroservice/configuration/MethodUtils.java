package com.pragma.powerup.usermicroservice.configuration;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodUtils {

    private static String[] formatDate={"dd-MM-yyyy","dd/MM/yyyy"};

    public static Boolean validarSoloNumeros(String numero){
        if(numero==null){return null;}
        Pattern pattern = Pattern.compile(Constants.EXPRESSION_SOLO_NUMERO);
        Matcher mather = pattern.matcher(numero);
        if (mather.matches()) {return true;}

        return false;
    }

    public static Boolean validateEmailStructure(String email){
        if(email==null){return null;}
        Pattern pattern = Pattern.compile(Constants.EXPRESSION_FORMAT_EMAIL);
        Matcher mather = pattern.matcher(email);
        if (mather.matches()) {return true;}

        return false;
    }

    public static Boolean validateFormatDateExpression(String fecha){
        if(fecha==null){return null;}
        Pattern pattern = Pattern.compile(Constants.EXPRESSION_FORMAT_DATE);
        Matcher mather = pattern.matcher(fecha);
        if (mather.matches()) {return true;}
        return false;
    }

    public static Boolean validateFormatDate(String fecha) {

        for (int i = 0; i < formatDate.length + 1; i++) {
            try {
                SimpleDateFormat formatoFecha = new SimpleDateFormat(formatDate[i], Locale.ENGLISH);
                formatoFecha.setLenient(false);
                formatoFecha.parse(fecha);
                return true;
            } catch (Exception e) {}
        }
        return false;
    }

    public static Date getDate(String fecha) {

        Date date = null;
        for (int i = 0; i < formatDate.length + 1; i++) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatDate[i],Locale.ENGLISH);
                date = simpleDateFormat.parse(fecha);
                break;
            } catch (Exception e) {}
        }

        return date;
    }

    public static Date EliminarTiempoDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static int calcularEdad(Date fechaDeNacimiento, Date fecha) {
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(fechaDeNacimiento));
        int d2 = Integer.parseInt(formatter.format(fecha));
        int edad= (d2 - d1) / 10000;
        return edad;
    }
    public static Boolean validateFormatPhone(String phone){
        if(phone==null){return null;}

        Pattern pat = Pattern.compile(Constants.EXPRESSION_FORMAT_PHONE);
        Matcher mat = pat.matcher(phone);
        if(mat.matches()){
            return true;
        }
        return false;
    }

    public static boolean isNull(Object objeto) {

        if(objeto != null) {
            return false;
        }

        return true;
    }

    public static boolean isVacio(Object objeto) {

        if(!isNull(objeto) && objeto.toString().trim().length()!=0) {
            return false;
        }

        return true;
    }

    private static boolean saberTipoParametro(Object parametro, Integer evento, Integer posicion) {

        if(parametro != null) {
            switch (evento) {
                case 1: // CLASE

                    if(!parametro.getClass().getSimpleName().equals("String") && !parametro.getClass().getSimpleName().equals("Integer")
                            && !parametro.getClass().getSimpleName().equals("Boolean") && !parametro.getClass().getSimpleName().equals("Long")
                            && !parametro.getClass().getSimpleName().equals("BigDecimal") && !parametro.getClass().getSimpleName().equals("Date")
                            && !parametro.getClass().getSimpleName().equals("Byte") && !parametro.getClass().getSimpleName().equals("Character")
                            && !parametro.getClass().getSimpleName().equals("Short") && !parametro.getClass().getSimpleName().equals("Float")
                            && !parametro.getClass().getSimpleName().equals("Double") && !parametro.getClass().getSimpleName().equals("ArrayList")
                            && !parametro.getClass().getSimpleName().equals("String[]") ){
                        return true;
                    }

                    break;
                case 2: // ArrayList GENERAL
                    if(parametro.getClass().getSimpleName().equals("ArrayList")){
                        return true;
                    }
                    break;
                case 3: // ArrayList Tipos
                    if(!((java.util.ArrayList) parametro).get(posicion).getClass().getSimpleName().equals("String")
                            && !((java.util.ArrayList) parametro).get(posicion).getClass().getSimpleName().equals("Integer")
                            && !((java.util.ArrayList) parametro).get(posicion).getClass().getSimpleName().equals("Boolean")
                            && !((java.util.ArrayList) parametro).get(posicion).getClass().getSimpleName().equals("Long")
                            && !((java.util.ArrayList) parametro).get(posicion).getClass().getSimpleName().equals("BigDecimal")
                            && !((java.util.ArrayList) parametro).get(posicion).getClass().getSimpleName().equals("Date")
                            && !((java.util.ArrayList) parametro).get(posicion).getClass().getSimpleName().equals("Byte")
                            && !((java.util.ArrayList) parametro).get(posicion).getClass().getSimpleName().equals("Character")
                            && !((java.util.ArrayList) parametro).get(posicion).getClass().getSimpleName().equals("Short")
                            && !((java.util.ArrayList) parametro).get(posicion).getClass().getSimpleName().equals("Float")
                            && !((java.util.ArrayList) parametro).get(posicion).getClass().getSimpleName().equals("Double")
                            && !((java.util.ArrayList) parametro).get(posicion).getClass().getSimpleName().equals("ArrayList")){
                        return true;
                    }
                    break;
                case 4: // Array
                    if (parametro.getClass().getSimpleName().equals("String[]")){
                        return true;
                    }
                default:
                    break;
            }
        }


        return false;
    }

    public static boolean buscarVariableRequerida(String clase, String parametro, Object classListData){

        Class<? extends Object> ClaseCliente = classListData.getClass();

        Field VariableArray = null;
        Object valorVariable = null;

        try {

            VariableArray = ClaseCliente.getField(clase);

            VariableArray.setAccessible(true);
            valorVariable = VariableArray.get(VariableArray);
            String[] array = (String[])valorVariable;
            for (int i = 0; i < array.length; i++) {
                if(array[i].equals(parametro)){
                    return true;
                }
            }

        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {}

        return false;
    }

    public static List<String> isValidaParametrosRequeridosTodos(Object clase, Object classListData, List<String> listMensaje, Integer evento, Integer posicion){

        if(listMensaje == null) {
            listMensaje = new ArrayList<String>();
        }

        if (clase != null) {

            Class<? extends Object> objetoDeClassConInfoDeMiClase = null;
            Field[] todasLasVariablesDeclaradas = null;

            if(evento == null || (evento != null && evento == 3 ) ){ // Clases que no se envia evento
                objetoDeClassConInfoDeMiClase = clase.getClass();
                todasLasVariablesDeclaradas = objetoDeClassConInfoDeMiClase.getDeclaredFields();

                try { // para clases que tienen clases extendidas
                    listMensaje = isValidaParametrosRequeridosTodos(clase, classListData, listMensaje, 2,posicion);
                } catch (Exception e) {}

            }else{
                if( (evento != null && evento == 2) ){
                    objetoDeClassConInfoDeMiClase = (Class<? extends Object>) clase.getClass().getGenericSuperclass();
                    todasLasVariablesDeclaradas = objetoDeClassConInfoDeMiClase.getDeclaredFields();
                }
            }

            String nombreClase = clase.getClass().getSimpleName();

            for (int i = 0; i < todasLasVariablesDeclaradas.length; i++) {

                try {

                    Field variable = todasLasVariablesDeclaradas[i]; // INFORMACION DEL PARAMETRO

                    String nombreVariable = variable.getName();

                    if(!nombreVariable.equals("serialVersionUID")) {

                        variable.setAccessible(true); // TENER ACESSO AL PARAMETRO
                        Object valorVariable = variable.get(clase); // VALOR PARAMETRO

                        boolean requerida = buscarVariableRequerida(nombreClase,nombreVariable,classListData);

                        if(saberTipoParametro(valorVariable, 1, null)) {// SI ES UNA CLASE
                            listMensaje = isValidaParametrosRequeridosTodos(valorVariable, classListData, listMensaje, null,posicion);
                        }

                        if(saberTipoParametro(valorVariable, 2, null)) { // SI ES UN ARRAYLIST GENERAL
                            int size =  ((java.util.ArrayList) valorVariable).size();

                            for (int j = 0; j < size; j++) {
                                if(saberTipoParametro(valorVariable, 3, j)) { // SI ES UN ARRAYLIST TIPO
                                    listMensaje = isValidaParametrosRequeridosTodos(((java.util.ArrayList) valorVariable).get(j), classListData, listMensaje, 3, j);
                                }
                            }
                        }

                        if(requerida){

                            if(isNull(valorVariable)){
                                listMensaje.add(Constants.PARAMETRO_NULO+" "+nombreVariable+(posicion != null ? "["+posicion+"]" : ""));
                                continue;
                            }

                            if(saberTipoParametro(valorVariable, 2, null)) {
                                if(((java.util.ArrayList) valorVariable).size() == 0) {
                                    listMensaje.add(Constants.PARAMETRO_VACIO+" "+nombreVariable+(posicion != null ? "["+posicion+"]" : ""));
                                    continue;
                                }
                            }

                            if(saberTipoParametro(valorVariable, 4, null)) {
                                String[] list = (String[]) valorVariable;
                                Integer count = 0;
                                for(String campo : list) {
                                    if(isVacio(campo)){
                                        listMensaje.add(Constants.PARAMETRO_VACIO+" "+nombreVariable+(count != null ? "["+count+"]" : ""));
                                    }
                                    count++;
                                }

                            }

                            if(isVacio(valorVariable)){
                                listMensaje.add(Constants.PARAMETRO_VACIO+" "+nombreVariable+(posicion != null ? "["+posicion+"]" : ""));
                                continue;
                            }

                        }
                    }


                } catch (IllegalArgumentException | IllegalAccessException  e) {}
            }

        }

        return listMensaje;
    }

}
