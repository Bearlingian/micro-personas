package com.pragma.powerup.usermicroservice.configuration;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final int MAYOR_EDAD = 18;
    public static final Long CLIENT_ROLE_ID = 4L;
    public static final Long EMPLOYEE_ROLE_ID = 3L;
    public static final Long PROVIDER_ROLE_ID = 2L;
    public static final Long ADMIN_ROLE_ID = 1L;
    public static final String ACCOUNT_CREATED_MESSAGE = "successfully created.";
    public static final String ACCOUNT_EXISTS_MESSAGE = "Documento ya existe";
    public static final String EXPRESSION_FORMAT_EMAIL = "^[A-Za-z0-9+_.]+@[a-zA-Z0-9.]+$";
    public static final String EXPRESSION_FORMAT_PHONE = "(?:^[+]|\\A)[0-9]*$";
    public static final String EXPRESSION_SOLO_NUMERO = "^[0-9]*$";
    public static final String EXPRESSION_FORMAT_DATE = "^(?:3[01]|[12][0-9]|0?[1-9])([\\-/.])(0?[1-9]|1[1-2])\\1\\d{4}$";//Formato dd/mm/aaaa
    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String WRONG_CREDENTIALS_MESSAGE = "Wrong credentials";
    public static final String SWAGGER_TITLE_MESSAGE = "User API Pragma Power Up";
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "User microservice";
    public static final String SWAGGER_VERSION_MESSAGE = "1.0.0";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "http://springdoc.org";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";

    public static final String PARAMETRO_NULO = "No se encontro parametro";
    public static final String PARAMETRO_VACIO = "Parametro vacio";

    public static final String EMAIL_FORMAT_EXCEPTION = "Email no cumple con estructura";

    public static final String FECHA_FORMAT_EXCEPTION = "Fecha no cumple con estructura";
    public static final String FECHA_MAYOR_EXCEPTION = "Fecha es superior a la fecha actual";
    public static final String PHONE_FORMAT_EXCEPTION = "Celular no cumple con estructura";
    public static final String MENOR_EDAD_EXCEPTION = "No puede ser menor de edad";
    public static final String DOUMENTO_NO_NUMERICO_EXCEPTION = "Documento de identidad no es numerico";

    public static final String HTTP_PETICION_EXCEPTION = "No se reconoce petición";
}
