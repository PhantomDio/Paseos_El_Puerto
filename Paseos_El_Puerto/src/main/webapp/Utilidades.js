function validarFormulario() {
    var fechaInput = document.querySelector('input[name="fecha_nac"]');
    var fechaValue = fechaInput.value;
    var regex = /^\d{4}-\d{2}-\d{2}$/;

    if (!regex.test(fechaValue)) {
        alert("El formato de fecha debe ser (yyyy-mm-dd).");
        fechaInput.value = '';
        return false;
    }

    return true;
}

function validarFormulario2() {
    var fechaInputInicio = document.querySelector('input[name="fecha_inicio"]');
    var fechaInputFin = document.querySelector('input[name="fecha_fin"]');
    var fechaValueInicio = fechaInputInicio.value;
    var fechaValueFin = fechaInputFin.value;
    var regex = /^\d{4}-\d{2}-\d{2}$/;

    if (!regex.test(fechaValueInicio) || !regex.test(fechaValueFin)) {
        alert("El formato de fecha debe ser (yyyy-mm-dd).");
        fechaInputInicio.value = '';
        fechaInputFin.value = '';
        return false;
    }

    return true;
}
