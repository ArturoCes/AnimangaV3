document.getElementById("nombre").addEventListener("blur", comprobarNombre);
document.getElementById("descripcion").addEventListener("blur", comprobarDescripcion);


function revisarFormulario() {
	let resultado = false;
	resultado = 
		comprobarNombre() &&
		comprobarDescripcion();
	formulario.enviar.className = resultado ? "btn btn-lg btn-outline-danger" : "btn btn-lg btn-outline-success";
	return resultado;

}
function comprobarNombre() {
	let campoNombre = document.getElementById("nombre");

	let resultado = formulario.nombre.value !== "" & isNaN(formulario.nombre.value);
	cambiarApariencia(campoNombre, resultado);
	return resultado;
}

function comprobarDescripcion() {
	let campoDescripcion = document.getElementById("descripcion");
	let resultado = formulario.descripcion.value !== "" && formulario.descripcion.value.length >= 30 && formulario.descripcion.value.length <= 200;
	cambiarApariencia(campoDescripcion, resultado);
	return resultado;

}
function cambiarApariencia(campo, estado) {
	if (estado) {
		campo.classList.remove("border-danger");
		campo.classList.add("border-success");
		campo.parentNode.nextElementSibling.style.visibility = 'hidden';

	}
	else {
		campo.classList.remove("border-success");
		campo.classList.add("border-danger");
		campo.parentNode.nextElementSibling.style.visibility = 'visible';
	}

}