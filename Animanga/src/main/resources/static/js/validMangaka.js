document.getElementById("urlPortada").addEventListener("blur", comprobarUrl);
document.getElementById("nombre").addEventListener("blur", comprobarNombre);
document.getElementById("edad").addEventListener("blur", comprobarEdad);
document.getElementById("biografia").addEventListener("blur", comprobarBiografia);


function revisarFormulario() {
	let resultado = false;
	resultado = comprobarUrl() &&
		comprobarNombre() &&
		comprobarEdad() &&
		comprobarBiografia();
	formulario.enviar.className = resultado ? "btn btn-lg btn-outline-danger" : "btn btn-lg btn-outline-success";
	return resultado;

}
function comprobarUrl() {
	let campoUrl = document.getElementById("urlPortada");
	let resultado = /^(ftp|http|https):\/\/[^ "]+$/.test(formulario.urlPortada.value);
	cambiarApariencia(campoUrl, resultado);
	return resultado;
}

function comprobarNombre() {
	let campoNombre = document.getElementById("nombre");

	let resultado = formulario.nombre.value !== "" & isNaN(formulario.nombre.value);
	cambiarApariencia(campoNombre, resultado);
	return resultado;
}


function comprobarEdad() {
	let campoEdad = document.getElementById("edad");

	let resultado = formulario.edad.value >= 18;
	cambiarApariencia(campoEdad, resultado);
	return resultado;
}

function comprobarBiografia() {
	let campoBiografia = document.getElementById("biografia");
	let resultado = formulario.biografia.value !== "" && formulario.biografia.value.length >= 30 && formulario.biografia.value.length <= 200;
	cambiarApariencia(campoBiografia, resultado);
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