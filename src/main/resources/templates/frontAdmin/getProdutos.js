function fazGet(url){
    let request = new XMLHttpRequest()
    request.open("GET", url, false)
    request.send()
    return request.responseText
}

function gerarDadosTabelaProduto(produto){
    console.log(produto)
    linha = document.createElement("tr")
    tdId = document.createElement("td")
    tdNome = document.createElement("td")
    tdDescricao = document.createElement("td")
    tdCenterId = document.createElement("center")
    tdCenterNome = document.createElement("center")
    tdCenterDescricao = document.createElement("center")

    tdId.appendChild(tdCenterId)
    tdNome.appendChild(tdCenterNome)
    tdDescricao.appendChild(tdCenterDescricao)

    tdCenterId.innerHTML = produto.id
    tdCenterNome.innerHTML = produto.nome
    tdCenterDescricao.innerHTML = produto.descricao

    linha.appendChild(tdId)
    linha.appendChild(tdNome)
    linha.appendChild(tdDescricao)

    return linha
}

function getProdutos(){
    let data = fazGet("http://localhost:8080/produto/Lista")
    let produtos = JSON.parse(data)
    let tabela = document.getElementById("tableCorpoProdutos")
    produtos.forEach(element =>{
        let linha = gerarDadosTabelaProduto(element)
        tabela.appendChild(linha)
    });
}

getProdutos()