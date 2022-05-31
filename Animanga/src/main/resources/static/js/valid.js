document.getElementById("urlPortada").addEventListener("blur",comprobarUrl);
document.getElementById("nombre").addEventListener("blur",comprobarNombre);
document.getElementById("descripcion").addEventListener("blur",comprobarDescripcion);
document.getElementById("editorial").addEventListener("blur",comprobarEditorial);
document.getElementById("numPags").addEventListener("blur",comprobarNumPags);
document.getElementById("precio").addEventListener("blur",comprobarPrecio);
document.getElementById("isbn10").addEventListener("blur",comprobarIsbn10);
document.getElementById("pesoProducto").addEventListener("blur",comprobarPesoProducto);



function revisarFormulario() {
	let resultado = false;
	resultado = comprobarUrl()&&
				comprobarNombre()&&
				comprobarDescripcion()&&
				comprobarEditorial()&&
				comprobarNumPags()&&
				comprobarPrecio()&&
				comprobarIsbn10()&&
				comprobarPesoProducto();
	formulario.enviar.className = resultado ? "btn btn-lg btn-outline-danger" : "btn btn-lg btn-outline-success";
	return resultado;

}

function comprobarUrl() {
	let campoUrl = document.getElementById("urlPortada");
	let resultado = /^(ftp|http|https):\/\/[^ "]+$/.test(formulario.urlPortada.value);	
	cambiarApariencia(campoUrl,resultado);
	return resultado;
}

function comprobarNombre (){
	let campoNombre= document.getElementById("nombre");
	
	let resultado = formulario.nombre.value !== "";
	cambiarApariencia(campoNombre,resultado);
	return resultado;
}
function comprobarDescripcion (){
	let campoDescripcion= document.getElementById("descripcion");
	let resultado = formulario.descripcion.value !==""&&formulario.descripcion.value.length>=30&&formulario.descripcion.value.length<=200;
	cambiarApariencia(campoDescripcion,resultado);
	return resultado;
	
}
function comprobarEditorial(){
	let campoEditorial = document.getElementById("editorial");
	let resultado= formulario.editorial.value !=="" && isNaN(formulario.editorial.value);
	cambiarApariencia(campoEditorial,resultado);
	return resultado;
}

function comprobarNumPags(){
	let campoNumPags= document.getElementById("numPags");
	
	let resultado = formulario.numPags.value > 5;
	cambiarApariencia(campoNumPags,resultado);
	return resultado;
}

function comprobarPrecio(){
	let campoPrecio=document.getElementById("precio");
	let resultado = formulario.precio.value>1;
	cambiarApariencia(campoPrecio,resultado);
	return resultado;
}
function comprobarIsbn10(){
	let campoIsbn10 = document.getElementById("isbn10");
	let resultado = /^(?=(?:\D*\d){10}(?:(?:\D*\d){3})?$)[\d-]+$/.test(formulario.isbn10.value);
	cambiarApariencia(campoIsbn10,resultado);
	return resultado;
	
}

function comprobarPesoProducto(){
	let campoPesoProducto=document.getElementById("pesoProducto");
	let variable = 2;
	let resultado = formulario.pesoProducto.value>=variable&&!isNaN(formulario.pesoProducto.value);
	cambiarApariencia(campoPesoProducto,resultado);
	return resultado;
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