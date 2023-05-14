package com.pragma.powerup.usermicroservice.domain.usecase.provaider;

import com.pragma.powerup.usermicroservice.configuration.Constants;
import com.pragma.powerup.usermicroservice.configuration.MethodUtils;
import com.pragma.powerup.usermicroservice.domain.api.usecase.IProvaiderUseCasePort;
import com.pragma.powerup.usermicroservice.domain.exceptions.*;
import com.pragma.powerup.usermicroservice.domain.listdatafactory.ProvedorListdDataFactory;
import com.pragma.powerup.usermicroservice.domain.model.Persona;
import com.pragma.powerup.usermicroservice.domain.spi.IPersonaPersistenciaPort;


import java.util.Date;
import java.util.List;

public class ProvaiderUseCase implements IProvaiderUseCasePort {

    private final ProvedorListdDataFactory listdDataFactory;
    private final IPersonaPersistenciaPort personaPersistenciaPort;

    public ProvaiderUseCase(IPersonaPersistenciaPort personaPersistenciaPort) {
        this.personaPersistenciaPort = personaPersistenciaPort;
        this.listdDataFactory = new ProvedorListdDataFactory();
    }


    @Override
    public void validateCreatedFields(Persona persona) {

        validarCamposNulosVacios(persona);
        validarFormatoFecha(persona.getFechaNacimiento());
        validarFechaNoMayorActual(persona.getFechaNacimiento());
        ValidarEdad(persona.getFechaNacimiento());
        validarFormatoEmail(persona.getEmail());
        validarDocumentoSoloNumero(persona.getDocumentoIdentidad());
        validarFormatoTelefono(persona.getCelular());
        existeDocumentoIdentidad(persona.getDocumentoIdentidad());
    }

    private void validarCamposNulosVacios(Persona persona){

        List list = MethodUtils.isValidaParametrosRequeridosTodos(persona,listdDataFactory,null,null,null);

        if(list.size() != 0){
            throw new CamposNulosVacionException(list);
        }

    }

    private void validarFormatoEmail(String email){
        Boolean saber = MethodUtils.validateEmailStructure(email);
        if(saber!= null && saber==false){
            throw new EmailFormatException();
        }
    }

    private void validarFormatoFecha(String fecha){
        Boolean saber = MethodUtils.validateFormatDate(fecha);
        if(saber!= null && saber==false){
            throw new FechaFormatException();
        }
    }

    private void validarFormatoTelefono(String telefono){
        Boolean saber = MethodUtils.validateFormatPhone(telefono);
        if(saber!= null && saber==false){
            throw new PhoneFormatException();
        }

        if(telefono.length() > 13){
            throw new PhoneFormatException();
        }
    }

    private void validarDocumentoSoloNumero(String documento){
        Boolean saber = MethodUtils.validarSoloNumeros(documento);
        if(saber!= null && saber==false){
            throw new DocumentoIdentidadException(Constants.DOUMENTO_NO_NUMERICO_EXCEPTION);
        }
    }

    private void validarFechaNoMayorActual(String fecha){
        Date fechaactual = new Date(System.currentTimeMillis());
        Date fechaDate = MethodUtils.getDate(fecha);  //String a date
        //comprueba si es que inicio esta después que fecha actual
        if(MethodUtils.EliminarTiempoDate(fechaDate).after(MethodUtils.EliminarTiempoDate(fechaactual))){
            throw new FechaFormatException(Constants.FECHA_MAYOR_EXCEPTION);
        }
    }

    private void ValidarEdad(String fecha){
        Date fechaactual = new Date(System.currentTimeMillis());
        Date fechaDate = MethodUtils.getDate(fecha);  //String a date

        int edad = MethodUtils.calcularEdad(MethodUtils.EliminarTiempoDate(fechaDate), MethodUtils.EliminarTiempoDate(fechaactual));

        if(edad < Constants.MAYOR_EDAD){
            throw new FechaFormatException(Constants.MENOR_EDAD_EXCEPTION);
        }
    }

    private void existeDocumentoIdentidad(String documento){
        Boolean existe = personaPersistenciaPort.existsDocumentoIdentidad(documento);
        if(existe){
            throw new GeneralMessageException(Constants.ACCOUNT_EXISTS_MESSAGE);
        }
    }

}
