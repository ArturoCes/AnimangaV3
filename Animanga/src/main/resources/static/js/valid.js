document.getElementById("urlPortada").addEventListener("mouseout",comprobarUrl());






function revisarFormulario() {

	let resultado = false;

	resultado = comprobarUrl() 

	formulario.enviar.className = resultado ? "btn btn success mb-2" : "btn btn danger mb-2";

	return resultado;

}

function comprobarUrl() {
	let campoUrl = document.getElementById("urlPortada");
	let valid = /^(ftp|http|https):\/\/[^ "]+$/.test(formulario.urlPortada.value);
		

	
	cambiarApariencia(campoUrl,valid);
}



function cambiarApariencia(campo, estado){	
	if(estado){
		campo.classList.remove("border-danger");
		campo.classList.add("border-success");
		campo.parentNode.nextElementSibling.style.visibility = 'hidden';
		
	}
	else{
		campo.classList.remove("border-success");
		campo.classList.add("border-danger");
		campo.parentNode.nextElementSibling.style.visibility = 'visible';
	}
		
}