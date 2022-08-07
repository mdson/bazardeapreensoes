function fazGet(url){
    let requisicao = new XMLHttpRequest()
    requisicao.open("GET", url, false)
    requisicao.setRequestHeader("Content-Type", "application/json")
    requisicao.send()
    return requisicao.responseText
}

function gerarDadosTabelaLote(lote){
    console.log(lote)
    linha = document.createElement("tr")
    tdId = document.createElement("td")
    tdDataEntrega = document.createElement("td")
    tdObservacao = document.createElement("td")
    tdListaDeProdutos = document.createElement("td")
    tdOrgaoDonatario = document.createElement("td")
    tdOrgaoFiscalizador = document.createElement("td")

    tdId.innerHTML = lote.id
    tdDataEntrega.innerHTML = lote.dataEntrega
    tdObservacao.innerHTML = lote.observacao
    tdListaDeProdutos.innerHTML = lote.produtos.nome
    tdOrgaoDonatario.innerHTML = lote.orgaoDonatario.nome
    tdOrgaoFiscalizador.innerHTML = lote.orgaoFiscalizador.nome

    linha.appendChild(tdId)
    linha.appendChild(tdDataEntrega)
    linha.appendChild(tdObservacao)
    linha.appendChild(tdListaDeProdutos)
    linha.appendChild(tdOrgaoDonatario)
    linha.appendChild(tdOrgaoFiscalizador)

    return linha
}

function reqqLotes(){
    let data = fazGet("localhost:8080/lote/Lista")
    let lotes = JSON.parse(data)
    let tabela = document.getElementById("tableCorpoLotes")
    lotes.forEach(element =>{
        let linha = gerarDadosTabelaLote(element)
        tabela.appendChild(linha)
    });
}


function teste() {
    const url = "localhost:8080/lote/Lista";
    fetch(url)
        .then((resp) => resp.json())
        .then(function (data) {
            let dados = data.results;
            let tabela = document.getElementById("tableCorpoLotes")
            return dados.map(function (dado) {
                let linha = gerarDadosTabelaLote(dado)
                tabela.appendChild(linha)
            })
        })
        .catch(function (error) {
            console.log(error);
        });
}

reqqLotes();