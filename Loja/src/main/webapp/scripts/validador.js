/**
 * Script para validar campos obrigatórios
 */

function validar() {
	let marca = formContato.marca.value;
	let nome = formContato.nome.value;
	let quantidade = formContato.quantidade.value;
	let valor = formContato.valor.value;
	let vencimento = formContato.vencimento.value;

	if (marca === '') {
		alert('Campo Marca é obrigatório');
		formContato.marca.focus();

	} else if (nome === '') {
		alert('Campo Nome é obrigatório');
		formContato.nome.focus();

	} else if (quantidade === '') {
		alert('Campo Quantidade é obrigatório');
		formContato.quantidade.focus();

	} else if (valor === '') {
		alert('Campo Valor é obrigatório');
		formContato.valor.focus();

	} else if (vencimento === '') {
		alert('Campo vencimento é obrigatório');
		formContato.vencimento.focus();

	} else {
		document.forms["formContato"].submit();
	}
}