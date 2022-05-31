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
	formulario.enviar.className = resultado ? "btn btn success mb-2" : "btn btn danger mb-2";
	return resultado;

}

function comprobarUrl() {
	let campoUrl = document.getElementById("urlPortada");
	let valid = /^(ftp|http|https):\/\/[^ "]+$/.test(formulario.urlPortada.value);	
	cambiarApariencia(campoUrl,valid);
}

function comprobarNombre (){
	let campoNombre= document.getElementById("nombre");
	
	let valid = formulario.nombre.value !== "";
	cambiarApariencia(campoNombre,valid);
}
function comprobarDescripcion (){
	let campoDescripcion= document.getElementById("descripcion");
	
	let valid = formulario.descripcion.value !=="";
	cambiarApariencia(campoDescripcion,valid);
	
}
function comprobarEditorial(){
	let campoEditorial = document.getElementById("editorial");
	let valid= formulario.editorial.value !=="" && isNaN(formulario.editorial.value);
	cambiarApariencia(campoEditorial,valid);
}

function comprobarNumPags(){
	let campoNumPags= document.getElementById("numPags");
	
	let valid = formulario.numPags.value > 5;
	cambiarApariencia(campoNumPags,valid)
}

function comprobarPrecio(){
	let campoPrecio=document.getElementById("precio");
	let valid = formulario.precio.value>1;
	cambiarApariencia(campoPrecio,valid);
}
function comprobarIsbn10(){
	let campoIsbn10 = document.getElementById("Isbn10");
	let valid = /^(?=(?:\D*\d){10}(?:(?:\D*\d){3})?$)[\d-]+$/.test(formulario.isbn10.value);
	cambiarApariencia(campoIsbn10,valid);
	
}

function comprobarPesoProducto(){
	let campoPesoProducto=document.getElementById("pesoProducto");
	
	let valid = formulario.pesoProducto.value>0.5;
	cambiarApariencia(campoPesoProducto,valid);
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