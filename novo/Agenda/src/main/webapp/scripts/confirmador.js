/**
 * Script para confirmar exclusão do contato
 */
 
 function confirmar(idcon) {
	let resposta = confirm("Deseja excluir esse contato?")
	
	if (resposta === true) {
		window.location.href = `delete?idcon=${idcon}`
	}
}
 
 