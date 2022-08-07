function fazPost(url, body) {
    console.log("Body=", body)
    let request = new XMLHttpRequest()
    request.open("POST", url, true)
    request.setRequestHeader("Content-type", "application/json")
    request.send(JSON.stringify(body))

    request.onload = function() {
        console.log(this.responseText)
    }

    return request.responseText
}


function cadastrarFiscalizador() {
    event.preventDefault()
    let url = "http://127.0.0.1:8080/fiscalizador"
    let nome = document.getElementById("nome").value
    let descricao = document.getElementById("descricao").value

    body = {
        "nome": nome,
        "descricao": descricao
    }

    fazPost(url, body)
}

function cadastrarDonatario() {
    event.preventDefault()
    let url = "http://127.0.0.1:8080/donatario"
    let nome = document.getElementById("nome").value
    let endereco = document.getElementById("endereco").value
    let telefone = document.getElementById("telefone").value
    let descricao = document.getElementById("descricao").value

    body = {
        "nome": nome,
        "descricao": descricao,
        "endereco": endereco,
        "telefone": telefone
    }

    fazPost(url, body)
}

function cadastrarProduto() {
    event.preventDefault()
    let url = "http://127.0.0.1:8080/produto"
    let nome = document.getElementById("nome").value
    let descricao = document.getElementById("descricao").value
    let quantidade = document.getElementById("quantidade").value

    body = {
        "nome": nome,
        "descricao": descricao,
        "quantidade": quantidade
    }

    fazPost(url, body)
}

function cadastrarLote() {
    event.preventDefault()
    let url = "http://127.0.0.1:8080/lote"
    let nome = document.getElementById("nome").value
    let dataEntrega = document.getElementById("dataEntrega").value
    let observacao = document.getElementById("observacao").value
    let idFiscalizador = document.getElementById("idFiscalizador").value
    let idDonatario = document.getElementById("idDonatario").value

    let fiscalizador = new Object();
    fiscalizador.id = idFiscalizador;

    let donatario = new Object();
    donatario.id = idDonatario;

    body = {
        "nome": nome,
        "dataEntrega": dataEntrega,
        "observacao": observacao,
        "fiscalizador": fiscalizador,
        "donatario": donatario
    }

    fazPost(url, body)
}