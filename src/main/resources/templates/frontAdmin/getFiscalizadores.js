function fazGet(url){
    let request = new XMLHttpRequest()
    request.open("GET", url, false)
    request.send()
    return request.responseText
}

function gerarDadosTabelaOrgaoFiscalizador(orgaoFiscalizador){
    console.log(orgaoFiscalizador)
    linha = document.createElement("tr")
    tdId = document.createElement("td")
    tdNome = document.createElement("td")
    tdDescricao = document.createElement("td")

    tdId.innerHTML = orgaoFiscalizador.id
    tdNome.innerHTML = orgaoFiscalizador.nome
    tdDescricao.innerHTML = orgaoFiscalizador.descricao

    linha.appendChild(tdId)
    linha.appendChild(tdNome)
    linha.appendChild(tdDescricao)

    return linha
}

function getFiscalizadores(){
    let data = fazGet("http://localhost:8080/orgaoFiscalizador/Lista")
    let orgaosFiscalizadores = JSON.parse(data)
    let tabela = document.getElementById("tableCorpoFiscalizadores")
    orgaosFiscalizadores.forEach(element =>{
        let linha = gerarDadosTabelaOrgaoFiscalizador(element)
        tabela.appendChild(linha)
    });
}

getFiscalizadores()