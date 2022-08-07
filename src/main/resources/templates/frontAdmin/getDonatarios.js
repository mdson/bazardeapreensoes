function fazGet(url){
    let request = new XMLHttpRequest()
    request.open("GET", url, false)
    request.send()
    return request.responseText
}

function gerarDadosTabelaOrgaoDonatario(orgaoDonatario){
    console.log(orgaoDonatario)
    linha = document.createElement("tr")
    tdId = document.createElement("td")
    tdNome = document.createElement("td")
    tdEndereco = document.createElement("td")
    tdTelefone = document.createElement("td")
    tdHorarioDeFuncionamento = document.createElement("td")
    tdDescricao = document.createElement("td")

    tdId.innerHTML = orgaoDonatario.id
    tdNome.innerHTML = orgaoDonatario.nome
    tdEndereco.innerHTML = orgaoDonatario.endereco
    tdTelefone.innerHTML = orgaoDonatario.telefone
    tdHorarioDeFuncionamento.innerHTML = orgaoDonatario.horarioDeFuncionamento
    tdDescricao.innerHTML = orgaoDonatario.descricao

    linha.appendChild(tdId)
    linha.appendChild(tdNome)
    linha.appendChild(tdEndereco)
    linha.appendChild(tdTelefone)
    linha.appendChild(tdHorarioDeFuncionamento)
    linha.appendChild(tdDescricao)

    return linha
}

function getDonatarios(){
    let data = fazGet("http://localhost:8080/orgaoDonatario/Lista")
    let orgaosDonatarios = JSON.parse(data)
    let tabela = document.getElementById("tableCorpoDonatarios")
    orgaosDonatarios.forEach(element =>{
        let linha = gerarDadosTabelaOrgaoDonatario(element)
        tabela.appendChild(linha)
    });
}

getDonatarios()