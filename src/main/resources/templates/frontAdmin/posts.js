function fazPost(url, body){
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

function cadastrarOrgaoFiscalizador(){
    event.preventDefault()
    let url = "http://localhost:8080/cadastrarOrgaoFiscalizador"
    let Inome = document.getElementById("Inome").value
    let Idescricao = document.getElementById("Idescricao").value
    body={
        "nome": Inome,
        "descricao": Idescricao
    }
    fazPost(url,body)
}

function cadastrarOrgaoDonatario(){
    event.preventDefault()
    let url = "http://localhost:8080/cadastrarOrgaoDonatario"
    let Inome = document.getElementById("Inome").value
    let Iendereco = document.getElementById("Iendereco").value
    let Itelefone = document.getElementById("Itelefone").value
    let IhorarioDeFuncionamento = document.getElementById("IhorarioDeFuncionamento").value
    let Idescricao = document.getElementById("Idescricao").value
    body={
        "nome": Inome,
        "endereco": Iendereco,
        "telefone": Itelefone,
        "horarioDeFuncionamento": IhorarioDeFuncionamento,
        "descricao": Idescricao
    }
    fazPost(url,body)
}

function cadastrarProduto(){
    event.preventDefault()
    let url = "http://localhost:8080/cadastrarProduto"
    let Inome = document.getElementById("Inome").value
    let Idescricao = document.getElementById("Idescricao").value
    body={
        "nome": Inome,
        "descricao": Idescricao
    }
    fazPost(url,body)
}

function cadastroLote(){
    event.preventDefault()
    let url = "http://localhost:8080/cadastrarLote"
    let Iobservacao = document.getElementById("Iobservacao").value
    let select = document.getElementById("IorgaoDonatario")
    var Idonatario = select.options[select.selectedIndex].value
    let select2 = document.getElementById("IorgaoFiscalizador")
    var Ifiscalizador = select2.options[select2.selectedIndex].value

    let donatario = new Object()
    donatario.id = Idonatario

    let fiscalizador = new Object()
    fiscalizador.id = Ifiscalizador

    let request2 = new XMLHttpRequest()
    let url5 = "http://localhost:8080/produto/Lista"
    request2.open("GET", url5, false)
    request2.send()
    let produtos2 = JSON.parse(request2.responseText)

    var arrayDeProdutos = [];

    var checkboxes = document.getElementsByName('valoresProdutos')
        for (var i = 0; i < checkboxes.length; i++) {
            for(var b = 0; b < produtos2.length; b++){
                if (checkboxes[i].checked && checkboxes[i].value == produtos2[b].id) {
                    let produto = new Object()
                    produto.id = checkboxes[i].value
                    arrayDeProdutos.push(produto)
                }
            }
        }

    console.log(arrayDeProdutos)

    body={
        "observacao": Iobservacao,
        "orgaoDonatario": donatario,
        "orgaoFiscalizador": fiscalizador,
        "produtos": arrayDeProdutos
    }
    fazPost(url,body)
}